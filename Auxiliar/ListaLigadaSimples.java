package Auxiliar;
public class ListaLigadaSimples implements TADLista {
	private NoSimples inicio;
	private int quantidade;
	
	public void add(Object o) {
		NoSimples novo = new NoSimples();
		novo.setElemento(o);
		if (inicio == null) 
			inicio = novo;
		else {
			novo.setProximo(inicio);
			inicio = novo;
		}
		quantidade++;
	}

	public boolean contains(Object o) {
		boolean r = false;
		NoSimples p = inicio;
		for (int i = 0; i < quantidade; i++) {
			if (o.equals(p.getElemento())) {
				r = true;
				break;
			}
			p = p.getProximo();
		}
		return r;
	}

	public int indexOf(Object o) {
		int r = -1;
		NoSimples p = inicio;
		for (int i = 0; i < quantidade; i++) {
			if (o.equals(p.getElemento())) {
				r = i;
				break;
			}
			p = p.getProximo();
		}
		return r;
	}

	public boolean remove(Object o) {
		boolean r = false;
		if (inicio != null) {
			if (inicio.getElemento().equals(o)) {
				inicio = inicio.getProximo();
				quantidade--;
				r = true;
			} else {
				NoSimples p = inicio;
				for (int i = 0; i < quantidade-1; i++) {
					if (o.equals(p.getProximo().getElemento())) {
						r = true;
						p.setProximo(p.getProximo().getProximo());
						quantidade--;
						break;
					}
					p = p.getProximo();
				}		
			}
		}
		return r;
	}

	public int size() {
		return quantidade;
	}
}
