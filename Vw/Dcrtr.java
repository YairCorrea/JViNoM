package JViNoM.Vw;

import java.awt.*;
import javax.swing.*;

/**
 *	Allows to decorate a {@Wndw} with panels to populate her. This ones are not supposed to be independent frames, tough it can become one in execution
 *	time, by migrating to a {@IndWndw}.
 *
 *	@Author Yair Correa
 *	@Version 2211
 */
public abstract class Dcrtr implements Wndw{
	private Wndw pdr;
	private final String ttl;
	
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
	public abstract void stStt(GSttIntrfc nwStts);
	/**
	 *	Returns the current status of this frame.
	 *	@return GSttIntrfc Said status.
	 */
	public abstract GSttIntrfc gtStt();
	
	
	/**
	 *	Returns the {@Wndw} that its currently decorating.
	 *	@return Wndw Its parent.
	 */	
	public Wndw gtPdr(){
		return pdr;
	}
	/**
	 * 	Returns this frame's title.
	 * 	@return String title.
	 */
	public String gtTtl(){
		return ttl;
	}
}
