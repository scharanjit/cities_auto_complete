package org.imaginea.demo.utils;

/**
 * @author Charanjit Singh
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;


public class StringsUtils {

    private static final Logger LOG = LoggerFactory.getLogger(StringsUtils.class);

    public static String stringToCamelCase(String value) {
        LOG.info("Inside stringToCamelCase() of " + StringsUtils.class.getSimpleName());
        return StringUtils.capitalize(value);

    }
}
