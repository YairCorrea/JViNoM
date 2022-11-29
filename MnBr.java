package JViNoM.Vw;

import java.awt.*;
import javax.swing.*;

import JViNoM.Cntrllr.*;
/**
 *	Top menu for a window.	
 */
public class MnBr{
	private static JMenuBar mb;
	private TxtFtchr txtFtchr=TxtFtchr.gtInstnc();
	private JMenu fl,edt,img,lyr,slct,scrpts,sttngs,wndw,hlp;
	public MnBr(){
		mb=new JMenuBar();

		fl=new JMenu(txtFtchr.gtTxt(22));
		edt=new JMenu(txtFtchr.gtTxt(23));
		img=new JMenu(txtFtchr.gtTxt(24));
		lyr=new JMenu(txtFtchr.gtTxt(25));
		slct=new JMenu(txtFtchr.gtTxt(26));
		scrpts=new JMenu(txtFtchr.gtTxt(27));
		sttngs=new JMenu(txtFtchr.gtTxt(28));
		wndw=new JMenu(txtFtchr.gtTxt(29));
		hlp=new JMenu(txtFtchr.gtTxt(30));

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

	public static JMenuBar gtMb(){
		return mb;
	}
}
