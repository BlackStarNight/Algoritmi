import Lab2.Swap;

import java.util.Random;
import java.util.Scanner;

public class Lab2_sort3 {
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
        System.out.println("Сортировка включением:");//Метод сортировки Шейкера
        metod_sheikera(array, amount);                //

    }

    public static void metod_sheikera(int[] a,int n) {

        int cos=0;
        int leftMark = 1;
        int rightMark = n - 1;
        while (leftMark <= rightMark) {
            for (int i = rightMark; i >= leftMark; i--)
                if (a[i - 1] > a[i]) swapEl(a, i);
            leftMark++;


            for (int i = leftMark; i <= rightMark; i++)
                if (a[i - 1] > a[i]) swapEl(a, i);
            rightMark--;

            cos++; // просмотр количества итераций
        }
        for (int i=0;i<n;i++)
            System.out.print(a[i]+",");
        System.out.println();
        System.out.println("Кол-во операций:"+cos);

    }

    public static void swapEl(int[] arr, int i)
    {
        int buff;
        buff = arr[i];
        arr[i] = arr[i - 1];
        arr[i - 1] = buff;
    }
}