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
public class GuestUser {

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
	
	
}
