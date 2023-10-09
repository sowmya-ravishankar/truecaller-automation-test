package com.truecaller.test;

import com.truecaller.driver.AppDriver;
import com.truecaller.pom.GetStartedPage;
import com.truecaller.pom.LoginPage;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class LoginTest extends TestBase{

    String phoneNumber = "9900234853";

    AppiumDriver driver;
    AppDriver appDriver;
    GetStartedPage getStartedPage;
    LoginPage loginPage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        appDriver = new AppDriver();
        driver = appDriver.getDriver();
    }

    @Test(priority = 0)
    public void verifyGetStartedPage() {

        getStartedPage = new GetStartedPage(driver);
        Assert.assertTrue(getStartedPage.isOnGetStartedPage());

        getStartedPage.clickOnGetStartedButton();
        getStartedPage.acceptPermissionBottomSheet();
        getStartedPage.acceptAllPermissions();

    }

    @Test(dependsOnMethods = "verifyGetStartedPage")
    public void verifyLogin() {
        loginPage = new LoginPage(driver);
        loginPage.cancelGoogleSignIn();

        Assert.assertTrue(loginPage.isOnEnterPhoneNumberPage());

        loginPage.enterPhoneNumber(phoneNumber);
        loginPage.clickOnVerifyPhoneNumber();
        loginPage.confirmNumber();

        Assert.assertTrue(loginPage.verifyPrivacyPolicy());

        loginPage.acceptPrivacyPolicy();

        Assert.assertTrue(loginPage.validateVerifyingNumberPage());
        Assert.assertTrue(loginPage.userLandsOnCreateProfilePage());

    }
}
