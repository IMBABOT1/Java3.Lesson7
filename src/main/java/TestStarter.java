import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestStarter {

    private static void start(Class test) throws Exception {
        HashMap<Integer, Class> map = new HashMap<>();
        int beforeCount = 0;
        int afterCount = 0;
        Class c = TestClass.class;
        Method[] methods = c.getDeclaredMethods();


        Method[] temp = new Method[methods.length];
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
            if (m.isAnnotationPresent(BeforeSuite.class) && m.getAnnotation(BeforeSuite.class).priority() == 10) {
                temp[9] = m;
            }
            if (m.isAnnotationPresent(AfterSuite.class) && m.getAnnotation(AfterSuite.class).priority() == 1) {
                temp[0] = m;
            }
            if (m.isAnnotationPresent(Test.class) && m.getAnnotation(Test.class).priority() == 2) {
                temp[1] = m;
            }
            if (m.isAnnotationPresent(Test.class) && m.getAnnotation(Test.class).priority() == 3) {
                temp[2] = m;
            }
            if (m.isAnnotationPresent(Test.class) && m.getAnnotation(Test.class).priority() == 4) {
                temp[3] = m;
            }
            if (m.isAnnotationPresent(Test.class) && m.getAnnotation(Test.class).priority() == 5) {
                temp[4] = m;
            }
            if (m.isAnnotationPresent(Test.class) && m.getAnnotation(Test.class).priority() == 6) {
                temp[5] = m;
            }
            if (m.isAnnotationPresent(Test.class) && m.getAnnotation(Test.class).priority() == 7) {
                temp[6] = m;
            }
            if (m.isAnnotationPresent(Test.class) && m.getAnnotation(Test.class).priority() == 8) {
                temp[7] = m;
            }
            if (m.isAnnotationPresent(Test.class) && m.getAnnotation(Test.class).priority() == 9) {
                temp[8] = m;
            }
        }


        for (int i = temp.length - 1; i >= 0; i--) {
            temp[i].invoke(null);
        }
    }


    public static void main(String[] args) {
        try {
            start(TestClass.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}