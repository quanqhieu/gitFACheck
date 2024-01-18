package edu.fa.service;

import edu.fa.model.DichVu;
import edu.fa.repository.DichVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author PC
 * at 12/31/2023
 */
@Service
public class DichVuService {
    @Autowired
    private DichVuRepository dichVuRepository;

    public void save(DichVu dv) {
        dichVuRepository.save(dv);
    }

    public void delete(DichVu dv) {
        dichVuRepository.delete(dv);
    }

    public DichVu findByMaDV(String maDV) {
        return dichVuRepository.findByMaDV(maDV);
    }

    public List<DichVu> findAll() {
        return dichVuRepository.findAll();
    }

    public boolean existsByMaDV(String maDV) {
        return dichVuRepository.existsByMaDV(maDV);
    }

}
