package JViNoM.Cntrllr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import JViNoM.Cntrllr.TxtFtchr;
import JViNoM.Vw.*;
import JViNoM.Mdl.DAO;
import JViNoM.Mdl.Dao.*;
import JViNoM.Mdl.Bns.*;
import JViNoM.Mdl.Srvcs.*;

/**
 *	Listener for the new scene pop-up.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class CrtNwScnLstnr implements ActionListener{
	private TxtFtchr txtFtchr=TxtFtchr.gtInstnc();
	private CrtNwScn srcF;
	public CrtNwScnLstnr(CrtNwScn src){
		this.srcF=src;
	}
	public void actionPerformed(ActionEvent e){
		
		JButton src=(JButton)e.getSource();

		if(src.getText().equals(txtFtchr.gtTxt(13))){
			JPnlCrtl cntxt=srcF.gtCntxt();

			String nmt=srcF.nmT.getText();

			cntxt.stStt(cntxt.gtEdtr());
			srcF.crtNwScn();
			cntxt.ntfy();
			return;
		}
		if(src.getText().equals(txtFtchr.gtTxt(14))){
			//Cancel. Just hides the frame.
			srcF.cncl();
			return;
		}
	}
}
