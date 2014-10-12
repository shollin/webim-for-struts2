/*
 * BuddiesAction.java
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

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

import webim.client.WebimClient;
import webim.client.WebimException;
import webim.model.WebimEndpoint;

/**
 * 读取好友列表: /Webim/buddies.do
 * 
 * @author Ery Lee <ery.lee at gmail.com>
 * @since 1.0
 */
@SuppressWarnings("serial")
public class BuddiesAction extends WebimAction {

	private String ids;

	private List<WebimEndpoint> buddies;

	public List<WebimEndpoint> getBuddies() {
		return buddies;
	}

	public String execute() throws WebimException, JSONException {
		WebimEndpoint endpoint = currentEndpoint();
		Set<String> idSet = new HashSet<String>(Arrays.asList(this.ids.split(",")));
		buddies = plugin.buddiesByIds(endpoint.getId(), idSet);
		if (idSet.size() > 0) {
			WebimClient c = client(endpoint);
			JSONObject presences = c.presences(idSet);
			for (WebimEndpoint buddy : buddies) {
				String id = buddy.getId();
				if (presences.has(id)) {
					String show = presences.getString(id);
					if (!"invisible".equals(show)) {
						buddy.setPresence("online");
						buddy.setShow(presences.getString(id));
					}
				}
			}
		}
		return SUCCESS;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

}
