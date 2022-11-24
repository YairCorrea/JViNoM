package JViNoM.Mdl;

import JViNoM.Mdl.Bns.*;

import java.io.*;

import java.util.ArrayList;
/**
 * A class with very simple filewriting capacities. Used as a dumb stance on the persitance layer.
 * @Author Yair Correa
 * @Version 2211
 */
public class FlWrtr<T>{

	public ArrayList<T> rd(String lctn){
		ArrayList<T> rtrnbl=new ArrayList<T>();
		try{
			FileInputStream flIn=new FileInputStream(lctn);
			ObjectInputStream in=new ObjectInputStream(flIn);
			rtrnbl=(ArrayList<T>)in.readObject();
			in.close();
			flIn.close();
		}catch(IOException i){
			i.printStackTrace();
			return rtrnbl;
		}catch(Exception ex){
			ex.printStackTrace();
			return rtrnbl;
		}
		return rtrnbl;
		
	}
	public void sv(String lctn, ArrayList<T> tWrt){
		try{
			FileOutputStream flOt=new FileOutputStream(lctn);
			ObjectOutputStream ot=new ObjectOutputStream(flOt);
			ot.writeObject(tWrt);
			ot.close();
			flOt.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}finally{
			System.out.println(lctn+ " file saved");
		}
	}
	public void svPrjct(String lctn,Prjct tWrt){
		try{
			FileOutputStream flOt=new FileOutputStream(lctn);
			ObjectOutputStream ot=new ObjectOutputStream(flOt);
			ot.writeObject(tWrt);
			ot.close();
			flOt.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}finally{
			System.out.println(lctn+ " file saved");
		}
	}
	public Prjct rdPrjct(String lctn){
	       	Prjct rtrnbl=new Prjct();
		try{
			FileInputStream flIn=new FileInputStream(lctn);
			ObjectInputStream in=new ObjectInputStream(flIn);
			rtrnbl=(Prjct)in.readObject();
			in.close();
			flIn.close();
		}catch(IOException i){
			i.printStackTrace();
			return rtrnbl;
		}catch(Exception ex){
			ex.printStackTrace();
			return rtrnbl;
		}
		return rtrnbl;

	}
	public void dltPrjct(String lctn){
		File prjct=new File(lctn);
		prjct.delete();
	}
}
