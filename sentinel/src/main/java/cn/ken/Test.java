package cn.ken;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Test {

    public static void main(String[] args) {
        initFlowRules();

        for (int i = 0; i < 10; i++) {
            try (Entry entry = SphU.entry("hello")) {
                // 下面的代码即为被Sentinel保护的资源
                System.out.println("hello");
            } catch (BlockException e) {
                System.out.println("blocked");
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < 5; i++) {
            try (Entry entry = SphU.entry("hello")) {
                // 下面的代码即为被Sentinel保护的资源
                System.out.println("hello");
            } catch (BlockException e) {
                System.out.println("blocked");
            }
        }

        while (true) {

        }
    }

    @SentinelResource("hello")
    public void hello() {
        System.out.println("hello");
    }

    private static void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule("hello");
        // 流量控制的阈值类型（0：线程计数，1：QPS）
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 设置QPS阈值为10
        rule.setCount(5);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
