package JViNoM.Mdl.Srvcs;

import java.util.Collection;

import JViNoM.Mdl.DAO;
import JViNoM.Mdl.Dao.LclsDAO;
import JViNoM.Mdl.Bns.Lcls;

/**
 *	Service for the project bean.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class LclsSrvc{
	private DAO<Lcls> dLcls;
	private Lcls crrntLcls;
	
	public LclsSrvc(DAO<Lcls> dLcls){
		this.dLcls=dLcls;
	}
	/**
	 *	Sets the current element.
	 *	@param Lcls new current element.
	 */
	public void stLcls(Lcls crrntLcls){
		this.crrntLcls=crrntLcls;
	}
	/**
	 *	Makes a call to the DAO for the bean. Saving it to disk and giving us a new object as current.
	 */
	public int save(){
		return dLcls.sv(crrntLcls);
	}
	/**
	 *	Makes a call for the DAO to fetch us the data
	 *	@return Collection<Lcls> A list with all current data..
	 */
	public Collection<Lcls> gtAllLcls(){
		return dLcls.gtAll();
	}
	/**
	 *	Makes a call to save object, without changing current object.
	 *	@param Lcls the object to save.
	 */
	public int svLcls(Lcls crrntLcls){
		return dLcls.sv(crrntLcls);
	}
}	
