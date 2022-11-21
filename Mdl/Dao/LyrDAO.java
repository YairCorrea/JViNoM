package JViNoM.Mdl.Dao;

import JViNoM.Mdl.Bns.Lyr;
import JViNoM.Mdl.DAO;

/**
 *	Data Access Object for layers.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class LyrDAO implements DAO{
	/**
	 *	Get a specific object of a kind.
	 *	@param int id for said object
	 *	@return T The object searched for or a NULL.
	 */
	public Lyr gt(int id){

	}
	/**
	 *	Get all objects of a kind.
	 *	@return Lyr A list containing all the objects of said kind..
	 */
	public ArrayList<Lyr> gtAll(){}
	/**
	 *	Saves into our persistance layer an object..
	 *	@param Lyr Lyrhe object to save
	 */
	public void sv(Lyr tSv){}
	/**
	 * 	Updates a certain EXISLyrING object's parameters..
	 *	@param Lyr key for said object
	 *	@param String[] parameters in the order of the corresponding bean.
	 */
	public void updt(Lyr bngEdtd, String[] prmtrs){}
	/**
	 *	Deletes a specific object of a kind.
	 *	@param Lyr  key for object.
	 */
	public void dlt(Lyr bngDltd){}
}
