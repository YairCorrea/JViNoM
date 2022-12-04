package JViNoM.Cntrllr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import JViNoM.Cntrllr.TxtFtchr;
import JViNoM.Vw.*;
import JViNoM.Mdl.DAO;
import JViNoM.Mdl.Dao.*;
import JViNoM.Mdl.Bns.*;
import JViNoM.Mdl.Srvcs.*;

/**
 *	Listener for the new project pop-up.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class CrtNwPrjctLstnr implements ActionListener{
	private TxtFtchr txtFtchr=TxtFtchr.gtInstnc();
	private CrtNwPrjct srcF;
	public CrtNwPrjctLstnr(CrtNwPrjct src){
		this.srcF=src;
	}
	public void actionPerformed(ActionEvent e){
		
		JButton src=(JButton)e.getSource();

		if(src.getText().equals(txtFtchr.gtTxt(13))){
			//Create the project and moves to it. Meaning, changing status to prjctscnslst
			JPnlCrtl cntxt=srcF.gtCntxt();

			String nmt=srcF.nmT.getText();
			String fl=srcF.svTT.getText();
			String wdt=srcF.wdt.getText();
			String hgh=srcF.hgh.getText();

			Prjct prjct=new Prjct();
			prjct.stSttcs(new Sttc[0]);
			prjct.stScns(new Scn[0]);
			prjct.stLctn(fl);
			prjct.stNm(nmt);
			int[] efe={Integer.parseInt(wdt),Integer.parseInt(hgh)};
			prjct.stAspctRltn(efe);
			PrjctSrvc prjctSrvc=new PrjctSrvc(new PrjctDAO());
			prjctSrvc.stPrjct(prjct);
			
			int prjctId=prjctSrvc.save();
			PrjctScnsLst prjctLst=(PrjctScnsLst)cntxt.gtPrjctScnsLst();
			prjctLst.stPrjct(prjctId);
			cntxt.stStt(cntxt.gtPrjctScnsLst());

			((TrEdtr)cntxt.gtTrEdtr()).stPrjct(prjctId);
			srcF.crtNwPrjct();
			cntxt.ntfy();
			return;
		}
		if(src.getText().equals(txtFtchr.gtTxt(14))){
			//Cancel. Just hides the frame.
			srcF.cncl();
			return;
		}
		
		JFileChooser flChsr=new JFileChooser();
		JFrame flChsrFr=new JFrame();
		JPnlCrtl cntxt=srcF.gtCntxt();
		int i=flChsr.showOpenDialog(flChsrFr);
		if(i==JFileChooser.APPROVE_OPTION){
			File f=flChsr.getSelectedFile();
			String lctn=f.getPath();
			srcF.svTT.setText(lctn);
		}			
	}
}
