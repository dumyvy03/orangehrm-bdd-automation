package com.orangehrm.commons;

import java.io.File;

public class GlobalConstants {
    // 1. System Info
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String JAVA_VERSION = System.getProperty("java.version");

    // 2. Environment Config
    public static final String SERVER = System.getProperty("server", "localhost");
    public static final String PROJECT_NAME = "OrangeHRM";

    // 3. TIMEOUT
    public static final long SHORT_TIMEOUT = 3;
    public static final long LONG_TIMEOUT = 10;

    // 4. FILE PATH
    public static final String UPLOAD_PATH = PROJECT_PATH
            + File.separator + "src"
            + File.separator + "test"
            + File.separator + "resources"
            + File.separator + "uploadFiles"
            + File.separator;

}
