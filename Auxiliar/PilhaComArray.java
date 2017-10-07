package Auxiliar;

public class PilhaComArray implements TADPilha {

	private Object[] elementos;
	private int topo;
	
	public PilhaComArray() {
		elementos = new Object[10];
		topo = -1;
	}
	
	public void push(Object o) {
		if (! isFull()) {
			elementos[++topo] = o;
		} else {
			throw new StackOverflowError("Pilha cheia!");
		}
	}

	public Object pop() {
		Object o = null;
		if (!isEmpty()) {
			o = elementos[topo];
			elementos[topo] = null;
			topo--;
		} else {
			throw new RuntimeException("Pilha vazia!");
		}
		return o;
	}

	public Object top() {
		Object o = null;
		if (!isEmpty()) {
			o = elementos[topo];
		} else {
			throw new RuntimeException("Pilha vazia!");
		}
		return o;
	}

	public int size() {
		return topo+1;
	}

	public boolean isEmpty() {
		return topo == -1;
	}

	public boolean isFull() {
		return topo == elementos.length - 1;
	}

}
