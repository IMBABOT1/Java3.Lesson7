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

        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                beforeCount++;
            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                afterCount++;
            }
        }

        for (int i = 0; i < methods.length - 1 ; i++) {
            for (int j = 0; j < methods.length - 1 - i; j++) {
               if (methods[j].getAnnotation(Test.class).priority() > methods[j+1].getAnnotation(Test.class).priority()){
                   Method temp = methods[j];
                   methods[j] = methods[j + 1];
                   methods[j+1] = temp;
               }
            }
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
