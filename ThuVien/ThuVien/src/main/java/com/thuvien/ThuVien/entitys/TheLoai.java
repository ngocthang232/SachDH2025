package com.thuvien.ThuVien.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "theloai")
public class TheLoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tenTheLoai", nullable = false, unique = true)
    private String tenTheLoai;

    // Gợi ý: Nếu bạn muốn hiển thị danh sách sách thuộc thể loại này
    @OneToMany(mappedBy = "theLoai")
    @JsonIgnore // tránh vòng lặp khi trả JSON
    private List<Books> books;
}