package edu.fa.repository;

import edu.fa.model.May;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author: PC
 * @date: 12/28/2023
 */

@Repository
public interface MayRepository extends JpaRepository<May, String> {
    boolean existsByMaMay(String maMay);

    May findByMaMay(String maMay);

    @Query(value = "SELECT * FROM MAY WHERE CONCAT(MaMay, TrangThai, ViTri) LIKE N'%' + :query + '%'",
            countQuery = "SELECT COUNT(*) FROM MAY WHERE CONCAT(MaMay, TrangThai, ViTri) LIKE N'%'+:query+'%'",
            nativeQuery = true)
    Page<May> findAll(@Param("query") String query, Pageable pageable);

}
