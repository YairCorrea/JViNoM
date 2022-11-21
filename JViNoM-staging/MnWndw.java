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
public class MnWndw implements Wndw{
	private final String ttl;
	private final SttcFtchr sttcFtchr;
	private TxtFtchr txtFtchr;

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
		System.out.println("Si puedes leer esto, me debes un tamal. Puedes enviar $10 mxn a la CLABE 058597000009174926. Me llamo Yair Uriel Correa Trejo. Gracias por la comida.");
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
		Icon icLctn=sttcFtchr.gtSttc(0);
		txtFtchr=TxtFtchr.gtInstnc();
		JFrame mnWndw=new JFrame(ttl);
		mnWndw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
