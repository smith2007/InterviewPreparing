package core;

public class OverridingOverloadingTest {

    class Parent {

        String method1() throws Exception {
            return null;
        }

    }

    class Child extends Parent {

        @Override
        String method1() {
            return null;
        }
    }
}
