package com.yuan.qrcode;

import jp.sourceforge.qrcode.data.QRCodeImage;

import java.awt.image.BufferedImage;

public class MyQRcodeImage implements QRCodeImage {

    BufferedImage image;

    public MyQRcodeImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public int getWidth() {
        return image.getWidth();
    }

    @Override
    public int getHeight() {
        return image.getHeight();
    }

    @Override
    public int getPixel(int i, int i1) {
        return image.getRGB(i, i1);
    }

}
