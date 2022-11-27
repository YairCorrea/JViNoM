package JViNoM.Vw;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import JViNoM.Cntrllr.*;
/**
 * 	View that prompts when you want to create a new project..
 *	@Author Yair Correa
 *	@Version 2211
 */
public class CrtNwPrjct extends GSttIntrfc{
	private JFrame prjctWndw;
	private JPanel rtrnbl;
	private JLabel nm;
	private JLabel svT;
	private JLabel dfltAspctRt;

	public JTextArea nmT;
	public JTextArea svTT;
	public JTextArea wdt;
	public JTextArea hgh;

	private JButton chsFl;
	private JButton crt;
	private JButton cncl;

	private TxtFtchr txtFtchr=TxtFtchr.gtInstnc();
	private SttcFtchr sttcFtchr=new SttcFtchr();

	public CrtNwPrjct(JPnlCrtl cntxt,int a, int b){
		super(cntxt,a,b);
	}
	//State methods
	public void crtNwPrjct(){
		this.cncl();
	}
	public void crtNwScn(){
		//NA
	}
	public void opnFl(){
		//Chooses which file to open.
	}
	public void cncl(){
		prjctWndw.setVisible(false);
	}

	/**
	 *	Get the view of THIS state.
	 *	
	 *	@return JPanel The view in JPanel so you can put it wherever its needed.
	 */
	public JPanel gtVw(int wdth,int hght){
		if(rtrnbl==null){
			prjctWndw=new JFrame(txtFtchr.gtTxt(9)+cntxt.gtTtl());

			prjctWndw.setSize((int)wdth/2,(int)hght/2);

			rtrnbl=new JPanel();
			rtrnbl.setSize((int)wdth/2,(int)hght/2);

			CrtNwPrjctLstnr crtNwPrjctLstnr=new CrtNwPrjctLstnr(this);
			nm=new JLabel(txtFtchr.gtTxt(10));
			svT=new JLabel(txtFtchr.gtTxt(11));
			dfltAspctRt=new JLabel(txtFtchr.gtTxt(12));

			nmT=new JTextArea(2,20);
			svTT=new JTextArea(2,20);
			wdt=new JTextArea(2,4);
			hgh=new JTextArea(2,4);

			chsFl=new JButton(sttcFtchr.gtSttc(0));
			crt=new JButton(txtFtchr.gtTxt(13));
			cncl=new JButton(txtFtchr.gtTxt(14));

			chsFl.addActionListener(crtNwPrjctLstnr);
			crt.addActionListener(crtNwPrjctLstnr);
			cncl.addActionListener(crtNwPrjctLstnr);
			
			rtrnbl.add(nm);
			rtrnbl.add(nmT);

			rtrnbl.add(svT);
			rtrnbl.add(svTT);
			rtrnbl.add(chsFl);

			rtrnbl.add(dfltAspctRt);
			rtrnbl.add(wdt);			
			rtrnbl.add(hgh);

			rtrnbl.add(crt);
			rtrnbl.add(cncl);
		}
		prjctWndw.setContentPane(rtrnbl);
		prjctWndw.setVisible(true);
		return rtrnbl;
	}
}
