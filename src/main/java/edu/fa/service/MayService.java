package edu.fa.service;

import edu.fa.model.May;
import edu.fa.repository.MayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author PC
 * at 12/31/2023
 */
@Service
public class MayService {
    @Autowired
    private MayRepository mayRepository;

    public void save(May may) {
        mayRepository.save(may);
    }

    public void delete(May may) {
        mayRepository.delete(may);
    }

    public May findByMaMay(String maMay) {
        return mayRepository.findByMaMay(maMay);
    }

    public boolean existsByMaMay(String maMay) {
        return mayRepository.existsByMaMay(maMay);
    }

    public List<May> findAll() {
        return mayRepository.findAll();
    }

}
