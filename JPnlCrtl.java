package JViNoM.Vw;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
/**
 *	Base for regular panels.
 *
 *	@Author Yair Correa
 *	@Version 2211
 */
public class JPnlCrtl extends Dcrtr implements Sbjct{
	private GSttIntrfc actl;

	private ArrayList<Obsrvr> lstObsrvrs;

	private final GSttIntrfc trEdtr;
	private final GSttIntrfc strtMn;
	private final GSttIntrfc crtNwScn;
	private final GSttIntrfc crtNwPrjct;
	private final GSttIntrfc edtr;
	private final GSttIntrfc prjctScnsLst;

	private int wdth,hght;
	public JPnlCrtl(String ttl,int wdth,int hght, Wndw pdr){
		super(ttl,pdr);
		lstObsrvrs=new ArrayList<Obsrvr>();
		trEdtr=new TrEdtr(this,wdth,hght);
		strtMn=new StrtMn(this,wdth,hght);
		crtNwScn=new CrtNwScn(this,wdth,hght);
		crtNwPrjct=new CrtNwPrjct(this,wdth,hght);
		edtr=new Edtr(this,wdth,hght);
		prjctScnsLst=new PrjctScnsLst(this,wdth,hght);
		this.wdth=wdth;
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
	public void ntfy(){
		for(Obsrvr obs: lstObsrvrs){
			obs.updt(this.obtnrCrtl());
		}
	}
	public void attch(Obsrvr obs){
		lstObsrvrs.add(obs);
	}
	/**
	 *	Chance status of frame/panel, pass the status that you need it to move to.
	 *
	 *	@param GSttIntrfc The status to change to.
	 *	@return void
	 */
	public void stStt(GSttIntrfc nwStts){
		this.actl=nwStts;
		ntfy();
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
