import play.i18n.Messages;
import play.templates.JavaExtensions;
import controllers.*;
import models.*;
import java.util.*;
import java.io.*;

public class app_rythm_Secure_login_html__R_T_C__ extends app_rythm_Secure__layout_html__R_T_C__ {//<extended_resource_key>/app/rythm/Secure/_layout.html</extended_resource_key>

	@Override public java.lang.String getName() {
		return "Secure.login";
	}

	@Override protected void setup() {
		if (request == null) {request=(play.mvc.Http.Request)_get("request");}
		if (session == null) {session=(play.mvc.Scope.Session)_get("session");}
		if (_rythm == null) {_rythm=(com.greenlaw110.rythm.RythmEngine)_get("_rythm");}
		if (error_parity == null) {error_parity=(java.lang.String)_get("error_parity");}
		if (error == null) {error=(play.data.validation.Error)_get("error");}
		if (params == null) {params=(play.mvc.Scope.Params)_get("params");}
		if (_rythmPlugin == null) {_rythmPlugin=(com.greenlaw110.rythm.play.RythmPlugin)_get("_rythmPlugin");}
		if (_renderArgs == null) {_renderArgs=(play.mvc.Scope.RenderArgs)_get("_renderArgs");}
		if (error_isFirst == null) {error_isFirst=(Boolean)_get("error_isFirst");}
		if (error_index == null) {error_index=(Integer)_get("error_index");}
		if (messages == null) {messages=(play.i18n.Messages)_get("messages");}
		if (lang == null) {lang=(java.lang.String)_get("lang");}
		if (_play == null) {_play=(play.Play)_get("_play");}
		if (error_isLast == null) {error_isLast=(Boolean)_get("error_isLast");}
		if (errors == null) {errors=(java.util.List<play.data.validation.Error>)_get("errors");}
		if (_response_encoding == null) {_response_encoding=(java.lang.String)_get("_response_encoding");}
		if (flash == null) {flash=(play.mvc.Scope.Flash)_get("flash");}
	}

	protected play.mvc.Http.Request request=null;
	protected play.mvc.Scope.Session session=null;
	protected com.greenlaw110.rythm.RythmEngine _rythm=null;
	protected java.lang.String error_parity=null;
	protected play.data.validation.Error error=null;
	protected play.mvc.Scope.Params params=null;
	protected com.greenlaw110.rythm.play.RythmPlugin _rythmPlugin=null;
	protected play.mvc.Scope.RenderArgs _renderArgs=null;
	protected Boolean error_isFirst=false;
	protected Integer error_index=0;
	protected play.i18n.Messages messages=null;
	protected java.lang.String lang=null;
	protected play.Play _play=null;
	protected Boolean error_isLast=false;
	protected java.util.List<play.data.validation.Error> errors=null;
	protected java.lang.String _response_encoding=null;
	protected play.mvc.Scope.Flash flash=null;

	@SuppressWarnings("unchecked") public void setRenderArgs(java.util.Map<String, Object> args) {
		if (null != args && args.containsKey("request")) this.request=(play.mvc.Http.Request)args.get("request");
		if (null != args && args.containsKey("session")) this.session=(play.mvc.Scope.Session)args.get("session");
		if (null != args && args.containsKey("_rythm")) this._rythm=(com.greenlaw110.rythm.RythmEngine)args.get("_rythm");
		if (null != args && args.containsKey("error_parity")) this.error_parity=(java.lang.String)args.get("error_parity");
		if (null != args && args.containsKey("error")) this.error=(play.data.validation.Error)args.get("error");
		if (null != args && args.containsKey("params")) this.params=(play.mvc.Scope.Params)args.get("params");
		if (null != args && args.containsKey("_rythmPlugin")) this._rythmPlugin=(com.greenlaw110.rythm.play.RythmPlugin)args.get("_rythmPlugin");
		if (null != args && args.containsKey("_renderArgs")) this._renderArgs=(play.mvc.Scope.RenderArgs)args.get("_renderArgs");
		if (null != args && args.containsKey("error_isFirst")) this.error_isFirst=(Boolean)args.get("error_isFirst");
		if (null != args && args.containsKey("error_index")) this.error_index=(Integer)args.get("error_index");
		if (null != args && args.containsKey("messages")) this.messages=(play.i18n.Messages)args.get("messages");
		if (null != args && args.containsKey("lang")) this.lang=(java.lang.String)args.get("lang");
		if (null != args && args.containsKey("_play")) this._play=(play.Play)args.get("_play");
		if (null != args && args.containsKey("error_isLast")) this.error_isLast=(Boolean)args.get("error_isLast");
		if (null != args && args.containsKey("errors")) this.errors=(java.util.List<play.data.validation.Error>)args.get("errors");
		if (null != args && args.containsKey("_response_encoding")) this._response_encoding=(java.lang.String)args.get("_response_encoding");
		if (null != args && args.containsKey("flash")) this.flash=(play.mvc.Scope.Flash)args.get("flash");
		super.setRenderArgs(args);
	}

	@SuppressWarnings("unchecked") @Override public void setRenderArg(String name, Object arg) {
		if ("request".equals(name)) this.request=(play.mvc.Http.Request)arg;
		if ("session".equals(name)) this.session=(play.mvc.Scope.Session)arg;
		if ("_rythm".equals(name)) this._rythm=(com.greenlaw110.rythm.RythmEngine)arg;
		if ("error_parity".equals(name)) this.error_parity=(java.lang.String)arg;
		if ("error".equals(name)) this.error=(play.data.validation.Error)arg;
		if ("params".equals(name)) this.params=(play.mvc.Scope.Params)arg;
		if ("_rythmPlugin".equals(name)) this._rythmPlugin=(com.greenlaw110.rythm.play.RythmPlugin)arg;
		if ("_renderArgs".equals(name)) this._renderArgs=(play.mvc.Scope.RenderArgs)arg;
		if ("error_isFirst".equals(name)) this.error_isFirst=(Boolean)arg;
		if ("error_index".equals(name)) this.error_index=(Integer)arg;
		if ("messages".equals(name)) this.messages=(play.i18n.Messages)arg;
		if ("lang".equals(name)) this.lang=(java.lang.String)arg;
		if ("_play".equals(name)) this._play=(play.Play)arg;
		if ("error_isLast".equals(name)) this.error_isLast=(Boolean)arg;
		if ("errors".equals(name)) this.errors=(java.util.List<play.data.validation.Error>)arg;
		if ("_response_encoding".equals(name)) this._response_encoding=(java.lang.String)arg;
		if ("flash".equals(name)) this.flash=(play.mvc.Scope.Flash)arg;
		super.setRenderArg(name, arg);
	}

	@SuppressWarnings("unchecked") public void setRenderArg(int pos, Object arg) {
		int _p = 0;
		if (_p++ == pos) { Object v = arg; boolean isString = ("java.lang.String".equals("play.mvc.Http.Request") || "String".equals("play.mvc.Http.Request")); request = (play.mvc.Http.Request)(isString ? (null == v ? "" : v.toString()) : v); }
		if (_p++ == pos) { Object v = arg; boolean isString = ("java.lang.String".equals("play.mvc.Scope.Session") || "String".equals("play.mvc.Scope.Session")); session = (play.mvc.Scope.Session)(isString ? (null == v ? "" : v.toString()) : v); }
		if (_p++ == pos) { Object v = arg; boolean isString = ("java.lang.String".equals("com.greenlaw110.rythm.RythmEngine") || "String".equals("com.greenlaw110.rythm.RythmEngine")); _rythm = (com.greenlaw110.rythm.RythmEngine)(isString ? (null == v ? "" : v.toString()) : v); }
		if (_p++ == pos) { Object v = arg; boolean isString = ("java.lang.String".equals("java.lang.String") || "String".equals("java.lang.String")); error_parity = (java.lang.String)(isString ? (null == v ? "" : v.toString()) : v); }
		if (_p++ == pos) { Object v = arg; boolean isString = ("java.lang.String".equals("play.data.validation.Error") || "String".equals("play.data.validation.Error")); error = (play.data.validation.Error)(isString ? (null == v ? "" : v.toString()) : v); }
		if (_p++ == pos) { Object v = arg; boolean isString = ("java.lang.String".equals("play.mvc.Scope.Params") || "String".equals("play.mvc.Scope.Params")); params = (play.mvc.Scope.Params)(isString ? (null == v ? "" : v.toString()) : v); }
		if (_p++ == pos) { Object v = arg; boolean isString = ("java.lang.String".equals("com.greenlaw110.rythm.play.RythmPlugin") || "String".equals("com.greenlaw110.rythm.play.RythmPlugin")); _rythmPlugin = (com.greenlaw110.rythm.play.RythmPlugin)(isString ? (null == v ? "" : v.toString()) : v); }
		if (_p++ == pos) { Object v = arg; boolean isString = ("java.lang.String".equals("play.mvc.Scope.RenderArgs") || "String".equals("play.mvc.Scope.RenderArgs")); _renderArgs = (play.mvc.Scope.RenderArgs)(isString ? (null == v ? "" : v.toString()) : v); }
		if (_p++ == pos) { Object v = arg; boolean isString = ("java.lang.String".equals("Boolean") || "String".equals("Boolean")); error_isFirst = (Boolean)(isString ? (null == v ? "" : v.toString()) : v); }
		if (_p++ == pos) { Object v = arg; boolean isString = ("java.lang.String".equals("Integer") || "String".equals("Integer")); error_index = (Integer)(isString ? (null == v ? "" : v.toString()) : v); }
		if (_p++ == pos) { Object v = arg; boolean isString = ("java.lang.String".equals("play.i18n.Messages") || "String".equals("play.i18n.Messages")); messages = (play.i18n.Messages)(isString ? (null == v ? "" : v.toString()) : v); }
		if (_p++ == pos) { Object v = arg; boolean isString = ("java.lang.String".equals("java.lang.String") || "String".equals("java.lang.String")); lang = (java.lang.String)(isString ? (null == v ? "" : v.toString()) : v); }
		if (_p++ == pos) { Object v = arg; boolean isString = ("java.lang.String".equals("play.Play") || "String".equals("play.Play")); _play = (play.Play)(isString ? (null == v ? "" : v.toString()) : v); }
		if (_p++ == pos) { Object v = arg; boolean isString = ("java.lang.String".equals("Boolean") || "String".equals("Boolean")); error_isLast = (Boolean)(isString ? (null == v ? "" : v.toString()) : v); }
		if (_p++ == pos) { Object v = arg; boolean isString = ("java.lang.String".equals("java.util.List<play.data.validation.Error>") || "String".equals("java.util.List<play.data.validation.Error>")); errors = (java.util.List<play.data.validation.Error>)(isString ? (null == v ? "" : v.toString()) : v); }
		if (_p++ == pos) { Object v = arg; boolean isString = ("java.lang.String".equals("java.lang.String") || "String".equals("java.lang.String")); _response_encoding = (java.lang.String)(isString ? (null == v ? "" : v.toString()) : v); }
		if (_p++ == pos) { Object v = arg; boolean isString = ("java.lang.String".equals("play.mvc.Scope.Flash") || "String".equals("play.mvc.Scope.Flash")); flash = (play.mvc.Scope.Flash)(isString ? (null == v ? "" : v.toString()) : v); }
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
		out().ensureCapacity(1170);
p("<div id=\"login\">\n<h1>"); //line: 36
p(Messages.get("secure.title")); //line: 4
p("</h1>\n<form action=\""); //line: 36
p(s().raw(new com.greenlaw110.rythm.play.utils.ActionBridge(false,false).invokeMethod("authenticate", new Object[] {}))); //line: 5
p("\" method=\"post\">\n "); //line: 36
{ //line: 6
	com.greenlaw110.rythm.runtime.ITag.ParameterList _pl = null;  //line: 6
		_invokeTag("authenticityToken", _pl, false); //line: 6
} //line: 6
p("\n "); //line: 36
if (flash.contains("error")) { //line: 8
p("\n<p class=\"error\">\n "); //line: 36
p(Messages.get(flash.get("error"))); //line: 10
p("\n</p>\n "); //line: 36
} //line: 12
p("\n "); //line: 36
if (flash.contains("success")) { //line: 13
p("\n<p class=\"success\">\n "); //line: 36
p(Messages.get(flash.get("success"))); //line: 15
p("\n</p>\n "); //line: 36
} //line: 17
p("\n<p id=\"username-field\">\n<label for=\"username\">"); //line: 36
p(Messages.get("secure.username")); //line: 20
p("</label>\n<input type=\"text\" name=\"username\" id=\"username\" value=\""); //line: 36

try{pe(flash.get("username"));} catch (RuntimeException e) {handleTemplateExecutionException(e);}  //line: 21
p("\" />\n</p>\n<p id=\"password-field\">\n<label for=\"password\">"); //line: 36
p(Messages.get("secure.password")); //line: 24
p("</label>\n<input type=\"password\" name=\"password\" id=\"password\" value=\"\" />\n</p>\n<p id=\"remember-field\">\n<input type=\"checkbox\" name=\"remember\" id=\"remember\" value=\"true\" "); //line: 36

try{pe((flash.get("remember") != null ? "checked=\"true\"" : ""));} catch (RuntimeException e) {handleTemplateExecutionException(e);}  //line: 28
p(" />\n<label for=\"remember\">"); //line: 36
p(Messages.get("secure.remember")); //line: 29
p("</label>\n</p>\n<p id=\"signin-field\">\n<input type=\"submit\" id=\"signin\" value=\""); //line: 36
p(Messages.get("secure.signin")); //line: 32
p("\" />\n</p>\n</form>\n</div>"); //line: 36

		return this;
	}

}
