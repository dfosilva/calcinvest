package controllers;
import java.util.List;
import play.mvc.Controller;
import models.Usuario;
public class Usuarios extends Controller{
	public static void form() {		
		List<Usuario> usuarios= Usuario.findAll();
		render(usuarios);
	}
	
	public static void salvar(Usuario usr) {
		usr.save();
		flash.success("Usuário salvo com sucesso!");
		listar();
	}
	
	public static void editar(Long id) {
		Usuario usuario= Usuario.findById(id);
		List<Usuario> usuarios= Usuario.findAll();
		render("usuarios/form.html", usuario, usuarios);
	}
	
	public static void listar() {
		List<Usuario> usuarios= Usuario.findAll();
		render(usuarios);
	}
}
