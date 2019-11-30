package config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginStateInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws  Exception{
        System.out.println(request.getRequestURI());
        if (request.getRequestURI().equals("/sedesign_war_exploded/userCenter")&&
                "login".equals(request.getParameter("action"))){
            return true;
        }
        Object obj = request.getSession().getAttribute("currentUser");
        if (obj == null){
            System.out.println("obj==null");
            response.sendRedirect("/sedesign_war_exploded/userCenter?action=login");
            return  false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//            System.out.println(httpServletRequest.getParameter("action"));
//            httpServletResponse.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
//            httpServletResponse.setHeader("Pragma","no-cache");
//            httpServletResponse.setDateHeader("Expires",0);

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
