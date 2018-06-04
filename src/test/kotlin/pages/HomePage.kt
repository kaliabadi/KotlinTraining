package com.kotlin.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class HomePage(private val driver: WebDriver) {

    @FindBy(id = "search")
    private val searchBox: WebElement? = null

    @FindBy(id = "search-icon-legacy")
    private val searchButton: WebElement? = null

    init {
        PageFactory.initElements(driver, this)
    }

    fun searchVideo(video: String) {
        searchBox?.sendKeys(video)
        searchButton?.click()
    }
}