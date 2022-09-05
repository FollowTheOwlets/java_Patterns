import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем фильтрацию");
        List<Integer> result = source.stream()
                .filter(e -> {
                    boolean ans = e >= this.treshold;
                    if (ans) {
                        logger.log("Число " + e + " подходит");
                    } else {
                        logger.log("Число " + e + " не подходит");
                    }
                    return ans;
                })
                .collect(Collectors.toList());

        logger.log("Прошло фильтр " + result.size() + " элемента из " + source.size());
        return result;
    }
}
