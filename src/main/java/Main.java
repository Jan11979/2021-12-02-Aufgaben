import java.util.Scanner;
import java.util.Arrays;
import java.util.Locale;


public class Main {

    public static Scanner scanner = new Scanner(System.in);


    public static void print(String what) {
        System.out.println(what);
    }

    public static void main(String[] args) {

/*
        print("Level: Novice");
        //Level: Novice
        //Schreibe ein Programm das deinen Namen ausgibt.
        printMyName();
        //Lasse den Namen mit Hilfe einer Schleife 5 mal ausgeben.
        printMyNameTakeFive();
        //Schreibe eine Methoden die prüft ob eine Zahl größer als 0 ist.
        int iIsBiggerThenZeroNumber = 0;
        System.out.println(iIsBiggerThenZeroNumber + "getIsBiggerThenZero = " + Main.getIsBiggerThenZero(iIsBiggerThenZeroNumber++) );
        System.out.println(iIsBiggerThenZeroNumber + "getIsBiggerThenZero = " + getIsBiggerThenZero(iIsBiggerThenZeroNumber) );
        //Schreibe eine Methode die das Quadrat einer Zahl berechnet.
        System.out.println("Quadrat von " + 10 + " ist " + getQuadratOf(10));
        //Schreibe ein Programm das den Namen des Nutzers einliest (Scanner) und ihn mit Namen begrüßt.
        halloDuMitScanFunktion();

        print("Level: Intermediate");
        //Level: Intermediate
        //Fülle einen String-Array mit den Zahlenwörtern "Eins" bis "Zehn"
        printOneToTenInStringArray();

        //Schreibe eine Methode die zu einer einstelligen Zahl das entsprechende Zahlenwort ausgibt.
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " ist " + getNumberTextOf(i));

        }
        //Schreibe ein Programm das die Zahlen 1-100 ausgibt, aber:
        //Vor Zahlen die durch 3 teilbar sind (modulo) soll ein # stehen
        //Vor Zahlen die durch 5 teilbar sind soll ein $ stehen
        do1ti100withBonus();

        //Schreibe ein Programm die Wörter vom Benutzer einliest (Scanner) und diese in einem Array speichert.
        //Gib vor jeder Eingabe jeweils die eingegebenen Wörter noch mal aus.
        StartNameList();


        //  Level: Expert
        //    Schreibe eine Methode die einen Eingabestring rückwärts ausgibt.
        String sName = scanner.nextLine().toLowerCase(Locale.GERMAN);
        System.out.println(sName + " ist " + getTurnAroundString(sName));

        // Gibt den folgenden Array aufsteigend sortiert aus: {6, 2, 8, 3, 9, 6}
        doSortArrayTest();
 */
        //Schreibe eine Methode die einen String nach , separiert und als Array zurück gibt.
        String[] sArrayCut = getStringsInPeaceEse("Hallo,Welt");
        System.out.println( sArrayCut[0] + " und " + sArrayCut[1] );

        //Schreibe eine Methode die die Quersumme einer Ganzzahl berechnet.
        System.out.println("Quersumme von " + 42 + " ist " +getQuersumme(42) );
        System.out.println("Quersumme von " + 123123 + " ist " +getQuersumme(123123) );

        //Gib eine Ganzzahl (1-100) als römische Zahl aus (12 = XII)
        System.out.println("römische " + 42 + " ist " + getRomanski(42) );
        System.out.println("römische " + 46 + " ist " + getRomanski(46) );
        System.out.println("römische " + 289542 + " ist " + getRomanski(289542) );
    }

    /**
     * Level: Intermediate
     * Gib eine Ganzzahl (1-100) als römische Zahl aus (12 = XII)
     * Großbuchstaben	I	V	X	L	C	D	M	    ↁ	    ↂ	    ↇ	    ↈ
     * Wert	            1	5	10	50	100	500	1000	5000	10.000	50.000	100.000
     *                                                                  K       P  (Hab ich mir ausgedacht wegen "Zeichen gibt es nicht")
     */
    public static String getRomanski(long lZahl){
        String sReturn = "";
        String [] sRList = {"I", "V", "X", "L", "C", "D", "M", "ↁ", "ↂ", "K", "P" };
        long[]    lNList = {1,5,10,50,100,500,1000,5000,10000,50000,100000 } ;
        int iIndexSize = 11;
        int iIndex = 0;
        for(int i=iIndexSize-1; i >= 0; i--){
            if(lZahl >= lNList[i])
            {
                long lRest = lZahl % lNList[i];
                long lTemp = lRest;
                lZahl = lZahl - lRest;
                lZahl = lZahl / lNList[i];
                for(; lZahl>0; lZahl--)
                {
                    sReturn += sRList[i];
                }
                lZahl = lTemp;
            }
        }
        return sReturn;
    }



    /**
     * Level: Intermediate
     * Schreibe eine Methode die die Quersumme einer Ganzzahl berechnet.
     */
    public static int getQuersumme(int iZahl) {
        int iQuersumme = 0;
        while(iZahl != 0) {
            int rest = iZahl % 10;
            iZahl -= rest;
            if (iZahl >= 10)
                iZahl = iZahl / 10;
            iQuersumme += rest;
        }
        return iQuersumme;
    }


    /**
     * Level: Intermediate
     * Schreibe eine Methode die einen String nach , separiert und als Array zurück gibt.
     */
    public static String[] getStringsInPeaceEse(String ssToCut) {
        String [] sRetArray =  new String[2];
        sRetArray[0] = "";
        sRetArray[1] = "";
        int iIndex = 0;
        while (ssToCut.length() > 0) {
            String sTemp = ssToCut.substring(0, 1);
            if ((sTemp.equals(",")) && (iIndex == 0)) {
                iIndex = 1;
            }
            else{
                sRetArray[iIndex] += sTemp;
            }
            ssToCut = ssToCut.substring(1, ssToCut.length());
        }

        return sRetArray;
    }



    /**
     * Level: Intermediate
     * Gibt den folgenden Array aufsteigend sortiert aus: {6, 2, 8, 3, 9, 6}
     */
    public static void doSortArrayTest() {
        int iSize = 5;
        int[] words = {6, 2, 8, 3, 9, 6};

        for(int i=0; i < iSize; i++)
            System.out.print( words[i] + ", ");
        System.out.println("");


        for (int i = 0; i <= (iSize-1); ) {

            if ( words[i] > words[i+1] ){
                int cTemp1 = words[i];
                int cTemp2 = words[i+1];
                words[i] = cTemp2;
                words[i+1] = cTemp1;
                i = 0;
            }
            else
                i++;

        }
        for(int i=0; i < iSize; i++)
            System.out.print(words[i] + ", ");
        System.out.println("");

    }

    /**
     * Level: Intermediate
     * Schreibe eine Methode die einen Eingabestring rückwärts ausgibt.
     */
    public static String getTurnAroundString(String sString) {
        String sReturnString = "";

        while (sString.length() > 0) {
            //if(sReturnString.length() == 0)
            sReturnString += sString.substring(sString.length() - 1, sString.length());
            sString = sString.substring(0, sString.length() - 1);
        }

        return sReturnString;
    }

    /**
     * Level: Intermediate
     * Schreibe ein Programm die Wörter vom Benutzer einliest (Scanner) und diese in einem Array speichert.
     * Gib vor jeder Eingabe jeweils die eingegebenen Wörter noch mal aus.
     */

    public static boolean bKlaus = false;
    public static String[] sNameListArray;
    public static int iNameListSize = 0;

    public static String getName() {
        while (true) {
            System.out.println("Deinen Namen Bitte: (klaus ist Raus)");
            String sName = scanner.nextLine().toLowerCase(Locale.GERMAN);
            if (sName.length() > 0) {
                if (sName.equals(String.valueOf("klaus"))) {
                    bKlaus = true;
                    return "klaus";
                } else
                    return sName;

            }
        }
    }

    public static void StartNameList() {

        while (true) {
            String sName = getName();

            if (iNameListSize == 0) {
                sNameListArray = new String[1];
                sNameListArray[0] = sName;
                iNameListSize++;
            } else {
                String[] tempNameListArray = new String[iNameListSize];
                for (int i = 0; i < iNameListSize; i++)
                    tempNameListArray[i] = sNameListArray[i];

                // In Java macht der garbage collector jas ja alles Tutti (Hoffentlich)
                sNameListArray = new String[iNameListSize + 1];
                for (int i = 0; i < iNameListSize; i++)
                    sNameListArray[i] = tempNameListArray[i];

                sNameListArray[iNameListSize] = sName;
                iNameListSize++;
            }

            for (int i = 0; i < iNameListSize; i++) {
                System.out.println("Hallo " + sNameListArray[i]);
            }

            if (bKlaus)
                return;
        }

    }


    /**
     * Level: Intermediate
     * Fülle einen String-Array mit den Zahlenwörtern "Eins" bis "Zehn"
     */
    public static void printOneToTenInStringArray() {
        String[] stringArray = new String[10];
        for (int i = 0; i < 10; i++) {
            switch (i + 1) {
                case 1:
                    stringArray[i] = "Eins";
                    break;
                case 2:
                    stringArray[i] = "Zwei";
                    break;
                case 3:
                    stringArray[i] = "Drei";
                    break;
                case 4:
                    stringArray[i] = "Vier";
                    break;
                case 5:
                    stringArray[i] = "Fuenf";
                    break;
                case 6:
                    stringArray[i] = "Sechs";
                    break;
                case 7:
                    stringArray[i] = "Sieben";
                    break;
                case 8:
                    stringArray[i] = "Acht";
                    break;
                case 9:
                    stringArray[i] = "Neune";
                    break;
                case 10:
                    stringArray[i] = "Zehn";
                    break;
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(stringArray[i]);
        }

    }

    /**
     * Level: Intermediate
     * Schreibe eine Methode die zu einer einstelligen Zahl das entsprechende Zahlenwort ausgibt.
     */
    public static String getNumberTextOf(int i) {
        switch (i) {
            case 1:
                return "Eins";

            case 2:
                return "Zwei";

            case 3:
                return "Drei";

            case 4:
                return "Vier";

            case 5:
                return "Fuenf";

            case 6:
                return "Sechs";

            case 7:
                return "Sieben";

            case 8:
                return "Acht";

            case 9:
                return "Neune";

            case 0:
                return "Null";
        }
        return "Nö";
    }

    /**
     * Level: Intermediate
     * Schreibe ein Programm das die Zahlen 1-100 ausgibt, aber:
     * Vor Zahlen die durch 3 teilbar sind (modulo) soll ein # stehen
     * Vor Zahlen die durch 5 teilbar sind soll ein $ stehen
     */
    public static void do1ti100withBonus() {
        for (int i = 1; i < 100; i++) {
            if ((i % 10) == 0)
                System.out.print("\n");
            if ((i % 3) == 0)
                System.out.print("#" + ", ");
            else if ((i % 5) == 0)
                System.out.print("$" + ", ");
            else
                System.out.print(i + ", ");
        }
    }


    /**
     * Level: Novice
     * Schreibe ein Programm das deinen Namen ausgibt.
     */
    public static void printMyName() {
        System.out.println("Jan");
    }

    /**
     * Level: Novice
     * Lasse den Namen mit Hilfe einer Schleife 5 mal ausgeben.
     */
    public static void printMyNameTakeFive() {
        for (int i = 0; i < 5; i++)
            printMyName();
    }

    /**
     * Level: Novice
     * Schreibe eine Methoden die prüft ob eine Zahl größer als 0 ist.
     */
    public static boolean getIsBiggerThenZero(int i) {
        return (i > 0);
    }

    /**
     * Level: Novice
     * Schreibe eine Methode die das Quadrat einer Zahl berechnet.
     */
    public static int getQuadratOf(int i) {
        return (i * i);
    }

    /**
     * Level: Novice
     * Schreibe ein Programm das den Namen des Nutzers einliest (Scanner) und ihn mit Namen begrüßt.
     */
    public static void halloDuMitScanFunktion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Deinen Namen Bitte:");
        String sName = scanner.nextLine();
        if (sName.length() > 0) {
            System.out.println("Hallo " + sName);
        } else
            System.out.println("Hallo unbekannter User");
    }


}



