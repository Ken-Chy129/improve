package cn.ken.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * <pre>
 * <p></p>
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2022/8/16 21:39
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("cn.ken.aop")
public class AOPConfig {
    
    public AOPConfig() {
        System.out.println("aop");
    }
    
    @Bean
    public Service getService() {
        return new Service();
    }
    
    @Bean
    public LogAspect getLogAspect() {
        return new LogAspect();    
    }
    
}
