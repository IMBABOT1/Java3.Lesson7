import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestStarter {

    private static void start(Class test) throws Exception {
        HashMap<Class, Integer> map = new HashMap<>();
        int beforeCount = 0;
        int afterCount = 0;
        int p = 0;
        int a = 0;
        Class c = TestClass.class;
        Method[] methods = c.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)){
                beforeCount++;
            }
            if (m.isAnnotationPresent(AfterSuite.class)){
                afterCount++;
            }
            if (beforeCount > 1 || afterCount > 1){
                throw new RuntimeException("Beforecount: " + beforeCount + " " + "Aftercount" + afterCount);
            }
            if (m.isAnnotationPresent(BeforeSuite.class)){
                map.put(BeforeSuite.class, m.getAnnotation(BeforeSuite.class).priority());
            }
            if (m.isAnnotationPresent(AfterSuite.class)){
                map.put(AfterSuite.class, m.getAnnotation(AfterSuite.class).priority());
            }
        }

        System.out.println(map);
    }





    public static void main(String[] args) {
        try {
            start(TestClass.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

