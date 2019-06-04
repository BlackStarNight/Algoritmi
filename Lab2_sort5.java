import java.util.*;
import java.lang.*;



public class Lab2_sort5 {

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
        System.out.println("Сортировка пирамидальная:");//Метод сортировки Шейкера
        HeapSortAlgorithm.sort(array);                //

        for (int i=0;i<amount;i++)
            System.out.print(array[i]+",");         //Вывод отсартировонного массива
        System.out.println();


    }
}

class HeapSortAlgorithm {
    public static int cos = 0;

    //Сортировка кучей
    static void sort(int a[]) {

        int N = a.length;

        //Создаём из массива сортирующее дерево
        //Максимальный элемент окажется в корне.
        for (int k = N / 2; k > 0; k--) downheap(a, k, N);

        //Избавляемся от максимумов
        //и перетряхиваем сортирующее дерево
        do {

            //Меняем максимум с последним элементом...
            int T = a[0];
            a[0] = a[N - 1];
            a[N - 1] = T;

            //... и перестравиваем сортирующее дерево
            //для неотсортированной части массива
            N = N - 1;
            downheap(a, 1, N);

        } while (N > 1); //До последнего элемента

        System.out.println("Количество операций:"+cos);
    }

    //Просматриваем ветку и в её корень перемещаем наибольший узел
    static void downheap(int a[], int k, int N) {

        //В корне поддерева
        //запоминаем родителя
        int T = a[k - 1];

        //Смотрим потомков в пределах ветки
        while (k <= N / 2) {

            int j = k + k;//Левый потомок

            //Если есть правый потомок,
            //то сравниваем его с левым
            //и из них выбираем наибольший
            if ((j < N) && (a[j - 1] < a[j])) j++;

            //Если родитель больше (или равен) наибольшего потомка...
            if (T >= a[j - 1]) {

                //... то значит всё в порядке в этой ветке
                break;

            } else { //Если родитель меньше наибольшего потомка...

                //... то потомок становится на место родителя
                a[k - 1] = a[j - 1];
                k = j;

            }
        }

        //Родитель в итоге меняется местами с наибольшим из потомков
        //(или остаётся на своём месте, если все потомки меньше его)
        a[k - 1] = T;
        cos++;

    }

}