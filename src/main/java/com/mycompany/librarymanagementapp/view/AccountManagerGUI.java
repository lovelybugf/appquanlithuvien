package com.mycompany.librarymanagementapp.view;

import com.mycompany.librarymanagementapp.controller.AccountManagerController;
import com.mycompany.librarymanagementapp.utils.SessionManager;
import com.mycompany.librarymanagementapp.model.User; // Đảm bảo import User nếu cần
import javax.swing.*;
import java.awt.*;

public class AccountManagerGUI extends JFrame {
    private AccountManagerController controller;

    public AccountManagerGUI() {
        controller = new AccountManagerController(this); // Khởi tạo controller
        initUI(); // Cài đặt giao diện
    }

    private void initUI() {
        setTitle("Quản lý tài khoản");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // CardLayout để chuyển giữa các panel
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // Các panel thêm tài khoản và danh sách tài khoản
        JPanel addAccountPanel = controller.createAddAccountPanel();
        JPanel accountListPanel = controller.createAccountListPanel();

        cardPanel.add(addAccountPanel, "AddAccount");
        cardPanel.add(accountListPanel, "AccountList");

        // Tạo panel nút điều hướng
        JPanel buttonPanel = new JPanel();
        JButton btnAdd = new JButton("Thêm tài khoản");
        JButton btnList = new JButton("Danh sách tài khoản");
        JButton btnBack = new JButton("Trở về");

        // Lắng nghe sự kiện các nút
        btnAdd.addActionListener(e -> cardLayout.show(cardPanel, "AddAccount"));
        btnList.addActionListener(e -> {
            controller.loadUserTable();  // Load dữ liệu người dùng
            cardLayout.show(cardPanel, "AccountList");
        });
        btnBack.addActionListener(e -> {
            // Lấy tên người dùng từ SessionManager
            String loggedInUsername = SessionManager.getCurrentUsername();
            if (!loggedInUsername.isEmpty()) {
                // Đóng cửa sổ hiện tại và mở giao diện chính (Giaodienthuhai)
                dispose();  // Đóng cửa sổ hiện tại
                new Giaodienthuhai(loggedInUsername).setVisible(true);  // Mở giao diện chính với tên người dùng
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng đăng nhập trước!");
            }
        });

        // Thêm nút vào panel
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnList);
        buttonPanel.add(btnBack);

        // Thiết lập layout cho giao diện
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(buttonPanel, BorderLayout.NORTH);
        getContentPane().add(cardPanel, BorderLayout.CENTER);
    }
}
