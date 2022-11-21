package JViNoM.Vw;

import java.awt.*;
import javax.swing.*;

/**
 *	Base for regular panels.
 *
 *	@Author Yair Correa
 *	@Version 2211
 */
public class JPnlCrtl extends Dcrtr{
	private JPanel thsPnl;
	private GSttsIntrfc actl;
	
	private final GSttsIntrfc trEdtr;
	private final GSttsIntrfc strtMn;
	private final GSttsIntrfc crtNwScn;
	private final GSttsIntrfc crtNwPrjct;
	private final GSttsIntrfc edtr;
	private final GSttsIntrfc prjctScnsLst;
	private final GSttsIntrfc txEdtr;

	/**
	 *	Returns the view of this state/view.
	 *	Viewing elements go here.
	 *
	 *	@return JPanel The panel cointaining this status graphical components.
	 */
	public JPanel obtnrCrtl(){
		JPanel rtrnbl=new JPanel();
		return rtrnbl;
	}
	/**
	 *	Chance status of frame/panel, pass the status that you need it to move to.
	 *
	 *	@param GSttIntrfc The status to change to.
	 *	@return void
	 */
	public void stStt(GSttIntrfc nwStts){
		actl=nwStts;
	}
	/**
	 *	Returns the current status of this frame.
	 *	@return GSttIntrfc Said status.
	 */
	public GSttIntrfc gtStt(){
		return actl;
	}
}
