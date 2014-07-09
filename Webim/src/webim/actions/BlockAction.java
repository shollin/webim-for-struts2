package webim.actions;

import webim.client.WebimEndpoint;
import webim.client.WebimException;

@SuppressWarnings("serial")
public class BlockAction extends WebimAction {
	
	private String id;

	public String execute() throws WebimException {
		WebimEndpoint endpoint = currentEndpoint();
		model.blockRoom(id, endpoint.getId());
		return SUCCESS;
	}

}
