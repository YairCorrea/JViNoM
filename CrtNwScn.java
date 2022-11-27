package JViNoM.Vw;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import JViNoM.Cntrllr.*;
/**
 * 	View that prompts when you want to create a new scene.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class CrtNwScn extends GSttIntrfc{
	private JFrame scnWndw;
	private JLabel nm;
	private JPanel rtrnbl;

	public JTextArea nmT;

	private JButton crt;
	private JButton cncl;

	private TxtFtchr txtFtchr=TxtFtchr.gtInstnc();
	private SttcFtchr sttcFtchr=new SttcFtchr();
	public CrtNwScn(JPnlCrtl cntxt,int a, int b){
		super(cntxt,a,b);
	}
	//State methods
	public void crtNwPrjct(){
		super.gtCntxt().gtCrtNwPrjct();
	}
	public void crtNwScn(){
		this.cncl();
	}
	public void opnFl(){
		//NA
	}
	public void cncl(){
		scnWndw.setVisible(false);
	}

	/**
	 *	Get the view of THIS state.
	 *	
	 *	@return JPanel The view in JPanel so you can put it wherever its needed.
	 */
	public JPanel gtVw(int wdth,int hght){
		if(rtrnbl==null){
			scnWndw=new JFrame(txtFtchr.gtTxt(9)+cntxt.gtTtl());

			scnWndw.setSize((int)wdth/2,(int)hght/2);

			rtrnbl=new JPanel();
			rtrnbl.setSize((int)wdth/2,(int)hght/2);

			CrtNwScnLstnr crtNwScnLstnr=new CrtNwScnLstnr(this);
			nm=new JLabel(txtFtchr.gtTxt(21));
			
			nmT=new JTextArea(2,20);
			
			crt=new JButton(txtFtchr.gtTxt(13));
			cncl=new JButton(txtFtchr.gtTxt(14));

			crt.addActionListener(crtNwScnLstnr);
			cncl.addActionListener(crtNwScnLstnr);
			
			rtrnbl.add(nm);
			rtrnbl.add(nmT);

			rtrnbl.add(crt);
			rtrnbl.add(cncl);
		}
		scnWndw.setContentPane(rtrnbl);
		scnWndw.setVisible(true);
		return rtrnbl;
	}
}
