package JViNoM.Mdl.Dao;

import JViNoM.Mdl.Bns.Sttc;
import JViNoM.Mdl.DAO;

/**
 *	Data Access Object for statics.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class SttcDAO implements DAO{
	/**
	 *	Get a specific object of a kind.
	 *	@param int id for said object
	 *	@return T The object searched for or a NULL.
	 */
	public Sttc gt(int id){

	}
	/**
	 *	Get all objects of a kind.
	 *	@return Sttc A list containing all the objects of said kind..
	 */
	public ArrayList<Sttc> gtAll(){}
	/**
	 *	Saves into our persistance layer an object..
	 *	@param Sttc Sttche object to save
	 */
	public void sv(Sttc tSv){}
	/**
	 * 	Updates a certain EXISSttcING object's parameters..
	 *	@param Sttc key for said object
	 *	@param String[] parameters in the order of the corresponding bean.
	 */
	public void updt(Sttc bngEdtd, String[] prmtrs){}
	/**
	 *	Deletes a specific object of a kind.
	 *	@param Sttc  key for object.
	 */
	public void dlt(Sttc bngDltd){}
}
