import java.util.Arrays;
import java.util.Random;

// 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
// 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
// 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
// 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2

public class Homework1 {

    public static void main(String[] args) {
        
        int i = get_random();
        int n = get_bit(i);
// Задача 3 
        short[] m1 = get_arraym1(n, i);
        System.out.println("Массив m1" + Arrays.toString(m1));
// Задача 4
        short[] m2 = get_arraym2(n, i);
        System.out.println("Массив m2" +Arrays.toString(m2));
// Задача 1
        System.out.println("i = " + i);   //Изменила последовательность вывода Задач, чтобы был виден ответ на 1 и 2
// Задача 2
        System.out.println("n = " + n);
    }
    
    static int get_random(){   
        return new Random().nextInt(0,2001);
    }

    static int get_bit(int i){
        return Integer.toBinaryString(i).length();    
    }

    static short[] get_arraym1(int n, int i){
        int n0 = ((i - 1) / n + 1) * n;
        int n1 = (Short.MAX_VALUE / n) * n;
        short[] array = new short[(n1 - n0) / n + 1];
        for (int l = n0; l <= n1; l += n) {
            array[(l - n0) / n] = (short) l;
        }
        return array;
    }

    static short[] get_arraym2(int n, int i){
        int k = (i  / n ) + (Short.MIN_VALUE / n ) * (-1) + 1;
        short[] array = new short[i - Short.MIN_VALUE + 1 - k];
        int m = 0;
        for (int l = Short.MIN_VALUE; l <= i; l++) {
            if (l % n != 0) {
                array[m] = (short) l;
                m++;
            }
        }
        return array;
    }
}