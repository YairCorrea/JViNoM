package JViNoM.Mdl;
/**
 *	Bean for a layer..
 *	@Author Yair Correa
 *	@Version 2211
 */
public class Lyr{
	private String nm;
	private int id;
	private int scnId;
	private JComponent[] cmpnnts;
	
	public int gtId(){
		return id;
	}
	public void stId(int id){
		this.id=id;
	}
	public int gtScnId(){
		return scnId;
	}
	public void stScntId(int id){
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
