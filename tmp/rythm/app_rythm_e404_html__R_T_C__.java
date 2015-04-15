import play.mvc.Router;
import play.templates.JavaExtensions;
import controllers.*;
import models.*;
import java.util.*;
import java.io.*;

public class app_rythm_e404_html__R_T_C__ extends com.greenlaw110.rythm.template.TagBase {

	@Override public java.lang.String getName() {
		return "e404";
	}

	@Override protected void setup() {
		if (result == null) {result=(play.mvc.results.Result)_get("result");}
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

	protected play.mvc.results.Result result=null; //line: 2
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
		if (null != args && args.containsKey("result")) this.result=(play.mvc.results.Result)args.get("result");
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
		if (_p < l) { Object v = args[_p++]; boolean isString = ("java.lang.String".equals("play.mvc.results.Result") || "String".equals("play.mvc.results.Result")); result = (play.mvc.results.Result)(isString ? (null == v ? "" : v.toString()) : v); }
	}

	@SuppressWarnings("unchecked") @Override public void setRenderArg(String name, Object arg) {
		if ("result".equals(name)) this.result=(play.mvc.results.Result)arg;
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
		if (_p++ == pos) { Object v = arg; boolean isString = ("java.lang.String".equals("play.mvc.results.Result") || "String".equals("play.mvc.results.Result")); result = (play.mvc.results.Result)(isString ? (null == v ? "" : v.toString()) : v); }
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
		out().ensureCapacity(2746);
p("<style type=\"text/css\">\nhtml, body, pre {\nmargin: 0;\npadding: 0;\nfont-family: Monaco, 'Lucida Console';\nbackground: #ECECEC;\n}\nh1 {\nmargin: 0;\nbackground: #AD632A;\npadding: 20px 45px;\ncolor: #fff;\ntext-shadow: 1px 1px 1px rgba(0,0,0,.3);\nborder-bottom: 1px solid #9F5805;\nfont-size: 28px;\n}\np#detail {\nmargin: 0;\npadding: 15px 45px;\nbackground: #F6A960;\nborder-top: 4px solid #D29052;\ncolor: #733512;\ntext-shadow: 1px 1px 1px rgba(255,255,255,.3);\nfont-size: 14px;\nborder-bottom: 1px solid #BA7F5B;\n}\nh2 {\nmargin: 0;\npadding: 5px 45px;\nfont-size: 12px;\nbackground: #333;\ncolor: #fff;\ntext-shadow: 1px 1px 1px rgba(0,0,0,.3);\nborder-top: 4px solid #2a2a2a;\n}\npre {\nmargin: 0;\nborder-bottom: 1px solid #DDD;\ntext-shadow: 1px 1px 1px rgba(255,255,255,.5);\nposition: relative;\nfont-size: 12px;\noverflow: hidden;\n}\npre span.line {\ntext-align: right;\ndisplay: inline-block;\npadding: 5px 5px;\nwidth: 30px;\nbackground: #D6D6D6;\ncolor: #8B8B8B;\ntext-shadow: 1px 1px 1px rgba(255,255,255,.5);\nfont-weight: bold;\n}\npre span.route {\npadding: 5px 5px;\nposition: absolute;\nright: 0;\nleft: 40px;\n}\npre span.route span.verb {\ndisplay: inline-block;\nwidth: 5%;\nmin-width: 50px;\noverflow: hidden;\nmargin-right: 10px;\n}\npre span.route span.path {\ndisplay: inline-block;\nwidth: 30%;\nmin-width: 200px;\noverflow: hidden;\nmargin-right: 10px;\n}\npre span.route span.call {\ndisplay: inline-block;\nwidth: 50%;\noverflow: hidden;\nmargin-right: 10px;\n}\npre:first-child span.route {\nborder-top: 4px solid #CDCDCD;\n}\npre:first-child span.line {\nborder-top: 4px solid #B6B6B6;\n}\npre.error span.line {\nbackground: #A31012;\ncolor: #fff;\ntext-shadow: 1px 1px 1px rgba(0,0,0,.3);\n}\n</style>\n<h1>Action not found</h1>\n<p id=\"detail\">\nFor request '"); //line: 108

try{pe(play.mvc.Http.Request.current());} catch (RuntimeException e) {handleTemplateExecutionException(e);}  //line: 98
p("'\n</p>"); //line: 108
if (Router.routes != null) { //line: 101
p("\n "); //line: 108
_Itr<Router.Route> __v0 = new _Itr(Router.routes); //line: 102
if (__v0.size() > 0) { //line: 102
com.greenlaw110.rythm.runtime.Each.INSTANCE.render(__v0, new com.greenlaw110.rythm.runtime.Each.Looper<Router.Route>(app_rythm_e404_html__R_T_C__.this,197){ //line: 102
	public boolean render(final Router.Route  route, final int  route_size, final int  route_index, final boolean  route_isOdd, final String  route_parity, final boolean  route_isFirst, final boolean  route_isLast, final String  route_sep, final com.greenlaw110.rythm.runtime.Each.IBody.LoopUtils  route_utils) {  //line: 102
p("<pre><span class=\"line\">"); //line: 108

try{pe(route_index);} catch (RuntimeException e) {handleTemplateExecutionException(e);}  //line: 103
p("</span><span class=\"route\"><span class=\"verb\">"); //line: 108

try{pe(route.method);} catch (RuntimeException e) {handleTemplateExecutionException(e);}  //line: 103
p("</span><span class=\"path\">"); //line: 108

try{pe(route.path);} catch (RuntimeException e) {handleTemplateExecutionException(e);}  //line: 103
p("</span><span class=\"call\">"); //line: 108

try{pe(route.action);} catch (RuntimeException e) {handleTemplateExecutionException(e);}  //line: 103
p("</span></span></pre>\n "); //line: 108

	 return true;
	}});
}
 //line: 104
}else { //line: 105
p("\n<h2>No router defined.</h2>"); //line: 108
} //line: 107

		return this;
	}

}
