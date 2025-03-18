import java.util.Stack;
import java.util.StringTokenizer; // Importamos StringTokenizer para dividir la expresión en tokens.

public class ConversorNotacion {
    private static int precedencia(char operador) {
        switch (operador) {
            case '+': case '-': return 1; // Suma y resta tienen la menor precedencia, nivel 3
            case '*': case '/': return 2; // Multiplicación y división tienen mayor precedencia, nivel 2
            case '^': return 3; // La potencia tiene la mayor precedencia, nivel1
            default: return -1; // Retorna -1 para caracteres que no son operadores.
        }
    }

    public static String infijaAPostfija(String expresion) {
        StringBuilder resultado = new StringBuilder(); // Almacenamos la expresion en notacion postfija.
        Stack<Character> pila = new Stack<>(); // Pila para manejar los operadores y paréntesis.

        StringTokenizer tokens = new StringTokenizer(expresion, "()+-*/^ ", true); // Dividimos en tokens

        while (tokens.hasMoreTokens()) { // Procesamos cada token de la expresion.
            String token = tokens.nextToken().trim(); //Eliminamos espacios de cada token
            if (token.isEmpty()) continue;

            if (token.matches("\\d+")) {
                resultado.append(token).append(" "); // Si es un numero lo agrega al resultado
            } else if (token.equals("(")) {
                pila.push('('); // Si es un paréntesis abierto, lo agrega a la pila.
            } else if (token.equals(")")) {
                while (!pila.isEmpty() && pila.peek() != '(') { // Si es un paréntesis cerrado, extrae operadores hasta encontrarlo
                    resultado.append(pila.pop()).append(" ");
                }
                pila.pop(); // Eliminar de la pila
            } else {
                char operador = token.charAt(0); // Si es un operador, maneja la precedencia.
                while (!pila.isEmpty() && precedencia(pila.peek()) >= precedencia(operador)) {
                    resultado.append(pila.pop()).append(" "); // Extrae operadores con mayor o igual precedencia.
                }
                pila.push(operador); //Agregamos el operador a la pila
            }
        }

        while (!pila.isEmpty()) { // Extraemos cualquier operador restante.
            resultado.append(pila.pop()).append(" ");
        }
        
        return resultado.toString().trim();
    }
}
