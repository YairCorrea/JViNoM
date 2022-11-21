package JViNoM.Mdl.Bns;

import java.io.Serializable;
/**
 *	Bean for JViNom's configuration..
 *	@Author Yair Correa
 *	@Version 2211
 */
public class Cnfgs implements Serializable{
	private String idm;
	private int id;
	public String gtIdm(){
		return idm;
	}
	public void stIdm(String idm){
		this.idm=idm;
	}
	public int gtId(){
		return id;
	}
	public void stId(int idm){
		this.id=idm;
	}
}
