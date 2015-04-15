import play.test.Helpers;
import play.templates.JavaExtensions;
import controllers.*;
import models.*;
import java.util.*;
import java.io.*;

public class app_rythm_selenium_html__R_T_C__ extends com.greenlaw110.rythm.template.TagBase {

	@Override public java.lang.String getName() {
		return "selenium";
	}

	@Override protected void setup() {
		if (arg == null) {arg=(String)_get("arg");}
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

	protected String arg=null; //line: 2
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
		if (null != args && args.containsKey("arg")) this.arg=(String)args.get("arg");
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

	@SuppressWarnings("unchecked") public void setRenderArgs(Object... args) {
		int _p = 0, l = args.length;
		if (_p < l) { Object v = args[_p++]; boolean isString = ("java.lang.String".equals("String") || "String".equals("String")); arg = (String)(isString ? (null == v ? "" : v.toString()) : v); }
	}

	@SuppressWarnings("unchecked") @Override public void setRenderArg(String name, Object arg) {
		if ("arg".equals(name)) this.arg=(String)arg;
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
		if (_p++ == pos) { Object v = arg; boolean isString = ("java.lang.String".equals("String") || "String".equals("String")); arg = (String)(isString ? (null == v ? "" : v.toString()) : v); }
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
		out().ensureCapacity(1028);
p("<table cellpadding=\"1\" cellspacing=\"1\" border=\"0\" width=\"100%\" style=\"margin-bottom: 20px\">\n<thead>\n<tr>\n<th colspan=\"3\" style=\"background: #111; color: #fff; padding: 5px\">"); //line: 28

try{pe((null == arg ? "" : "Test"));} catch (RuntimeException e) {handleTemplateExecutionException(e);}  //line: 6
p("</th>\n</tr>\n</thead>\n<tbody>\n "); //line: 28
_Itr<String> __v0 = new _Itr(_body.toString().split("\n")); //line: 10
if (__v0.size() > 0) { //line: 10
com.greenlaw110.rythm.runtime.Each.INSTANCE.render(__v0, new com.greenlaw110.rythm.runtime.Each.Looper<String>(app_rythm_selenium_html__R_T_C__.this,610){ //line: 10
	public boolean render(final String  command, final int  command_size, final int  command_index, final boolean  command_isOdd, final String  command_parity, final boolean  command_isFirst, final boolean  command_isLast, final String  command_sep, final com.greenlaw110.rythm.runtime.Each.IBody.LoopUtils  command_utils) {  //line: 10
if (command.trim().startsWith("//") || command.trim().startsWith("#")) { //line: 11
p("\n<tr>\n<td colspan=\"3\" style=\"font-style:italic; background: #e2e2e2\">${command}</td>\n</tr>\n "); //line: 28
}else { //line: 15
p("\n "); //line: 28
 String[] parts = Helpers.seleniumCommand(command)  //line: 16
; //line: 17
p("  "); //line: 28
if (null != parts && parts.length > 0) { //line: 17
p("\n<tr>\n<td width=\"33%\">"); //line: 28

try{pe((parts[0]));} catch (RuntimeException e) {handleTemplateExecutionException(e);}  //line: 19
p("</td>\n<td width=\"33%\">"); //line: 28

try{pe((parts.length > 1 ? parts[1] : ""));} catch (RuntimeException e) {handleTemplateExecutionException(e);}  //line: 20
p("</td>\n<td>"); //line: 28

try{pe((parts.length > 2 ? parts[2] : ""));} catch (RuntimeException e) {handleTemplateExecutionException(e);}  //line: 21
p("</td>\n</tr>\n "); //line: 28
} //line: 23
p("\n "); //line: 28
} //line: 24
p("\n "); //line: 28

	 return true;
	}});
}
 //line: 25
p("\n</tbody>\n</table>"); //line: 28

		return this;
	}

}
