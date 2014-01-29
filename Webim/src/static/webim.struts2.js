//custom
(function(webim) {
	var path = _IMC.path;
	webim.extend(webim.setting.defaults.data, _IMC.setting);

	webim.route( {
		online: path + "online.do",
		offline: path + "offline.do",
		deactivate: path + "refresh.do",
		message: path + "message.do",
		presence: path + "presence.do",
		status: path + "status.do",
		setting: path + "setting.do",
		history: path + "history.do",
		clear: path + "clear_history.do",
		download: path + "download_history.do",
		members: path + "members.do",
		join: path + "join.do",
		leave: path + "leave.do",
		buddies: path + "buddies.do",
		upload: path + "upload.do",
		notifications: path + "notifications.do"
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
            downloadHistory: !_IMC.is_visitor,
			simple: _IMC.is_visitor,
			upload: _IMC.upload && !_IMC.is_visitor
		},
		roomChatOptions: {
			upload: _IMC.upload
		}
	}), im = ui.im;

	if( _IMC.user ) im.setUser( _IMC.user );
	if( _IMC.menu ) ui.addApp("menu", { "data": _IMC.menu } );
	if( _IMC.enable_shortcut ) ui.layout.addShortcut( _IMC.menu );

	ui.addApp("buddy", {
		showUnavailable: _IMC.show_unavailable,
		is_login: _IMC['is_login'],
		disable_login: true,
		collapse: false,
		disable_user: _IMC.is_visitor,
        simple: _IMC.is_visitor,
		loginOptions: _IMC['login_options']
	});
    if(!_IMC.is_visitor) {
        if( _IMC.enable_room) ui.addApp("room");
        if( _IMC.enable_noti) ui.addApp("notification");
        ui.addApp("setting", {"data": webim.setting.defaults.data});
    }
    ui.addApp("setting", {"data": webim.setting.defaults.data});
	ui.render();
	_IMC['is_login'] && im.autoOnline() && im.online();
})(webim);
