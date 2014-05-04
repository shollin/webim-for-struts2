/*
 * WebimAction.java
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

import webim.client.WebimClient;
import webim.client.WebimEndpoint;
import webim.struts2.WebimConfig;
import webim.struts2.WebimModel;
import webim.struts2.WebimPlugin;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action父类
 * 
 * @author Ery Lee <ery.lee at gmail.com>
 * @since 1.0
 */
@SuppressWarnings("serial")
public class WebimAction extends ActionSupport {
	
    protected WebimConfig config = null;

    protected WebimModel model = null;

    protected WebimPlugin plugin = null;

    protected WebimClient client = null;

    protected WebimEndpoint endpoint = null;

	protected String ticket;

    public WebimAction () {
        this.config = new WebimConfig();
        this.model = new WebimModel();
        this.plugin = new WebimPlugin();
        this.endpoint = this.plugin.endpoint();
    }

    protected String currentUid() {
        return this.endpoint.getId();
    }

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	
    /**
     * 返回当前的Webim客户端。
     *
     * @param ticket
     *            通信令牌
     * @return 当前用户的Webim客户端
     */
    protected WebimClient client(String ticket) {
        if (this.client == null) {
            this.client = new WebimClient(this.endpoint,
                    (String) this.config.get("domain"),
                    (String) this.config.get("apikey"),
                    (String) this.config.get("host"),
                    ((Integer) this.config.get("port")).intValue());
            this.client.setTicket(ticket);
        }
        return this.client;
    }

}
