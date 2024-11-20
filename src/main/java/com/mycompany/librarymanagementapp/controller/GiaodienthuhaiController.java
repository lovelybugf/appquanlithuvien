package com.mycompany.librarymanagementapp.controller;

import com.mycompany.librarymanagementapp.view.Giaodienthuhai;
import com.mycompany.librarymanagementapp.view.AccountManagerGUI;
import com.mycompany.librarymanagementapp.view.Giaodienchinh;
import com.mycompany.librarymanagementapp.utils.SessionManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GiaodienthuhaiController {

    private Giaodienthuhai view;

    public GiaodienthuhaiController(Giaodienthuhai view) {
        this.view = view;
        addListeners();
    }

    private void addListeners() {
        // Đăng xuất
        view.getjButtonDANGXUAT().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SessionManager.clearSession();
                new Giaodienchinh().setVisible(true);  // Mở giao diện đăng nhập
                view.dispose();  // Đóng giao diện hiện tại
            }
        });

        // Thêm hành động cho nút "THÊM TÀI KHOẢN QUẢN LÝ"
        view.getjButtonTHEMQUANLY().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Kiểm tra vai trò người dùng từ SessionManager
                String role = SessionManager.getCurrentUserRole();
                if ("quan li".equals(role)) {
                    // Nếu là quản lý, đóng cửa sổ hiện tại và mở cửa sổ AccountManagerGUI
                    new AccountManagerGUI().setVisible(true);
                    view.dispose();  // Đóng cửa sổ hiện tại
                } else {
                    JOptionPane.showMessageDialog(view, "Bạn không có quyền này!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
