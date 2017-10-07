package Principal;

public class TesteArvore {

    public static void main(String[] args) {
      TADTree<Comparable> arvore = new BinarySortedTree<String>();

        arvore.add("Sergio");
        arvore.add("Bruno");
        arvore.add("Arthur");
        arvore.add("Lucas");
        arvore.add("Allan");
        arvore.add("Pedro");
        arvore.add("Theusma");

        System.out.println(arvore.contains("Arthur"));
        System.out.println(arvore.contains("Pedro"));
        System.out.println(arvore.contains("Gabriel"));
        System.out.println(arvore.contains("Ana"));
        System.out.println(arvore.contains("Eduardo"));

        System.out.println("--------");
        arvore.exploreTree(TADTree.PRE_ORDER_EXPLORE);
        //remove Allan
        arvore.remove("Allan");
        System.out.println("----REMOVIDO----");
        arvore.exploreTree(TADTree.PRE_ORDER_EXPLORE);
        System.out.println("--------");
        //remove Pedro
        arvore.exploreTree(TADTree.PRE_ORDER_EXPLORE);
        arvore.remove("Pedro");
        System.out.println("----REMOVIDO----");
        arvore.exploreTree(TADTree.IN_ORDER_EXPLORE);
        System.out.println("--------");
        arvore.exploreTree(TADTree.POST_ORDER_EXPLORE);
        //remove Theusma
        arvore.remove("Theusma");
        System.out.println("----REMOVIDO----");
        arvore.exploreTree(TADTree.POST_ORDER_EXPLORE);
        
        //teste printarArvore
        arvore.printTree();

    }

}
