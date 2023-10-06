Name : Julie MAHOT

Group : 2

# Exercises LAB 2 - Programming in Java

___

## 1) Java exceptions hierarchy

---

**Throwable, Error vs. Exception; checked vs. unchecked exceptions**
    
    Exercises

    1) Familiarise yourself with The Java Tutorials > Essential Java Classes > Exceptions

    2) Familiarise yourself with the following classes:
        Throwable
            Error
            Exception
                IOException
                RuntimeException

    3) Look briefly at the chapter of Java Language Specification related to Exceptions

## 2) throws, throw, try-catch, try-finally, and try-catch-finally

    Analyse the source code in packages:
    lst03_01 (unchecked exceptions, RuntimeException, Error)
    lst03_02 (checked exceptions, try-catch)
    lst03_03 (try-finally, and try-catch-finally)
---
    Exercises

    1) Look briefly at the chapters of Java Language Specification related to:
        - throws clause
        - throw statement
        - try statement
    2) Explain the differences between checked and unchecked exceptions
    3) Explain the meaning of keywords throw and throws
    4) [c] Refactor the source code to one file-one class structure
    5) [c] Add exception handling to the StackOfInts

### Question 2 :
**Differences between checked and unchecked exceptions**

Checked exceptions must be either caught or declared using the throws keyword in the method signature. 
Unchecked exceptions (RuntimeExceptions) don't need to be explicitly handled or declared.

### Question 3 :
**Meaning of throw and throws:**
- `throw` is used to manually throw an exception in your code. 
- `throws` is used in a method signature to declare the exceptions that the method might throw, indicating that the caller of the method should handle them.

### Question 5 :
**Add exception handling to StackOfInts**

To add exception handling to StackOfInts, we must use the try and catch keywords :

```
try {
  //  Block of code to try
}
catch(Exception e) {
  //  Block of code to handle errors
}
```

## 3) try-with-resources and AutoCloseable interface

    package lst03_04

---
    Exercises

    1) Look briefly at the chapter of Java Language Specification related to try-with-resources
    2) Familiarise yourself with the AutoCloseable interface
    3) [c] Refactor the source code to one file-one class structure

### Question 2 :
**AutoCloseable Interface**

The AutoCloseable interface is a part of Java's standard library. 
It defines a single method, close(), which is used to release resources when an object implementing AutoCloseable is no longer needed. 
It's commonly used in try-with-resources to ensure that resources are properly closed when the try block exits.

## 4) Reading and writing from/to the console

    package lst03_05

---

    Exercises
    1) Look briefly at the content of files: Console.java, System.java, and Scanner.java
    2) Run agh.ii.prinjava.lab03.lst03_05.Main from the (external) console window

## 5) Simple File I/O: text files

    package lst03_06
---
    Exercises

    1) [c] [ optional ] Write a function that counts the number of characters in a given text file
    2) [c] [ optional ] Write a function that counts the number of lines in a given text file
    3) [c] [ optional ] Write a function that concatenates two given files; consider two approaches:
        - the second file is appended to the first one
        - the result is a new file
    4) [c] [ optional ] Write a function that counts the number of words in a given text file
    5) [c] [ optional ] Write a function that counts the number of whitespace characters in a given text file
    6) [c] [ optional ] Write a function that changes, in a given text file, all TAB characters to SPACE characters


## 6) Simple File I/O: binary files

    package lst03_07
---
    
    Exercises

    1) Explain briefly the applications of the following classes:
        - BufferedReader
        - BufferedWriter
        - FileReader
        - FileWriter
        - PrintWriter
        - FileInputStream
        - FileOutputStream
        - DataInputStream
        - DataOutputStream
        - ObjectInputStream
        - ObjectOutputStream
        - Files
        - Path
        - File
    2) [c] Extend the code in lst03_07 to be able to track how many times agh.ii.prinjava.lab03.lst03_07.Main has been executed. Hint: you can store a counter in the file and increment each time this program is executed.

### Question 1 :

- BufferedReader and BufferedWriter: These classes are used for efficient reading and writing of characters. They provide buffering, which reduces the number of I/O operations and improves performance.

- FileReader and FileWriter: These classes are used for reading and writing characters from and to files. They are simple to use but lack the advanced features of BufferedReader and BufferedWriter.

- PrintWriter: This class is used for writing formatted text to a character output stream. It simplifies writing text to files and other character-based destinations.

- FileInputStream and FileOutputStream: These classes are used for reading and writing binary data from and to files.

- DataInputStream and DataOutputStream: These classes are used for converts an input stream and writing primitive data-type values and strings into an output stream.

- ObjectInputStream and ObjectOutputStream: These classes are used for reading and writing Java objects to and from binary streams. They are essential for object serialization and deserialization.

- Files: The Files class provides static methods for working with files and directories. It can be used for various file operations, including reading and writing files, checking file attributes, and more.

- Path: The Path class represents a file or directory path in a platform-independent manner. It's used for working with file paths and performing file operations.

- File: The File class is used to interact with files and directories in the file system. It provides methods for checking file properties, creating and deleting files, and navigating file system structures.


## 7) Java marker interfaces (Cloneable and Serializable)

    packages:
    lst03_08 (marker interface concept)
    lst03_09 (Serializable)
    lst03_10 (Cloneable)
---
    Exercises

    1) Familiarise yourself with the content of Serializable.java and Cloneable.java
    2) [c] Refactor the source code to one file-one class structure.

## 8) Mini project 03_01 (exc03_01)


