package com.vytrack.step_definitions;

import com.vytrack.utilities.DBUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before(value = "@db",order = 2)
    public void setUpDB(){
        System.out.println("DB is opened");
        DBUtils.createConnection();
    }

    @Before(order=1)
    public void setUp(){
        System.out.println("this is coming BEFORE");
    }

    @After(value = "@db",order = 2)
    public void closeDB(){

        System.out.println("DB is closed");
        DBUtils.destroy();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario){
if (scenario.isFailed()){
    final byte[] screenshot=((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
    scenario.attach(screenshot,"image/png","screenshot");
}


        Driver.closeDriver();

    }



}
