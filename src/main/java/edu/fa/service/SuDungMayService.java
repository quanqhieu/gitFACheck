package edu.fa.service;


import edu.fa.model.SuDungMay;
import edu.fa.repository.SuDungMayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

/**
 * @author PC
 * at 12/31/2023
 */
@Service
public class SuDungMayService {
    @Autowired
    private SuDungMayRepository suDungMayRepository;

    public List<SuDungMay> findAll() {
        return suDungMayRepository.findAll();
    }
    public void save(SuDungMay suDungMay) {
        suDungMayRepository.save(suDungMay);
    }

}
