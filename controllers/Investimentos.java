package controllers;
import java.util.List;
import models.Carteira;
import play.mvc.Controller;
import models.Investimento;
public class Investimentos extends Controller {
	/*public static void form() {		
		List<Carteira> carteiras= Carteira.findAll();
		render(carteiras);
	}*/
	float vf1;
	float vf2;
	float vf3;
	public static void form() {
		List<Investimento> investimentos = Investimento.findAll();
		render(investimentos);
	}
	public static void salvar(Investimento inv) {
		inv.save();
		flash.success("Cálculo de investimento feito com sucesso!");
		listar();
	}
	public static void editar(Long id) {
		Investimento investimento = Investimento.findById(id);
		List<Carteira> carteiras= Carteira.findAll();
		render("investimentos/form.html", investimento, carteiras);
	}
	public static void listar() {
		List<Investimento> investimentos = Investimento.findAll();
		render(investimentos);
	}
	public void converter2valores(String vs1, String vs2, Investimento investimento) {
		try{
			vf1 = Float.parseFloat(vs1);
			vf2 = Float.parseFloat(vs2);
		}catch(Exception e) {
			render("Application/erroentrada.html");
		}
	}
	/*public float converter3(float valor1, float valor2, float valor3) {	
	}*/

	public void preCalcBruto(String ValorInicial, String RendPorcent){
		Investimento investimento = new Investimento();
		investimento.setCalcafzr("preCalcBruto");
		converter2valores(ValorInicial, RendPorcent, investimento);
		investimento.CalculoGeralBruto(vf1, vf2);
		render("Application/calculadora.html", investimento);
	}
	public void preCalcCent(float ValorInicial, float RendPorcent){
		Investimento investimento = new Investimento();
		investimento.setCalcafzr("");
		
		
		
		investimento.CalculoGeralBruto(ValorInicial, RendPorcent);
		render("Application/calculadora.html", investimento);
	}
	
	
	
	
	public void CalculoGeralPorcent(float ValorInicial, float RendBruto) {
		Investimento investimento = new Investimento();
		investimento.CalculoGeralPorcent(ValorInicial, RendBruto);
		render("Application/calculadora.html", investimento);
	}
	public static void selicBruto(float tempomeses, float valorinicial) {
		Investimento investimento = new Investimento();
		investimento.TesouroSelicBruto(tempomeses, valorinicial);
		render("Application/calculadora.html", investimento);
	}
	public static void investirPoup(float tempomeses, float valorinicial) {
		Investimento investimento = new Investimento();
		investimento.PoupancaBruto(tempomeses, valorinicial); // Esta dzd q o metodo PoupancaBruto recebe tres valores float
		//resultadoCalculoInvestimento(investimento);
		render("Application/calculadora.html", investimento);
	}
	public static void cdb(float tempomeses, float valorinicial, float porcenttxbs) {
		Investimento investimento = new Investimento();
		investimento.CDB(tempomeses, valorinicial, porcenttxbs);
		render("Application/calculadora.html", investimento);
	}
	public static void prefix(float tempomeses, float valorinicial, float taxabase) {
		Investimento investimento = new Investimento();
		investimento.Tesouro_Pre_Fixado(tempomeses, valorinicial, taxabase);
		render("Application/calculadora.html", investimento);
	}
	
	
	/*public static void resultadoCalculoInvestimento(Investimento investimento) {
		render("Application/calculadora.html", investimento);
	}*/
	
	/*public static float investirPoup(float valorinicial, float rendporcent) {
		Investimento investimento = new Investimento();
		investimento.CalculoGeralBruto(valorinicial, rendporcent);
		return investimento.getRend_bruto();
	}*/
	/*public static float investirPoup(float valorinicial, float rendporcent) {
	Investimento investimento = new Investimento();
	investimento.CalculoGeralBruto(valorinicial, rendporcent);
	return investimento.getRend_bruto();
}*/
	/*public static float investirPoup(float valorinicial, float rendporcent) {
	Investimento investimento = new Investimento();
	investimento.CalculoGeralBruto(valorinicial, rendporcent);
	return investimento.getRend_bruto();
}*/
	/*public static float investirPoup(float valorinicial, float rendporcent) {
	Investimento investimento = new Investimento();
	investimento.CalculoGeralBruto(valorinicial, rendporcent);
	return investimento.getRend_bruto();
}*/
	
}
