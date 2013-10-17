/*
 * WebimHistoryDao.java
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
package webim.dao;

import java.util.ArrayList;
import java.util.List;

import webim.WebimHistory;

/*
CREATE TABLE webim_histories (
	    `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
	    `send` tinyint(1) DEFAULT NULL,
	    `type` varchar(20) DEFAULT NULL,
	    `to` varchar(50) NOT NULL,
	    `from` varchar(50) NOT NULL,
	    `nick` varchar(20) DEFAULT NULL COMMENT 'from nick',
	    `body` text,
	    `style` varchar(150) DEFAULT NULL,
	    `timestamp` double DEFAULT NULL,
	    `todel` tinyint(1) NOT NULL DEFAULT '0',
	    `fromdel` tinyint(1) NOT NULL DEFAULT '0',
	    `created_at` date DEFAULT NULL,
	    `updated_at` date DEFAULT NULL,
	    PRIMARY KEY (`id`),
	    KEY `todel` (`todel`),
	    KEY `fromdel` (`fromdel`),
	    KEY `timestamp` (`timestamp`),
	    KEY `to` (`to`),
	    KEY `from` (`from`),
	    KEY `send` (`send`)
	) ENGINE=MyISAM;
*/
public class WebimHistoryDao {

	public void clearHistories(long uid, String with) {
		// TODO Auto-generated method stub
		
	}

	public List<WebimHistory> getHistories(long uid, String with, String type) {
		// TODO Auto-generated method stub
		return new ArrayList<WebimHistory>();
	}

	public void offlineMessageToHistory(int uid) {
		// TODO Auto-generated method stub
		
	}

	public List<WebimHistory> getOfflineMessages(long uid) {
		// TODO Auto-generated method stub
		return new ArrayList<WebimHistory>();
	}

	public void insert(WebimHistory h) {
		// TODO Auto-generated method stub
		
	}

	public void offlineMessageToHistory(long uid) {
		// TODO Auto-generated method stub
		
	}

}
