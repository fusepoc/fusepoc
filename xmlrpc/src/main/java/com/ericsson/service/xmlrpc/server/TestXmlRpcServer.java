package com.ericsson.service.xmlrpc.server;

import java.util.Map;

import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

public class TestXmlRpcServer {
	
	private static final Integer PORT = 8111;
	
	public Integer getBalanceAndDate(Map<String, String> map) {
		return new Integer(map.size());
	}

	public static void main(String[] args) {
		
		try {
			System.out.println("Attempting to start XML-RPC Server...");

			WebServer server = new WebServer(PORT);
			
			XmlRpcServer xmlRpcServer = server.getXmlRpcServer();
			
			PropertyHandlerMapping phm = new PropertyHandlerMapping();
			phm.addHandler("sample", TestXmlRpcServer.class);
			
			xmlRpcServer.setHandlerMapping(phm);
			XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
			serverConfig.setEnabledForExtensions(true);
			serverConfig.setContentLengthOptional(false);
			
			server.start();
			System.out
					.println("Started successfully. Accepting requests(Halt program to stop)\nListening on port: " + PORT);
			//XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
			
			
			xmlRpcServer.setHandlerMapping(phm);

		} catch (Exception exception) {
			System.err.println("XmlRpcServer: " + exception);
		}
	}

}
