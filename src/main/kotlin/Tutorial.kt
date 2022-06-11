
import org.openqa.selenium.firefox.FirefoxDriver


fun main() {
    System.setProperty("webdriver.gecko.driver","""C:\geckodriver.exe""")
    val driver  = FirefoxDriver()
    driver.get("https://waitbutwhy.com/archive")
}