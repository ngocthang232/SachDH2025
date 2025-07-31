package com.thuvien.ThuVien.mapper;

import com.thuvien.ThuVien.dto.BookDTO;
import com.thuvien.ThuVien.entitys.Books;
import com.thuvien.ThuVien.entitys.TheLoai;
import com.thuvien.ThuVien.repositories.TheLoaiRepository;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    private final TheLoaiRepository theLoaiRepository;

    public BookMapper(TheLoaiRepository theLoaiRepository) {
        this.theLoaiRepository = theLoaiRepository;
    }

    public BookDTO toDto(Books book) {
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTenSach(book.getTenSach());
        dto.setTacGia(book.getTacGia());
        dto.setNhaXuatBan(book.getNhaXuatBan());
        dto.setNamXuatBan(book.getNamXuatBan());
        dto.setIsbn(book.getIsbn());
        dto.setSoLuong(String.valueOf(book.getSoLuong()));

        if (book.getTheLoai() != null) {
            dto.setTheLoaiId(book.getTheLoai().getId());
            dto.setTheLoaiName(book.getTheLoai().getTenTheLoai());
        }

        return dto;
    }

    public Books toEntity(BookDTO dto) {
        Books book = new Books();
        book.setId(dto.getId());
        book.setTenSach(dto.getTenSach());
        book.setTacGia(dto.getTacGia());
        book.setNhaXuatBan(dto.getNhaXuatBan());
        book.setNamXuatBan(dto.getNamXuatBan());
        book.setIsbn(dto.getIsbn());
        book.setSoLuong(Integer.valueOf(dto.getSoLuong()));

        if (dto.getTheLoaiId() != null) {
            TheLoai theLoai = theLoaiRepository.findById(dto.getTheLoaiId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy thể loại với ID: " + dto.getTheLoaiId()));
            book.setTheLoai(theLoai);
        }

        return book;
    }
}
