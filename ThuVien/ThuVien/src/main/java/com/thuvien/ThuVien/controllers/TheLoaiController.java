package com.thuvien.ThuVien.controllers;

import com.thuvien.ThuVien.dto.TheLoaiDTO;
import com.thuvien.ThuVien.services.TheLoaiServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theloai")
@CrossOrigin(origins = "*") // Cho phép gọi từ FE
public class TheLoaiController {

    @Autowired
    private TheLoaiServices theLoaiService;

    @GetMapping
    public List<TheLoaiDTO> getAll() {
        return theLoaiService.getAll();
    }

    @GetMapping("/{id}")
    public TheLoaiDTO getById(@PathVariable Integer id) {
        return theLoaiService.getById(id);
    }

    @PostMapping("/add")
    public TheLoaiDTO create(@Validated @RequestBody TheLoaiDTO dto) {
        return theLoaiService.create(dto);
    }

    @PutMapping("/{id}")
    public TheLoaiDTO update(@PathVariable Integer id, @RequestBody TheLoaiDTO dto) {
        return theLoaiService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        theLoaiService.delete(id);
    }
}
