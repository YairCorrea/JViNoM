package JViNoM.Mdl.Bns;

import java.io.Serializable;
/**
 *	Bean for a scene..
 *	@Author Yair Correa
 *	@Version 2211
 */
public class Scn implements Serializable{
	private String nm;
	private int id;
	private int prjctId;
	private Lyr[] lyrs;
	
	public int gtId(){
		return id;
	}
	public void stId(int id){
		this.id=id;
	}
	public int gtPrjctId(){
		return prjctId;
	}
	public void stPrjctId(int id){
		this.prjctId=id;
	}
	public String gtNm(){
		return nm;
	}
	public void stNm(String nm){
		this.nm=nm;
	}
	public Lyr[] gtLyrs(){
		return lyrs;
	}
	public void stLyrs(Lyr[] lyrs){
		this.lyrs=lyrs;
	}
}
