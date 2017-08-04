package com.example.filter;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.*;

/**
 * Created by zxh on 16/8/15.
 */
@Aspect
@Component
@EnableAspectJAutoProxy
public class EmptyAspect {
    private static Logger logger = LoggerFactory.getLogger(EmptyAspect.class);
    private final static String PASS_URI_EMPTY = "/";
    private final static String PASS_URI_LOGIN = "/login";
    private final static String TOKEN = "token";
    
    public final static String USER_LOGIN_SESSION="usermsg";

    ThreadLocal<Map<String,Object>> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.example.controller..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        Map<String,Object> params = new HashMap<>();
        params.put(SPEND_TIME,System.currentTimeMillis());
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session=request.getSession();
        try {
        		String url=request.getRequestURL().toString();
        		
        		//如果是登陆，放行
    			//如果不是登陆请求，需要验证身份信息 map(username:password+id)
        		if(!url.contains("zj/loginapp")||url.contains("zj/errorforword")) {
        			@SuppressWarnings("unchecked")
        			Map<String,String> usermap = (Map<String, String>)session.getAttribute(USER_LOGIN_SESSION);
        			String username=request.getParameter("username");
            		String password=request.getParameter("password");
            		String userid=request.getParameter("userid");
            		StringBuffer sb=new StringBuffer();
            		sb.append(password).append(userid);
            		if(!usermap.containsKey(username)||!usermap.get(username).equals(sb.toString())) {
            			request.setAttribute("msg", "{\"result\":\"1\",\"message\":\"" + "用户信息错误，请重新登陆" + "\"}");
                        try {
                            request.getRequestDispatcher("/zj/errorforword").forward(request, attributes.getResponse());
                        } catch (ServletException se) {
                            se.printStackTrace();
                        } catch (IOException ie) {
                            ie.printStackTrace();
                     }
            		}
        		}
        }catch (Exception e){
            request.setAttribute("msg", "{\"result\":\"1\",\"message\":\"" + "无权限" + "\"}");
            try {
                request.getRequestDispatcher("/zj/errorforword").forward(request, attributes.getResponse());
            } catch (ServletException se) {
                se.printStackTrace();
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        }
        Map<String,String[]> paramsMap = request.getParameterMap();
        if(null != paramsMap && paramsMap.size() > 0){
            Map<String, String> delParams = new HashMap<>(paramsMap.size());
            paramsMap.forEach((key,val)->{

            });
            params.put(ARGS,delParams);
        }
        // 记录下请求内容
        params.put(URL,request.getRequestURL().toString());
        params.put(HTTP_METHOD,request.getMethod());
        params.put(IP,getIpAddress(request));
        startTime.set(params);

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
//        if (ret instanceof List || ret instanceof Map){
//            startTime.get().put(RESPONSE,  JSON.toJSONString(ret));
//        }else {
//            startTime.get().put(RESPONSE, ret);
//        }
        startTime.get().put(SPEND_TIME,System.currentTimeMillis() - Long.valueOf(startTime.get().get(SPEND_TIME).toString()));
        logger.info(JSON.toJSONString(startTime.get()));
    }

    private String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader(X_REAL_IP);//先从nginx自定义配置获取
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(X_FORWARDED_FOR);
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(PROXY_CLIENT_IP);
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(WL_PROXY_CLIENT_IP);
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

//    private final static String PASS_URI_EMPTY = "/";
//    private final static String PASS_URI_LOGIN = "/da/v1/login";
    private final static String X_REAL_IP = "X-real-ip";
    private final static String X_FORWARDED_FOR = "x-forwarded-for";
    private final static String PROXY_CLIENT_IP = "Proxy-Client-IP";
    private final static String WL_PROXY_CLIENT_IP = "WL-Proxy-Client-IP";
    private final static String UNKNOWN = "unknown";
    private final static String URL = "URL";
    private final static String IP = "IP";
    private final static String HTTP_METHOD = "HTTP_METHOD";
    private final static String ARGS = "ARGS";
    private final static String RESPONSE = "RESPONSE";
    private final static String SPEND_TIME = "SPEND_TIME";
}
