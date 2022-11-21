package JViNoM.Cntrllr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

import JViNoM.Cntrllr.TxtFtchr;
import JViNom.Vw.StrtMn;

/**
 *	Listener for the start menu page.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class StrMnLstnr implements ActionListener{
	private TxtFtchr txtFtchr=TxtFtchr.gtInstnc();
	private StrtMn src;
	private Desktop dsktp;
	public StrMnLstnr(StrtMn src){
		this.src=src;
		dsktp=Desktop.getDesktop();
	}
	@Override
	public void actionPerformed(ActionEvent e){
		JLabel src=(JLabel)e.getSource();
		if(src.getText().equals(txtFtchr.gtTxt(2))){
			src.crtNwPrjct();
		}
		if(src.getText().equals(txtFtchr.gtTxt(3))){
			src.opnFl();
		}
		if(src.getText().equals(txtFtchr.gtTxt(5))){
			src.crtNwPrjct();
		}
		if(src.getText().equals(txtFtchr.gtTxt(6))){
			dsktp.browse(new URI("https://yaircorrea.wixsite.com/jvinom"));
		}
		if(src.getText().equals(txtFtchr.gtTxt(7))){
			dsktp.browse(new URI("https://yaircorrea.wixsite.com/jvinom/menu"));
		}
		if(src.getText().equals(txtFtchr.gtTxt(8))){
			dsktp.browse(new URI("https://github.com/YairCorrea/JViNoM"));
		}

	}
}
