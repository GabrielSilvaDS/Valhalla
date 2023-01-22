package com.example.demo.configuration;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AutorizadorInterceptor implements HandlerInterceptor{
	
private static final String[] RECURSOS_LIVRES = {"/","/solicitarSenha","/cadastrarUsuario","/esqueciSenha","/efetuarCadastro","/css","/assets","/efetuarLogin","/svg","/index"};
//pesquisar como não bloquear o front
	/*@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		
		for (String recurso: RECURSOS_LIVRES) {
			if (request.getRequestURL().toString().endsWith(recurso)) {
				//System.out.println(recurso +"- TERMINA COM RECURSO.");
				return true;
			}
		}
        
		if (request.getSession().getAttribute("usuarioLogado") == null) {	
			//System.out.println("var USUARIOLOGADO == NULL");
			request.getRequestDispatcher("redirect:/").forward(request, response); // redirecionar para outra página	
			return false;
		} else {
			//System.out.println("var USUARIOLOGADO DIF NULL");
			return true;
		}
	}*/
}
