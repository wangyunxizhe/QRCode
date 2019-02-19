package com.yuan.qrcode;

import com.swetake.util.Qrcode;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * qrcode方式生成二维码类
 */
public class CreateQRcode {

    public static void main(String[] args) throws Exception {
        Qrcode x = new Qrcode();
        x.setQrcodeErrorCorrect('M');//纠错等级
        x.setQrcodeEncodeMode('B');//N代表数字，A代表a-Z，B代表其他字符
        x.setQrcodeVersion(7);//版本
        String qrdata = "为了部落";//二维码的内容

        int width = 67 + 12 * (7 - 1);//固定格式，记住就行。不然二维码图片会有很大留白
        int height = 67 + 12 * (7 - 1);
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D gs = bufferedImage.createGraphics();//使用Java自带的画图工具
        gs.setBackground(Color.WHITE);
        gs.setColor(Color.BLACK);
        gs.clearRect(0, 0, width, height);

        int pixoff = 2;//偏移量，不加的话可能会导致解析的时候出错

        byte[] d = qrdata.getBytes("gb2312");
        if (d.length > 0 && d.length < 120) {
            boolean[][] s = x.calQrcode(d);
            for (int i = 0; i < s.length; i++) {
                for (int j = 0; j < s.length; j++) {
                    if (s[j][i]) {
                        gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
                    }
                }
            }
        }

        gs.dispose();
        bufferedImage.flush();
        ImageIO.write(bufferedImage, "png", new File("qrcode.png"));
    }

}
