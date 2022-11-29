package JViNoM.Cntrllr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;

import JViNoM.Cntrllr.TxtFtchr;
import JViNoM.Vw.StrtMn;
import JViNoM.Mdl.Dao.*;
import JViNoM.Mdl.Bns.*;
import JViNoM.Mdl.Srvcs.*;
import JViNoM.Vw.*;

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
		PrjctSrvc prjctSrvc=new PrjctSrvc(new PrjctDAO());
		ArrayList<Prjct> prjcts=new ArrayList<Prjct>(prjctSrvc.gtAllPrjct());
		JPanel rcntPrjcts=new JPanel();
		BoxLayout lyt=new BoxLayout(rcntPrjcts,BoxLayout.Y_AXIS);
		rcntPrjcts.setLayout(lyt);

		Iterator<Prjct> prjctItrtr=new PrjctItrtr(prjcts);

		Prjct tmp;
		boolean hdSmntng=false;
		while(prjctItrtr.hasNext()){
			tmp=prjctItrtr.next();
			JLabel stmp=new JLabel(tmp.gtLctn());
			stmp.addMouseListener(this);
			rcntPrjcts.add(stmp);
			hdSmntng=true;
		}
		if(hdSmntng) srcF.ntRcnt=rcntPrjcts;
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
			return;
		}
		if(src.getText().equals(txtFtchr.gtTxt(3))){
			JFileChooser flChsr=new JFileChooser();
			JFrame flChsrFr=new JFrame();
			JPnlCrtl cntxt=srcF.gtCntxt();
			int i=flChsr.showOpenDialog(flChsrFr);
			if(i==JFileChooser.APPROVE_OPTION){
				File f=flChsr.getSelectedFile();
				String lctn=f.getPath();
				PrjctDAO prjctDAO=new PrjctDAO();
				int prjctId=prjctDAO.rdPrjct(lctn);
				PrjctScnsLst prjctLst=(PrjctScnsLst)cntxt.gtPrjctScnsLst();
				prjctLst.stPrjct(prjctId);
				cntxt.stStt(cntxt.gtPrjctScnsLst());
				cntxt.ntfy();
			}
			return;
		}
		if(src.getText().equals(txtFtchr.gtTxt(5))){
			srcF.crtNwPrjct();
			return;
		}
		if(src.getText().equals(txtFtchr.gtTxt(6))){
			try{
			dsktp.browse(new URI("https://yaircorrea.wixsite.com/jvinom"));}
			catch(URISyntaxException ex){
				System.out.println("I did a bad URL :(");
			}catch(IOException ex){
				System.out.println("Please check default browser configuration on your OS");
			}
			return;
		}
		if(src.getText().equals(txtFtchr.gtTxt(7))){
			try{
				dsktp.browse(new URI("https://yaircorrea.wixsite.com/jvinom/manual"));}
			catch(URISyntaxException ex){
				System.out.println("I did a bad URL :(");
			}catch(IOException ex){
				System.out.println("Please check default browser configuration on your OS");}
			return;
		}
		if(src.getText().equals(txtFtchr.gtTxt(8))){
			try{
				dsktp.browse(new URI("https://github.com/YairCorrea/JViNoM"));}
			catch(URISyntaxException ex){
				System.out.println("I did a bad URL :(");
			}catch(IOException ex){
				System.out.println("Please check default browser configuration on your OS");}
			return;
		}

		//If nothing seems to catch, then its a dynamic project.
		
		JPnlCrtl cntxt=srcF.gtCntxt();

		PrjctDAO prjctDAO=new PrjctDAO();
		int prjctId=prjctDAO.rdPrjct(src.getText());
		PrjctScnsLst prjctLst=(PrjctScnsLst)cntxt.gtPrjctScnsLst();
		prjctLst.stPrjct(prjctId);
		cntxt.stStt(cntxt.gtPrjctScnsLst());
		cntxt.ntfy();
	}
}
