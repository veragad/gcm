import java.util.Random;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        int numero = new Random().nextInt(5) + 1; // número de 1 a 5
        System.out.print("Adivinhe um número de 1 a 5: ");
        int palpite = new Scanner(System.in).nextInt();
        System.out.println(palpite == numero ? "🎉 Acertou!" : "❌ Errou! O número era " + numero);
    }
    
}
