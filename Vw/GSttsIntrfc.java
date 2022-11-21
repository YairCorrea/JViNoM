package JViNoM.Vw;

import java.awt.*;
import javax.swing.*;
/**
 * 	Main view switching.
 *
 * 	@Author Yair Correa
 * 	@Version 2211
 */
public abstract class GSttIntrfc{
	private JPnlCrtl cntxt;

	public void crtNwPrjct();
	public void crtNwScn();
	public void opnFl();
	public void cncl();

	public JPnlCrtl gtCntxt(){
		return cntxt;
	}
}
