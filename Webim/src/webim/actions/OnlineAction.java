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
package webim.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import webim.client.WebimClient;
import webim.model.WebimEndpoint;
import webim.model.WebimHistory;
import webim.model.WebimRoom;

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

	public String execute() throws Exception {
		WebimEndpoint endpoint = currentEndpoint();
		String uid = endpoint.getId();
		List<WebimEndpoint> buddies = this.plugin.buddies(uid);
		List<WebimRoom> rooms = this.plugin.rooms(uid);
		rooms.addAll(this.model.rooms(uid));
		// Forward Online to IM Server
		WebimClient client = this.client(endpoint);
		Set<String> buddyIds = buddyIds(buddies);
		Set<String> roomIds = roomIds(rooms);
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
				if(!show.equals("invisible")) {
					buddy.setPresence("online");
					buddy.setShow(show);
				}
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
            List<WebimHistory> offlineHistories = this.model.offlineHistories(uid, 100);
            this.model.offlineHistoriesReaded(uid);
			data.put("buddies", rtBuddies.toArray());
			data.put("rooms", rooms.toArray());
            data.put("new_messages", offlineHistories.toArray());
			data.put("server_time", System.currentTimeMillis()); 
			data.put("user", client.getEndpoint());
		} catch (Exception e) {
            data = new HashMap<String, Object>();
			data.put("success", false);
			data.put("error_msg", e.getMessage());
		}

		return SUCCESS;
	}

	private Set<String> buddyIds(List<WebimEndpoint> buddies) {
		Set<String> ids = new HashSet<String>();
		for (WebimEndpoint b : buddies) {
			ids.add(b.getId());
		}
		return ids;
	}

	private Set<String> roomIds(List<WebimRoom> rooms) {
		Set<String> ids = new HashSet<String>();
		for (WebimRoom room : rooms) {
			ids.add(room.getId());
		}
		return ids;
	}


}
