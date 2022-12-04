package JViNoM.Vw;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import JViNoM.Cntrllr.*;
/**
 *	Tree Editor view.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class TrEdtr extends GSttIntrfc{
	private JPanel rtrnbl;
	public JPanel cnvs;
	private TxtFtchr txtFtchr=TxtFtchr.gtInstnc();
	private SttcFtchr sttcFtchr=new SttcFtchr();
	public TrEdtrLstnr lstnr;
	private int prjctId;

	public TrEdtr(JPnlCrtl cntxt,int a,int b){
		super(cntxt,a,b);
	}
	//State methods
	public void crtNwPrjct(){
		super.gtCntxt().gtCrtNwPrjct();
	}
	public void crtNwScn(){
	}
	public void opnFl(){
	}
	public void cncl(){
		lstnr.save();
	}

	public void stPrjct(int prjctId){
		this.prjctId=prjctId;
		lstnr.ppltTr(prjctId);
		rtrnbl.repaint();
	}
	public int gtPrjctId(){
		return prjctId;
	}
	/**
	 *	Get the view of THIS state.
	 *	
	 *	@return JPanel The view in JPanel so you can put it wherever its needed.
	 */
	public JPanel gtVw(int wdth,int hght){
		if(rtrnbl==null){
			rtrnbl=new JPanel();
			lstnr=new TrEdtrLstnr(this);
			JLabel ttl=new JLabel(txtFtchr.gtTxt(50));
			rtrnbl.add(ttl);
			rtrnbl.setSize(wdth,hght);
		}
		cnvs=new JPanel();
		BoxLayout lyt=new BoxLayout(cnvs,BoxLayout.X_AXIS);
		cnvs.setLayout(lyt);
		rtrnbl.add(cnvs);
		return rtrnbl;
	}
}
