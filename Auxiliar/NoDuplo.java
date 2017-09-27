package Auxiliar;

public class NoDuplo {
	private Object elemento;
	private NoDuplo proximo;
	private NoDuplo anterior;
	
	public NoDuplo getAnterior() {
		return anterior;
	}
	public void setAnterior(NoDuplo anterior) {
		this.anterior = anterior;
	}
	public Object getElemento() {
		return elemento;
	}
	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}
	public NoDuplo getProximo() {
		return proximo;
	}
	public void setProximo(NoDuplo proximo) {
		this.proximo = proximo;
	}
}
