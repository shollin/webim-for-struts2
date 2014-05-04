/*
 * OnlineAction.java
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
package webim.struts2.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import webim.client.WebimClient;
import webim.client.WebimEndpoint;
import webim.client.WebimRoom;

/**
 * 用户上线: /Webim/online.do
 * 
 * @author Ery Lee <ery.lee at gmail.com>
 * @since 1.0
 */
@SuppressWarnings("serial")
public class OnlineAction extends WebimAction {

	private Map<String, Object> data;

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	private List<String> buddyIds(List<WebimEndpoint> buddies) {
		List<String> ids = new ArrayList<String>();
		for (WebimEndpoint b : buddies) {
			ids.add(b.getId());
		}
		return ids;
	}

	private List<String> roomIds(List<WebimRoom> rooms) {
		List<String> ids = new ArrayList<String>();
		for (WebimRoom room : rooms) {
			ids.add(room.getId());
		}
		return ids;
	}

	public String execute() throws Exception {
		String uid = this.currentUid();
		List<WebimEndpoint> buddies = this.plugin.buddies(uid);
		List<WebimRoom> rooms = this.plugin.rooms(uid);
		rooms.addAll(this.model.rooms(uid));
		// Forward Online to IM Server
		WebimClient client = this.client("");
		List<String> buddyIds = buddyIds(buddies);
		List<String> roomIds = roomIds(rooms);
		try {
			data = client.online(buddyIds, roomIds);
			System.out.println(data.toString());

			// Online Buddies
			Map<String, WebimEndpoint> buddyMap = new HashMap<String, WebimEndpoint>();
			for (WebimEndpoint e : buddies) {
				buddyMap.put(e.getId(), e);
			}

			Map<String, String> presences = (Map<String, String>) data
					.get("presences");
			Iterator<String> it = presences.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();
				WebimEndpoint buddy = buddyMap.get(key);
				String show = presences.get(key);
				buddy.setPresence("online");
				buddy.setShow(show);
			}

			Collection<WebimEndpoint> rtBuddies;
			if (this.config.getBoolean("show_unavailable")) {
				rtBuddies = buddyMap.values();
			} else {
				rtBuddies = new ArrayList<WebimEndpoint>();
				for (WebimEndpoint e : buddyMap.values()) {
					if (e.getPresence() == "online")
						rtBuddies.add(e);
				}
			}
			data.remove("presences");
			data.put("buddies", rtBuddies.toArray());
			data.put("rooms", rooms.toArray());
			data.put("server_time", System.currentTimeMillis()); // TODO: /
																	// 1000.0
			data.put("user", client.getEndpoint());
		} catch (Exception e) {
			data.put("success", false);
			data.put("error_msg", e.getMessage());
		}

		return SUCCESS;
	}

}
