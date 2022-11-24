package JViNoM.Cntrllr;

import JViNoM.Mdl.DAO;
import JViNoM.Mdl.Srvcs.LclsSrvc;
import JViNoM.Mdl.Srvcs.CnfgsSrvc;
import JViNoM.Mdl.Bns.Lcls;
import JViNoM.Mdl.Bns.Cnfgs;
import JViNoM.Mdl.Dao.CnfgsDAO;
import JViNoM.Mdl.Dao.LclsDAO;

/**
 *	A simple singleton for the view to be able to fetch and chance JViNoM's languaje.
 */
public class TxtFtchr{
	private static TxtFtchr instnc=new TxtFtchr();
	private String[] txt=new String[0];
	private TxtFtchr(){
		LclsSrvc lclsSrvc=new LclsSrvc(new LclsDAO());
		CnfgsSrvc cnfgsSrvc=new CnfgsSrvc(new CnfgsDAO());
		Cnfgs[] cnfg=cnfgsSrvc.gtAllCnfgs().toArray(new Cnfgs[0]);
		Lcls[] lcls=lclsSrvc.gtAllLcls().toArray(new Lcls[0]);
		for(int i=0; i<lcls.length;i++){
			if(lcls[i].gtLclNm().equals(cnfg[0].gtIdm())){
				txt=lcls[i].gtTxt();
				break;
			}
		}
	}
	public static TxtFtchr gtInstnc(){
		return instnc;
	}
	public String gtTxt(int indx){
		if(indx<0 || indx>txt.length) return txt[0];
		return txt[indx];
	}
}
