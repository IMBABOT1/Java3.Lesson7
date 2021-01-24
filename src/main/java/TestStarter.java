import java.lang.reflect.Method;

public class TestStarter {

    private static void start(Class test) throws Exception {
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
                p = m.getAnnotation(BeforeSuite.class).priority();
            }
            if (m.isAnnotationPresent(AfterSuite.class)){
                a = m.getAnnotation(AfterSuite.class).priority();
            }
            if (m.isAnnotationPresent(BeforeSuite.class)){
                m.invoke(null);
            }
            if (m.isAnnotationPresent(Test.class) && m.getAnnotation(Test.class).priority() == 9){
                m.invoke(null);
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

