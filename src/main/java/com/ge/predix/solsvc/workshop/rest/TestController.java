package com.ge.predix.solsvc.workshop.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.ge.dspmicro.hoover.api.spillway.ISpillway;
import com.ge.dspmicro.machinegateway.types.ITransferable;
import com.ge.dspmicro.machinegateway.types.PDataValue;
import com.ge.dspmicro.machinegateway.types.PEnvelope;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;

@SuppressWarnings("javadoc")
interface IHttpsServer
{
    public static final String PATH = "/testserver"; //$NON-NLS-1$
}

/**
 * Test rest server to see if client authentication works
 * 
 * @author Jiaqi Wu
 */
@Component(provide = TestController.class)
@Path(IHttpsServer.PATH)
public class TestController
        implements IHttpsServer
{
	private  ISpillway spillway;
    /**
     * Basic endpoint which returns some junk
     * 
     * @return junk
     */
    @SuppressWarnings("deprecation")
	@GET
    @Path("/test")
    @Produces("application/json")
    public Map<String, String> test()
    {
        Map<String, String> result = new HashMap<String,String>();
        result.put("status", "accepted"); //$NON-NLS-1$ //$NON-NLS-2$
        List<ITransferable> data = new ArrayList<ITransferable>();
        
        try {
        	PDataValue value = new PDataValue();
			value.setAddress(new URI("http://localhost"));
			value.setNodeName("Node1-1");
			value.setValue(new PEnvelope("1234"));
			data.add(value);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
        spillway.processAndTransferData(data);
        return result;
    }
	public ISpillway getSpillway() {
		return spillway;
	}
	
	@Reference
	public void setSpillway(ISpillway spillway) {
		this.spillway = spillway;
	}
}
