package com.thuvien.ThuVien.services.Impl;

import com.thuvien.ThuVien.entitys.Books;
import com.thuvien.ThuVien.entitys.TheLoai;
import com.thuvien.ThuVien.repositories.BooksRepository;
import com.thuvien.ThuVien.repositories.TheLoaiRepository;
import com.thuvien.ThuVien.services.BookServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookServices {

    private final BooksRepository bookRepository;
    private final TheLoaiRepository theLoaiRepository;

    @Override
    public List<Books> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Books findById(Integer id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    @Override
    public Books save(Books book) {
        // kiểm tra theLoai tồn tại
        if (book.getTheLoai() != null && book.getTheLoai().getId() != null) {
            TheLoai theLoai = theLoaiRepository.findById(book.getTheLoai().getId())
                    .orElseThrow(() -> new RuntimeException("Thể loại không tồn tại"));
            book.setTheLoai(theLoai);
        }
        return bookRepository.save(book);
    }

    @Override
    public Books update(Books book) {
        Books existing = bookRepository.findById(book.getId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        existing.setTenSach(book.getTenSach());
        existing.setTacGia(book.getTacGia());
        existing.setNhaXuatBan(book.getNhaXuatBan());
        existing.setNamXuatBan(book.getNamXuatBan());
        existing.setIsbn(book.getIsbn());
        existing.setSoLuong(book.getSoLuong());

        if (book.getTheLoai() != null && book.getTheLoai().getId() != null) {
            TheLoai theLoai = theLoaiRepository.findById(book.getTheLoai().getId())
                    .orElseThrow(() -> new RuntimeException("Thể loại không tồn tại"));
            existing.setTheLoai(theLoai);
        }

        return bookRepository.save(existing);
    }

    @Override
    public void delete(Integer id) {
        Books book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
        bookRepository.delete(book);
    }
}
