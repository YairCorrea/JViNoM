package JViNoM.Cntrllr;

import JViNoM.Mdl.Bns.Sttc;
import JViNom.Mdl.Dao.SttcDAO;
import JViNom.Mdl.Srvc.SttcSrvc;
import JViNoM.Mdl.Bns.Prjct;
import JViNom.Mdl.Dao.PrjctDAO;
import JViNom.Mdl.Srvc.PrjctSrvc;

import javax.swing.*;
public class SttcFtchr{
	private Icon[] imgs;
	public SttcFtchr(){
		SttcSrvc sttcSrvc=new SttcSrvc(new SttcDAO());
		Sttcs[] sttcs=sttcSrvc.gtAllSrvc().toArray();
		imgs=new Icon[sttcs.length];
		for(int i=0;i<sttcs.length;i++){
			imgs[i]=new ImageIcon(sttcs.gtLctn);
		}
	}
	public SttcFtchr(String prjctNm){

	}
	public Icon gtSttc(int indx){
		if(indx<0 || indx>imgs.length) return null;
		return imgs[indx];
	}
}
