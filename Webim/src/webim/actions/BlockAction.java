package webim.actions;

import webim.client.WebimException;
import webim.model.WebimEndpoint;

@SuppressWarnings("serial")
public class BlockAction extends WebimAction {
	
	private String id;

	public String execute() throws WebimException {
		WebimEndpoint endpoint = currentEndpoint();
		model.blockRoom(id, endpoint.getId());
		return SUCCESS;
	}

}
