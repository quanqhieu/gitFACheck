    package edu.fa.controller;

    import edu.fa.model.DichVu;
    import edu.fa.repository.DichVuRepository;
    import edu.fa.service.DichVuService;
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
     * @date: 12/30/2023
     */

    @Controller
    @RequestMapping("/dichvu")
    @RequiredArgsConstructor
    public class DichVuController {
        private final DichVuRepository dichVuRepository;
        private final DichVuService dichVuService;

        @GetMapping("/create")
        public String create(Model model) {
            model.addAttribute("dichVu", new DichVu());
            return "/dichvu/create";
        }

        @PostMapping("/create")
        public String save(@Valid @ModelAttribute("dichVu") DichVu dichVu,
                           BindingResult bindingResult,
                           Model model,
                           RedirectAttributes redirectAttributes) {
            Map<String, String> errors = new HashMap<>();
            if (bindingResult.hasErrors()) {
                for (FieldError error : bindingResult.getFieldErrors()) {
                    errors.put(error.getField(), error.getDefaultMessage());
                }
            } else if (dichVuService.existsByMaDV(dichVu.getMaDV())) {
                errors.put("maDV", "Mã dịch vụ đã tồn tại.");
            }
            if (!errors.isEmpty()) {
                model.addAttribute("dichVu", dichVu);
                model.addAttribute("error", errors);
                return "/dichvu/create";
            }
            dichVuService.save(dichVu);
            redirectAttributes.addFlashAttribute("successMessage", "Tạo mới dịch vụ thành công.");
            return "redirect:/dichvu/create";
        }

        @GetMapping
        public String showAll(@RequestParam(value = "q", required = false) String query,
                              Pageable pageable,
                              Model model) {
            Page<DichVu> dichVuPage = dichVuRepository.findAll(query == null ? "" : query, pageable);
//            Page<DichVu> dichVuPage = dichVuService.findAll();

            model.addAttribute("query", query);
            model.addAttribute("itemList", dichVuPage.getContent());
            model.addAttribute("currentPage", dichVuPage.getNumber());
            model.addAttribute("pageSize", dichVuPage.getSize());
            model.addAttribute("totalPages", dichVuPage.getTotalPages());
            return "dichvu/showAll";
        }

        @GetMapping("/update/{maDV}")
        public String edit(@PathVariable("maDV") String maDV,
                           Model model) {
            model.addAttribute("dichVu", dichVuService.findByMaDV(maDV));
            return "dichvu/update";
        }

        @PostMapping("/update")
        public String update(@Valid @ModelAttribute("dichVu") DichVu dichVu,
                             BindingResult bindingResult,
                             Model model,
                             RedirectAttributes redirectAttributes) {
            Map<String, String> errors = new HashMap<>();

            if (bindingResult.hasErrors()) {
                for (FieldError error : bindingResult.getFieldErrors()) {
                    errors.put(error.getField(), error.getDefaultMessage());
                }
                model.addAttribute("error", errors);
                model.addAttribute("dichVu", dichVu);
                return "dichvu/update";
            }


            dichVuService.save(dichVu);
            redirectAttributes.addFlashAttribute("successMessage", "Cập nhật dịch vụ thành công.");
            return "redirect:/dichvu" ;
        }

        @GetMapping("/delete/{maDV}")
        public String delete(@PathVariable("maDV") String maDV) {
            dichVuService.delete(dichVuService.findByMaDV(maDV));
            return "redirect:/dichvu";
        }
    }
