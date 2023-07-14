package com.example.korail.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.korail.dto.SessionDto;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.korail.dto.SessionDto;

public class SessionAuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {

			HttpSession session = request.getSession();
			SessionDto svo = (SessionDto)session.getAttribute("svo");

			if (svo == null) {
				String requestURI = request.getRequestURI();
				if (requestURI.equals("reservation_main")) {
					response.sendRedirect("/login2");
				} else if (requestURI.equals("mypage")) {
					response.sendRedirect("/mylogin");
				} else if (requestURI.equals("s_reservation")) {
					response.sendRedirect("s_reservation");
				} else {
					response.sendRedirect("login");
				}
			}
			return false;
		}
}
