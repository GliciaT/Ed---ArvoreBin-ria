package Auxiliar;
public class ListaComArray implements TADLista {
	private Object[] elementos;
	private int quantidade;
	public ListaComArray() {
		elementos = new Object[10];
		quantidade = 0;
	}
	
	public void add(Object o) {
		if (quantidade < elementos.length) {
			elementos[quantidade] = o;
			quantidade++;
		} else {
			throw new RuntimeException("Lista cheia!");
		}
	}
	
	public boolean contains(Object o) {
		boolean r = false;
		for (int i = 0; i < quantidade; i++) {
			if (o.equals(elementos[i])) {
				r = true;
				break;
			}
		}
		return r;
	}
	
	public int indexOf(Object o) {
		int r = -1;
		for (int i = 0; i < quantidade; i++) {
			if (o.equals(elementos[i])) {
				r = i;
				break;
			}
		}
		return r;
	}
	
	public boolean remove(Object o) {
		boolean r = false;
		for (int i = 0; i < quantidade; i++) {
			if (o.equals(elementos[i])) {
				r = true;
				// deslocar os elementos a frente
				while (i < quantidade-1) {
					elementos[i] = elementos[i+1];
					i++;
				}
				quantidade--;
				elementos[quantidade] = null;
				break;
			}
		}
		return r;
	}

	public int size() {
		return quantidade;
	}
}
