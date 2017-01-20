import static org.junit.Assert.*;

/**
 * Created by runze on 9/22/16.
 */
public class ConvertMoneyTest {
    @org.junit.Test
    public void main() throws Exception {

    }

    @org.junit.Test
    public void convert() throws Exception {
        String[] input = {"918716.89", "100", "10", "1000000", "0", "123", "999999999999"};
        String[] output = {"","","","","","",""};
        String[] expected = {"nine hundred eighteen thousand seven hundred sixteen and 89/100 dollar(s).",
                "one hundred dollar(s).",
                "ten dollar(s).",
                "one million dollar(s).",
                "zero dollar(s).",
                "one hundred and twenty three dollar(s).",
                "out of range."};
        for (int i=0;i < input.length; i++) {
            output[i] = ConvertMoney.convert(input[i]);
            assertEquals(expected[i], output[i]);
        }
    }

    @org.junit.Test
    public void toWord() throws Exception {

    }

    @org.junit.Test
    public void toWordTens() throws Exception {

    }

}