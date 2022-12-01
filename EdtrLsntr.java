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
	private Point orgn;
	private Prjct prjct;
	public EdtrLsntr(Edtr src){
		this.srcF=src;
		mvng=null;
		orgn=null;
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
			JLabel ext=(JLabel)e.getSource();
			if(ext.getText()=="X"){
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
				srcF.cncl();
				return;
			}
			srcF.stSlct(ext);
		}catch(Exception ex){
			ex.printStackTrace();
			srcF.cncl();
		}
	}
}
