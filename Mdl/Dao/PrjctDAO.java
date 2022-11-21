package JViNoM.Mdl.Dao;

import JViNoM.Mdl.Bns.Prjct;
import JViNoM.Mdl.DAO;
import JViNoM.Mdl.FlWrtr;

import java.util.ArrayList.*;

/**
 *	Data Access Object for projects.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class PrjctDAO implements DAO{
	private ArrayList<Prjct> arryPrjct;
	private FLWrtr flWrtr;
	public PrjctDAO(){
		arryPrjct=flWrtr.rd("Prjct");
	}
	/**
	 *	Get a specific object of a kind.
	 *	@param int id for said object
	 *	@return T The object searched for or a NULL.
	 */
	public Prjct gt(int id){
		return arryPrjct.get(id);
	}
	/**
	 *	Get all objects of a kind.
	 *	@return Prjct A list containing all the objects of said kind..
	 */
	public ArrayList<Prjct> gtAll(){
		return arryPrjct;
	}
	/**
	 *	Saves into our persistance layer an object..
	 *	@param Prjct Prjcthe object to save
	 */
	public void sv(Prjct tSv){
		int tmStmp=arryPrjct.size();
		tSv.stId(tmpStmp);
		arryPrjct.add(tSv);
		flWrt.sv("Prjct",arryPrjct);
		this.svPrjct(tSv.gtLctn(),tSv);
	}
	/**
	 * 	Updates a certain EXISTING object's parameters..
	 *	@param Prjct key for said object
	 *	@param String[] parameters in the order of [Location,name,aspectRatio].
	 */
	public void updt(int bngEdtd, Object[] prmtrs){
		Prjct tmp=arryPrjct.get(bngEdtd);
		Strng prvsLctn=tmp.gtLctn;
		tmp.stLctn((String)prmtrs[0]);
		tmp.stNm((String)prmtrs[1]);
		tmp.stAspctRltn((int[])prmtrs[2]);
		tmp.stScns((Scns[])prmtrs[3]);
		flWrt.sv("Prjct",arryPrjct);
		if(!prvsLctn.equals(tmp.gtLctn)) flWrtr.dltPrjct(prvsLctn);
	}
	/**
	 *	Deletes a specific object of a kind. For project in particular, it WONT remove your files, it just will make JViNoM forget about your project and stop it from appearing on recent projects.
	 *	@param Prjct  key for object.
	 */
	public void dlt(int bngDltd){
		int tmp=arryPrjct.size()-(1+bngDltd);
		arryPrjct.remove(bngDltd);
		for(int i=0;i<tmp;i++){
			Prjct rnm=arryPrjct.get(bngDltd+i);
			rnm.stId(bngDltd+i);
		}
		flWrt.sv("Prjct",arryPrjct);
	}
	/**
	 *	Saves a file where it was indicated to.
	 */
	private void svPrjct(String lctn,Prjct tSv){
		flWrtr.svPrjct(lctn,tSv);
	}
	/**
	 * 	Reads a previously unknow project.
	 * 	@param String location of the project.
	 */
	public ArrayList<Prjct> rdPrjct(String lctn){
		Prjct tmp=flWrtr.rdPrjct(lctn);
		this.sv(Prjct);
		return arryPrjct;
	}
}
