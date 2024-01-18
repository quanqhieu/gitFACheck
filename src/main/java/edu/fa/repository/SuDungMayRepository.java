package edu.fa.repository;

import edu.fa.model.SuDungMay;
import edu.fa.model.SuDungMayId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author: PC
 * @date: 1/2/2024
 */

@Repository
public interface SuDungMayRepository extends JpaRepository<SuDungMay, SuDungMayId> {

}
