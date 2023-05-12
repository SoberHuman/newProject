package org.soft.hotel.controller;


import com.alipay.api.internal.util.AlipaySignature;
import org.soft.hotel.config.AlipayConfig;
import org.soft.hotel.dao.IncomeDAO;
import org.soft.hotel.model.Reservation;
import org.soft.hotel.model.Room;
import org.soft.hotel.model.RoomType;
import org.soft.hotel.model.Users;
import org.soft.hotel.server.IncomeServer;
import org.soft.hotel.server.ReservationServer;
import org.soft.hotel.server.RoomServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.*;

/**
 * @Author: Kevin·Lu
 * @Email: kevinlu98@qq.com
 * @Date: 2020/2/20 11:50 上午
 * @Description: 回调
 */
@Controller
@RequestMapping("/callback")
public class CallbackController {


    @Autowired
    @Qualifier("ReservationServer")
    private ReservationServer reservationServer;

    @Autowired
    @Qualifier("RoomServer")
    private RoomServer roomServer;

    @Autowired
    @Qualifier("IncomeServer")
    private IncomeServer incomeServer;

    @Autowired
    private IncomeDAO incomeDAO;






    /**
     * 同步回调地址 从return_url.jsp拷贝
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/return")
    public String returnUrl(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession, Model model) throws Exception {


        PrintWriter out = response.getWriter();
        //获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
        String path = "error";
        //——请在这里编写您的程序（以下代码仅作参考）——
        if (signVerified) {
            System.out.println("同步验证成功");


            Reservation reservation = (Reservation)httpSession.getAttribute("reservation");
            Users users = (Users)httpSession.getAttribute("userss");
            reservation.setReservationName(users.getUserRealName());
            reservation.setReservationIdCard(users.getUserIdCard());
            reservation.setReservationPhoneNumber(users.getUserPhone());
            int roomTypeId = reservation.getRoomTypeId();
            int reservationStatus = 0;
            reservation.setReservationStatus(reservationStatus);
            //System.out.println(reservation.getExpectedTimeOfArrival());
            RoomType roomTypeInfo = reservationServer.roomTypes(roomTypeId);
            reservation.setReservationForegift(roomTypeInfo.getReservationForegift());

            System.out.println();
            boolean reservations = false;
            //查询干净且空闲的房间
            List<Room> roomInfo = reservationServer.queryRoom(reservation.getRoomTypeId()) ;
            if(roomInfo.size()!=0){
                int roomId = 0;
                Random random = new Random();
                List<Integer> roomNumber = new ArrayList<>();
                for(Room room :roomInfo){
                    roomNumber.add(room.getRoomId());
                }
                int roomIdCount = roomNumber.size();
                int index = random.nextInt(roomIdCount);
                roomId = roomNumber.get(index);
                reservation.setRoomId(roomId);
                System.out.println("随机房号："+roomId);

                //添加预订记录
                reservations = reservationServer.reservation(reservation);
                System.out.println(reservations);
                //更改房间状态
                boolean roomState = reservationServer.UpRoomState(roomId);
                //添加收入
                int selectMenu = Integer.parseInt(request.getSession().getAttribute("selectMenu").toString());
                double Price = (double)request.getSession().getAttribute("Price");
                Map<String,Object> map = new HashMap<>();
                int staffId = 1;
                int paymentMethod = 1;
                int incomeType = 0;
                double incomeMoney = 0;
                double reservationForegift = roomTypeInfo.getReservationForegift();

                map.put("roomTypeId",roomTypeId);
                map.put("staffId",staffId);
                map.put("paymentMethod",paymentMethod);
                boolean addIncome=false;
                if(selectMenu==0){
                    incomeType =1;
                    incomeMoney = reservationForegift;
                    map.put("incomeType",incomeType);
                    map.put("incomeMoney",incomeMoney);
                     addIncome = incomeServer.addIncome(map);
//                    System.out.println(roomTypeId + "/"+staffId + "/"+paymentMethod+ "/"+incomeType+ "/"+incomeMoney);
                }else if(selectMenu==1){
                    //租金
                    incomeType =1;

                    incomeMoney = reservationForegift;
                    map.put("incomeType",incomeType);
                    map.put("incomeMoney",incomeMoney);
                     addIncome = incomeServer.addIncome(map);
//                    System.out.println(roomTypeId + "/"+staffId + "/"+paymentMethod+ "/"+incomeType+ "/"+incomeMoney);
                    //房费
                    incomeType = 0;
                    incomeMoney = Price-reservationForegift;
                    map.put("incomeType",incomeType);
                    map.put("incomeMoney",incomeMoney);
                    addIncome = incomeServer.addIncome(map);
//                    System.out.println(roomTypeId + "/"+staffId + "/"+paymentMethod+ "/"+incomeType+ "/"+incomeMoney);

                }




            }else {
                System.out.println("房间已售罄");
            }




            if(reservations) {
                Reservation reservationInfo = reservationServer.queryReservation(reservation.getReservationPhoneNumber());
                model.addAttribute("reservationInfo",reservationInfo);
                path = "/gatewayShowAllRoomType/0";
            }
        } else {
            out.println("验签失败");
        }
        //——请在这里编写您的程序（以上代码仅作参考）——
        return path;
    }

    /**
     * 异步回调地址 从notify_url.jsp拷贝
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/notify")
    public void notifyUrl(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("异步验证");
        PrintWriter out = response.getWriter();
        //获取支付宝POST过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

        //——请在这里编写您的程序（以下代码仅作参考）——

	/* 实际验证过程建议商户务必添加以下校验：
	1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
	2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
	3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
	4、验证app_id是否为该商户本身。
	*/
        if (signVerified) {//验证成功
            System.out.println("异步验证成功");
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //交易状态
            String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");

            if (trade_status.equals("TRADE_FINISHED")) {
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序
                System.out.println("订单已完成");
                //注意：
                //退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
            } else if (trade_status.equals("TRADE_SUCCESS")) {
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序
                //我们的业务代码
                System.out.println("订单付款成功");
                //注意：
                //付款完成后，支付宝系统发送该交易状态通知
            }

            out.println("success");

        } else {//验证失败
            out.println("fail");

            //调试用，写文本函数记录程序运行情况是否正常
            //String sWord = AlipaySignature.getSignCheckContentV1(params);
            //AlipayConfig.logResult(sWord);
        }

        //——请在这里编写您的程序（以上代码仅作参考）——
//        return "";
    }
}
