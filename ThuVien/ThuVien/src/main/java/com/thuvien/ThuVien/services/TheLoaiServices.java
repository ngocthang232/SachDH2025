package com.thuvien.ThuVien.services;

import com.thuvien.ThuVien.dto.TheLoaiDTO;
import com.thuvien.ThuVien.entitys.TheLoai;

import java.util.List;

public interface TheLoaiServices {
    List<TheLoaiDTO> getAll();
    TheLoaiDTO getById(Integer id);
    TheLoaiDTO create(TheLoaiDTO theLoaiDTO);
    TheLoaiDTO update(Integer id, TheLoaiDTO theLoaiDTO);
    void delete(Integer id);
}
