package JViNoM.Mdl.Srvcs;

import java.util.Collection;

import JViNoM.Mdl.DAO;
import JViNoM.Mdl.Dao.SttcDAO;
import JViNoM.Mdl.Bns.Sttc;

/**
 *	Service for the project bean.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class SttcSrvc{
	private DAO<Sttc> dSttc;
	private Sttc crrntSttc;
	
	public SttcSrvc(DAO<Sttc> dSttc){
		this.dSttc=dSttc;
	}
	/**
	 *	Sets the current element.
	 *	@param Sttc new current element.
	 */
	public void stSttc(Sttc crrntSttc){
		this.crrntSttc=crrntSttc;
	}
	/**
	 *	Makes a call to the DAO for the bean. Saving it to disk and giving us a new object as current.
	 */
	public int save(){
		return dSttc.sv(crrntSttc);
	}
	/**
	 *	Makes a call for the DAO to fetch us the data
	 *	@return Collection<Sttc> A list with all current data..
	 */
	public Collection<Sttc> gtAllSttc(){
		return dSttc.gtAll();
	}
	/**
	 *	Makes a call to save object, without changing current object.
	 *	@param Sttc the object to save.
	 */
	public int svSttc(Sttc crrntSttc){
		return dSttc.sv(crrntSttc);
	}
}	
