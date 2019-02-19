package com.yuan.zxing;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * zxing方式生成二维码类
 */
public class CreateQRcode {

    public static void main(String[] args) throws Exception {
        int width = 300;//定义生成二维码的宽度
        int height = 300;//定义生成二维码的高度
        String format = "png";//定义二维码的图片格式
        String content = "大吉大利，今晚吃鸡";//定义二维码的内容

        //定义二维码的参数
        Map params = new HashMap<>();
        params.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        params.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);//纠错等级，越高可存贮数据越少
        params.put(EncodeHintType.MARGIN, 2);//边距，默认5，值越小，图片留白越小

        //开始生成
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, params);
        Path file = new File("img.png").toPath();
        MatrixToImageWriter.writeToPath(bitMatrix, format, file);
    }

}
