package com.thuvien.ThuVien.controllers;

import com.thuvien.ThuVien.dto.BookDTO;
import com.thuvien.ThuVien.entitys.Books;
import com.thuvien.ThuVien.mapper.BookMapper;
import com.thuvien.ThuVien.services.BookServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookControllers {
    private final BookServices bookService;
    private final BookMapper bookMapper;

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<Books> books = bookService.findAll();
        List<BookDTO> bookDTOs = books.stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(bookDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Integer id) {
        Books book = bookService.findById(id);
        return ResponseEntity.ok(bookMapper.toDto(book));
    }

    @PostMapping("/add")
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        Books book = bookMapper.toEntity(bookDTO);
        Books savedBook = bookService.save(book);
        return new ResponseEntity<>(bookMapper.toDto(savedBook), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Integer id, @RequestBody BookDTO bookDTO) {
        bookDTO.setId(id);
        Books book = bookMapper.toEntity(bookDTO);
        Books updatedBook = bookService.update(book);
        return ResponseEntity.ok(bookMapper.toDto(updatedBook));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
