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

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.salesforce.automation.RegressionTests;
import org.mule.modules.salesforce.automation.SalesforceTestParent;
import org.mule.modules.tests.ConnectorTestUtils;
import org.mule.util.IOUtils;

import com.sforce.async.BatchInfo;
import com.sforce.async.JobInfo;



public class BatchResultStreamTestCases extends SalesforceTestParent {

	@Before
	public void setUp() throws Exception {

		loadTestRunMessage("batchResultStreamTestData");
		
		JobInfo jobInfo = runFlowAndGetPayload("create-job");
			
		upsertOnTestRunMessage("jobId", jobInfo.getId());
		upsertOnTestRunMessage("jobInfoRef", jobInfo);
		
	}
	
	@After
	public void tearDown() throws Exception {
		
		runFlowAndGetPayload("delete-from-message");
		runFlowAndGetPayload("close-job");

	}
	
    @Category({RegressionTests.class})
	@Test
	public void testBatchResultStream() {
    	
    	BatchInfo batchInfo;
    	
		String[] results;
		String id;
		String success;
		boolean isSuccess = true;

		List<String> sObjectsIds = new ArrayList<String>();
		
		try {
  
			
			batchInfo = runFlowAndGetPayload("create-batch");
			
			do {
				
				Thread.sleep(BATCH_PROCESSING_DELAY);
				upsertOnTestRunMessage("batchInfoRef", batchInfo);
				batchInfo = runFlowAndGetPayload("batch-info");

			} while (batchInfo.getState().equals(com.sforce.async.BatchStateEnum.InProgress) || batchInfo.getState().equals(com.sforce.async.BatchStateEnum.Queued));
	
			assertTrue(batchInfo.getState().equals(com.sforce.async.BatchStateEnum.Completed));
			
			String operationResponse = IOUtils.toString((InputStream) runFlowAndGetPayload("batch-result-stream"));
			
			results = StringUtils.substringsBetween(operationResponse,"<result>","</result>");
			for (int index=0; index<results.length; index++) {
				
				id = StringUtils.substringBetween(results[index],"<id>","</id>");
				success = StringUtils.substringBetween(results[index],"<success>","</success>");
				
				if (success.equals("true")) {
					sObjectsIds.add(id);
				} else {
					isSuccess = false;	
				}
				
			}
			
			upsertOnTestRunMessage("idsToDeleteFromMessage", sObjectsIds);
			
			assertTrue(isSuccess);
			
		} catch (Exception e) {
			fail(ConnectorTestUtils.getStackTrace(e));
		}
    	     
	}

}