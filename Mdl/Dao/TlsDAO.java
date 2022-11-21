package JViNoM.Mdl.Dao;

import JViNoM.Mdl.Bns.Tls;
import JViNoM.Mdl.DAO;

/**
 *	Data Access Object for tools.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class TlsDAO implements DAO{
	/**
	 *	Get a specific object of a kind.
	 *	@param int id for said object
	 *	@return T The object searched for or a NULL.
	 */
	public Tls gt(int id){

	}
	/**
	 *	Get all objects of a kind.
	 *	@return Tls A list containing all the objects of said kind..
	 */
	public ArrayList<Tls> gtAll(){}
	/**
	 *	Saves into our persistance layer an object..
	 *	@param Tls Tlshe object to save
	 */
	public void sv(Tls tSv){}
	/**
	 * 	Updates a certain EXISTlsING object's parameters..
	 *	@param Tls key for said object
	 *	@param String[] parameters in the order of the corresponding bean.
	 */
	public void updt(Tls bngEdtd, String[] prmtrs){}
	/**
	 *	Deletes a specific object of a kind.
	 *	@param Tls  key for object.
	 */
	public void dlt(Tls bngDltd){}
}
