package cn.ken.sealed;

public class SealedTest {

    public static void main(String[] args) {
        SonClass son = new SonClass();
        son.hello();
        GrandsonClass grandsonClass = new GrandsonClass();
        grandsonClass.hello();
    }
}
