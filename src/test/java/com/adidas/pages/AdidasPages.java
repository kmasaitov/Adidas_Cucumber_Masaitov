package com.adidas.pages;

import com.adidas.utilities.BrowserUtils;
import com.adidas.utilities.Driver;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdidasPages {


    public AdidasPages() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.='Laptops']")
    public WebElement Laptop;

    @FindBy(xpath = "//a[.='Sony vaio i5']")
    public WebElement Sony;

     @FindBy(xpath = "//a[.='Add to cart']")
      public WebElement Adding;

    @FindBy(xpath = "(//a[@class='nav-link'])[1]")
    public WebElement GoingHomePage;

    @FindBy(xpath = "//a[.='Dell i7 8gb']")
    public WebElement Dell;

    @FindBy(xpath = "//a[.='Cart']")
    public WebElement GoToCart;

    @FindBy(xpath = "//tbody//tr//td[.='Dell i7 8gb']/..//td[.='Delete']/a")
    public WebElement DeleteTheItem;

    @FindBy(id = "name")
    public WebElement name;
    @FindBy(id = "country")
    public WebElement Country;
    @FindBy(id = "city")
    public WebElement City;
    @FindBy(id = "card")
    public WebElement Card;
    @FindBy(id = "month")
    public WebElement Month;
    @FindBy(id = "year")
    public WebElement Year;
    @FindBy(xpath = "//button[.='Purchase']")
    public WebElement purchase;
    @FindBy(xpath = "//button[.='Place Order']")
    public WebElement placeOrder;

}
