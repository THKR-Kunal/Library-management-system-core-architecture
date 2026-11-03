# 📚 Java In-Memory Library Management System

A robust, console-based Library Management System designed to handle core cataloging and operational workflows without external database dependencies. Built using pure Core Java, the system implements an optimized, in-memory data architecture centered around dynamic `ArrayList` data structures, ensuring high data locality, predictable access times, and strict encapsulation.

---

### ⚙️ Core Architecture & Highlights

* **Dynamic In-Memory Catalog Engine:** Utilizes Java `ArrayList` collections to facilitate dynamic data sizing, enabling real-time book registration, updates, and removal without static array boundaries or memory reallocation bottlenecks.
* **Predictable Lookups & Fast Traversals:** Implements clean search and filtering routines (by ISBN, title, and author) using direct indexed iteration and continuous heap allocation.
* **Strict OOP Design:** Built following fundamental Object-Oriented principles (Encapsulation, Polymorphism, Abstraction), decoupling the data layer (`Book`, `Patron`) from the transaction and validation services.
* **State & Transaction Integrity:** Enforces validation logic during borrow/return cycles to prevent catalog desynchronization, double allocations, or out-of-bounds pointer states.

---

### 🛠️ Key Capabilities

- **Inventory Tracking:** Real-time stock counting, instant availability status checks, and metadata indexing.
- **Patron Transaction Workflow:** Seamless book check-out and check-in linked directly to patron profile collections.
- **Input Validation & Exception Safety:** Gracefully handles non-existent IDs, invalid inputs, and edge cases to maintain system stability during command-line execution.

---

### 💻 Tech Stack & Concepts

- **Language:** Core Java (JDK 8+)
- **Collections Framework:** `java.util.ArrayList`, `java.util.Iterator`
- **Design Concepts:** Object-Oriented Programming (OOP), In-Memory State Management, Clean Code Architecture

---

## 🏗 Architecture & Class Structure

```mermaid
classDiagram
    direction TB
    class Book {
        -int id
        -String title
        -String author
        -boolean isIssued
        +getId() int
        +getTitle() String
        +getAuthor() String
        +isIssued() boolean
        +setIssued(boolean) void
        +toString() String
    }

    class Member {
        -int memberId
        -String name
        -ArrayList~Book~ borrowedBooks
        +getMemberId() int
        +getName() String
        +getBorrowedBooks() ArrayList~Book~
        +borrowBook(Book) void
        +returnBook(Book) boolean
        +toString() String
    }

    class LibraryManager {
        -ArrayList~Book~ books
        -ArrayList~Member~ members
        +addBook(Book) void
        +registerMember(Member) void
        +issueBook(int, int) boolean
        +returnBook(int, int) boolean
        +searchBook(String) ArrayList~Book~
        +displayAllBooks() void
    }

    class Main {
        +main(String[] args) void
    }

    Main ..> LibraryManager : uses
    LibraryManager o-- Book : manages via ArrayList
    LibraryManager o-- Member : manages via ArrayList
    Member o-- Book : tracks borrowed
