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
		if(((Edtr)srcF.gtStt()).gtLyrs().size()==0){
			lyrs=new ArrayList<Lyr>(Arrays.asList(scn.gtLyrs()));
			ArrayList<JComponent[]> cmpnts=new ArrayList<JComponent[]>();
			for(Lyr lyr:lyrs){
				cmpnts.add(lyr.gtCmpnnts());
			}
			srcF.rcvNwLyrs(cmpnts);
			JPnlCrtl idk=srcF.gtStt().gtCntxt();
			Edtr idk2=(Edtr)idk.gtEdtr();
			idk2.stLyrs(cmpnts);
			updt();
		}else{
			lyrs=new ArrayList<Lyr>();
			Lyr tmp=new Lyr();
			ArrayList<JComponent[]> ugh=((Edtr)srcF.gtStt()).gtLyrs();
			for(int i=0;i<ugh.size();i++){
				tmp=new Lyr();
				tmp.stOrdr(i);
				tmp.stScnId(scnId);
				tmp.stCmpnnts(ugh.get(i));
				lyrs.add(tmp);
			}
		}
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
			src.setOpaque(true);
			src.setBackground(Color.BLUE);
			Edtr uwu=((Edtr)srcF.gtStt());
			uwu.stCrrntLyr(Integer.parseInt(src.getText()));
			src.repaint();
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
		crrnt.stLyrs(cmpnts);
		cntxt.ntfy();
	}
}
