import play.templates.JavaExtensions;
import controllers.*;
import models.*;
import java.util.*;
import java.io.*;

public class app_rythm_welcome_html__R_T_C__ extends com.greenlaw110.rythm.template.TagBase {

	@Override public java.lang.String getName() {
		return "welcome";
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
		out().ensureCapacity(5952);

_setRenderProperty("title","Your application is ready !");if ("DEV".equals(_play.mode.toString())) { //line: 3

_startSection("moreStyles");
p("<link rel=\"stylesheet\" href=\"/public/playmanual/manual.css\" type=\"text/css\" media=\"screen\" charset=\""); //line: 137

try{pe(_response_encoding);} catch (RuntimeException e) {handleTemplateExecutionException(e);}  //line: 6
p("\">\n<link rel=\"stylesheet\" href=\"/public/playmanual/wiki.css\" type=\"text/css\" media=\"screen\" charset=\""); //line: 137

try{pe(_response_encoding);} catch (RuntimeException e) {handleTemplateExecutionException(e);}  //line: 7
p("\">"); //line: 137

_endSection(); //line: 8
p("\n<div class=\"wrapper\">\n<div id=\"docSidebar\">\n<div id=\"logo\">\n<img src=\"/public/playmanual/logo.png\">\n<h2 id=\"version\">Play "); //line: 137

try{pe(_play.version);} catch (RuntimeException e) {handleTemplateExecutionException(e);}  //line: 16
p("</h2>\n</div>\n<h2>Browse</h2>\n<ul>\n<li id=\"gotoc\"><a href=\"/@documentation/home\">Local documentation</a></li>\n<li id=\"gotoc\"><a href=\"/@api/index.html\">Browse Java API</a></li>\n</ul>\n<h2>Contents</h2>\n<div id=\"toc\"></div>"); //line: 137
p("\n<h2>Search</h2>\n<p>Get help with google</p>\n<div id=\"searchBox\"><form action=\"http://www.google.com/cse\" id=\"cse-search-box\"><div><input type=\"hidden\" name=\"cx\" value=\"002614023023983855063:jn1mu_7bof0\" /><input type=\"hidden\" name=\"ie\" value=\"UTF-8\" /><input type=\"text\" name=\"q\" size=\"28\" style=\"font-size:14px\"/></div></form><script type=\"text/javascript\" src=\"http://www.google.com/coop/cse/brand?form=cse-search-box&lang=en\"></script></div>\n</div>\n<div id=\"pageContent\">\n<div class=\"wikistyle\">\n<h1>Your new application is ready!</h1>\n<p>\nCongratulation, you've just created a new play application. This page will help you in the few next steps.\n</p>\n<h2><a name=\"why\">Why do you see this page?</a></h2>\n<p>\nThe <strong>conf/routes</strong> file defines a route that tell play to invoke the <strong>Application.index</strong> action\nwhen a browser requests the <strong>/</strong> URI using the <strong>GET</strong> method:\n</p>\n<pre><code># Application home page\nGET / Application.index</code></pre>\n<p>\nSo play has invoked the <strong>controllers&#46;Application&#46;index()</strong> method:\n</p>\n<pre><code>public static void index() {\nrender();}</code></pre>\n<p>\nUsing the <strong>render()</strong> call, this action asks play to display a template. By convention play has\ndisplayed the <strong>app/views/Application/index.html</strong> template:\n</p>\n<pre><code>&#35;{extends 'main.html' /}&#35;{set title:'Home' /}&#35;{welcome /}</code></pre>\n<p>\nThis template extends the <strong>app/views/main.html</strong>, and uses the <strong>&#35;{welcome /}</strong> tag to display this\nwelcome page.\n</p>\n<h2><a name=\"ide\">Need to set up a Java IDE?</a></h2>\n<p>\nYou can start right now to hack your application using any text editor. Any changes will be automatically realoaded at the\nnext page refresh, including modifications made to Java sources files.\n</p>\n<p>\nIf you want to set up your application in <strong>Eclipse</strong>, <strong>Netbeans</strong> or any other Java IDE, check\nthe <a href=\"/@documentation/ide\">Setting up your preferred IDE</a> page.\n</p>\n<h2><a name=\"db\">Need to connect to a database?</a></h2>\n<p>\nYou can quickly set up a developement database (either in memory or written to the filesystem), by adding one of these\nlines to the <strong>conf/application.conf</strong> file:\n</p>\n<pre><code># For a transient in memory database (H2 in memory)\ndb=mem# for a simple file written database (H2 file stored)\ndb=fs</code></pre>\n<p>\nIf you want to connect to an existing <strong>MySQL5 server</strong>, use:\n</p>\n<pre><code>db=mysql:user:pwd@database_name</code></pre>\n<p>\nIf you need to connect to another JDBC compliant database, first add the corresponding driver library to the\n<strong>lib/</strong> directory of your application, and add these lines to the <strong>conf/application.conf</strong> file:\n</p>\n<pre><code>db.url=jdbc:postgresql:database_name\ndb.driver=org.postgresql.Driver\ndb.user=root\ndb.pass=secret</code></pre>\n<h2><a name=\"doc\">Need more help?</a></h2>\n<p>\nWhen your application run in <strong>DEV</strong> mode, you can access directly the current documentation at the\n<a href=\"/@documentation\">/@documentation</a> URL or go to <a href=\"http://www.playframework.org\">http://www.playframework.org</a>.\n</p>\n<p>\nThe <a href=\"http://groups.google.com/group/play-framework\">Play Google Group</a> is where Play users come to seek help, announce projects, and discuss.\nIf you don't have any google account, you can still join the mailing list sending an email to\n<br/><strong>play-framework+subscribe@googlegroups.com</strong>.\n</p>\n</div>\n</div>\n</div>\n</div>\n</div>\n<script type=\"text/javascript\" src=\"/public/playmanual/jquery-1.3.2.min.js\"></script>\n<script type=\"text/javascript\" src=\"/public/playmanual/navigation.js\"></script>"); //line: 137
}else { //line: 134
p("\n<h1>Your application is ready!</h1>"); //line: 137
} //line: 136

		return this;
	}

}
