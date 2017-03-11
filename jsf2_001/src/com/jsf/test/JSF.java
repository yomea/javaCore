package com.jsf.test;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.context.FacesContext;

import org.junit.Test;

/**
 * 在tomcat启动后才能获取到FacesContext，这段代码用当写在action中，由服务器调用
 * @author may
 *
 */
public class JSF {

	@Test
	public void test() {
		FacesContext context = FacesContext.getCurrentInstance();
		ELContext elcontext = context.getELContext();
		Application application = context.getApplication();
		String name = application.evaluateExpressionGet(context, "#{user.name}", String.class);
		System.out.println(name);//获取值
		
		
		//获取值和设置值
		ExpressionFactory factory = application.getExpressionFactory();
		ValueExpression valueExpression = factory.createValueExpression(elcontext, "#{user.name}", String.class);
		name = (String) valueExpression.getValue(elcontext);//获取值
		
		valueExpression.setValue(elcontext, "newName");//设置值
		
		
		//获取方法和调用方法
		//string.class表示返回值，null原本传递的值是一个class数组，表示参数类型
		MethodExpression method = factory.createMethodExpression(elcontext, "#{user.outcome}", String.class, null);
		//null表示Object的数组参数，没有参数那就是写null
		method.invoke(elcontext, null);
		
	}

}
