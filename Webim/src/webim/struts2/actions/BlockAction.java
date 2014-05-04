package webim.struts2.actions;

import webim.client.WebimException;

@SuppressWarnings("serial")
public class BlockAction extends WebimAction {
	
	private String id;

	public String execute() throws WebimException {
		model.blockRoom(id, currentUid());
		return SUCCESS;
	}

}
