package practica2.ejercicio01y02;

public class BinaryTree<T> {
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	public BinaryTree() {
		super();
	}	

	public BinaryTree(T data) {
		this.data = data;
                this.leftChild = null; 
                this.rightChild = null; 
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}
	
	//agrega un hijo como hijo izquierdo o derecho del árbol.
	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}
	
	//eliminan el hijo correspondiente.
	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}
	
	//indica si el árbol está vacío
	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	
        // indica si no tiene hijos.
	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
	
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	
	
	@Override
	public String toString() {
		return this.getData().toString();
	}
	
        // contar hojas
        public int contarHojas(){
            int cont = 0; 
            if(this.isEmpty())
                return 0; 
            else {
                if(this.isLeaf())
                    return 1; 
                else {
                    if (this.hasLeftChild())
                        cont += this.getLeftChild().contarHojas();
                    if (this.hasRightChild())
                        cont += this.getRightChild().contarHojas();
                }
            }
            return cont; 
        }
        
        // espejar arbol
        public BinaryTree<T> espejo(){
            if (this.isEmpty())
                return this; 
            else { 
                BinaryTree<T> ab = new BinaryTree(this.getData());
                if(this.hasLeftChild()) {
                    ab.addRightChild(this.getLeftChild().espejo());
                }
                if(this.hasRightChild()){
                    ab.addLeftChild(this.getRightChild().espejo());
                }    
                return ab;
            }
        }

}
