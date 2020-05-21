package org.cx.game.hystrix;

import java.util.concurrent.Callable;

import org.cx.game.filter.UserContext;
import org.cx.game.filter.UserContextHolder;


public final class DelegatingUserContextCallable<V> implements Callable<V> {
    private final Callable<V> delegate;
    private UserContext originalUserContext;

    /*
     * 原始Callable类将被传递到自定义的Callable类， 
     * 自定义Callable将调用Hystrix保护的代码和来自父线程的UserContext 
     */
    public DelegatingUserContextCallable(Callable<V> delegate,
                                             UserContext userContext) {
        this.delegate = delegate;
        this.originalUserContext = userContext;
    }

    /*
     * call()方法在被@HystrixCommand注解保护的方法之前调用
     * 在call()方法中要做的第一件事是通过UserContextHolder.setContext()方法设置UserContext。
     * 记住，setContext()方法将UserContext对象存储在ThreadLocal变量中，这个ThreadLocal变量特定于正在运行的线程。
     * 设置了UserContext之后，就会调用委托的Callable类的call()方法。
     * 调用delegate.call()会调用由@HystrixCommand注解保护的方法。
     */
    public V call() throws Exception {
        UserContextHolder.setContext( originalUserContext );

        try {
            return delegate.call();
        }
        finally {
            this.originalUserContext = null;
        }
    }

    public static <V> Callable<V> create(Callable<V> delegate,
                                         UserContext userContext) {
        return new DelegatingUserContextCallable<V>(delegate, userContext);
    }
}