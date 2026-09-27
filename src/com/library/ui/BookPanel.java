package com.library.ui;

import com.library.Book;
import com.library.Library;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BookPanel extends JPanel {

    private final Library library;

    private DefaultTableModel tableModel;
    private JTable table;

    // ===== CLASSIC LIBRARY COLORS =====
    private final Color BACKGROUND =
            new Color(246, 240, 226);

    private final Color CARD =
            new Color(255, 251, 240);

    private final Color PRIMARY =
            new Color(126, 83, 43);

    private final Color PRIMARY_DARK =
            new Color(91, 58, 30);

    private final Color GOLD =
            new Color(184, 134, 58);

    private final Color TEXT =
            new Color(55, 43, 32);

    private final Color MUTED =
            new Color(115, 95, 76);

    private final Color BORDER =
            new Color(218, 202, 174);

    public BookPanel(Library library) {

        this.library = library;

        setLayout(new BorderLayout(15, 15));

        setBackground(BACKGROUND);

        setBorder(
                BorderFactory.createEmptyBorder(
                        25, 30, 30, 30
                )
        );

        createUI();
    }

    // =====================================================
    // UI
    // =====================================================

    private void createUI() {

        JPanel topPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT,
                                10,
                                5
                        )
                );

        topPanel.setBackground(
                BACKGROUND
        );


        JButton addButton =
                createButton("➕ Add Book");

        JButton removeButton =
                createButton("🗑 Remove Book");

        JButton refreshButton =
                createButton("🔄 Refresh");


        JTextField searchField =
                new JTextField(18);

        searchField.setFont(
                new Font(
                        "Serif",
                        Font.PLAIN,
                        14
                )
        );

        searchField.setPreferredSize(
                new Dimension(
                        180,
                        34
                )
        );


        JButton searchButton =
                createButton("🔎 Search");


        topPanel.add(addButton);

        topPanel.add(removeButton);

        topPanel.add(refreshButton);

        topPanel.add(
                createLabel("Search:")
        );

        topPanel.add(searchField);

        topPanel.add(searchButton);


        createTable();

        loadBooks();


        add(
                topPanel,
                BorderLayout.NORTH
        );

        add(
                new JScrollPane(table),
                BorderLayout.CENTER
        );


        // ================= ACTIONS =================

        addButton.addActionListener(
                e -> addBook()
        );

        removeButton.addActionListener(
                e -> removeBook()
        );

        refreshButton.addActionListener(
                e -> loadBooks()
        );

        searchButton.addActionListener(
                e -> searchBooks(
                        searchField.getText().trim()
                )
        );
    }


    // =====================================================
    // TABLE
    // =====================================================

    private void createTable() {

        String[] columns = {
                "ID",
                "Title",
                "Author",
                "Status"
        };


        tableModel =
                new DefaultTableModel(
                        columns,
                        0
                ) {

                    @Override
                    public boolean isCellEditable(
                            int row,
                            int column
                    ) {
                        return false;
                    }
                };


        table =
                new JTable(tableModel);


        table.setRowHeight(36);

        table.setFont(
                new Font(
                        "Serif",
                        Font.PLAIN,
                        14
                )
        );


        table.setForeground(TEXT);

        table.setBackground(CARD);


        table.setSelectionBackground(
                new Color(
                        232,
                        216,
                        190
                )
        );

        table.setSelectionForeground(
                TEXT
        );


        table.setGridColor(
                BORDER
        );

        table.setShowGrid(true);


        table.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );


        // ===== TABLE HEADER =====

        table.getTableHeader().setFont(
                new Font(
                        "Georgia",
                        Font.BOLD,
                        13
                )
        );

        table.getTableHeader().setBackground(
                PRIMARY
        );

        table.getTableHeader().setForeground(
                Color.WHITE
        );

        table.getTableHeader().setPreferredSize(
                new Dimension(
                        0,
                        38
                )
        );
    }


    // =====================================================
    // LOAD BOOKS
    // =====================================================

    private void loadBooks() {

        tableModel.setRowCount(0);

        for (Book book :
                library.getBooks()) {

            tableModel.addRow(
                    new Object[]{
                            book.getId(),
                            book.getTitle(),
                            book.getAuthor(),
                            book.isAvailable()
                                    ? "Available"
                                    : "Issued"
                    }
            );
        }
    }


    // =====================================================
    // ADD BOOK
    // =====================================================

    private void addBook() {

        JTextField idField =
                createInputField();

        JTextField titleField =
                createInputField();

        JTextField authorField =
                createInputField();


        JPanel panel =
                new JPanel(
                        new GridLayout(
                                3,
                                2,
                                12,
                                12
                        )
                );

        panel.setBackground(CARD);

        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        10,
                        10,
                        10
                )
        );


        panel.add(
                createLabel("Book ID:")
        );

        panel.add(idField);


        panel.add(
                createLabel("Title:")
        );

        panel.add(titleField);


        panel.add(
                createLabel("Author:")
        );

        panel.add(authorField);


        int result =
                JOptionPane.showConfirmDialog(
                        this,
                        panel,
                        "📚 Add New Book",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE
                );


        if (result != JOptionPane.OK_OPTION) {
            return;
        }


        try {

            int id =
                    Integer.parseInt(
                            idField
                                    .getText()
                                    .trim()
                    );


            String title =
                    titleField
                            .getText()
                            .trim();


            String author =
                    authorField
                            .getText()
                            .trim();


            if (
                    title.isEmpty()
                            ||
                            author.isEmpty()
            ) {

                showError(
                        "Please enter all book details."
                );

                return;
            }


            if (
                    library.findBookById(id)
                            != null
            ) {

                showError(
                        "Book ID already exists."
                );

                return;
            }


            library.addBook(
                    new Book(
                            id,
                            title,
                            author
                    )
            );


            loadBooks();


            showSuccess(
                    "📚 Book added successfully!"
            );


        } catch (
                NumberFormatException ex
        ) {

            showError(
                    "Book ID must be a number."
            );
        }
    }


    // =====================================================
    // REMOVE BOOK
    // =====================================================

    private void removeBook() {

        int row =
                table.getSelectedRow();


        if (row == -1) {

            showError(
                    "Please select a book first."
            );

            return;
        }


        int id =
                (int) tableModel.getValueAt(
                        row,
                        0
                );


        Book book =
                library.findBookById(id);


        if (book == null) {
            return;
        }


        if (!book.isAvailable()) {

            showError(
                    "Issued book cannot be removed."
            );

            return;
        }


        int confirm =
                JOptionPane.showConfirmDialog(
                        this,
                        "Remove \"" +
                                book.getTitle() +
                                "\"?",
                        "🗑 Confirm Delete",
                        JOptionPane.YES_NO_OPTION
                );


        if (
                confirm ==
                        JOptionPane.YES_OPTION
        ) {

            library.removeBook(id);

            loadBooks();

            showSuccess(
                    "📚 Book removed successfully!"
            );
        }
    }


    // =====================================================
    // SEARCH
    // =====================================================

    private void searchBooks(
            String keyword
    ) {

        if (keyword.isEmpty()) {

            loadBooks();

            return;
        }


        tableModel.setRowCount(0);


        for (Book book :
                library.getBooks()) {

            if (
                    book.getTitle()
                            .toLowerCase()
                            .contains(
                                    keyword.toLowerCase()
                            )

                            ||

                            book.getAuthor()
                                    .toLowerCase()
                                    .contains(
                                            keyword.toLowerCase()
                                    )
            ) {

                tableModel.addRow(
                        new Object[]{
                                book.getId(),
                                book.getTitle(),
                                book.getAuthor(),
                                book.isAvailable()
                                        ? "Available"
                                        : "Issued"
                        }
                );
            }
        }
    }


    // =====================================================
    // HELPERS
    // =====================================================

    private JButton createButton(
            String text
    ) {

        JButton button =
                new JButton(text);

        button.setBackground(
                PRIMARY
        );

        button.setForeground(
                Color.WHITE
        );

        button.setFocusPainted(false);

        button.setBorderPainted(false);

        button.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        13
                )
        );

        button.setPreferredSize(
                new Dimension(
                        125,
                        34
                )
        );


        button.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            java.awt.event.MouseEvent e
                    ) {

                        button.setBackground(
                                PRIMARY_DARK
                        );
                    }

                    @Override
                    public void mouseExited(
                            java.awt.event.MouseEvent e
                    ) {

                        button.setBackground(
                                PRIMARY
                        );
                    }
                }
        );


        return button;
    }


    private JLabel createLabel(
            String text
    ) {

        JLabel label =
                new JLabel(text);

        label.setForeground(TEXT);

        label.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        13
                )
        );

        return label;
    }


    private JTextField createInputField() {

        JTextField field =
                new JTextField();

        field.setFont(
                new Font(
                        "Serif",
                        Font.PLAIN,
                        14
                )
        );

        return field;
    }


    private void showError(
            String message
    ) {

        JOptionPane.showMessageDialog(
                this,
                "⚠ " + message,
                "Library",
                JOptionPane.ERROR_MESSAGE
        );
    }


    private void showSuccess(
            String message
    ) {

        JOptionPane.showMessageDialog(
                this,
                message,
                "Library",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}