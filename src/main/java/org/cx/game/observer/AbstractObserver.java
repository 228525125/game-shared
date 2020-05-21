package org.cx.game.observer;

import java.io.Serializable;
import java.util.Observer;

public abstract class AbstractObserver<T> implements Observer, Serializable {
	
	private static final long serialVersionUID = 1L;

	public static final Integer Response_Format_DEFAULT_ID = 1;
	
	/**
	 * 未测试在多人在线的状态下是否异常
	 * 问题：如果同一个线程处理多个游戏实例怎么办？ 
	 * ThreadLocal用于保存某个线程共享变量：对于同一个static ThreadLocal，不同线程只能从中get，set，remove自己的变量，而不会影响其他线程的变量。
	 * JDK建议ThreadLocal定义为private static
	 */
	public static ThreadLocal<StringBuffer> process = new ThreadLocal<StringBuffer>() {
		
		/**
		 * 调用get方法时，当前线程共享变量没有设置，调用initialValue获取默认值！
		 */
		@Override
		protected StringBuffer initialValue() {
			// TODO Auto-generated method stub
			return new StringBuffer();
		}
	};

	/**
	 * 把观察到的结果转换成特定对象
	 * @param info 观察结果
	 * @return
	 */
	protected abstract Object convert(IObservedResult<T> resp);
	
}
