package PilaP;
import ListaSencillamenteEnlazada.Node;

public class Pila<T> {

    private Node<T> cima;
    private int tamano;

    public Pila(){
        this.cima = null;
        this.tamano = 0;
    }
    public Pila(T data) {
        this.cima = new Node<>(data);
        this.tamano = 0;
    }


    public boolean estaVacia() {
        return cima == null;
    }

    /**
     * Inserta un elemento en la Pila - push
     * @param dato elemento a guardar en la pila
     */
    public void push(T dato) {
        Node<T> nodo = new Node<>(dato);
        nodo.setNext(cima);
        cima = nodo;
        tamano++;
    }

    /**
     * Retorna y elimina el elemento que está en la cima de la Pila - pop
     * @return Elemento de la cima
     */
    public T pop() {
        if (estaVacia()) {
            throw new RuntimeException("La Pila está vacía");
        }

        T dato = cima.getValor();
        cima = cima.getNext();
        tamano--;

        return dato;
    }

    /**
     * Borra completamente la Pila
     */
    public void borrarPila() {
        cima = null;
        tamano = 0;
    }

    /**
     * @return el valor en la cima - peek
     */
    public T obtenerCima() {
        if (estaVacia()) {
            throw new RuntimeException("La Pila está vacía");
        }
        return cima.getValor();
    }

    /**
     * @return la cima como nodo
     */
    public Node<T> getCima() {
        return cima;
    }

    /**
     * @return el tamaño de la pila
     */
    public int getTamano() {
        return tamano;
    }

    /**
     * Imprime una pila en consola
     */
    public void imprimir() {
        Node<T> aux = cima;
        while (aux != null) {
            System.out.print(aux.getValor() + "\t");
            aux = aux.getNext();
        }
        System.out.println();
    }

}
