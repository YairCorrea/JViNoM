package JViNoM.Mdl.Dao;

import JViNoM.Mdl.Bns.Lcls;
import JViNoM.Mdl.DAO;

/**
 *	Data Access Object for locales.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class LclsDAO implements DAO{
	/**
	 *	Get a specific object of a kind.
	 *	@param int id for said object
	 *	@return T The object searched for or a NULL.
	 */
	public Lcls gt(int id){

	}
	/**
	 *	Get all objects of a kind.
	 *	@return Lcls A list containing all the objects of said kind..
	 */
	public ArrayList<Lcls> gtAll(){}
	/**
	 *	Saves into our persistance layer an object..
	 *	@param Lcls Lclshe object to save
	 */
	public void sv(Lcls tSv){}
	/**
	 * 	Updates a certain EXISLclsING object's parameters..
	 *	@param Lcls key for said object
	 *	@param String[] parameters in the order of the corresponding bean.
	 */
	public void updt(Lcls bngEdtd, String[] prmtrs){}
	/**
	 *	Deletes a specific object of a kind.
	 *	@param Lcls  key for object.
	 */
	public void dlt(Lcls bngDltd){}
}
