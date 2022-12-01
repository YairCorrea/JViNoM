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
	private int crrntLyr;
	private ArrayList<JComponent[]> lyrs=new ArrayList<JComponent[]>();
	private int prjctId,scnId;
	private JComponent mvn;
	private JLabel ext;
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
		System.out.println("Not available");
	}
	public void opnFl(){
		super.gtCntxt().gtStrtMn().opnFl();
	}
	public void cncl(){
		JPnlCrtl cntxt=super.gtCntxt();
		cntxt.stStt(cntxt.gtStrtMn());
		cntxt.ntfy();
	}
	public void stPrjct(int prjctId){
		this.prjctId=prjctId;
	}
	public int gtPrjctId(){
		return prjctId;
	}
	public void stScn(int prjctId){
		lyrs=new ArrayList<JComponent[]>();
		crrntLyr=0;
		this.scnId=prjctId;
	}
	public int gtCrrntLyr(){
		return crrntLyr;
	}
	public void stCrrntLyr(int c){
		this.crrntLyr=c;
	}
	public int gtScnId(){
		return scnId;
	}
	public void stLyr(int lyrId,JComponent[] cmpnnts){
		lyrs.set(lyrId,cmpnnts);
		MouseListener[] cnfrm;
		System.out.println();
		JPanel lyr=new JPanel();
		for(JComponent ele:cmpnnts){
			cnfrm=(MouseListener[])ele.getListeners(MouseListener.class);
			if(cnfrm.length==0)ele.addMouseListener(edtrLstnr);
			lyr.add(ele);
		}
		rtrnbl.add(lyr);
		rtrnbl.repaint();
	}
	public void stLyrs(ArrayList<JComponent[]> lyrs){
		this.lyrs=lyrs;
	}
	public ArrayList<JComponent[]> gtLyrs(){
		return lyrs;
	}
	public void stSlct(JComponent e){
		this.mvn=e;
		JPnlCrtl cntxt=super.gtCntxt();
		cntxt.ntfy();

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
			lyrs=new ArrayList<JComponent[]>();
			SpringLayout lyt=new SpringLayout();
			rtrnbl=new JPanel(lyt);
			edtrLstnr=new EdtrLsntr(this);
			ext=new JLabel("X");
			ext.addMouseListener(edtrLstnr);
			rtrnbl.setSize(wdth,hght);
		}
		rtrnbl.removeAll();
		for(int i=0;i<lyrs.size();i++){
			stLyr(i,lyrs.get(i));
		}
		rtrnbl.add(ext);
		return rtrnbl;
	}
}
