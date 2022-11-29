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
		lclsSrvc.stLcls(EnUsLcls());
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
	 *	16.- Return
	 *	17.- Scenes
	 *	18.-Not new scenes
	 *	19.-Create new scene
	 *	20.-Recent Scenes
	 *	21.-Not recent scenes
	 *	22.-Scene name
	 *	23.- File
	 *	24.- Edit
	 *	25.- Image
	 *	26.- Layer
	 *	27.- Select
	 *	28.-Scripts
	 *	29.-Settings
	 *	30.-Window
	 *	31.- Help
	 *	32.-Load a scene first.
	 *	33.-Select a element to see it here.
	 *	34.- Layers
	 *	35.- Asset view
	 */
	public static Lcls EsMxLcls(){
		Lcls EsMx=new Lcls();
		EsMx.stLclNm("EsMx");
		String[] txts={"JViNoM","Inicio!","Nuevo Proyecto","Abrir proyecto","Reciente","No hay proyectos recientes :( (Porque no empezar uno :D?)","COOMunidad","Manual","Codigo fuente","Creando nuevo proyecto ","Nombre del proyecto:","Guardar en: "," Relacion de aspecto :"," Crear", "Cancelar","Regresar","Escenas","No hay escenas!(Porque no hacer una?)","Crear nueva escena","Escenas recientes","No hay escenas recientes","Nombre de la escena","Archivo","Editar","Imagen","Capa","Seleccion","Scripts","Configuraciones","Ventana","Ayuda","Carga una escena primero","Selecciona algun elemento para verlo aqui","Capas","Observador del asset"};
		EsMx.stTxt(txts);

		return EsMx;
	}

	public static Lcls EnUsLcls(){
		Lcls EnUs=new Lcls();
		EnUs.stLclNm("EnUs");
		String[] txts={"JViNoM","Start!","New Project","Open project","Recent","Not a single recent project:( ( Why not start today :D?)","CUMunity","Manual","Source Code","New project .- ","Project's name:","Save on: ","Aspect ratio :","Create", "Cancel","Back","Scenes","No scenes!(Make one, pretty please?)","Create new scene","Recent scenes","No recent scenes","Scene's name :","File","Edit","Image","Layer","Select","Scripts","Configurations","Frame","Help","Load a scene first","Select an element to see it here","Layers","Asset view"};
		EnUs.stTxt(txts);

		return EnUs;

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
