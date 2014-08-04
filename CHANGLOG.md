CHANGELOG
==============================

v5.7 (2014/08/18)
-------------------
* MembersAction.java: 删除ticket属性


v5.6 (2014/07/18)
-------------------
* 升级lib, static到5.6版本
* 修复群成员IE浏览器下无法区分在线、离线
* 修复聊天窗口名稱顯示不完整
* 群組成员（在线、离线、进组、退组）区分开，并以消息记录的形式提示
* 创建组，选择人员时加所属组，按照组排序
* 修复隐身功能实现有问题
* 修复IE打开聊天窗口，直接选择表情。会同时把，“请输入……”一起发送出去
* 修复chatbtn app响应presence变化事件

v5.5 (2014/07/07)
-------------------
* 修改WebimAction中endpoint, client对象的生命周期问题
* 修改LeaveAction.java, 先删除数据库在转发leave消息


v5.4.1 (2014/05/03)
-------------------

* static前端界面升级到5.4
* webim.client库升级到5.4 
* online, join, leave, members接口修改
* block, unblock接口增加
* WebimModel, WebimPlugin重构

v5.2.1 (2014/01/03)
-------------------

* OnlineAction, MessageAction修复时间戳错误

v5.2 (2013/12/31)
-------------------

* 版本号与与消息服务器、java库(webim-java)同步
* Webim通用代码正式打包为WEB-INF/lib/webim-5.2.jar
* JSON库代码正式删除，引入WEB-INF/lib/org.json-20120521.jar
* webim.actions包重命名为webim.struts2.actions
* struts.xml重新配置action
* Index.jsp嵌入javascript地址更新为"/Webim/boot.do"
* WebimClient.online接口、OnlineAction更新
* WebimClient.join接口、 JoinAction更新
* WebimClient.members接口、 MemberAction更新
* WebimService新增newTmpGroup接口
* WebimConfig放入webim.config包
* WebimConfig新增ENABLE_UPLOAD配置
* 新增WebClient.push接口
* 新增WebimClient.presences接口
* RunAction重命名为BootAction
* RunJS.jsp更新为Boot.jsp
* 更新static/静态资源文件
* static/webim.strtus2.js更新静态资源位置URL


v1.3 (2013/12/18)
-----------------------------
* 支持显示离线用户


v1.2 (2013/10/20)
-----------------------------
* 临时讨论组支持 


v1.1 (2013/10/15)
-----------------------------
* 修改群组支持问题


v1.0 (2013/10/10)
-----------------------------
* 首次发布


