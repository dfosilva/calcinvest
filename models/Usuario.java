package models;
import java.util.Date;
import enums.TipoUsuario;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import play.db.jpa.Model;
@Entity
public class Usuario extends Model{
	public String nome;
	public String senha;
	public TipoUsuario tipoUsuario; 
	public int qtdeinvs;
	
	public Usuario() {
		tipoUsuario = TipoUsuario.PADRAO;
	}
	
	
	
}
