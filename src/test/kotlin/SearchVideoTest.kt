package com.kotlin.test

import com.kotlin.UtilResources
import com.kotlin.pages.HomePage
import com.kotlin.pages.ResultPage
import org.testng.Assert
import org.testng.annotations.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import java.util.concurrent.TimeUnit

class SearchVideoTest() {

    lateinit var driver: WebDriver
        private set

    @BeforeTest
    fun setup() {
        val pageURL = "https://www.youtube.com/"

        System.setProperty(UtilResources.getProperties("nameDriver"),
                UtilResources.getProperties("pathDriver") + UtilResources.getProperties("exeDriver"))
        driver = ChromeDriver()
        driver.manage()?.timeouts()?.implicitlyWait(10, TimeUnit.SECONDS)
        driver.manage()?.window()?.maximize()
        driver.get(pageURL)
    }

    @AfterTest
    fun driverClose() {
        driver.close();
    }

    @Test
    fun searchVideo() {
        val videoName = "kotlin selenium test"
        val videoSelection = "Kotlin with API tests (Roma Marinsky, Ukraine) [RU]"
        val channel = "Selenium Camp"

        val homePage = HomePage(driver)
        homePage.searchVideo(videoName)

        val resultPage = ResultPage(driver)

        resultPage.selectVideo(videoSelection)

        Assert.assertTrue(resultPage.playingVideo(videoSelection,
                channel))
    }

}