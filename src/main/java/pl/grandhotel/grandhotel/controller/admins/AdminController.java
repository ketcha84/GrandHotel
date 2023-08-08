package pl.grandhotel.grandhotel.controller.admins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.grandhotel.grandhotel.repositories.Adminrepository;

@Controller
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    Adminrepository adminrepository;

    @GetMapping
    public String admins(Model model) {
        model.addAttribute("admins", adminrepository.findAll());
        return "/admin/admins.html";
    }


}
