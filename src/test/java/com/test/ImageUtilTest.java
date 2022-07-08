package com.test;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;

import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.io.*;

public class ImageUtilTest {

    public static void main(String[] args) {
        byte[] buffer = null;
        String path1 = "D:\\code.jpg";
        String left = "D:\\left";
        try {
            File file = new File(path1);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();


            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buffer);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImgUtil.cut(
                    byteArrayInputStream,
                    byteArrayOutputStream,
                    new Rectangle(20, 20, 430, 430)//裁剪的矩形区域
            );

            ImgUtil.pressImage(
//                    FileUtil.file("/home/uns/tmp/jddqrcode/left.png"),
                    FileUtil.file(left),
                    FileUtil.file(path1),
                    ImgUtil.read(FileUtil.file(path1)), //水印图片
                    0, //x坐标修正值。 默认在中间，偏移量相对于中间偏移
                    -20, //y坐标修正值。 默认在中间，偏移量相对于中间偏移
                    1.0f
            );



        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}
