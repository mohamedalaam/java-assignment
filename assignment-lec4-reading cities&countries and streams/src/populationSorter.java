import java.util.Comparator;

public class populationSorter implements Comparator<cities>
{
    @Override
    public int compare(cities o1, cities o2) {
        Integer x=o1.getPop();
        Integer y=o2.getPop();

        return y.compareTo(x);
    }
}