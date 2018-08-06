package com.ericsson.service.xmlrpc.client;

import java.net.URL;
import java.util.*;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcTransport;
import org.apache.xmlrpc.client.XmlRpcTransportFactory;

public class TestXmlRpcClient {
	
	public static void main(String[] args) {
		
		try {
				System.out.println("XML-RPC Client call...");
				XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
				
				config.setServerURL(new URL("http://10.61.38.108:10000/Air"));
				config.setBasicUserName("user");
				config.setBasicPassword("user");
				config.setUserAgent("Ugw Server/5.0/1.0");
				
				XmlRpcClient client = new XmlRpcClient();
				final XmlRpcTransportFactory transportFactory = new XmlRpcTransportFactory()
				{
				    public XmlRpcTransport getTransport()
				    {
				        return new MessageLoggingTransport(client);
				    }
				};
				
				/*config.setBasicUserName("userRpc1");
				config.setBasicPassword("passRpc1");*/
				//XmlRpcClient client = new XmlRpcClient();
				client.setTransportFactory(transportFactory);
		        client.setConfig(config);
		        Vector params = new Vector();
		        //params.addElement(obj);
		        /*params.addElement(new Integer(10));
		        params.addElement(new Integer(50));*/
		        
		        Map<String, String> map = new HashMap<String, String>();
		        map.put("key1", "value1");
		        map.put("key2", "value2");
		        
		        params.addElement(map);
		        Object result = client.execute("GetBalanceAndDate", params);
		        //client.
		       // XmlRpcRequest
		        System.out.print("Client Executed");
	
		        int sum = ((Integer) result).intValue();
		        System.out.println("\nThe sum is: "+ sum);

	      } catch (Exception exception) {
	         System.err.println("xmlRpcClient: " + exception);
	   }
	}

}
