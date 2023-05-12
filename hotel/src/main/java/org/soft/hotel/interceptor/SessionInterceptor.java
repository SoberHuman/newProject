package org.soft.hotel.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/**
 * 定义拦截器
 * @author Administrator
 *
 */
public class SessionInterceptor extends HandlerInterceptorAdapter {
	private static String[] IGNORE_URI = { "staffLogin", "/toPage/staff/staffLogin", "/toPage/gateway/gateway","/toPage/gateway/userLogin","/toPage/gate/clientLogin"};
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		boolean flag = false;
        String url = request.getRequestURL().toString();
		for (String s : IGNORE_URI) {
            if (url.contains(s)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
        	Object obj = request.getSession().getAttribute("staff");
        	Object objs = request.getSession().getAttribute("userss");
        	Object objss = request.getSession().getAttribute("clients");

            if (null == obj && objs == null && objss == null) {//未登录
            	if (request.getHeader("x-requested-with") != null && 
            					request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
            		
            		response.setHeader("sessionstatus", "timeout");//在响应头设置session状态  
            		response.setCharacterEncoding("text/html;charset=utf-8");
    				response.setContentType("text/html;charset=utf-8");
    				response.getWriter().print("error");
    	        } else {
    	        	response.sendRedirect(request.getContextPath()+"/toPage/staff/staffLogin");
    	        }
            	return false;
            } else {
            	/*User user = (User)obj;
            	if(!RightUtil.hasRight(currentURLTemp, request)){
            		if(!"iisAdminTmp".equals(user.getName()) && !"/index".equals(targetURL)){
            			//response.sendRedirect(request.getContextPath()+"/login/login");//应该返回到没有权限的页面
            			//request.getRequestDispatcher("/login/login").forward(request, response);
            			return false;
            		}
            	}*/
            }
        }
        return super.preHandle(request, response, handler);
    }
	 
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
}