package com.ericsson.service.xmlrpc.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcStreamTransport;
import org.apache.xmlrpc.client.XmlRpcSunHttpTransport;
import org.xml.sax.SAXException;

public class MessageLoggingTransport extends XmlRpcSunHttpTransport {

	public MessageLoggingTransport(XmlRpcClient pClient) {
		super(pClient);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void writeRequest(final XmlRpcStreamTransport.ReqWriter pWriter)
			throws IOException, XmlRpcException, SAXException {
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		pWriter.write(baos);
		System.out.println(baos.toString());
		super.writeRequest(pWriter);
	}

}
