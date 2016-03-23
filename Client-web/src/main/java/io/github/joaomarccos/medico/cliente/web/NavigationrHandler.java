package io.github.joaomarccos.medico.cliente.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
public class NavigationrHandler extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("username") == null) {
            response.sendRedirect("/");
            return false;
        }

        return true;
    }

}
