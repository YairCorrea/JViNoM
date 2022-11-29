package JViNoM.Cntrllr;

import java.util.ArrayList;

import JViNoM.Mdl.Bns.*;
import JViNoM.Mdl.Srvcs.*;
import JViNoM.Mdl.Dao.*;

public class ScnItrtr implements Iterator<Scn>{
	private ArrayList<Scn> lst;
	private int i;
	public ScnItrtr(ArrayList<Scn> lst){
		this.lst=lst;
		i=0;
	}
	public Scn next(){
		Scn n=lst.get(i);
		i++;
		return n;
	}
	public boolean hasNext(){
		return (i<lst.size());
	}
}
