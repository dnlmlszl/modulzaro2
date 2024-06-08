// Laszlo Mihaly Daniel

package modulzaro;

public class Feladat3 {
    static String[] tabla = new String[]{"X", "X", "X", " ", "O", "O", "O"};

    public static void main(String[] args) {
        tablaKiir();
        while (!jatekVege()) {
            lepes();
        }

        System.out.println("Játék vége, Nyertél!");
    }

    private static void tablaKiir() {
        for (int i = 0; i < tabla.length; i++) {
            System.out.print(tabla[i] + " ");
        }
        System.out.println();
    }

    private static int lehetLepni() {
        int uresIndex = -1;

        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i].equals(" ")) {
                uresIndex = i;
                break;
            }
        }
        return uresIndex;
    }

    public static void lepes() {
        int uresIndex = lehetLepni();

        if (uresIndex != -1) {

            for (int i = 0; i < tabla.length; i++) {
                if (tabla[i].equals("O") && i > uresIndex) {
                    String temp = tabla[i];
                    tabla[i] = tabla[uresIndex];
                    tabla[uresIndex] = temp;
                    uresIndex = i;
                } else if (tabla[i].equals("X") && i < uresIndex) {
                    String temp = tabla[i];
                    tabla[i] = tabla[uresIndex];
                    tabla[uresIndex] = temp;
                    uresIndex = i;
                }
            }
        } else {

            tabla[tabla.length / 2] = " ";
        }
        tablaKiir();
    }


    private static boolean jatekVege() {
        return (tabla[0].equals("O") && tabla[1].equals("O") && tabla[2].equals("O")
                && tabla[3].equals(" ") && tabla[4].equals("X") && tabla[5].equals("X") && tabla[6].equals("X"));
    }
}

