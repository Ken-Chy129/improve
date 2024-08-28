package cn.ken.record;

public class RecordTest {

    public static void main(String[] args) {
        Point p = new Point("1", "2");
        System.out.println(p.x());
        p.test();
        Pair<A> pair = new Pair<A>(new A(), new B());
        switch (pair) {
            case Pair<A>(A x, B y):
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + pair);
        }
    }
}

class A {}
class B extends A {}
record Pair<T>(T x, T y) {}