import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestStarter {

    private static void start(Class test) throws Exception {
        HashMap<Integer, Class> map = new HashMap<>();
        int beforeCount = 0;
        int afterCount = 0;
        int p = 0;
        int a = 0;
        Class c = TestClass.class;
        Method[] methods = c.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                beforeCount++;
            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                afterCount++;
            }
            if (beforeCount > 1 || afterCount > 1) {
                throw new RuntimeException("Beforecount: " + beforeCount + " " + "Aftercount" + afterCount);
            }
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                map.put(m.getAnnotation(BeforeSuite.class).priority(), BeforeSuite.class);
            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                map.put(m.getAnnotation(AfterSuite.class).priority(), AfterSuite.class);
            }
            if (m.isAnnotationPresent(Test.class)) {
                map.put(m.getAnnotation(Test.class).priority(), Test.class);
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

