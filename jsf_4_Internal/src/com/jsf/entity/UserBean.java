package com.jsf.entity;

//@ManagedBean

/**
 * JSF 使用 JavaBean 来达到程序逻辑与视图分离的目的，在 JSF 中的 Bean 其角色 是属于 Backing Bean，又称之为 Glue
 * Bean，其作用是在真正的业务逻辑 Bean 及 UI 组件之间搭起桥梁，在 Backing Bean 中会呼叫业务逻辑 Bean 处理使用者的请求，或者
 * 是将业务处理结果放置其中，等待 UI 组件取出当中的值并显示结果给使用者
 * 
 * @author may
 *
 */
public class UserBean {

	private String name;

	private String locale = "en_US";

	private String password;

	private String errMessage;

	public void setName(String name) {
		this.name = name;

	}

	public String getName() {

		return name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String verify() {
		if (name.equals("admin") && password.equals("123")) {

			return "success";
		}

		this.errMessage = "用户名是admin，密码是123";

		return "fail";

	}

}
