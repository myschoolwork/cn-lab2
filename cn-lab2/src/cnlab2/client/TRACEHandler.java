package cnlab2.client;

import java.io.IOException;
import java.net.UnknownHostException;

public class TRACEHandler extends Handler {

	public TRACEHandler(Client client, URI uri) throws UnknownHostException, IOException {
		super(client, uri);
	}
	
	@Override
	public String getCommand() {
		return "TRACE";
	}
	
}
