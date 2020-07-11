/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.Usuarios;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DAYIRO
 */
@WebFilter("/*")
public class SGAFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
        // nada por ahora...
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        
        String loginURI = request.getContextPath() + "/login";
        boolean permitirURI=false;
                
        List<String> listaURI = new ArrayList<>();
        listaURI.add("/login");
        listaURI.add("/lib/.*");
        listaURI.add("/css/.*");
        listaURI.add("/images/.*");
        listaURI.add("/js/.*");


        if(!listaURI.isEmpty()){
            for(int a=0;a<listaURI.size();a++){
                /*if(request.getRequestURI().equals(listaURI.get(a))){
                    permitirURI=true;
                     System.out.println("permitir="+listaURI.get(a));
                    break;
                }*/
    
                if(Pattern.matches("^"+request.getContextPath() + listaURI.get(a), request.getRequestURI())){
                    permitirURI=true;
                    System.out.println("permitir="+listaURI.get(a));
                    break;
                }else{
                    //System.out.println("no permitir="+listaURI.get(a));
                }
            }
                

        }
        
        //System.out.println("permitirURI="+permitirURI);
        boolean loggedIn = session != null && session.getAttribute("sesionSGA") != null;
        //boolean loginRequest = request.getRequestURI().equals(loginURI);

        if (loggedIn || permitirURI) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(loginURI);
        }
        
        
        
               
    }

    @Override
    public void destroy() {
        // nada por ahora...
    }

}