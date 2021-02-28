package com.cms.util;

import java.util.Locale;
import java.util.ResourceBundle;

import com.cms.constants.DatabaseConstants;

/**
 * @author Rishabh Gupta
 *
 */
public class PropertyUtil {

    /**
     * @param fileName
     * @return ResourceBundle
     */
    public static final ResourceBundle getBundle(String fileName) {
        Locale locale = Locale.getDefault();
        return ResourceBundle.getBundle(fileName, locale);

    }

    /**
     * @return String 
     */
    public static String getUrl() {
        ResourceBundle url = getBundle(DatabaseConstants.DBPROPERTIES);
        return url.getString(DatabaseConstants.DBURL);

    }

    /**
     * @return String 
     */
    public static String getUserName() {
        ResourceBundle url = getBundle(DatabaseConstants.DBPROPERTIES);
        return url.getString(DatabaseConstants.DBUSERNAME);

    }

    /**
     * @return String 
     */
    public static String getPassword() {
        ResourceBundle url = getBundle(DatabaseConstants.DBPROPERTIES);
        return url.getString(DatabaseConstants.DBPASSWORD);

    }

    /**
     * @param messageCode
     * @return String 
     */
    public static String getCMSMessages(String messageCode) {
        ResourceBundle url = getBundle(DatabaseConstants.CMSMESSAGES);
        return url.getString(messageCode);

    }

  
}
