/*
 * ChatboxAction.java
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

import webim.WebimConfig;
import webim.model.WebimEndpoint;
import webim.service.WebimPlugin;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 手机聊天窗口: /Webim/chatbox.do
 * 
 * @author Ery Lee <feng@nextalk.im>
 * @since 5.8
 */

public class ChatboxAction extends ActionSupport {

	private static final long serialVersionUID = -5760612924092893671L;

	protected WebimConfig config = null;

	protected WebimPlugin plugin = null;

	private String uid;

	private String nick;

	private String avatar;

	public ChatboxAction() {
		this.config = new WebimConfig();
		this.plugin = new WebimPlugin(config);
	}

	public String execute() {
		WebimEndpoint ep = plugin.findUser(uid);
		if (ep == null)
			return ERROR;
		setNick(ep.getNick());
		setAvatar(ep.getAvatar());
		return SUCCESS;
	}
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
