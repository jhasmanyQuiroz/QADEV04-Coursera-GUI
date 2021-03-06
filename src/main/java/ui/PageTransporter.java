/**
 * Created with IntelliJ IDEA.
 * User: jhasmanyquiroz
 * Date: 11/11/15
 * Time: 11:21 AM
 * To change this template use File | Settings | File Templates.
 */
package ui;

import framework.BrowserManager;
import org.openqa.selenium.WebDriver;
import ui.pages.*;

public class PageTransporter {
    private WebDriver driver = BrowserManager.getInstance().getDriver();
    private String baseLoginURL = "https://www.coursera.org/";
    private String baseHomeURL = "https://www.coursera.org/?authMode=login";
    private String baseAccountProfileURL = "https://www.coursera.org/account/profile";
    private String baseCertificateURL = "https://www.coursera.org/account/settings/signature";
    private String baseCourseURL = "https://class.coursera.org/algs4partII-006";
    private static PageTransporter instance;

    protected PageTransporter() {
        initialize();
    }

    public static PageTransporter getInstance() {
        if(instance == null) {
            instance = new PageTransporter();
        }
        return instance;
    }

    private void initialize() {
//        log.info("Initialize the page transporter");
    }

    private void goToURL(String url) {
        driver.navigate().to(url);
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public MainPage navigateToMainPage() {
        goToURL(baseLoginURL);
        return new MainPage();
    }

    public LoginPage navigateToLoginPage() {
        return new LoginPage();
    }

    public HomePage navigateToHomePage() {
        goToURL(baseHomeURL);
        return new HomePage();
    }

    public ProfilePage navigateToAccountProfilePage() {
        goToURL(baseAccountProfileURL);
        return new ProfilePage();
    }

    public CertificatePage navigateCertificatePage() {
        goToURL(baseCertificateURL);
        return new CertificatePage();
    }

    public CoursePage navigateToCoursePage() {
        goToURL(baseCourseURL);
        return new CoursePage();
    }
}