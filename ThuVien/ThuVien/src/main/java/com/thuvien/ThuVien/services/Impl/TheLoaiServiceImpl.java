package com.thuvien.ThuVien.services.Impl;

import com.thuvien.ThuVien.dto.TheLoaiDTO;
import com.thuvien.ThuVien.entitys.TheLoai;
import com.thuvien.ThuVien.mapper.TheLoaiMapper;
import com.thuvien.ThuVien.repositories.TheLoaiRepository;
import com.thuvien.ThuVien.services.TheLoaiServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheLoaiServiceImpl implements TheLoaiServices {

    private final TheLoaiRepository theLoaiRepository;

    public TheLoaiServiceImpl(TheLoaiRepository theLoaiRepository) {
        this.theLoaiRepository = theLoaiRepository;
    }

    @Override
    public List<TheLoaiDTO> getAll() {
        return theLoaiRepository.findAll()
                .stream()
                .map(TheLoaiMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TheLoaiDTO getById(Integer id) {
        TheLoai theLoai = theLoaiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thể loại"));
        return TheLoaiMapper.toDTO(theLoai);
    }

    @Override
    public TheLoaiDTO create(TheLoaiDTO dto) {
        if (theLoaiRepository.existsByTenTheLoai(dto.getTenTheLoai())) {
            throw new RuntimeException("Thể loại đã tồn tại!");
        }
        TheLoai theLoai = TheLoaiMapper.toEntity(dto);
        return TheLoaiMapper.toDTO(theLoaiRepository.save(theLoai));
    }

    @Override
    public TheLoaiDTO update(Integer id, TheLoaiDTO dto) {
        TheLoai theLoai = theLoaiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thể loại"));

        theLoai.setTenTheLoai(dto.getTenTheLoai());
        return TheLoaiMapper.toDTO(theLoaiRepository.save(theLoai));
    }

    @Override
    public void delete(Integer id) {
        if (!theLoaiRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy thể loại");
        }
        theLoaiRepository.deleteById(id);
    }
}
