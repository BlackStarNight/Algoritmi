import java.util.Random;

public class Lab2_sort4_end {

    public static int ARRAY_LENTH = 30;
    public static int cos = 0;
    private static int[] array = new int[ARRAY_LENTH];
    private static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Введите размер массива:"); //"Вводим массив"

        for (int i = 0; i < ARRAY_LENTH; i++) {
            array[i] = random.nextInt(1014);
            array[i] = array[i] - 123;//Заполняем рандомными числами
        }
        for (int i = 0; i < ARRAY_LENTH; i++)
            System.out.print(array[i] + ",");           //Выводим полученный массив


        System.out.println();                        //
        System.out.println("Сортировка быстрая:");//Метод сортировки Шейкера
        int i = 0, j = ARRAY_LENTH - 1;
        fast_metod(i, j);                //

        for (i = 0; i < ARRAY_LENTH; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
        System.out.println("Количество операций:"+cos);
    }

    public static void fast_metod(int st, int fin) {
        if (st >= fin)
            return;
        int n=(fin+1)-st;
        int sep1, sep2;
        if (n % 3 != 0) {
            sep1 = (n / 3);
            sep2 = ((n / 3) * 2) + 1;
        } else {                           //Задаются апорные элементы
            sep1 = n / 3 - 1;
            sep2 = n / 3 * 2;
        }
        sep1+=st;
        sep2+=st;
        cheak_sep(sep1, sep2);


        sep1 = sort(sep1,st,sep2-1);

        sep2 = sort(sep2,sep1+1,fin);

        sep1 = sort(sep1,st,sep2-1);

        fast_metod(st,sep1);
        fast_metod(sep1+1,sep2);
        fast_metod(sep2+1,fin);

    }



    public static int sort(int cur,int start,int end) {
        if (start >=cur)
            return cur;
        int i = start, j = end;
        while (i < j) {
            while (i < cur && (array[i] <= array[cur])) {
                i++;
            }
            while (j > cur && (array[cur] <= array[j])) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        cos++;
        return cur;
    }

    public static void cheak_sep(int sep1,int sep2){
        if (array[sep1]>array[sep2]){            //Проверка опорных элементов
            swap(sep1,sep2);
        }
    }

    public static void swap(int i,int j){  //Перестановка элементов
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}