package JViNoM.Vw;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.util.ArrayList;

import javax.swing.border.Border;
import JViNoM.Cntrllr.*;
/**
 *	Super simple list view for layers.
 *	@Author Yair Correa
 *	@Version 2211
 */

public class LyrLstVw extends AsstVw implements Obsrvr{
	private JPanel rtrnbl;
	private TxtFtchr txtFtchr=TxtFtchr.gtInstnc();
	private String ttl1;
	private ArrayList<JComponent[]> crrnt;
	public LyrLstVw(String ttl,Wndw prd){
		super(ttl,prd);
		this.ttl1=ttl;
		rtrnbl=new JPanel();
		Border blck=BorderFactory.createLineBorder(Color.black);
		rtrnbl.setBorder(blck);
	}
	public void rcvNwLyrs(ArrayList<JComponent[]> crrnt){
		this.crrnt=crrnt;

	}
	public void updt(JPanel ignore){
		rtrnbl.repaint();
	}
	public JPanel obtnrCrtl(){
		rtrnbl.removeAll();
		rtrnbl.add(new JLabel(txtFtchr.gtTxt(33)));
		if(super.gtStt().getClass()==Edtr.class){
			Edtr edtr=(Edtr)super.gtStt();
			crrnt=(crrnt==null)?edtr.gtLyrs():crrnt;
			BoxLayout lyt=new BoxLayout(rtrnbl,BoxLayout.Y_AXIS);
			rtrnbl.setLayout(lyt);
			MouseListener lstnr=new LyrLstVwLstnr(this);	
			JPanel lst=new JPanel();
			for(int i=0;i<crrnt.size();i++){
				if(i==0){
					JLabel nm=new JLabel(i+"");
					lst.add(nm);
				}else{
					JPanel lyrPn=new JPanel();
					JLabel nm=new JLabel(i+"");
					nm.addMouseListener(lstnr);
					lyrPn.add(nm);
					lst=lyrPn;
				}
					rtrnbl.add(lst);
			}
			lst=new JPanel();
			JButton crtNwLyr=new JButton();
			crtNwLyr.addMouseListener(lstnr);
			JButton upLyr=new JButton("^");
			upLyr.addMouseListener(lstnr);
			JButton dwnLyr=new JButton("V");
			dwnLyr.addMouseListener(lstnr);
			lst.add(crtNwLyr);
			lst.add(upLyr);
			lst.add(dwnLyr);
			rtrnbl.add(lst);
		}else{
			JLabel np=new JLabel(txtFtchr.gtTxt(31));
			rtrnbl.add(np);
		}
		return rtrnbl;
	}
}	
