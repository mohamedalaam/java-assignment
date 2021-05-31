import joinery.DataFrame;

import java.io.IOException;
import java.util.Date;

public class joinery_Ex {
    public static void main(String args[]){
        try {

            DataFrame<Object>  df1= DataFrame.readCsv ("src/main/resources/titanic.csv")
                    .describe ();
           System.out.println (df1.toString ());
            System.out.println ("=========================================================================================");
            DataFrame<Object>  dfl= df1.retain("pclass","age");
            System.out.println (dfl.toString ());
            DataFrame<Object>  dfr= df1 .retain("pclass","sibsp","parch","body");
            System.out.println (dfr.toString ());

            DataFrame<Object>dfj=dfr.join(dfl);
            System.out.println (dfj.toString ());



            System.out.println ("=========================================================================================");
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}