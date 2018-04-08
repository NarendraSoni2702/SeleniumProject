package com.cucumber.testng.examples;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit.rawat on 21/12/15.
 */
public class GenerateReport {
    public static void GenerateMasterthoughtReport(){
        try{
            String RootDir = System.getProperty("user.dir");
            File reportOutputDirectory = new File("target/Masterthought");
            List<String> list = new ArrayList<String>();
            list.add("target/cucumber1.json");
            list.add("target/cucumber2.json");

            String pluginUrlPath = "";
            String buildNumber = "1";
            String buildProject = "cucumber-jvm";
            boolean skippedFails = true;
            boolean runWithJenkins = false;
            boolean parallelTesting = true;
           
            Configuration configuration = new Configuration(reportOutputDirectory,buildProject);
            // optional configuration
            configuration.setParallelTesting(parallelTesting);
            configuration.setRunWithJenkins(runWithJenkins);
            configuration.setBuildNumber(buildNumber);
            
            
            // optionally add metadara presented on main page
            configuration.addClassifications("Platform","Windows");
            configuration.addClassifications("Browser", "firefox");
            
            // optionally
            List<String> classificationfiles = new ArrayList<String>();
            classificationfiles.add("date_calculator1.feature");
            classificationfiles.add("date_calculator2.feature");
            configuration.addClassificationFiles(classificationfiles);
            
            ReportBuilder reportBuilder = new ReportBuilder(list, configuration);
            reportBuilder.generateReports();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
