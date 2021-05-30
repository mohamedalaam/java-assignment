import java.util.List;

public class main_class {
    public static void main(String[] args) {

        PyramidCSVDAO pDAO = new PyramidCSVDAO();
        List<pyramids> pyramids_L = pDAO.read_pyramid("pyramids.csv");

        for (pyramids p : pyramids_L) {
            System.out.println(p);
        }
    }
}
