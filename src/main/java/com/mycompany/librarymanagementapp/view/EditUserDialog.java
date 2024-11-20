package com.mycompany.librarymanagementapp.view;

import com.mycompany.librarymanagementapp.model.User;
import com.mycompany.librarymanagementapp.dao.UserDAO;
import javax.swing.*;
import java.awt.*;

public class EditUserDialog extends JDialog {
    public EditUserDialog(Frame owner, User user) {
        super(owner, "Chỉnh sửa tài khoản", true);
        setSize(400, 300);
        setResizable(false); // Không cho phép phóng to thu nhỏ
        setLocationRelativeTo(owner);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblUsername = new JLabel("Tên đăng nhập:");
        JTextField txtUsername = new JTextField(user.getUsername());
        JLabel lblPassword = new JLabel("Mật khẩu:");
        JPasswordField txtPassword = new JPasswordField(user.getPassword());
        JLabel lblRole = new JLabel("Vai trò:");
        JComboBox<String> cmbRole = new JComboBox<>(new String[]{"quan li", "nhan vien"});
        cmbRole.setSelectedItem(user.getRole());

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

        btnSave.addActionListener(e -> saveEditedUser(user, txtUsername, txtPassword, cmbRole));
        btnCancel.addActionListener(e -> dispose());

        add(panel);
        setVisible(true);
    }

    private void saveEditedUser(User user, JTextField txtUsername, JPasswordField txtPassword, JComboBox<String> cmbRole) {
        String newUsername = txtUsername.getText();
        String newPassword = new String(txtPassword.getPassword());
        String newRole = (String) cmbRole.getSelectedItem();

        if (newUsername.isEmpty() || newPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên đăng nhập và mật khẩu không được để trống!");
            return;
        }

        user.setUsername(newUsername);
        user.setPassword(newPassword);
        user.setRole(newRole);

        // Cập nhật người dùng trong cơ sở dữ liệu
        new UserDAO().updateUser(user);
        JOptionPane.showMessageDialog(this, "Chỉnh sửa tài khoản thành công!");
        dispose();
    }
}
