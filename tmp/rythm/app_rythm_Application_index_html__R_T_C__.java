import play.templates.JavaExtensions;
import controllers.*;
import models.*;
import java.util.*;
import java.io.*;

public class app_rythm_Application_index_html__R_T_C__ extends com.greenlaw110.rythm.template.TagBase {

	@Override public java.lang.String getName() {
		return "Application.index";
	}


	@SuppressWarnings("unchecked") public void setRenderArgs(java.util.Map<String, Object> args) {
		super.setRenderArgs(args);
	}

	@SuppressWarnings("unchecked") @Override public void setRenderArg(String name, Object arg) {
		super.setRenderArg(name, arg);
	}

	@SuppressWarnings("unchecked") public void setRenderArg(int pos, Object arg) {
		int _p = 0;
		if(0 == pos) setRenderArg("arg", arg);
	}



    protected String _msg(String key, Object ... params) {return play.i18n.Messages.get(key, params);}
    protected String _url(String action, Object... params) {return _url(false, action, params);}
   protected String _url(boolean isAbsolute, String action, Object... params) {
       com.greenlaw110.rythm.internal.compiler.TemplateClass tc = getTemplateClass(true);
       boolean escapeXML = (!tc.isStringTemplate() && tc.templateResource.getKey().toString().endsWith(".xml"));
       return new com.greenlaw110.rythm.play.utils.ActionBridge(isAbsolute, escapeXML).invokeMethod(action, params).toString();
   }


	@Override public com.greenlaw110.rythm.utils.TextBuilder build(){
		out().ensureCapacity(1820);
p("<!DOCTYPE html>\n<html lang=\"zh-CN\" >\n<head>\n<meta charset=\"utf-8\">\n<meta name=\"keywords\" content=\"\" />\n<meta name=\"description\" content=\"\" />\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n<meta name=\"HandheldFriendly\" content=\"True\">\n<meta name=\"MobileOptimized\" content=\"320\">\n<meta name=\"format-detection\" content=\"telephone=no\">\n<meta http-equiv=\"cleartype\" content=\"on\">\n<link rel=\"icon\" href=\"http://kdt-static.qiniucdn.com/v2/image/yz_fc.ico\" />\n<title>微店热卖</title>\n<style>\nbody { margin: 0; padding: 0; font-family:Helvetica,\"STHeiti STXihei\",\"Microsoft JhengHei\",\"Microsoft YaHei\",Tohoma,Arial; color:#333;background-color:#eee;-webkit-backface-visibility:hidden;width:100%;height:100%;}\na {\ncolor: #808080; text-decoration: none;\n}\n.btn-main {\ndisplay : inline-block ;\nborder:0;\npadding : 15px 20px;\nfont-size: 1.5em;\nbackground-color: #F14040;\nwidth:80%;\noverflow : visible;\n-webkit-appearance : none;\nheight:13%;\nborder-radius: 8px;\ncolor: #FFF;\nbox-sizing: border-box;\n}\n</style>\n</head>\n<body>\n<div style=\"margin-top:10%;margin-left:auto;margin-right:auto;width:35%;text-align:center; max-width:220px; max-height:220px;\">\n<img src=\"http://img.hot.gara.cc/hot-icon_200.png\" style=\"width:100%;height:100%;\">\n</div>\n<div style=\"text-align:center;font-size:3em;margin-top:1%;\">\n<b>微店</b>热卖\n</div>\n<div style=\"text-align:center;font-size:1.3em;margin-top:0%;\">\n9块9，想不到的低价\n</div>\n<div style=\"text-align:center;margin-top:18%;\">\n<a href=\"http://hot.gara.cc\" class=\"btn btn-main js-app-download\">立即下载，省钱赚钱</a>\n</div>\n<div style=\"text-align:center;font-size:1.2em;margin-top:1%; color:#bbb\">\n超过2千万人的选择\n</div>\n</body>\n</html>"); //line: 55

		return this;
	}

}
