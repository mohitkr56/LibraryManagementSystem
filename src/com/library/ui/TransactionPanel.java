package com.library.ui;

import com.library.Book;
import com.library.Library;

import javax.swing.*;
import java.awt.*;

public class TransactionPanel extends JPanel {

    private final Library library;


    // =====================================================
    // CLASSIC LIBRARY COLORS
    // =====================================================

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


    public TransactionPanel(
            Library library
    ) {

        this.library = library;

        setLayout(
                new BorderLayout()
        );

        setBackground(
                BACKGROUND
        );

        createUI();
    }


    // =====================================================
    // UI
    // =====================================================

    private void createUI() {

        JPanel mainPanel =
                new JPanel(
                        new GridLayout(
                                1,
                                2,
                                25,
                                25
                        )
                );

        mainPanel.setBackground(
                BACKGROUND
        );

        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        35,
                        35,
                        35,
                        35
                )
        );


        // =================================================
        // ISSUE CARD
        // =================================================

        JPanel issueCard =
                createTransactionCard(
                        "📖",
                        "Issue Book",
                        "Issue an available book",
                        "Issue Book"
                );


        // =================================================
        // RETURN CARD
        // =================================================

        JPanel returnCard =
                createTransactionCard(
                        "↩️",
                        "Return Book",
                        "Return a previously issued book",
                        "Return Book"
                );


        mainPanel.add(issueCard);

        mainPanel.add(returnCard);


        add(
                mainPanel,
                BorderLayout.CENTER
        );
    }


    // =====================================================
    // TRANSACTION CARD
    // =====================================================

    private JPanel createTransactionCard(
            String icon,
            String title,
            String description,
            String buttonText
    ) {

        JPanel card =
                new JPanel();


        card.setLayout(
                new BoxLayout(
                        card,
                        BoxLayout.Y_AXIS
                )
        );


        card.setBackground(
                CARD
        );


        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER,
                                1
                        ),
                        BorderFactory.createEmptyBorder(
                                35,
                                35,
                                35,
                                35
                        )
                )
        );


        // =================================================
        // ICON
        // =================================================

        JLabel iconLabel =
                new JLabel(icon);

        iconLabel.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        42
                )
        );

        iconLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        // =================================================
        // TITLE
        // =================================================

        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "Georgia",
                        Font.BOLD,
                        24
                )
        );

        titleLabel.setForeground(
                PRIMARY_DARK
        );

        titleLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        // =================================================
        // DESCRIPTION
        // =================================================

        JLabel descriptionLabel =
                new JLabel(description);

        descriptionLabel.setFont(
                new Font(
                        "Serif",
                        Font.ITALIC,
                        14
                )
        );

        descriptionLabel.setForeground(
                MUTED
        );

        descriptionLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        // =================================================
        // LABEL
        // =================================================

        JLabel bookIdLabel =
                new JLabel(
                        "Enter Book ID"
                );

        bookIdLabel.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        14
                )
        );

        bookIdLabel.setForeground(
                TEXT
        );

        bookIdLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        // =================================================
        // INPUT
        // =================================================

        JTextField bookIdField =
                new JTextField();

        bookIdField.setFont(
                new Font(
                        "Serif",
                        Font.PLAIN,
                        16
                )
        );

        bookIdField.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        bookIdField.setMaximumSize(
                new Dimension(
                        260,
                        42
                )
        );

        bookIdField.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        // =================================================
        // BUTTON
        // =================================================

        JButton actionButton =
                new JButton(
                        buttonText
                );

        actionButton.setBackground(
                PRIMARY
        );

        actionButton.setForeground(
                Color.WHITE
        );

        actionButton.setFocusPainted(
                false
        );

        actionButton.setBorderPainted(
                false
        );

        actionButton.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        14
                )
        );

        actionButton.setPreferredSize(
                new Dimension(
                        150,
                        40
                )
        );

        actionButton.setMaximumSize(
                new Dimension(
                        180,
                        40
                )
        );

        actionButton.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        actionButton.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            java.awt.event.MouseEvent e
                    ) {

                        actionButton.setBackground(
                                PRIMARY_DARK
                        );
                    }


                    @Override
                    public void mouseExited(
                            java.awt.event.MouseEvent e
                    ) {

                        actionButton.setBackground(
                                PRIMARY
                        );
                    }
                }
        );


        // =================================================
        // ADD COMPONENTS
        // =================================================

        card.add(iconLabel);

        card.add(
                Box.createVerticalStrut(10)
        );

        card.add(titleLabel);

        card.add(
                Box.createVerticalStrut(8)
        );

        card.add(descriptionLabel);

        card.add(
                Box.createVerticalStrut(35)
        );

        card.add(bookIdLabel);

        card.add(
                Box.createVerticalStrut(8)
        );

        card.add(bookIdField);

        card.add(
                Box.createVerticalStrut(25)
        );

        card.add(actionButton);


        // =================================================
        // ACTION
        // =================================================

        if (
                buttonText.equals(
                        "Issue Book"
                )
        ) {

            actionButton.addActionListener(
                    e -> issueBook(
                            bookIdField
                    )
            );

        } else {

            actionButton.addActionListener(
                    e -> returnBook(
                            bookIdField
                    )
            );
        }


        return card;
    }


    // =====================================================
    // ISSUE BOOK
    // =====================================================

    private void issueBook(
            JTextField field
    ) {

        try {

            int bookId =
                    Integer.parseInt(
                            field.getText().trim()
                    );


            Book book =
                    library.findBookById(
                            bookId
                    );


            if (book == null) {

                showError(
                        "Book not found."
                );

                return;
            }


            if (!book.isAvailable()) {

                showError(
                        "Book is already issued."
                );

                return;
            }


            library.issueBook(
                    bookId
            );


            showSuccess(
                    "📖 Book issued successfully!"
            );


            field.setText("");


        } catch (
                NumberFormatException ex
        ) {

            showError(
                    "Please enter a valid Book ID."
            );
        }
    }


    // =====================================================
    // RETURN BOOK
    // =====================================================

    private void returnBook(
            JTextField field
    ) {

        try {

            int bookId =
                    Integer.parseInt(
                            field.getText().trim()
                    );


            Book book =
                    library.findBookById(
                            bookId
                    );


            if (book == null) {

                showError(
                        "Book not found."
                );

                return;
            }


            if (book.isAvailable()) {

                showError(
                        "Book is already available."
                );

                return;
            }


            library.returnBook(
                    bookId
            );


            showSuccess(
                    "↩️ Book returned successfully!"
            );


            field.setText("");


        } catch (
                NumberFormatException ex
        ) {

            showError(
                    "Please enter a valid Book ID."
            );
        }
    }


    // =====================================================
    // HELPERS
    // =====================================================

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