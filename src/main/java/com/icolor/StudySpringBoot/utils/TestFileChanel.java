package com.icolor.StudySpringBoot.utils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by admin on 2017/12/5.
 */
public class TestFileChanel {

    public static void copyFile(File f1, File f2) {   //f1 为源文件  f2 为目标文件，本方法的功能是 复制f1文件 为f2
        FileInputStream fi = null;
        FileOutputStream fo = null;
        FileChannel in = null;
        FileChannel out = null;
        try {
            fi = new FileInputStream(f1);
            fo = new FileOutputStream(f2);
            in = fi.getChannel();//得到f1 的文件通道
            out = fo.getChannel();//得到f12的文件通道
            in.transferTo(0, in.size(), out);//连接两个通道，并且从in通道读取，然后写入out通道
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fi.close();
                in.close();
                fo.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void fun2(){

        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile("C:\\smy\\context1.xml", "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileChannel inChannel = aFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead=0;
        try {
            bytesRead = inChannel.read(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (bytesRead != -1) {
            System.out.println("Read " + bytesRead);
            buf.flip();
            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }
            buf.clear();
            try {
                bytesRead = inChannel.read(buf);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            aFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
