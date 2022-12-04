package JViNoM.Mdl.Bns;

import javax.swing.*;
import java.io.Serializable;
/**
 *	Bean for a tree node.
 *	@Author Yair Correa
 *	@Version 2211
 */
public class Nodo implements Serializable{
	private int id;
	private int[] sonsId;
	private JComponent[] options;
	private JComponent[] elements;
	private int prjctId;

	public int gtId(){
		return id;
	}
	public int[] gtSonsId(){
		return sonsId;
	}
	public JComponent[] gtOptions(){
		return options;
	}
	public JComponent[] gtElements(){
		return elements;
	}
	public int gtPrjctId(){
		return prjctId;
	}

	public void stPrjctId(int id){
		this.prjctId=id;
	}
	public void stId(int id){
		this.id=id;
	}
	public void stSonsId(int[] id){
		this.sonsId=id;
	}
	public void stOptions(JComponent[] id){
		this.options=id;
	}
	public void stElments(JComponent[] id){
		this.elements=id;
	}
}
