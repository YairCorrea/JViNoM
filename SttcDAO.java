package JViNoM.Mdl.Dao;

import JViNoM.Mdl.Bns.Sttc;
import JViNoM.Mdl.DAO;
import JViNoM.Mdl.FlWrtr;
import JViNoM.Mdl.Bns.Prjct;

import java.util.ArrayList;
import java.util.Arrays;
/**
 *	Data Access Object for statics.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class SttcDAO implements DAO<Sttc>{
	private ArrayList<Sttc> arrySttc;
	private FlWrtr flWrtr=new FlWrtr();;
	private Prjct ownr;
	public SttcDAO(){
		arrySttc=flWrtr.rd("Sttcs");
	}
	public SttcDAO(Prjct ownr){
		arrySttc=new ArrayList<Sttc>(Arrays.asList(ownr.gtSttcs()));
	}
	/**
	 *	Get a specific object of a kind.
	 *	@param int id for said object
	 *	@return T The object searched for or a NULL.
	 */
	public Sttc gt(int id){
		return arrySttc.get(id);
	}
	/**
	 *	Get all objects of a kind.
	 *	@return Sttc A list containing all the objects of said kind..
	 */
	public ArrayList<Sttc> gtAll(){
		return arrySttc;
	}
	/**
	 *	Saves into our persistance layer an object..
	 *	@param Sttc Sttche object to save
	 */
	public int sv(Sttc tSv){
		int tmStmp=arrySttc.size();
		tSv.stId(tmStmp);
		arrySttc.add(tSv);
		if(ownr!=null)ownr.stSttcs((Sttc[])arrySttc.toArray());
		if(ownr==null)flWrtr.sv("Sttcs",arrySttc);
		return tmStmp;
	}
	/**
	 * 	Updates a certain EXISTING object's parameters..
	 *	@param Sttc key for said object
	 *	@param String[] parameters in the order of [fileName,lctn].
	 */
	public void updt(int bngEdtd, Object[] prmtrs){
		Sttc tmp=arrySttc.get(bngEdtd);
		tmp.stFlNm((String)prmtrs[0]);
		tmp.stLctn((String)prmtrs[1]);
		if(ownr!=null)ownr.stSttcs((Sttc[])arrySttc.toArray());
	}
	/**
	 *	Deletes a specific object of a kind. 
	 *	@param Sttc  key for object.
	 */
	public void dlt(int bngDltd){
		int tmp=arrySttc.size()-(1+bngDltd);
		arrySttc.remove(bngDltd);
		for(int i=0;i<tmp;i++){
			Sttc rnm=arrySttc.get(bngDltd+i);
			rnm.stId(bngDltd+i);
		}
		if(ownr!=null)ownr.stSttcs((Sttc[])arrySttc.toArray());
	}
}
