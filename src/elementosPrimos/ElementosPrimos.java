package elementosPrimos;
import cola.Cola;
import PilaP.Pila;

public class ElementosPrimos {

    public static boolean esPrimo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static Cola<Integer> pasarPrimosDePilaACola(Pila<Integer> pila) {
        Cola<Integer> cola = new Cola<>();
        Pila<Integer> auxiliar = new Pila<>();


        while (!pila.estaVacia()) {
            int elemento = pila.pop();

            if (esPrimo(elemento)) {
                cola.encolar(elemento);
            }

            auxiliar.push(elemento);
        }


        while (!auxiliar.estaVacia()) {
            pila.push(auxiliar.pop());
        }

        return cola;
    }


    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>();


        pila.push(10);
        pila.push(5);
        pila.push(4);
        pila.push(7);
        pila.push(9);
        pila.push(2);

        System.out.println("Pila original:");
        pila.imprimir();

        Cola<Integer> colaDePrimos = pasarPrimosDePilaACola(pila);

        System.out.println("\nPrimos encontrados en la pila (en la cola):");
        colaDePrimos.imprimir();

        System.out.println("\nPila restaurada (después de extraer primos):");
        pila.imprimir();
    }
}
