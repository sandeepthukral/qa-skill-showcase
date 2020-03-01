package sandeep.qa.utils;

import org.apache.commons.lang.RandomStringUtils;

public class RandomGenerator {

    public static String getRandomEmail() {
        return RandomStringUtils.randomAlphabetic(10) + "@no-email.address";
    }

    public static String getRandomName() {
        return RandomStringUtils.randomAlphabetic(10);
    }

    public static String getRandomPassword() {
        return RandomStringUtils.randomAlphanumeric(20);
    }
}
