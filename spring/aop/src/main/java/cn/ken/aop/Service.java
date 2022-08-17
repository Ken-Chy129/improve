package cn.ken.aop;

/**
 * <pre>
 * <p></p>
 * </pre>
 *
 * @author <a href="https://github.com/kil1ua">Ken-Chy129</a>
 * @date 2022/8/17 13:51
 */
public class Service {

    public Service(){
        System.out.println("=======Service=======");
    }

    //业务方法
    public int doService(int i) {
        int result=5/i;
        System.out.println("运行doService");
        return result;
    }
}
