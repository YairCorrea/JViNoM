package JViNoM.Mdl.Dao;

import JViNoM.Mdl.Bns.Prjct;
import JViNoM.Mdl.DAO;

/**
 *	Data Access Object for projects.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class PrjctDAO implements DAO{
	/**
	 *	Get a specific object of a kind.
	 *	@param int id for said object
	 *	@return T The object searched for or a NULL.
	 */
	public Prjct gt(int id){

	}
	/**
	 *	Get all objects of a kind.
	 *	@return Prjct A list containing all the objects of said kind..
	 */
	public ArrayList<Prjct> gtAll(){}
	/**
	 *	Saves into our persistance layer an object..
	 *	@param Prjct Prjcthe object to save
	 */
	public void sv(Prjct tSv){}
	/**
	 * 	Updates a certain EXISPrjctING object's parameters..
	 *	@param Prjct key for said object
	 *	@param String[] parameters in the order of the corresponding bean.
	 */
	public void updt(Prjct bngEdtd, String[] prmtrs){}
	/**
	 *	Deletes a specific object of a kind.
	 *	@param Prjct  key for object.
	 */
	public void dlt(Prjct bngDltd){}
}
