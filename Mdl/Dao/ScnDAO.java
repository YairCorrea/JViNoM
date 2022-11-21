package JViNoM.Mdl.Dao;

import JViNoM.Mdl.Bns.Scn;
import JViNoM.Mdl.DAO;

/**
 *	Data Access Object for scenes.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class ScnDAO implements DAO{
	/**
	 *	Get a specific object of a kind.
	 *	@param int id for said object
	 *	@return T The object searched for or a NULL.
	 */
	public Scn gt(int id){

	}
	/**
	 *	Get all objects of a kind.
	 *	@return Scn A list containing all the objects of said kind..
	 */
	public ArrayList<Scn> gtAll(){}
	/**
	 *	Saves into our persistance layer an object..
	 *	@param Scn Scnhe object to save
	 */
	public void sv(Scn tSv){}
	/**
	 * 	Updates a certain EXISScnING object's parameters..
	 *	@param Scn key for said object
	 *	@param String[] parameters in the order of the corresponding bean.
	 */
	public void updt(Scn bngEdtd, String[] prmtrs){}
	/**
	 *	Deletes a specific object of a kind.
	 *	@param Scn  key for object.
	 */
	public void dlt(Scn bngDltd){}
}
