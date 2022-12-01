package JViNoM.Cntrllr;

import JViNoM.Mdl.Bns.*;
import JViNoM.Mdl.Dao.*;
import JViNoM.Mdl.Srvcs.*;

public class LclsItrtr implements Iterator<Lcls>{
	private Lcls[] lcls;
	private int i;
	public LclsItrtr(){
		LclsSrvc lclsSrvc=new LclsSrvc(new LclsDAO());
		lcls=lclsSrvc.gtAllLcls().toArray(new Lcls[0]);
		i=0;
	}
	public Lcls next(){
		Lcls tmp=lcls[i];
		i++;
		return tmp;
	}
	public boolean hasNext(){
		return (i<lcls.length);
	}
}
