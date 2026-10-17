package ru.gr05503.ui;

import ru.gr05503.domain.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class Window extends JFrame implements BookView {
    private JTextField tfAuthor = new JTextField();
    private JTextField tfTitle = new JTextField();
    private JTextField tfYear = new JTextField();
    private JTextField tfAdditional = new JTextField();
    JButton btnAdd = new JButton("Добавить");
    private JTextArea taBooks = new JTextArea();
    private final BookPresenter presenter;
    private final JLabel lblStatus = new JLabel();
    public Window(BookPresenter presenter) {
        this.presenter = presenter;

        setTitle("Книги");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600, 300));
        JPanel topPanel = new JPanel();

        JLabel lblAuthor = new JLabel("Автор:");
        JLabel lblTitle = new JLabel("Название:");
        JLabel lblYear = new JLabel("Год издания:");
        JLabel lblAdditional = new JLabel("Допинформация:");

        btnAdd.addActionListener(e -> {
            presenter.addBookClicked();
        });

        tfAuthor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                presenter.inputChanged();
            }
        });

        tfTitle.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                presenter.inputChanged();
            }
        });

        tfYear.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                presenter.inputChanged();
            }
        });

        GroupLayout layout = new GroupLayout(topPanel);
        topPanel.setLayout(layout);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGap(8)
                .addGroup(
                        layout.createParallelGroup()
                                .addComponent(lblAuthor, DS, DS, DS)
                                .addComponent(lblTitle, DS, DS, DS)
                                .addComponent(lblYear, DS, DS, DS)
                                .addComponent(lblAdditional, DS, DS, DS)
                )
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
                                .addComponent(lblAuthor)
                                .addGap(8)
                                .addComponent(lblTitle)
                                .addGap(8)
                                .addComponent(lblYear)
                                .addGap(8)
                                .addComponent(lblAdditional))
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

        taBooks.setEditable(false);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(taBooks), BorderLayout.CENTER);
        add( lblStatus, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
    }

    private static final int DS = GroupLayout.DEFAULT_SIZE;

    @Override
    public String getAuthor() {
        return tfAuthor.getText();
    }

    @Override
    public String getBookTitle() {
        return tfTitle.getText();
    }

    @Override
    public String getYear() {
        return tfYear.getText();
    }

    @Override
    public String getInfo() {
        return tfAdditional.getText();
    }

    @Override
    public void clearForm() {
        tfAuthor.setText("");
        tfTitle.setText("");
        tfYear.setText("");
        tfAdditional.setText("");
    }

    @Override
    public void showBooks(List<Book> books) {
        taBooks.setText("");
        for (var book : books) {
            taBooks.append(book.author());
            taBooks.append(" | ");
            taBooks.append(book.title());
            taBooks.append(" | ");
            taBooks.append("" + book.year());
            if (book.information() != null && !book.information().isBlank()) {
                taBooks.append(" | ");
                taBooks.append(book.information());
            }
            taBooks.append(System.lineSeparator());
        }
    }

    @Override
    public void render(BookFormState state) {
     btnAdd.setEnabled(state.addEnabled());
     lblStatus.setText(state.status());
     if ( state.error()!= null)
         showError(state.error());
    }

    @Override
    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}