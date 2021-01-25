import java.lang.reflect.Method;
import java.util.*;

public class TestStarter {

    private static void start(Class test) throws Exception {
        HashMap<Integer, Class> map = new HashMap<>();
        int beforeCount = 0;
        int afterCount = 0;
        Class c = TestClass.class;
        Method[] methods = c.getDeclaredMethods();

        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                beforeCount++;
            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                afterCount++;
            }
        }

        if (afterCount > 1 || beforeCount > 1) {
            throw new RuntimeException("BeforeSuite:" + " " + beforeCount + " AfterSuite: " + afterCount + "," + " " + "BeforeSuite" + " and " + "AfterSuite" + " must be less then two");
        }

        for (int i = 0; i < methods.length; i++) {
            for (int j = 0; j < methods.length - i - 1; j++) {
                if (methods[j].getAnnotation(Common.class).priority() > methods[j+1].getAnnotation(Common.class).priority()){
                    Method m = methods[j];
                    methods[j] = methods[j + 1];
                    methods[j + 1] = m;
                }
            }
        }

        for (int i = methods.length - 1; i >= 0  ; i--) {
            methods[i].invoke(null);
        }

    }

            public static void main (String[]args){
                try {
                    start(TestClass.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

