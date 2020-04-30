package com.test;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.junit.Test;

import javax.imageio.ImageIO;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.PrivateKey;
import java.util.Random;
import java.util.function.Consumer;

public class TestClass {
    @Test
    public void test2() {
        Document document = DocumentHelper.createDocument();
        XMLSignatureFactory dom = XMLSignatureFactory.getInstance("DOM");
        PrivateKey privateKey = null;
    }








    @Test
    public void test1() {
        BufferedImage image = new BufferedImage(70, 26, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, 70, 26);
        String s = createCharacter(g);
        System.out.println("验证码" + s);
        g.dispose();

        try {
            ImageIO.write(image, "jpg", new File("E:/" + "123.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String createCharacter(Graphics g) {
        char[] codeSeq = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J',
                'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9'};
        String[] fontTypes = {"Arial", "Arial Black", "AvantGarde Bk BT", "Calibri"};
        Random random = new Random();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            String r = String.valueOf(codeSeq[random.nextInt(codeSeq.length)]);//random.nextInt(10));
            g.setColor(new Color(50 + random.nextInt(100), 50 + random.nextInt(100), 50 + random.nextInt(100)));
            g.setFont(new Font(fontTypes[random.nextInt(fontTypes.length)], Font.BOLD, 26));
            g.drawString(r, 15 * i + 5, 19 + random.nextInt(8));
//			g.drawString(r, i*w/4, h-5);
            s.append(r);
        }


        return s.toString();
    }

    @Test
    public void mybatisTest() {
        while (true) {
            for (int i = 0; i < 30000; i++) {
                int a = i * i;
            }
        }
    }
}
