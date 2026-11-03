package com.library.model;

import java.util.ArrayList;

public class Member {
    private final int memberId;
    private final String name;
    private final ArrayList<Book> borrowedBooks;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getMemberId() { return memberId; }
    public String getName() { return name; }
    public ArrayList<Book> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public boolean returnBook(Book book) {
        return borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return String.format("[Member ID: %-3d] %-20s | Books Borrowed: %d",
                memberId, name, borrowedBooks.size());
    }
}