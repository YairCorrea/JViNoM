package JViNoM.Mdl.Srvcs;

import java.util.Collection;

import JViNoM.Mdl.DAO;
import JViNoM.Mdl.Dao.LyrDAO;
import JViNoM.Mdl.Bns.Lyr;

/**
 *	Service for the project bean.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class LyrSrvc{
	private DAO<Lyr> dLyr;
	private Lyr crrntLyr;
	
	public LyrSrvc(DAO<Lyr> dLyr){
		this.dLyr=dLyr;
	}
	/**
	 *	Sets the current element.
	 *	@param Lyr new current element.
	 */
	public void stLyr(Lyr crrntLyr){
		this.crrntLyr=crrntLyr;
	}
	/**
	 *	Makes a call to the DAO for the bean. Saving it to disk and giving us a new object as current.
	 */
	public int save(){
		return dLyr.sv(crrntLyr);
	}
	/**
	 *	Makes a call for the DAO to fetch us the data
	 *	@return Collection<Lyr> A list with all current data..
	 */
	public Collection<Lyr> gtAllLyr(){
		return dLyr.gtAll();
	}
	/**
	 *	Makes a call to save object, without changing current object.
	 *	@param Lyr the object to save.
	 */
	public int svLyr(Lyr crrntLyr){
		return dLyr.sv(crrntLyr);
	}
}	
