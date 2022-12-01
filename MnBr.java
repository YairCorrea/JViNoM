package JViNoM.Vw;

import java.awt.*;
import javax.swing.*;

import JViNoM.Cntrllr.*;
/**
 *	Top menu for a window.	
 */
public class MnBr extends Dcrtr{
	private static JMenuBar mb;
	private TxtFtchr txtFtchr=TxtFtchr.gtInstnc();
	private JMenu fl,edt,img,lyr,slct,scrpts,sttngs,wndw,hlp;
	private MnBrLstnr lstnr;
	private GSttIntrfc crrntStts;
	public MnBr(String ttl,Wndw prd){
		super(ttl,prd);

		lstnr=new MnBrLstnr(this);
		
		mb=new JMenuBar();
		
		fl=mkMn(txtFtchr.gtTxt(22));
		edt=mkMn(txtFtchr.gtTxt(23));
		img=mkMn(txtFtchr.gtTxt(24));
		lyr=mkMn(txtFtchr.gtTxt(25));
		slct=mkMn(txtFtchr.gtTxt(26));
		scrpts=mkMn(txtFtchr.gtTxt(27));
		sttngs=mkMn(txtFtchr.gtTxt(28));
		wndw=mkMn(txtFtchr.gtTxt(29));
		hlp=mkMn(txtFtchr.gtTxt(30));
		
		mb.add(fl);
		mb.add(edt);
		mb.add(img);
		mb.add(lyr);
		mb.add(slct);
		mb.add(scrpts);
		mb.add(sttngs);
		mb.add(wndw);
		mb.add(hlp);
	}
	public JPanel obtnrCrtl(){
		return null;
	}
	/**
	 *	Chance status of frame/panel, pass the status that you need it to move to.
	 *
	 *	@param GSttIntrfc The status to change to.
	 *	@return void
	 */
	public void stStt(GSttIntrfc nwStts){
		this.crrntStts=nwStts;
	}
	/**
	 *	Returns the current status of this frame.
	 *	@return GSttIntrfc Said status.
	 */
	public GSttIntrfc gtStt(){
		return crrntStts;
	}
	/**
	 *	Returns the according menu to the string fetched, if said string is a valid menu. Otherwise a blank menu.
	 *	@param String menu's name
	 *	@return JMenu menu produced.
	 */
	public JMenu mkMn(String m){
		JMenu rtrnbl=new JMenu(m);
		if(m==txtFtchr.gtTxt(22)){
			JMenuItem itm1=new JMenuItem(txtFtchr.gtTxt(35));
			JMenuItem itm2=new JMenuItem(txtFtchr.gtTxt(3));
			JMenuItem itm3=new JMenuItem(txtFtchr.gtTxt(36));
			JMenuItem itm4=new JMenuItem(txtFtchr.gtTxt(37));
			JMenuItem itm5=new JMenuItem(txtFtchr.gtTxt(18));
			JMenuItem itm6=new JMenuItem(txtFtchr.gtTxt(38));
			
			itm1.addActionListener(lstnr);
			itm2.addActionListener(lstnr);
			itm3.addActionListener(lstnr);
			itm4.addActionListener(lstnr);
			itm5.addActionListener(lstnr);
			itm6.addActionListener(lstnr);
			
			rtrnbl.add(itm1);
			rtrnbl.add(itm2);
			rtrnbl.add(itm3);
			rtrnbl.add(itm4);
			rtrnbl.add(itm5);
			rtrnbl.add(itm6);
			return rtrnbl;
		}
		if(m==txtFtchr.gtTxt(23)){
			JMenuItem itm1=new JMenuItem(txtFtchr.gtTxt(49));
			itm1.addActionListener(lstnr);
			rtrnbl.add(itm1);
			return rtrnbl;

		}
		if(m==txtFtchr.gtTxt(24)){
			JMenuItem itm1=new JMenuItem(txtFtchr.gtTxt(39));
			JMenuItem itm2=new JMenuItem(txtFtchr.gtTxt(40));
			rtrnbl.add(itm1);
			rtrnbl.add(itm2);
			itm1.addActionListener(lstnr);
			itm2.addActionListener(lstnr);
			return rtrnbl;
		}
		if(m==txtFtchr.gtTxt(25)){
			JMenuItem itm1=new JMenuItem(txtFtchr.gtTxt(41));
			JMenuItem itm2=new JMenuItem(txtFtchr.gtTxt(42));
			JMenuItem itm3=new JMenuItem(txtFtchr.gtTxt(43));
			rtrnbl.add(itm1);
			rtrnbl.add(itm2);
			rtrnbl.add(itm3);
			itm1.addActionListener(lstnr);
			itm2.addActionListener(lstnr);
			itm3.addActionListener(lstnr);
			return rtrnbl;
		}
		if(m==txtFtchr.gtTxt(27)){
			JMenuItem itm1=new JMenuItem(txtFtchr.gtTxt(44));
			JMenuItem itm2=new JMenuItem(txtFtchr.gtTxt(45));
			rtrnbl.add(itm1);
			rtrnbl.add(itm2);
			itm1.addActionListener(lstnr);
			itm2.addActionListener(lstnr);
			return rtrnbl;
		}
		if(m==txtFtchr.gtTxt(28)){
			JMenuItem itm1=new JMenuItem(txtFtchr.gtTxt(46));
			rtrnbl.add(itm1);
			itm1.addActionListener(lstnr);
			return rtrnbl;
		}
		if(m==txtFtchr.gtTxt(29)){
			JMenuItem itm1=new JMenuItem(txtFtchr.gtTxt(47));
			JMenuItem itm2=new JMenuItem(txtFtchr.gtTxt(48));
			rtrnbl.add(itm1);
			rtrnbl.add(itm2);
			itm1.addActionListener(lstnr);
			itm2.addActionListener(lstnr);
			return rtrnbl;
		}
		if(m==txtFtchr.gtTxt(30)){
			JMenuItem itm1=new JMenuItem(txtFtchr.gtTxt(30));
			rtrnbl.add(itm1);
			itm1.addActionListener(lstnr);
			return rtrnbl;
		}
		return rtrnbl;
	}
	/**
	 *	Returns the populated menu bar.
	 */
	public static JMenuBar gtMb(){
		return mb;
	}
}
