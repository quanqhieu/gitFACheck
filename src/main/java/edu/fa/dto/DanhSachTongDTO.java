package edu.fa.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author PC
 * at 1/5/2024
 */
@Data
public class DanhSachTongDTO {
        private String maKH;
        private String tenKH;
        private String maMay;
        private String viTri;
        private String trangThai;
        private LocalDate ngayBatDauSuDung;
        private LocalTime gioBatDauSuDung;
        private Long thoiGianSuDung;
        private String maDV;
        private String tenDV;
        private LocalDate ngaySuDung;
        private LocalTime gioSuDung;
        private Integer soLuong;
        private double tongTienDichVu;
        private double tongTienMay;
}
