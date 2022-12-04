package JViNoM.Cntrllr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

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
	private Prjct prjct;
	private Point orgn;
	public EdtrLsntr(Edtr src){
		this.srcF=src;
		mvng=null;
	}
	public void mouseEntered(MouseEvent e){
		return;
	}
	public void mouseExited(MouseEvent e){
		return;
	}
	public void mousePressed(MouseEvent e){
		orgn=e.getPoint();
		mvng=(JComponent)e.getSource();
		return;
	}
	public void mouseReleased(MouseEvent e){
		Point end=e.getPoint();
		mvng.setLocation(mvng.getX()+(end.x-orgn.x),mvng.getY()+(end.y-orgn.y));
		srcF.ntfy();
		return;
	}
	public void mouseClicked(MouseEvent e){
		try{
			JLabel ext=(JLabel)e.getSource();
			if(ext.getText()=="X"){
				sv();
				srcF.cncl();
				return;
			}
			srcF.stSlct(ext);
		}catch(Exception ex){
			ex.printStackTrace();
			srcF.cncl();
		}
	}
	public void sv(){
		PrjctDAO prjctDAO=new PrjctDAO();
		PrjctSrvc prjctSrvc=new PrjctSrvc(prjctDAO);
		ScnDAO scnDAO=new ScnDAO(prjctDAO.gt(srcF.gtPrjctId()));
		Scn tmp=scnDAO.gt(srcF.gtScnId());
		Object[] prmtrs=new Object[3];
		prmtrs[0]=tmp.gtNm();
		prmtrs[1]=tmp.gtPrjctId();
		ArrayList<JComponent[]> r=srcF.gtLyrs();
		ArrayList<Lyr> l=new ArrayList<Lyr>();
		for(int i=0;i<r.size();i++){
			Lyr dtmp=new Lyr();
			dtmp.stId(i);
			dtmp.stOrdr(i);
			dtmp.stScnId(srcF.gtScnId());
			dtmp.stCmpnnts(r.get(i));
			dtmp.stNm(i+"");
			l.add(dtmp);
		}
		prmtrs[2]=(Lyr[])l.toArray(new Lyr[0]);
		scnDAO.updt(srcF.gtScnId(),prmtrs);
		ArrayList<Scn> mg=scnDAO.gtAll();
		prjct=prjctDAO.gt(srcF.gtPrjctId());
		prjct.stScns((Scn[])mg.toArray(new Scn[0]));
		prjctSrvc.svPrjct(prjct);
	}
}
