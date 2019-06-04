

import java.util.Random;
import java.util.Scanner;

public class Lab2_sort1 {
    public static void main(String[] args) {
        System.out.println("Введите размер массива:"); //"Вводим массив"
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        int amount = in.nextInt();                     //Указываем кол-во элементов масива
        int[] array = new int[amount];                 //Создаем сам массив
        for (int i = 0; i < amount; i++) {
            array[i] = random.nextInt(1014);
            array[i] = array[i] - 123;//Заполняем рандомными числами
        }
        for (int i = 0; i < amount; i++)
            System.out.print(array[i] + ",");           //Выводим полученный массив

        System.out.println();                        //
        System.out.println("Сортировка выбором:");   //Метод сортировки Выборам
        vibor_int(array, amount);                     //
    }



    public static void vibor_int(int[] a,int n) {
        int cos=0;
        int remember_i=0,remember_a=0;
        for (int j = 0; j < n; j++) {
            int min = a[j];
            for (int i = j; i < n; i++) {
                if (a[i] < min) {
                    min = a[i];
                    remember_i = i;                 //Сам метод
                    cos++;
                }
            }
            if (a[j] > min){
                remember_a = a[j];

                a[j] = a[remember_i];
                a[remember_i] = remember_a;
                cos++;
            }
        }
        for (int i=0;i<n;i++)
            System.out.print(a[i]+",");
        System.out.println();
        System.out.println("Кол-во операций:"+cos);
    }
}