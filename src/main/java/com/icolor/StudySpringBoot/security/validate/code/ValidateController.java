package com.icolor.StudySpringBoot.security.validate.code;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by admin on 2017/11/7.
 */
@RestController
public class ValidateController {
    public final static String SESSION_KEY="SESSION_KEY_IMAGE_CODE";

    @GetMapping("/code/image")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException{

        ImageCode imageCode=createImageCode(request);
        request.getSession().setAttribute(SESSION_KEY,imageCode);
        ImageIO.write(imageCode.getImage(),"jpeg",response.getOutputStream());

    }

    public ImageCode createImageCode(HttpServletRequest request){

        int width = 83, height = 30;
        int lineCount = 150;
        int codeCount=4;
        int fontHeight = height - 2;//字体的高度
        int x = width / (codeCount + 2);//每个字符的宽度(左右各空出一个字符)
        fontHeight = height - 2;//字体的高度
        int codeY = height - 4;
        // 验证码干扰线数
        char[]codeSequence={'1','2','3','4','5','6','7','8','9','a','b','c','d'};
        // 建立指定宽、高和BufferedImage对象
        BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics(); //该画笔画在image上
        g.setColor(Color.white);//保存当前画笔的颜色
        //填充矩形
        g.fillRect(0, 0, width, height);
        // 创建字体,可以修改为其它的
        Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);
//        Font font = new Font("Times New Roman", Font.ROMAN_BASELINE, fontHeight);
        g.setFont(font);
        // 生成随机数
        Random random = new Random();
        int red,green,blue;
        for (int i = 0; i < lineCount; i++) {
            // 设置随机开始和结束坐标
            int xs = random.nextInt(width);//x坐标开始
            int ys = random.nextInt(height);//y坐标开始
            int xe = xs + random.nextInt(width / 8);//x坐标结束
            int ye = ys + random.nextInt(height / 8);//y坐标结束

            // 产生随机的颜色值，让输出的每个干扰线的颜色值都将不同。
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            g.setColor(new Color(red, green, blue));
            g.drawLine(xs, ys, xe, ye);
        }

        // randomCode记录随机产生的验证码
        StringBuffer randomCode = new StringBuffer();
        // 随机产生codeCount个字符的验证码。
        for (int i = 0; i < codeCount; i++) {
            String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
            // 产生随机的颜色值，让输出的每个字符的颜色值都将不同。
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            g.setColor(new Color(red, green, blue));
            g.drawString(strRand, (i + 1) * x, codeY);
            // 将产生的四个随机数组合在一起。
            randomCode.append(strRand);
        }
        // 将四位数字的验证码保存到Session中。
        String code = randomCode.toString();
        ImageCode imageCode=new ImageCode(image,code,60);
        return  imageCode;
    }
}
