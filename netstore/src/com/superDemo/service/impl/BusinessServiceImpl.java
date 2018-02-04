package com.superDemo.service.impl;

import com.superDemo.commons.Page;
import com.superDemo.dao.BookDao;
import com.superDemo.dao.CategoryDao;
import com.superDemo.dao.CustomerDao;
import com.superDemo.dao.impl.BookDaoImpl;
import com.superDemo.dao.impl.CategoryDaoImpl;
import com.superDemo.dao.impl.CustomerDaoImpl;
import com.superDemo.domain.Book;
import com.superDemo.domain.Category;
import com.superDemo.domain.Customer;
import com.superDemo.service.BusinessService;

import java.util.List;
import java.util.UUID;

public class BusinessServiceImpl implements BusinessService {
    private CategoryDao categoryDao = new CategoryDaoImpl();
    private BookDao bookDao = new BookDaoImpl();
    private CustomerDao customerDao  = new CustomerDaoImpl();

    @Override
    public void addCategory(Category category) {
        category.setId(UUID.randomUUID().toString());
        categoryDao.save(category);
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryDao.findAll();
    }

    @Override
    public Category findCategoryById(String categoryId) {
        return categoryDao.findById(categoryId);
    }

    @Override
    public void addBook(Book book) {
        book.setId(UUID.randomUUID().toString());
        bookDao.save(book);
    }

    @Override
    public Page findAllBookPageRecords(String pagenum) {
        int currentPageNum = 1;
        if(pagenum != null){
            currentPageNum = Integer.parseInt(pagenum);
        }
        int totalRecords = bookDao.findAllBooksNumber();
        Page page = new Page(currentPageNum, totalRecords);
        page.setRecords(bookDao.findPageBooks(page.getStartIndex(), page.getPageSize()));
        return page;
    }

    @Override
    public Page findAllBookPageRecords(String pagenum, String categoryId) {
        int currentPageNum = 1;
        if(pagenum!=null){
            currentPageNum = Integer.parseInt(pagenum);
        }
        int totalRecords = bookDao.findCategoryBooksNumber(categoryId);
        Page page = new Page(currentPageNum, totalRecords);

        page.setRecords(bookDao.findPageBooks(page.getStartIndex(), page.getPageSize(),categoryId));

        return page;
    }

    @Override
    public Book findBookById(String bookId) {
        return bookDao.findById(bookId);
    }

    @Override
    public void regitsCustomer(Customer c) {
        c.setId(UUID.randomUUID().toString());
        customerDao.save(c);
    }

    @Override
    public void activeCustomer(String code) {
        Customer customer = customerDao.findByCode(code);
        customer.setActived(true);
        customerDao.update(customer);
    }

    @Override
    public Customer customerLogin(String username, String password) {
        Customer c = customerDao.findCustomer(username, password);
        if(c == null || !c.isActived()){
            return null;
        }
        return c;
    }
}
