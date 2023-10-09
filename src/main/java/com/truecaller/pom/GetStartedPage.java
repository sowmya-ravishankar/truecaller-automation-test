package com.truecaller.pom;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetStartedPage extends POMBase{
    public GetStartedPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.truecaller:id/nextButton")
    public MobileElement getStartedButton;

    @AndroidFindBy(id = "com.truecaller:id/permissions_title")
    public MobileElement permissionMessage;

    @AndroidFindBy(id = "android:id/button1")
    public MobileElement continueBtn;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_message")
    public MobileElement permissionPopUp;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    public MobileElement permissionAllowBtn;


    public Boolean isOnGetStartedPage() {
        boolean result = false;
        WebDriverWait wait = new WebDriverWait(driver, waitTimeInSec);
        try {
            wait.until(ExpectedConditions.visibilityOf(getStartedButton));
            result = getStartedButton.isDisplayed();
        } catch (TimeoutException exp) {
            LOGGER.info(exp.getMessage());
        }
        return result;
    }

    public void clickOnGetStartedButton() {
        getStartedButton.click();
    }

    public void acceptPermissionBottomSheet() {
        if(permissionMessage.isDisplayed()){
            continueBtn.click();
        }

    }

    public void acceptAllPermissions() {
        while(permissionPopUp.isDisplayed()){
            permissionAllowBtn.click();
        }
    }
}
