package pl.grandhotel.grandhotel.controller.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.grandhotel.grandhotel.servises.UserService;

@Controller
@RequestMapping("/grandhotel")
public class UsersController {

    @Autowired
    UserService userService;


}
