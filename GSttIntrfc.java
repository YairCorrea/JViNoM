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
	protected JPnlCrtl cntxt;
	protected int wdth,hght;
	public GSttIntrfc(JPnlCrtl cntx,int w,int h){
		this.cntxt=cntx;
		this.wdth=w;
		this.hght=h;

	}
	public abstract void crtNwPrjct();
	public abstract void crtNwScn();
	public abstract void opnFl();
	public abstract void cncl();
	public abstract JPanel gtVw(int wdth,int hght);
	public JPnlCrtl gtCntxt(){
		return cntxt;
	}
}
