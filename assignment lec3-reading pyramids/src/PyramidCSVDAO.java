
import javax.print.attribute.standard.MediaSize;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class PyramidCSVDAO {
    public List<pyramids>read_pyramid(String file)
    {
        List<pyramids> ret = new ArrayList<>();
        try {
            int l=0;
            File myData= new File(file);
            Scanner myReader = new Scanner(myData);
            String data = myReader.nextLine();

            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                pyramids p=creatP(data);
                ret.add(p);
            }
            myReader.close();
        } catch ( FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return  ret;
    }



    public pyramids creatP(String per)
    {
        String[] data = per.split(",");
        String s="";
        double d=Double.NaN;

        if (!data[7].isEmpty())
        {

           d= Double.parseDouble(data[7]);

        }

    return new pyramids(data[2],data[0], data[4],d);
    }

}
