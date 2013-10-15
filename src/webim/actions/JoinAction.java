/*
 * JoinAction.java
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

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import webim.WebimClient;
import webim.service.WebimService;

@SuppressWarnings("serial")
public class JoinAction extends WebimAction {

	private String id;
	
	//TODO: FIXME
	private Map<String, Integer> rooms[];

	public String execute() throws Exception {
		WebimClient c = WebimService.instance().currentClient(this.ticket);
		Map<String, Integer> data = new HashMap<String, Integer>();
		JSONObject o = c.join(id);
		data.put(id, o.getInt(id));
		rooms[0] = data;
		return SUCCESS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}