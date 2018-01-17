package com.icolor.StudySpringBoot.utils;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by admin on 2017/12/30.
 */
public class ResourceUtil {
    public static ResourceBundle getResource(String baseName, Locale locale){
      return  ResourceBundle.getBundle(baseName,locale);
    }
}
