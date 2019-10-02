

import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sss = new Scanner(System.in);
        System.out.print("If you want to crypt choose 1 , else 2 : ");
        int choix = sss.nextInt();
        if(choix==1){
            System.out.print("Enter your text : ");
            Scanner ss = new Scanner(System.in);
            String text = ss.nextLine();
            System.out.print("Your first coeff :");
            Scanner sc = new Scanner(System.in);
            int k1 = sc.nextInt();
            System.out.print("Your second coeff : ");
            Scanner sc1 = new Scanner(System.in);
            int k2 = sc1.nextInt();
            crypt_affine(k1,k2,text);

        }
        else {
            System.out.print("Enter your text : ");
            Scanner ss = new Scanner(System.in);
            String text = ss.nextLine();
            System.out.print("Your first coeff :");
            Scanner sc = new Scanner(System.in);
            int k1 = sc.nextInt();
            System.out.print("Your second coeff : ");
            Scanner sc1 = new Scanner(System.in);
            int k2 = sc1.nextInt();
            decry_affine(k1 , k2 ,text);
        }


    }

    public static void crypt_affine(int k1, int k2, String text) {

        String[] CODE = new String[26];
        int[] CODE1 = new int[26];
        CODE = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        CODE1 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};


        String[] tab = text.split("");
        String[] tab1 = new String[text.length()];
        String[] tab2 = new String[text.length()];

        //int[] tab1 = new int[tab.length];
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if (tab[i].equals(CODE[j])) {

                    tab1[i] = String.valueOf(CODE1[j]);
                }
            }
        }

        int fct = 0;

        System.out.print("\n");
        for (int i = 0; i < tab.length; i++) {

            fct = (Integer.valueOf(tab1[i]) * k1) + k2;
            fct = fct % 26;
            tab2[i] = CODE[fct];

            fct = 0;

        }
        System.out.print("\n");
        for (int j = 0; j < text.length(); j++) {

            System.out.print(tab2[j]);
        }

    }

    public static void decry_affine(int k1 , int k2 , String text) {

        String[] CODE = new String[26];
        int[] CODE1 = new int[26];
        CODE = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        CODE1 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};


        String[] tab = text.split("");
        String[] tab1 = new String[text.length()];
        String[] tab2 = new String[text.length()];

        //int[] tab1 = new int[tab.length];
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if (tab[i].equals(CODE[j])) {

                    tab1[i] = String.valueOf(CODE1[j]);
                }
            }
        }

        int fct = 0;
        int counter = 0;
        System.out.print("\n");
        int k11 = 0;
        int product = 0;
            for (int i = 0; i < 26; i++) {

                product = k1 * i;
                if (product % 26 == 1) {
                    k11 = i;
                    break;
                }
        }
            for (int i = 0; i < tab.length; i++) {


                fct = k11 * (Integer.valueOf(tab1[i]) - k2);
                fct = fct % 26;

                if (fct < 0) {

                    fct = fct + 26;

                }

                tab2[i] = CODE[fct];
            }
            System.out.print("\n");
            for (int j = 0; j < tab.length; j++) {

                System.out.print(tab2[j]);
            }
            System.out.println("\n");
        }



    }
