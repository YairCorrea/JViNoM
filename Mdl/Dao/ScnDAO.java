package JViNoM.Mdl.Dao;

import JViNoM.Mdl.Bns.Scn;
import JViNoM.Mdl.DAO;

/**
 *	Data Access Object for scenes.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class ScnDAO implements DAO{
	private ArrayList<Scn> arryScn;
	private FLWrtr flWrtr;
	private Prjct ownr;
	public ScnDAO(Prjct ownr){
		arryScn=ownr.gtScns();
	}
	/**
	 *	Get a specific object of a kind.
	 *	@param int id for said object
	 *	@return T The object searched for or a NULL.
	 */
	public Scn gt(int id){
		return arryScn.get(id);
	}
	/**
	 *	Get all objects of a kind.
	 *	@return Scn A list containing all the objects of said kind..
	 */
	public ArrayList<Scn> gtAll(){
		return arryScn;
	}
	/**
	 *	Saves into our persistance layer an object..
	 *	@param Scn Scnhe object to save
	 */
	public void sv(Scn tSv){
		int tmStmp=arryScn.size();
		tSv.stId(tmpStmp);
		arryScn.add(tSv);
		ownr.stScns(arryScn);
	}
	/**
	 * 	Updates a certain EXISTING object's parameters..
	 *	@param Scn key for said object
	 *	@param String[] parameters in the order of [name,Id of Parent Project,Layers].
	 */
	public void updt(int bngEdtd, Object[] prmtrs){
		Scn tmp=arryScn.get(bngEdtd);
		tmp.stNm((String)prmtrs[0]);
		tmp.stPrjctId((int)prmtrs[1]);
		tmp.stLyrs((Lyr[])prmtrs[2]);
		ownr.stScns(arryScn);
	}
	/**
	 *	Deletes a specific object of a kind. 
	 *	@param Scn  key for object.
	 */
	public void dlt(int bngDltd){
		int tmp=arryScn.size()-(1+bngDltd);
		arryScn.remove(bngDltd);
		for(int i=0;i<tmp;i++){
			Scn rnm=arryScn.get(bngDltd+i);
			rnm.stId(bngDltd+i);
		}
		ownr.stScns(arryScn);
	}
}
