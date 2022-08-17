package cn.ken.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <pre>
 * <p></p>
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2022/8/17 13:55
 */
public class AopTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AOPConfig.class);
        Service service = applicationContext.getBean(Service.class);
        System.out.println(service.doService(1));
    }
}
