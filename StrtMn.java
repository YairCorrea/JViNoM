package JViNoM.Vw;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import JViNoM.Cntrllr.*;
/**
 * 	Start menu view.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class StrtMn extends GSttIntrfc{
	private JPanel rtrnbl;
	private TxtFtchr txtFtchr=TxtFtchr.gtInstnc();
	private SttcFtchr sttcFtchr=new SttcFtchr();
	//State methods
	public void crtNwPrjct(){
		super.gtCntxt().gtCrtNwPrjct();
	}
	public void crtNwScn(){
	}
	public void opnFl(){
	}
	public void cncl(){

	}

	/**
	 *	Get the view of THIS state.
	 *	
	 *	@return JPanel The view in JPanel so you can put it wherever its needed.
	 */
	public JPanel gtVw(int wdth,int hght){
		if(rtrnbl==null){
			rtrnbl=new JPanel();

			rtrnbl.setSize(wdth,hght);
			MouseListener lstnr=new StrMnLstnr(this);

			JLabel strt= new JLabel(txtFtchr.gtTxt(1));
			JLabel nwPrjct=new JLabel(txtFtchr.gtTxt(2));
			JLabel opnFl=new JLabel(txtFtchr.gtTxt(3));

			JLabel rcnt=new JLabel(txtFtchr.gtTxt(4));	
			JLabel ntRcnt=new JLabel(txtFtchr.gtTxt(5));

			JLabel cmmnt=new JLabel(txtFtchr.gtTxt(6));
			JLabel mnl=new JLabel(txtFtchr.gtTxt(7));
			JLabel srcCd=new JLabel(txtFtchr.gtTxt(8));

			mnl.setForeground(Color.BLUE.darker());
			srcCd.setForeground(Color.BLUE.darker());

			mnl.addMouseListener(lstnr);
			srcCd.addMouseListener(lstnr);
			JLabel jvmn=new JLabel(sttcFtchr.gtSttc(0));
		}
		return rtrnbl;
	}
}