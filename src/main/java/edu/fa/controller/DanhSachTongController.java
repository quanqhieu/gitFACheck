package edu.fa.controller;

import edu.fa.dto.DanhSachTongDTO;
import edu.fa.model.SuDungDichVu;
import edu.fa.model.SuDungMay;
import edu.fa.service.SuDungDichVuService;
import edu.fa.service.SuDungMayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author PC
 * at 1/5/2024
 */

@Controller
@RequestMapping("/danhSachTong")
@RequiredArgsConstructor
public class DanhSachTongController {
    private final SuDungDichVuService suDungDichVuService;
    private final SuDungMayService suDungMayService;


    @GetMapping
    public String show(Model model) {
        List<SuDungMay> suDungMayList = suDungMayService.findAll();
        List<SuDungDichVu> suDungDichVuList = suDungDichVuService.findAll();
        List<DanhSachTongDTO> danhSachTongDtoList = new ArrayList<>();

        DanhSachTongDTO dto;
        for (SuDungMay suDungMay : suDungMayList) {
            for (SuDungDichVu suDungDichVu : suDungDichVuList) {
                if(suDungMay.getId().getMaKH().equals(suDungDichVu.getId().getMaKH()) && suDungMay.getId().getNgayBatDauSuDung().equals(suDungDichVu.getId().getNgaySuDung())) {
                    dto = new DanhSachTongDTO();
                    dto.setMaKH(suDungMay.getId().getMaKH());
                    dto.setTenKH(suDungMay.getKhachHang().getTenKH());
                    dto.setMaMay(suDungMay.getId().getMaMay());
                    dto.setViTri(suDungMay.getMay().getViTri());
                    dto.setTrangThai(suDungMay.getMay().getTrangThai());
                    dto.setNgayBatDauSuDung(suDungMay.getId().getNgayBatDauSuDung());
                    dto.setGioBatDauSuDung(suDungMay.getId().getGioBatDauSuDung());
                    dto.setThoiGianSuDung(suDungMay.getThoiGianSuDung());
                    dto.setTongTienMay(suDungMay.getThoiGianSuDung() * 150);

                    dto.setMaDV(suDungDichVu.getId().getMaDV());
                    dto.setTenDV(suDungDichVu.getDichVu().getTenDV());
                    dto.setNgaySuDung(suDungDichVu.getId().getNgaySuDung());
                    dto.setGioSuDung(suDungDichVu.getId().getGioSuDung());
                    dto.setSoLuong(suDungDichVu.getSoLuong());
                    dto.setTongTienDichVu(suDungDichVu.getSoLuong() * suDungDichVu.getDichVu().getDonGia());

                    danhSachTongDtoList.add(dto);
                }
            }
        }
//        for (SuDungMay suDungMay : suDungMayList) {
//            dto = new DanhSachTongDTO();
//            dto.setMaKH(suDungMay.getId().getMaKH());
//            dto.setTenKH(suDungMay.getKhachHang().getTenKH());
//            dto.setMaMay(suDungMay.getId().getMaMay());
//            dto.setViTri(suDungMay.getMay().getViTri());
//            dto.setTrangThai(suDungMay.getMay().getTrangThai());
//            dto.setNgayBatDauSuDung(suDungMay.getId().getNgayBatDauSuDung());
//            dto.setGioBatDauSuDung(suDungMay.getId().getGioBatDauSuDung());
//            dto.setThoiGianSuDung(suDungMay.getThoiGianSuDung());
//            dto.setTongTienMay(suDungMay.getThoiGianSuDung() * 150);
//            danhSachTongDtoList.add(dto);
//        }
//
//        for (SuDungDichVu suDungDichVu : suDungDichVuList) {
//            dto = new DanhSachTongDTO();
//            dto.setMaKH(suDungDichVu.getId().getMaKH());
//            dto.setTenKH(suDungDichVu.getKhachHang().getTenKH());
//            dto.setMaDV(suDungDichVu.getId().getMaDV());
//            dto.setTenDV(suDungDichVu.getDichVu().getTenDV());
//            dto.setNgaySuDung(suDungDichVu.getId().getNgaySuDung());
//            dto.setGioSuDung(suDungDichVu.getId().getGioSuDung());
//            dto.setSoLuong(suDungDichVu.getSoLuong());
//            dto.setTongTienDichVu(suDungDichVu.getSoLuong() * suDungDichVu.getDichVu().getDonGia());
//            danhSachTongDtoList.add(dto);
//        }

//        danhSachTongDtoList.sort(Comparator.comparing(DanhSachTongDTO::getMaKH)
//                .thenComparing(Comparator.comparing(DanhSachTongDTO::getTenKH))
//                .thenComparing(
//                        Comparator.comparing(
//                                DanhSachTongDTO::getMaMay,
//                                Comparator.nullsLast(Comparator.naturalOrder())
//                        ))
//                .thenComparing(
//                        Comparator.comparing(
//                                DanhSachTongDTO::getNgayBatDauSuDung,
//                                Comparator.nullsLast(Comparator.naturalOrder())
//                        ))
//                .thenComparing(
//                        Comparator.comparing(
//                                DanhSachTongDTO::getGioBatDauSuDung,
//                                Comparator.nullsLast(Comparator.naturalOrder())
//                        ))
//                .thenComparing(
//                        Comparator.comparing(
//                                DanhSachTongDTO::getMaDV,
//                                Comparator.nullsLast(Comparator.naturalOrder())
//                        ))
//                .thenComparing(
//                        Comparator.comparing(
//                                DanhSachTongDTO::getNgaySuDung,
//                                Comparator.nullsLast(Comparator.naturalOrder())
//                        ))
//                .thenComparing(
//                        Comparator.comparing(
//                                DanhSachTongDTO::getGioSuDung,
//                                Comparator.nullsLast(Comparator.naturalOrder())
//                        ))
//
//        );

        model.addAttribute("dtoList", danhSachTongDtoList);

        return "danhSachTong";
    }
}
