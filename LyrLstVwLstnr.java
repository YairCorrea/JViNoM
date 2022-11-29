package JViNoM.Vw;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

import JViNoM.Vw.*;
import JViNoM.Mdl.Dao.*;
import JViNoM.Mdl.Bns.*;
import JViNoM.Mdl.Srvcs.*;

public class LyrLstVwLstnr implements MouseListener{
	private LyrLstVw srcF;
	private ArrayList<Lyr> lyrs;
	private LyrSrvc lyrSrvc;
	private Scn scn;
	private int scnId;
	public LyrLstVwLstnr(LyrLstVw src){
		this.srcF=src;
		JPnlCrtl cntxt=srcF.gtStt().gtCntxt();
		Edtr crrnt=(Edtr)cntxt.gtEdtr();
		PrjctDAO prjctDAO=new PrjctDAO();
		scnId=crrnt.gtScnId();
		ScnDAO scnDAO=new ScnDAO(prjctDAO.gt(crrnt.gtPrjctId()));
		scn=scnDAO.gt(scnId);
		lyrs=new ArrayList<Lyr>(Arrays.asList(scn.gtLyrs()));
		lyrSrvc=new LyrSrvc(new LyrDAO(scn));
	}

	public void mouseEntered(MouseEvent e){
		return ;
	}
	public void mouseExited(MouseEvent e){
		return ;
	}
	public void mousePressed(MouseEvent e){
		return ;
	}
	public void mouseReleased(MouseEvent e){
		return ;
	}
	@Override
	public void mouseClicked(MouseEvent e){
		try{
			JLabel src=(JLabel)e.getSource();
			return ;
		}catch(Exception ex){
			JButton src=(JButton)e.getSource();
			String meh=src.getText();

			if(meh=="V"){
				//Move layer down
				return;
			}
			if(meh=="^"){
				//Move layer up
				return;
			}			
			//Else, its the create layer button.
			Lyr lyr=new Lyr();
			lyr.stScnId(scnId);
			lyr.stCmpnnts(new JComponent[0]);
			lyr.stOrdr(lyrs.size());
			lyrSrvc.stLyr(lyr);
			int nw=lyrSrvc.save();
			lyrs.add(lyr);
			updt();
		}
	}
	public void updt(){
		ArrayList<JComponent[]> cmpnts=new ArrayList<JComponent[]>();

		for(Lyr lyr:lyrs){
			cmpnts.add(lyr.gtCmpnnts());
		}
		srcF.rcvNwLyrs(cmpnts);
		JPnlCrtl cntxt=srcF.gtStt().gtCntxt();
		Edtr crrnt=(Edtr)cntxt.gtEdtr();
		for(Lyr lyr: lyrs){
			crrnt.stLyr(lyr.gtId(),lyr.gtCmpnnts());
		}
		cntxt.ntfy();
	}
}
