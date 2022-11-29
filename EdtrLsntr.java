package JViNoM.Cntrllr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import JViNoM.Vw.*;
import JViNoM.Cntrllr.TxtFtchr;

import JViNoM.Mdl.Dao.*;
import JViNoM.Mdl.Bns.*;
import JViNoM.Mdl.Srvcs.*;
/**
 *	Listener for the editor view.
 *
 *	@Author Yair Correa
 *	@Version 2211
 */

public class EdtrLsntr implements MouseListener{
	private TxtFtchr txtFtchr=TxtFtchr.gtInstnc();
	private Edtr srcF;
	private JComponent mvng;
	private Point orgn;
	public EdtrLsntr(Edtr src){
		this.srcF=src;
		mvng=null;
		orgn=null;
	}
	public void igntCnvs(){
			PrjctDAO prjctDAO=new PrjctDAO();
			Prjct prjct=prjctDAO.gt(srcF.gtPrjctId());
			ScnDAO scnDAO=new ScnDAO(prjct);
			Scn scn=scnDAO.gt(srcF.gtScnId());
			Lyr[] lyrs=scn.gtLyrs();
			for(int i=0;i<lyrs.length;i++){
				srcF.stLyr(i,lyrs[i].gtCmpnnts());
			}
	}
	public void mouseEntered(MouseEvent e){
		return;
	}
	public void mouseExited(MouseEvent e){
		return;
	}
	public void mousePressed(MouseEvent e){
		Point orgn=e.getPoint();
		mvng=(JComponent)e.getSource();
		return;
	}
	public void mouseReleased(MouseEvent e){
		e.getPoint();
		return;
	}
	public void mouseClicked(MouseEvent e){
		try{
		}catch(Exception ex){
			srcF.cncl();
		}
	}
}
