package cnlab2.client;

import java.io.IOException;
import java.net.UnknownHostException;

import cnlab2.common.Response;
import cnlab2.common.SmartSocket;
import cnlab2.common.URI;

public class HTTP10Client extends Client {
	
	public HTTP10Client() {
		super();
	}

	@Override
	public SmartSocket getSmartSocketFor(URI uri) throws UnknownHostException, IOException {
		return new SmartSocket(uri);
	}

	@Override
	public void handle(String command, URI uri) throws UnknownHostException, IOException {
		Handler handler;
		
		switch (command) {
		case "GET":
			handler = new GETHandler(this, uri);
			break;
		case "HEAD":
			handler = new HEADHandler(this, uri);
			break;
		case "POST":
			handler = new POSTHandler(this, uri);
			break;
		default:
			throw new IllegalArgumentException("Unknown command");
		}
		
		handler.send();
		Response response = handler.receive();
		
		System.out.print(response);
	}

	@Override
	public String getVersion() {
		return "HTTP/1.0";
	}
	
}
