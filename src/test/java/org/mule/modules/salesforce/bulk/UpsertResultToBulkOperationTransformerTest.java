package org.mule.modules.salesforce.bulk;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mule.api.transformer.DiscoverableTransformer;
import org.mule.common.bulk.BulkItem;
import org.mule.common.bulk.BulkOperationResult;
import org.mule.modules.salesforce.SalesforceUtils;
import org.mule.modules.salesforce.exception.SalesforceBulkException;

import com.sforce.soap.partner.Error;
import com.sforce.soap.partner.UpsertResult;
import com.sforce.soap.partner.sobject.SObject;

public class UpsertResultToBulkOperationTransformerTest extends AbstractBulkOperationTransformerTest {

	@Override
	protected Class<?> getSourceClass() {
		return UpsertResult.class;
	}

	@Override
	protected Class<? extends DiscoverableTransformer> getTransformerClass() {
		return UpsertResultToBulkOperationTransformer.class;
	}
	
	@Test
    public void testUpsert() throws Exception {
        final int objectCount = 10;
        final int failedIndex = 5;
        final int updatedIndex = 7;
        Error error = null;
        
        SObject[] sObjects = new SObject[objectCount];
        UpsertResult[] results = new UpsertResult[objectCount];
        
        for (int i = 0; i < objectCount; i++) {
        	sObjects[i] = Mockito.mock(SObject.class);
            UpsertResult result = Mockito.mock(UpsertResult.class);
        	
        	if (i == failedIndex) {
        		Mockito.when(result.isSuccess()).thenReturn(false);
        		error = Mockito.mock(Error.class);
        		Mockito.when(result.getErrors()).thenReturn(new Error[]{error});
        	} else {
        		Mockito.when(result.isSuccess()).thenReturn(true);
        		Mockito.when(result.isCreated()).thenReturn(i != updatedIndex);
        	}
        	
        	results[i] = result;
        }

        List<UpsertResult> upsertResults = SalesforceUtils.enrichWithPayload(sObjects, results);

		@SuppressWarnings("unchecked")
		BulkOperationResult<SObject> result = (BulkOperationResult<SObject>) this.getTransformer().transform(upsertResults);
        Assert.assertNotNull(result);
        Assert.assertFalse(result.isSuccessful());
        
        for (int i = 0; i < objectCount; i++) {
        	BulkItem<SObject> item = result.getItems().get(i);
        	Assert.assertSame(sObjects[i], item.getPayload());
        	
        	if (i == failedIndex) {
        		Assert.assertFalse(item.isSuccessful());
        		Exception e = item.getException();
        		Assert.assertTrue(e instanceof SalesforceBulkException);
        		SalesforceBulkException sbe = (SalesforceBulkException) e;
        		Assert.assertEquals(1, sbe.getErrors().size());
        		Assert.assertSame(error, sbe.getErrors().get(0));
        	} else {
        		Assert.assertTrue(item.isSuccessful());
        		Assert.assertEquals(i != updatedIndex ? "Created" : "Updated", item.getMessage());
        	}
        }
    }

}
