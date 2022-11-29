package JViNoM.Vw;

import java.awt.*;
import javax.swing.*;

import JViNoM.Cntrllr.*;
/**
 *	A distinguished type of frame, because it's the first one it launches when you launch the app.
 *
 *	Still, is otherwise a regular frame of the interface Wndw.
 *
 *	@Author Yair Correa
 *	@Version 2211
 */
public class MnWndw implements Wndw,Obsrvr{
	private final String ttl;
	private final SttcFtchr sttcFtchr;
	private TxtFtchr txtFtchr;
	private JFrame mnWndw;
	private JPnlCrtl main;
	private int wdth,hght;
	/**
	 *	Returns the view of this state/view.
	 *	Viewing elements go here.
	 *
	 *	@return JPanel The panel cointaining this status graphical components.
	 */
	public JPanel obtnrCrtl(){
		return null;
	}
	/**
	 *	Chance status of frame/panel, pass the status that you need it to move to.
	 *
	 *	@param GSttIntrfc The status to change to.
	 *	@return void
	 */
	public void stStt(GSttIntrfc stts){
	}
	/**
	 *	Returns the current status of this frame.
	 *	@return GSttIntrfc Said status.
	 */
	public GSttIntrfc gtStt(){
		return null;
	}

	public void updt(JPanel cntr){	
		JPanel lyrLstVw=(new LyrLstVw(ttl,main)).obtnrCrtl();
		JPanel snglAsstVw=(new SnglAsstVw(ttl,main)).obtnrCrtl();
		cntr.add(lyrLstVw);
		cntr.add(snglAsstVw);
		
		SpringLayout lyt=(SpringLayout)cntr.getLayout();

		lyt.putConstraint(SpringLayout.EAST,lyrLstVw,6,SpringLayout.EAST,cntr);
		lyt.putConstraint(SpringLayout.NORTH,snglAsstVw,6,SpringLayout.SOUTH,lyrLstVw);
		lyt.putConstraint(SpringLayout.EAST,snglAsstVw,6,SpringLayout.EAST,cntr);

		cntr.setLayout(lyt);
		
		mnWndw.setContentPane(cntr);
		mnWndw.repaint();
	}
	/**
	 * 	Returns this frame's title.
	 * 	@return String title.
	 */
	public String gtTtl(){
		return ttl;
	}
	/**
	 * 	Main :v
	 */
	public static void main(String[] args){
		System.out.println("JViNoM mk.2211");
		MnWndw mnWndw=new MnWndw();
	}

	/**
	 *	Constructor of main frame. It gets the screen's dimensions and creates an according frame. Plus, ignites the whole system.
	 */
	public MnWndw(){
		ttl= "JVisualNovelMaker (JViNom)";
		Dimension scrnSz=Toolkit.getDefaultToolkit().getScreenSize();

		wdth= (int) scrnSz.getWidth();
		hght= (int) scrnSz.getHeight();

		sttcFtchr=new SttcFtchr();	
		Image icLctn=((ImageIcon)sttcFtchr.gtSttc(0)).getImage();
		txtFtchr=TxtFtchr.gtInstnc();
		mnWndw=new JFrame(ttl);
		mnWndw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mnWndw.setSize(wdth,hght);
		mnWndw.setIconImage(icLctn);
		
		MnBr mnBr=new MnBr();

		mnWndw.setJMenuBar(mnBr.gtMb());
			
		main=new JPnlCrtl(ttl,wdth,hght,this);
		main.attch(this);

		JPanel cntr=main.obtnrCrtl();

		JPanel lyrLstVw=(new LyrLstVw(ttl,main)).obtnrCrtl();
		JPanel snglAsstVw=(new SnglAsstVw(ttl,main)).obtnrCrtl();
		cntr.add(lyrLstVw);
		cntr.add(snglAsstVw);
		
		SpringLayout lyt=(SpringLayout)cntr.getLayout();

		lyt.putConstraint(SpringLayout.EAST,lyrLstVw,6,SpringLayout.EAST,cntr);
		lyt.putConstraint(SpringLayout.NORTH,snglAsstVw,6,SpringLayout.SOUTH,lyrLstVw);
		lyt.putConstraint(SpringLayout.EAST,snglAsstVw,6,SpringLayout.EAST,cntr);

		cntr.setLayout(lyt);
		
		mnWndw.setContentPane(cntr);
		
		mnWndw.setVisible(true);
	}
}
