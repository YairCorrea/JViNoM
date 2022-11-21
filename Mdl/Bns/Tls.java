package JViNoM.Mdl.Bns;
/**
 *	Bean for tools.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class Tls{
	private int id;
	private String tlCd;
	private String tlNm;
	private String imgIcnTl;

	public int gtId(){
		return id;
	}
	public void stId(int id){
		this.id=id;
	}
	public String gtTlCd(){
		return tlCd;
	}
	public void stTlCd(String tlCd){
		this.tlCd=tlCd;
	}
	public String gtTlNm(){
		return tlNm;
	}
	public void stTlNm(String id){
		this.tlNm=id;
	}
	public String gtImgIcnTl(){
		return imgIcnTl;
	}
	public void stImgIcnTl(String id){
		this.imgIcnTl=id;
	}
}
