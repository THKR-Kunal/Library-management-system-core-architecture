package com.library;

import com.library.model.Book;
import com.library.model.Member;
import com.library.service.LibraryManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        Scanner scanner = new Scanner(System.in);

        // Seed initial data
        manager.addBook(new Book(101, "Clean Code", "Robert C. Martin"));
        manager.addBook(new Book(102, "Effective Java", "Joshua Bloch"));
        manager.addBook(new Book(103, "Design Patterns", "Gang of Four"));
        manager.registerMember(new Member(1, "Alice"));
        manager.registerMember(new Member(2, "Bob"));

        boolean running = true;
        while (running) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. View All Books");
            System.out.println("2. Issue a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Add New Book");
            System.out.println("5. Exit");
            System.out.print("Select an option (1-5): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> manager.displayAllBooks();
                case 2 -> {
                    System.out.print("Enter Book ID: ");
                    int bId = scanner.nextInt();
                    System.out.print("Enter Member ID: ");
                    int mId = scanner.nextInt();
                    if (manager.issueBook(bId, mId)) {
                        System.out.println("Success: Book issued successfully.");
                    } else {
                        System.out.println("Error: Could not issue book. Check availability or IDs.");
                    }
                }
                case 3 -> {
                    System.out.print("Enter Book ID: ");
                    int bId = scanner.nextInt();
                    System.out.print("Enter Member ID: ");
                    int mId = scanner.nextInt();
                    if (manager.returnBook(bId, mId)) {
                        System.out.println("Success: Book returned successfully.");
                    } else {
                        System.out.println("Error: Return rejected. Verify book and member record.");
                    }
                }
                case 4 -> {
                    System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = scanner.nextLine();
                    manager.addBook(new Book(id, title, author));
                    System.out.println("Success: Book added to inventory.");
                }
                case 5 -> {
                    System.out.println("Exiting system. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid selection. Choose between 1 and 5.");
            }
        }
        scanner.close();
    }
}