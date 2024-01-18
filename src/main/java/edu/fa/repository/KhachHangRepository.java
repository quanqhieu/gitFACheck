package edu.fa.repository;

import edu.fa.model.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author: PC
 * @date: 12/29/2023
 */

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, String> {
    boolean existsByMaKH(String maKH);

    KhachHang findByMaKH(String maKH);

    @Query(value = "SELECT * FROM KHACHHANG WHERE CONCAT(MaKH, TenKH, DiaChi, SoDienThoai, DiaChiEmail) LIKE N'%' + :query + '%'",
            countQuery = "SELECT COUNT(*) FROM KHACHHANG WHERE CONCAT(MaKH, TenKH, DiaChi, SoDienThoai, DiaChiEmail) LIKE N'%' + :query + '%'",
            nativeQuery = true)
    Page<KhachHang> findAll(@Param("query") String query, Pageable pageable);
}
