package com.dwr.send_push;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptSessions;

/**
 * dwr的推送技术 类似于websocket技术
 * 
 * @author may
 *
 */
public class JavaChat {

	public void send(String msg) {
		/*过时的写法，不推荐
		 * WebContext wc = WebContextFactory.get();
		 * 
		 * Collection sessions = wc.getAllScriptSessions();
		 * 
		 * ScriptBuffer sb = new ScriptBuffer();
		 * 
		 * sb.appendScript("receiveMessages("); sb.appendScript(msg);
		 * 
		 * sb.appendScript(")"); org.directwebremoting.proxy.dwr.Util util = new
		 * org.directwebremoting.proxy.dwr.Util(sessions);
		 * 
		 * util.addScript(sb);
		 */
		//向所有的打开此页面的标签页发送消息
		Browser.withAllSessions(new Runnable() {

			@Override
			public void run() {
				ScriptSessions.addFunctionCall("receiveMessages", msg);

			}
		});

	}

}
