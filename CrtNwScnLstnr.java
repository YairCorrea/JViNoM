package JViNoM.Cntrllr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import JViNoM.Cntrllr.TxtFtchr;
import JViNoM.Vw.*;
import JViNoM.Mdl.DAO;
import JViNoM.Mdl.Dao.*;
import JViNoM.Mdl.Bns.*;
import JViNoM.Mdl.Srvcs.*;

/**
 *	Listener for the new scene pop-up.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class CrtNwScnLstnr implements ActionListener{
	private TxtFtchr txtFtchr=TxtFtchr.gtInstnc();
	private CrtNwScn srcF;
	public CrtNwScnLstnr(CrtNwScn src){
		this.srcF=src;
	}
	public void actionPerformed(ActionEvent e){
		
		JButton src=(JButton)e.getSource();

		if(src.getText().equals(txtFtchr.gtTxt(13))){
			JPnlCrtl cntxt=srcF.gtCntxt();

			String nmt=srcF.nmT.getText();

			//Creates scene.
			Scn scn=new Scn();
			scn.stNm(nmt);
			scn.stPrjctId(srcF.gtPrjctId());
			
			//Registers new scene.
			PrjctDAO prjctDAO=new PrjctDAO();
			ScnSrvc scnSrvc=new ScnSrvc(new ScnDAO(prjctDAO.gt(srcF.gtPrjctId())));
			scnSrvc.stScn(scn);
			int scnId=scnSrvc.save();

			//Fetches project which owns it and updates it.
			PrjctSrvc prjcSrvc=new PrjctSrvc(prjctDAO);
			Prjct crrnt=prjctDAO.gt(srcF.gtPrjctId());
			Scn[] scns=crrnt.gtScns();
			Scn[] nwScns=new Scn[scns.length+1];
			Lyr[] req=new Lyr[1];
			
			Lyr asd=new Lyr();
			
			asd.stScnId(scns.length);
			asd.stOrdr(scns.length);
			asd.stNm(scns.length+"");
			asd.stCmpnnts(new JComponent[0]);
			asd.stId(0);
			
			req[0]=asd;

			scn.stLyrs(req);
			
			for(int i=0;i<scns.length;i++){
				nwScns[i]=scns[i];
			}
			//Investigate this part
			nwScns[scns.length]=scn;
			
			Object[] nwDt=new Object[4];
			nwDt[0]=crrnt.gtLctn();
			nwDt[1]=crrnt.gtNm();
			nwDt[2]=crrnt.gtAspctRltn();
			nwDt[3]=nwScns;
			prjctDAO.updt(srcF.gtPrjctId(),nwDt);		
			//Enters into the editor
			Edtr edtr=(Edtr)cntxt.gtEdtr();
			edtr.stScn(scnId);
			edtr.stPrjct(srcF.gtPrjctId());
			
			cntxt.stStt(cntxt.gtEdtr());
			srcF.crtNwScn();
			cntxt.ntfy();
			return;
		}
		if(src.getText().equals(txtFtchr.gtTxt(14))){
			//Cancel. Just hides the frame.
			srcF.cncl();
			return;
		}
	}
}
