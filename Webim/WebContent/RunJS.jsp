<%@ page language="java" contentType="text/javascript"
    pageEncoding="UTF8"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
    
    var _IMC = {
	            production_name: 'struts2',
	            version: '1.0',
	            path: '/Webim/',
	            is_login: true,
	            user: '',
	            setting: '{}',
	            menu: '',
	            enable_chatlink: <s:property value="enable_chatlink" />,
	            enable_shortcut: <s:property value="enable_shortcut" />,
	            enable_menu: <s:property value="enable_menu" />,
	            enable_room: <s:property value="enable_room" />,
	            enable_noti: <s:property value="enable_noti" />,
	            theme: '<s:property value="theme" />',
	            local: '<s:property value="local" />',
	            opacity: <s:property value="opacity" />,
	            show_unavailable: <s:property value="show_unavailable" />,
	            min: window.location.href.indexOf("webim_debug") != -1 ? "" : ".min"
            };
            
            _IMC.script = window.webim ? '' : ('<link href="' + _IMC.path + 'static/webim.'+ _IMC.production_name + _IMC.min + '.css?' + _IMC.version + '" media="all" type="text/css" rel="stylesheet"/><link href="' + _IMC.path + 'static/themes/' + _IMC.theme + '/jquery.ui.theme.css?' + _IMC.version + '" media="all" type="text/css" rel="stylesheet"/><script src="' + _IMC.path + 'static/webim.' + _IMC.production_name + _IMC.min + '.js?' + _IMC.version + '" type="text/javascript"></script><script src="' + _IMC.path + 'static/i18n/webim-' + _IMC.local + '.js?' + _IMC.version + '" type="text/javascript"></script>');
            _IMC.script += '<script src="' + _IMC.path + 'static/webim.js?' + _IMC.version + '" type="text/javascript"></script>';
            document.write( _IMC.script );
            
