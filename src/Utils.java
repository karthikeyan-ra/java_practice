import java.util.function.Predicate;

public class Utils {

   static Predicate<Record> isZeroCpu=r->r.getCpu()==0;
   static Predicate<Record> isGreaterThanZeroCpu=r->r.getCpu()>0;

}
