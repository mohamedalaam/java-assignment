public class cities {
    private String code,name , continent;
    private int s_area , pop;

    public cities(String code, String name, String continent, int s_area, int pop) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.s_area = s_area;
        this.pop = pop;
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

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getS_area() {
        return s_area;
    }

    public void setS_area(int s_area) {
        this.s_area = s_area;
    }

    public int getPop() {
        return pop;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }

    @Override
    public String toString() {
        return "cities{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", s_area=" + s_area +
                ", pop=" + pop +
                '}';
    }
}
