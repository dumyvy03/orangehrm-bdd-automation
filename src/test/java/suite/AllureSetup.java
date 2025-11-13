package suite;

import com.orangehrm.helper.AllureHelper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AllureSetup {
    @BeforeTest
    public static void cleanAllureResults() {
        AllureHelper.cleanResults();
        AllureHelper.bringHistory();
    }

    @AfterTest
    public static void createEnvFile() {
        AllureHelper.createEnvironmentFile();
    }
}
