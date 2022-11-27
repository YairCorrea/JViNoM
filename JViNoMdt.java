package JViNoM;

import JViNoM.Mdl.FlWrtr;
import JViNoM.Mdl.Dao.*;
import JViNoM.Mdl.Srvcs.*;
import JViNoM.Mdl.Bns.*;

import java.util.ArrayList;
/**
 * 	JViNoM's default data
 *	Contains most default JViNoM texts, images and basic structures to allow it to run smoothly.
 *	Do NOT alter unless you know what you are doing.Despite not running most times you execute JViNoM, it runs at least when its first installed, and it may use it again if it presents any problem to restore itself to a minimum working state. So altering it may cause your program to die. Your files would still be intact and everything, but JViNoM not.
 *
 * 	If you want to add a new language or chance images, you can do so here. Some guy in Mexico will own you its eternal gratitude for it.
 *	@Author La grande hambre que siento.
 *	@Version 2211
 */
public class JViNoMdt{

	public static void main(String[] args){
		FlWrtr flWrtr=new FlWrtr();
		flWrtr.sv("Lcls",new ArrayList<Lcls>());
		LclsDAO lclsDAO=new LclsDAO();
		LclsSrvc lclsSrvc=new LclsSrvc(lclsDAO);
		lclsSrvc.stLcls(EsMxLcls());
		lclsSrvc.save();

		flWrtr.sv("Sttcs",new ArrayList<Sttc>());
		SttcDAO sttcDAO=new SttcDAO();
		SttcSrvc sttcSrvc=new SttcSrvc(sttcDAO);
		sttcSrvc.stSttc(imgs());
		sttcSrvc.save();

		flWrtr.sv("Cnfgs",new ArrayList<Cnfgs>());
		CnfgsDAO cnfgsDAO=new CnfgsDAO();
		CnfgsSrvc cnfgsSrvc=new CnfgsSrvc(cnfgsDAO);
		cnfgsSrvc.stCnfgs(dfltCnfgs());
		cnfgsSrvc.save();
	}
	public static Cnfgs dfltCnfgs(){
		Cnfgs cnfgs=new Cnfgs();
		cnfgs.stIdm("EsMx");
		return cnfgs;
	}
	/**
	 *	Locales order goes like:
	 *	1.-JViNoM :D
	 *	2.-Start greeting
	 *	3.- New project text
	 *	4.- Open project 
	 *	5.- Recent
	 *	6.- No recent projects message
	 *	7.- Hehehe... COOMunitty
	 *	8.-Manual
	 *	9.- Source code
	 *	10.- Creating new project
	 *	11.-name of the project
	 *	12.- Where to save?
	 *	13.- Which aspect ratio?
	 *	14.-Create!
	 *	15.- Cancel :(
	 *
	 *
	 */
	public static Lcls EsMxLcls(){
		Lcls EsMx=new Lcls();
		EsMx.stLclNm("EsMx");
		String[] txts={"JViNoM","Inicio!","Nuevo Proyecto","Abrir proyecto","Reciente","No hay proyectos recientes :( (Porque no empezar uno :D?)","COOMunidad","Manual","Codigo fuente","Creando nuevo proyecto ","Nombre del proyecto:","Guardar en: "," Relacion de aspecto :"," Crear", "Cancelar"};
		EsMx.stTxt(txts);

		return EsMx;
	}
	/**
	 *	Statics for imgs. JViNoM currently does not have sound. It supports it, but does not comes with samples or anything.
	 */
	public static Sttc imgs(){
		Sttc icon=new Sttc();
		icon.stFlNm("jainima");
		icon.stLctn("jainima.png");
		return icon;
	}
}
