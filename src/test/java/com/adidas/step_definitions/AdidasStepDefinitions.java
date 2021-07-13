package com.adidas.step_definitions;

import com.adidas.pages.AdidasPages;
import com.adidas.utilities.BrowserUtils;
import com.adidas.utilities.ConfigurationReader;
import com.adidas.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.cs.Ale;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.protobuf.StringValue;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class AdidasStepDefinitions {
    AdidasPages pages = new AdidasPages();
    Faker faker = new Faker();

    @Given("user is the home page")
    public void user_is_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("clicks the laptop")
    public void clicks_the_laptop() {
        BrowserUtils.sleep(1);
        pages.Laptop.click();
    }

    @When("user selects Sony laptop")
    public void user_selects_sony_laptop() {
    BrowserUtils.sleep(1);
    pages.Sony.click();

    }
    @When("user add to the cart")
    public void user_add_to_the_cart() {
        BrowserUtils.sleep(1);
        pages.Adding.click();
        BrowserUtils.sleep(1);
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
        BrowserUtils.sleep(1);
        pages.GoingHomePage.click();
    }

    @When("user selects Dell laptop")
    public void user_selects_dell_laptop() {
        BrowserUtils.sleep(1);
        pages.Dell.click();
    }

    @Given("user is on the card page")
    public void user_is_on_the_card_page() {
        BrowserUtils.sleep(1);
        pages.GoToCart.click();
    }


    @When("user click on delete Dell and should delete")
    public void user_click_on_delete_dell_and_should_delete() {
        BrowserUtils.sleep(1);
        pages.DeleteTheItem.click();
    }

    @Given("User puts his info")
    public void userPutsHisInfo() {
        BrowserUtils.sleep(1);
        pages.placeOrder.click();
        BrowserUtils.sleep(1);
        pages.name.sendKeys(faker.name().fullName());
        pages.Country.sendKeys(faker.country().name());
        pages.City.sendKeys(faker.country().capital());
        pages.Card.sendKeys(faker.finance().creditCard());
        pages.Month.sendKeys(String.valueOf(faker.number().numberBetween(1,12)));
        pages.Year.sendKeys(String.valueOf(faker.number().numberBetween(2021,2025)));
    }

    @When("Clicks purchase he should see sale id")
    public void clicksPurchaseHeShouldSeeSaleId() {
        BrowserUtils.sleep(1);
        pages.purchase.click();
        int expectedOrderAmmount = 790;
        String confirmation = Driver.getDriver().findElement(By.xpath("//p[@class='lead text-muted ']")).getText();
        System.out.println("confirmation = " + confirmation);

        String[] confirmationArray = confirmation.split("\n");
        String orderID = confirmationArray[0];
        System.out.println("orderID = " + orderID);
        int actualAmmount = Integer.parseInt(confirmationArray[1].split(" ")[1]);
        System.out.println("actualAmmount = " + actualAmmount);
        System.out.println("expectedOrderAmmount = " + expectedOrderAmmount);

        Assert.assertEquals(actualAmmount,expectedOrderAmmount);

    }
}
