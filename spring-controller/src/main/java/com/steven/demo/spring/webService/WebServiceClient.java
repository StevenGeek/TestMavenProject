package com.steven.demo.spring.webService;

import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;

/**
 * Created by kira7 on 2016/11/28 0028.
 */
@Component
public class WebServiceClient {

	private static final String MESSAGE =
			"<message xmlns=\"http://tempuri.org\">Hello World</message>";

	private final WebServiceTemplate webServiceTemplate = new WebServiceTemplate();

	public void setDefaultUri(String defaultUri) {
		webServiceTemplate.setDefaultUri(defaultUri);
	}

	// send to the configured default URI
	public String simpleSendAndReceive() throws IOException {
		StreamSource source = new StreamSource(new StringReader(MESSAGE));
		StreamResult result = new StreamResult(System.out);
		webServiceTemplate.sendSourceAndReceiveToResult(source, result);
		OutputStreamWriter osw= new OutputStreamWriter(result.getOutputStream());
		String x="";
		osw.write(x);
		return x;
	}

	// send to an explicit URI
	public void customSendAndReceive() {
		StreamSource source = new StreamSource(new StringReader(MESSAGE));
		StreamResult result = new StreamResult(System.out);
		webServiceTemplate.sendSourceAndReceiveToResult("http://localhost:8080/AnotherWebService",
				source, result);
	}

}

