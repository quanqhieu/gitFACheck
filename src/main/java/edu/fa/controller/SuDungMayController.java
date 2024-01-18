package edu.fa.controller;

import edu.fa.model.SuDungMay;
import edu.fa.service.KhachHangService;
import edu.fa.service.MayService;
import edu.fa.service.SuDungMayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: PC
 * @date: 1/2/2024
 */

@Controller
@RequestMapping("/sudungmay")
@RequiredArgsConstructor
public class SuDungMayController {
    private final SuDungMayService suDungMayService;
    private final MayService mayService;
    private final KhachHangService khachHangService;


    @GetMapping
    public String show(Model model) {
        model.addAttribute("mayList", mayService.findAll());
        model.addAttribute("khachHangList", khachHangService.findAll());
        model.addAttribute("suDungMay", new SuDungMay());

        return "may/use";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute("suDungMay") SuDungMay suDungMay,
                       BindingResult bindingResult,
                       Model model,
                       RedirectAttributes redirectAttributes) {
        Map<String, String> errors = new HashMap<>();

        if (bindingResult.hasErrors()) {
            model.addAttribute("mayList", mayService.findAll());
            model.addAttribute("khachHangList", khachHangService.findAll());
            model.addAttribute("suDungMay", suDungMay);
            model.addAttribute("error", bindingResult.getFieldErrors().stream()
                    .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)));
            return "may/use";
        }

        suDungMayService.save(suDungMay);
        redirectAttributes.addFlashAttribute("successMessage", "Sử dụng máy thành công.");
        return "redirect:/sudungmay";
    }
}
