package sandeep.geophy.qa.utils;

import org.apache.commons.lang.RandomStringUtils;

public class RandomGenerator {

    public static String getRandomEmail() {
        return RandomStringUtils.randomAlphabetic(10) + "@no-email.address";
    }
}
