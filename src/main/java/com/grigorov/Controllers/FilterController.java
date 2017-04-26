package com.grigorov.Controllers;

import com.grigorov.DAO.Predicates;
import com.grigorov.Entity.StorageItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//import com.grigorov.Service.ProductStorage;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/userView/filter")
public class FilterController {

    @Autowired
    private Predicates predicates;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView filterByPrice(@RequestParam(value = "pattern") String pattern,
                                      HttpServletRequest request){
        List<StorageItem> parts = predicates.filter(predicates.namePredicate(pattern));
        request.getSession().setAttribute("parts", parts);
        return new ModelAndView("UserView", "storage", parts);
    }

    @RequestMapping(value = "/price", method = RequestMethod.POST)
    public ModelAndView filterByPrice(@RequestParam(value = "priceFrom") double priceFrom,
                                      @RequestParam(value = "priceTo") double priceTo,
    HttpServletRequest request) {
        List<StorageItem> parts = predicates.filter(predicates.pricePredicate(priceFrom, priceTo));
        request.getSession().setAttribute("parts", parts);
        return new ModelAndView("UserView", "storage", parts);
    }

//    @Override
//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ProductStorage.getInctance().filter(
//                PartVerificator.priceBetween(Double.parseDouble(request.getParameter("priceFrom")),
//                        Double.parseDouble(request.getParameter("priceTo"))));
//        response.sendRedirect(String.format("%s%s", request.getContextPath(), "/"));
//    }
}
