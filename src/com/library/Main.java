package com.library;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Library library = new Library();

        // Sample Books
        library.addBook(
                new Book(101, "Effective Java", "Joshua Bloch")
        );

        library.addBook(
                new Book(102, "Clean Code", "Robert C. Martin")
        );

        library.addBook(
                new Book(103, "Head First Java", "Kathy Sierra")
        );

        // Sample Member
        library.addMember(
                new Member(
                        1,
                        "Anand",
                        "anand@example.com"
                )
        );

        boolean running = true;

        while (running) {

            System.out.println("\n=================================");
            System.out.println("     LIBRARY MANAGEMENT SYSTEM");
            System.out.println("=================================");

            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Add Member");
            System.out.println("5. View Members");
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            System.out.println("8. Remove Book");
            System.out.println("9. Exit");

            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Book ID: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();

                    Book book = new Book(
                            bookId,
                            title,
                            author
                    );

                    library.addBook(book);
                    break;

                case 2:

                    library.viewBooks();
                    break;

                case 3:

                    System.out.print("Enter title or author to search: ");
                    String keyword = scanner.nextLine();

                    library.searchBook(keyword);
                    break;

                case 4:

                    System.out.print("Enter Member ID: ");
                    int memberId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Member Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Member Email: ");
                    String email = scanner.nextLine();

                    Member member = new Member(
                            memberId,
                            name,
                            email
                    );

                    library.addMember(member);
                    break;

                case 5:

                    library.viewMembers();
                    break;

                case 6:

                    System.out.print("Enter Book ID to issue: ");
                    int issueId = scanner.nextInt();

                    library.issueBook(issueId);
                    break;

                case 7:

                    System.out.print("Enter Book ID to return: ");
                    int returnId = scanner.nextInt();

                    library.returnBook(returnId);
                    break;

                case 8:

                    System.out.print("Enter Book ID to remove: ");
                    int removeId = scanner.nextInt();

                    library.removeBook(removeId);
                    break;

                case 9:

                    running = false;
                    System.out.println("Thank you for using Library Management System.");
                    break;

                default:

                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}