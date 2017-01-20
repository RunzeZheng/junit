import java.util.Scanner;

/**
 * Created by runze on 9/22/16.
 */
public class ConvertMoney {

    public static void main(String[] args) {

        String result;
        System.out.println("Enter an amount: ");
        Scanner sc = new Scanner(System.in);
        while(true) {
            try {
                if (sc.hasNext()) {
                    String value = sc.next();
                    if (value.equals("")) {
                        System.out.println("Enter an amount.");
                        sc = new Scanner(System.in);

                    } else if (Double.parseDouble(value) < 0) {
                        System.out.println("The amount must be larger than 0.");
                    } else {
                        result = convert(value);
                    }
                }
            } catch (Exception e) {
                System.out.println("program error");
                System.out.println(e);
            }
        }

    }

    public static String convert(String a){
        double amount = Double.parseDouble(a);
        String cents = "";
        String dollars;
        String[] array = {"","","","","",""};
        String fractionResult = "";
        String onesResult = "";
        String tensResult = "";
        String hundredsResult = "";
        String thousandsResult = "";
        String tensThousandsResult = "";
        String hundredThousandsResult = "";
        String intAnd = "";
        String fractionAnd = "";
        String finalString;

        if (amount > 1000000){
            System.out.println("The number entered is too large. The max is 1 million.");
            return "out of range.";
        }else if (amount == 1000000){
          System.out.println("one million dollar(s).");
            return "one million dollar(s).";
        }else if (amount == 0){
            System.out.println("zero dollar(s).");
            return "zero dollar(s).";
        }else {
            if(a.contains(".")){
                int decimalPointIndex = a.indexOf(".");
                cents = a.substring(decimalPointIndex+1); //cents
                dollars = a.substring(0,decimalPointIndex);//dollars
            }else {
                dollars = a;//dollars
            }
            for(int i=0; i < dollars.length(); i++){
                array[i] = String.valueOf(dollars.charAt(dollars.length() - i - 1));//read from right
            }

            for (int i= 0 ; i < array.length; i++){
                if (!array[i].equals("") && !array[i].equals("0")){
                    switch (i){
                        case 0://1s
                            onesResult = toWord(array[i]);
                            break;
                        case 1://10s
                            if (array[i].equals("1")){
                                onesResult = "";
                            }
                            tensResult = toWordTens(array[i], array[i-1]);
                            break;
                        case 2://100s
                            hundredsResult = toWord(array[i]) + " hundred";
                            break;
                        case 3://1000s
                            thousandsResult = toWord(array[i]) + " thousand";
                            break;
                        case 4://10000s
                            if (array[i].equals("1")){
                                thousandsResult = " thousand";
                            }
                            tensThousandsResult = toWordTens(array[i], array[i-1]) + " " + thousandsResult;
                            thousandsResult = "";
                            break;
                        case 5://100000s
                            hundredThousandsResult = toWord(array[i]) + " hundred";

                    }
                }
            }
            if (!cents.equals("")){
                fractionResult = cents + "/100";
                fractionAnd = " and";
            }else{
                if (dollars.length() > 2 && (!array[0].equals("0") || !array[1].equals("0")) && amount > 100) {
                    intAnd = " and";
                }
            }
            finalString = hundredThousandsResult + " " + tensThousandsResult + " " + thousandsResult +  " " +
                    hundredsResult +  " " + intAnd + " " + tensResult +  " " + onesResult + " " + fractionAnd + " " +
                    fractionResult + " dollar(s).";
            finalString = finalString.trim().replaceAll(" +", " ");
            System.out.println(finalString);

        }
        return finalString;
    }

    private static String toWord(String a){
        String word= "";
        switch (a){
            case "1":
                word = "one";
                break;
            case "2":
                word = "two";
                break;
            case "3":
                word = "three";
                break;
            case "4":
                word = "four";
                break;
            case "5":
                word = "five";
                break;
            case "6":
                word = "six";
                break;
            case "7":
                word = "seven";
                break;
            case "8":
                word = "eight";
                break;
            case "9":
                word = "nine";
                break;
        }
        return word;
    }

    private static String toWordTens(String a, String i){
        String word= "";
        switch (a){
            case "1":
                switch (i){
                    case "0":
                        word = "ten";
                        break;
                    case "1":
                        word = "eleven";
                        break;
                    case "2":
                        word = "twelve";
                        break;
                    case "3":
                        word = "thirteen";
                        break;
                    case "4":
                        word = "fourteen";
                        break;
                    case "5":
                        word = "fifteen";
                        break;
                    case "6":
                        word = "sixteen";
                        break;
                    case "7":
                        word = "seventeen";
                        break;
                    case "8":
                        word = "eighteen";
                        break;
                    case "9":
                        word = "nineteen";
                        break;
                }
                break;
            case "2":
                word = "twenty";
                break;
            case "3":
                word = "thirty";
                break;
            case "4":
                word = "forty";
                break;
            case "5":
                word = "fifty";
                break;
            case "6":
                word = "sixty";
                break;
            case "7":
                word = "seventy";
                break;
            case "8":
                word = "eighty";
                break;
            case "9":
                word = "ninety";
                break;
        }
        return word;
    }
}
