package com.thuvien.ThuVien.repositories;

import com.thuvien.ThuVien.entitys.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {
    boolean existsByIsbn(String isbn);
}
