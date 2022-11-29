package JViNoM.Cntrllr;

import java.util.ArrayList;

import JViNoM.Mdl.Bns.*;
import JViNoM.Mdl.Srvcs.*;
import JViNoM.Mdl.Dao.*;

public class PrjctItrtr implements Iterator<Prjct>{
	private ArrayList<Prjct> lst;
	private int i;
	public PrjctItrtr(ArrayList<Prjct> lst){
		this.lst=lst;
		i=0;
	}
	public Prjct next(){
		Prjct n=lst.get(i);
		i++;
		return n;
	}
	public boolean hasNext(){
		return (i<lst.size());
	}
}
