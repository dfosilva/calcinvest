/**
 * 
 */
package jobs;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import enums.TipoUsuario;
import models.Carteira;
import models.Usuario;
@OnApplicationStart
public class Inicializador extends Job {
	
	@Override
	public void doJob() throws Exception {
		if(Usuario.count() == 0) {
			//Usuario[] usrr = new Usuario[20];
			Usuario usr0= new Usuario();			
			usr0.nome = "investidoradm";
			usr0.senha = "123";
			usr0.qtdeinvs = 0;
			usr0.tipoUsuario = TipoUsuario.ADMIN;
			usr0.save();	
			
			Usuario usr1 = new Usuario();
			usr1.nome = "investidor1";
			usr1.senha = "123";
			usr1.save();
		}		
	}
}