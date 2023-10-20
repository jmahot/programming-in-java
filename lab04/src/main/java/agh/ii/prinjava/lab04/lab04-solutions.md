Name : Julie MAHOT

Group : 2

Exercises LAB 4 - Programming in Java
===


## 2) Generic methods, classes, and interfaces

    Analyse the source code in packages:
    lst04_01
    lst04_02
    lst04_03

---
### Exercise 1 :

    Explain the benefits of using generic types

1. Code Reuse: We can write a method/class/interface once and use it for any type we want.

2. Type Safety: Generics make errors to appear compile time than at run time 
(It’s always better to know problems in your code at compile time rather than making your code fail at run time). 
Suppose you want to create an ArrayList that store name of students, and if by mistake the programmer adds an integer object instead of a string, the compiler allows it. 
But, when we retrieve this data from ArrayList, it causes problems at runtime.

---
### Exercise 2 :

    Explain the syntax of 'generic class declaration' and 'generic method declaration'


- **Generic Class Declaration** : To declare a generic class, you use angle brackets with a type parameter. For example :

```java
class MyGenericClass <T> {
    // Class content
}
```
Here, `<T>` is the type parameter that can represent any data type.

and to create an instance of generic class, we use the following syntax :
`` BaseType <Type> obj = new BaseType <Type>() ``

- **Generic Method Declaration** : To declare a generic method, you also use angle brackets with a type parameter just before the return type. For example :

```java
<T> returnType myGenericMethod(T parameter) {
    // Method code
}
```
In a generic method, `<T>` is the type parameter for the generic method that you specify when calling the method. It lets you work with different data types within the same method.

---
### Exercise 3 :

    Explain what a raw type is, why it is unsafe, and why the raw types are allowed in Java

A raw type in Java is a generic type used without specifying a data type. 
It's unsafe because it doesn't get the benefits of compile-time type checking, potentially leading to runtime errors. 
Java allows raw types for compatibility with pre-generic code, but it sacrifices type safety.

---
### Exercise 4 :

```java
Given GenBox as defined in lst04_01 explain the compilation result of :
        
// (a)
GenBox gb1 = new GenBox(1);
gb1.setX("abc");
gb1.setX(new GenBox(true));

// (b)
GenBox<Integer> gb2 = new GenBox(1);
gb2.setX("abc");
gb2.setX(new GenBox(true));
```

(a) The code compiles without errors, but it generates warnings about unchecked or unsafe operations. 
This is because you're using raw types, which can lead to type-related issues at runtime.

(b) The code compiles without errors or warnings. 
This is because you're using a specific type parameter (Integer) for the GenBox, ensuring type safety when setting the value of "x."

---
### Exercise 5 :

```java
[c] Complete the method header in the following code so that it compiles:

public class Main {
    public static void main(String[] args ) {
        Integer[] ints = {1, 2, 3};
        String[] strs = {"A", "B", "C"};

        print(ints);
        print(strs);
    }

    public static <T> void print(T[] elems) {   // <-- completed line
    for (int i = 0; i < elems.length; i++)
        System.out.print(elems[i] + " ");
    System.out.println();
    }
}
```

### Exercise 6 :

    [c] Refactor the source code to one file-one class structure

### Exercise 7 :

    [c] Implement the generic class Pair<F,S> (see exc04_01):

    - add at least one constructor (two parameters: F fst and S snd)
    - add the accessors ("getters") and mutators ("setters")
    - add toString, equals, hashCode
    - add clone method
    - add unit tests

---
## 3) Bounds for type variables

    Analyse the source code in packages:
    lst04_04
    lst04_05

---
### Exercise 1 :

    Explain the purpose of bounds for type variables

Bounds for type variables serve to restrict the types that can be used with generics, 
ensuring that the type variable is compatible with specific types or interfaces. 
They provide more precise type checking and enable certain operations on the type variable.

---
### Exercise 2 :

    Check if a type variable may have many interface bounds. Repeat this for class bounds.

A type variable may have many interface bounds, but it can extend only one class.

---
### Exercise 3 :

[c] Changed the given generic function so that it compiles :

```java
// bound for the type variable
interface Moveable {
    void goTo(double x, double y);
}

// Moving all elements of the array to point (x,y)
private static <T extends Moveable> void moveAll(T[] elems, double x, double y) {
    for (var e : elems) {
        e.goTo(x, y);
    }
}
```

This modification ensures that the type variable "T" must implement the "Moveable" interface, 
allowing the "goTo" method to be called within the function.

---
## 4) Subtyping and Wildcards

    Analyse the source code in package lst04_06

---
### Question 1 :

    Explain the notions of invariance, covariance, and contravariance of generic types (type constructors)

Generic Types Notions:

- Invariance : Generic types are invariant if they do not allow conversions between different instantiations of the generic type. 

- Covariance : Generic types are covariant if you can assign a more derived (sub)type to a variable of the base (super)type. 

- Contravariance : Generic types are contravariant if you can assign a more base (super)type to a variable of the derived (sub)type. 

### Question 2 :

    Explain the notions of:
        - subtype wildcard
        - supertype wildcard
        - unbounded wildcard


Wildcard Notions:

- **Subtype Wildcard** (? extends T) : 
It represents an unknown subtype of a specific type T. You can read from it, but you cannot write to it. It's useful when you need to work with elements of an unknown subtype.
- **Supertype Wildcard** (? super T) : 
It represents an unknown supertype of a specific type T. You can write to it, but you cannot read from it. It's useful when you need to add elements to a collection with a specific supertype.
- **Unbounded Wildcard** (? or simply T) : 
It's a wildcard that doesn't have an upper or lower bound. It's often used for flexibility when you don't need to read or write specific elements.


### Question 3 :

**Compile correctly :**

    GenBox<B> gb1 = new GenBox<B>();
    B b1 = gb1.getX();
    gb1.setX(new B());
    GenBox<? extends B> gb4 = new GenBox<B>();
    GenBox<? extends B> gb5 = new GenBox<C>();
    GenBox<? extends B> gb6 = new GenBox<A>();
    B b2 = gb5.getX();
    GenBox<? super B> gb7 = new GenBox<B>();
    GenBox<? super B> gb8 = new GenBox<C>();
    GenBox<? super B> gb9 = new GenBox<A>();
    gb9.setX(new B());
    GenBox<?> gb10 = new GenBox<B>();
    GenBox<?> gb11 = new GenBox<C>();
    GenBox<?> gb12 = new GenBox<A>();
    B b4 = gb10.getX();

**Do Not Compile and Explanation :**

    GenBox<B> gb2 = new GenBox<C>();
Does not compile. This is an example of invariance error. You cannot assign a more derived type `(GenBox<C>)` to a variable of type `GenBox<B>`.

---
    GenBox<B> gb3 = new GenBox<A>();
Does not compile. Another invariance error. You cannot assign a more base type `(GenBox<A>)` to a variable of type `GenBox<B>`.

---
    gb5.setX(new B());
Does not compile. You cannot write to a wildcard with an upper bound as it represents an unknown subtype.

---
    B b3 = gb9.getX();
Does not compile. You cannot assume the exact type when dealing with a wildcard with a lower bound, so it's not safe to assign to B.

---
    gb10.setX(new B());
Does not compile. You cannot write to an unbounded wildcard as it's not specific about the subtype.
