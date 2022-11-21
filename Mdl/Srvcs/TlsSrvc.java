package JViNoM.Mdl.Srvcs;

import JViNoM.Mdl.DAO;
import JViNoM.Mdl.Dao.TlsDAO;
import JViNoM.Mdl.Bns.Tls;

/**
 *	Service for the project bean.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class TlsSrvc{
	private DAO<Tls> dTls;
	private Tls crrntTls;
	
	TlsSrvc(DAO<Tls> dTls){
		this.dTls=dTls;
	}
	/**
	 *	Sets the current element.
	 *	@param Tls new current element.
	 */
	public void stTls(Tls crrntTls){
		this.crrntTls=crrntTls;
	}
	/**
	 *	Makes a call to the DAO for the bean. Saving it to disk and giving us a new object as current.
	 */
	public void save(){
		dTls.sv(crrntTls);
	}
	/**
	 *	Makes a call for the DAO to fetch us the data
	 *	@return Collection<Tls> A list with all current data..
	 */
	public Collection<Tls> gtAllTls(){
		return dTls.gtAll();
	}
	/**
	 *	Makes a call to save object, without changing current object.
	 *	@param Tls the object to save.
	 */
	public int svTls(Tls crrntTls){
		dTls.sv(crrntTls);
	}
}	
