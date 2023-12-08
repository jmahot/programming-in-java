Name : Julie MAHOT

Group : 2

Exercises LAB 5 - Programming in Java
===

## 2) `List<E>` and its two implementations: `ArrayList<E>`, `LinkedList<E>`

    Analyse the source code in package lst05_01

### Exercise 1 :

    Suppose `lList` is a LinkedList that contains a million int values. Which of the following two loops will run faster?
``` java
 sum = 0;
 for (int i = 0; i < lList.size(); i++)
     sum += lList.get(i);

 sum = 0;
 for (int e: lList)
     sum += e;
```

The second loop will run faster because it doesn't rely on the LinkedList's size and directly accesses the elements. The first loop traverses the entire list using an index, which, in the worst case, may require iterating through the entire list. In contrast, the second loop uses an enhanced for-loop, which efficiently accesses elements without the need for indexing, resulting in better performance.

### Exercice 2:

    Explain the printout of the following code:
``` java
 List<Integer> l1 = new ArrayList<>(List.of(1,2,3,4,5));
 l1.remove(2);
 System.out.println(l1);
```

In this code, you create an ArrayList, remove an element, and print the result. The l1.remove(2) removes the element at index 2, so it removes the number 3 from the list, and you will get [1, 2, 4, 5] as the output.

### Exercise 3 :

    Explain the printout of the following code:
``` java
    List<Integer> l2 = new ArrayList<>(List.of(1,2,3,4));
    for (int i = 0; i < l2.size(); i++)
        System.out.print(l2.remove(i));
```

The code attempts to remove elements from an ArrayList while using an index-based for-loop (for (int i = 0; i < l2.size(); i++)), which can result in unexpected behavior. This approach might not remove all elements as expected, leading to unpredictable output.

### Exercice 4 :

    Explain the difference between the following pieces of code:

``` java
 Collection<Integer> l1 = new ArrayList<>(List.of(0, 1, 2));
 for (int i = 0; i < 3; i++) {
     System.out.println(l1.remove(i));
 }
 System.out.println(l1);
```

``` java
 List<Integer> l2 = new ArrayList<>(List.of(0, 1, 2));
 for (int i = 0; i < 3; i++) {
     System.out.println(l2.remove(i));
 }
 System.out.println(l2);
```

The main difference between the two code segments is the type declaration (Collection in the first and List in the second) and their impact on element removal. In both cases, the code attempts to remove elements from an ArrayList while iterating. However, the key issue is that as elements are removed, the size of the list changes, code 2 is likely to work as expected due to the use of a List type, whereas Code 1 may result in an IndexOutOfBoundsException.

---
## 3) Iterators, the for-each loop (aka. enhanced for loop), and forEach method

    Analyse the source code in package lst05_02

### Exercise 2 :

    Rewrite the following piece of code
``` java
 List<Integer> lst = List.of(1,2,3,4,5);
 for (int i = 0; i < lst.size(); i++) {
     System.out.println(lst.get(i));
 }
```

 - while loop
```java 
List<Integer> lst = List.of(1, 2, 3, 4, 5);
Iterator<Integer> i = lst.iterator();
while (i.hasNext()) {
System.out.println(i.next());
}
```

 - for loop
```java
List<Integer> lst = List.of(1, 2, 3, 4, 5);
Iterator<Integer> i = lst.iterator();
for (; i.hasNext();) {
    System.out.println(i.next());
}
```

 - enhanced for-loop
```java
List<Integer> lst = List.of(1, 2, 3, 4, 5);
for (int num : lst) {
    System.out.println(num);
}
```
 - forEach loop
```java
List<Integer> lst = List.of(1, 2, 3, 4, 5);
lst.forEach(num -> System.out.println(num));
```

---
## 4) `Queue<E>`, `Dequeue<E>` and their implementations: `PriorityQueue<E>`, and `ArrayDequeue<E>`

    Analyse the source code in package lst05_03

### Exercise 2 :

    Explain the execution result of the following method :

``` java
private static void m() {
    Queue<Integer> pq = new PriorityQueue<>(List.of(6, 1, 5, 3, 4, 2));
    for (int e : pq)
        System.out.print(e + " ");

    System.out.println();

    while (!pq.isEmpty())
        System.out.print(pq.poll() + " ");
}
```

In this method, a PriorityQueue is created with initial elements, and then elements are printed using both a for-each loop and a while loop. The for-each loop will print the elements in arbitrary order, while the while loop will print them in sorted order because it uses pq.poll() to retrieve and remove the elements in ascending order.

---

### 5) `java.lang.Comparable` and `java.util.Comparator`

    Analyse the source code in package lst05_04

## Exercise 2 :

The provided code has an error. You cannot use compareTo on Object directly. To fix it, you should cast the objects to Comparable and then use compareTo like this:

```java
static Object max(Comparable o1, Comparable o2) {
    if (o1.compareTo(o2) >= 0) {
        return o1;
    } else {
        return o2;
    }
}
```

### Exercise 3 :

**3)**
```java
private static void m() {
    String[] cities = {"Copenhagen", "Warsaw", "Budapest"};
    Arrays.sort(cities, (s1, s2) -> Integer.compare(s2.length(), s1.length()));
    System.out.println(Arrays.toString(cities));
}
```

---
## 6) `Set<E>` and its implementations: `HashSet<E>`, `LinkedHashSet<E>`, `TreeSet<E>`, and `EnumSet<E extends Enum<E>>`

### Exercise 1 :

    Explain the key differences between the four implementations of the Set interface

 - HashSet for fast retrieval without caring about order
 - LinkedHashSet to maintain insertion order
 - TreeSet for sorted elements
 - EnumSet when working with enum types efficiently

### Exercise 2 :

    Explain how to compute the union, intersection, and difference of two sets, using just the methods of the Set interface and without using loops

 - union :

```java
Set<T> set1 = ...; 
Set<T> set2 = ...; 

Set<T> union = new HashSet<>(set1);
union.addAll(set2);
```

 - intersection :

```java
Set<T> set1 = ...; 
Set<T> set2 = ...; 

set1.retainAll(set2);
```

 - difference :

```java
Set<T> set1 = ...; 
Set<T> set2 = ...; 

set1.removeAll(set2);
```

### Exercise 3 :

    Write a function that takes a TreeSet of strings and returns a new TreeSet with each string being transformed to uppercase

```java
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static TreeSet<String> transformToUppercase(TreeSet<String> inputSet) {
        TreeSet<String> result = new TreeSet<>();
        
        for (String str : inputSet) {
            result.add(str.toUpperCase());
        }
        
        return result;
    }

    public static void main(String[] args) {
        TreeSet<String> originalSet = new TreeSet<>();
        originalSet.add("orange");
        originalSet.add("candy");
        originalSet.add("hello");

        TreeSet<String> uppercaseSet = transformToUppercase(originalSet);

        System.out.println("Original Set: " + originalSet);
        System.out.println("Uppercase Set: " + uppercaseSet);
    }
}
```

---
## 7) `Map<K,V>` and its implementations: `HashMap<K,V>`, `LinkedHashMap<K,V>`, `TreeMap<K,V>`, and `EnumMap<K extends Enum<K>,V>`

    Analyse the source code in package lst05_06

### Exercise 1 :

    Explain the key differences between the four implementations of the Map interface

- HashMap for fast access to key-value pairs without requiring a specific order.
- LinkedHashMap for a predictable iteration order (insertion-order or access-order) and potential use in building an LRU cache.
- TreeMap for ordered keys or range-based operations.
- EnumMap for enum constants, offering efficient storage and retrieval.

### Exercise 2 :

    Write a program that reads all words in a file and prints out how often each word occurred. Use a `TreeMap<String, Integer>`

---
## 8) Selected algorithms from `java.util.Collections` and `java.util.Arrays`

    Analyse the source code in package lst05_07

### Exercise 2 :

Binary search requires sorted data because it relies on comparing elements and repeatedly dividing the search range in half. Without a sorted order, the algorithm cannot make reliable comparisons.

### Exercise 3 :

The main difference is the time complexity: linear search operates at O(n) as it sequentially checks each element, while binary search boasts an O(log n) time complexity by repeatedly halving the search space at each step.

