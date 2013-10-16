/*
 * WebimConfig.java
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
package webim;

/**
 * @doc 测试的配置文件，配置消息服务器的地址、端口、通信domain、apikey。<br>
 *      正式项目配置应写在XML文件或者数据库中。
 *      
 * @author Ery Lee <ery.lee @ gmail.com>
 * 
 */
public class WebimConfig {

    public static String VERSION = "1.0";
    /**
     * @doc 站点域名
     */
    public static String DOMAIN = "localhost";
    /**
     * @doc 通信APIKEY
     */
    public static String APIKEY = "public";
    
    /**
     * @doc 消息服务器地址
     */
    public static String HOST = "nextalk.im";
    
    /**
     * @doc 消息服务器端口
     */
    public static int PORT = 8000;

}
