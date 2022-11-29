package JViNoM.Vw;

import java.awt.*;
import javax.swing.*;

import java.util.ArrayList;

import javax.swing.border.Border;
import JViNoM.Cntrllr.*;
/**
 *	Super simple list view for layers.
 *	@Author Yair Correa
 *	@Version 2211
 */

public class LyrLstVw extends AsstVw{
	private JPanel rtrnbl;
	private TxtFtchr txtFtchr=TxtFtchr.gtInstnc();
	private String ttl1;
	public LyrLstVw(String ttl,Wndw prd){
		super(ttl,prd);
		this.ttl1=ttl;
		rtrnbl=new JPanel();
		Border blck=BorderFactory.createLineBorder(Color.black);
		rtrnbl.setBorder(blck);
	}	
	public JPanel obtnrCrtl(){
		rtrnbl.removeAll();
		rtrnbl.add(new JLabel(txtFtchr.gtTxt(33)));
		if(super.gtStt().getClass()==Edtr.class){
			Edtr edtr=(Edtr)super.gtStt();
			ArrayList<JComponent[]> crrnt=edtr.gtLyrs();
			BoxLayout lyt=new BoxLayout(rtrnbl,BoxLayout.Y_AXIS);
			rtrnbl.setLayout(lyt);
			
			JPanel lst=new JPanel();
			for(int i=0;i<crrnt.size();i++){
				if(i==0){
					JLabel nm=new JLabel(i+".-");
					lst.add(nm);
				}else{
					JPanel lyrPn=new JPanel();
					JLabel nm=new JLabel(i+".-");
					lyrPn.add(nm);
					lst=lyrPn;
				}
					rtrnbl.add(lst);
			}
			
		}else{
			JLabel np=new JLabel(txtFtchr.gtTxt(31));
			rtrnbl.add(np);
		}
		return rtrnbl;
	}
}	
