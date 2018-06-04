package com.kotlin.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class ResultPage(private val driver: WebDriver) {


    @FindBy(css = "#video-title")
    private val videos: List<WebElement>? = null

    @FindBy(id = "result-count")
    private val resultCount: WebElement? = null

    @FindBy(css = ".title.style-scope.ytd-video-primary-info-renderer .style-scope")
    private val titleVideoSelector: WebElement? = null

    @FindBy(id = "#owner-name .yt-simple-endpoint")
    private val channelSelector: WebElement? = null

    init {
        PageFactory.initElements(driver, this)
    }

    fun selectVideo(selectVideo: String){
        val wait = WebDriverWait(driver, 10000)
        wait.until(ExpectedConditions.visibilityOf(resultCount))

        for (webElement in videos!!) {
            if (webElement.getAttribute("title").contains(selectVideo)) {
                webElement.click()
                break
            }
        }
    }

    fun playingVideo(titleVideo: String, channel: String): Boolean{
        val wait = WebDriverWait(driver, 10000)
        wait.until(ExpectedConditions.visibilityOf(channelSelector))
        return titleVideo == titleVideoSelector!!.text && channel == channelSelector!!.text
    }
}