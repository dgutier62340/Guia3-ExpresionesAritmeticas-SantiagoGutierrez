import java.util.Scanner;

public class EvaluadorExpresiones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una expresion aritmetica: ");
        String expresion = scanner.nextLine(); //Lee la expresion ingresada por el usuario
        scanner.close();
        
        if (!Parentesis.estanBalanceados(expresion)) { // Verifica si los parentesis de la expresión estan balanceados
            System.out.println("Error: Parentesis no balanceados");
            return;
        }

        String postfija = ConversorNotacion.infijaAPostfija(expresion);  // Convierte la expresion de notación infija a notacion postfija.
        System.out.println("Expresion Postfija: " + postfija);
        System.out.println("Resultado: " + Postfija.evaluarPostfija(postfija)); // Muestra la expresion convertida
    }
}
