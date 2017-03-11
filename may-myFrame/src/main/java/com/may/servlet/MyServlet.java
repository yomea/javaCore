package com.may.servlet;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.may.annotation.Autowire;
import com.may.annotation.Controller;
import com.may.annotation.Repository;
import com.may.annotation.RequestMapper;
import com.may.annotation.RespondBody;
import com.may.annotation.Service;
import com.may.annotation.Transaction;
import com.may.beanScale.BeanScale;
import com.may.contains.Contains;
import com.may.controller.UserController;
import com.may.jackson.JsonUtils;
import com.may.proxy.HandlerImpl;
import com.may.proxy.MyHandler;
import com.may.proxy.MyProxy;
import com.may.service.UserService;
import com.may.service.impl.UserServiceImpl;

public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = -7705115985807616662L;

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		work(req, resp, "delete");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		work(req, resp, "get");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		work(req, resp, "post");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		work(req, resp, "put");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	private void work(HttpServletRequest req, HttpServletResponse resp, String action) {

		String contextPath = req.getServletPath();

		Method method = (Method) Contains.METHODS.get(contextPath);
		Object object = Contains.CONTROLLERS.get(method);

		try {
			Object returnValue = method.invoke(object);
			RespondBody respondBody = method.getAnnotation(RespondBody.class);
			if (respondBody != null) {
				String jsonStr = JsonUtils.objectToJson(returnValue);
				resp.setContentType("application/json;charset=utf-8");
				resp.getWriter().write(jsonStr);
			} else {
				String view = (String) returnValue;
				req.getRequestDispatcher(view).forward(req, resp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// System.out.println(contextPath);

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		String basePackage = config.getInitParameter("basePackage");

		String path = config.getServletContext().getClassLoader().getResource("/").getPath();

		// System.out.println(path);

		List<Class<?>> clazzs = null;
		try {
			clazzs = BeanScale.scaleBean(path, basePackage, config.getServletContext().getClassLoader());

			String mapperPath = "";

			for (Class<?> clazz : clazzs) {
				Controller controller = clazz.getAnnotation(Controller.class);
				Service service = clazz.getAnnotation(Service.class);
				Repository repository = clazz.getAnnotation(Repository.class);
				Object obj = null;
				if (controller != null || service != null || repository != null) {

					obj = clazz.newInstance();
					Contains.BEANS.put(clazz, obj);

				}
				if (null != controller) {
					RequestMapper requestMapper = clazz.getAnnotation(RequestMapper.class);
					if (requestMapper != null) {
						mapperPath = requestMapper.value();
					}

					Method[] methods = clazz.getDeclaredMethods();
					for (Method method : methods) {
						requestMapper = method.getDeclaredAnnotation(RequestMapper.class);
						if (requestMapper != null) {
							String mpath = mapperPath + requestMapper.value();
							Contains.METHODS.put(mpath, method);
							if (Contains.CONTROLLERS.get(method) == null) {
								Contains.CONTROLLERS.put(method, obj);
							}

						}
					}

				}

				// System.out.println(mapperPath);

			}

			setBeanProperty(clazzs, config);

			System.out.println(Contains.BEANS);
			System.out.println(Contains.CONTROLLERS);
			System.out.println(Contains.METHODS);
			UserController obj = (UserController) Contains.BEANS.get(UserController.class);
			System.out.println(obj.getUserService());
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	private void setBeanProperty(List<Class<?>> clazzs, ServletConfig config) {

		try {
			for (Class<?> clazz : clazzs) {
				Field[] fields = clazz.getDeclaredFields();
				Method[] methods = clazz.getDeclaredMethods();

				for (Field field : fields) {
					Autowire autowire = field.getAnnotation(Autowire.class);
					if (autowire != null) {
						Class<?> c = field.getType();
						Object obj = null;
						Object oo = Contains.BEANS.get(clazz);
						for (Class<?> cls : Contains.BEANS.keySet()) {
							if (c.isAssignableFrom(cls)) {
								obj = Contains.BEANS.get(cls);
								break;

							}

						}
						field.setAccessible(true);
						field.set(oo, obj);
					}
				}
				// 表示当前的类是否使用了@transaction默认没有
				boolean flag = false;

				for (Method method : methods) {
					Transaction transaction = method.getAnnotation(Transaction.class);
					if (transaction != null) {
						flag = true;

					}

				}

				if (flag) {

					Object objProxy = MyProxy.newProxyInstance(config.getServletContext().getClassLoader(),
							clazz.getInterfaces(), new HandlerImpl(Contains.BEANS.get(clazz)));

					Contains.BEANS.put(clazz, objProxy);

					flag = false;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		UserService objProxy = (UserService) MyProxy.newProxyInstance(MyServlet.class.getClassLoader(), new Class<?>[] {UserService.class},
				new HandlerImpl(new UserServiceImpl()));
		objProxy.insert();
		objProxy.update();
	}
	
	

}
