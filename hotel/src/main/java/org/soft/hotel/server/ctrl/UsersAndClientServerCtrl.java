package org.soft.hotel.server.ctrl;


import org.soft.hotel.model.Client;
import org.soft.hotel.model.Reservation;
import org.soft.hotel.model.Users;
import org.soft.hotel.server.ClientServer;
import org.soft.hotel.server.UsersServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Map;

//会员和普通用户
@Controller
public class UsersAndClientServerCtrl {


    @Autowired
    @Qualifier("UsersServer")
    private UsersServer usersServer;

    @Autowired
    @Qualifier("ClientServer")
    private ClientServer clientServer;


    /**
     * 个人信息
     */
    @RequestMapping("personalInfo")
    public String personalInfo(HttpServletRequest request, Model model){
        String path = "error";
        int loginKey = Integer.parseInt(request.getSession().getAttribute("loginKey").toString());
        Users userss = (Users) request.getSession().getAttribute("userss");
        Client clients = (Client)request.getSession().getAttribute("clients");




        String Pass = null;
        if(loginKey==0){
            int ulength = userss.getUserPass().length();
            String th = String.join("", Collections.nCopies(ulength, "*"));;
            Pass = userss.getUserPass().replaceAll(userss.getUserPass(),th);
            model.addAttribute("Pass",Pass);
            path="/gateway/personalInfo";
        }else if(loginKey==1){
            int clength = clients.getClientPass().length();
            String th = String.join("", Collections.nCopies(clength, "*"));;
            Pass = clients.getClientPass().replaceAll(clients.getClientPass(),th);
            model.addAttribute("Pass",Pass);
            path="/gateway/personalInfo";
        }


        return path;
    }


    /**
     * 个人订单
     */
    @RequestMapping("/order")
    public String order(HttpServletRequest request,Model model){
        String path = "error";
        int loginKey = Integer.parseInt(request.getSession().getAttribute("loginKey").toString());
        Users userss = (Users) request.getSession().getAttribute("userss");
        Client clients = (Client)request.getSession().getAttribute("clients");


        if(loginKey==0){
            List<Reservation> reservations = usersServer.queryOrder(userss);
            model.addAttribute("reservations",reservations);
            path="/gateway/personalOrder";

        }

        return path;
    }

    /**
     * 用户修改密码
     */
    @RequestMapping("/personalModify")
    public String updateUsersPass(Users users, HttpServletRequest request,Model model){
        String path = "error";
        String newuPass = users.getUserPass();
        String uPass = request.getParameter("oldUserPass");
        String tuPass = request.getParameter("twoUserPass");

        Users userss = (Users) request.getSession().getAttribute("userss");
        String userPass = userss.getUserPass();
        int usersId = userss.getUsersId();

        users.setUsersId(usersId);

        if(userPass.equals(uPass)){
            if(tuPass.equals(newuPass)){
                boolean b= usersServer.personalModify(users);
                if(b){
                    path = "redirect:/toPage/gateway/userLogin";
                }
            }else {
                model.addAttribute("fail","两次密码不一致");
            }
        }else{
            model.addAttribute("fail","原密码不正确");
        }


        return path;
    }
}
