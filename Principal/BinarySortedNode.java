package Principal;

public class BinarySortedNode<T> {

	private Comparable<T> elemento;
	private BinarySortedNode left, right;
	
	public Comparable<T> getElemento() {
		return elemento;
	}
	public void setElemento(Comparable<T> elemento) {
		this.elemento = elemento;
	}
	public BinarySortedNode getLeft() {
		return left;
	}
	public void setLeft(BinarySortedNode left) {
		this.left = left;
	}
	public BinarySortedNode getRight() {
		return right;
	}
	public void setRight(BinarySortedNode right) {
		this.right = right;
	}
	
}
