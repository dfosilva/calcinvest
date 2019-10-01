package models;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import play.db.jpa.Model;
@Entity
public class Investimento extends Model {
	float valor_inicial;
	float valor_final;
	float rend_bruto;
	float rend_porcent;
	float taxa_base = 0.5f;
	float tempo_meses;
	float porcent_taxa_base;
	@ManyToOne
	@JoinColumn(name="carteira_id")
	public Carteira carteira;
	float resultado;
	String descricao = "teste de descricao";
	String observacoes = "teste de observações";
	String calcafzr;
	
	
	public String getCalcafzr() {
		return calcafzr;
	}
	public void setCalcafzr(String calcafzr) {
		this.calcafzr = calcafzr;
	}
	public String getDescricao() {return descricao;}
	public String getObservacoes() {return observacoes;}	
	public void setDescricao(String descricao) {this.descricao = descricao;}
	public void setObservacoes(String observacoes) {this.observacoes = observacoes;}
	public float getValor_inicial() {return valor_inicial;}
	public void setValor_inicial(float valor_inicial) {this.valor_inicial = valor_inicial;}
	public float getValor_final() {return valor_final;}
	public void setValor_final(float valor_final) {this.valor_final = valor_final;}
	public float getRend_bruto() {return rend_bruto;}
	public void setRend_bruto(float rend_bruto) {this.rend_bruto = rend_bruto;}
	public float getRend_porcent() {return rend_porcent;}
	public void setRend_porcent(float rend_porcent) {this.rend_porcent = rend_porcent;}
	public float getTaxa_base() {return taxa_base;}
	public void setTaxa_base(float taxa_base) {this.taxa_base = taxa_base;}
	public float getTempo_meses() {return tempo_meses;}
	public void setTempo_meses(float tempo_meses) {this.tempo_meses = tempo_meses;}
	public float getPorcent_taxa_base() {return porcent_taxa_base;}
	public void setPorcent_taxa_base(float porcent_taxa_base) {this.porcent_taxa_base = porcent_taxa_base;}
	public float getResultado() {return resultado;}
	public void setResultado(float resultado) {this.resultado = resultado;}
	
	
	// Valores brutos
	public void TesouroSelicBruto(float TempoMeses, float ValorInicial){
		this.setRend_bruto(ValorInicial + ValorInicial*TempoMeses*this.taxa_base);  
		this.setResultado(this.getRend_bruto());
	}
	
	
	//PREVER RESULTADOS DE INVESTIMENTOS FUTUROS - REND BRUTO
	public void PoupancaBruto(float TempoMeses, float ValorInicial){
		//TaxaBase é um valor que o sistema deve ter armazenado(0.5)
		//TempoMeses e  ValorInicial são dados pelo usuário
		this.setValor_inicial(ValorInicial);
		if(this.taxa_base > 8.5){
			this.setPorcent_taxa_base(0.5f);
		}else{
			this.setPorcent_taxa_base(this.taxa_base*0.7f);	
		}
		this.setRend_bruto(ValorInicial + ValorInicial*TempoMeses*this.getPorcent_taxa_base());
		this.setResultado(this.getRend_bruto());
	}
	
	public void Tesouro_Pre_Fixado(float TempoMeses, float ValorInicial, float TaxaBase){
		//TaxaBase é um valor dado pelo usuário
		//TempoMeses e ValorInicial são valores dados pelo usuário
		this.setRend_bruto(ValorInicial + ValorInicial*TaxaBase*TempoMeses);
		this.setResultado(this.getRend_bruto());
	}
	public void CDB(float TempoMeses, float ValorInicial, float PorcentTaxaBase){
		//TaxaBase é um valor que o sistema deve ter armazenado(0.5)
		//TempoMeses, ValorInicial e PorcentTaxaBase são valores dados pelo usuário
		this.setRend_bruto(ValorInicial + ValorInicial*TempoMeses*this.taxa_base*PorcentTaxaBase);
		this.setResultado(this.getRend_bruto());
	}
	
	
	//CALCULAR RESULTADOS DE INVESTIMENTOS PRÉVIOS
	public void CalculoGeralBruto(float ValorInicial, float RendPorcent){
		this.setRend_bruto(ValorInicial + ValorInicial*RendPorcent);
		this.setRend_porcent(RendPorcent);
		this.setResultado(this.getRend_bruto());
	}
	public void CalculoGeralPorcent(float ValorInicial, float RendBruto){
		this.setRend_porcent((RendBruto - ValorInicial)/ValorInicial);
		this.setResultado(this.getRend_porcent());
	}
}
