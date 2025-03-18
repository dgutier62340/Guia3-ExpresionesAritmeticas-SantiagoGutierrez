import java.util.Stack;
import java.util.StringTokenizer;

public class Postfija {
    public static double evaluarPostfija(String expresion) {
        Stack<Double> pila = new Stack<>(); // Crea una pila para almacenar los operandos.
        StringTokenizer tokens = new StringTokenizer(expresion);

        while (tokens.hasMoreTokens()) { //Procesamos cada token
            String token = tokens.nextToken();
            if (token.matches("\\d+")) { 
                pila.push(Double.parseDouble(token)); // Si el token es un número, lo convierte a Double y lo apila
            } else { // Si el token es un operador, extrae dos operandos de la pila
                double b = pila.pop();
                double a = pila.pop();

            
                switch (token.charAt(0)) { // Realiza la operación correspondiente y almacena el resultado en la pila
                    case '+': pila.push(a + b); break;
                    case '-': pila.push(a - b); break;
                    case '*': pila.push(a * b); break;
                    case '/': 
                        if (b == 0) throw new ArithmeticException("Error: División por cero");
                        pila.push(a / b); 
                        break;
                    case '^': pila.push(Math.pow(a, b)); break;
                }
            }
        }
        return pila.pop(); // Retorna el resultado final de la evaluación
    }
} 