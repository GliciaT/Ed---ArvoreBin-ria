package Auxiliar;

public class PilhaDinamica implements TADPilha {

	private NoSimples topo;
	private int quantidade;
	
	public void push(Object o) {
		NoSimples novo = new NoSimples();
		novo.setElemento(o);
		if (topo == null)
			topo = novo;
		else {
			novo.setProximo(topo);
			topo = novo;
		}
		quantidade++;
	}

	public Object pop() {
		Object r = null;
		if (topo != null) {
			r = topo.getElemento();
			topo = topo.getProximo();
			quantidade--;
		}
		return r;
	}

	public Object top() {
		Object r = null;
		if (topo != null) {
			r = topo.getElemento();
		}
		return r;
	}

	public int size() {
		return quantidade;
	}

	public boolean isEmpty() {
		return topo == null;
	}

	public boolean isFull() {
		return false;
	}

}
