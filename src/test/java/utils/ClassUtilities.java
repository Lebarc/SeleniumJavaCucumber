package utils;

import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClassUtilities {

    public static boolean WaitForElementVisible(WebElement element, int timeoutSecond) {
        int count = 0;

        do {
            try {
                Thread.sleep(250);
                return element.isDisplayed() && element.isEnabled();

            } catch (Exception e) {
                count++;
            }

        } while (count < timeoutSecond * 4);

        return false;
    }

    private static int randomiza(int n) {
        return (int) (Math.random() * n);
    }

    private static int mod(int dividendo, int divisor) {
        return (int) Math.round(dividendo - (Math.floor(dividendo / divisor) * divisor));
    }

    public static String cpf(boolean comPontos) {
        int n = 9;
        int n1 = randomiza(n);
        int n2 = randomiza(n);
        int n3 = randomiza(n);
        int n4 = randomiza(n);
        int n5 = randomiza(n);
        int n6 = randomiza(n);
        int n7 = randomiza(n);
        int n8 = randomiza(n);
        int n9 = randomiza(n);
        int d1 = n9 * 2 + n8 * 3 + n7 * 4 + n6 * 5 + n5 * 6 + n4 * 7 + n3 * 8 + n2 * 9 + n1 * 10;

        d1 = 11 - (mod(d1, 11));

        if (d1 >= 10)
            d1 = 0;

        int d2 = d1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 * 11;

        d2 = 11 - (mod(d2, 11));

        String retorno;

        if (d2 >= 10)
            d2 = 0;
        retorno = "";

        if (comPontos)
            retorno = "" + n1 + n2 + n3 + '.' + n4 + n5 + n6 + '.' + n7 + n8 + n9 + '-' + d1 + d2;
        else
            retorno = "" + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + d1 + d2;

        return retorno;
    }

    public static String telefone(){
        long number = (long) (Math.random() * 9999999l);
        String telefone = Long.toString(number);

        return telefone;
    }

    public static String GerarDataEHora(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
