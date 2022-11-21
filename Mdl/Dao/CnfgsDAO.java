package JViNoM.Mdl.Dao;

import JViNoM.Mdl.Bns.Cnfgs;
import JViNoM.Mdl.DAO;

/**
 *	Data Access Object for configurations.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class CnfgsDAO implements DAO{
	/**
	 *	Get a specific object of a kind.
	 *	@param int id for said object
	 *	@return T The object searched for or a NULL.
	 */
	public Cnfgs gt(int id){

	}
	/**
	 *	Get all objects of a kind.
	 *	@return Cnfgs A list containing all the objects of said kind..
	 */
	public ArrayList<Cnfgs> gtAll(){}
	/**
	 *	Saves into our persistance layer an object..
	 *	@param Cnfgs Cnfgshe object to save
	 */
	public void sv(Cnfgs tSv){}
	/**
	 * 	Updates a certain EXISCnfgsING object's parameters..
	 *	@param Cnfgs key for said object
	 *	@param String[] parameters in the order of the corresponding bean.
	 */
	public void updt(Cnfgs bngEdtd, String[] prmtrs){}
	/**
	 *	Deletes a specific object of a kind.
	 *	@param Cnfgs  key for object.
	 */
	public void dlt(Cnfgs bngDltd){}
}
