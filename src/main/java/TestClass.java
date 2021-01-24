public class TestClass {

    @BeforeSuite(priority = 10)
    public static void beforeSuite(){
        System.out.println("BeforeSuite");
    }


    @Test(priority = 2)
    public static void method1(){
        System.out.println("method1");
    }
    @Test(priority = 3)
    public static void method2(){
        System.out.println("method2");
    }
    @Test(priority = 4)
    public static void method3(){
        System.out.println("method3");
    }
    @Test(priority = 5)
    public static void method4(){
        System.out.println("method4");
    }
    @Test(priority = 6)
    public static void method5(){
        System.out.println("method5");
    }
    @Test(priority = 7)
    public static void method6(){
        System.out.println("method6");
    }
    @Test(priority = 8)
    public static void method7(){
        System.out.println("method7");
    }
    @Test(priority = 9)
    public static void method8(){
        System.out.println("method8");
    }

    @AfterSuite(priority = 1)
    public static void afterSuite(){
        System.out.println("AfterSuite");
    }
}
