package com.thuvien.ThuVien.mapper;

import com.thuvien.ThuVien.dto.TheLoaiDTO;
import com.thuvien.ThuVien.entitys.TheLoai;

public class TheLoaiMapper {
    public static TheLoaiDTO toDTO(TheLoai entity) {
        TheLoaiDTO dto = new TheLoaiDTO();
        dto.setId(entity.getId());
        dto.setTenTheLoai(entity.getTenTheLoai());
        return dto;
    }

    public static TheLoai toEntity(TheLoaiDTO dto) {
        TheLoai entity = new TheLoai();
        entity.setId(dto.getId());
        entity.setTenTheLoai(dto.getTenTheLoai());
        return entity;
    }
}
