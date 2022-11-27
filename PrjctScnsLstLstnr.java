package JViNoM.Cntrllr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import JViNoM.Vw.*;
import JViNoM.Cntrllr.TxtFtchr;

/**
 *	Listener for the scenes project page.
 *
 *	@Author Yair Correa
 *	@Version 2211
 */

public class PrjctScnsLstLstnr implements MouseListener{
	private TxtFtchr txtFtchr=TxtFtchr.gtInstnc();
	private PrjctScnsLst srcF;

	public PrjctScnsLstLstnr(PrjctScnsLst src){
		this.srcF=src;
	}
	public void mouseEntered(MouseEvent e){
		return;
	}
	public void mouseExited(MouseEvent e){
		return;
	}
	public void mousePressed(MouseEvent e){
		return;
	}
	public void mouseReleased(MouseEvent e){
		return;
	}
	public void mouseClicked(MouseEvent e){
		try{
			JLabel src=(JLabel)e.getSource();
			if(src.getText().equals(txtFtchr.gtTxt(17))){
				srcF.crtNwScn();
			}
			if(src.getText().equals(txtFtchr.gtTxt(18))){
				srcF.crtNwScn();
			}
		}catch(Exception ex){
			srcF.cncl();
		}
	}
}
