package JViNoM.Vw;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import JViNoM.Cntrllr.*;
/**
 *	Main project view. It mostly lists scenes, so the name.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class PrjctScnsLst extends GSttIntrfc{
	private JPanel rtrnbl;
	private TxtFtchr txtFtchr=TxtFtchr.gtInstnc();
	private SttcFtchr sttcFtchr=new SttcFtchr();
	public PrjctScnsLst(JPnlCrtl cntxt,int a,int b){
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
		}
		return rtrnbl;
	}
}
