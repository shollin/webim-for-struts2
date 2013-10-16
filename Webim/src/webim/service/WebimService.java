/*
 * WebimService.java
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
package webim.service;

import java.util.ArrayList;
import java.util.List;

import webim.WebimClient;
import webim.WebimConfig;
import webim.WebimEndpoint;
import webim.WebimGroup;
import webim.WebimHistory;
import webim.WebimMenu;
import webim.WebimMessage;
import webim.WebimNotification;
import webim.dao.WebimDao;
import webim.dao.WebimHistoryDao;
import webim.dao.WebimSettingDao;

public class WebimService {

	static WebimService instance = null;

	private WebimDao webimDao;
	private WebimSettingDao settingDao;
	private WebimHistoryDao historyDao;

	public WebimService() {
		webimDao = new WebimDao();
		settingDao = new WebimSettingDao();
		historyDao = new WebimHistoryDao();
	}

	public static WebimService instance() {
		if (instance == null) {
			instance = new WebimService();
		}
		return instance;
	}

	public long currentUid() {
		return 1;
	}

	// TODO: you should read current user, and mapping to endpoint
	public WebimEndpoint currentEndpoint() {
		WebimEndpoint ep = new WebimEndpoint("1", "user1");
		ep.setPic_url("https://1.gravatar.com/avatar/136e370cbf1cf500cbbf791e56dac614?d=https%3A%2F%2Fidenticons.github.com%2F577292a0aa8cb84aa3e6f06fee6f711c.png&s=70"); // 用户头像
		ep.setShow("available");
		ep.setUrl(""); // 用户空间
		ep.setStatus(""); // 用户状态
		return ep;
	}

	public WebimClient currentClient(String ticket) {
		WebimClient c = new WebimClient(currentEndpoint(), WebimConfig.DOMAIN,
				WebimConfig.APIKEY, WebimConfig.HOST, WebimConfig.PORT);
		c.setTicket(ticket);
		return c;
	}

	public List<WebimEndpoint> getBuddies(long uid) {
		return webimDao.getBuddiesByUid(uid, 1000);
	}

	public List<WebimGroup> getGroups(long uid) {
		return webimDao.getGroups(uid, 100);
	}

	// Groups
	public WebimGroup GetGroup(long gid) {
		return webimDao.getGroup(gid);
	}

	// Offline
	public List<WebimHistory> GetOfflineMessages(long uid) {
		return historyDao.getOfflineMessages(uid);
	}

	public void OfflineMessageToHistory(int uid) {
		historyDao.offlineMessageToHistory(uid);
	}

	public void InsertHistory(long uid, String offline, WebimMessage msg) {
		WebimHistory h = new WebimHistory();
		h.setFrom(String.valueOf(uid));
		h.setSend(offline == "true" ? 0 : 1);
		h.setNick(msg.getNick());
		h.setType(msg.getType());
		h.setTo(msg.getTo());
		h.setBody(msg.getBody());
		h.setStyle(msg.getStyle());
		h.setTimestamp(msg.getTimestamp());
		historyDao.insert(h);
	}

	// Setting
	public String getSetting(long uid) {
		return settingDao.get(uid);
	}

	public void updateSetting(long uid, String data) {
		settingDao.set(uid, data);
	}

	// History
	public List<WebimHistory> getHistories(long uid, String with, String type) {
		return historyDao.getHistories(uid, with, type);
	}

	public void clearHistories(long uid, String with) {
		historyDao.clearHistories(uid, with);
	}

	// Notifications
	public List<WebimNotification> getNotifications(long uid) {
		// TODO: unimplemented
		return new ArrayList<WebimNotification>();
	}

	// Menu
	public List<WebimMenu> getMenuList(long uid) {
		return new ArrayList<WebimMenu>();
	}

	public List<WebimEndpoint> getBuddiesByIds(long ids[]) {
		return webimDao.getBuddiesByIds(ids);
	}

	public void insertHistory(long uid, String offline, WebimMessage msg) {
		// TODO Auto-generated method stub

	}

	public List<WebimEndpoint> getBuddiesByIds(String[] ids) {
		// TODO Auto-generated method stub
		return null;
	}

}
