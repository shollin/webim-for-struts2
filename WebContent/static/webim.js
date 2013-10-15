//custom
(function(webim){
	var path = _IMC.path;
	webim.extend(webim.setting.defaults.data, _IMC.setting );

	webim.route( {
		online: path + "/online",
		offline: path + "/offline",
		deactivate: path + "/refresh",
		message: path + "/message",
		presence: path + "/presence",
		status: path + "/status",
		setting: path + "/setting",
		history: path + "/history",
		clear: path + "/clearhistory",
		download: path + "/downloadhistory",
		members: path + "/members",
		join: path + "/join",
		leave: path + "/leave",
		buddies: path + "/buddies",
		upload: path + "static/images/upload.php",
		notifications: path + "/notifications"
	} );

	webim.ui.emot.init({"dir": path + "static/images/emot/default"});
	var soundUrls = {
		lib: path + "static/assets/sound.swf",
		msg: path + "static/assets/sound/msg.mp3"
	};
	var ui = new webim.ui(document.body, {
		imOptions: {
			jsonp: _IMC.jsonp
		},
		soundUrls: soundUrls,
		buddyChatOptions: {
			upload: _IMC.upload
		},
		roomChatOptions: {
			upload: _IMC.upload
		}
	}), im = ui.im;

	if( _IMC.user ) im.setUser( _IMC.user );
	if( _IMC.menu ) ui.addApp("menu", { "data": _IMC.menu } );
	if( _IMC.enable_shortcut ) ui.layout.addShortcut( _IMC.menu );

	ui.addApp("buddy", {
		showUnavailable: _IMC.showUnavailable,
		is_login: _IMC['is_login'],
		loginOptions: _IMC['login_options']
	} );
	ui.addApp("room");
	ui.addApp("notification");
	ui.addApp("setting", {"data": webim.setting.defaults.data});
	ui.render();
	_IMC['is_login'] && im.autoOnline() && im.online();
})(webim);
