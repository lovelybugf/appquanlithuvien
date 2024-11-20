package com.mycompany.librarymanagementapp.controller;

import com.mycompany.librarymanagementapp.model.User;
import com.mycompany.librarymanagementapp.view.EditUserDialog;
import com.mycompany.librarymanagementapp.dao.UserDAO;
import javax.swing.*;

public class EditUserDialogController {
    private EditUserDialog editUserDialog;

    public EditUserDialogController(EditUserDialog dialog) {
        this.editUserDialog = dialog;
    }

    public void saveEditedUser(User user, String newUsername, String newPassword, String newRole) {
        if (newUsername.isEmpty() || newPassword.isEmpty()) {
            JOptionPane.showMessageDialog(editUserDialog, "Tên đăng nhập và mật khẩu không được để trống!");
            return;
        }

        user.setUsername(newUsername);
        user.setPassword(newPassword);
        user.setRole(newRole);

        new UserDAO().updateUser(user);
        JOptionPane.showMessageDialog(editUserDialog, "Chỉnh sửa tài khoản thành công!");
        editUserDialog.dispose();
    }
}
