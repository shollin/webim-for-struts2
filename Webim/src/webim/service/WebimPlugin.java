/*
 * WebimPlugin.java
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
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import webim.WebimConfig;
import webim.model.WebimAskProvider;
import webim.model.WebimEndpoint;
import webim.model.WebimMember;
import webim.model.WebimMenu;
import webim.model.WebimNotification;
import webim.model.WebimRobot;
import webim.model.WebimRoom;

/**
 * WebIM插件接口
 * 
 * @author Ery Lee <ery.lee at gmail.com>
 * @since 5.4
 */
public class WebimPlugin {

    private WebimRobot robot;
    
	private WebimConfig config;

    public WebimPlugin(WebimConfig config) {
    	
    	this.config = config;
    	
    	WebimAskProvider provider = new WebimAskProvider() {
			@Override
			public String answer(String ask) {
				ask = ask.trim();
				if("1".equals(ask)) {
					return "http://nextalk.im";
				}
				if("2".equals(ask)) {
					return "https://github.com/webim/webim-for-struts2";
				}
				StringBuffer sb = new StringBuffer("问题列表:\n");
				for(String s : this.askList()) {
					sb.append(s + "\n");
				}
				return sb.toString();
			}

			@Override
			public String[] askList() {
				return new String[] {
						"1. NexTalk产品介绍",
						"2. Webim-for-struts2插件源码下载"
				};
			}
		};
			
    	robot = new WebimRobot("robot", "Robot");
    	
    	robot.setAvatar("static/images/male.png");
    	
    	robot.setProvider(provider);
    	
    }

	/**
	 * API: current user
	 *
	 * 返回当前的Webim端点(用户)
	 *
	 * @return current user
	 */
	public WebimEndpoint endpoint() {
		// TODO: 应替换该代码，返回集成系统的当前用户。
		WebimEndpoint ep = new WebimEndpoint("1", "user1");
		ep.setAvatar("static/images/male.png");
		ep.setShow("available");
		ep.setUrl(""); // 用户空间
		ep.setStatus(""); // 用户状态
		return ep;
	}

	/**
     * API: Buddies of current user.
     *
     * Buddy:
     *
     *  id:         uid
     *  uid:        uid
     *  nick:       nick
     *  avatar:     url of photo
     *  presence:   online | offline
     *  show:       available | unavailable | away | busy | hidden
     *  url:        url of home page of buddy
     *  status:     buddy status information
     *  group:      group of buddy

     * @param string current uid
     *
     * @return Buddy list
     *
     */	
	public List<WebimEndpoint> buddies(String uid) {
		// TODO: DEMO CODE
		List<WebimEndpoint> buddies = new ArrayList<WebimEndpoint>();
		for (int i = 1; i <= 10; i++) {
			WebimEndpoint e = new WebimEndpoint(String.valueOf(i), "user" + i);
			e.setAvatar("static/images/male.png");
			buddies.add(e);
		}
		if (isRobotSupport()) {
			buddies.add(robot);
		}
		return buddies;
	}

	/**
	 * API: buddies by ids. 根据id列表读取buddy列表。
	 * 
	 * @param uid
	 *            当前用户id
	 * @param idSet
	 *            好友id列表
	 * @return 好友列表
	 */
	public List<WebimEndpoint> buddiesByIds(String uid, Set<String> idSet) {
		// TODO: DEMO CODE 示例代码
		List<WebimEndpoint> buddies = new ArrayList<WebimEndpoint>();
		for (String id : idSet) {
			WebimEndpoint e = new WebimEndpoint(id, "user" + id);
			e.setAvatar("static/images/male.png");
			buddies.add(e);
		}
		return buddies;
	}

	/**
	 * 根据uid查询用户
	 * @param uid
	 * @return
	 */
	public WebimEndpoint findUser(String uid) {
		WebimEndpoint e = new WebimEndpoint(uid, "user" + uid);
		e.setAvatar("static/images/male.png");
		return e;
	}


	/**
	 * 根据roomId读取群组
	 * 
	 * @param roomId
	 * @return 群组
	 */
	public WebimRoom findRoom(String roomId) {
		// TODO: 示例代码，需要替换
		if (roomId.equals("room1")) {
			WebimRoom room = new WebimRoom("room1", "Room1");
			room.setAvatar("/Webim/static/images/room.png");
			return room;
		}
		return null;
	}

    /**
     * API：rooms of current user
     *
     * @param uid
     *
     * @return rooms
     *
     * Room:
     *
     *  id:         Room ID,
     *  nick:       Room Nick
     *  url:        Home page of room
     *  avatar:     Pic of Room
     *  status:     Room status
     *  count:      count of online members
     *  all_count:  count of all members
     *  blocked:    true | false
     */
	public List<WebimRoom> rooms(String uid) {
		// TODO: 示例代码，需要替换
		List<WebimRoom> rooms = new ArrayList<WebimRoom>();
		WebimRoom room = new WebimRoom("room1", "Room1");
		room.setAvatar("/Webim/static/images/room.png");
		rooms.add(room);
		return rooms;
	}

	/**
	 * API: rooms by ids
	 *
	 * @param room
	 *            id array
	 *
	 * @return rooms
	 *
	 *         Room
	 *
	 */
	public List<WebimRoom> roomsByIds(String uid, Set<String> ids) {
		// TODO: 示例代码，需要替换
		List<WebimRoom> rooms = new ArrayList<WebimRoom>();
		WebimRoom room = new WebimRoom("room1", "Room1");
		room.setAvatar("/Webim/static/images/room.png");
		rooms.add(room);
		return rooms;
	}

	/**
	 * API: members of room
	 *
	 * @param roomId
	 * @return member list
	 */
	public List<WebimMember> members(String roomId) {
		List<WebimMember> members = new ArrayList<WebimMember>();
		for (int i = 1; i <= 10; i++) {
			members.add(new WebimMember("" + i, "user" + i));
		}
		return members;
	}

	/**
	 * API: notifications of current user
	 *
	 * @return notification list
	 *
	 *         Notification:
	 *
	 *         text: text link: link
	 */
	public List<WebimNotification> notifications(String uid) {
		List<WebimNotification> notifications = new ArrayList<WebimNotification>();
		notifications.add(new WebimNotification("通知", "#"));
		return notifications;
	}

	/**
	 * API: menu
	 *
	 * @return menu list
	 *
	 *         Menu:
	 *
	 *         icon text link
	 */
	public List<WebimMenu> menu(String uid) {
		return new ArrayList<WebimMenu>();
	}

    /**
     * 敏感词处理
     * @param body
     * @return
     */
	public boolean checkCensor(String body) {
		//TODO: 调用敏感词接口
		return true;
	}
	
	/**
	 * 是否支持Robot
	 * 
	 * @return true 支持机器人
	 */
	public boolean isRobotSupport() {
		return config.getBoolean("robot");
	}

	/**
	 * 是否发送给机器人的消息?
	 * 
	 * @param to 机器人id
	 * @return
	 */
	public boolean isFromRobot(String to) {
		return robot.getId().equals(to);
	}

	/**
	 * 机器人
	 * @return 机器人
	 */
	public WebimRobot getRobot() {
		return robot;
	}


}
