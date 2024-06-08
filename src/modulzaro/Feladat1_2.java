// Laszlo Mihaly Daniel

package modulzaro;

import java.util.Random;
import java.util.Scanner;

public class Feladat1_2 {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static int[] arr;
    static int[][] matrix;
    public static void main(String[] args) {
        programozoiTetelek();
        adatszerkezetTomb();
    }

    private static void adatszerkezetTomb() {
        System.out.println("Add meg a matrix meretet: ");
        int db = scanner.nextInt();
        matrix = matrixGeneralas(db);
        matrixKiiras(matrix);

        int[][] invertedMatrix = matrixInvertalas(matrix);
        System.out.println("\nInvertált mátrix:");
        matrixKiiras(invertedMatrix);
    }

    private static void programozoiTetelek() {
        System.out.println("Add meg a feltolteshez a tomb hosszat::");
        int db = scanner.nextInt();
        felTolt(db);

        System.out.println("Add meg az oszlopok szamat a kiirashoz:");
        int oszlop = scanner.nextInt();
        kiir(oszlop);

        System.out.println("Osszegzes:" + osszegzes());
        System.out.println("Nullak szama: " + megszamlalas());
        System.out.println("Legkisebb ertek helye: " + minHely());
        System.out.println("Legnagyobb ertek helye: " + maxHely());
        if (kivalasztas() == -1) {
            System.out.println("Nem talalhato 5-tel oszthato szam a tombben");
        } else {
            System.out.println("Elso 5-tel oszthato elem helye: " + kivalasztas());
        }
        System.out.println("Van-e tokeletes szam: " + eldontesEgy());
        System.out.println("Tomb elemei novekvo sorrendben: " + eldontesMind());
        if ( linKer() == -1) {
            System.out.println("13-as szam helye: nem talalhato az ertek a tombben");
        } else {
            System.out.println("13-as szam helye: " + linKer());
        }

    }

    public static int velSzam(int also, int felso) {
        if (also >= felso) {
            throw new IllegalArgumentException("Az also hatar nem lehet nagyobb a felso hatarnal!");
        }
        return random.nextInt(also, felso);
    }

    public static void felTolt(int db) {
        arr = new int[db];
        System.out.print("Adja meg az alsó határt: ");
        int also = scanner.nextInt();

        System.out.print("Adja meg a felső határt: ");
        int felso = scanner.nextInt();

        for (int i = 0; i < db; i++) {
            arr[i] = velSzam(also, felso);
        }
    }

    public static void kiir(int oszlop) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%-5d", arr[i]);

            if ((i + 1) % oszlop == 0) {
                System.out.println();
            }
        }

        if (arr.length % oszlop != 0) {
            System.out.println();
        }
    }

    public static int osszegzes() {
        int osszeg = 0;
        for (int elem: arr) {
            osszeg += elem;
        }
        return osszeg;
    }

    public static int megszamlalas() {
        int db = 0;
        for (int elem: arr) {
            if (elem == 0) {
                db++;
            }
        }
        return db;
    }

    public static int minHely() {
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int maxHely() {
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static int kivalasztas() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 5 == 0) {
                return i;
            }
        }
        return -1;
    }

    public static boolean eldontesEgy() {
        for (int elem: arr) {
            if (tokeletesElem(elem)) {
                return true;
            }
        }
        return false;
    }

    public static boolean tokeletesElem(int szam) {
        if (szam < 2) return false;
        int osszeg = 1;
        for (int i = 2; i <= Math.sqrt(szam); i++) {
            if (szam % i == 0) {
                osszeg += i;
                if (i != szam / i) {
                    osszeg += szam /i;
                }
            }
        }
        return osszeg == szam;
    }

    public static boolean eldontesMind() {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static int linKer() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 13) {
                return i;
            }
        }
        return -1;
    }

    public static int[][] matrixGeneralas(int db) {
        int[][] matrix = new int[db][db];
        for (int i = 0; i < db; i++) {
            matrix[i][i] = random.nextInt(100);
        }
        return matrix;
    }

    public static void matrixKiiras(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] matrixInvertalas(int[][] matrix) {
        int[] atloErtekek = atloErtekei(matrix);
        int min = atloErtekek[0];
        int max = atloErtekek[1];


        int[][] invertMatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    invertMatrix[i][j] = 0;
                } else {
                    invertMatrix[i][j] = random.nextInt((max - min) + 1) + min;
                }
            }
        }

        return invertMatrix;
    }

    public static int[] atloErtekei(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            int value = matrix[i][i];
            min = Math.min(min, value);
            max = Math.max(max, value);
        }

        return new int[]{min, max};
    }

}
