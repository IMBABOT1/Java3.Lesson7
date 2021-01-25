public class TestClass {
    @Common(priority = 10)
    @BeforeSuite(priority = 10)
    public static void test1() {
        System.out.println(10);
    }
    @Common(priority = 9)
    @Test(priority = 9)
    public static void test2() {
        System.out.println(9);
    }
    @Common(priority = 8)
    @Test(priority = 8)
    public static void test3() {
        System.out.println(8);
    }
    @Common(priority = 7)
    @Test(priority = 7)
    public static void test4() {
        System.out.println(7);
    }
    @Common(priority = 6)
    @Test(priority = 6)
    public static void test5() {
        System.out.println(6);
    }
    @Common(priority = 5)
    @Test(priority = 5)
    public static void test6() {
        System.out.println(5);
    }
    @Common(priority = 4)
    @Test(priority = 4)
    public static void test7() {
        System.out.println(4);
    }
    @Common(priority = 3)
    @Test(priority = 3)
    public static void test8() {
        System.out.println(3);
    }
    @Common(priority = 2)
    @Test(priority = 2)
    public static void test9() {
        System.out.println(2);
    }
    @Common(priority = 1)
    @AfterSuite(priority = 1)
    public static void test10() {
        System.out.println(1);
    }


}