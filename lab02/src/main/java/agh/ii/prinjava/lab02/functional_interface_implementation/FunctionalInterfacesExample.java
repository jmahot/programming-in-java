package agh.ii.prinjava.lab02.functional_interface_implementation;

public class FunctionalInterfacesExample {

    // Functional interface for void -> int
    interface VoidToIntFunction {
        int apply();
    }

    // Functional interface for int -> void
    interface IntToVoidFunction {
        void apply(int value);
    }

    // Functional interface for int -> int
    interface IntToIntFunction {
        int apply(int value);
    }

    // Functional interface for (int, int) -> void
    interface TwoIntsToVoidFunction {
        void apply(int x, int y);
    }

    public static void main(String[] args) {
        // Using anonymous classes
        VoidToIntFunction anonymousVoidToInt = new VoidToIntFunction() {
            @Override
            public int apply() {
                return 12; // A random int value
            }
        };

        IntToVoidFunction anonymousIntToVoid = new IntToVoidFunction() {
            @Override
            public void apply(int value) {
                System.out.println("Received value: " + value);
            }
        };

        IntToIntFunction anonymousIntToInt = new IntToIntFunction() {
            @Override
            public int apply(int value) {
                return value * 2; // Double the input value
            }
        };

        TwoIntsToVoidFunction anonymousTwoIntsToVoid = new TwoIntsToVoidFunction() {
            @Override
            public void apply(int x, int y) {
                System.out.println("Received values: " + x + ", " + y);
            }
        };

        // Using lambda expressions
        VoidToIntFunction lambdaVoidToInt = () -> 123; // A random int value

        IntToVoidFunction lambdaIntToVoid = value -> System.out.println("Received value: " + value);

        IntToIntFunction lambdaIntToInt = value -> value * 3; // Triple the input value

        TwoIntsToVoidFunction lambdaTwoIntsToVoid = (x, y) -> System.out.println("Received values: " + x + ", " + y);

        // Testing the implementations
        int result1 = anonymousVoidToInt.apply();
        anonymousIntToVoid.apply(12);
        int result2 = anonymousIntToInt.apply(5);
        anonymousTwoIntsToVoid.apply(10, 20);

        int result3 = lambdaVoidToInt.apply();
        lambdaIntToVoid.apply(100);
        int result4 = lambdaIntToInt.apply(7);
        lambdaTwoIntsToVoid.apply(30, 40);

        System.out.println("Result1: " + result1);
        System.out.println("Result2: " + result2);
        System.out.println("Result3: " + result3);
        System.out.println("Result4: " + result4);
    }
}
