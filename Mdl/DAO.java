package JViNoM.Mdl;

public interface DAO<T>{
	public T gt(int id);
	public ArrayList<T> gtAll();
	public void sv(T tSv);
	public void updt(T bngEdtd, String[] prmtrs);
	public void dlt(T bngDltd);
}
