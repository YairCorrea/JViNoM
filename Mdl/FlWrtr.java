package JViNoM.Mdl;

import JViNoM.Mdl.Bns.*;

import java.io.*;

import java.util.ArrayList;
public class FlWrtr{
	public ArrayList<T> rd(String lctn){
		ArrayList<T> rtrnbl=new ArrayList<T>();
		try{
			FileInputStream flIn=new FileInputStream(lctn);
			ObjectInputStream in=new ObjectInputStream(flIn);
			rtrnbl=in.readObject();
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
			FileOutputStrean flOt=new FileOutputStream(lctn);
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
			FileOutputStrean flOt=new FileOutputStream(lctn);
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
}
