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

import java.util.HashMap;
import java.util.Map;

import webim.client.WebimClient;
import webim.client.WebimException;
import webim.model.WebimEndpoint;
import webim.model.WebimMessage;

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

	//return data
	private Map<String, String> data;

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
	
	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}

	public String execute() throws WebimException {
        //HttpServletRequest request = ServletActionContext.getRequest();
		//request.setCharacterEncoding("UTF-8");
        data = new HashMap<String, String>();
        WebimEndpoint endpoint = currentEndpoint();
		if (!plugin.checkCensor(body)) {
			data.put("status", "error");
			data.put("message", "您发送消息有敏感词");
			return SUCCESS;
		}
		if (plugin.isRobotSupport() && plugin.isFromRobot(to)) {
			WebimClient c = this.client(endpoint);
			c.setTicket(null);

			WebimMessage requestMsg = new WebimMessage(to, c.getEndpoint()
					.getNick(), body, style, System.currentTimeMillis());
			this.model.insertHistory(endpoint.getId(), requestMsg);

			String answer = plugin.getRobot().answer(body);
			WebimMessage answermsg = new WebimMessage(endpoint.getId(), plugin.getRobot()
					.getNick(), answer, "", System.currentTimeMillis());
			c.push(to, answermsg);
			this.model.insertHistory(to, answermsg);
		} else {
            WebimClient c = client(endpoint);
            WebimMessage msg = new WebimMessage(to, endpoint.getNick(), body,
                    style, System.currentTimeMillis());
            msg.setType(type);
            msg.setOffline("true".equals(offline) ? true : false);
            c.publish(msg);
            if (body != null && !body.startsWith("webim-event:")) {
                model.insertHistory(endpoint.getId(), msg);
            }
        }
        data.put("status", "ok");
		return SUCCESS;
	}

}
