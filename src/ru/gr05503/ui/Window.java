package ru.gr05503.ui;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private JTextField tfAuthor = new JTextField();
    private JTextField tfTitle = new JTextField();
    private JTextField tfYear = new JTextField();
    private JTextField tfAdditional = new JTextField();
    public Window(){
        setTitle("Книги");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(400, 300));
        JPanel topPanel = new JPanel();
        JButton btnAdd = new JButton("Добавить");
        GroupLayout layout = new GroupLayout(topPanel);
        topPanel.setLayout(layout);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGap(8)
                .addGroup(
                        layout.createParallelGroup()
                                .addComponent(tfAuthor, DS, DS, DS)
                                .addComponent(tfTitle, DS, DS, DS)
                                .addComponent(tfYear, DS, DS, DS)
                                .addComponent(tfAdditional, DS, DS, DS)
                )
                .addGap(8)
                .addComponent(btnAdd)
                .addGap(8));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(8)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(tfAuthor)
                                .addGap(8)
                                .addComponent(tfTitle)
                                .addGap(8)
                                .addComponent(tfYear)
                                .addGap(8)
                                .addComponent(tfAdditional))
                        .addComponent(btnAdd))
                .addGap(8));


        add(topPanel, BorderLayout.NORTH);
        pack();
        setLocationRelativeTo(null);
    }

    private static final int DS = GroupLayout.DEFAULT_SIZE;
}