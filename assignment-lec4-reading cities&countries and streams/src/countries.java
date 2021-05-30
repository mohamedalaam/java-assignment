import java.util.ArrayList;
import java.util.List;

public class countries {
    private String code , name;
    private List<cities> citiesList ;

    @Override
    public String toString() {
        return "countries{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", citiesList=" + citiesList +
                '}';
    }

    public countries(String code, String name) {
        this.code = code;
        this.name = name;
        citiesList = new ArrayList<>();

    }

    public List<cities> getCitiesList() {
        return citiesList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCitiesList(List<cities> citiesList) {
        this.citiesList = citiesList;
    }
}
