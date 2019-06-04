package Lab3;

import java.util.Scanner;

public class Lab3_n2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число(1-30):");
        int n = scanner.nextInt();
        System.out.println("Введите количество подрят единиц нельзя:");
        int k = scanner.nextInt();
        int sum,t,ord=0;
        String nomber;
        double amount = Math.pow(2,n);
        for (int i=0;i<amount;i++) {
            nomber = convert(i);
            t = 0;
            for (int j = 0; j < nomber.length(); j++) {
                if (nomber.charAt(j) == '1') {
                    t++;
                } else {
                    t = 0;
                }
                if (t == k) {
                    ord++;
                    System.out.println(nomber);
                    break;
                }
            }
        }

        System.out.println("Количество чисел:"+(amount-ord));

    }

    public static String convert(int n) {
        return Integer.toBinaryString(n);
    }



}
