package Principal;

public class BinarySortedTree<T> implements TADTree<Comparable> {

    private BinarySortedNode<Comparable> raiz;
    private int quantidade;

    public void add(Comparable o) {
        if (raiz != null) {
            BinarySortedNode<Comparable> novo = new BinarySortedNode<Comparable>();
            novo.setElemento(o);
            BinarySortedNode<Comparable> p = raiz;
            while (p != null) {
                if (p.getElemento().equals(o)) {
                    break;
                } else if (p.getElemento().compareTo(o) < 0) {
                    if (p.getRight() != null) {
                        p = p.getRight();
                    } else {
                        p.setRight(novo);
                        quantidade++;
                        break;
                    }
                } else {
                    if (p.getLeft() != null) {
                        p = p.getLeft();
                    } else {
                        p.setLeft(novo);
                        quantidade++;
                        break;
                    }
                }
            }
        } else {
            BinarySortedNode<Comparable> novo = new BinarySortedNode<Comparable>();
            novo.setElemento(o);
            raiz = novo;
            quantidade++;
        }
    }

    public boolean contains(Comparable o) {
        return (getNo(o) != null);
    }

    private BinarySortedNode<Comparable> getNo(Comparable o) {
        BinarySortedNode<Comparable> r = null;
        if (raiz != null) {
            BinarySortedNode<Comparable> p = raiz;
            while (p != null) {
                if (p.getElemento().equals(o)) {
                    r = p;
                    break;
                } else if (p.getElemento().compareTo(o) < 0) {
                    p = p.getRight();
                } else {
                    p = p.getLeft();
                }
            }
        }
        return r;
    }

    public int getNivelNo(Comparable o) {
        int r = -1;
        if (raiz != null) {
            int nivel = 0;
            BinarySortedNode<Comparable> p = raiz;
            while (p != null) {
                if (p.getElemento().equals(o)) {
                    r = nivel;
                    break;
                } else if (p.getElemento().compareTo(o) < 0) {
                    p = p.getRight();
                } else {
                    p = p.getLeft();
                }
                nivel++;
            }
        }
        return r;
    }

    @Override
    public boolean remove(Comparable o) {
        boolean r = false;
        if (raiz != null) {
            if (raiz.getElemento().equals(o)) {
                r = true;
                quantidade--;
                if (raiz.getLeft() == null) {
                    raiz = raiz.getRight();
                } else if (raiz.getRight() == null) {
                    raiz = raiz.getLeft();
                } else {
                    // raiz possui as duas ramificacoes
                    // seguimos em busca do maior elemento a esquerda da raiz
                    BinarySortedNode<Comparable> p = raiz.getLeft();
                    BinarySortedNode<Comparable> paiP = raiz;
                    while (p.getRight() != null) {
                        // desce para direita
                        paiP = p;
                        p = p.getRight();
                    }
                    // faz a copia do elemento de p para a raiz
                    raiz.setElemento(p.getElemento());
                    // verifica como a remocao de p deve ser realizada
                    if (paiP == raiz) {
                        paiP.setLeft(p.getLeft());
                    } else {
                        paiP.setRight(p.getLeft());
                    }
                }
            } else {
                // o elemento a ser removido nao é a raiz ...
                BinarySortedNode<Comparable> paiAux = raiz;
                BinarySortedNode<Comparable> aux = raiz;
                while (aux != null) {
                    // procurando o elemento a ser removido
                    if (aux.getElemento().equals(o)) {
                        // encontrei o elemento
                        break;
                    } else if (aux.getElemento().compareTo(o) < 0) {
                        paiAux = aux;
                        aux = aux.getRight();
                    } else {
                        paiAux = aux;
                        aux = aux.getLeft();
                    }
                }
                if (aux != null) {
                    // encontramos o elemento
                    r = true;
                    quantidade--;
                    if (aux.getLeft() == null) {
                        if (aux == paiAux.getLeft()) {
                            paiAux.setLeft(aux.getRight());
                        } else {
                            paiAux.setRight(aux.getRight());
                        }
                    } else if (aux.getRight() == null) {
                        if (aux == paiAux.getLeft()) {
                            paiAux.setLeft(aux.getLeft());
                        } else {
                            paiAux.setRight(aux.getLeft());
                        }
                    } else {
                        // o elemento que preciso remover possui duas subarvores
                        // buscar o maior elemento a esquerda para substituir ...
                        BinarySortedNode<Comparable> p = aux.getLeft();
                        BinarySortedNode<Comparable> paiP = aux;

                        while (aux.getRight() != null) {
                            paiP = p;
                            p = p.getRight();
                        }
                        aux.setElemento(p.getElemento());

                        if (paiP == aux) {
                            paiP.setLeft(p.getLeft());
                        } else {
                            paiP.setRight(p.getLeft());
                        }
                    }
                }
            }
        }
        return r;
    }

    public int size() {
        return quantidade;
    }

    public void exploreTree(int option) {
        if (option < 0) {
            System.out.println("Percurso em pre-ordem: ");
            exploreTreePreOrder(raiz);
        } else if (option == 0) {
            System.out.println("Percurso em ordem: ");
            exploreTreeInOrder(raiz);
        } else {
            System.out.println("Percurso em pos-ordem: ");
            exploreTreePostOrder(raiz);
        }
    }

    private void exploreTreePreOrder(BinarySortedNode<Comparable> p) {
        if (p != null) {
            System.out.println(p.getElemento());
            exploreTreePreOrder(p.getLeft());
            exploreTreePreOrder(p.getRight());
        }
    }

    private void exploreTreeInOrder(BinarySortedNode<Comparable> p) {
        if (p != null) {
            exploreTreeInOrder(p.getLeft());
            System.out.println(p.getElemento());
            exploreTreeInOrder(p.getRight());
        }
    }

    private void exploreTreePostOrder(BinarySortedNode<Comparable> p) {
        if (p != null) {
            exploreTreePostOrder(p.getLeft());
            exploreTreePostOrder(p.getRight());
            System.out.println(p.getElemento());
        }
    }

    private int getAlturaNo(BinarySortedNode<Comparable> p) {
        if (p != null) {
            int altEsq = getAlturaNo(p.getLeft());
            int altDir = getAlturaNo(p.getRight());
            int altP = (altEsq > altDir) ? altEsq + 1 : altDir + 1;
            return altP;
        } else {
            // caso base da recursao
            return -1;
        }
    }

    public int getAlturaNo(Comparable elemento) {
        int altura = -1;
        BinarySortedNode<Comparable> p = getNo(elemento);
        altura = getAlturaNo(p);
        return altura;
    }

    @Override
    public void printTree() {
        // TODO Imprimir a arvore na forma como desenhamos no quadro

    }

}
