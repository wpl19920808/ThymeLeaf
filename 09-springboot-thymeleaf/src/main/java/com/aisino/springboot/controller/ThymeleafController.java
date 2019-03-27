package com.aisino.springboot.controller;

import com.aisino.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class ThymeleafController {

    @RequestMapping("/boot/index")
    public String index(Model model, HttpServletRequest request){
        User user = new User();
        user.setId(1);
        user.setPhone("18812345678");
        user.setAddress("北京海淀四季青");
        user.setEmail("abc@abc.com");
        user.setNick("john");

        model.addAttribute("user", user);
        model.addAttribute("msg", "spring boot集成thymeleaf");

        List<User> userList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            User u = new User();
            u.setId(i);
            u.setNick("name" + i);
            u.setEmail("mail"+ i);
            u.setAddress("add" + i);
            u.setPhone("phone" + i);
            userList.add(u);
        }
        model.addAttribute("userlist",userList);

        Map<String, Object> userMap = new HashMap<>();
        for(int i = 0; i < 10; ++i){
            User u = new User();
            u.setId(i);
            u.setNick("name" + i);
            u.setEmail("mail"+ i);
            u.setAddress("add" + i);
            u.setPhone("phone" + i);

            userMap.put(String.valueOf(i), u);
        }
        model.addAttribute("usermap", userMap);

        model.addAttribute("username", "张三");

        model.addAttribute("sex", 1);

        //request中放数据，在页面中可以取到
        request.setAttribute("name", "www.aisino.com");

        request.getSession().setAttribute("address", "北京海淀");

        model.addAttribute("date", new Date());
        return "index";
    }


}
