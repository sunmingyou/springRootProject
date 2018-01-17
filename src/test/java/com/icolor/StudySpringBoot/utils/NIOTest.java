package com.icolor.StudySpringBoot.utils;

import junit.framework.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.UnknownFormatConversionException;

/**
 * Created by admin on 2017/12/5.
 */
@SpringBootTest
public class NIOTest {

    @Test
    public void Testfc(){
        TestFileChanel.copyFile(new File("C:\\smy\\apache-tomcat2\\conf\\context.xml"),new File("C:\\smy\\context1.xml"));

    }

    @Test
    public void TestRd() throws UnsupportedEncodingException{
        ResourceBundle resourceBundle=  ResourceBundle.getBundle("base",new Locale("en","us"));
       System.out.print(new String(resourceBundle.getString("hello").getBytes("ISO-8859-1"),"UTF-8"));
    }

    @Test
public void TestA(){
//       Object myObject=new Object();
       String myObject=null;
        if (!Objects.equals(myObject, null)) {
            System.out.print("2");
        } else {
            System.out.print("1");
        }
    }




        class  A{
            private String _name;

            public String get_name() {
                return _name;
            }

            public void set_name(String _name) {
                this._name = _name;
            }
        }
        class B extends A{
            private int _age;

            public int get_age() {
                return _age;
            }

            public void set_age(int _age) {
                this._age = _age;
            }
        }



}
