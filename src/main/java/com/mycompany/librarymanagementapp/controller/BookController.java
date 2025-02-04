/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementapp.controller;

import com.mycompany.librarymanagementapp.dao.BookDAO;
import com.mycompany.librarymanagementapp.dao.CategoryDAO;
import com.mycompany.librarymanagementapp.dao.PublisherDAO;
import com.mycompany.librarymanagementapp.model.Book;
import com.mycompany.librarymanagementapp.model.Category;
import com.mycompany.librarymanagementapp.model.Publisher;
import com.mycompany.librarymanagementapp.view.BookGUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class BookController {

    private BookGUI view;

    public BookController(BookGUI view) {
        this.view = view;
    }

    public void addCategory(String categoryName) {
        if (!categoryName.isEmpty()) {
            // Tạo đối tượng Category mới
            Category category = new Category();
            category.setCategory(categoryName);

            // Lưu thể loại vào cơ sở dữ liệu
            CategoryDAO categoryDao = new CategoryDAO();
            categoryDao.saveCategory(category);

            view.clearCategoryInputField();
            updateCategoryTable();
            view.loadInfoToComboBox();

            JOptionPane.showMessageDialog(view, "Đã thêm thể loại thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập tên thể loại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateCategoryTable() {
        DefaultTableModel model = (DefaultTableModel) view.getCategoryTableModel();
        model.setRowCount(0); // Xóa các dòng cũ

        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> categories = categoryDAO.getAllCategories();

        for (Category category : categories) {
            model.addRow(new Object[]{category.getCategoryId(), category.getCategory()});
        }
    }

    public void deleteCategory(int selectedRow, String role) {
        if ("quan_li".equals(role)) {
            CategoryDAO categoryDAO = new CategoryDAO();
            if (selectedRow != -1) {
                // Hiển thị xác nhận xóa
                int response = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa thể loại này không?\nTất cả sách có thể loại này cũng sẽ bị xóa.",
                        "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    String categoryId = view.getCategoryIdAt(selectedRow);
                    categoryDAO.deleteCategoryById(Integer.valueOf(categoryId));
                    view.removeCategoryRow(selectedRow);
                    JOptionPane.showMessageDialog(null, "Đã xóa thể loại thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    view.refreshBookTable();
                    view.loadInfoToComboBox();
                }
            }
        } else {
            JOptionPane.showMessageDialog(view, "Bạn không có quyền này!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void addPublisher(String publisherName) {
        if (!publisherName.isEmpty()) {
            // Tạo đối tượng Publisher mới
            Publisher publisher = new Publisher();
            publisher.setPublisherName(publisherName);

            // Lưu NXB vào cơ sở dữ liệu
            PublisherDAO publisherDao = new PublisherDAO();
            publisherDao.savePublisher(publisher);

            view.clearPublisherInputField();
            updatePublisherTable();
            view.loadInfoToComboBox();

            JOptionPane.showMessageDialog(view, "Đã thêm nhà xuất bản thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập tên nhà xuất bản!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updatePublisherTable() {
        DefaultTableModel model = (DefaultTableModel) view.getPublisherTableModel();
        model.setRowCount(0); // Xóa các dòng cũ

        PublisherDAO publisherDao = new PublisherDAO();
        List<Publisher> publishers = publisherDao.getAllPublishers();

        for (Publisher publisher : publishers) {
            model.addRow(new Object[]{publisher.getPublisherId(), publisher.getPublisherName()});
        }
    }

    public void deletePublisher(int selectedRow, String role) {
        if ("quan_li".equals(role)) {
            PublisherDAO publisherDAO = new PublisherDAO();
            if (selectedRow != -1) {
                int response = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa nhà xuất bản này không?\nTất cả sách từ nhà xuất bản này cũng sẽ bị xóa.",
                        "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    String publisherId = view.getPublisherIdAt(selectedRow);
                    publisherDAO.deletePublisherById(Integer.valueOf(publisherId));
                    view.removePublisherRow(selectedRow);
                    JOptionPane.showMessageDialog(null, "Đã xóa nhà xuất bản thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    view.refreshBookTable();
                    view.loadInfoToComboBox();
                }
            }
        } else {
            JOptionPane.showMessageDialog(view, "Bạn không có quyền này!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Tìm kiếm sách theo tiêu chí.
     *
     * @param bookId
     * @param title
     * @param author
     * @param category
     * @param publisher
     * @return Danh sách sách khớp với tiêu chí tìm kiếm.
     */
    public List<Book> searchBooks(String bookId, String title, String author, Category category, Publisher publisher) {
        BookDAO bookDAO = new BookDAO();

        List<Book> allBooks = bookDAO.getAllBooks(); // Lấy toàn bộ sách từ DAO
        List<Book> searchResults = new ArrayList<>();

        for (Book book : allBooks) {
            boolean matches = true;

            // So sánh mã sách
            if (!bookId.isEmpty()) {
                try {
                    int bookIdInt = Integer.parseInt(bookId);
                    if (book.getBookId() != bookIdInt) {
                        matches = false;
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Mã sách phải là số nguyên!");
                }
            }

            // So sánh tiêu đề
            if (!title.isEmpty() && !book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                matches = false;
            }

            // So sánh tác giả
            if (!author.isEmpty() && !book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                matches = false;
            }

            // So sánh thể loại
            if (category != null && !book.getCategory().equals(category)) {
                matches = false;
            }

            // So sánh nhà xuất bản
            if (publisher != null && !book.getPublisher().equals(publisher)) {
                matches = false;
            }

            if (matches) {
                searchResults.add(book);
            }
        }

        return searchResults; // Trả về danh sách kết quả tìm kiếm
    }

    public void addBook(String title, String author, String selectedCategoryName, String selectedPublisherName, String yearPublishedStr, String quantityStr, Map<String, Category> categoryMap, Map<String, Publisher> publisherMap) {
        try {
            // Lấy đối tượng Category từ ánh xạ Map
            Category category = categoryMap.get(selectedCategoryName);
            if (category == null) {
                JOptionPane.showMessageDialog(view, "Vui lòng chọn thể loại", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Lấy đối tượng Publisher từ ánh xạ Map
            Publisher publisher = publisherMap.get(selectedPublisherName);
            if (publisher == null) {
                JOptionPane.showMessageDialog(view, "Vui lòng chọn nhà xuất bản!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Kiểm tra và chuyển đổi dữ liệu số
            int yearPublished;
            int quantity;
            try {
                yearPublished = Integer.parseInt(yearPublishedStr.trim());
                quantity = Integer.parseInt(quantityStr.trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, "Năm xuất bản và số lượng phải là số nguyên!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Tạo mới và thêm vào database
           Book newBook = new Book(title, author, yearPublished, quantity, category, publisher);
           BookDAO bookDao = new BookDAO();
           bookDao.saveBook(newBook);


            // Cập nhật bảng sách
            DefaultTableModel tableModel = (DefaultTableModel) view.getBookTableModel();
            Object[] row = {title, author, category.toString(), publisher.toString(), yearPublished, quantity};
            tableModel.addRow(row);

            // Đóng dialog và làm mới bảng
            JOptionPane.showMessageDialog(view, "Thêm sách mới thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            view.closeAddDialog();
            view.refreshBookTable();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Đã xảy ra lỗi: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public void updateBook(int bookID, String title, String author, String categoryName, String publisherName, int yearPublished, int quantity) {
        try {
            // Hiển thị dialog cập nhật
            view.showUpdateDialog();

            // Tải danh sách category và publisher vào ComboBox
            view.loadInfoToComboBoxUD();

            // Điền thông tin vào các trường
            view.setUpdateDialogFields(title, author, categoryName, publisherName, yearPublished, quantity);

            // Xóa các ActionListener trước đó để tránh việc gắn lặp
            view.clearUpdateButtonListeners();

            // Gắn sự kiện cập nhật cho nút Update
            view.addUpdateButtonListener(evt -> {
                try {
                    // Lấy dữ liệu mới từ các trường
                    String updatedTitle = view.getUpdatedTitle();
                    String updatedAuthor = view.getUpdatedAuthor();

                    // Lấy đối tượng Category và Publisher từ ComboBox
                    Category selectedCategory = view.getSelectedCategory();
                    Publisher selectedPublisher = view.getSelectedPublisher();

                    int updatedYearPublished = view.getUpdatedYearPublished();
                    int updatedQuantity = view.getUpdatedQuantity();

                    // Cập nhật đối tượng Book
                    Book updatedBook = new Book();
                    updatedBook.setBookId(bookID); // Set ID sách
                    updatedBook.setTitle(updatedTitle);
                    updatedBook.setAuthor(updatedAuthor);
                    updatedBook.setCategory(selectedCategory);
                    updatedBook.setPublisher(selectedPublisher);
                    updatedBook.setYearPublished(updatedYearPublished);
                    updatedBook.setQuantity(updatedQuantity);

                    // Gọi DAO để cập nhật sách
                    BookDAO bookDao = new BookDAO();
                    bookDao.updateBook(updatedBook);

                    // Đóng dialog và làm mới bảng
                    view.closeUpdateDialog();
                    view.refreshBookTable();
                    JOptionPane.showMessageDialog(view, "Cập nhật sách thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(view, "Vui lòng kiểm tra lại thông tin nhập!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(view, "Đã xảy ra lỗi khi cập nhật thông tin sách!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            });

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Đã xảy ra lỗi khi thu thập thông tin sách!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

}
