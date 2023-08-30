import java.util.Scanner;

public class Recursividad {
    public static float multiply(float multiplicando, float multiplicador) {
        if (multiplicador > 0) {
            return multiplicando + multiply(multiplicando, multiplicador - 1);
        }

        if (multiplicador < 0) {
            return -multiply(multiplicando, -multiplicador);
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el multiplicando");
        float multiplicando = sc.nextFloat();

        System.out.println("Ingrese el multiplicando");
        float multiplicador = sc.nextFloat();

        float result = multiply(multiplicando, multiplicador);
        System.out.println(multiplicando + " * " + multiplicador + " = " + result);
    }
}