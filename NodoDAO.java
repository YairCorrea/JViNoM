package JViNoM.Mdl.Dao;

import JViNoM.Mdl.Bns.*;
import JViNoM.Mdl.DAO;

import JViNoM.Mdl.FlWrtr;

import javax.swing.*;

import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *	Data Acess Object for nodes.
 *	@Author Yair Correa
 *	@Version 2211
 */

public class NodoDAO implements DAO<Nodo>{
	private ArrayList<Nodo> arryNodo;
	private int ownr;
	private String prjct;
	private FlWrtr<Nodo> rdr;
	public NodoDAO(int prjctID){
		ownr=prjctID;
		prjct=((new PrjctDAO()).gt(ownr)).gtLctn();
		rdr=new FlWrtr<Nodo>();
		arryNodo=rdr.rd(prjct+"Nodes");
		if(arryNodo.size()==0){
			Nodo nd=new Nodo();
			nd.stOptions(new JComponent[0]);
			nd.stElments(new JComponent[0]);
			nd.stSonsId(new int[0]);
			this.sv(nd);
		}
	}

	public Nodo gt(int id){
		return arryNodo.get(id);
	}
	public ArrayList<Nodo> gtAll(){
		return arryNodo;
	}
	public int sv(Nodo tSv){
		int tmStmp=arryNodo.size();
		tSv.stId(tmStmp);
		tSv.stPrjctId(ownr);
		arryNodo.add(tSv);
		rdr.sv(prjct+"Nodes",arryNodo);
		return tmStmp;
	}
	/**
	 *	Updates it the following way:
	 *	[sonsId:int[] , options: JComponent[],elements:JComponent[]]
	 */
	public void updt(int bngEdtd,Object[] prmtrs){
		Nodo nd=arryNodo.get(bngEdtd);
		nd.stSonsId((int[])prmtrs[0]);
		nd.stOptions((JComponent[])prmtrs[1]);
		nd.stElments((JComponent[])prmtrs[2]);
		arryNodo.set(bngEdtd,nd);
		rdr.sv(prjct+"Nodes",arryNodo);
	}
	public void dlt(int bngDltd){
		int tmp=arryNodo.size()-(1+bngDltd);
		arryNodo.remove(bngDltd);
		for(int i=0;i<tmp;i++){
			Nodo rnm=arryNodo.get(bngDltd+i);
			rnm.stId(bngDltd+i);
		}
		rdr.sv(prjct+"Nodes",arryNodo);
	}
	public void svCrrnt(ArrayList<Nodo> arry){
		this.arryNodo=arry;
		rdr.sv(prjct+"Nodes",arry);

	}
}
