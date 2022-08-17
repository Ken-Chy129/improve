package mystream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Ken-Chy129
 * @date 2022/7/21 22:17
 */
public class Test01 {
    public static void main(String[] args) {
        String s = "hello";
        
        Stream<String> s1 = Stream.of(s);
        System.out.println(s1.filter(Predicate.not(Predicate.isEqual("h"))).count());
        // 流已经用过，则无法再次使用，再次操作则会报错：stream has already been operated upon or closed
//        System.out.println(s1.filter(new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.equals("hello");
//            }
//        }).count());
        System.out.println(Stream.of("a","b","c").filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.equals("hello");
            }
        }).count());
        // generate方法接收一个不包含任何引元的函数，iterate接收一个种子和函数，两次都产生无限流
        System.out.println(Stream.generate(() -> "helo").limit(10).collect(Collectors.toList()));
        System.out.println(Stream.generate(Math::random).limit(19).sorted().collect(Collectors.toList()));
        System.out.println(Stream.iterate(10, n-> n<100,n -> n+1).collect(Collectors.toList()));
        System.out.println(Stream.ofNullable(s).count());

        System.out.println(Arrays.toString(Stream.of(s).map(String::toUpperCase).toArray()));
        System.out.println(s);
        int[] a = {1,2,3};
    }
}
