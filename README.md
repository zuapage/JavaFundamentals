# Java Fundamentals
Java learning repository covering core concepts and practical implementations.

Name: Nazwa Anindya
NIM : 2802554640
## Overview

This repository contains 6 comprehensive assignments demonstrating fundamental Java programming concepts, object-oriented principles, and problem-solving techniques. Each assignment includes theoretical explanation, multiple solution approaches, and production-ready code examples.

---

## Table of Contents

1. [Question 1: Primitive vs Non-Primitive Data Types](#question-1-primitive-vs-non-primitive-data-types)
2. [Question 2: Static vs Non-Static Methods](#question-2-static-vs-non-static-methods)
3. [Question 3: If-Else vs Switch-Case Control Flow](#question-3-if-else-vs-switch-case-control-flow)
4. [Question 4: Array vs ArrayList Comparison](#question-4-array-vs-arraylist-comparison)
5. [Question 5: Two Sum Problem](#question-5-two-sum-problem)
6. [Question 6: Palindrome Number Validator](#question-6-palindrome-number-validator)

---

## Question 1: Primitive vs Non-Primitive Data Types

**Weight:** 10% | **Topic:** Java Fundamentals, Variables, Data Types  
**Learning Outcome:** Understand Java data type system

### Key Concepts

| Aspect | Primitive | Non-Primitive |
|--------|-----------|---------------|
| Storage | Direct value in memory (Stack) | Reference/address to object (Heap) |
| Size | Fixed, determined by type | Dynamic, varies with content |
| Examples | `byte, short, int, long, float, double, boolean, char` | `String, Array, Class, Interface, ArrayList` |
| Access Speed | Very fast (direct access) | Slower (through reference) |
| Methods | None | Contains methods and properties |
| Default Value | Type-dependent (int=0, boolean=false) | `null` |
| Mutability | Directly reassigned | Varies (String immutable, ArrayList mutable) |

### Implementation

**File:** `Question1_DataTypes/DataTypes.java`

**Demonstrates:**
- 8 primitive type examples with values
- 5 non-primitive type implementations
- Memory model comparison (Stack vs Heap)
- Reference behavior difference

**Compile & Run:**
```bash
cd Question1_DataTypes
javac DataTypes.java
java DataTypes
```

**Key Methods:**
- `demonstratePrimitiveTypes()` - Shows all 8 primitive types
- `demonstrateNonPrimitiveTypes()` - Shows String, Array, Class, Interface, ArrayList
- `compareMemoryUsage()` - Demonstrates pass-by-value vs pass-by-reference

---

## Question 2: Static vs Non-Static Methods

**Weight:** 10% | **Topic:** Classes, Objects, Methods  
**Learning Outcome:** Understand method binding and memory allocation

### Key Differences

**Static Methods:**
- Belong to class, not instance
- Loaded once at class initialization
- Accessed via `ClassName.method()`
- No `this` reference
- Cannot access non-static members directly
- Time Complexity: O(1) access

**Non-Static Methods:**
- Belong to instance
- Created per object instantiation
- Accessed via `instance.method()`
- Have `this` reference to current object
- Can access static and non-static members
- Lifetime tied to object lifecycle

### Why main() is Static

The JVM requires an entry point without creating any instance first. If `main()` were non-static:
- JVM would need an instance to call it
- Instance creation requires... `main()` execution
- **Circular dependency → Program cannot start**

### Solution: Yes, non-static main() is syntactically valid but JVM ignores it

```java
// Valid syntax, but JVM won't recognize as entry point
public void main(String[] args) { }

// Solution: Static main() creates instance and delegates
public static void main(String[] args) {
    new App().run(args);
}
```

### Implementation

**File:** `Question2_StaticMethod/StaticVsNonStatic.java`

**Demonstrates:**
- Static method behavior and memory model
- Non-static method instance binding
- Accessibility rules enforcement
- Memory allocation timing

**Compile & Run:**
```bash
cd Question2_StaticMethod
javac StaticVsNonStatic.java
java StaticVsNonStatic
```

**Key Methods:**
- `staticMethod()` - O(1) class-level access
- `nonStaticMethod()` - Instance-specific behavior
- `demonstrateMemoryModel()` - PermGen vs Heap allocation

---

## Question 3: If-Else vs Switch-Case Control Flow

**Weight:** 10% | **Topic:** Control Statements, Selection  
**Learning Outcome:** Optimize conditional logic for performance and readability

### Comparison

| Aspect | If-Else | Switch-Case |
|--------|---------|-------------|
| **Evaluation** | Sequential (top-to-bottom) | Jump table (bytecode optimization) |
| **Logic Type** | Boolean expressions, ranges | Exact value matching |
| **Time Complexity** | O(n) worst case | O(1) average case |
| **Use Case** | Complex conditions, ranges | Discrete categorical values |
| **Readability** | Clear for logic branches | Clean for multiple values |
| **Flexibility** | Supports any boolean logic | Limited to same type |

### Performance Example

```
If-Else: Checks condition1, condition2, condition3... (worst: 3 evaluations)
Switch:  Jumps directly to matching case (always 1 lookup)
```

### Implementation

**File:** `Question3_ControlFlow/ControlFlowComparison.java`

**Demonstrates:**
- Vehicle type classification (motor, mobil, truk)
- Sequential if-else evaluation
- Optimized switch-case routing
- Performance characteristics
- Hybrid approach combining both

**Compile & Run:**
```bash
cd Question3_ControlFlow
javac ControlFlowComparison.java VehicleRegistrationSystem.java
java ControlFlowComparison
java VehicleRegistrationSystem
```

**Key Methods:**
- `determineVehicleTypeIfElse()` - Sequential evaluation
- `determineVehicleTypeSwitchCase()` - Jump table routing
- `classifyVehicle()` - Hybrid approach

---

## Question 4: Array vs ArrayList Comparison

**Weight:** 10% | **Topic:** Collections, Data Structures  
**Learning Outcome:** Choose appropriate collection based on use case

### Detailed Comparison

| Aspect | Array | ArrayList |
|--------|-------|-----------|
| **Size** | Fixed at declaration | Dynamic, auto-growing |
| **Access (get)** | O(1) direct indexing | O(1) with overhead |
| **Insert/Delete** | O(n) requires copy | O(n) elements shift |
| **Memory** | Efficient, no overhead | Overhead for capacity management |
| **Primitives** | Supports `int[], double[]` | Requires `Integer, Double` wrappers |
| **API** | Limited to indexing | Rich API (`add, remove, contains`) |
| **Best For** | Fixed data, performance-critical | Dynamic data, flexibility |

### ArrayList Operations

**Add Operations:**
```java
ArrayList<String> list = new ArrayList<>();
list.add("item1");              // append O(1)
list.add(0, "item0");           // insert O(n)
list.addAll(anotherList);       // bulk add O(k+n)
```

**Remove Operations:**
```java
list.remove(0);                 // by index O(n)
list.remove("item1");           // by value O(n)
list.removeAll(collection);     // bulk remove O(n*m)
list.clear();                   // remove all O(n)
```

### Implementation

**File:** `Question4_ArrayAndCollection/ArrayVsArrayListComparison.java`

**Demonstrates:**
- Array basics and limitations
- ArrayList operations (add, remove, insert, update)
- Comprehensive comparison table (15 aspects)
- Memory usage patterns
- Performance characteristics

**Compile & Run:**
```bash
cd Question4_ArrayAndCollection
javac ArrayVsArrayListComparison.java StudentManagementSystem.java
java ArrayVsArrayListComparison
java StudentManagementSystem
```

**Key Classes:**
- `StudentManagementSystem` - Practical ArrayList usage with CRUD operations
- Demonstrates `add()`, `remove()`, `update()`, `filter()` operations

---

## Question 5: Two Sum Problem

**Weight:** 30% | **Topic:** Data Structures, Algorithms, Exception Handling  
**Learning Outcome:** Solve problems using arrays and optimize with hash tables

### Problem Statement

Given an array of integers `nums` and an integer `target`, return indices of two numbers that add up to `target`.

**Constraints:**
- Exactly one solution exists
- Cannot use same index twice
- Return type must be array of indices

**Example:**
```
Input: nums = [2, 7, 11, 15], target = 9
Output: [0, 1]
Explanation: nums[0] + nums[1] = 2 + 7 = 9
```

### Solutions

**Approach 1: Brute Force**
- Time: O(n²) | Space: O(1)
- Nested loops checking all pairs
- Simple but inefficient for large arrays

**Approach 2: Hash Map (Recommended)**
- Time: O(n) | Space: O(n)
- Single pass with complement lookup
- Optimal for interviews and production

```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[]{map.get(complement), i};
        }
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No solution found");
}
```

### Implementation

**Files:**
- `Question5_TwoSumProblem/TwoSumProblem.java` - Array-based solutions
- `Question5_TwoSumProblem/TwoSumWithArrayList.java` - ArrayList with details

**Demonstrates:**
- Multiple algorithm approaches
- Time/space complexity trade-offs
- Exception handling (empty, null, no solution)
- Performance benchmarking
- Test case validation

**Compile & Run:**
```bash
cd Question5_TwoSumProblem
javac TwoSumProblem.java TwoSumWithArrayList.java
java TwoSumProblem
java TwoSumWithArrayList
```

**Key Methods:**
- `twoSum()` - Brute force O(n²)
- `twoSumOptimized()` - HashMap O(n)
- `twoSumWithDetails()` - Detailed result object
- `findAllPairs()` - Multiple solutions

### Exception Handling

```java
if (nums == null || nums.length < 2) {
    throw new IllegalArgumentException("Array must have at least 2 elements");
}
```

---

## Question 6: Palindrome Number Validator

**Weight:** 30% | **Topic:** Control Flow, Algorithms, Method Reusability  
**Learning Outcome:** Implement control structures and reusable methods

### Problem Statement

Determine if an integer is a palindrome (reads same forwards and backwards).

**Examples:**
```
Input: 121 → Output: true
Input: -121 → Output: false (negative numbers not palindromes)
Input: 10 → Output: false (10 reversed is 01, not equal)
```

### Solutions

**Method 1: Numeric Reversal (Recommended)**
- Time: O(log n) | Space: O(1)
- Extract digits with modulo, rebuild reversed number
- Most efficient, zero extra space

```java
public boolean isPalindrome(int x) {
    if (x < 0) return false;
    int original = x, reversed = 0;
    while (x > 0) {
        reversed = reversed * 10 + x % 10;
        x /= 10;
    }
    return original == reversed;
}
```

**Method 2: Two Pointer String**
- Time: O(n) | Space: O(n)
- Compare characters from both ends
- Easy to understand and maintain

**Method 3: String Reverse**
- Time: O(n) | Space: O(n)
- Most concise, uses StringBuilder
- Best for readability

**Method 4: Optimized Half Reversal**
- Time: O(log n) | Space: O(1)
- Only reverse half the digits
- Most space-efficient

### Control Flow Usage

```java
if (x < 0) {           // Negative check
    return false;
}

while (x > 0) {        // Digit extraction loop
    int digit = x % 10;
    reversed = reversed * 10 + digit;
    x /= 10;
}

if-else for conditionals and loop termination
```

### Implementation

**Files:**
- `Question6_PalindromeNumber/PalindromeNumber.java` - 4 method comparison
- `Question6_PalindromeNumber/PalindromeValidator.java` - Full validator with features

**Demonstrates:**
- Multiple algorithm approaches
- Reusable method pattern
- Detailed result objects
- Range-based palindrome finder
- Comprehensive exception handling
- Edge case validation

**Compile & Run:**
```bash
cd Question6_PalindromeNumber
javac PalindromeNumber.java PalindromeValidator.java
java PalindromeNumber
java PalindromeValidator
```

**Key Methods:**
- `isPalindromeMethod1()` - Numeric reversal O(log n)
- `isPalindromeMethod2()` - Two pointer O(n)
- `isPalindromeMethod3()` - String reverse O(n)
- `isPalindromeOptimized()` - Half reversal O(log n)
- `isPalindromeWithDetails()` - Returns detailed result
- `findPalindromesInRange()` - Batch processing

**Edge Cases Handled:**
- Single digit (0-9) → true
- Negative numbers → false
- Numbers ending with 0 → false
- Large integers (MAX_VALUE)

---

## Repository Structure

```
JavaFundamentals/
├── README.md
├── Question1_DataTypes/
│   └── DataTypes.java
├── Question2_StaticMethod/
│   └── StaticVsNonStatic.java
├── Question3_ControlFlow/
│   ├── ControlFlowComparison.java
│   └── VehicleRegistrationSystem.java
├── Question4_ArrayAndCollection/
│   ├── ArrayVsArrayListComparison.java
│   └── StudentManagementSystem.java
├── Question5_TwoSumProblem/
│   ├── TwoSumProblem.java
│   └── TwoSumWithArrayList.java
└── Question6_PalindromeNumber/
    ├── PalindromeNumber.java
    └── PalindromeValidator.java
```

---

## Setup & Installation

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- IDE: IntelliJ IDEA, Eclipse, or VSCode with Java extension

### Compile

```bash
# Navigate to specific question directory
cd QuestionX_Topic

# Compile all Java files
javac *.java

# Or compile specific file
javac FileName.java
```

### Execute

```bash
# Run specific class
java ClassName

# Example
java TwoSumProblem
java PalindromeValidator
```

---

## Key Learning Concepts

### 1. Data Types & Memory Management
- Stack allocation for primitives
- Heap allocation for objects
- Reference vs value semantics

### 2. Object-Oriented Programming
- Static context vs instance context
- Method binding and dispatch
- Encapsulation and access modifiers

### 3. Control Flow & Algorithms
- Conditional branching (if-else, switch)
- Loop structures (while, for, enhanced for)
- Algorithm optimization techniques

### 4. Collections & Data Structures
- Fixed-size arrays
- Dynamic ArrayList
- Hash-based lookups
- Time/space complexity analysis

### 5. Exception Handling
- Input validation
- Custom error messages
- Try-catch patterns
- Graceful failure handling

### 6. Algorithm Design
- Brute force vs optimized approaches
- Trade-offs (time vs space)
- Algorithmic complexity analysis

---


## License

Educational Use Only

---

## Author Notes

These solutions represent professional Java programming practices suitable for:
- University assessments
- Interview preparation
- Production code review
- Learning reference material