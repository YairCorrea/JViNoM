package JViNoM.Vw;

import java.awt.*;
import javax.swing.*;

import javax.swing.border.Border;
import JViNoM.Cntrllr.*;
/**
 *	Super simple view for a selected element.
 *	@Author Yair Correa
 *	@Version 2211
 */

public class SnglAsstVw extends AsstVw{
	private JPanel rtrnbl;
	private TxtFtchr txtFtchr=TxtFtchr.gtInstnc();
	private String ttl1;
	public SnglAsstVw(String ttl,Wndw prd){
		super(ttl,prd);
		this.ttl1=ttl;
		rtrnbl=new JPanel();
		Border blck=BorderFactory.createLineBorder(Color.black);
		rtrnbl.setBorder(blck);
	}	
	public JPanel obtnrCrtl(){
		rtrnbl.removeAll();
		rtrnbl.add(new JLabel(txtFtchr.gtTxt(34)));
		if(super.gtStt().getClass()==Edtr.class){
			Edtr edtr=(Edtr)super.gtStt();
			JComponent crrnt=edtr.gtCrrntSlct();
			if(crrnt==null){
				JLabel ntSlctd=new JLabel(txtFtchr.gtTxt(32));
					rtrnbl.add(ntSlctd);

			}else{
					JTextArea x=new JTextArea(crrnt.getLocation().getX()+"");
					JTextArea y=new JTextArea(crrnt.getLocation().getY()+"");
					rtrnbl.add(x);
					rtrnbl.add(y);
				}
		}else{
			JLabel np=new JLabel(txtFtchr.gtTxt(31));
			rtrnbl.add(np);
		}
		return rtrnbl;
	}
}	
