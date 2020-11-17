import java.util.*;

// Name : Kim Chan Mi
// Student ID : 20191574

@SuppressWarnings("unchecked")
class BST <T extends KeyValue> {

	class TreeNode <U extends KeyValue> {
		U data;	// storage for data : in HW 3, T will be Item
		TreeNode<U> leftChild;	// link to the left Child
		TreeNode<U> rightChild;	// link to the right Child

		// constructors come here
		TreeNode() {
			leftChild = rightChild = null;
		}
		TreeNode(U d) {
			// data is given
			data = d;
			// the leftChild and rightChild field are null
			leftChild = rightChild = null;
		}
	};

	TreeNode <T> root;// the reference to the root node

	BST() { 
		// BST constructor. 
		root = null;
	}

	void Show() {
		System.out.print( "PRE  Order : ");
		PreOrder(root);
		System.out.println("");
		System.out.print("IN   Order : ");
		InOrder(root);
		System.out.println("");
		System.out.print("POST Order : ");
		PostOrder(root);
		System.out.println("");
		System.out.print("Number of Nodes : ");
		System.out.println( Count(root));
		System.out.print("HEIGHT : ");
		System.out.println( Height(root));
		System.out.println("");
	}

	// IMPLEMENT THE FOLLOWING FUNCTIONS

	boolean  Insert(T item)  {
		// first search the key
		if(root == null) {
			root = new TreeNode(item);

			return true;
		}

		TreeNode<T> ptr, parent;

		ptr = parent = root;
		
		while (ptr != null) {
			parent = ptr;
			
			if (item.GetKey() < ptr.data.GetKey()) {
				ptr = ptr.leftChild;
			}
			else if (item.GetKey() > ptr.data.GetKey()) {
				ptr = ptr.rightChild;
			}
			else {
				return false;
			}
		}
		
		ptr = new TreeNode(item);
		if (item.GetKey() < parent.data.GetKey()) {
			parent.leftChild = ptr;
		}
		else {
			parent.rightChild = ptr;
		}

		return true;
	}

	T Get(T item)  {
		// use the key field of item and find the node
		// do not use val field of item
		TreeNode<T> ptr;
		ptr = root;
		
		while (ptr != null) {
			if (item.GetKey() < ptr.data.GetKey()) {
				ptr = ptr.leftChild;
			}
			else if (item.GetKey() > ptr.data.GetKey()) {
				ptr = ptr.rightChild;
			}
			else { break; }
		}
		
		if (ptr == null) { return null; }

		return ptr.data;
	} 


   boolean Delete(T item)  {
	      TreeNode<T> ptr, parent, two, leftRoot, temp, newNode;
	      if(root == null) return false;   // non existing key
	      
	      ptr = root;
	      parent = root;
	      boolean isLeftchild = false;
	      
	      while(ptr.data.GetKey() != item.GetKey()) { 
	         parent = ptr ;
	         if(item.GetKey() > ptr.data.GetKey()) {
	            isLeftchild = false;
	            ptr = ptr.rightChild;
	         }
	         else if(item.GetKey() < ptr.data.GetKey()) {
	            isLeftchild = true;
	            ptr = ptr.leftChild;
	         }
	         if (ptr == null) return false;
	      }
	      
	      // leaf 
	      if(ptr.leftChild == null && ptr.rightChild == null) { 
	         if(ptr == root) root = null;
	         if(isLeftchild == true) parent.leftChild = null;
	         else parent.rightChild = null;
	      }
	      //Non lefChild && Non rightChild
	      else if(ptr.rightChild == null || ptr.leftChild == null) {
	         if(ptr.rightChild == null) { 
	            if(ptr == root) root = ptr.leftChild;
	            if(isLeftchild == false) parent.rightChild = ptr.leftChild;
	            else parent.leftChild = ptr.leftChild;
	         }
	         else {  
	            if(ptr == root) root = ptr.rightChild;
	            if(isLeftchild == false) parent.rightChild = ptr.rightChild;
	            else parent.leftChild = ptr.rightChild;
	         }
	      }
	      // 2 children
	      else {             
	         TreeNode<T> leftSubTree = ptr.leftChild;
	         leftRoot = ptr.leftChild;
	         two = leftRoot;
	         temp = leftRoot;
	         
	         while(temp.rightChild != null) {
	            two = temp;
	            temp = temp.rightChild;
	         }
	         two.rightChild = temp.leftChild;
	         newNode = temp;
	         
	         if(ptr == root) root = newNode;
	         else if(isLeftchild) parent.leftChild = newNode;
	         else parent.rightChild = newNode;
	         
	         newNode.leftChild = leftSubTree;
	         
	         if(newNode == leftSubTree) newNode.leftChild = null;
	         
	         newNode.rightChild = ptr.rightChild;
	      }
	      return true;
	   }

	void  PreOrder(TreeNode<T> t)  {
		
		if (t == null) {
			return ;
		}
		T data = t.data;
		
		System.out.print("[" + data.GetKey() + "(" + data.GetValue() + ")" + "]");
		PreOrder(t.leftChild);
		PreOrder(t.rightChild);

	}

	void  InOrder(TreeNode<T> t)  {
		if (t == null) { return; }
		
		T data = t.data;
		
		InOrder(t.leftChild);
		System.out.print("[" + data.GetKey() + "(" + data.GetValue() + ")" + "]");
		InOrder(t.rightChild);

	}

	void  PostOrder(TreeNode<T> t)  {
		if (t == null) { return; }
		
		T data = t.data;
		
		PostOrder(t.leftChild);
		PostOrder(t.rightChild);
		System.out.print("[" + data.GetKey() + "(" + data.GetValue() + ")" + "]");

	}

	int  Count(TreeNode<T> t)  {
		if (t == null) { return 0; }
		
		int cnt; 
		
		cnt = 1 + Count(t.leftChild) + Count(t.rightChild);
		
		return cnt;

	}

	int  Height(TreeNode<T> t)  {
		if (t == null) { return 0; }
		
		int cnt_left = 1 + Height(t.leftChild);
		int cnt_right = 1 + Height(t.rightChild);
		
		if (cnt_left > cnt_right) { return cnt_left; }
		else { return cnt_right; }

	}
}


