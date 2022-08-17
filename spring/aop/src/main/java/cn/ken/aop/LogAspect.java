package cn.ken.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * <pre>
 * <p></p>
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2022/8/17 13:52
 */
@Aspect
public class LogAspect {

    public LogAspect() {
        System.out.println("======LogAspects========");
    }

    @Pointcut("execution(* cn.ken.aop.Service.*(..))")
    public void pointCut() {
    }

    /**
     * 在目标方法执行前
     */
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        System.out.println("logStart  开始运行:" + joinPoint.getSignature().getName());
    }

    /**
     * 在目标方法执行后
     */
    @After("pointCut()")
    public void logAfter() {
        System.out.println("logAfter  结束运行");
    }

    /**
     * 方法返回后
     */
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturning(Object result) {
        System.out.println("logReturning  正常返回，结果:" + result);
    }

    /**
     * 出现异常后
     */
    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(Exception exception) {
        System.out.println("logStarException  运行异常:" + exception);
    }

}
