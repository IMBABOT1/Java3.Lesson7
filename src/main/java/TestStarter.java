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

        List<Method> temp = new ArrayList<>();
        Method before = null;
        Method after = null;

        for (int i = 0; i < methods.length; i++) {
          if (methods[i].isAnnotationPresent(Test.class)){
              temp.add(methods[i]);
          }
        }


        for (int i = 0; i < methods.length -1; i++) {
            if (methods[i].isAnnotationPresent(BeforeSuite.class)){
                before = methods[i];
            }
        }

        for (int i = 0; i < methods.length -1; i++) {
            if (methods[i].isAnnotationPresent(AfterSuite.class)){
                after = methods[i];
            }
        }

        for (int i = 0; i < temp.size() - 1; i++) {
            for (int j = 0; j < temp.size() - 1 - i; j++) {
                if (temp.get(j).getAnnotation(Test.class).priority() > temp.get(j + 1).getAnnotation(Test.class).priority()){
                    Method m = temp.get(j);
                    temp.set(j, temp.get(j + 1));
                    temp.set(j + 1, m);
                }
            }
        }
        temp.add(0, after);
        temp.add(temp.size(), before);

        for (int i = temp.size()-1; i >=0 ; i--) {
            temp.get(i).invoke(null);
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

