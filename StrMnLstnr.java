package JViNoM.Cntrllr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;

import JViNoM.Cntrllr.TxtFtchr;
import JViNoM.Vw.StrtMn;

/**
 *	Listener for the start menu page.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class StrMnLstnr implements MouseListener{
	private TxtFtchr txtFtchr=TxtFtchr.gtInstnc();
	private StrtMn srcF;
	private Desktop dsktp;
	public StrMnLstnr(StrtMn src){
		this.srcF=src;
		dsktp=Desktop.getDesktop();
	}
	public void mouseEntered(MouseEvent e){
		return ;
	}
	public void mouseExited(MouseEvent e){
		return ;
	}
	public void mousePressed(MouseEvent e){
		return ;
	}
	public void mouseReleased(MouseEvent e){
		return ;
	}
	@Override
	public void mouseClicked(MouseEvent e){
		JLabel src=(JLabel)e.getSource();
		if(src.getText().equals(txtFtchr.gtTxt(2))){
			srcF.crtNwPrjct();
		}
		if(src.getText().equals(txtFtchr.gtTxt(3))){
			srcF.opnFl();
		}
		if(src.getText().equals(txtFtchr.gtTxt(5))){
			srcF.crtNwPrjct();
		}
		if(src.getText().equals(txtFtchr.gtTxt(6))){
			try{
			dsktp.browse(new URI("https://yaircorrea.wixsite.com/jvinom"));}
			catch(URISyntaxException ex){
				System.out.println("I did a bad URL :(");
			}catch(IOException ex){
				System.out.println("Please check default browser configuration on your OS");
			}
		}
		if(src.getText().equals(txtFtchr.gtTxt(7))){
			try{
				dsktp.browse(new URI("https://yaircorrea.wixsite.com/jvinom/menu"));}
			catch(URISyntaxException ex){
				System.out.println("I did a bad URL :(");
			}catch(IOException ex){
				System.out.println("Please check default browser configuration on your OS");}
		}
		if(src.getText().equals(txtFtchr.gtTxt(8))){
			try{
				dsktp.browse(new URI("https://github.com/YairCorrea/JViNoM"));}
			catch(URISyntaxException ex){
				System.out.println("I did a bad URL :(");
			}catch(IOException ex){
				System.out.println("Please check default browser configuration on your OS");}
		}

	}
}
