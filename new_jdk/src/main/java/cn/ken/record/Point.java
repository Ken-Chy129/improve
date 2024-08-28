package cn.ken.record;

public record Point(String x, String y) {

    public void test() {
        System.out.println(x + y);
    }
}
