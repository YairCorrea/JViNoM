package JViNoM.Mdl.Srvcs;
import java.util.Collection;


import JViNoM.Mdl.DAO;
import JViNoM.Mdl.Dao.ScnDAO;
import JViNoM.Mdl.Bns.Scn;

/**
 *	Service for the project bean.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class ScnSrvc{
	private DAO<Scn> dScn;
	private Scn crrntScn;
	
	public ScnSrvc(DAO<Scn> dScn){
		this.dScn=dScn;
	}
	/**
	 *	Sets the current element.
	 *	@param Scn new current element.
	 */
	public void stScn(Scn crrntScn){
		this.crrntScn=crrntScn;
	}
	/**
	 *	Makes a call to the DAO for the bean. Saving it to disk and giving us a new object as current.
	 */
	public int save(){
		return dScn.sv(crrntScn);
	}
	/**
	 *	Makes a call for the DAO to fetch us the data
	 *	@return Collection<Scn> A list with all current data..
	 */
	public Collection<Scn> gtAllScn(){
		return dScn.gtAll();
	}
	/**
	 *	Makes a call to save object, without changing current object.
	 *	@param Scn the object to save.
	 */
	public int svScn(Scn crrntScn){
		return dScn.sv(crrntScn);
	}
}	
