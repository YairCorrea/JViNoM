package JViNoM.Mdl;
/**
 *	Bean for project.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class Prjct{
	private String lctn;
	private int id;
	private String nm;
	private int[] aspctRltn;

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
		return lctn;
	}
	public void stLctn(int[] aspctRltn){
		this.aspctRltn=aspctRltn;
	}
}
