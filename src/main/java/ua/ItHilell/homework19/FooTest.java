package ua.ItHilell.homework19;

public class FooTest {

    @BeforeSuite()
    public void fooTest6() {
        System.out.println("Before test");
    }

    @Test(priority = 6)
    public void fooTest1() {
        System.out.println("This is test with priority 6");
    }

    @Test(priority = 5)
    public void fooTest2() {
        System.out.println("This is test with priority 5");
    }

    @Test(priority = 7)
    public void fooTest3() {
        System.out.println("This is test with priority 7");
    }

    @Test(priority = 2)
    public void fooTest4() {
        System.out.println("This is test with priority 2");
    }

    @Test(priority = 5)
    public void fooTest5() {
        System.out.println("This is test with priority 5 (copy)");
    }

    @AfterSuite
    public void fooTest7() {
        System.out.println("After method");
    }

}
