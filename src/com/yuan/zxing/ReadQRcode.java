package com.yuan.zxing;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * zxing方式读取二维码类
 */
public class ReadQRcode {

    public static void main(String[] args) throws Exception {
        MultiFormatReader formatReader = new MultiFormatReader();
        File file = new File("img.png");
        BufferedImage image = ImageIO.read(file);
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
        //定义二维码的参数
        Map params = new HashMap<>();
        params.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        Result result = formatReader.decode(binaryBitmap, params);
        System.out.println("解析结果：" + result.toString());
        System.out.println("二维码的格式类型：" + result.getBarcodeFormat());
        System.out.println("二维码的文本类容：" + result.getText());
    }

}
