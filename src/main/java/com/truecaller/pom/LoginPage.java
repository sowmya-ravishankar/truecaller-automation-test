package com.truecaller.pom;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends POMBase{
    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.google.android.gms:id/title")
    public MobileElement signInWithGoogleHeader;

    @AndroidFindBy(id = "com.google.android.gms:id/cancel")
    public MobileElement cancelGoogleSignIn;

    @AndroidFindBy(id = "com.truecaller:id/titleText")
    public MobileElement enterPhoneNumberHeader;

    @AndroidFindBy(id = "com.truecaller:id/phoneNumberEditText")
    public MobileElement phoneNumberField;

    @AndroidFindBy(id = "com.truecaller:id/nextButton")
    public MobileElement verifyNumberBtn;

    @AndroidFindBy(id = "com.truecaller:id/alertTitle")
    public MobileElement confirmNumberAlert;

    @AndroidFindBy(id = "android:id/button1")
    public MobileElement confirmNumberButton;

    @AndroidFindBy(id = "com.truecaller:id/privacyPolicyTitle")
    public MobileElement privacyPolicyTitle;

    @AndroidFindBy(id = "com.truecaller:id/nextButton")
    public MobileElement privacyPolicyContinueBtn;

    @AndroidFindBy(id = "com.truecaller:id/title")
    public MobileElement callingToVerifyNumber;

    @AndroidFindBy(id = "com.truecaller:id/headerTextView")
    public MobileElement createYourProfile;


    public void cancelGoogleSignIn() {
        if(signInWithGoogleHeader.isDisplayed()){
            cancelGoogleSignIn.click();
        }
    }

    public boolean isOnEnterPhoneNumberPage() {
        return enterPhoneNumberHeader.isDisplayed();
    }

    public void enterPhoneNumber(String phoneNumber) {
        phoneNumberField.setValue(phoneNumber);
    }

    public void clickOnVerifyPhoneNumber() {
        verifyNumberBtn.click();
    }

    public void confirmNumber() {
        if(confirmNumberAlert.isDisplayed()) {
            confirmNumberButton.click();
        }
    }

    public boolean verifyPrivacyPolicy() {
        return privacyPolicyTitle.isDisplayed();
    }

    public void acceptPrivacyPolicy() {
        privacyPolicyContinueBtn.click();
    }

    public boolean validateVerifyingNumberPage() {
        return callingToVerifyNumber.isDisplayed();
    }

    public boolean userLandsOnCreateProfilePage() {
        return createYourProfile.isDisplayed();
    }

}
