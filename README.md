webim-plugin-struts2
====================

This is a webim plugin demo for struts2 web application.

Demo
====

1. Import 'Webim' Project to Eclipse EE.

2. Create Tomcat Server and Run

3. Access: http://localhost:8080/Webim/

Developer Guide
===============

Create Database
---------------

import install.sql

Coding WebimPlugin.java
-----------------------

implements these methods:

```java

1.  public WebimEndpoint endpoint();

2.  public List<WebimEndpoint> buddies(String uid);

3.  List<WebimEndpoint> buddiesByIds(String uid, String[] ids);

4.  public WebimRoom findRoom(String roomId);

5.  public List<WebimRoom> rooms(String uid);

6.  public List<WebimRoom> roomsByIds(String uid, String[] ids);

8.  public List<WebimMember> members(String roomId);

9.  public List<WebimNotification> notifications(String uid);

```

Coding WebimModel.java
-----------------------

1. Histories

2. Settings


Coding Config
-------------

You should change the WebimConfig.java, and load configurations from database or xml.

Webim Javascript
-----------------------

Insert Javascript code below to web pages that need to display Webim:

```javascript

	<script type="text/javascript" src="/Webim/boot.do"></script>

```


