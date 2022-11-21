package JViNoM.Mdl.Bns;

import java.io.Serializable;
/**
 *	Bean for project.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class Prjct implements Serializable{
	private String lctn;
	private int id;
	private String nm;
	private int[] aspctRltn;
	private Scn[] scns;
	private Sttc[] sttcs;
	
	public Sttc[] gtSttcs(){
		return sttcs;
	}

	public void stSttcs(Sttc[] sttcs){
		this.sttcs=sttcs;
	}

	public Scn[] gtScns(){
		return scns;
	}

	public void stScns(Scn[] scns){
		this.scns=scns;
	}

	public int gtId(){
		return id;
	}
	public void stId(int id){
		this.id=id;
	}
	public String gtLctn(){
		return lctn;
	}
	public void stLctn(String lctn){
		this.lctn=lctn;
	}
	public String gtNm(){
		return nm;
	}
	public void stNm(String nm){
		this.nm=nm;
	}
	public int[] gtAspctRltn(){
		return aspctRltn;
	}
	public void stAspctRltn(int[] aspctRltn){
		this.aspctRltn=aspctRltn;
	}
}
