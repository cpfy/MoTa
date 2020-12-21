package Datas;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ImageData {
	private static final int FaceUp = 0;
	private static final int FaceRight = 1;
	private static final int FaceDown = 2;
	private static final int FaceLeft = 3;
	
    public static HashMap<Integer, BufferedImage> playerMap = new HashMap<>();
    public static HashMap<Integer, BufferedImage> imageMap = new HashMap<>();
    public static BufferedImage gameBgImg;
    public static BufferedImage messageBgImg;
    public static BufferedImage battleBgImg;
    public static BufferedImage victoryBgImg;
    public static BufferedImage shopBgImg;
    public static BufferedImage dialogBgImg;
    public static BufferedImage flyBgImg;

    static {
        try {
        	//System.out.print(System.getProperty("user.dir") + "/Assets/BackgroundImage/GameBg.png");
            gameBgImg = ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/BackgroundImage/GameBg.png"));
            messageBgImg = ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/BackgroundImage/MessageBg.png"));
            battleBgImg = ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/BackgroundImage/BattleBg.png"));
            victoryBgImg = ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/BackgroundImage/VictoryBg.png"));
            shopBgImg = ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/BackgroundImage/ShopBg.png"));
            dialogBgImg = ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/BackgroundImage/DialogBg.png"));
            flyBgImg = ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/BackgroundImage/FlyBg.png"));
            
            //
            imageMap.clear();
            imageMap.put(0, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/0.png")));
            imageMap.put(1, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/1.png")));
            imageMap.put(2, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/2.png")));
            imageMap.put(3, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/3.png")));
            imageMap.put(4, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/4.png")));
            imageMap.put(5, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/5.png")));
            imageMap.put(6, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/6.png")));
            imageMap.put(7, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/7.png")));
            imageMap.put(8, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/8.png")));
            imageMap.put(9, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/9.png")));
            imageMap.put(10, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/10.png")));
            imageMap.put(11, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/11.png")));
            imageMap.put(12, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/12.png")));
            imageMap.put(13, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/13.png")));
            imageMap.put(14, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/14.png")));
            imageMap.put(15, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/15.png")));
            imageMap.put(16, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/16.png")));
            imageMap.put(17, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/17.png")));
            imageMap.put(19, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/19.png")));
            imageMap.put(20, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/20.png")));
            imageMap.put(21, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/21.png")));
            imageMap.put(22, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/22.png")));
            imageMap.put(23, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/23.png")));
            imageMap.put(24, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/24.png")));
            imageMap.put(25, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/25.png")));
            imageMap.put(26, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/26.png")));
            imageMap.put(27, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/27.png")));
            imageMap.put(28, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/28.png")));
	        //imageMap.put(29, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/29.png")));
            imageMap.put(30, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/30.png")));
            imageMap.put(31, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/31.png")));
            imageMap.put(32, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/32.png")));
            imageMap.put(33, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/33.png")));
            imageMap.put(34, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/34.png")));
            imageMap.put(35, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/35.png")));
            imageMap.put(36, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/36.png")));
            imageMap.put(38, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/38.png")));
            imageMap.put(39, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/39.png")));
            imageMap.put(40, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/40.png")));
            imageMap.put(41, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/41.png")));
            imageMap.put(42, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/42.png")));
            imageMap.put(43, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/43.png")));
            imageMap.put(44, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/44.png")));
            imageMap.put(45, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/45.png")));
            imageMap.put(46, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/46.png")));
            imageMap.put(47, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/47.png")));
            imageMap.put(48, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/48.png")));
            imageMap.put(49, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/49.png")));
            imageMap.put(50, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/50.png")));
            imageMap.put(51, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/51.png")));
            imageMap.put(52, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/52.png")));
            imageMap.put(53, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/53.png")));
            imageMap.put(54, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/54.png")));
            imageMap.put(55, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/55.png")));
            imageMap.put(56, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/56.png")));
            imageMap.put(57, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/57.png")));
            imageMap.put(58, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/58.png")));
            imageMap.put(59, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/59.png")));
            
            //imageMap.put(60, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/60.png")));
            
            imageMap.put(61, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/61.png")));
            imageMap.put(62, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/62.png")));
            imageMap.put(63, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/63.png")));
            imageMap.put(64, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/64.png")));
            imageMap.put(65, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/65.png")));
            imageMap.put(66, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/66.png")));
            imageMap.put(67, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/67.png")));
            imageMap.put(68, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/68.png")));
            imageMap.put(69, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/69.png")));
            imageMap.put(70, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/70.png")));
            imageMap.put(71, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/71.png")));
            imageMap.put(72, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/72.png")));
            imageMap.put(73, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/73.png")));
            imageMap.put(75, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/75.png")));
            imageMap.put(76, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/76.png")));
            imageMap.put(77, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/77.png")));
            imageMap.put(78, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/78.png")));
            imageMap.put(80, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/80.png")));
            imageMap.put(81, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/81.png")));
            imageMap.put(82, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/82.png")));
            
            /*
            imageMap.put(181, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/181.png")));
            imageMap.put(182, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/182.png")));
            imageMap.put(183, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/183.png")));
            imageMap.put(184, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/184.png")));
            imageMap.put(185, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/185.png")));
            imageMap.put(186, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/186.png")));
            imageMap.put(187, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/187.png")));
            imageMap.put(188, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/188.png")));
            imageMap.put(189, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/189.png")));
            */
            
            imageMap.put(191, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/191.png")));//°Ë×¦Óã
            imageMap.put(192, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/192.png")));
            imageMap.put(193, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/193.png")));
            imageMap.put(194, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/194.png")));
            imageMap.put(195, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/195.png")));
            imageMap.put(196, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/196.png")));
            imageMap.put(197, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/197.png")));
            imageMap.put(198, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/198.png")));
            imageMap.put(199, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/199.png")));
            
            /*
//	            imageMap.put(201, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/201.png")));
            imageMap.put(202, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/202.png")));
            imageMap.put(203, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/203.png")));
            // ÖØ¸´Í¼Æ¬
            imageMap.put(115, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/15.png")));
            imageMap.put(119, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/0.png")));
            imageMap.put(129, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/0.png")));
            imageMap.put(301, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/13.png")));
            imageMap.put(302, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/13.png")));
            imageMap.put(303, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/14.png")));
            imageMap.put(304, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/14.png")));
            imageMap.put(305, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/MapImage/5.png")));   
            */
            
            // Íæ¼Ò ¿ØÖÆÍ¼Æ¬
            playerMap.clear();
            playerMap.put(FaceUp, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/playerImage/up.png")));
            playerMap.put(FaceRight, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/playerImage/right.png")));
            playerMap.put(FaceDown, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/playerImage/down.png")));
            playerMap.put(FaceLeft, ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/playerImage/left.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
