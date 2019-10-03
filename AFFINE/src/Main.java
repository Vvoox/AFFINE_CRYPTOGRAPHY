

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class Main {
    static int counter = 0;
    static StringBuilder output=new StringBuilder();

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
            System.out.print("If you have the two keys enter 'YES' , else 'NO' : ");
            Scanner ss1 = new Scanner(System.in);
            String key = ss1.nextLine();
            if(key.equals("YES")){
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
            else {
                System.out.print("Enter your text : ");
                Scanner ss = new Scanner(System.in);
                String text = ss.nextLine();
                Brute_Force_affine(text);

            }

        }
        System.out.println("\n");
        //dict();


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
        //int counter = 0;
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
    public static void Brute_Force_affine(String text) {

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
        System.out.print("\n");
        for (int j = 0; j < tab.length; j++) {

            System.out.print(tab1[j]);
        }

        int fct = 0;
        System.out.print("\n");
        int k11 = 0;
        //int k2=0;
        int product = 0;
        for(int k1=0 ; k1<26; k1++) {
            for (int k2 = 0; k2 < 26; k2++) {
                for (int i = 0; i < 26; i++) {

                    product = k1 * i;
                    if (product % 26 == 1) {
                        k11 = i;
                       // System.out.print("A="+k1+",");
                        //System.out.print("B="+k2+" ");
                        for (int j = 0; j < text.length(); j++) {

                            fct = k11 * (Integer.valueOf(tab1[j]) - k2);

                            fct = fct % 26;
                               // System.out.println(fct);
                            if (fct < 0) {

                                fct = fct + 26;
                            }

                            tab2[j] = CODE[fct];
                            //System.out.print(CODE[fct]);

                        }
                        /*for (int p = 0; p < tab2.length; p++) {

                            System.out.print(tab2[p]);


                        }*/
                        System.out.println("\n");
                        for (int wrd = 3; wrd < 7; wrd++) {
                        dict(tab2,k1,k2,wrd);}
                    }


                        }


                }

        }
        System.out.println(counter);
        System.out.println(output);
        //show

    }
    //rllqqpxelrzetlmzjqzp
    public static int[] dict(String[] tab,int A , int B,int wrd) {

        // The name of the file to open.
        String fileName = "C:\\Users\\yama-\\Desktop\\CRYPTO\\src\\words.txt";

        StringBuilder text1 = new StringBuilder();
        String out="";
        int[] coef_dic = new int[2];

            for (int i = 0; i < wrd; i++) {
                //if(wrd>text1.length()){break;}
                text1.append(tab[i]);
            }
            //System.out.println(text1);
            String text2 = text1.toString();
            // This will reference one line at a time
            String line = null;

            try {

                FileReader fileReader =
                        new FileReader(fileName);


                BufferedReader bufferedReader =
                        new BufferedReader(fileReader);

                while ((line = bufferedReader.readLine()) != null) {

                    if (text2.equals(line)) {
                        out = "The word found is  :" + text1 +" | in A = "+A+" and B = "+B +" |";
                        // System.out.println(out);
                       // System.out.println("in A = " + A + " and B = " + B);
                        coef_dic[0] = A;
                        coef_dic[1] = B;
                        counter += 1;
                        output.append(out);
                        output.append("\n");

                    }

                }
                // System.out.println(counter);


                bufferedReader.close();
            } catch (FileNotFoundException ex) {
                System.out.println(
                        "Unable to open file '" +
                                fileName + "'");
            } catch (IOException ex) {
                System.out.println(
                        "Error reading file '"
                                + fileName + "'");


            }

            return coef_dic;


    }


    public static void show(String text , int A  , int B){


    }
}






