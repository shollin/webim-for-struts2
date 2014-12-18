<%@ page language="java" contentType="text/html" pageEncoding="UTF8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0" name="viewport">
  <title>Webim ChatBox</title>
  <link rel="stylesheet" type="text/css" href="/Webim/static/webim-chatbox.css"/>
  <script type="text/javascript" src="/Webim/static/webim-chatbox.js"> </script>
  </head>
  
  <body id="chatbox">
  <div id="header">
  <img id="avatar" class="avatar" src="<s:property value="avatar" />"></img>
  <h4 id="user"><s:property value="nick" /></h4>
  </div>

  <div id="notice" class="chatbox-notice ui-state-highlight" style="display: none;"></div>
  <div id="content">
  <div id="histories"></div>
  </div>

  <div id="footer">
  <table style="width:100%"><tbody><tr><td width="100%">
  <input type="hidden" id="to" value="<s:property value="uid" />">
  <input type="text" data-inline="true" placeholder="请这里输入消息..." id="inputbox">
  </td></tr></tbody></table>
  </div>
  <script>
  (function(webim, options) {
	var path = options.path || "", suffix = options.suffix || "";
	function url(api) { return path + api + suffix; }
	webim.route({
		online: url("online"),
		offline: url("offline"),
		deactivate: url("refresh"),
		message: url("message"),
		presence: url("presence"),
		status: url("status"),
		setting: url("setting"),
		history: url("history"),
		buddies: url("buddies")
	});
    var im = new webim(null, options);
    var chatbox = new webim.chatbox(im, options);
    im.online();
  })(webim, {touid: '<s:property value="uid"/>', path:'/Webim/', suffix:'.do'});
  </script>
  </body>
</html>
  