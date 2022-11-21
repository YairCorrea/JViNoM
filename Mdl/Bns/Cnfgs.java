package JViNoM.Mdl.Bns;
/**
 *	Bean for JViNom's configuration..
 *	@Author Yair Correa
 *	@Version 2211
 */
public class Cnfgs{
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
