package JViNoM.Mdl;
/**
 *	Data Access Object interface.
 *	@Author Yair Correa
 *	@Version 2211
 */
public interface DAO<T>{
	/**
	 *	Get a specific object of a kind.
	 *	@param int id for said object
	 *	@return T The object searched for or a NULL.
	 */
	public T gt(int id);
	/**
	 *	Get all objects of a kind.
	 *	@return T A list containing all the objects of said kind..
	 */
	public ArrayList<T> gtAll();
	/**
	 *	Saves into our persistance layer an object..
	 *	@param T The object to save
	 */
	public void sv(T tSv);
	/**
	 * 	Updates a certain EXISTING object's parameters..
	 *	@param T key for said object
	 *	@param String[] parameters in the order of the corresponding bean.
	 */
	public void updt(T bngEdtd, String[] prmtrs);
	/**
	 *	Deletes a specific object of a kind.
	 *	@param T  key for object.
	 */
	public void dlt(T bngDltd);
}
