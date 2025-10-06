package poly.edu.controller.lab4;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import poly.edu.model.lab4.Staff;

@Controller
@RequestMapping("/lab4/staff")
class StaffController {

    @RequestMapping("/create/form")
    public String createForm(Model model, @ModelAttribute("staff") Staff staff) {
        model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
        return "lab4/create-staff";
    }

    @RequestMapping("create/save")
    public String createSave(Model model, @Valid @ModelAttribute("staff") Staff staff, Errors errors,
                             @RequestParam(value = "photo_file", required = false) MultipartFile photoFile) {
        // Gán tên ảnh được upload vào bean staff
        if (photoFile != null && !photoFile.isEmpty()) {
            staff.setPhoto(photoFile.getOriginalFilename());
        }

        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau!");
            return "lab4/create-staff";
        } else model.addAttribute("message", "Xin chào " + staff.getName());

        return "/lab4/create-staff";
    }
}
