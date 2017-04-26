package com.grigorov.Controllers;

import com.grigorov.DAO.UserDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class Authorisation {

    @Autowired
    private UserDAOImpl userDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String loginPage(Model model) {
        return "index";
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public ModelAndView auth(Model model, @RequestParam(value = "login") String login,
//                             @RequestParam(value = "password") String password,
//                             HttpServletRequest request) {
//        User user = userDAO.mergeUser(new User(login, password));
//        request.getSession().setAttribute("user", user.getId());
//        model.addAttribute("user", user.getId());
//        return new ModelAndView("redirect:/UserView");
//    }
}
