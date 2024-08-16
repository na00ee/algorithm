
public class TNode<T> {

	TNode <T> left;
	T value;
	TNode <T> right;
	
	public TNode(TNode<T> left, T value, TNode<T> right) {
		this.left = left;
		this.value = value;
		this.right = right;
	}
	public TNode(T value) {
		this.value = value;
	}
	public void setLeftChild(TNode<T> left) {
		this.left = left;
	}
	public void setRightChild(TNode<T> right) {
		this.right = right;
	}
	
}
