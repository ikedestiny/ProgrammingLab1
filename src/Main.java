import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // 1. Создать одномерный массив c типа int. Заполнить его чётными числами от 2 до 18 включительно в порядке убывания.
        ArrayList<Integer> c = new ArrayList<>();
        int count = 0;
        for (int i = 18; i >= 2; i--) {
            if (i % 2 == 0) {
                c.add(i);
            }
        }
        System.out.println("Массив с: " + c);

        //2. Создать одномерный массив x типа float. Заполнить его 10-ю случайными числами в диапазоне от -6.0 до 14.0.
        float[] x = new float[10];
        for (int i = 0; i < 10; i++) {
            x[i] = floatGen(-6.0, 14.0);
        }
        System.out.println("Массив х: " + Arrays.toString(x));

        //3. Создать двумерный массив c размером 9x10. Вычислить его элементы по следующей формуле (где x = x[j])
        double[][] c2 = new double[9][10];
        System.out.println();
        for (int i = 0; i < 9; i++) {
            if (c.get(i) == 8) {
                for (int j = 0; j < 10; j++) {
                    c2[i][j] = calcJ(x[j]);
                }
            } else if (c.get(i) == 2 || c.get(i) == 10 || c.get(i) == 14 || c.get(i) == 18) {
                for (int j = 0; j < c2[i].length; j++) {
                    c2[i][j] = calcJ2(x[j]);
                }
            } else {
                for (int j = 0; j < c2[i].length; j++) {
                    c2[i][j] = calcJ3(x[j]);
                }
            }
        }

        //4. Напечатать полученный в результате массив в формате с двумя знаками после запятой.
        System.out.println("двумерный массив c2:".toUpperCase());
        for (var i : c2) {
            for (var element : i) {
                System.out.print(Math.round(element * 100.0) / 100.0 + ",");
            }
            System.out.println();
        }
    }
    public static float floatGen(double min, double max) {
        //this class generates random floats
        if (min > max) {
            throw new IllegalArgumentException("Invalid range [" + min + ", " + max + "]");
        }
        Random r = new Random();
        return (float) (min + r.nextFloat() * (max - min));
    }
    public static double calcJ(float x) {
        double cosX = 2 / Math.cos(Math.toRadians(x));
        double power = Math.pow(Math.cbrt(x), cosX);
        return power;
    }
    public static double calcJ2(float x) {
        double part1 = (Math.pow(x, (0.25 / (x + 1)))) - 1;
        double part2 = Math.atan(((double) (x + 4) / 2) * Math.E) + 1;
        double part3 = Math.log(Math.abs(x));
        return Math.sin(Math.pow(part3, (part1 * part2)));
    }
    public static double calcJ3(float x) {
        double part1 = 1 / (Math.exp(Math.abs(x)));
        return Math.cbrt(Math.log(Math.acos(part1)));
    }
}
