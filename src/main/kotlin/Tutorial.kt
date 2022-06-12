
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.support.ui.WebDriverWait


fun main() {
    System.setProperty("webdriver.gecko.driver","""C:\geckodriver.exe""")
    val driver  = FirefoxDriver()
    val github = Login(
        "https://github.com",
    "ismaelforest@gmail.com",
    "login_field",
        "Satan258069911!",
    "password"
    )
    val virtuo = Login(
        "https://virtuo.ciussscn.rtss.qc.ca/portals/home/app/login",
        "510217",
        "username-txt",
        "Satan258069911!",
        "password-txt",
    )
    //logMeIn(driver, virtuo)
    driver["https://virtuo.ciussscn.rtss.qc.ca/portals/home/app/login"]

    driver.manage().window().fullscreen()
    println(driver.title)

    driver.findElement(By.id("username-txt")).click()
    driver.findElement(By.id("username-txt")).sendKeys("510217")
    driver.findElement(By.id("password-txt")).click()
    driver.findElement(By.id("password-txt")).sendKeys("Satan258069911!")

    driver.findElementByXPath("/html/body/app-root/div/ms-navigation/div/div/app-home-login/div/div/div[3]/div[2]/ms-form/form/dx-validation-group/div[2]/ms-button/div/ms-default-button/button").click()
    waitUntilPageIsReady(driver)
    Thread.sleep(4000)
    val list = driver.findElementsByTagName("span")

    for(i in list.indices) {
        println(list.get(i).text)
        println(list.get(i))
        println("$i \n")
        if(i == 34) list[i].click()
    }
}

data class Login(
    val url : String,
    val username : String,
    val username_id : String,
    val password : String,
    val password_id : String
)

fun logMeIn(driver : FirefoxDriver, login : Login) {
    driver.get(login.url)
    driver.findElementById(login.username_id).sendKeys(login.username)
    driver.findElementById(login.password_id).sendKeys(login.password)
}

fun waitUntilPageIsReady(driver: FirefoxDriver) {
    val executor = driver as JavascriptExecutor
    WebDriverWait(driver, 1)
        .until { executor.executeScript("return document.readyState") == "complete" }
}
