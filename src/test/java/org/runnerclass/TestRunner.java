package org.runnerclass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\Lenovo\\eclipse-workspace\\LanuageDetails\\MavenProject\\FeatureFiles\\Cucuber.feature",
glue= {"org.stepdefinitions"},dryRun=false,monochrome=true,tags="@Sanity and @Smoke",
plugin= {"pretty","html:C:\\Users\\Lenovo\\eclipse-workspace\\LanuageDetails\\MavenProject\\target\\index.html",
		"json:target\\result.json","junit:target\\file.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class TestRunner {

}
