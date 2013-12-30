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
package webim.config;

/**
 * ���Ե������ļ���������Ϣ�������ĵ�ַ���˿ڡ�ͨ��domain��apikey��<br>
 * 
 * ��ʽ��Ŀ����Ӧд��XML�ļ�������ݿ��С�
 *      
 * @author Ery Lee <ery.lee @ gmail.com>
 * @since 1.0
 */
public class WebimConfig {


	/**
	 * �Ƿ���
	 */
	public static boolean ISOPEN = true;
	
	
    public static String VERSION = "5.2";
    /**
     * վ������
     */
    public static String DOMAIN = "localhost";
    /**
     * ͨ��APIKEY
     */
    public static String APIKEY = "public";
    
    /**
     * ��Ϣ��������ַ
     */
    public static String HOST = "nextalk.im";
    
    /**
     * ��Ϣ�������˿�
     */
    public static int PORT = 8000;

    /**
     * ����Theme
     */
    public static String THEME = "base";
    
    /**
     * ��������
     */
    public static String LOCAL = "zh-CN";
    
    /**
     * �����
     */
    public static String EMOT = "default";

    /**
     * ������͸����
     */
    public static int OPACITY = 80;
    
    /**
     * Ⱥ������
     */
    public static boolean ENABLE_ROOM = true;

    /**
     * ��ʾ֪ͨ��ť
     */
    public static boolean ENABALE_NOTI = true;

    /**
     * ֧�ֿ�ݹ�����
     */
    public static boolean ENABLE_SHORTCUT = false;
    
    /**
     * ֧����������
     */
	public static boolean ENABLE_CHATLINK = false;
    
    /**
     * ��ʾ�˵���
     */
    public static boolean ENABLE_MENU = false;
    
    /**
     * ��ʾ�����ߺ���
     */
    public static boolean SHOW_UNAVAILABLE = true;
    
    /**
     * ֧�ַÿ�
     */
    public static boolean VISITOR = true;
}

