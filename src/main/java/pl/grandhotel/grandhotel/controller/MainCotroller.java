package pl.grandhotel.grandhotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.grandhotel.grandhotel.servises.RoomService;

@Controller
@RequestMapping("")
public class MainCotroller {
    @Autowired
    RoomService roomService;

    @GetMapping
    public String main(Model model){
        var rooms = roomService.getAllRooms();

        model.addAttribute("rooms", rooms);
        return "/grandHotel/index.html";
    }

}
