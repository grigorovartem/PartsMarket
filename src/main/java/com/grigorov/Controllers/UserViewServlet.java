package com.grigorov.Controllers;

import com.grigorov.DAO.*;
import com.grigorov.Entity.*;
import com.grigorov.Service.SparePartServiceImpl;
import com.grigorov.Service.StorageBuilder;
import com.grigorov.Service.StorageItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/userView")
public class UserViewServlet {

    @Autowired
    private OrderDAOImpl orderDAO;

    @Autowired
    private OrderItemDAOImpl orderItemDAO;

    @Autowired
    private SparePartServiceImpl parService;

    @Autowired
    private UserDAOImpl userDAO;

    @Autowired
    private StorageItemServiceImpl itemService;

    @Autowired
    private StorageBuilder builder;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showParts() {
        return new ModelAndView("UserView", "storage", itemService.getAll());
    }

    @RequestMapping(value = "/addPart", method = RequestMethod.POST)
    public ModelAndView addPart(@RequestParam(value = "name") String name,
                                @RequestParam(value = "price") double price,
                                @RequestParam(value = "brand") String brand,
                                @RequestParam(value = "quality") int quality,
                                HttpServletRequest request,
                                HttpServletResponse response) {

        SparePart sparePart = new SparePart(name, Brand.valueOf(brand), price);
        StorageItem item = new StorageItem(parService.add(sparePart), quality);
        itemService.add(item);
        //productStorage.add(sparePart, quality);
        return new ModelAndView("UserView", "storage", itemService.getAll());

    }

    @RequestMapping(value = "/newOrder", method = RequestMethod.GET)
    public ModelAndView newOrder(Model model, HttpServletRequest request, @AuthenticationPrincipal User user) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String login = auth.getName();
        User userDB = userDAO.getByName(login);
        Long userId = userDB.getId();   //(Long) request.getSession().getAttribute("user");
                Order order = orderDAO.mergeOrder(new Order(userDAO.getById(userId)));
        request.getSession().setAttribute("order", order.getId());
        model.addAttribute("user", userId);
        model.addAttribute("order", order.getId());

        return new ModelAndView("redirect:/userView");
    }

    @RequestMapping("/add")
    public ModelAndView add(Model model, HttpServletRequest request, @RequestParam(value = "part") Long partId) {
        HttpSession session = request.getSession();
        Long orderId = (Long) session.getAttribute("order");
        OrderItem part = orderItemDAO.mergePart(new OrderItem(parService.getById(partId), 10000));
        Order order = orderDAO.getById(orderId);
        order.addPart(part);
        Order order1 = orderDAO.mergeOrder(order);
        session.setAttribute("parts", order1.getSpareParts());
        return new ModelAndView("redirect:/userView?user=" + session.getAttribute("user") +
                "&order=" + session.getAttribute("order"));
    }
}
//public class UserViewServlet extends HttpServlet {
//
//    @Override
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("storage", PartCache.inctance().getProducts());
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/UserView.jsp");
//        dispatcher.forward(request, response);
//    }
//}
