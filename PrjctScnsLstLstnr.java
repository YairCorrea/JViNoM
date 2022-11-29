package JViNoM.Cntrllr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.Arrays;

import JViNoM.Vw.*;
import JViNoM.Mdl.Srvcs.*;
import JViNoM.Mdl.Bns.*;
import JViNoM.Mdl.Dao.*;
import JViNoM.Cntrllr.TxtFtchr;

/**
 *	Listener for the scenes project page.
 *
 *	@Author Yair Correa
 *	@Version 2211
 */

public class PrjctScnsLstLstnr implements MouseListener{
	private TxtFtchr txtFtchr=TxtFtchr.gtInstnc();
	private PrjctScnsLst srcF;

	public PrjctScnsLstLstnr(PrjctScnsLst src){
		this.srcF=src;
		Prjct prjct=(new PrjctDAO()).gt(srcF.gtPrjctId());
		Scn[] scns=prjct.gtScns();
		ArrayList<Scn> scs=new ArrayList<Scn>(Arrays.asList(scns));
		JPanel rcntPrjcts=new JPanel();
		BoxLayout lyt=new BoxLayout(rcntPrjcts,BoxLayout.Y_AXIS);
		rcntPrjcts.setLayout(lyt);

		Iterator<Scn> prjctItrtr=new ScnItrtr(scs);

		Scn tmp;
		boolean hdSmntng=false;
		while(prjctItrtr.hasNext()){
			tmp=prjctItrtr.next();
			JLabel stmp=new JLabel(tmp.gtId()+"");
			stmp.addMouseListener(this);
			JLabel stmp2=new JLabel(tmp.gtNm());
			rcntPrjcts.add(stmp);
			rcntPrjcts.add(stmp2);
			hdSmntng=true;
		}
		if(hdSmntng) srcF.ntRcntScns=rcntPrjcts;
	}
	public void mouseEntered(MouseEvent e){
		return;
	}
	public void mouseExited(MouseEvent e){
		return;
	}
	public void mousePressed(MouseEvent e){
		return;
	}
	public void mouseReleased(MouseEvent e){
		return;
	}
	public void mouseClicked(MouseEvent e){
		try{
			JLabel src=(JLabel)e.getSource();
			if(src.getText().equals(txtFtchr.gtTxt(17))){
				srcF.crtNwScn();
				return;
			}
			if(src.getText().equals(txtFtchr.gtTxt(18))){
				srcF.crtNwScn();
				return;
			}
			int scnId=Integer.parseInt(src.getText());

			//Fetches project which owns it and updates it.
			JPnlCrtl cntxt=srcF.gtCntxt();

			//Enters into the editor
			Edtr edtr=(Edtr)cntxt.gtEdtr();
			edtr.stScn(scnId);
			edtr.stPrjct(srcF.gtPrjctId());
			
			cntxt.stStt(cntxt.gtEdtr());
			cntxt.ntfy();
			return;
		}catch(Exception ex){
			ex.printStackTrace();
			srcF.cncl();
		}
	}
}
