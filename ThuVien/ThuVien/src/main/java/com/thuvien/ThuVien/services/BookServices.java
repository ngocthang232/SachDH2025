package com.thuvien.ThuVien.services;

import com.thuvien.ThuVien.entitys.Books;

import java.util.List;
import java.util.Optional;

public interface BookServices {
    List<Books> findAll();
    Books findById(Integer id);
    Books save(Books book);
    Books update(Books book);
    void delete(Integer id);
}
