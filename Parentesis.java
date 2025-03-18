import java.util.Stack; // Hacemos uso de la clase stack para manejar parentesis.

public class Parentesis {
    public static boolean estanBalanceados(String expresion) {
        Stack<Character> pila = new Stack<>(); // Creamos una pila para almacenar los parentesis abiertos.

        for (char c : expresion.toCharArray()) { // Recorremos cada caracter de la expresion.
            if (c == '(') {
                pila.push(c); // Si encuentra un '(', lo agrega a la pila.
            } else if (c == ')') {
                if (pila.isEmpty() || pila.pop() != '(') { // Si encuentra un ')', verifica si hay un '(' en la pila para emparejar.
                    return false;
                }
            }
        }
        return pila.isEmpty();
    }
}
