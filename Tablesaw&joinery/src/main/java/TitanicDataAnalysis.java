
//import sun.tools.jconsole.Tab;
import tech.tablesaw.api.*;

import java.io.IOException;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TitanicDataAnalysis {
    Table titanicData;
    String dataPath = "src/main/resources/titanic.csv";

    public TitanicDataAnalysis() {
    }

    public static void main(String[] args) {
        TitanicDataAnalysis tda = new TitanicDataAnalysis ();
        try {
            tda.titanicData = Table.read ().csv (tda.dataPath);
            //getting the Structure of the data
            String structure = tda.titanicData.structure().toString();
            System.out.println (structure);
            //getting Data summery
            System.in.read ();
            String summary = tda.titanicData.summary().toString();
            System.out.println (summary);
            System.in.read ();
            // Adding date Column
            Table dataWithDate = tda.addDateColumnToData (tda.titanicData);
            System.out.println ("=====================================================================================");
            System.out.println (dataWithDate.structure ());
            System.in.read ();
            //add id
            Table joiningTable =tda.addID(tda.mapTextColumnToNumber(tda.titanicData));

            Table left = joiningTable.select("Fakeid","name","Pclass");
            summary = left.summary().toString();
            System.out.println (summary);
            System.in.read ();
            Table right =joiningTable.select("Fakeid","age","sex");
            summary = left.summary().toString();
            System.out.println (summary);
            System.in.read ();
            Table joined = left.joinOn("Fakeid").leftOuter(right);
            //getting the first 10 rows
            System.out.println ("Printing the first rows of the table");
            System.in.read ();
            Table firstTenRows = joined.first (50);

            System.out.println (firstTenRows);
            System.in.read ();

        } catch (IOException e) {
            e.printStackTrace ();
        }
    }




    public  Table addID(Table data){
        int rowCount = data.rowCount ();
        int[] a = IntStream.range(1, rowCount+1).toArray();;
        NumberColumn dateColumn = IntColumn.create ("Fakeid", a);
        data.insertColumn (data.columnCount (), dateColumn);
        return data;
    }
    public Table addDateColumnToData(Table data) {
        int rowCount = data.rowCount ();
        List<LocalDate> dateList = new ArrayList<LocalDate> ();
        for (int i = 0; i < rowCount; i++) {
            dateList.add (LocalDate.of (2021, 3, i % 31 == 0 ? 1 : i % 31));
        }
        DateColumn dateColumn = DateColumn.create ("Fake Date", dateList);
        data.insertColumn (data.columnCount (), dateColumn);
        return data;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // mapping text data to numeric values on the sex field female=1,male=0 and adding a column named gender
    public Table mapTextColumnToNumber(Table data) {
       /*
        NumberColumn mappedGenderColumn = null;
        StringColumn gender = (StringColumn) data.column ("Sex");
        List<Number> mappedGenderValues = new ArrayList<Number> ();
        for (String v : gender) {
            if ((v != null) && (v.equals ("female"))) {
                mappedGenderValues.add (new Double (1));
            } else {
                mappedGenderValues.add (new Double (0));
            }
        }
        mappedGenderColumn = DoubleColumn.create ("gender", mappedGenderValues);
        data.addColumns (mappedGenderColumn);
        return data;*/
        int[] gens = data.stream().mapToInt(row -> { String gen = row.getString("sex");
            if (gen.equals("female"))
                return 0;
            else
                return 1;
        }).toArray();
        data.removeColumns("sex");
        NumberColumn genderColumn = DoubleColumn.create("sex", gens);
        data.addColumns(genderColumn);

        return data;
    }
}

