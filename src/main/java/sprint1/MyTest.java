package sprint1;

import org.testng.annotations.Test;

public class MyTest {

    @Test(groups = {"smoke"})
    public void tes1()
    {
        System.out.println("Smoke1");
    }

    @Test(groups = {"smoke"})
    public void tes2()
    {
        System.out.println("Smoke2");
    }

    @Test(groups = {"smoke1"})
    public void tes7()
    {
        System.out.println("Smoke");
    }

    @Test(groups = {"regression"})
    public void tes3()
    {
        System.out.println("Regression1");
    }

    @Test(groups={"regression"}, dependsOnGroups = {"smoke1"})
    public void tes4()
    {
        System.out.println("Regression2");
    }

}
