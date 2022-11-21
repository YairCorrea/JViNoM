package JViNoM.Mdl.Dao;

import JViNoM.Mdl.Bns.Cnfgs;
import JViNoM.Mdl.DAO;
import JViNoM.Mdl.FlWrtr;

import java.util.ArrayList;
/**
 *	Data Access Object for configurations.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class CnfgsDAO implements DAO<Cnfgs>{
	private ArrayList<Cnfgs> arryCnfgs;
	private FlWrtr flWrtr;
	public CnfgsDAO(){
		arryCnfgs=flWrtr.rd("Cnfgs");
	}
	/**
	 *	Get a specific object of a kind.
	 *	@param int id for said object
	 *	@return T The object searched for or a NULL.
	 */
	public Cnfgs gt(int id){
		return arryCnfgs.get(id);
	}
	/**
	 *	Get all objects of a kind.
	 *	@return Cnfgs A list containing all the objects of said kind..
	 */
	public ArrayList<Cnfgs> gtAll(){
		return arryCnfgs;
	}
	/**
	 *	Saves into our persistance layer an object..
	 *	@param Cnfgs Cnfgshe object to save
	 */
	public int sv(Cnfgs tSv){
		int tmStmp=arryCnfgs.size();
		tSv.stId(tmStmp);
		arryCnfgs.add(tSv);
		flWrtr.sv("Cnfgs",arryCnfgs);
		return tmStmp;
	}
	/**
	 * 	Updates a certain EXISCnfgsING object's parameters..
	 *	@param Cnfgs key for said object
	 *	@param String[] parameters in the order of the corresponding bean.
	 */
	public void updt(int bngEdtd, Object[] prmtrs){
		Cnfgs tmp=arryCnfgs.get(bngEdtd);
		tmp.stIdm((String)prmtrs[0]);
		flWrtr.sv("Cnfgs",arryCnfgs);
	}
	/**
	 *	Deletes a specific object of a kind.
	 *	@param Cnfgs  key for object.
	 */
	public void dlt(int bngDltd){
		int tmp=arryCnfgs.size()-(1+bngDltd);
		arryCnfgs.remove(bngDltd);
		for(int i=0;i<tmp;i++){
			Cnfgs rnm=arryCnfgs.get(bngDltd+i);
			rnm.stId(bngDltd+i);
		}
		flWrtr.sv("Cnfgs",arryCnfgs);
	}
}
