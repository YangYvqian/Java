package Java.lambda;
import java.util.Arrays;
import java.util.List;

public class LambdaTest {
    public static void main(String[] args) {
        List<GPU> gpus = Arrays.asList(
       new GPU("GTX-1080", 700, 2560, 1607, 1733, 8),
       new GPU("GTX-1070", 550, 1920, 1506, 1683, 8),
       new GPU("GTX-970", 330, 1664, 1050, 1178, 4),
       new GPU("GTX-770", 400, 1536, 1046, 1085, 2));

gpus.sort((g1, g2) -> g2.getPrice() - g1.getPrice());
gpus.forEach((g) -> System.out.println(g.getName() + " price $" + g.getPrice()));
        
        
    }


}
