package binaria;
import PilaP.Pila;
import cola.Cola;

public class ImprimirBinaria {

    public static int enteroABinario(int numero) {
        if (numero == 0) return 0;

        Pila<Integer> pila = new Pila<>();
        Cola<Integer> cola = new Cola<>();


        while (numero > 0) {
            pila.push(numero % 2);
            numero /= 2;
        }


        while (!pila.estaVacia()) {
            cola.encolar(pila.pop());
        }


        int binario = 0;
        while (! (cola.getTamanio() == 0)) {
            binario = binario * 10 + cola.desencolar();
        }

        return binario;
    }
    public static void main(String[] args) {
        int numero = 8;
        int binario = enteroABinario(numero);
        System.out.println("Binario de " + numero + " es: " + binario);
    }

}
