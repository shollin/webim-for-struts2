/*
 * MembersAction.java
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import webim.WebimClient;
import webim.service.WebimService;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class MembersAction extends ActionSupport {

	private String id;

	private String ticket;

	private List<Map<String, String>> members;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public List<Map<String, String>> getMembers() {
		return members;
	}
	
	public void setMembers(List<Map<String, String>> members) {
		this.members = members;
	}
	
	public String execute() throws Exception {
    	WebimClient c = WebimService.instance().currentClient(this.ticket);
        String gid = this.id;
        JSONObject obj = c.members(gid);
        members = new ArrayList<Map<String,String>>();
        JSONArray array = obj.getJSONArray(gid);
        for(int i = 0; i < array.length(); i++)
        {
            Map<String,String> m = new HashMap<String,String>();
            obj = array.getJSONObject(i);
            m.put("id", obj.getString("id"));
            m.put("nick", obj.getString("nick"));
            members.add(m);
        }
    	return SUCCESS;
    }

}