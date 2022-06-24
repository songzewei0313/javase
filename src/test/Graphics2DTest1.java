package test;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author szw
 * @date 2022/4/29 8:33
 */
public class Graphics2DTest1 {
    FontUtil fu = new FontUtil();
    private Font font = fu.getDefinedFont(1, 110.0f);

    @Test
    public void addTextTest() throws IOException {
        String num = "0022";
//        String name = "宋泽";
        String name = "宋泽伟";
//        String name = "宋泽伟伟";
        File file = new File("D:\\linshi\\疫线新青年-01.jpg");
        BufferedImage image = ImageIO.read(file);
        addTextWaterMark(image, Color.RED, font, "NO.", num, name, "D:\\linshi\\疫线新青年-02.jpg");
    }

    public void addTextWaterMark(BufferedImage targetImg, Color textColor, Font font, String text, String num, String name, String outPath) {
        try {
            //图片宽
            int width = targetImg.getWidth();
            //图片高
            int height = targetImg.getHeight();
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
            Graphics2D g = bufferedImage.createGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.drawImage(targetImg, 0, 0, width, height, null);
            //水印颜色
            g.setColor(textColor);
            g.setFont(font);
            //最上面的NO.
            int x = width - 720 - 392;
            int y = height - 1840 - 196;

            myDrawString(text, x, y, 1.4, g);
            //最上面的编号
            g.setFont(font);
            x = width - 196 - 700;
            y = height - 196 - 1840;
            myDrawString(num, x, y, 1.2, g);

            //上面的名字
            font = font.deriveFont(200.0f);
            g.setColor(Color.black);
            g.setFont(font);
            int length = name.length();
            if (length == 2) {
                x = width - 840 - 342 + 66;
                y = height - 890 - 342;
                myDrawString(name, x, y, 1.5, g);
            } else if (length == 3) {
                x = width - 840 - 342;
                y = height - 890 - 342;
                myDrawString(name, x, y, 1.1, g);
            } else if (length == 4) {
                x = width - 840 - 342 - 50;
                y = height - 890 - 342;
                myDrawString(name, x, y, 1.0, g);
            }

            //下面名字
            g.setColor(Color.RED);
            g.rotate(Math.toRadians(-16), (double) width / 2, (double) height / 2);
            font = font.deriveFont(52.0f);
            if (length == 2) {
                x = width - 842 - 600;
                y = height - 488 - 630;
            } else if (length == 4) {
                font = font.deriveFont(49.0f);
                x = width - 842 - 645;
                y = height - 488 - 630;
            } else if (length == 3) {
                x = width - 842 - 630;
                y = height - 488 - 630;
            }
            g.setFont(font);
            g.drawString(name, x, y);

            //下面编号
            String textNum = text + num;
//            font = fu.getDefinedFont(1,52.0f);
            font = font.deriveFont(52.0f);
            g.setFont(font);
            x = width - 1291 - 208;
            y = height - 848 - 208;
            g.drawString(textNum, x, y);
            FileOutputStream outImgStream = new FileOutputStream(outPath);
            ImageIO.write(bufferedImage, "jpg", outImgStream);
            outImgStream.flush();
            outImgStream.close();
            g.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int len(Graphics2D g, String text) {
        //获取文字长度
        int len = g.getFontMetrics(
                g.getFont()).charsWidth(text.toCharArray(),
                0, text.length());
        return len;
    }

    public static void myDrawString(String str, int x, int y, double rate, Graphics2D g) {
        String tempStr;
        int orgStringWight = g.getFontMetrics().stringWidth(str);
        int orgStringLength = str.length();
        int tempx = x;
        int tempy = y;
        while (str.length() > 0) {
            tempStr = str.substring(0, 1);
            str = str.substring(1);
            g.drawString(tempStr, tempx, tempy);
            tempx = (int) (tempx + (double) orgStringWight / (double) orgStringLength * rate);
        }
    }
}
