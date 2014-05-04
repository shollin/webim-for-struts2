/*
 * DownloadHistoryAction.java
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

import webim.client.WebimHistory;

/**
 * 下载历史记录: /Webim/downhistory.do
 * 
 * @author Ery Lee <ery.lee at gmail.com>
 * @since 1.0
 */
@SuppressWarnings("serial")
public class DownloadHistoryAction extends WebimAction {

	private String id;
	private String type;
	private List<WebimHistory> histories;

	public String execute() {

		histories = model.histories(currentUid(), id, type, 1000);
		// response.setHeader("Content-Disposition",
		// "attachment; filename=\"histories.html\"");

		return SUCCESS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<WebimHistory> getHistories() {
		return histories;
	}

	public void setHistories(List<WebimHistory> histories) {
		this.histories = histories;
	}

}
