
class NodoDicc{
	protected Object id, info;
	public NodoDicc sgte;
	public NodoDicc(Object x, Object y, NodoDicc z){
		id = x;
		info = y;
		sgte = z;
	}
	
}
public class DiccionarioLista {
	protected NodoDicc primero;
	public DiccionarioLista(){
		primero = null;
	}
	
	protected NodoDicc referencia(Object x){
		for(NodoDicc r = primero; r!= null; r=r.sgte)
			if(x.equals(r.id))
				return r;
		return null;
	}
	
	public Object buscar(Object x){
		NodoDicc r = referencia(x);
		return r == null ? null : r.info;
	}
	
	public boolean agregar(Object x, Object y) throws DiccLleno{
		if(referencia(x) != null)
			return false;
		primero = new NodoDicc(x,y,primero);
		return true;
	}
	
	public boolean cambiar(Object x, Object y){
		NodoDicc r = referencia(x);
		if(r == null)
			return false;
		r.info = y;
		return true;
	}
	
	public boolean borrar(Object x){
		NodoDicc r = referencia(x);
		if(r == null)
			return false;
		if(r == primero)
			primero = primero.sgte;
		else{
			NodoDicc ant = primero;
			while(ant.sgte != r)
				ant = ant.sgte;
			ant.sgte = r.sgte;
		}
		return true;
	}
	
	
}
