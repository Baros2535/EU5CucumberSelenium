package com.vytrack.pages;


import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import io.github.bonigarcia.wdm.managers.SeleniumServerStandaloneManager;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class VehiclesInformationPage extends BasePage {


    public Map<String, Object> getCarInformation(){
        String locatorOfKey="//div[@class='control-group attribute-row']/label[@class='control-label']";
        List<WebElement> keyOfCar = Driver.get().findElements(By.xpath(locatorOfKey));

        List<String> keyOfCarString = BrowserUtils.getElementsText(keyOfCar);

        String locatorOfValue="//div[@class='controls']/div[@class='control-label']";
        List<WebElement> valueOfCar = Driver.get().findElements(By.xpath(locatorOfValue));
        List<String> valueOfCarString = BrowserUtils.getElementsText(valueOfCar);

        Map<String ,Object> carMap=new LinkedHashMap<>();


        for (int i = 0; i <valueOfCar.size() ; i++) {
            carMap.put(keyOfCarString.get(i),valueOfCarString.get(i));
        }
 return carMap;



    }

    public void assertVehiclesInformation(Map<String, Object> expectedCarInformation, Map<String, Object> actualCarInformation) {
        List<Object> expected=new ArrayList<>();
        SoftAssertions assertions=new SoftAssertions();
        for (Object value : expectedCarInformation.values()) {
        ;
            expected.add(value);
        }
        List<Object>actual=new ArrayList<>();
        for (Object value : actualCarInformation.values()) {
            actual.add(value);
        }
        for (int i = 0; i <expected.size() ; i++) {
          switch (i){
              case 0:
              case 1:
              case 9:
              case 10:

                  assertions.assertThat(expected.get(i).toString()).isEqualTo(actual.get(i).toString());
              break;
              case 4:
              case 5:
              case 6:
              case 7:
              case 8:
                 // Assert.assertEquals(expected.get(i).toString().substring(0,expected.get(i).toString().indexOf(".")),actual.get(i));
                 assertions.assertThat(expected.get(i).toString().substring(0,expected.get(i).toString().indexOf("."))).isEqualTo(actual.get(i));
                  break;
              case 2:
                String expectedData=""+expected.get(i);
                  System.out.println(expectedData);
                if (expectedData.equals("true")){
                   // Assert.assertEquals("Yes",actual.get(i));
                    assertions.assertThat("Yes").isEqualTo(actual.get(i));
                    System.out.println("girdi true");

                }
                else{
             // Assert.assertEquals("No",actual.get(i));
              assertions.assertThat("No").isEqualTo(actual.get(i));
                }
                break;
              case 3:

                 String expectedDataNull= ""+expected.get(i);
                  System.out.println(expectedDataNull);
                 if (expectedDataNull.equals("null")){
                     //Assert.assertEquals("",actual.get(i));
                     System.out.println("girdi null");
                     assertions.assertThat("").isEqualTo(actual.get(i));
                 }else
                 {
                     System.out.println("girmedi");
                    // Assert.assertEquals(expectedDataNull,actual.get(i));
                     assertions.assertThat(expectedDataNull).isEqualTo(actual.get(i));
                 }
                  assertions.assertAll();
                 break;
          }
        }

        System.out.println("expected = " + expected);
        System.out.println("actual = " + actual);

    }
}