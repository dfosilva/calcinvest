package controllers;
import models.Usuario;
import play.mvc.Controller;
import models.Usuario;
public class Login extends Controller {
	public static void logout() {
		session.clear();
		Application.index(); 
	}
	
	
	public static void autenticar(String nome, String senha) {
		Usuario usuario = Usuario.find("nome = ? and senha = ?", nome, senha).first();
	if(usuario == null){
		Application.index();
	} else {
		session.put("nomeUsuario", usuario.nome);
		session.put("usuarioID", usuario.id);
		Application.index();
	}
}
}