package JViNoM.Cntrllr;

import JViNoM.Mdl.Bns.Sttc;
import JViNoM.Mdl.Dao.SttcDAO;
import JViNoM.Mdl.Srvcs.SttcSrvc;
import JViNoM.Mdl.Bns.Prjct;
import JViNoM.Mdl.Dao.PrjctDAO;
import JViNoM.Mdl.Srvcs.PrjctSrvc;

import javax.swing.*;
public class SttcFtchr{
	private Icon[] imgs;
	public SttcFtchr(){
		SttcSrvc sttcSrvc=new SttcSrvc(new SttcDAO());
		Sttc[] sttcs=(Sttc[])sttcSrvc.gtAllSttc().toArray();
		imgs=new Icon[sttcs.length];
		for(int i=0;i<sttcs.length;i++){
			imgs[i]=new ImageIcon(sttcs[i].gtLctn());
		}
	}
	public SttcFtchr(String prjctNm){

	}
	public Icon gtSttc(int indx){
		if(indx<0 || indx>imgs.length) return null;
		return imgs[indx];
	}
}
