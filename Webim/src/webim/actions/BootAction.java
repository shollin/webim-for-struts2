/*
 * RunAction.java
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

import com.opensymphony.xwork2.ActionSupport;

/**
 * Javascript嵌入脚本: /Webim/boot.do
 * 
 * @author Ery Lee <ery.lee at gmail.com>
 * @since 1.0
 */
@SuppressWarnings("serial")
public class BootAction extends ActionSupport {

	public String theme;
	public String local;
	public String emot;
	public String opacity;
	public boolean enable_room;
	public boolean enable_noti;
	public boolean enable_chatlink;
	public boolean enable_shortcut;
	public boolean enable_menu;
	public boolean show_unavailable;
	public boolean visitor;

	public BootAction() {
		WebimConfig config = new WebimConfig();
		theme = (String) config.get("theme");
		local = (String) config.get("local");
		emot = (String) config.get("emot");
		opacity = (String) config.get("opacity");
		enable_room = config.getBoolean("enable_room");
		enable_noti = config.getBoolean("enable_noti");
		enable_chatlink = config.getBoolean("enable_chatlink");
		enable_shortcut = config.getBoolean("enable_shortcut");
		enable_menu = config.getBoolean("enable_menu");
		show_unavailable = config.getBoolean("show_unavailable");
		visitor = config.getBoolean("enable_visitor");
	}

	public String execute() {
		return SUCCESS;
	}

}
