import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class cityDao {
    public Map<String,List<cities>>m = new HashMap<>();
    public List<cities> read_city(String file)
    {
        List<cities> ret = new ArrayList<>();
        try {
            int l=0;
            File myData= new File(file);
            Scanner myReader = new Scanner(myData);
            String data = myReader.nextLine();

            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                cities p=creat_c(data);
                ret.add(p);
            }
            myReader.close();
        } catch ( FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return  ret;
    }



    public cities creat_c(String per)
    {
        String[] data = per.split(",");
        String s="";
        int d=Integer.parseInt(data[4]);
        int pop=Integer.parseInt(data[4]);
        cities c = new cities(data[0],data[1], data[2],d,pop);
            if (!m.containsKey(c.getCode()))
            m.put(c.getCode(),new ArrayList<>());
        m.get(c.getCode()).add(c);

        return c;
    }

}
