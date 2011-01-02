public class A {
    public static void main(String[] args) {
        System.out.println("in main");
        new Bar("bar1");
    }
}

class Foo {
    Foo(String foo) {
        System.out.println("Create Foo " + foo);
    }
}

class Bar {
    private Foo f1 = new Foo("f1");
    Bar(String bar) {
        System.out.println("Create Bar " + bar);
    }
    static Foo f2 = new Foo("f2");
}
