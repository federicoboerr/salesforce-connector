/**
 * Mule Salesforce Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

/**
 * This file was automatically generated by the Mule Development Kit
 */
package org.mule.modules.salesforce;

import org.junit.Ignore;
import org.junit.Test;
import org.mule.construct.Flow;
import org.mule.tck.AbstractMuleTestCase;
import org.mule.tck.FunctionalTestCase;

/**
 * Verifies that the connector produces a valid xsd.
 */
@Ignore
public class SalesforceNamespaceHandlerTest extends FunctionalTestCase {
    @Override
    protected String getConfigResources() {
        return "mule-config.xml";
    }

    @Test
    public void testFlow() throws Exception {
        //Flow flow = lookupFlowConstruct("Create");
        //MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
    }

    /**
     * Retrieve a flow by name from the registry
     *
     * @param name Name of the flow to retrieve
     */
    protected Flow lookupFlowConstruct(String name) {
        return AbstractMuleTestCase.muleContext.getRegistry().lookupObject(name);
    }
}
