package com.library.ui;

import com.library.Book;
import com.library.Library;
import com.library.Member;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DashboardFrame extends JFrame {

    private final Library library;
    private JPanel contentPanel;

    // =====================================================
    // CLASSIC LIBRARY THEME
    // =====================================================

    private final Color SIDEBAR =
            new Color(48, 36, 27);

    private final Color SIDEBAR_HOVER =
            new Color(91, 63, 39);

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


    // =====================================================
    // CONSTRUCTOR
    // =====================================================

    public DashboardFrame() {

        library = new Library();

        // ================= SAMPLE BOOKS =================

        library.addBook(
                new Book(
                        101,
                        "Effective Java",
                        "Joshua Bloch"
                )
        );

        library.addBook(
                new Book(
                        102,
                        "Clean Code",
                        "Robert C. Martin"
                )
        );

        library.addBook(
                new Book(
                        103,
                        "Head First Java",
                        "Kathy Sierra"
                )
        );

        // ================= SAMPLE MEMBER =================

        library.addMember(
                new Member(
                        1,
                        "Anand Kumar",
                        "anand@example.com"
                )
        );

        // ================= FRAME =================

        setTitle(
                "Library Management System"
        );

        setSize(
                1100,
                700
        );

        setMinimumSize(
                new Dimension(
                        950,
                        600
                )
        );

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        createUI();
    }


    // =====================================================
    // MAIN UI
    // =====================================================

    private void createUI() {

        JPanel mainPanel =
                new JPanel(
                        new BorderLayout()
                );

        mainPanel.setBackground(
                BACKGROUND
        );


        // =================================================
        // SIDEBAR
        // =================================================

        JPanel sidebar =
                new JPanel();

        sidebar.setPreferredSize(
                new Dimension(
                        240,
                        700
                )
        );

        sidebar.setBackground(
                SIDEBAR
        );

        sidebar.setLayout(
                new BoxLayout(
                        sidebar,
                        BoxLayout.Y_AXIS
                )
        );


        // =================================================
        // LOGO AREA
        // =================================================

        JPanel logoPanel =
                new JPanel();

        logoPanel.setLayout(
                new BoxLayout(
                        logoPanel,
                        BoxLayout.Y_AXIS
                )
        );

        logoPanel.setBackground(
                SIDEBAR
        );

        logoPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        25,
                        20,
                        20,
                        20
                )
        );


        JLabel logoIcon =
                new JLabel("📚");

        logoIcon.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        34
                )
        );

        logoIcon.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        JLabel logoText =
                new JLabel("LIBRARY");

        logoText.setForeground(
                new Color(
                        245,
                        221,
                        175
                )
        );

        logoText.setFont(
                new Font(
                        "Georgia",
                        Font.BOLD,
                        25
                )
        );

        logoText.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        JLabel tagline =
                new JLabel(
                        "Knowledge • Books • Learning"
                );

        tagline.setForeground(
                new Color(
                        190,
                        166,
                        135
                )
        );

        tagline.setFont(
                new Font(
                        "Serif",
                        Font.ITALIC,
                        11
                )
        );

        tagline.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        logoPanel.add(logoIcon);

        logoPanel.add(
                Box.createVerticalStrut(2)
        );

        logoPanel.add(logoText);

        logoPanel.add(
                Box.createVerticalStrut(5)
        );

        logoPanel.add(tagline);


        sidebar.add(logoPanel);


        // =================================================
        // SEPARATOR
        // =================================================

        JSeparator separator =
                new JSeparator();

        separator.setForeground(
                new Color(
                        100,
                        75,
                        52
                )
        );

        separator.setMaximumSize(
                new Dimension(
                        200,
                        1
                )
        );

        sidebar.add(separator);

        sidebar.add(
                Box.createVerticalStrut(18)
        );


        // =================================================
        // MENU BUTTONS
        // =================================================

        JButton dashboardButton =
                createMenuButton(
                        "🏠  Dashboard"
                );

        JButton booksButton =
                createMenuButton(
                        "📚  Books"
                );

        JButton membersButton =
                createMenuButton(
                        "👥  Members"
                );

        JButton transactionButton =
                createMenuButton(
                        "🔄  Transactions"
                );

        JButton searchButton =
                createMenuButton(
                        "🔎  Search"
                );


        sidebar.add(dashboardButton);

        sidebar.add(booksButton);

        sidebar.add(membersButton);

        sidebar.add(transactionButton);

        sidebar.add(searchButton);


        // =================================================
        // SPACE
        // =================================================

        sidebar.add(
                Box.createVerticalGlue()
        );


        // =================================================
        // AUTHOR AREA
        // =================================================

        JPanel authorPanel =
                new JPanel();

        authorPanel.setLayout(
                new BoxLayout(
                        authorPanel,
                        BoxLayout.Y_AXIS
                )
        );

        authorPanel.setBackground(
                SIDEBAR
        );

        authorPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        10,
                        10,
                        10
                )
        );


        JSeparator authorSeparator =
                new JSeparator();

        authorSeparator.setForeground(
                new Color(
                        100,
                        75,
                        52
                )
        );

        authorSeparator.setMaximumSize(
                new Dimension(
                        210,
                        1
                )
        );


        JLabel createdBy =
                new JLabel(
                        "✨ Created by"
                );

        createdBy.setForeground(
                new Color(
                        184,
                        158,
                        126
                )
        );

        createdBy.setFont(
                new Font(
                        "Serif",
                        Font.ITALIC,
                        11
                )
        );

        createdBy.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        JLabel authorName =
                new JLabel(
                        "Anand Kumar Saha"
                );

        authorName.setForeground(
                new Color(
                        238,
                        214,
                        173
                )
        );

        authorName.setFont(
                new Font(
                        "Georgia",
                        Font.BOLD,
                        13
                )
        );

        authorName.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        JLabel year =
                new JLabel(
                        "📖 Library Management System"
                );

        year.setForeground(
                new Color(
                        150,
                        127,
                        101
                )
        );

        year.setFont(
                new Font(
                        "Serif",
                        Font.PLAIN,
                        10
                )
        );

        year.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        authorPanel.add(authorSeparator);

        authorPanel.add(
                Box.createVerticalStrut(12)
        );

        authorPanel.add(createdBy);

        authorPanel.add(
                Box.createVerticalStrut(3)
        );

        authorPanel.add(authorName);

        authorPanel.add(
                Box.createVerticalStrut(5)
        );

        authorPanel.add(year);


        sidebar.add(authorPanel);


        // =================================================
        // EXIT BUTTON
        // =================================================

        JButton exitButton =
                createMenuButton(
                        "🚪  Exit"
                );

        sidebar.add(exitButton);

        sidebar.add(
                Box.createVerticalStrut(12)
        );


        // =================================================
        // CONTENT PANEL
        // =================================================

        contentPanel =
                new JPanel(
                        new BorderLayout()
                );

        contentPanel.setBackground(
                BACKGROUND
        );


        // =================================================
        // DEFAULT PAGE
        // =================================================

        showDashboard();


        // =================================================
        // ACTIONS
        // =================================================

        dashboardButton.addActionListener(
                e -> showDashboard()
        );

        booksButton.addActionListener(
                e -> showBooks()
        );

        membersButton.addActionListener(
                e -> showMembers()
        );

        transactionButton.addActionListener(
                e -> showTransactions()
        );

        searchButton.addActionListener(
                e -> showSearch()
        );

        exitButton.addActionListener(
                e -> System.exit(0)
        );


        // =================================================
        // FRAME
        // =================================================

        mainPanel.add(
                sidebar,
                BorderLayout.WEST
        );

        mainPanel.add(
                contentPanel,
                BorderLayout.CENTER
        );

        add(mainPanel);
    }


    // =====================================================
    // DASHBOARD
    // =====================================================

    private void showDashboard() {

        contentPanel.removeAll();

        JPanel header =
                createHeader(
                        "📖 Dashboard",
                        "Welcome to your personal library"
                );


        JPanel dashboard =
                new JPanel(
                        new BorderLayout()
                );

        dashboard.setBackground(
                BACKGROUND
        );

        dashboard.setBorder(
                BorderFactory.createEmptyBorder(
                        25,
                        30,
                        30,
                        30
                )
        );


        // =================================================
        // STATISTICS
        // =================================================

        JPanel cards =
                new JPanel(
                        new GridLayout(
                                1,
                                4,
                                18,
                                18
                        )
                );

        cards.setBackground(
                BACKGROUND
        );


        int totalBooks =
                library.getBooks().size();

        int totalMembers =
                library.getMembers().size();

        int available =
                0;

        int issued =
                0;


        for (Book book :
                library.getBooks()) {

            if (book.isAvailable()) {

                available++;

            } else {

                issued++;
            }
        }


        cards.add(
                createCard(
                        "📚 Total Books",
                        String.valueOf(
                                totalBooks
                        )
                )
        );

        cards.add(
                createCard(
                        "👥 Members",
                        String.valueOf(
                                totalMembers
                        )
                )
        );

        cards.add(
                createCard(
                        "✅ Available",
                        String.valueOf(
                                available
                        )
                )
        );

        cards.add(
                createCard(
                        "📕 Issued",
                        String.valueOf(
                                issued
                        )
                )
        );


        // =================================================
        // RECENT BOOKS
        // =================================================

        JPanel bookSection =
                new JPanel(
                        new BorderLayout()
                );

        bookSection.setBackground(
                BACKGROUND
        );

        bookSection.setBorder(
                BorderFactory.createEmptyBorder(
                        28,
                        0,
                        0,
                        0
                )
        );


        JLabel title =
                new JLabel(
                        "📚 Recent Books"
                );

        title.setFont(
                new Font(
                        "Georgia",
                        Font.BOLD,
                        21
                )
        );

        title.setForeground(
                TEXT
        );

        title.setBorder(
                BorderFactory.createEmptyBorder(
                        0,
                        0,
                        12,
                        0
                ));


        DefaultTableModel model =
                new DefaultTableModel(
                        new String[]{
                                "ID",
                                "Title",
                                "Author",
                                "Status"
                        },
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


        for (Book book :
                library.getBooks()) {

            model.addRow(
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


        JTable table =
                new JTable(model);

        table.setRowHeight(34);

        table.setFont(
                new Font(
                        "Serif",
                        Font.PLAIN,
                        14
                )
        );

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

        table.setShowGrid(
                true
        );


        bookSection.add(
                title,
                BorderLayout.NORTH
        );

        bookSection.add(
                new JScrollPane(table),
                BorderLayout.CENTER
        );


        dashboard.add(
                cards,
                BorderLayout.NORTH
        );

        dashboard.add(
                bookSection,
                BorderLayout.CENTER
        );


        contentPanel.add(
                header,
                BorderLayout.NORTH
        );

        contentPanel.add(
                dashboard,
                BorderLayout.CENTER
        );

        refresh();
    }


    // =====================================================
    // BOOKS
    // =====================================================

    private void showBooks() {

        contentPanel.removeAll();

        JPanel header =
                createHeader(
                        "📚 Books Management",
                        "Manage your library collection"
                );

        contentPanel.add(
                header,
                BorderLayout.NORTH
        );

        contentPanel.add(
                new BookPanel(library),
                BorderLayout.CENTER
        );

        refresh();
    }


    // =====================================================
    // MEMBERS
    // =====================================================

    private void showMembers() {

        contentPanel.removeAll();

        JPanel header =
                createHeader(
                        "👥 Members Management",
                        "Manage registered library members"
                );

        contentPanel.add(
                header,
                BorderLayout.NORTH
        );

        contentPanel.add(
                new MemberPanel(library),
                BorderLayout.CENTER
        );

        refresh();
    }


    // =====================================================
    // TRANSACTIONS
    // =====================================================

    private void showTransactions() {

        contentPanel.removeAll();

        JPanel header =
                createHeader(
                        "🔄 Transactions",
                        "Issue and return books"
                );

        contentPanel.add(
                header,
                BorderLayout.NORTH
        );

        contentPanel.add(
                new TransactionPanel(library),
                BorderLayout.CENTER
        );

        refresh();
    }


    // =====================================================
    // SEARCH
    // =====================================================

    private void showSearch() {

        contentPanel.removeAll();

        JPanel header =
                createHeader(
                        "🔎 Search Library",
                        "Find books and members quickly"
                );


        JPanel searchPanel =
                new JPanel(
                        new BorderLayout(
                                15,
                                15
                        )
                );

        searchPanel.setBackground(
                BACKGROUND
        );

        searchPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        30,
                        30,
                        30,
                        30
                )
        );


        JPanel top =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT
                        )
                );

        top.setBackground(
                BACKGROUND
        );


        JTextField searchField =
                new JTextField(25);


        JButton searchButton =
                new JButton(
                        "🔎 Search"
                );

        styleActionButton(
                searchButton
        );


        top.add(
                new JLabel(
                        "Search:"
                )
        );

        top.add(searchField);

        top.add(searchButton);


        JTextArea resultArea =
                new JTextArea();

        resultArea.setEditable(
                false
        );

        resultArea.setFont(
                new Font(
                        "Serif",
                        Font.PLAIN,
                        14
                )
        );

        resultArea.setBackground(
                CARD
        );

        resultArea.setForeground(
                TEXT
        );


        searchButton.addActionListener(
                e -> {

                    String keyword =
                            searchField
                                    .getText()
                                    .trim()
                                    .toLowerCase();


                    resultArea.setText("");


                    if (keyword.isEmpty()) {
                        return;
                    }


                    for (Book book :
                            library.getBooks()) {

                        if (
                                book.getTitle()
                                        .toLowerCase()
                                        .contains(
                                                keyword
                                        )
                                        ||
                                        book.getAuthor()
                                                .toLowerCase()
                                                .contains(
                                                        keyword
                                                )
                        ) {

                            resultArea.append(
                                    "📚 BOOK  |  ID: " +
                                            book.getId() +
                                            "  |  " +
                                            book.getTitle() +
                                            "  |  " +
                                            book.getAuthor() +
                                            "\n"
                            );
                        }
                    }


                    for (Member member :
                            library.getMembers()) {

                        if (
                                member.getName()
                                        .toLowerCase()
                                        .contains(
                                                keyword
                                        )
                                        ||
                                        member.getEmail()
                                                .toLowerCase()
                                                .contains(
                                                        keyword
                                                )
                        ) {

                            resultArea.append(
                                    "👤 MEMBER  |  ID: " +
                                            member.getId() +
                                            "  |  " +
                                            member.getName() +
                                            "  |  " +
                                            member.getEmail() +
                                            "\n"
                            );
                        }
                    }


                    if (
                            resultArea
                                    .getText()
                                    .isEmpty()
                    ) {

                        resultArea.setText(
                                "📜 No result found."
                        );
                    }
                }
        );


        searchPanel.add(
                top,
                BorderLayout.NORTH
        );

        searchPanel.add(
                new JScrollPane(
                        resultArea
                ),
                BorderLayout.CENTER
        );


        contentPanel.add(
                header,
                BorderLayout.NORTH
        );

        contentPanel.add(
                searchPanel,
                BorderLayout.CENTER
        );

        refresh();
    }


    // =====================================================
    // HEADER
    // =====================================================

    private JPanel createHeader(
            String title,
            String subtitle
    ) {

        JPanel header =
                new JPanel(
                        new BorderLayout()
                );

        header.setBackground(
                CARD
        );

        header.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(
                                0,
                                0,
                                1,
                                0,
                                BORDER
                        ),
                        BorderFactory.createEmptyBorder(
                                20,
                                30,
                                20,
                                30
                        )
                )
        );


        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "Georgia",
                        Font.BOLD,
                        27
                )
        );

        titleLabel.setForeground(
                TEXT
        );


        JLabel subtitleLabel =
                new JLabel(subtitle);

        subtitleLabel.setForeground(
                MUTED
        );

        subtitleLabel.setFont(
                new Font(
                        "Serif",
                        Font.ITALIC,
                        13
                )
        );


        JPanel text =
                new JPanel();

        text.setLayout(
                new BoxLayout(
                        text,
                        BoxLayout.Y_AXIS
                )
        );

        text.setBackground(
                CARD
        );

        text.add(titleLabel);

        text.add(
                Box.createVerticalStrut(5)
        );

        text.add(subtitleLabel);


        header.add(
                text,
                BorderLayout.WEST
        );


        return header;
    }


    // =====================================================
    // DASHBOARD CARD
    // =====================================================

    private JPanel createCard(
            String title,
            String value
    ) {

        JPanel card =
                new JPanel(
                        new BorderLayout()
                );

        card.setBackground(
                CARD
        );


        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        BorderFactory.createEmptyBorder(
                                18,
                                20,
                                18,
                                20
                        )
                )
        );


        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        13
                )
        );

        titleLabel.setForeground(
                MUTED
        );


        JLabel valueLabel =
                new JLabel(value);

        valueLabel.setFont(
                new Font(
                        "Georgia",
                        Font.BOLD,
                        30
                )
        );

        valueLabel.setForeground(
                PRIMARY
        );


        card.add(
                titleLabel,
                BorderLayout.NORTH
        );

        card.add(
                valueLabel,
                BorderLayout.CENTER
        );


        return card;
    }


    // =====================================================
    // SIDEBAR MENU BUTTON
    // =====================================================

    private JButton createMenuButton(
            String text
    ) {

        JButton button =
                new JButton(text);


        button.setMaximumSize(
                new Dimension(
                        240,
                        46
                )
        );


        button.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        button.setHorizontalAlignment(
                SwingConstants.LEFT
        );


        button.setBorder(
                BorderFactory.createEmptyBorder(
                        0,
                        24,
                        0,
                        0
                )
        );


        button.setBackground(
                SIDEBAR
        );

        button.setForeground(
                new Color(
                        239,
                        230,
                        214
                )
        );


        button.setFocusPainted(
                false
        );

        button.setBorderPainted(
                false
        );


        button.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.BOLD,
                        14
                )
        );


        button.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            java.awt.event.MouseEvent e
                    ) {

                        button.setBackground(
                                SIDEBAR_HOVER
                        );
                    }


                    @Override
                    public void mouseExited(
                            java.awt.event.MouseEvent e
                    ) {

                        button.setBackground(
                                SIDEBAR
                        );
                    }
                }
        );


        return button;
    }


    // =====================================================
    // ACTION BUTTON
    // =====================================================

    private void styleActionButton(
            JButton button
    ) {

        button.setBackground(
                PRIMARY
        );

        button.setForeground(
                Color.WHITE
        );

        button.setFocusPainted(
                false
        );

        button.setBorderPainted(
                false
        );

        button.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        13
                )
        );
    }


    // =====================================================
    // REFRESH
    // =====================================================

    private void refresh() {

        contentPanel.revalidate();

        contentPanel.repaint();
    }


    // =====================================================
    // MAIN
    // =====================================================

    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(
                () -> {

                    DashboardFrame frame =
                            new DashboardFrame();

                    frame.setVisible(true);
                }
        );
    }
}