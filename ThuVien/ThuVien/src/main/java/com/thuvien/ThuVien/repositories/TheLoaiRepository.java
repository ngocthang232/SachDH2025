package com.thuvien.ThuVien.repositories;

import com.thuvien.ThuVien.entitys.TheLoai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheLoaiRepository extends JpaRepository<TheLoai, Integer> {
    boolean existsByTenTheLoai(String tenTheLoai);
}
