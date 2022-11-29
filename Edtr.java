package JViNoM.Vw;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import JViNoM.Cntrllr.*;
/**
 * 	Scene editor - view.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class Edtr extends GSttIntrfc{
	private JPanel rtrnbl;
	private TxtFtchr txtFtchr=TxtFtchr.gtInstnc();
	private SttcFtchr sttcFtchr=new SttcFtchr();
	private int prjctId;
	public Edtr(JPnlCrtl cntxt,int a,int b){
		super(cntxt,a,b);
		prjctId=-1;
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
	public void stScn(int prjctId){
		this.prjctId=prjctId;
	}
	public int gtScnId(){
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
			//You need to be able to bring stuff here.
			rtrnbl.setSize(wdth,hght);
		}
		return rtrnbl;
	}
}
