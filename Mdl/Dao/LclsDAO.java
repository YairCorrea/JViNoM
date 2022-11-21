package JViNoM.Mdl.Dao;

import JViNoM.Mdl.Bns.Lcls;
import JViNoM.Mdl.DAO;

import JViNoM.Mdl.FlWrtr;
/**
 *	Data Access Object for locales.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class LclsDAO implements DAO{
	private ArrayList<Lcls> arryLcls;
	private FLWrtr flWrtr;
	public LclsDAO(){
		arrayLcls=flWrtr.rd("Lcls");
	}
	/**
	 *	Get a specific object of a kind.
	 *	@param int id for said object
	 *	@return T The object searched for or a NULL.
	 */
	public Lcls gt(int id){
		return arryLcls.get(id);
	}
	/**
	 *	Get all objects of a kind.
	 *	@return Lcls A list containing all the objects of said kind..
	 */
	public ArrayList<Lcls> gtAll(){
		return arryLcls;
	}
	/**
	 *	Saves into our persistance layer an object..
	 *	@param Lcls Lclshe object to save
	 */
	public void sv(Lcls tSv){
		int tmStmp=arryLcls.size();
		tSv.stId(tmpStmp);
		arryLcls.add(tSv);
		flWrt.sv("Lcls",arryLcls);
	}
	/**
	 * 	Updates a certain EXISLclsING object's parameters..
	 *	@param Lcls key for said object
	 *	@param String[] parameters in the order of the corresponding bean.
	 */
	public void updt(int bngEdtd, Object[] prmtrs){
		Lcls tmp=arryLcls.get(bngEdtd);
		tmp.stTxt((String[])prmtrs[0]);
		tmp.stLclNm((String)prmtrs[0]);
		flWrt.sv("Lcls",arryLcls);
	}
	/**
	 *	Deletes a specific object of a kind.
	 *	@param Lcls  key for object.
	 */
	public void dlt(int bngDltd){
		int tmp=arryLcls.size()-(1+bngDltd);
		arryLcls.remove(bngDltd);
		for(int i=0;i<tmp;i++){
			Lcls rnm=arryLcls.get(bngDltd+i);
			rnm.stId(bngDltd+i);
		}
		flWrt.sv("Lcls",arryLcls);
	}
}
