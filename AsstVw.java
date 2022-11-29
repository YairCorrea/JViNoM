package JViNoM.Vw;

import java.awt.*;
import javax.swing.*;

import JViNoM.Cntrllr.*;

/**
 *	Allows to decorate a {@Wndw} with panels to populate her. This ones are not supposed to be independent frames, tough it can become one in execution
 *	time, by migrating to a {@IndWndw}.
 *
 *	@Author Yair Correa
 *	@Version 2211
 */
public abstract class AsstVw extends Dcrtr{
	private String ttl1;
	private GSttIntrfc crrntStts;

	public AsstVw(String ttl,Wndw prd){
		super(ttl,prd);
		this.ttl1=ttl;
	}	
	/**
	 *	Returns the view of this state/view.
	 *	Viewing elements go here.
	 *
	 *	@return JPanel The panel cointaining this status graphical components.
	 */
	public abstract JPanel obtnrCrtl();
	/**
	 *	Chance status of frame/panel, pass the status that you need it to move to.
	 *
	 *	@param GSttIntrfc The status to change to.
	 *	@return void
	 */
	public void stStt(GSttIntrfc nwStts){
		this.crrntStts=nwStts;
	}
	/**
	 *	Returns the current status of this frame.
	 *	@return GSttIntrfc Said status.
	 */
	public GSttIntrfc gtStt(){
		return crrntStts;
	}
	/**
	 * 	Returns this frame's title.
	 * 	@return String title.
	 */
	@Override
	public String gtTtl(){
		return super.gtTtl()+ttl1;
	}
}
