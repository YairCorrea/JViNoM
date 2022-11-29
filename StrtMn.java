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
	public JComponent ntRcnt;
	private TxtFtchr txtFtchr=TxtFtchr.gtInstnc();
	private SttcFtchr sttcFtchr=new SttcFtchr();
	//State methods
	public StrtMn(JPnlCrtl cntx,int w,int h){
		super(cntx,w,h);
	}
	public void crtNwPrjct(){
		super.gtCntxt().gtCrtNwPrjct().gtVw(super.wdth,super.hght);
	}
	public void crtNwScn(){
		System.out.println("Not available");
	}
	public void opnFl(){
		//OpenFile
	}
	public void cncl(){
		//None.
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

			SpringLayout lyt=new SpringLayout();
			rtrnbl.setLayout(lyt);

			JLabel strt= new JLabel(txtFtchr.gtTxt(1));
			JLabel nwPrjct=new JLabel(txtFtchr.gtTxt(2));
			JLabel opnFl=new JLabel(txtFtchr.gtTxt(3));

			JLabel rcnt=new JLabel(txtFtchr.gtTxt(4));
			ntRcnt=(ntRcnt==null)?new JLabel(txtFtchr.gtTxt(5)):ntRcnt;

			JLabel cmmnt=new JLabel(txtFtchr.gtTxt(6));
			JLabel mnl=new JLabel(txtFtchr.gtTxt(7));
			JLabel srcCd=new JLabel(txtFtchr.gtTxt(8));

			mnl.setForeground(Color.BLUE.darker());
			srcCd.setForeground(Color.BLUE.darker());

			nwPrjct.addMouseListener(lstnr);
			opnFl.addMouseListener(lstnr);
			ntRcnt.addMouseListener(lstnr);
			cmmnt.addMouseListener(lstnr);
			mnl.addMouseListener(lstnr);
			srcCd.addMouseListener(lstnr);
			JLabel jvmn=new JLabel(sttcFtchr.gtSttc(0));

			rtrnbl.add(strt);
			rtrnbl.add(nwPrjct);
			rtrnbl.add(opnFl);
			rtrnbl.add(rcnt);
			rtrnbl.add(ntRcnt);
			rtrnbl.add(cmmnt);
			rtrnbl.add(mnl);
			rtrnbl.add(srcCd);
			rtrnbl.add(jvmn);

			lyt.putConstraint(SpringLayout.WEST,strt,6,SpringLayout.WEST,rtrnbl);
			lyt.putConstraint(SpringLayout.NORTH,strt,6,SpringLayout.NORTH,rtrnbl);
			lyt.putConstraint(SpringLayout.NORTH,nwPrjct,6,SpringLayout.SOUTH,strt);
			lyt.putConstraint(SpringLayout.NORTH,opnFl,6,SpringLayout.SOUTH,nwPrjct);

			lyt.putConstraint(SpringLayout.NORTH,rcnt,30,SpringLayout.SOUTH,opnFl);
			lyt.putConstraint(SpringLayout.NORTH,ntRcnt,6,SpringLayout.SOUTH,rcnt);
			
			lyt.putConstraint(SpringLayout.WEST,cmmnt,6,SpringLayout.HORIZONTAL_CENTER,rtrnbl);
			lyt.putConstraint(SpringLayout.NORTH,cmmnt,6,SpringLayout.NORTH,rtrnbl);
			
			lyt.putConstraint(SpringLayout.WEST,mnl,6,SpringLayout.HORIZONTAL_CENTER,rtrnbl);
			lyt.putConstraint(SpringLayout.NORTH,mnl,6,SpringLayout.SOUTH,cmmnt);
			lyt.putConstraint(SpringLayout.WEST,srcCd,6,SpringLayout.HORIZONTAL_CENTER,rtrnbl);
			lyt.putConstraint(SpringLayout.NORTH,srcCd,6,SpringLayout.SOUTH,mnl);
			lyt.putConstraint(SpringLayout.NORTH,jvmn,6,SpringLayout.SOUTH,srcCd);
			lyt.putConstraint(SpringLayout.WEST,jvmn,6,SpringLayout.HORIZONTAL_CENTER,rtrnbl);
		}
		return rtrnbl;
	}
}
