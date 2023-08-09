package pl.grandhotel.grandhotel.controller.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.grandhotel.grandhotel.servises.users.UserService;

@Controller
@RequestMapping("/grandhotel")
public class UsersController {

    @Autowired
    UserService userService;

    @GetMapping
    public String hello(Model model) {
        return "/grandHotel/index.html";
    }

}
