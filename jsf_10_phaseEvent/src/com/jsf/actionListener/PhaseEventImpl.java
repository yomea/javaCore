package com.jsf.actionListener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * jsf1.2的生命周期
 * 在 实时事件 中我们提到，JSF的请求执行到响应，完整的过程会经过六个阶段：
 *  • 回复画面（Restore View） 依客户端传来的 session数据或伺服端上的 session 数据，回复 JSF 画面组件。 
 *  • 套用请求值（Apply Request Values） JSF画面组件各自获得请求中的值属于自己的值，包括旧的值与新的值。
 *  • 执行验证（Process Validations） 转换为对象并进行验证。
 *  • 更新模型值（Update Model Values） 更新 Bean 或相关的模型值。
 *  • 唤起应用程序（Invoke Application）执行应用程序相关逻辑。
 *  • 绘制回应画面（Render Response） 对先前的请求处理完之后，产生画面以响应客户端执行结果。
 *  • 执行以上每个阶段触发的事件
 * @author may
 *
 */
public class PhaseEventImpl implements PhaseListener {

	private static final long serialVersionUID = -5617537772279801631L;

	@Override
	public void afterPhase(PhaseEvent event) {
		System.out.println("afterPhase..." + event.getPhaseId().toString());

	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		System.out.println("beforePhase..." + arg0.getPhaseId().toString());

	}

	@Override
	public PhaseId getPhaseId() {
		/**
		 * 		每个阶段的id
		 * •  PhaseId.RESTORE_VIEW
			•  PhaseId.APPLY_REQUEST_VALUES
			•  PhaseId.PROCESS_VALIDATIONS
			•  PhaseId.UPDATE_MODEL_VALUES
			•  PhaseId.INVOKE_APPLICATION
			•  PhaseId.RENDER_RESPONSE
			•  PhaseId.ANY_PHASE
		 */
		return PhaseId.ANY_PHASE;
	}

}
