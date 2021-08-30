package com.vytrack.step_definitions;

import com.vytrack.pages.FleetManagementPage;
import com.vytrack.pages.VehiclesInformationPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.DBUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class DBExampleStepDefs {
    @Given("the user clicks the {string} from list")
    public void the_user_clicks_the_from_list(String model) {

new FleetManagementPage().clickCar(model);
BrowserUtils.waitFor(5);
    }

    @Then("the vehicle model information should be same with database")
    public void the_vehicle_model_information_should_be_same_with_database() {
        Map<String, Object> expectedCarInformation = DBUtils.getRowMap("Select ModelName,Make,Canberequested,Logo_id,CatalogValue,CO2Fee,Cost,TotalCost,CO2Emissions,FuelType_id,Vendors from oro_ext_vehiclesmodel where ModelName='Mazda'");
        List<Object> rowList = DBUtils.getRowList("Select ModelName,Make,Canberequested,Logo_id,CatalogValue,CO2Fee,Cost,TotalCost,CO2Emissions,FuelType_id,Vendors from oro_ext_vehiclesmodel where ModelName='Mazda'");
        System.out.println(rowList);
        BrowserUtils.waitFor(10);

        Map<String, Object> actualCarInformation = new VehiclesInformationPage().getCarInformation();
        new VehiclesInformationPage().assertVehiclesInformation(expectedCarInformation,actualCarInformation);

    }

}
