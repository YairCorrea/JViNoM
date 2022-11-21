package JViNoM.Mdl.Srvcs;

import JViNoM.Mdl.DAO;
import JViNoM.Mdl.Dao.CnfgsDAO;
import JViNoM.Mdl.Bns.Cnfgs;

/**
 *	Service for the project bean.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class CnfgsSrvc{
	private DAO<Cnfgs> dCnfgs;
	private Cnfgs crrntCnfgs;
	
	CnfgsSrvc(DAO<Cnfgs> dCnfgs){
		this.dCnfgs=dCnfgs;
	}
	/**
	 *	Sets the current element.
	 *	@param Cnfgs new current element.
	 */
	public void stCnfgs(Cnfgs crrntCnfgs){
		this.crrntCnfgs=crrntCnfgs;
	}
	/**
	 *	Makes a call to the DAO for the bean. Saving it to disk and giving us a new object as current.
	 */
	public void save(){
		dCnfgs.sv(crrntCnfgs);
	}
	/**
	 *	Makes a call for the DAO to fetch us the data
	 *	@return Collection<Cnfgs> A list with all current data..
	 */
	public Collection<Cnfgs> gtAllCnfgs(){
		return dCnfgs.gtAll();
	}
	/**
	 *	Makes a call to save object, without changing current object.
	 *	@param Cnfgs the object to save.
	 */
	public int svCnfgs(Cnfgs crrntCnfgs){
		dCnfgs.sv(crrntCnfgs);
	}
}	
