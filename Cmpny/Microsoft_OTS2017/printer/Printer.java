package MS.OA2017.printer;

/**
 * Created by wtnwi on 1/13/2017.
 */
public class Printer {
    private static volatile Printer ins = null;
    public static Printer getIns(){
        if(ins==null){

                ins = new Printer();

        }
        return ins;
    }
}
