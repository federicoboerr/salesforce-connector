/**
 * Mule Salesforce Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.salesforce.automation.testcases;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.salesforce.automation.RegressionTests;
import org.mule.modules.salesforce.automation.SalesforceTestParent;
import org.mule.modules.tests.ConnectorTestUtils;

import com.sforce.soap.partner.SaveResult;


public class QueryAllTestCases extends SalesforceTestParent {

	@Before
	public void setUp() throws Exception {
    	
    	List<String> sObjectsIds = new ArrayList<String>();

		loadTestRunMessage("queryAllTestData");

        List<SaveResult> saveResultsList = runFlowAndGetPayload("create-from-message");
        Iterator<SaveResult> saveResultsIter = saveResultsList.iterator();  

        List<Map<String,Object>> sObjects = getTestRunMessageValue("sObjectFieldMappingsFromMessage");
		Iterator<Map<String,Object>> sObjectsIterator = sObjects.iterator();
        
		while (saveResultsIter.hasNext()) {
			
			SaveResult saveResult = saveResultsIter.next();
			Map<String,Object> sObject = sObjectsIterator.next();
			sObjectsIds.add(saveResult.getId());
	        sObject.put("Id", saveResult.getId());
			
		}

		upsertOnTestRunMessage("idsToDeleteFromMessage", sObjectsIds);
		
		runFlowAndGetPayload("delete-from-message");
     
	}
	
	@Category({RegressionTests.class})
	@Test
	public void testQueryAll() {
		
		List<String> queriedRecordIds = getTestRunMessageValue("idsToDeleteFromMessage");
		List<String> returnedSObjectsIds = new ArrayList<String>();
		
		try {

            org.mule.streaming.ConsumerIterator<Map<String, Object>> records =  runFlowAndGetPayload("query-all");

			while(records.hasNext()) {
                returnedSObjectsIds.add(records.next().get("Id").toString());
            }
			
			assertTrue(returnedSObjectsIds.size() > 0);

            for (String queriedRecordId : queriedRecordIds) {
                assertTrue(returnedSObjectsIds.contains(queriedRecordId));
            }
		
		} catch (Exception e) {
			fail(ConnectorTestUtils.getStackTrace(e));
		}
	}

}