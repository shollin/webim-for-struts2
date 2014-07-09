package webim.actions;

import java.util.List;

import webim.client.WebimClient;
import webim.client.WebimEndpoint;
import webim.client.WebimException;
import webim.client.WebimMessage;
import webim.client.WebimRoom;

@SuppressWarnings("serial")
public class InviteAction extends WebimAction {

	private String id;
	private String nick = "";
	private String members;
	private WebimRoom data;

	public String execute() throws WebimException {
		WebimEndpoint endpoint = currentEndpoint();
		String uid = endpoint.getId();
		String roomId = id;
		WebimRoom room = model.findRoom(roomId);
		if (room != null) {
			room = model.createRoom(uid, roomId, nick);
		}
		model.joinRoom(roomId, uid, endpoint.getNick());
		String[] memberIds = members.split(",");
		List<WebimEndpoint> members = plugin.buddiesByIds(uid, memberIds);
		model.inviteRoom(roomId, members);

		WebimClient c = client(endpoint);
		// send invite message to members
		for (WebimEndpoint m : members) {
			String body = "webim-event:invite|,|" + roomId + "|,|" + nick;
			c.publish(new WebimMessage(m.getId(), endpoint.getNick(), body, "",
					System.currentTimeMillis()));

		}
		c.join(roomId);
		setData(room);
		return SUCCESS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getMembers() {
		return members;
	}

	public void setMembers(String members) {
		this.members = members;
	}

	public WebimRoom getData() {
		return data;
	}

	public void setData(WebimRoom data) {
		this.data = data;
	}

}
