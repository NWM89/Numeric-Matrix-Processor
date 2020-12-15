import java.util.Scanner;

import static java.lang.Math.min;

class Main {
    private static int n;
    static int[] a;

    /**
     * @param sum   Какая сумма осталась
     * @param limit Ограничение сверху (элемент который левее всего)
     * @param size  Сколько мы слагаемых уже поставили
     */
    private static void rec(int sum, int limit, int size) {
        // Остановка рекурсии
        if (sum == 0) {
            System.out.print(a[0]);
            for (int i = 1; i < size; i++) {
                System.out.print(" " + a[i]);
            }
            System.out.println();
            return;
        }
        // Раскладываем оставшуюся сумму
        for (int x = 1; x <= min(limit, sum); x++) {
            a[size] = x; // Поставили элемент x
            rec(sum - x, x, size + 1);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        rec(n, n, 0);
    }
}