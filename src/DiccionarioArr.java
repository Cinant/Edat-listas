
@SuppressWarnings("serial")
class DiccLleno extends Exception{
	public DiccLleno(){System.out.println("Excedio");}
}

public class DiccionarioArr {
	protected static final int N=100;
	protected int n;
	protected Object[] id,info;
	
	public DiccionarioArr(){
		id = new Object[N];//Un arreglo para los indices(igual posicion)
		info = new Object[N];//Un arreglo para el significado(igual posicion)
		n = 0;
	}
	
	protected int indice(Object x){//retorna la posicion(indice) del objeto x
		for(int i = 0; i<n ; ++i)
			if(x.equals(id[i]))
				return i;
		return -1;
	}
	
	public Object buscar(Object x){//devuelve la informacion del objeto x
		int i = indice(x);
		return i < 0 ? null : info[i];
	}
	
	public boolean agregar(Object x, Object y) throws DiccLleno{
		try{
			if( indice(x) >= 0)
				return false;
			id[n] = x;
			info[n] = y;
			++n;
			return true;
		}
		catch(ArrayIndexOutOfBoundsException e){
			throw new DiccLleno();
		}
	}
	
	public boolean borrar(Object x){
		int i = indice(x);
		if( i<0 )
			return false;
		id[i] = id[n-1];
		info[i] = info[n-1];//subir el de laultima posicion
		--n;
		return true;
	}
	
	public boolean cambiar(Object x, Object y){
		int i = indice(x);
		if( i < 0 )
			return false;
		info[i] = y;
		return true;
	}

}
