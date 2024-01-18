package edu.fa.controller;

import edu.fa.model.KhachHang;
import edu.fa.repository.KhachHangRepository;
import edu.fa.service.KhachHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: PC
 * @date: 12/29/2023
 */

@Controller
@RequestMapping("/khachhang")
@RequiredArgsConstructor
public class KhachHangController {
    private final KhachHangRepository khachHangRepository;
    private final KhachHangService khachHangService;

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("khachHang", new KhachHang());
        model.addAttribute("successMessage", model.getAttribute("successMessage"));
        return "/khachhang/create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute("khachHang") KhachHang khachHang,
                       BindingResult bindingResult,
                       Model model,
                       RedirectAttributes redirectAttributes) {
        Map<String, String> errors = new HashMap<>();

        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
        } else if (khachHangService.existsByMaKH(khachHang.getMaKH())) {
            errors.put("maKH", "Mã khách hàng đã tồn tại.");
        }

        if (!errors.isEmpty()) {
            model.addAttribute("khachHang", khachHang);
            model.addAttribute("error", errors);
            return "/khachhang/create";
        }
        khachHangService.save(khachHang);
        redirectAttributes.addFlashAttribute("successMessage", "Tạo khách hàng thành công.");
        return "redirect:/khachhang/create";
    }

    @GetMapping
    public String showAll(@RequestParam(value = "q", required = false) String query,
                          Pageable pageable,
                          Model model) {
        Page<KhachHang> khachHangPage = khachHangRepository.findAll(query == null ? "" : query, pageable);

        model.addAttribute("query", query);
        model.addAttribute("itemList", khachHangPage.getContent());
        model.addAttribute("currentPage", khachHangPage.getNumber());
        model.addAttribute("pageSize", khachHangPage.getSize());
        model.addAttribute("totalPages", khachHangPage.getTotalPages());
        return "khachhang/showAll";
    }

    @GetMapping("/update/{maKH}")
    public String edit(@PathVariable("maKH") String maKH,
                       Model model) {
        model.addAttribute("khachHang", khachHangService.findByMaKH(maKH));
        return "khachhang/update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("khachHang") KhachHang khachHang,
                         BindingResult bindingResult,
                         Model model,
                         RedirectAttributes redirectAttributes) {
        Map<String, String> errors = new HashMap<>();

        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            model.addAttribute("error", errors);
            model.addAttribute("khachHang", khachHang);
            return "khachhang/update" ;
        }

        khachHangService.save(khachHang);
        redirectAttributes.addFlashAttribute("successMessage", "Cập nhật khách hàng thành công.");
        return "redirect:/khachhang";
    }

    @GetMapping("/delete/{maKH}")
    public String delete(@PathVariable("maKH") String maKH) {
        khachHangService.delete(khachHangService.findByMaKH(maKH));
        return "redirect:/khachhang";
    }
}