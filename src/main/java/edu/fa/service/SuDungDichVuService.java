package edu.fa.service;

import edu.fa.model.SuDungDichVu;
import edu.fa.repository.SuDungDichVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @author PC
 * at 12/31/2023
 */

@Service
public class SuDungDichVuService {
    @Autowired
    private SuDungDichVuRepository suDungDichVuRepository;



    public List<SuDungDichVu> findAll() {
        return suDungDichVuRepository.findAll();
    }
    public void save(SuDungDichVu suDungDichVu) {
        suDungDichVuRepository.save(suDungDichVu);
    }
}
