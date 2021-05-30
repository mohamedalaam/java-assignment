import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class countryDao {

        public List<countries> read_country(String file)
        {
            List<countries> ret = new ArrayList<>();
            try {
                int l=0;
                File myData= new File(file);
                Scanner myReader = new Scanner(myData);
                String data = myReader.nextLine();

                while (myReader.hasNextLine()) {
                    data = myReader.nextLine();
                    countries p=creat_c(data);
                    ret.add(p);
                }
                myReader.close();
            } catch ( FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            return  ret;
        }



        public countries creat_c(String per)
        {
            String[] data = per.split(",");
            String s="";



            return new countries(data[0],data[1]);
        }

    }

