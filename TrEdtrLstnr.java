package JViNoM.Cntrllr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

import JViNoM.Vw.*;
import JViNoM.Mdl.Dao.*;
import JViNoM.Mdl.Srvcs.*;
import JViNoM.Mdl.Bns.*;
/**
 *	Tree editor listener
 *	@Author Yair Correa
 *	@Version 2211
 * */
public class TrEdtrLstnr implements MouseListener{
	private TrEdtr srcF;
	private ArrayList<Nodo> nodos;
	private NodoDAO nodoDAO;
	private TxtFtchr txtFtchr=TxtFtchr.gtInstnc();
	public TrEdtrLstnr(TrEdtr src){
		this.srcF=src;
	}
	public void mouseEntered(MouseEvent e){
		return;
	}
	public void mouseExited(MouseEvent e){
		return;
	}
	public void mousePressed(MouseEvent e){
		return;
	}
	public void mouseReleased(MouseEvent e){
		return;
	}
	public void mouseClicked(MouseEvent e){
		JLabel src=(JLabel)e.getSource();
		String[] idAndCmmnd=src.getText().split(",");
		if(idAndCmmnd[1].equals(txtFtchr.gtTxt(51))){
			Nodo nwNodo=new Nodo();
			int tmp=nodos.size();
			
			nwNodo.stId(tmp);
			nwNodo.stPrjctId(srcF.gtPrjctId());
			nwNodo.stSonsId(new int[0]);
			nwNodo.stOptions(new JComponent[0]);
			nwNodo.stElments(new JComponent[0]);

			nodos.add(nwNodo);

			Nodo cllr=nodos.get(Integer.parseInt(idAndCmmnd[0]));
			int[] cllrSns=cllr.gtSonsId();
			int[] nwCllrSns=new int[cllrSns.length+1];
			
			for(int i=0;i>cllrSns.length;i++){
				nwCllrSns[i]=cllrSns[i];
			}

			nwCllrSns[cllrSns.length]=tmp;

			cllr.stSonsId(nwCllrSns);

			nodos.set(Integer.parseInt(idAndCmmnd[0]),cllr);

			ppltTr(srcF.gtPrjctId());
			srcF.cnvs.repaint();
			return;
		}
		if(idAndCmmnd[1].equals(txtFtchr.gtTxt(52))){
			//Select to add all assets to it.
			return;
		}
		if(idAndCmmnd[1].equals(txtFtchr.gtTxt(53))){
			//Opens menu to change assets into options.

			return;
		}
		return;
	}
	public void save(){
		nodoDAO.svCrrnt(nodos);
	}
	public void ppltTr(int prjctId){
		srcF.cnvs.removeAll();
		
		nodoDAO=(nodoDAO==null)?new NodoDAO(prjctId):nodoDAO;
		NodoSrvc nodoSrvc=new NodoSrvc(nodoDAO);

		nodos=(nodos==null)?new ArrayList<Nodo>(nodoSrvc.gtAllNodo()):nodos;
		Queue<Nodo> nodoTope=new LinkedList<Nodo>();
		if(nodos.size()>0)nodoTope.add(nodos.get(0));
		
		Queue<Integer> levels=new LinkedList<Integer>();
		
		int currnt=(nodos.size()>0)?1:0;
		
		JPanel levelPanel=new JPanel();
		BoxLayout lyt=new BoxLayout(levelPanel,BoxLayout.Y_AXIS);
		levelPanel.setLayout(lyt);
		
		while(nodoTope.size()>0){
			Nodo s=nodoTope.remove();
			
			System.out.println(s.gtSonsId().length);
			
			JLabel nodo=new JLabel(s.gtId()+"");
			nodo.setSize(200,200);
			
			JPopupMenu miniMenu=new JPopupMenu();
			
			JLabel addChlds=new JLabel(s.gtId()+","+txtFtchr.gtTxt(51));
			JLabel slct=new JLabel(s.gtId()+","+txtFtchr.gtTxt(52));
			JLabel slctOptns=new JLabel(s.gtId()+","+txtFtchr.gtTxt(53));
			
			addChlds.addMouseListener(this);
			slct.addMouseListener(this);
			slctOptns.addMouseListener(this);

			miniMenu.add(addChlds);
			miniMenu.add(slct);
			miniMenu.add(slctOptns);

			nodo.setComponentPopupMenu(miniMenu);
			levels.add(s.gtSonsId().length);
			int[] sns=s.gtSonsId();
			for(int son: sns){
				nodoTope.add(nodos.get(son));
			}
			if(currnt>0)levelPanel.add(nodo);
			
			currnt--;
			
			if(currnt<1){
				this.srcF.cnvs.add(levelPanel);
				levelPanel=new JPanel();
				lyt=new BoxLayout(levelPanel,BoxLayout.Y_AXIS);
				levelPanel.setLayout(lyt);
				currnt=(levels.size()>0)?levels.remove():0;
			}		
		}
	}
}
