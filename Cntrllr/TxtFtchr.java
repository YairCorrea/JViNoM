package JViNoM.Cntrllr;

import JViNoM.Mdl.Srvc.LclsSrvc;
import JViNoM.Mdl.Bns.Lcls;
import JViNoM.Mdl.Bns.Cnfgs;
import JViNoM.Mdl.Dao.CnfgsDAO;
import JViNoM.Mdl.Dao.LclsDAO;

/**
 *	A simple singleton for the view to be able to fetch and chance JViNoM's languaje.
 */
public class TxtFtchr{
	private static TxtFtchr instnc=new TxtFtchr();
	private final String[] txt;
	private TxtFtchr(){
		LclsSrvc lclsSrvc=new LclsSrvc(new LclsDAO());
		CnfgsSrvc cnfgsSrvc=new CnfgsSrvc(new CnfgsSrvc());
		Cnfgs[] cnfg=cnfgsSrvc.gtAllCnfgs().toArray();
		Lcls[] lcls=lcsSrvc.gtAllLcls().toArray();
		for(int i=0; i<lcls.size();i++){
			if(lcls[i].gtLclNm().equals(cnfg[0].gtIdm())) txt=lcls[i].gtTxts();
		}
	}
	public static TxtFtchr gtInstnc(){
		return instnc;
	}
	public String gtTxt(int indx){
		if(indx<0 || indx>txt.size()) return txt[0];
		return txt[indx];
	}
}
