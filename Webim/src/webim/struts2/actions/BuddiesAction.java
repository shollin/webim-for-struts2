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
package webim.struts2.actions;

import java.util.List;

import webim.client.WebimEndpoint;
import webim.service.WebimService;

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
	
    public String execute() {
    	String ids1[] = this.ids.split(",");
    	long id2[] = new long[ids1.length];
    	for(int i = 0; i < ids1.length; i++) {
    		id2[i] = Long.parseLong(ids1[i]);
    	}
    	buddies = WebimService.instance().getBuddiesByIds(id2);
    	return SUCCESS;
    }

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
    
}

