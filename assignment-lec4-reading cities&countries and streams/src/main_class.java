import java.util.List;
import java.util.Map;

public class main_class {
    public static void main(String[] args) {

        cityDao cDAO = new cityDao();
        List<cities> city_L = cDAO.read_city("cities.csv");
        countryDao caDAO = new countryDao();
        List<countries> country_L = caDAO.read_country("countries.csv");
        for (countries p : country_L) {
            p.setCitiesList(cDAO.m.get(p.getCode()));
            p.getCitiesList().sort(new populationSorter());
            System.out.println(p);
        }

    }
}
