package JViNoM.Mdl.Bns;

import java.io.Serializable;
/**
 *	Bean for locales.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class Lcls implements Serializable{
	private String[] txts;
	private String lclNm;
	private int id;

	public int gtId(){
		return id;
	}
	public void stId(int id){
		this.id=id;
	}
	public String[] gtTxt(){
		return txts;
	}
	public void stTxt(String[] txts){
		this.txts=txts;
	}
	public String gtLclNm(){
		return lclNm;
	}
	public void stLclNm(String lclNm){
		this.lclNm=lclNm;
	}
	@Override
	public String toString(){
		return lclNm;
	}
}
