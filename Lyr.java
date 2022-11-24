package JViNoM.Mdl.Bns;

import javax.swing.JComponent;
import java.io.Serializable;
/**
 *	Bean for a layer..
 *	@Author Yair Correa
 *	@Version 2211
 */
public class Lyr implements Serializable{
	private String nm;
	private int id;
	private int scnId;
	private JComponent[] cmpnnts;
	private int ordr;

	public int gtId(){
		return id;
	}
	public void stId(int id){
		this.id=id;
	}
	public int gtOrdr(){
		return ordr;
	}
	public void stOrdr(int id){
		this.ordr=id;
	}
	public int gtScnId(){
		return scnId;
	}
	public void stScnId(int id){
		this.scnId=id;
	}
	public String gtNm(){
		return nm;
	}
	public void stNm(String nm){
		this.nm=nm;
	}
	public JComponent[] gtCmpnnts(){
		return cmpnnts;
	}
	public void stCmpnnts(JComponent[] lyrs){
		this.cmpnnts=lyrs;
	}
}
