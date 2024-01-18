package edu.fa.repository;

import edu.fa.model.May;
import edu.fa.model.SuDungDichVu;
import edu.fa.model.SuDungDichVuId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

/**
 * @author: PC
 * @date: 1/2/2024
 */

@Repository
public interface SuDungDichVuRepository extends JpaRepository<SuDungDichVu, SuDungDichVuId> {

}
