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

			SpringLayout lyt=new SpringLayout();
			rtrnbl.setLayout(lyt);

			CrtNwPrjctLstnr crtNwPrjctLstnr=new CrtNwPrjctLstnr(this);
			nm=new JLabel(txtFtchr.gtTxt(10));
			svT=new JLabel(txtFtchr.gtTxt(11));
			dfltAspctRt=new JLabel(txtFtchr.gtTxt(12));

			nmT=new JTextArea(1,20);
			svTT=new JTextArea(1,20);
			wdt=new JTextArea(1,4);
			hgh=new JTextArea(1,4);

			chsFl=new JButton(sttcFtchr.gtSttc(0));
			crt=new JButton(txtFtchr.gtTxt(13));
			cncl=new JButton(txtFtchr.gtTxt(14));

			
			chsFl.addActionListener(crtNwPrjctLstnr);
			crt.addActionListener(crtNwPrjctLstnr);
			cncl.addActionListener(crtNwPrjctLstnr);
			JPanel sb1=new JPanel();
			JPanel sb2=new JPanel();
			JPanel sb3=new JPanel();
			JPanel sb4=new JPanel();

			sb1.add(nm);
			sb1.add(nmT);

			sb2.add(svT);
			sb2.add(svTT);
			sb2.add(chsFl);

			sb3.add(dfltAspctRt);
			sb3.add(wdt);			
			sb3.add(hgh);

			sb4.add(crt);
			sb4.add(cncl);

			rtrnbl.add(sb1);
			rtrnbl.add(sb2);
			rtrnbl.add(sb3);
			rtrnbl.add(sb4);

			lyt.putConstraint(SpringLayout.WEST,sb1,6,SpringLayout.WEST,rtrnbl);
			lyt.putConstraint(SpringLayout.WEST,sb2,6,SpringLayout.WEST,rtrnbl);
			lyt.putConstraint(SpringLayout.WEST,sb3,6,SpringLayout.WEST,rtrnbl);
			lyt.putConstraint(SpringLayout.WEST,sb4,6,SpringLayout.WEST,rtrnbl);

			lyt.putConstraint(SpringLayout.NORTH,sb2,6,SpringLayout.SOUTH,sb1);
			lyt.putConstraint(SpringLayout.NORTH,sb3,6,SpringLayout.SOUTH,sb2);
			lyt.putConstraint(SpringLayout.NORTH,sb4,6,SpringLayout.SOUTH,sb3);

		}
		prjctWndw.setContentPane(rtrnbl);
		prjctWndw.setVisible(true);
		return rtrnbl;
	}
}
