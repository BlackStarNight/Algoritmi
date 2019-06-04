import java.util.Random;
import java.util.Scanner;

public class Lab2_sort2 {
    public static void main(String[] args) {
        System.out.println("Введите размер массива:"); //"Вводим массив"
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        int amount = in.nextInt();                     //Указываем кол-во элементов масива
        int[] array = new int[amount];                 //Создаем сам массив
        int[] arr_rem = new int[amount];
        for (int i = 0; i < amount; i++) {
            array[i] = random.nextInt(1014);
            array[i] = array[i] - 123;//Заполняем рандомными числами
        }
        for (int i = 0; i < amount; i++)
            System.out.print(array[i] + ",");           //Выводим полученный массив


        System.out.println();                        //
        System.out.println("Сортировка включением:");//Метод сортировки Включения
        metod_vkluch(array, amount);                //

    }

  /*  public static void vkluchenia_int(int[] a,int n) {

        int j = 0, r, cos = 0, k = 0;
        while (k < n) {
            for (int i = 2; i < n; i++) {
                r = a[0];                     //Сам метод
                a[0] = a[i];
                j = i;
                while (a[0] < a[j - 1]) {
                    a[j] = a[j - 1];
                    j--;
                    cos++;
                }
                a[j] = r;
            }

            r = a[0];                          // Я не знал как исправить запару с первым элементом
            for (int i = 0; i < n - 1; i++) {               // по этому я просто таким не хитрым способом переставляю
                a[i] = a[i + 1];                   // его в конец
                cos++;                         //
            }                                  //
            a[n - 1] = r;                        //
            k++;
        }

        for (int i=0;i<n;i++)
            System.out.print(a[i]+",");
        System.out.println();
        System.out.println("Кол-во операций:"+cos);
    }*/

    public static void metod_vkluch(int[] a,int n){

        int i, j, Tmp,cos=0;
        for (i= 1;i<n;i++) {
            Tmp = a[i];
            j = i;
            while ((a[j - 1] > Tmp) && (j > 0)) {
                a[j] =a[j - 1];
                j =j - 1;
                cos++;
                if (j==0)break;
            }
            a[j] =Tmp;

        }
        for (i=0;i<n;i++)
            System.out.print(a[i]+",");
        System.out.println();
        System.out.println("Кол-во операций:"+cos);
    }
}