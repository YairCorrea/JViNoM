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
	private int prjctId;
	public PrjctScnsLst(JPnlCrtl cntxt,int a,int b){
		super(cntxt,a,b);
		prjctId=-1;
	}
	//State methods
	public void crtNwPrjct(){
		super.gtCntxt().gtCrtNwPrjct().gtVw(super.wdth,super.hght);
	}
	public void crtNwScn(){
		CrtNwScn crtNwScn=(CrtNwScn)(super.gtCntxt().gtCrtNwScn());
		crtNwScn.stPrjct(prjctId);
		crtNwScn.gtVw(super.wdth,super.hght);

	}
	public void opnFl(){
		//openFile.

	}
	public void cncl(){
		//Return to strtMn
		JPnlCrtl tmp=super.gtCntxt();
		tmp.stStt(tmp.gtStrtMn());
		tmp.ntfy();
	}

	public void stPrjct(int prjctId){
		this.prjctId=prjctId;
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

			rtrnbl.setSize(wdth,hght);
			
			MouseListener lstnr=new PrjctScnsLstLstnr(this);

			JButton rtrn=new JButton(txtFtchr.gtTxt(15));

			JLabel scns=new JLabel(txtFtchr.gtTxt(16));
			JLabel nScns=new JLabel(txtFtchr.gtTxt(17));
			JLabel crtNwScn=new JLabel(txtFtchr.gtTxt(18));
			JLabel rcntScns=new JLabel(txtFtchr.gtTxt(19));
			JLabel nRcntScns=new JLabel(txtFtchr.gtTxt(20));

			nScns.addMouseListener(lstnr);
			crtNwScn.addMouseListener(lstnr);
			rtrn.addMouseListener(lstnr);

			rtrnbl.add(rtrn);
			rtrnbl.add(scns);
			rtrnbl.add(nScns);
			rtrnbl.add(crtNwScn);
			rtrnbl.add(rcntScns);
			rtrnbl.add(nRcntScns);
		}
		return rtrnbl;
	}
}
