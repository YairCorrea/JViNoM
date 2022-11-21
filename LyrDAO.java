package JViNoM.Mdl.Dao;

import JViNoM.Mdl.Bns.Lyr;
import JViNoM.Mdl.Bns.Scn;
import JViNoM.Mdl.DAO;
import JViNoM.Mdl.FlWrtr;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *	Data Access Object for layers.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class LyrDAO implements DAO<Lyr>{
	private ArrayList<Lyr> arryLyr;
	private FlWrtr flWrtr;
	private Scn ownr;
	public LyrDAO(Scn ownr){
		arryLyr=new ArrayList<Lyr>(Arrays.asList(ownr.gtLyrs()));
	}
	/**
	 *	Get a specific object of a kind.
	 *	@param int id for said object
	 *	@return T The object searched for or a NULL.
	 */
	public Lyr gt(int id){
		return arryLyr.get(id);
	}
	/**
	 *	Get all objects of a kind.
	 *	@return Lyr A list containing all the objects of said kind..
	 */
	public ArrayList<Lyr> gtAll(){
		return arryLyr;
	}
	/**
	 *	Saves into our persistance layer an object..
	 *	@param Lyr Lyrhe object to save
	 */
	public int sv(Lyr tSv){
		int tmStmp=arryLyr.size();
		tSv.stId(tmStmp);
		arryLyr.add(tSv);
		ownr.stLyrs((Lyr[])arryLyr.toArray());
		return tmStmp;
	}
	/**
	 * 	Updates a certain EXISTING object's parameters..
	 *	@param Lyr key for said object
	 *	@param String[] parameters in the order of [ordr,name,Id of Parent Scene,JComponents].
	 */
	public void updt(int bngEdtd, Object[] prmtrs){
		Lyr tmp=arryLyr.get(bngEdtd);
		tmp.stOrdr((int)prmtrs[0]);
		tmp.stNm((String)prmtrs[1]);
		tmp.stScnId((int)prmtrs[2]);
		tmp.stCmpnnts((JComponent[])prmtrs[3]);
		ownr.stLyrs((Lyr[])arryLyr.toArray());
	}
	/**
	 *	Deletes a specific object of a kind. 
	 *	@param Lyr  key for object.
	 */
	public void dlt(int bngDltd){
		int tmp=arryLyr.size()-(1+bngDltd);
		arryLyr.remove(bngDltd);
		for(int i=0;i<tmp;i++){
			Lyr rnm=arryLyr.get(bngDltd+i);
			rnm.stId(bngDltd+i);
		}
		ownr.stLyrs((Lyr[])arryLyr.toArray());
	}
}
