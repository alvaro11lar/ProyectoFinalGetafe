package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import daos.RolDao;
import daos.UsuarioDao;
import entities.Roles;
import entities.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ServletLogin
 */
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletLogin() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Esta entrando al init");
		RolDao roldao = new RolDao();
		System.out.println(roldao.isVacio());
		if(roldao.isVacio()) {
		System.out.println("aaaa");
		roldao.agregarUsuario(new Roles("Usuario"));
		roldao.agregarUsuario(new Roles("Administrador"));
		}
	}

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UsuarioDao udao = new UsuarioDao();
		if(request.getParameter("accion").equals("eliminar")) {
		System.out.println("Entra por awi");
		String dni = request.getParameter("dni");
		udao.borrarUsuarioPorNombre(dni);
		List<Usuario> users = udao.listarUsuarios();
		System.out.println("tammaño de la lista usuarios:" + users.size());
		request.setAttribute("listadoUsuarios", users);
		RequestDispatcher rd = request.getRequestDispatcher("showUsers.jsp"); 
		rd.forward(request, response);
		}else if(request.getParameter("accion").equals("filtrar")) {
			String rol = request.getParameter("inputRol");
			String nombreUsuario = request.getParameter("inputIdUsuario");
			if(!rol.equals("Seleccionar...") && !nombreUsuario.isEmpty()) {
				List<Usuario> usuarios = udao.buscarPorNombreRol(nombreUsuario, rol);
				request.setAttribute("listadoUsuarios", usuarios);
				RequestDispatcher rd = request.getRequestDispatcher("showUsers.jsp"); 
				rd.forward(request, response);
			}else if(!rol.equals("Seleccionar...")){
				
				}
			}
			
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioDao udao = new UsuarioDao();
		String nombre = request.getParameter("inputNombre");
		String apellidos = request.getParameter("inputApellidos");
		String dni = request.getParameter("inputDNI");
		String sexo = request.getParameter("inputSexo");
		String idUsuario = request.getParameter("inputIdUsuario");
		String password = request.getParameter("inputPassword");
		String email = request.getParameter("inputEmail");
		String numero = request.getParameter("inputTelefono");
		String fechaNacimiento = request.getParameter("inputFechaNacimiento");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String[] roles = request.getParameterValues("rol");
		System.out.println(nombre);
		System.out.println(apellidos);
		System.out.println(dni);
		System.out.println(sexo);
		System.out.println(idUsuario);
		System.out.println(password);
		System.out.println(email);
		System.out.println(numero);
		System.out.println(fechaNacimiento);
			try {
				Usuario user = new Usuario(nombre,apellidos,dni,sexo,idUsuario,password,email,Integer.parseInt(numero),sdf.parse(fechaNacimiento));
				List<Roles> rols = new ArrayList<>();
				for(String rol : roles){
					RolDao roldao = new RolDao();
					Roles r = roldao.buscarPorDni(rol);
					System.out.println(r);
					rols.add(r);
				}
				System.out.println(rols.size());
				user.setRoles(rols);
				if(request.getParameter("accion").equals("insertar")) {
					udao.agregarUsuario(user);
				 }else if(request.getParameter("accion").equals("modificar")){
					 udao.modificarUsuarioPorId(dni, user);
					 
				 }
				
				
				
			} catch (NumberFormatException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			List<Usuario> users = udao.listarUsuarios();
			System.out.println("tammaño de la lista usuarios:" + users.size());
			request.setAttribute("listadoUsuarios", users);
			RequestDispatcher rd = request.getRequestDispatcher("showUsers.jsp"); 
			rd.forward(request, response);
		
			// TODO Auto-generated catch block
		
		
		
		//doGet(request, response);
	}

}
