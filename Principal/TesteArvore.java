package Principal;

public class TesteArvore {

    public static void main(String[] args) {
        TADTree<Comparable> arvore = new BinarySortedTree<String>();

        arvore.add("Carlos");
        arvore.add("Maria");
        arvore.add("Bruno");
        arvore.add("Antonio");
        arvore.add("Ana");
        arvore.add("Pedro");
        arvore.add("Eduardo");

        System.out.println(arvore.contains("Ana"));
        System.out.println(arvore.contains("Eduarda"));
        System.out.println(arvore.contains("Maria"));

        System.out.println("--------");
        arvore.exploreTree(TADTree.PRE_ORDER_EXPLORE);
        //remove carlos
        arvore.remove("Carlos");
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
        //remove Eduardo
        arvore.remove("Eduardo");
        System.out.println("----REMOVIDO----");
        arvore.exploreTree(TADTree.POST_ORDER_EXPLORE);

    }

}
