package com.library.ui;

import com.library.Library;
import com.library.Member;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MemberPanel extends JPanel {

    private final Library library;

    private DefaultTableModel tableModel;
    private JTable table;

    // ===== CLASSIC LIBRARY THEME =====

    private final Color BACKGROUND =
            new Color(246, 240, 226);

    private final Color CARD =
            new Color(255, 251, 240);

    private final Color PRIMARY =
            new Color(126, 83, 43);

    private final Color PRIMARY_DARK =
            new Color(91, 58, 30);

    private final Color TEXT =
            new Color(55, 43, 32);

    private final Color MUTED =
            new Color(115, 95, 76);

    private final Color BORDER =
            new Color(218, 202, 174);


    public MemberPanel(Library library) {

        this.library = library;

        setLayout(
                new BorderLayout(
                        15,
                        15
                )
        );

        setBackground(
                BACKGROUND
        );

        setBorder(
                BorderFactory.createEmptyBorder(
                        25,
                        30,
                        30,
                        30
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
                createButton(
                        "➕ Add Member"
                );

        JButton removeButton =
                createButton(
                        "🗑 Remove Member"
                );

        JButton refreshButton =
                createButton(
                        "🔄 Refresh"
                );

        JButton searchButton =
                createButton(
                        "🔎 Search"
                );


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


        topPanel.add(addButton);

        topPanel.add(removeButton);

        topPanel.add(refreshButton);

        topPanel.add(
                createLabel("Search:")
        );

        topPanel.add(searchField);

        topPanel.add(searchButton);


        createTable();

        loadMembers();


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
                e -> addMember()
        );

        removeButton.addActionListener(
                e -> removeMember()
        );

        refreshButton.addActionListener(
                e -> loadMembers()
        );

        searchButton.addActionListener(
                e -> searchMembers(
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
                "Name",
                "Email"
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
    // LOAD MEMBERS
    // =====================================================

    private void loadMembers() {

        tableModel.setRowCount(0);


        for (Member member :
                library.getMembers()) {

            tableModel.addRow(
                    new Object[]{
                            member.getId(),
                            member.getName(),
                            member.getEmail()
                    }
            );
        }
    }


    // =====================================================
    // ADD MEMBER
    // =====================================================

    private void addMember() {

        JTextField idField =
                createInputField();

        JTextField nameField =
                createInputField();

        JTextField emailField =
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
                createLabel("Member ID:")
        );

        panel.add(idField);


        panel.add(
                createLabel("Name:")
        );

        panel.add(nameField);


        panel.add(
                createLabel("Email:")
        );

        panel.add(emailField);


        int result =
                JOptionPane.showConfirmDialog(
                        this,
                        panel,
                        "👤 Add New Member",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE
                );


        if (
                result !=
                        JOptionPane.OK_OPTION
        ) {

            return;
        }


        try {

            int id =
                    Integer.parseInt(
                            idField
                                    .getText()
                                    .trim()
                    );


            String name =
                    nameField
                            .getText()
                            .trim();


            String email =
                    emailField
                            .getText()
                            .trim();


            if (
                    name.isEmpty()
                            ||
                            email.isEmpty()
            ) {

                showError(
                        "Please enter all member details."
                );

                return;
            }


            if (
                    library.findMemberById(id)
                            != null
            ) {

                showError(
                        "Member ID already exists."
                );

                return;
            }


            library.addMember(
                    new Member(
                            id,
                            name,
                            email
                    )
            );


            loadMembers();


            showSuccess(
                    "👤 Member added successfully!"
            );


        } catch (
                NumberFormatException ex
        ) {

            showError(
                    "Member ID must be a number."
            );
        }
    }


    // =====================================================
    // REMOVE MEMBER
    // =====================================================

    private void removeMember() {

        int row =
                table.getSelectedRow();


        if (row == -1) {

            showError(
                    "Please select a member first."
            );

            return;
        }


        int id =
                (int) tableModel.getValueAt(
                        row,
                        0
                );


        Member member =
                library.findMemberById(id);


        if (member == null) {
            return;
        }


        int confirm =
                JOptionPane.showConfirmDialog(
                        this,
                        "Remove \"" +
                                member.getName() +
                                "\"?",
                        "🗑 Confirm Delete",
                        JOptionPane.YES_NO_OPTION
                );


        if (
                confirm ==
                        JOptionPane.YES_OPTION
        ) {

            library.removeMember(id);

            loadMembers();

            showSuccess(
                    "👤 Member removed successfully!"
            );
        }
    }


    // =====================================================
    // SEARCH MEMBERS
    // =====================================================

    private void searchMembers(
            String keyword
    ) {

        if (keyword.isEmpty()) {

            loadMembers();

            return;
        }


        tableModel.setRowCount(0);


        for (Member member :
                library.getMembers()) {

            if (
                    member.getName()
                            .toLowerCase()
                            .contains(
                                    keyword.toLowerCase()
                            )

                            ||

                            member.getEmail()
                                    .toLowerCase()
                                    .contains(
                                            keyword.toLowerCase()
                                    )
            ) {

                tableModel.addRow(
                        new Object[]{
                                member.getId(),
                                member.getName(),
                                member.getEmail()
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
                        135,
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