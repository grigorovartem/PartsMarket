package com.grigorov.Controllers;

import com.grigorov.Entity.StorageItem;
import com.grigorov.Sorting.Sorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/sort")
public class SortController {

    @Autowired
    private Sorter sorter;

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView sort(@RequestParam(value = "condition") String condition, HttpServletRequest request){
        HttpSession session = request.getSession();
                List<StorageItem> items = (List<StorageItem>) session.getAttribute("parts");
            return new ModelAndView("UserView", "storage", sorter.sort(condition, items));
    }
}
