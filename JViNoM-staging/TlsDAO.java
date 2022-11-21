package JViNoM.Mdl.Dao;

import JViNoM.Mdl.Bns.Tls;
import JViNoM.Mdl.DAO;
import JViNoM.Mdl.FlWrtr;

import java.util.ArrayList;


/**
 *	Data Access Object for tools.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class TlsDAO implements DAO<Tls>{
	private ArrayList<Tls> arryTls;
	private FlWrtr flWrtr;
	public TlsDAO(){
		arryTls=flWrtr.rd("Tls");
	}
	/**
	 *	Get a specific object of a kind.
	 *	@param int id for said object
	 *	@return T The object searched for or a NULL.
	 */
	public Tls gt(int id){
		return arryTls.get(id);
	}
	/**
	 *	Get all objects of a kind.
	 *	@return Tls A list containing all the objects of said kind..
	 */
	public ArrayList<Tls> gtAll(){
		return arryTls;
	}
	/**
	 *	Saves into our persistance layer an object..
	 *	@param Tls Tlshe object to save
	 */
	public int sv(Tls tSv){
		int tmStmp=arryTls.size();
		tSv.stId(tmStmp);
		arryTls.add(tSv);
		flWrtr.sv("Tls",arryTls);
		return tmStmp;
	}
	/**
	 * 	Updates a certain EXISTING object's parameters..
	 *	@param Tls key for said object
	 *	@param String[] parameters in the order of [toolCode,toolName,imageIcon location].
	 */
	public void updt(int bngEdtd, Object[] prmtrs){
		Tls tmp=arryTls.get(bngEdtd);
		tmp.stTlCd((String)prmtrs[0]);
		tmp.stTlNm((String)prmtrs[1]);
		tmp.stImgIcnTl((String)prmtrs[1]);
		flWrtr.sv("Tls",arryTls);
	}
	/**
	 *	Deletes a specific object of a kind. 
	 *	@param Tls  key for object.
	 */
	public void dlt(int bngDltd){
		int tmp=arryTls.size()-(1+bngDltd);
		arryTls.remove(bngDltd);
		for(int i=0;i<tmp;i++){
			Tls rnm=arryTls.get(bngDltd+i);
			rnm.stId(bngDltd+i);
		}
		flWrtr.sv("Tls",arryTls);
	}
}
