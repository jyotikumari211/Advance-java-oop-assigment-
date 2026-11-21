# Advanced Java OOP Assignment — Non-programming Questions

Answer these 10 hard-level questions in your own words. The answers below are concise study answers; expand them if your teacher expects detailed explanations.

## 1. Differentiate abstraction and encapsulation.
**Answer:** Abstraction exposes essential behaviour while hiding implementation details, commonly through abstract classes and interfaces. Encapsulation bundles state and behaviour and restricts direct access to fields, commonly using `private` fields and public methods. Abstraction focuses on *what* an object does; encapsulation controls *how its state is accessed and changed*.

## 2. Explain compile-time and runtime polymorphism with examples.
**Answer:** Compile-time polymorphism is method overloading: the compiler selects a method based on parameter types and count. Runtime polymorphism is method overriding: the JVM selects the implementation according to the actual object type, such as an `Employee` reference referring to a `FullTimeEmployee` object.

## 3. When should an interface be preferred over an abstract class?
**Answer:** Prefer an interface when unrelated classes need to follow a common capability or contract, or when a class needs to implement multiple types. Prefer an abstract class when related classes share state, constructors, or common implementation. An abstract class can have instance fields and constructors; interfaces can define abstract, default, static and private methods.

## 4. Explain the Liskov Substitution Principle.
**Answer:** Objects of a subclass should be usable wherever objects of its parent type are expected without breaking the program's correctness. A subclass should preserve the expectations and behavioural guarantees of the base class. Violations often occur when an overridden method unexpectedly rejects valid parent-class inputs or weakens guarantees.

## 5. What is the difference between composition and inheritance?
**Answer:** Inheritance models an “is-a” relationship and reuses or specialises a parent type. Composition models a “has-a” relationship by storing references to collaborating objects. Composition generally gives looser coupling and allows behaviour to be changed by replacing collaborators; inheritance is useful for genuine substitutability.

## 6. Explain checked and unchecked exceptions.
**Answer:** Checked exceptions are checked by the compiler and must be caught or declared, for example `IOException`. Unchecked exceptions extend `RuntimeException` and generally represent programming or validation errors, for example `NullPointerException` and `IllegalArgumentException`. Custom checked exceptions can model recoverable domain failures.

## 7. Why are generics useful in Java?
**Answer:** Generics allow classes, interfaces and methods to work with parameterised types while providing compile-time type safety. They reduce explicit casting and catch type errors earlier. For example, `List<String>` prevents non-string values from being added. Java implements generics primarily through type erasure.

## 8. What is a race condition, and how can it be prevented?
**Answer:** A race condition occurs when multiple threads access shared mutable state and the result depends on timing. Prevention techniques include synchronisation, locks, atomic classes, immutable objects, and concurrent collections. The correct choice depends on the data and required performance.

## 9. Compare `ArrayList`, `LinkedList`, `HashSet` and `HashMap`.
**Answer:** `ArrayList` stores an ordered, index-based sequence and offers fast random access. `LinkedList` is a doubly linked list and can efficiently add/remove at its ends, but indexed access is slow. `HashSet` stores unique elements without guaranteed iteration order. `HashMap` stores key-value pairs with unique keys and no guaranteed iteration order.

## 10. Explain SOLID principles.
**Answer:** **S**ingle Responsibility: a class should have one reason to change. **O**pen/Closed: software should be open for extension but closed for modification. **L**iskov Substitution: subtypes should safely replace base types. **I**nterface Segregation: clients should not depend on methods they do not use. **D**ependency Inversion: high-level modules should depend on abstractions, not concrete details.
