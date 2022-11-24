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
	private GSttIntrfc actl;
	
	private final GSttIntrfc trEdtr;
	private final GSttIntrfc strtMn;
	private final GSttIntrfc crtNwScn;
	private final GSttIntrfc crtNwPrjct;
	private final GSttIntrfc edtr;
	private final GSttIntrfc prjctScnsLst;

	private int wdth,hght;
	public JPnlCrtl(String ttl,int wdth,int hght, Wndw pdr){
		super(ttl,pdr);
		trEdtr=new TrEdtr();
		strtMn=new StrtMn();
		crtNwScn=new CrtNwScn();
		crtNwPrjct=new CrtNwPrjct();
		edtr=new Edtr();
		prjctScnsLst=new PrjctScnsLst();
		this.wdth=width;
		this.hght=hght;
		actl=strtMn;
	}
	/**
	 *	Returns the view of this state/view.
	 *	Viewing elements go here.
	 *
	 *	@return JPanel The panel cointaining this status graphical components.
	 */
	public JPanel obtnrCrtl(){
		return actl.gtVw(wdth,hght);
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
	/**
	 *	Getters and setters for states.
	 */
	public GSttIntrfc gtTrEdtr(){
		return trEdtr;
	}
	public GSttIntrfc gtStrtMn(){
		return strtMn;
	}
	public GSttIntrfc gtCrtNwScn(){
		return crtNwScn;
	}
	public GSttIntrfc gtCrtNwPrjct(){
		return crtNwPrjct;
	}
	public GSttIntrfc gtEdtr(){
		return edtr;
	}
	public GSttIntrfc gtPrjctScnsLst(){
		return prjctScnsLst;
	}
}
