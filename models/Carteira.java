/**
 * 
 */
package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

/**
 * @author joaohelis
 *
 */
@Entity
public class Carteira extends Model{
	
	public String nome;
	public Integer qtdeInvs;
	public Integer qtdeDerrotas;
	

}
