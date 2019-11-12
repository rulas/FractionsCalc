## Coding Challenge
 
Write a command line program in the language of your choice that will take operations on fractions as an input and produce a fractional result.

- Legal operators shall be *, /, +, - (multiply, divide, add, subtract)
- Operands and operators shall be separated by one or more spaces
- Mixed numbers will be represented by whole_numerator/denominator. e.g. "3_1/4"
- Improper fractions and whole numbers are also allowed as operands 


### Example run:
```
? 1/2 * 3_3/4
= 1_7/8
 
? 2_3/8 + 9/8
= 3_1/2
```

## Requirements
Java 1.8
```
$ java -version
java version "1.8.0_231"
Java(TM) SE Runtime Environment (build 1.8.0_231-b11)
Java HotSpot(TM) 64-Bit GraalVM EE 19.2.1 (build 25.231-b11-jvmci-19.2-b03, mixed mode)
```

Maven
```
 130 ❯ mvn -version
Apache Maven 3.5.4 (1edded0938998edf8bf061f1ceb3cfdeccf443fe; 2018-06-17T13:33:14-05:00)
Maven home: /opt/apache-maven-3.5.4
Java version: 1.8.0_231, vendor: Oracle Corporation, runtime: /Library/Java/JavaVirtualMachines/graalvm-ee-19.2.1/Contents/Home/jre
Default locale: en_MX, platform encoding: UTF-8
OS name: "mac os x", version: "10.14.6", arch: "x86_64", family: "mac"
```

## Running all tests
```
mvn clean install
```

## Running the application
```
$ java -jar target/frac-calc-1.0-SNAPSHOT.jar
? 1/2 * 3_3/4
Nov 12, 2019 1:26:31 AM com.onelogin.challenges.FracCalculator calc
INFO: Processing these operations: 1/2 * 3_3/4
= 1_7/8

$ java -jar target/frac-calc-1.0-SNAPSHOT.jar
? 2_3/8 + 9/8
Nov 12, 2019 1:29:01 AM com.onelogin.challenges.FracCalculator calc
INFO: Processing these operations: 2_3/8 + 9/8
= 3_1/2
```

