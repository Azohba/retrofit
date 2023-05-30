package common;

import api_assured.ApiUtilities;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import gpt.api.GPT;
import io.cucumber.java.Scenario;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import models.cucumber.CucumberReport;
import org.json.simple.JSONArray;
import models.commons.Receivers;
import java.util.ArrayList;
import java.util.Properties;
import utils.*;

import java.util.List;
import java.io.*;


public abstract class Utilities extends ApiUtilities {
    public static Scenario scenario;
    public static PropertiesReader properties = new PropertiesReader("test.properties");

    public static GPT gpt = new GPT(properties.getProperty("gpt-token"));
    public static ObjectMapper mapper = new ObjectMapper();
    public static ReflectionUtilities reflectionUtils = new ReflectionUtilities();
    public static NumericUtilities numUtils = new NumericUtilities();
    public static StringUtilities strUtils = new StringUtilities();

    public enum Color {CYAN, RED, GREEN, YELLOW, PURPLE, GRAY, BLUE}

    Printer log = new Printer(Utilities.class);

    public Utilities(){
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    public List<Receivers.Receiver> getReceivers() {
        try(FileReader file = new FileReader(properties.getProperty("receivers-directory"))) {
            return mapper.readValue(file, Receivers.class).receivers();
        }
        catch (IOException e) {throw new RuntimeException(e);}
    }

    public List<CucumberReport> getCucumberReport(String directory){
        try {
            List<CucumberReport> reports = new ArrayList<>();
            FileReader reportFile = new FileReader(directory);
            JSONParser parser = new JSONParser();
            JSONArray array = (JSONArray) parser.parse(reportFile);
            for (Object jsonObject: array) {
                String json = jsonObject.toString();
                reports.add(mapper.readValue(json , CucumberReport.class));
            }
            return  reports;
        }
        catch (IOException | ParseException e) {throw new RuntimeException(e);}
    }
}
