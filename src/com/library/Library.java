package com.library;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public ArrayList<Member> getMembers() {
        return members;
    }

    public Member findMemberById(int id) {
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    public void removeMember(int id) {
        for (Member member : members) {
            if (member.getId() == id) {
                members.remove(member);
                return;
            }
        }
    }
    // Constructor
    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    // ================= BOOK METHODS =================

    // Add Book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    // Get all books
    public ArrayList<Book> getBooks() {
        return books;
    }

    // Find book by ID
    public Book findBookById(int id) {

        for (Book book : books) {

            if (book.getId() == id) {
                return book;
            }
        }

        return null;
    }

    // View Books
    public void viewBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\n========== BOOK LIST ==========");

        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Search Book
    public void searchBook(String keyword) {

        boolean found = false;

        for (Book book : books) {

            if (book.getTitle().toLowerCase()
                    .contains(keyword.toLowerCase())
                    || book.getAuthor().toLowerCase()
                    .contains(keyword.toLowerCase())) {

                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    // Remove Book
    public void removeBook(int id) {

        Book book = findBookById(id);

        if (book != null) {
            books.remove(book);
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    // ================= MEMBER METHODS =================

    // Add Member
    public void addMember(Member member) {
        members.add(member);
        System.out.println("Member added successfully.");
    }

    // View Members
    public void viewMembers() {

        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }

        System.out.println("\n========== MEMBER LIST ==========");

        for (Member member : members) {
            System.out.println(member);
        }
    }

    // ================= ISSUE / RETURN =================

    // Issue Book
    public void issueBook(int bookId) {

        Book book = findBookById(bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (book.isAvailable()) {

            book.setAvailable(false);
            System.out.println("Book issued successfully.");

        } else {

            System.out.println("Book is already issued.");
        }
    }

    // Return Book
    public void returnBook(int bookId) {

        Book book = findBookById(bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!book.isAvailable()) {

            book.setAvailable(true);
            System.out.println("Book returned successfully.");

        } else {

            System.out.println("Book is already available.");
        }
    }
}