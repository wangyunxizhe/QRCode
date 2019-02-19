package com.yuan.qrcode;

import jp.sourceforge.qrcode.QRCodeDecoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * qrcode方式读取二维码类
 */
public class ReadQRcode {

    public static void main(String[] args) throws Exception {
        File file = new File("qrcode.png");
        BufferedImage image = ImageIO.read(file);
        QRCodeDecoder codeDecoder = new QRCodeDecoder();
        String rs = new String(codeDecoder.decode(new MyQRcodeImage(image)), "gb2312");
        System.out.println(rs);
    }

}
