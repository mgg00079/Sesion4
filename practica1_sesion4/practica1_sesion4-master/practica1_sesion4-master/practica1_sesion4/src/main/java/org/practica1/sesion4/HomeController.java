package org.practica1.sesion4;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

import org.practica1.sesion4.*;
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private DaoUsuarioInterface dao;
	/**
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {	
		String salir = request.getParameter("sesion");
		
		if (salir.equals("fin")){
			request.removeAttribute("usuario");
			return "home";
		}
		else
			return "home";
	}
	
	/**
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public String login(Model model, HttpServletRequest request){
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		ArrayList<DtoUsuario> lista =  (ArrayList<DtoUsuario>) dao.leerUsuarios();
		
		if (user.equals("admin") && pass.equals("admin")){
			model.addAttribute(lista);
			return "listausuarios";
		}
		else{
			return sesion(model, request);
		}
	}
	
	/**
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/Sesion", method = RequestMethod.POST)
	public String sesion(Model model, HttpServletRequest request){
				
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(60); 
		
		String nom=request.getParameter("nombre");
		String ape=request.getParameter("apellidos");
		String ema=request.getParameter("useremail");
		String pas=request.getParameter("pass");
		String tel=request.getParameter("telefono");
		String cod=request.getParameter("codpost");
		
		DtoUsuario usuario = (DtoUsuario)session.getAttribute("usuario");
		
		if (usuario == null) {
			if(nom == null && ape == null && ema == null && pas == null && tel == null && cod == null) {
				return "registrosesion";
			}
			else {
				DtoUsuario usu = new DtoUsuario(nom, ape, ema, pas, tel, cod, false);
				dao.insertarUsuario(usu);
				model.addAttribute(usu);
				session.setAttribute("usuario", usu);
				return "usuarioregistrado";
			}
		}
		else {
			return "usuarioregistrado";
		}
	}
}
