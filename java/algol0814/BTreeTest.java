import java.util.LinkedList;
import java.util.Queue;

public class BTreeTest {

	public static void main(String[] args) {
		BinaryTree<Integer> bt = new BinaryTree<>();
		bt.setRoot(new TNode<Integer>(1));
		TNode<Integer> a = new TNode<Integer>(2);
		TNode<Integer> b = new TNode<Integer>(3);
		TNode<Integer> c = new TNode<Integer>(4);
		TNode<Integer> d = new TNode<Integer>(5);
		TNode<Integer> e = new TNode<Integer>(6);
		TNode<Integer> f = new TNode<Integer>(7);
		TNode<Integer> g = new TNode<Integer>(8);
		TNode<Integer> h = new TNode<Integer>(9);
		TNode<Integer> i = new TNode<Integer>(10);
		TNode<Integer> j = new TNode<Integer>(11);
		TNode<Integer> k = new TNode<Integer>(12);
		TNode<Integer> l = new TNode<Integer>(13);
		TNode<Integer> m = new TNode<Integer>(14);
		TNode<Integer> n = new TNode<Integer>(15);
		bt.getRoot().setLeftChild(a);
		bt.getRoot().setRightChild(b);
		a.setLeftChild(c);
		a.setRightChild(d);
		b.setLeftChild(e);
		b.setRightChild(f);
		c.setLeftChild(g);
		c.setRightChild(h);
		d.setLeftChild(i);
		d.setRightChild(j);
		e.setLeftChild(k);
		e.setRightChild(l);
		f.setLeftChild(m);
		f.setRightChild(n);
		System.out.println("----------------------preorder----------------------");
		preOrder(bt.getRoot());
		System.out.println();
		System.out.println("---------------------middleorder--------------------");
		middleOrder(bt.getRoot());
		System.out.println();
		System.out.println("----------------------postorder---------------------");
		postOrder(bt.getRoot());
		System.out.println();
		bfs(bt.getRoot());
	}

	static void bfs(TNode<Integer> root) {
		Queue<TNode<Integer>> que = new LinkedList<>();
		que.offer(root);
		while(!que.isEmpty()) {
			TNode<Integer> p = que.poll();
			System.out.println(p.value + "->");
			if (p.left!=null) {
				que.offer(p.left);
			}
			if(p.right!=null) {
				que.offer(p.right);
			}
		}
	}

	static void middleOrder(TNode<Integer> node) {
		if (node==null) return;
		middleOrder(node.left);
		System.out.print(node.value + "->");
		middleOrder(node.right);
	}

	// dfs
	static void preOrder(TNode<Integer> node) {
		if (node==null) return;
		System.out.print(node.value + "->");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	static void postOrder(TNode<Integer> node) {
		if (node==null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value + "->");
	}

}
