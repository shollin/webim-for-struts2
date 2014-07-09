/*
 * PresenceAction.java
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
import webim.client.WebimPresence;

/**
 * 现场变更: /Webim/presence.do
 * 
 * @author Ery Lee <ery.lee at gmail.com>
 * @since 1.0
 */
@SuppressWarnings("serial")
public class PresenceAction extends WebimAction {
	
	private String show;
	private String status = "";
	
    public String execute() throws WebimException {
    	WebimEndpoint endpoint = currentEndpoint();
    	WebimClient c = client(endpoint);
        c.publish(new WebimPresence(show, status));
    	return SUCCESS;
    }

	public String getShow() {
		return show;
	}

	public void setShow(String show) {
		this.show = show;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
}
