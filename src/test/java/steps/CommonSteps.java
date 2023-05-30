package steps;

import api_assured.ApiUtilities;
import bookstore.BookStore;
import io.cucumber.java.*;
import common.Utilities;

public class CommonSteps extends ApiUtilities {

    BookStore bookStore = new BookStore();

    @Before
    public void before(Scenario scenario){
        Utilities.scenario = scenario;
        if (scenario.getSourceTagNames().contains("@BookStoreAuthentication")){
            bookStore.createUserWithGpt();
            bookStore.generateTokenForContext();
        }
    }

    @After
    public void after(Scenario scenario){
        if (scenario.isFailed()){log.new Warning(scenario.getName() + ": FAILED!");}
        else log.new Success(scenario.getName() + ": PASS!");
    }

}
