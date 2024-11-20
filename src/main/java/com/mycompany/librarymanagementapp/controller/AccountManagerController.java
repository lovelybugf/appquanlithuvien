package com.mycompany.librarymanagementapp.controller;

import com.mycompany.librarymanagementapp.dao.UserDAO;
import com.mycompany.librarymanagementapp.model.User;
import com.mycompany.librarymanagementapp.view.AccountManagerGUI;
import com.mycompany.librarymanagementapp.view.EditUserDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AccountManagerController {
    private AccountManagerGUI view;
    private UserDAO userDAO;
    private DefaultTableModel tableModel;

    public AccountManagerController(AccountManagerGUI view) {
        this.view = view;
        this.userDAO = new UserDAO();
        this.tableModel = new DefaultTableModel(new String[]{"ID", "Tên đăng nhập", "Mật khẩu", "Vai trò"}, 0);
    }

    public JPanel createAddAccountPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblUsername = new JLabel("Tên đăng nhập:");
        JTextField txtUsername = new JTextField();
        JLabel lblPassword = new JLabel("Mật khẩu:");
        JPasswordField txtPassword = new JPasswordField();
        JLabel lblRole = new JLabel("Vai trò:");
        JComboBox<String> cmbRole = new JComboBox<>(new String[]{"quan li", "nhan vien"});
        JButton btnSave = new JButton("Lưu");
        JButton btnCancel = new JButton("Hủy");

        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(lblRole);
        panel.add(cmbRole);
        panel.add(btnSave);
        panel.add(btnCancel);

        btnSave.addActionListener(e -> saveUser(txtUsername, txtPassword, cmbRole));
        btnCancel.addActionListener(e -> cancelAddAccount(txtUsername, txtPassword));

        return panel;
    }

    private void saveUser(JTextField txtUsername, JPasswordField txtPassword, JComboBox<String> cmbRole) {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());
        String role = (String) cmbRole.getSelectedItem();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Tên đăng nhập và mật khẩu không được để trống!");
            return;
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setRole(role);

        userDAO.saveUser(newUser);
        JOptionPane.showMessageDialog(view, "Thêm tài khoản thành công!");
        txtUsername.setText("");
        txtPassword.setText("");
    }

    private void cancelAddAccount(JTextField txtUsername, JPasswordField txtPassword) {
        txtUsername.setText("");
        txtPassword.setText("");
    }

    public JPanel createAccountListPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JTable userTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(userTable);
        userTable.setComponentPopupMenu(createTablePopupMenu(userTable)); // Menu chuột phải
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPopupMenu createTablePopupMenu(JTable userTable) {
        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem editItem = new JMenuItem("Chỉnh sửa");
        JMenuItem deleteItem = new JMenuItem("Xóa");

        editItem.addActionListener(e -> editUser(userTable));
        deleteItem.addActionListener(e -> deleteUser(userTable));

        popupMenu.add(editItem);
        popupMenu.add(deleteItem);

        return popupMenu;
    }

    private void editUser(JTable userTable) {
        int selectedRow = userTable.getSelectedRow();
        if (selectedRow >= 0) {
            int userId = (int) tableModel.getValueAt(selectedRow, 0);
            User user = userDAO.getUserById(userId);
            if (user != null) {
                new EditUserDialog(view, user); // Mở cửa sổ chỉnh sửa
            }
        }
    }

    private void deleteUser(JTable userTable) {
        int selectedRow = userTable.getSelectedRow();
        if (selectedRow >= 0) {
            int userId = (int) tableModel.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(view, "Bạn có chắc chắn muốn xóa tài khoản không?");
            if (confirm == JOptionPane.YES_OPTION) {
                userDAO.deleteUser(userId);
                loadUserTable(); // Tải lại bảng sau khi xóa
            }
        }
    }

    public void loadUserTable() {
        List<User> users = userDAO.getAllUsers();
        tableModel.setRowCount(0);
        if (users != null) {
            for (User user : users) {
                tableModel.addRow(new Object[]{
                        user.getUserId(),
                        user.getUsername(),
                        user.getPassword(),
                        user.getRole()
                });
            }
        } else {
            JOptionPane.showMessageDialog(view, "Không thể tải danh sách người dùng!");
        }
    }
}
