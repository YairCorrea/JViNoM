package JViNoM.Mdl;
/**
 *	Bean for a scene..
 *	@Author Yair Correa
 *	@Version 2211
 */
public class Scn{
	private String nm;
	private int id;
	private int prjctId;
	private int[] lyrs;
	
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
	public int[] gtLyrs(){
		return lyrs;
	}
	public void stLyrs(int[] lyrs){
		this.lyrs=lyrs;
	}
}
