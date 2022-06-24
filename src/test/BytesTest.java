package test;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

/**
 * @author song
 */
public class BytesTest {
    @Test
    public void test() {
        String fileText = "看着我们周围。每一棵树、每一叶草、每一朵花，都不化妆， 面对骄阳、面对暴雨、面对风雪，它们都本色而自然。 它们会衰老和凋零，但衰老和凋零也是一种真实。 作为万物灵长的人类，为何要将自己隐藏在脂粉和油彩的后面";
        testmethod(fileText);
    }

    public static void main(String[] args) {
        String fileText = "世上有一种伪坦率，最需提防。人们常有一种善良的错觉，以为只有隐瞒才是欺骗，殊不知最高明的骗术，正是在光天化日下进行。伪坦率是一种更高水准的虚伪，他利用的是人们对坦率的信任。坦率其实不说明更多的问题，它只是把双方的意见公开，本身并不等同于真诚,我不相信命运，我只相信我的手。因为它不属于冥冥之中任何未知的力量，而只属于我的心。我可以支配它，去干我想干的任何一件事情,简言之，幸福就是没有痛苦的时刻。他出现的频率并不比我们想象的少，人们常常只是在幸福的金马车驶过去很远时，捡起地上的金鬃毛说，原来我见过它。人们喜欢会为幸福的标本，却忽略了幸福披着露水散发清香的时刻。那时候我们往往步履匆匆，瞻前顾后，不知在忙些什么。世上有人预报台风，有人预报蝗虫，有人预报瘟疫，有人预报地震，却没有人预报幸福看着我们周围。每一棵树、每一叶草、每一朵花，都不化妆， 面对骄阳、面对暴雨、面对风雪，它们都本色而自然。 它们会衰老和凋零，但衰老和凋零也是一种真实。 作为万物灵长的人类，为何要将自己隐藏在脂粉和油彩的后面";
        testmethod(fileText);
    }

    private static void testmethod(String fileText) {
        byte[] bytes = fileText.getBytes(StandardCharsets.UTF_8);
        String str;
        if (bytes.length > 1024) {
            int n = bytes.length / 1024 + 1;
            for (int i = 0; i < n; i++) {
                if (i + 1 == n) {
                    str = new String(bytes, i * 1024 + 1, bytes.length+1);
                } else {
                    if (i == 0) {
                        str = new String(bytes, i * 1024, (i + 1) * 1024);
                    } else str = new String(bytes, i * 1024 + 1, (i + 1) * 1024);
                }
                System.out.println(str);
            }
        } else {
            str = new String(bytes, 0, bytes.length);
            System.out.println(str);
        }
    }

    private static void testmethod1(String fileText) {


    }

}
