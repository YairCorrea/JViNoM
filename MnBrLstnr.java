package JViNoM.Cntrllr;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;
import java.io.*;

import java.util.ArrayList;

import JViNoM.Vw.*;
import JViNoM.Mdl.Bns.*;
import JViNoM.Mdl.Srvcs.*;
import JViNoM.Mdl.Dao.*;

/**
 *	Listener for the main menu and general program.
 *
 *	@Author Yair Correa
 *	@Version 2211
 */
public class MnBrLstnr implements ActionListener{
	private MnBr srcF;
	private Desktop dsktp;
	private TxtFtchr txtFtchr=TxtFtchr.gtInstnc();

	public MnBrLstnr(MnBr srcF){
		this.srcF=srcF;
		dsktp=Desktop.getDesktop();
	}
	public void actionPerformed(ActionEvent src){
		JMenuItem sr=(JMenuItem)src.getSource();
		GSttIntrfc cntxt=srcF.gtStt();
		String tmp=sr.getText();
			if(tmp==txtFtchr.gtTxt(35)){
				//Create new project.
				cntxt.crtNwPrjct();
				return;}
			if(tmp==txtFtchr.gtTxt(3)){
				//Open project
				cntxt.opnFl();
				return;}
			if(tmp==txtFtchr.gtTxt(36)){
				//Saves current project
				return;}
			if(tmp==txtFtchr.gtTxt(37)){
				//Saves current project at specified location
				return;}
			if(tmp==txtFtchr.gtTxt(18)){
				//Creates new scene
				cntxt.crtNwScn();
				return;}
			if(tmp==txtFtchr.gtTxt(38)){
				//Opens specified scene.

				return;}
			//Edit stuff
			if(tmp==txtFtchr.gtTxt(49)){
				//Import image
				GSttIntrfc crrnt=srcF.gtStt();
				if(crrnt.getClass()==Edtr.class){
					JFileChooser flChsr=new JFileChooser();
					JFrame flChsrFr=new JFrame();
					int i=flChsr.showOpenDialog(flChsrFr);
					String lctn="";
					if(i==JFileChooser.APPROVE_OPTION){
						File f=flChsr.getSelectedFile();
						lctn=f.getPath();
					}
					ImageIcon imgs=new ImageIcon(lctn);
					int lyr=((Edtr)crrnt).gtCrrntLyr();
					JComponent[] oldLyr=((Edtr)crrnt).gtLyrs().get(lyr);
					JComponent[] nwLyr=new JComponent[oldLyr.length+1];
					for(int j=0;i<oldLyr.length;i++){
						nwLyr[i]=oldLyr[i];
					}
					JLabel tmp2=new JLabel(imgs);
					nwLyr[oldLyr.length]=tmp2;
					((Edtr)crrnt).stLyr(lyr,nwLyr);
				}
				return;
			}
			//Image stuff
			if(tmp==txtFtchr.gtTxt(39)){
				//Mirror horizontally
				return;}
			if(tmp==txtFtchr.gtTxt(40)){
				//Mirror vertically
				return;}

			//Layer stuff
			if(tmp==txtFtchr.gtTxt(41)){
				//Cut layer
				return;}
			if(tmp==txtFtchr.gtTxt(42)){
				//Copy layer
				return;}
			if(tmp==txtFtchr.gtTxt(43)){
				//New layer
				return;}
			
			//Scripts stuff
			if(tmp==txtFtchr.gtTxt(44)){
				//Create script
				return;}
			if(tmp==txtFtchr.gtTxt(45)){
				//Open script
				return;}

			//Configurations stuff
			if(tmp==txtFtchr.gtTxt(46)){
				//Language stuff
				JFrame idms=new JFrame(txtFtchr.gtTxt(46));
				idms.setSize(200,300);
				JPanel cntnr=new JPanel();
				BoxLayout lyt=new BoxLayout(cntnr,BoxLayout.Y_AXIS);
				cntnr.setLayout(lyt);
				LclsItrtr it=new LclsItrtr();
				ArrayList<Lcls> m=new ArrayList<Lcls>();
				while(it.hasNext()) m.add(it.next());
				JList<Lcls> lst=new JList<Lcls>(m.toArray(new Lcls[0]));

				lst.addListSelectionListener(new ListSelectionListener(){
					public void valueChanged(ListSelectionEvent e){
						String nwLcl=lst.getSelectedValue().toString();
						CnfgsDAO cnfgsDAO=new CnfgsDAO();
						Object[] f=new Object[1];
						f[0]=nwLcl;
						cnfgsDAO.updt(0,f);
					}
				});
				cntnr.add(lst);
				idms.setContentPane(cntnr);
				idms.setVisible(true);
				return;}

			//Window stuff
			if(tmp==txtFtchr.gtTxt(47)){
				//New window
				return;}
			if(tmp==txtFtchr.gtTxt(48)){
				//New view
				return;}
			
			//Help stuff. Windows style {P
			if(tmp==txtFtchr.gtTxt(30)){
				try{
					dsktp.browse(new URI("https://yaircorrea.wixsite.com/jvinom/manual"));
				}
				catch(URISyntaxException ex){
					System.out.println("I did a bad URL :(");
				}
				catch(IOException ex){
					System.out.println("Please check default browser configuration on your OS");
				}
				return;}
	}
}
