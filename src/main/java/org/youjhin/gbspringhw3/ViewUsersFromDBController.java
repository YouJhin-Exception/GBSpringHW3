package org.youjhin.gbspringhw3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ViewUsersFromDBController {

    private final DataProcessingService dataProcessingService;

    public ViewUsersFromDBController(DataProcessingService dataProcessingService) {
        this.dataProcessingService = dataProcessingService;
    }


    @GetMapping(value = "/all")
    public String getAllUsersFromDB(Model model){
        List<User> users = dataProcessingService.getAllUsersFromBase();
        model.addAttribute("users", users);
        return "allUsers";
    }



}
