package org.practica1.sesion4;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import pack.Usuario;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("mensaje", "Acceso a la URL raiz");
		return "home";
	}
	
	@RequestMapping(value = "/ListaUsuarios", method = RequestMethod.POST)
	public class ListaUsuarios extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String login = request.getParameter("name");
			String password = request.getParameter("pass");
			
			ArrayList<Usuario> usuarios = new ArrayList<Usuario> ();
			Usuario user1 = new Usuario ("Manuel","Casquel Orzaes", "maco0007@ujaen.es", "123456789", "23005");
			Usuario user2 = new Usuario ("Marta","Gonzalez Gonzalez","mgg00079@ujaen.es", "789456123", "23006");
			usuarios.add(user1);
			usuarios.add(user2);
			request.setAttribute("usuarios", usuarios);
			
			if (login.equals("servicios") && password.equals("servicios")) {
				String url="/listausuarios.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
			}
			else {
				String url="/Sesion";
				getServletContext().getRequestDispatcher(url).forward(request, response);
			}
			
		}

	}
	
	@RequestMapping(value = "/Sesion", method = RequestMethod.POST)
	public class Sesion extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
		private String nom = null;
		private String ape = null;
		private String ema = null;
		private String tel = null;
		private String cod = null;

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
			HttpSession session = request.getSession(true); //En caso de que no exista la sesion, la crea.
			session.setMaxInactiveInterval(60); //El valor es en segundos.
			response.setContentType("text/html");
			
			
			nom=request.getParameter("nombre");
			ape=request.getParameter("apellidos");
			ema=request.getParameter("useremail");
			tel=request.getParameter("telefono");
			cod=request.getParameter("codpost");
			
			Usuario usuario = (Usuario)session.getAttribute("usuario");
			String url ="";
			
			if (usuario == null) {
				if(nom == null && ape == null && ema == null && tel == null && cod == null) {
					url = "/registrosesion.jsp";
					getServletContext().getRequestDispatcher(url).forward(request, response);
				}
				else {
					
					Usuario user = new Usuario(nom, ape, ema, tel, cod);
					request.setAttribute("usuario", user);
					session.setAttribute("usuario", user);
					url = "/registro.jsp";
					getServletContext().getRequestDispatcher(url).forward(request, response);
				}
			}
			else {
				url = "/registro.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
			}
			//return "home";
		}
		//return "home";
	}
	//return "home";
}
