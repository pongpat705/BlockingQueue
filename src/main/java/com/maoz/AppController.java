package com.maoz;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AppController {

    @GetMapping("/app")
    public String block(Model model, @RequestParam(name = "name", required = false, defaultValue = "World") String name){
        model.addAttribute("name", name);
        return "app";
    }
}
