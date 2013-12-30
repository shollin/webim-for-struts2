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
package webim.struts2.actions;

import webim.config.WebimConfig;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Javascript嵌入脚本: /Webim/run.do
 * 
 * @author Ery Lee <ery.lee at gmail.com>
 * @since 1.0
 */
@SuppressWarnings("serial")
public class RunAction extends ActionSupport {

	public String theme = WebimConfig.THEME;
	public String local = WebimConfig.LOCAL;
	public String emot = WebimConfig.EMOT;
	public int opacity = WebimConfig.OPACITY;
	public boolean enable_room = WebimConfig.ENABLE_ROOM;
	public boolean enable_noti = WebimConfig.ENABALE_NOTI;
	public boolean enable_chatlink = WebimConfig.ENABLE_CHATLINK;
	public boolean enable_shortcut = WebimConfig.ENABLE_SHORTCUT;
	public boolean enable_menu = WebimConfig.ENABLE_MENU;
	public boolean show_unavailable = WebimConfig.SHOW_UNAVAILABLE;
	public boolean visitor = WebimConfig.ENABLE_VISITOR;

	public String execute() {
		return SUCCESS;
	}

}
