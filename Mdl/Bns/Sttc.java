package JViNoM.Mdl.Bns;
/**
 *	Bean for a static, like images and the like.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class Sttc{
	private String flNm;
	private int id;
	private String lctn;

	public int gtId(){
		return id;
	}
	public void stId(int id){
		this.id=id;
	}
	public String gtFlNm(){
		return flNM;
	}
	public void stFlNm(String flNM){
		this.flNM=flNM;
	}
	public String gtLctn(){
		return lctn;
	}
	public void stLctn(String lyrs){
		this.lctn=lyrs;
	}
}
