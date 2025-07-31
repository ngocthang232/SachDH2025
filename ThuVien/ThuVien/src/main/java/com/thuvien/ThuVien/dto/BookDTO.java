package com.thuvien.ThuVien.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Integer id;
    private String tenSach;
    private String tacGia;
    private String nhaXuatBan;
    private Integer namXuatBan;
    private String isbn;
    private String soLuong;

    private Integer theLoaiId;   // chỉ cần ID của thể loại
    private String theLoaiName;  // tên thể loại (để hiển thị nếu cần)
}