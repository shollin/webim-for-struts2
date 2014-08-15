//custom
(function(webim) {
	var path = _IMC.path;
	webim.extend(webim.setting.defaults.data, _IMC.setting);
    //fix cookie conflict
    webim.status.defaults.key = "_webim_cookie" + _IMC.user.id;
    /*
	if( _IMC.is_visitor ) {
		webim.status.defaults.key = "_webim_v";
	}
    */

	webim.route( {
		online: path + "online.do",
		offline: path + "offline.do",
		buddies: path + "buddies.do",
		remove_buddy: path + "remove_buddy.do",
		deactivate: path + "refresh.do",
		message: path + "message.do",
		presence: path + "presence.do",
		status: path + "status.do",
		setting: path + "setting.do",
		history: path + "history.do",
		clear: path + "clear_history.do",
		download: path + "download_history.do",
        //room actions
		invite: path + "invite.do",
		join: path + "join.do",
		leave: path + "leave.do",
		block: path + "block.do",
		unblock: path + "unblock.do",
		members: path + "members.do",
        //notifications
		notifications: path + "notifications.do",
        //upload files
		upload: path + "upload.do"
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
		//layout: "layout.popup",
        layoutOptions: {
            unscalable: _IMC.is_visitor
        },
		buddyChatOptions: {
            downloadHistory: !_IMC.is_visitor,
			//simple: _IMC.is_visitor,
			upload: _IMC.upload && !_IMC.is_visitor
		},
		roomChatOptions: {
            downloadHistory: !_IMC.is_visitor,
			upload: _IMC.upload
		}
	}), im = ui.im;
    //全局化
    window.webimUI = ui;

	if( _IMC.user ) im.setUser( _IMC.user );
	if( _IMC.menu ) ui.addApp("menu", { "data": _IMC.menu } );
	if( _IMC.enable_shortcut ) ui.layout.addShortcut( _IMC.menu );

	ui.addApp("buddy", {
		showUnavailable: _IMC.show_unavailable,
		is_login: _IMC['is_login'],
		disable_login: true,
		collapse: false,
		//disable_user: _IMC.is_visitor,
        //simple: _IMC.is_visitor,
		loginOptions: _IMC['login_options']
	});
    if(!_IMC.is_visitor) {
        if( _IMC.enable_room )ui.addApp("room", { discussion: (_IMC.discussion && !_IMC.is_visitor) });
        if(_IMC.enable_noti )ui.addApp("notification");
    }
    if(_IMC.enable_chatlink) ui.addApp("chatbtn");
    ui.addApp("setting", {"data": webim.setting.defaults.data, "copyright": true});
	ui.render();
	_IMC['is_login'] && im.autoOnline() && im.online();
})(webim);
