import java.util.Scanner;

public class PotenciaRecursiva {
    public static int multiplicar(int num1, int num2) {
        if (num1 == 0 || num2 == 0) {
            return 0;
        } else if (num2 > 0) {
            return num1 + multiplicar(num1, num2 - 1);
        } else {
            return -num1 + multiplicar(num1, num2 + 1);
        }
    }

    public static int potencia(int base, int exponente) {
        if (exponente == 0) {
            return 1;
        }
        return multiplicar(base, potencia(base, exponente - 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese la base");
        int base = sc.nextInt();

        System.out.println("Ingrese el exponente");
        int exponente = sc.nextInt();

        int result = potencia(base, exponente);
        System.out.println(base + "^" + exponente + " = " + result);
    }
}
