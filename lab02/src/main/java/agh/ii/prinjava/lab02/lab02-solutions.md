Name : Julie MAHOT

Group : 2

# Exercises LAB 2 - Programming in Java

___

## 1) Final variables, methods, and classes

    Analyse the source code in packages:
    lst02_01 (final variables)
    lst02_02 (final methods)
    lst02_03 (final classes)
---
    Exercices

    1. Look briefly at the chapters of Java Language Specification related to final variables, methods, and classes
    2. Explain the benefits of using constants in programming
    3. Explain the meaning of keyword final when used for:
        - local variables
        - instance variables
        - static constants
        - methods
        - classes
    4. Answer the following questions:
        - If a class contains only private data fields and no setter methods, is the class immutable?
        - If all the data fields in a class are private and of primitive types, and the class does not contain any setter methods, is the class immutable?
    5. Explain why the following class is not immutable
            public class C {
               private int[] values;
        
               public int[] getValues() {
                  return values;
               }
            }
    6. [c] Refactor the source code to one file-one class structure

### Question 2 :
**Benefits of using constants in programming**

The benefit of using constants is that the value of the constant won't change after it's been defined, it reduces the risk of accidental modification.

### Question 3 :
**Meaning of the final keyword**

The meaning of keyword ``final`` when used for :
- Local variables : a constant declared inside a method, cannot be reassigned once initialized.
- Instance variables : a constant declared inside a class, cannot be changed after their initial assignment. 
- Static constants : Represents a constant value that cannot be modified. 
- Methods : Indicates that the method cannot be overridden by subclasses. 
- Classes : Prevents the class from being extended (avoid inheritance).

### Question 4 :
**Immutability of classes**

- If a class contains only private data fields and no setter methods, it does not guarantee immutability. 
Other methods or constructors might still modify the internal state of the object.

- If all the data fields in a class are private and of primitive types, and the class does not contain any setter methods, it is more likely to be immutable. 
However, immutability depends on whether any methods or constructors modify the object's state.

### Question 5 :
**Why the class is not immutable**

The class is not immutable because there is a getter method ``getValues()`` that returns a reference to the private `int[] values` array.
This allows external code to modify the internal state of the object by altering the contents of the array, even though the array itself is private.

## 2) Enumeration classes (enums)

    package lst02_04 (enums classes)

---

    Exercises

    1. Look briefly at the chapters of Java Language Specification related to enum classes
    2. Familiarise yourself with java.lang.Enum class
    3. Analyse the following implementation of the singleton design pattern, is this correct ? Thread-safe?
        enum EnumBasedSingleton {
           INSTANCE;
           int value;
           public int getValue() {
              return value;
           }
           public void setValue(int value) {
              this.value = value;
           }
        }
    4. [c] Refactor the source code to one file-one class structure

### Question 3 :

Yes, it is correct and thread-safe because the enum value is instantiated only once.

## 3) Nested classes

    package lst02_05 (nested classes)
---

*Note: nested classes: static and non-static member classes, local classes, and anonymous classes*

    Exercises

    1. Look briefly at the chapters of Java Language Specification related to Nested classes (a static and non-static member classes, local classes, and anonymous classes)
    2. Explain the main differences between the types of nested classes available in Java
    3. Answer the following questions:
        - Can an inner class be used in a class other than the class in which it nests?
        - Can the modifiers public, protected, private, and static be used for inner classes?
    4. [c] Refactor the source code to one file-one class structure

### Question 2 :

**Main differences between types of nested classes in Java**

- **Static Nested Class** : Associated with the outer class but can be instantiated independently. It does not have access to the instance-specific members of the outer class.
- **Non-Static (Inner) Class** : Tightly bound to an instance of the outer class. It has access to all members of the outer class, including instance-specific ones.
- **Local Class** : Defined within a method or block. It's only accessible within that method or block.
- **Anonymous Class** : A type of local class without a name, often used for quick implementations of interfaces or abstract classes.

### Question 3 :

- Yes, an inner class can be used in a class other than the class in which it nests, but you'll need an instance of the outer class to create an instance of the inner class.
- The modifiers public, protected, private, and static can be used for inner classes, influencing their visibility and accessibility.

## 4) Abstract Data Types (abstract classes and interfaces)

    packages :
    lst02_06 (abstract classes)
    lst02_07, lst02_08, lst02_09 (interfaces)

---

    Exercises

    1. Look briefly at the chapters of Java Language Specification related to abstract classes and interfaces
    2. Explain the main differences between abstract classes and interfaces in Java
    3. List possible types of members of Java interfaces
    4. From the following list select the correct definition of an abstract class:

            class A { abstract void m1() {} }
            public class abstract B { abstract void m1(); }
            class C { abstract void m1(); }
            abstract class D { protected void m1(); }
            abstract class E { abstract void m1(); }

    5. From the following list select the correct definition of an interface:

            interface A { void m1() {} }
            abstract interface B { m1(); }
            abstract interface C { abstract void m1() {} }
            interface D { void m1(); }

    6. Explain the output of running the class Main:

            interface A {}
            class C {}
            class D extends C {}
            class B extends D implements A {}

            public class Main {
               public static void main(String[] args) {
                  B b = new B();
                  if (b instanceof A)
                     System.out.println("b is an instance of A");
                  if (b instanceof C)
                     System.out.println("b is an instance of C");
               }
            }

    7. [c] Refactor the source code to one file-one class structure

### Question 2 :

**Main differences between abstract classes and interfaces**

Abstract Class :
- Can have constructors
- Can have instance variables (fields)
- Can have both abstract and concrete (non-abstract) methods
- Supports access modifiers like public, private, protected
- Supports single inheritance (extends one class)

Interface :
- Cannot have constructors
- Can only declare constant variables (public, static, final)
- Can only declare abstract methods (implicitly public and abstract)
- Supports multiple inheritance (implements multiple interfaces)

### Question 3 :

**Possible types of members of Java interfaces**
- Abstract methods (methods without a body)
- Constant variables (public, static, final)
- Default methods (methods with a default implementation)
- Static methods (methods defined at the interface level)

### Question 4 :

The correct definition of an abstract class is :
    
    abstract class E { abstract void m1(); }

### Question 5 :

The correct definition of an interface is :
    
    interface D { void m1(); }

### Question 6 :

The output of running the class Main will be:

    b is an instance of A
    b is an instance of C

Because the class B extends D (which itself extends C) and class B also implements A, therefore the class B is an instance of both A and C.

## 5) Functional interfaces and lambda expressions
    
    packages lst02_10 and lst02_12
---

    Exercises

    1. Look briefly at the chapters of Java Language Specification related to functional interfaces and lambda expressions
    2. Explain the relationship between lambda expressions and functional interfaces
    3. Write functional interfaces that correspond to the following function types:
            - void -> int
            - int -> void
            - int -> int
            - (int, int) -> void
        and then implement them (any implementation that compiles is good) using:
            - anonymous classes
            - lambda expressions
    4. [c] Refactor the source code to one file-one class structure

### Question 2 :

**Relationship between lambda expressions and functional interfaces**

- Functional interfaces are interfaces that have only one abstract method but can have multiple default or static methods.
- Lambda expressions in Java are a concise way to express instances of single abstract method interfaces, which are also known as functional interfaces.
- Lambda expressions provide a way to implement the abstract method of a functional interface without the need to create a separate class or anonymous inner class.


### Question 3 :

**Functional interfaces and their implementations**

In the package ``functional_interface_implementation`` :

````
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
````

## 6) Mini project 02_01 (exc02_01)

---

    [c] The implementation of interface StackOfInts:

    1. Add JavaDoc comments to the interface and all its methods
    2. Add JavaDoc comments to LinkedListBasedImpl (the class itself and all its methods)
    3. Complete the linked list based implementation - LinkedListBasedImpl.
    Notes:
        - use nested class Node as the linked list building block
        - use the simplest possible implementation of the linked list, i.e,
            - it can be unidirectional
            - only two operations are requried: adding and removing an element from the front of the list
    4. Write unit tests for different cases
    5. Add JavaDoc comments to ArrayBasedImpl (to the class itself and all its methods)
    6. Write unit tests for different cases (i.e. apply a TDD-like approach)
    7. Complete the array based implementation - ArrayBasedImpl.
    Notes:
        - it should be an array of integers (int), and not, for instance, ArrayList<Integer>)
        - the size of the array should grow and shrink (according to some strategy) as elements are pushed and popped

