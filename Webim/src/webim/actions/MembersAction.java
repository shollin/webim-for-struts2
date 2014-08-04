/*
 * MembersAction.java
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package webim.actions;

import java.util.List;

import org.json.JSONObject;

import webim.client.WebimEndpoint;
import webim.client.WebimMember;
import webim.client.WebimRoom;

/**
 * 读取群组成员: /Webim/members.do
 * 
 * @author Ery Lee <ery.lee at gmail.com>
 * @since 1.0
 */
@SuppressWarnings("serial")
public class MembersAction extends WebimAction {

	private String id;

	private List<WebimMember> members;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<WebimMember> getMembers() {
		return members;
	}

	public void setMembers(List<WebimMember> members) {
		this.members = members;
	}

	public String execute() throws Exception {
		WebimEndpoint endpoint = currentEndpoint();
		String roomId = getId();
		WebimRoom room = this.plugin.findRoom(roomId);
		if (room != null) {
			members = this.plugin.members(roomId);
		} else {
			room = this.model.findRoom(roomId);
			if (room != null) {
				members = this.model.members(roomId);
			}
		}
		if (room == null)
			return null;
		JSONObject presences = client(endpoint).members(roomId);
		for (WebimMember member : members) {
			String mid = member.getId();
			if (presences.has(mid)) {
				String show = presences.getString(mid);
				if (!"invisible".equals(show)) {
					member.setPresence("online");
					member.setShow(presences.getString(mid));
				}
			}
		}
		return SUCCESS;
	}

}
