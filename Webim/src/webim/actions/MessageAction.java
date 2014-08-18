/*
 * MessageAction.java
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

import webim.client.WebimClient;
import webim.client.WebimEndpoint;
import webim.client.WebimException;
import webim.client.WebimMessage;

/**
 * 发送即时消息: /Webim/messsage.do
 * 
 * @author Ery Lee <ery.lee at gmail.com>
 * @since 1.0
 */
@SuppressWarnings("serial")
public class MessageAction extends WebimAction {

	private String type = "chat";
	private String offline;
	private String to;
	private String body;
	private String style = "";

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOffline() {
		return offline;
	}

	public void setOffline(String offline) {
		this.offline = offline;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String execute() throws WebimException {
		//request.setCharacterEncoding("UTF-8");
		WebimEndpoint endpoint = currentEndpoint();
		WebimClient c = client(endpoint);
		WebimMessage msg = new WebimMessage(to, endpoint.getNick(), body,
				style, System.currentTimeMillis());
		msg.setType(type);
		msg.setOffline("true".equals(offline) ? true : false);
		c.publish(msg);
		if (body != null && !body.startsWith("webim-event:")) {
			model.insertHistory(endpoint.getId(), msg);
		}
		return SUCCESS;
	}

}
