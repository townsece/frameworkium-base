package com.ten10.academy.practice.automation.pages;

import com.frameworkium.core.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage<HomePage> {

    @FindBy(css = "g")
    private List<WebElement> navElements;

}