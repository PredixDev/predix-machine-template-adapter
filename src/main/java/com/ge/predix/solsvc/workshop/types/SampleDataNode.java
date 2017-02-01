/*
 * Copyright (c) 2014 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

package com.ge.predix.solsvc.workshop.types;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

import com.ge.dspmicro.machinegateway.types.PDataNode;
import com.ge.predix.solsvc.workshop.config.JsonDataNode;

/**
 * 
 * 
 * @author Predix Machine Sample
 */
public class SampleDataNode extends PDataNode
{

		
    private JsonDataNode node;
    /**
	 * @param machineAdapterId -
     * @param node - JSONData Node
	 */
	public SampleDataNode(UUID machineAdapterId, JsonDataNode node) {
		super(machineAdapterId, node.getNodeName());
		this.node = node;
		try {
			
			switch (this.node.getNodeType()) { //nodetype based on values in the nodeconfig.json file
			case "Light": //$NON-NLS-1$
				//create light node
				break;
			case "Temperature": //$NON-NLS-1$
				//create temperature node
				break;
			case "Sound": //$NON-NLS-1$
				//create sound node
				break;
			case "RotaryAngle": //$NON-NLS-1$
				//create rotary angle ode
				break;
			case "Button": //$NON-NLS-1$
				//create button node
				break;
			case "Buzzer": //$NON-NLS-1$
				
			default:
				break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    /**
     * Node address to uniquely identify the node.
     */
    @Override
    public URI getAddress()
    {
        try
        {
            URI address = new URI("sample.subscription.adapter", null, "localhost", -1, "/" + getName(), null, null); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            return address;
        }
        catch (URISyntaxException e)
        {
            return null;
        }
    }

	/**
	 * @return -
	 */
	public JsonDataNode getNode() {
		return this.node;
	}

	/**
	 * @param node -
	 */
	public void setNode(JsonDataNode node) {
		this.node = node;
	}
}
