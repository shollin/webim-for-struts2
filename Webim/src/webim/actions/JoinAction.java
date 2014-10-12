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


import webim.model.WebimEndpoint;
import webim.model.WebimRoom;

/**
 * 加入群组: /Webim/join.do
 * 
 * @author Ery Lee <ery.lee at gmail.com>
 * @since 1.0
 */
@SuppressWarnings("serial")
public class JoinAction extends WebimAction {

	private String id;

	private String nick = "";

	private WebimRoom data = null;

	public String execute() throws Exception {
		WebimEndpoint endpoint = currentEndpoint();
		WebimRoom room = this.plugin.findRoom(id);
		if (room == null) {
			room = this.model.findRoom(id);
		}
		if (room != null) {
			this.client(endpoint).join(id);
		}
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

	public void setData(WebimRoom room) {
		data = room;
	}

	public WebimRoom getData() {
		return data;
	}

}
