package edu.fa.repository;

import edu.fa.model.DichVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author: PC
 * @date: 12/30/2023
 */

@Repository
public interface DichVuRepository extends JpaRepository<DichVu, String> {
    boolean existsByMaDV(String maDV);

    DichVu findByMaDV(String maDV);

    @Query(value = "SELECT * FROM DICHVU WHERE CONCAT(MaDV, TenDV, DonViTinh, DonGia) LIKE N'%' + :query + '%'",
            countQuery = "SELECT * FROM DICHVU WHERE CONCAT(MaDV, TenDV, DonViTinh, DonGia) LIKE N'%' + :query + '%'",
            nativeQuery = true)
    Page<DichVu> findAll(@Param("query") String query, Pageable pageable);
}
