package JViNoM.Mdl.Srvcs;

import java.util.Collection;

import JViNoM.Mdl.DAO;
import JViNoM.Mdl.Dao.PrjctDAO;
import JViNoM.Mdl.Bns.Prjct;

/**
 *	Service for the project bean.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class PrjctSrvc{
	private DAO<Prjct> dPrjct;
	private Prjct crrntPrjct;
	
	PrjctSrvc(DAO<Prjct> dPrjct){
		this.dPrjct=dPrjct;
	}
	/**
	 *	Sets the current element.
	 *	@param Prjct new current element.
	 */
	public void stPrjct(Prjct crrntPrjct){
		this.crrntPrjct=crrntPrjct;
	}
	/**
	 *	Makes a call to the DAO for the bean. Saving it to disk and giving us a new object as current.
	 */
	public int save(){
		return dPrjct.sv(crrntPrjct);
	}
	/**
	 *	Makes a call for the DAO to fetch us the data
	 *	@return Collection<Prjct> A list with all current data..
	 */
	public Collection<Prjct> gtAllPrjct(){
		return dPrjct.gtAll();
	}
	/**
	 *	Makes a call to save object, without changing current object.
	 *	@param Prjct the object to save.
	 */
	public int svPrjct(Prjct crrntPrjct){
		return dPrjct.sv(crrntPrjct);
	}
}	
