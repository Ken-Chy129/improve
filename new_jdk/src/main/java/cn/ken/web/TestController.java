package cn.ken.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ken-Chy129
 * @date 2024/8/18
 */
@RestController
public class TestController {

    @GetMapping("get")
    public String get() {
        try {
//            System.out.println(Thread.currentThread());
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "ok";
    }
}
