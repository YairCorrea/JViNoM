package JViNoM.Vw;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;

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
	private EdtrLsntr edtrLstnr;
	private ArrayList<JComponent[]> lyrs=new ArrayList<JComponent[]>();
	private int prjctId,scnId;
	private JComponent mvn;
	public Edtr(JPnlCrtl cntxt,int a,int b){
		super(cntxt,a,b);
		prjctId=-1;
		scnId=-1;
		mvn=null;
	}
	//State methods
	public void crtNwPrjct(){
		super.gtCntxt().gtCrtNwPrjct();
	}
	public void crtNwScn(){
		//NA
	}
	public void opnFl(){
		//NA
	}
	public void cncl(){
		//NA
	}
	public void stPrjct(int prjctId){
		this.prjctId=prjctId;
	}
	public int gtPrjctId(){
		return prjctId;
	}
	public void stScn(int prjctId){
		this.scnId=prjctId;
	}
	public int gtScnId(){
		return scnId;
	}
	public void stLyr(int lyrId,JComponent[] cmpnnts){
		lyrs.add(lyrId,cmpnnts);
		MouseListener[] cnfrm;
		JPanel lyr=new JPanel();
		for(JComponent ele:cmpnnts){
			cnfrm=(MouseListener[])ele.getListeners(MouseListener.class);
			if(cnfrm.length==0)ele.addMouseListener(edtrLstnr);
			lyr.add(ele);
		}
		rtrnbl.add(lyr);
	}
	public ArrayList<JComponent[]> gtLyrs(){
		return lyrs;
	}
	public void stSlct(JComponent e){
		this.mvn=e;
	}
	public JComponent gtCrrntSlct(){
		return mvn;
	}
	/**
	 *	Get the view of THIS state.
	 *	
	 *	@return JPanel The view in JPanel so you can put it wherever its needed.
	 */
	public JPanel gtVw(int wdth,int hght){
		if(rtrnbl==null){
			SpringLayout lyt=new SpringLayout();
			rtrnbl=new JPanel(lyt);
			edtrLstnr=new EdtrLsntr(this);
			rtrnbl.setSize(wdth,hght);
		}
		edtrLstnr.igntCnvs();
		return rtrnbl;
	}
}
