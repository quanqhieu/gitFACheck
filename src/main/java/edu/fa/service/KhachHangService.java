package edu.fa.service;

import edu.fa.model.DichVu;
import edu.fa.model.KhachHang;
import edu.fa.repository.KhachHangRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author PC
 * at 12/31/2023
 */
@Service
@RequiredArgsConstructor
public class KhachHangService {

    private final KhachHangRepository khachHangRepository;
    public void save(KhachHang kh) {
        khachHangRepository.save(kh);
    }

    public void delete(KhachHang kh) {
        khachHangRepository.delete(kh);
    }

    public KhachHang findByMaKH(String maKH) {
        return khachHangRepository.findByMaKH(maKH);
    }

    public boolean existsByMaKH(String maKH) {
        return khachHangRepository.existsByMaKH(maKH);
    }

    public List<KhachHang> findAll() {
        return khachHangRepository.findAll();
    }

}
