Name : Julie MAHOT

Group : 2

Exercises LAB 6 - Programming in Java
===
---
## 1) Functional interfaces, lambda expressions and method references


    Analyse the source code in package lst06_01

### Exercise 1.1 :

    Explain the following concepts: functional interface, lambda expression, and method reference

- Functional Interface: It's an interface with a single abstract method. It's crucial for lambda expressions and functional programming in Java.

- Lambda Expression: It's a concise way to express anonymous methods. It's particularly useful for implementing functional interfaces.

- Method Reference: It's a shorthand notation for lambda expressions to call a method. It simplifies code when referring to existing methods.

### Exercise 1.2 :

Lambda Expressions:

- f1(x) = x - 2;
 ```java
Function<Integer, Integer> f1 = x -> x - 2;
```

- f2(x, y) = sqrt(x^2 + y^2);

```java
Function<CustomClass, Double> f2 = obj -> Math.sqrt(obj.getX() * obj.getX() + obj.getY() * obj.getY());
```

- f3(x, y, z) = sqrt(x^2 + y^2 + z^2);

```java
Function<CustomClass3D, Double> f3 = obj -> Math.sqrt(obj.getX() * obj.getX() + obj.getY() * obj.getY() + obj.getZ() * obj.getZ());
```

### Exercise 1.3 :
    Write and test anonymous functions corresponding to: sqrt, abs, log, id

```java
Function<Double, Double> sqrt = Math::sqrt;
Function<Double, Double> abs = Math::abs;
Function<Double, Double> log = Math::log;
Function<Double, Double> id = x -> x;
```

### Exercise 1.4 :

```java

Function<String, Integer> f1 = String::length;
Function<Integer, String> f2 = String::valueOf;
Function<Double, Double> f3 = Math::sqrt;
Function<Integer, Boolean> f4 = x -> x > 0;
Function<Boolean, Integer> f5 = b -> b ? 1 : 0;
Function<Boolean, Boolean> f6 = b -> !b;
```
---
## 2) Standard functional interfaces
    Analyse the source code in package lst06_02


### Exercise 2.2 :

Examples for standard functional interfaces:

```java
BiConsumer<String, String> bc = (s1, s2) -> System.out.println(s1 + " " + s2);
BiFunction<Integer, String, String> bf = (i, s) -> i + s;
BinaryOperator<Integer> bo = Integer::sum;
```

### Exercise 2.3 :
    Explain the rationale behind the primitive type specialisations of the standard generic functional interfaces (e.g., BooleanSupplier, DoubleConsumer)

Rationale behind primitive type specializations :

- Java provides specialized functional interfaces for primitive types (e.g., IntConsumer, DoubleSupplier) to avoid the overhead of autoboxing and unboxing that occurs when using generic interfaces with wrapper classes (e.g., Consumer<Integer>).
- Using primitive types directly improves performance and reduces memory overhead. For example, IntConsumer directly takes an int instead of an Integer. This is especially important in performance-critical scenarios.

---
## 3) Higher-order functions
    Analyse the source code in package lst06_03

## Exercise 1 :

**Using sumOfWith :**
```java
import java.util.stream.IntStream;

public class SumExample {
    public static void main(String[] args) {
        int result = IntStream.rangeClosed(1, 15)
                .sumOfWith(i -> Math.pow(i, 5));
        System.out.println("Sum: " + result);
    }
}
```

## Exercise 3 :

```java
import java.util.function.DoubleUnaryOperator;

public class DerivativeApproximation {
    public static void main(String[] args) {
        DoubleUnaryOperator f = x -> x * x; 
        double x0 = 2.0;
        double h = 0.001;

        DoubleUnaryOperator derivative = dfr(f, h);
        
        double result = derivative.applyAsDouble(x0);
        System.out.println("Approximation of f'(" + x0 + "): " + result);
    }

    static DoubleUnaryOperator dfr(DoubleUnaryOperator f, double h) {
        return x -> (f.applyAsDouble(x + h) - f.applyAsDouble(x)) / h;
    }
}
```

## Exercise 5 :

  `Analyse and test the following method:`

    private static <T, R> List<R> applyAll(List<Function<T, R>> fs, T x0) {
    List<R> ys = new ArrayList<>();
    
         for (var f : fs) {
             ys.add(f.apply(x0));
         }
    
         return Collections.unmodifiableList(ys);
    }

The method applyAll takes a list of functions and a value x0, applies each function to x0, collects the results into a list, and returns an unmodifiable version of that list. 
It's a way to apply multiple functions to a common input and get a list of results. 

---
## 4) Function composition
    Analyse the source code in package lst06_04

## Exercise 1 :
**N°1 :**
```java
import java.util.function.Function;

public class FunctionCompositionExample {
public static void main(String[] args) {
Function<Double, Double> f1 = x -> 2 * x;

        Function<Double, Double> g1 = x -> x * x;
        
        Function<Double, Double> composition1 = f1.compose(g1);
        
        double result1 = composition1.apply(3.0); // (2 * (3^2)) = 18.0
        System.out.println("(f1 ∘ g1)(3.0) = " + result1);
    }
}
```
**N°2 :**

```java
import java.util.function.Function;

public class FunctionCompositionExample {
    public static void main(String[] args) {
        // Function f2(x) = sin(x)
        Function<Double, Double> f2 = Math::sin;

        // Function g2(x) = (1 - x) / (1 + x^2)
        Function<Double, Double> g2 = x -> (1 - x) / (1 + x * x);

        // Composition (f2 ∘ g2)(x)
        Function<Double, Double> composition2 = f2.compose(g2);

        // Test the composition
        double result2 = composition2.apply(0.5); // sin((1 - 0.5) / (1 + 0.5^2)) ≈ 0.6829
        System.out.println("(f2 ∘ g2)(0.5) = " + result2);
    }
}
```

---
## 5) Dealing with optional data
    Analyse the source code in package lst06_05

### Exercise 5.1 :
    Familiarize yourself with class Optional:

Optional is a container object in Java that may or may not contain a non-null value. 
It's often used as a return type where there's a need to represent "no result" without using null, which can lead to errors.

### Exercise 5.2 :
    Describe pros and cons of the following approaches to represent a "no-valid-result" of a function/method:
      -  throwing an exception
      -  returning null
      -  using Optional

**Throwing an exception:**
- Pros: Explicit indication of failure.
- Cons: Can be heavy on performance and can lead to cumbersome error handling.

**Returning null:**
- Pros: Simple indication of no result, no exception handling.
- Cons: Null checks required, potential for NullPointerException, semantics ambiguity.

**Using Optional:**
- Pros: Provides a clear and concise way to represent the absence of a value. Forces explicit handling.
- Cons: Additional object overhead, learning curve for teams unfamiliar with Optional.

### Exercise 5.3 :
    Write three variants of a method that returns the tail of a given list (see headOf_v1, headOf_v2, headOf_v3 in lst01_05)

Method Variants:

- **Approach 1 (headOf_v1):**

    Throws a runtime exception when no valid result can be returned. 
    Example: `String head = headOf_v1(LIST1);`

- **Approach 2 (headOf_v2):**

    Returns null to represent "no result."
    Example: `String head = headOf_v2(LIST1);`

- **Approach 3 (headOf_v3):**

    Uses Optional, the recommended approach in many scenarios.
    Example: `Optional<String> head = headOf_v3(LIST1)`
