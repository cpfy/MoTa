package MoTa;

import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.HashMap;

import Objects.Hero;
import Datas.ImageData;
import Datas.ShopData;
import Datas.MapData;
import static Datas.MapData.*;

import Interface.BattleBoard;
import Interface.DialogBoard;
import Interface.MessageBoard;
import Interface.ShopBoard;

public class MTower extends JPanel
{
	public static final int PIX69 = 69;
	
	private static final int YellowKeyID = 0;
	private static final int BlueKeyID = 1;
	private static final int RedKeyID = 2;
	
	private static int[] firstPickup = new int[100];
	
	public static JFrame gameFrame;
    public static JPanel gamePanel;

    public static int currentFloor = 0;     // 当前楼层
    public static int maxFloor = 0;         // 最大楼层
    
    public static boolean inConversation = false;
    public static boolean canFly = false;
    
    public static HashMap<Integer, BufferedImage> imgSource = ImageData.imageMap;     // 图片
    public static Hero myHero = new Hero();                           				  // 玩家属性

    // 构造器
    public MTower() {
        setLayout(null);
        gameFrame = new JFrame("Cover : 新新魔塔v1.42");
    }

    // 重写 paintComponent() 方法。
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        //偏移量
        int offsetX = 3;
        int offsetY = 2;

        // 绘制游戏主背景
        g2.drawImage(ImageData.gameBgImg, 0, 0, 1233, 888, null);

        // 绘制 地图数据
        for (int x = 0; x < 11; x++) {
            for (int y = 0; y < 11; y++) {
                int id = OneMap[currentFloor][x][y];
                BufferedImage a = imgSource.get(id);
                g2.drawImage(a, PIX69 * y + PIX69 * 6 + offsetX , PIX69 * x + PIX69 + offsetY, null);
            }
        }
        
        //设置字体/颜色
        g2.setFont(new Font("黑体", Font.BOLD, 35));
        g2.setColor(Color.WHITE);

        // 绘制 玩家
        g2.drawImage(myHero.draw(), (myHero.getPosX() + 6) * PIX69, (myHero.getPosY() + 1) * PIX69, null);

        //左侧面板基础数据
        g2.drawString(myHero.getLevel() + "", 250, 205);
        g2.drawString(myHero.getHealth() + "", 220, 255);
        g2.drawString(myHero.getAttack() + "", 240, 305);
        g2.drawString(myHero.getDefence() + "", 240, 360);
        g2.drawString(myHero.getSpeed() + "", 250, 415);
        g2.drawString(myHero.getExp() + "", 250, 465);
        
        //当前楼层
        g2.drawString("主塔   " + currentFloor + "F", 710, 45);
        
        //绘制状态
        g2.drawString(myHero.getHeroStates(), 220, 155);
        
        // 绘制钥匙+金币
        g2.setFont(new Font("黑体", Font.BOLD, 60));
        g2.drawString(myHero.getKey(YellowKeyID) + "", 250, 610);
        g2.drawString(myHero.getKey(BlueKeyID) + "", 250, 680);
        g2.drawString(myHero.getKey(RedKeyID) + "", 250, 750);
        g2.drawString(myHero.getGold() + "", 250, 820);
    }


    // 核 心 交 互 函 数
    public static void interaction(int x, int y) {
        int id = OneMap[currentFloor][y][x];
        
        switch (id) {
            case 0:     // 道路
                myHero.move(x, y);
                break;
                
            case 1:     // 墙
                break;
                
            case 2:     // 黄门
                if (myHero.enoughKey(YellowKeyID)) 
                {
                    OneMap[currentFloor][y][x] = 0;
                    myHero.useKey(YellowKeyID);
                }
                break;
                
            case 3:     // 蓝门
            	if (myHero.enoughKey(BlueKeyID)) 
                {
                    OneMap[currentFloor][y][x] = 0;
                    myHero.useKey(BlueKeyID);
                }
                break;
                
            case 4:     // 红门
            	if (myHero.enoughKey(RedKeyID)) 
                {
                    OneMap[currentFloor][y][x] = 0;
                    myHero.useKey(RedKeyID);
                }
                break;
                
            case 5:     // 机关门
            	if(MapData.doorCanOpen(currentFloor)) 
            		OneMap[currentFloor][y][x] = 0;
                break;
                
            case 6:     // [道具] 黄钥匙
                OneMap[currentFloor][y][x] = 0;
                MTower.myHero.addKey(YellowKeyID);
                if(firstPickup[id] == 0) {
                	MessageBoard.displayMessage("黄钥匙");
                	firstPickup[id]++;
                }   
                break;
                
            case 7:     // [道具] 蓝钥匙
                OneMap[currentFloor][y][x] = 0;
                MTower.myHero.addKey(BlueKeyID);
                if(firstPickup[id] == 0) {
                	MessageBoard.displayMessage("蓝钥匙");
                	firstPickup[id]++;
                }   
                break;
                
            case 8:     // [道具] 红钥匙
                OneMap[currentFloor][y][x] = 0;
                MTower.myHero.addKey(RedKeyID);
                if(firstPickup[id] == 0) {
                	MessageBoard.displayMessage("红钥匙");
                	firstPickup[id]++;
                }   
                break;
                
            case 9:     // [道具] 蓝宝石
                OneMap[currentFloor][y][x] = 0;
                MTower.myHero.addDefence(2);
                if(firstPickup[id] == 0) {
                	MessageBoard.displayMessage("蓝宝石 防御力+2");
                	firstPickup[id]++;
                }   
                break;
                
            case 10:    // [道具] 红宝石
                OneMap[currentFloor][y][x] = 0;
                MTower.myHero.addAttack(2);
                if(firstPickup[id] == 0) {
                	MessageBoard.displayMessage("红宝石 攻击力+2");
                	firstPickup[id]++;
                }
                break;
                
            case 11:    // [道具] 红药水
                OneMap[currentFloor][y][x] = 0;
                MTower.myHero.addHealth(150);
                if(firstPickup[id] == 0) {
                    MessageBoard.displayMessage("小血瓶 生命值+150");
                	firstPickup[id]++;
                }
                break;
                
            case 12:    // [道具] 蓝药水
                OneMap[currentFloor][y][x] = 0;
                MTower.myHero.addHealth(500);
                if(firstPickup[id] == 0) {
                    MessageBoard.displayMessage("大血瓶 生命值+500");
                	firstPickup[id]++;
                }
                break;
                
            case 13:    // 上楼
            	flyPos[currentFloor][0] = x;
            	flyPos[currentFloor][1] = y;
            	
                currentFloor++;
                maxFloor = Math.max(maxFloor, currentFloor);
                myHero.move(x, y);
                break;
                
            case 14:    // 下楼
            	flyPos[currentFloor][0] = x;
            	flyPos[currentFloor][1] = y;
            	
                currentFloor--;
                myHero.move(x, y);
                break;
                
            case 15:    // 触碰消失的护栏
            	OneMap[currentFloor][y][x] = 0;
                break;
            
            case 16:
            	OneMap[currentFloor][y][x] = 0;
                myHero.move(x, y);
            	myHero.addSpeed(1);
            	if(firstPickup[id] == 0) {
                	MessageBoard.displayMessage("绿宝石 敏捷+1");
                	firstPickup[id]++;
                }
            	break;
            
            case 17:	//20F的蓝色墙
            	break;
            
            case 19:    // 火海
                break;
                
            case 20:    // 星空
                break;
                
            case 22:    // 商店
            	ShopBoard.shop(id);
            	break;
            	
            case 24:    // [对话] 仙子
                new DialogBoard(id, x, y);
                OneMap[currentFloor][y][x] = 0;
                break;
                
            case 25:    // [对话] 小偷
            case 26:    // [对话] 老人
            case 27:    // [对话] 商人
            	if(ShopData.isShopper(id,currentFloor)) 
            		ShopBoard.shop(id);
            	else new DialogBoard(id, x, y);
                break;
            
            case 28:    // [对话] 公主
            	if(currentFloor == 20) {
            		new DialogBoard(id, x, y);
            		OneMap[currentFloor][y+3][x] = 1;
            	}
            	
            	else if(currentFloor == 21) {
            		new DialogBoard(id, x, y);
            	}
            	
            	break;
                
            case 30:    // [道具] 跃进之翼
                OneMap[currentFloor][y][x] = 0;
                myHero.addLevel(1);
                myHero.addHealth(400);
                myHero.addAttack(5);
                myHero.addDefence(5);
                MessageBoard.displayMessage("跃进之翼 等级+1");
                break;
                
            case 31:    // [道具] 大飞羽
                OneMap[currentFloor][y][x] = 0;
                myHero.addLevel(3);
                myHero.addHealth(3000);
                myHero.addAttack(21);
                myHero.addDefence(21);
                MessageBoard.displayMessage("大飞羽 等级+3");
                break;
                /*
            case 32:    // [宝物] 幸运十字架
                OneMap[currentFloor][y][x] = 0;
                myHero.move(x, y);
                //ItemsBean.isHasCross = true;
                //MessageBoard.displayMessage("【幸运十字架】 把它交给序章中的仙子，可以将自身的所有能力提升一些（攻击、防御和生命值）。");
                break;
            case 33:    // [宝物] 圣水瓶
                OneMap[currentFloor][y][x] = 0;
                myHero.move(x, y);
                MTower.myHero.addHealth(myHero.getHealth());
                //MessageBoard.displayMessage("【圣水瓶】 它可以将你的体质增加一倍（生命值加倍）。");
                break;
            case 34:    // [宝物] 圣光徽
                OneMap[currentFloor][y][x] = 0;
                myHero.move(x, y);
                //ItemsBean.isHasForecast = true;
                //MessageBoard.displayMessage("【圣光徽】 按 L 键使用 查看怪物的基本情况。");
                break;
            case 35:    // [宝物] 风之罗盘
                OneMap[currentFloor][y][x] = 0;
                myHero.move(x, y);
                //ItemsBean.isHasJump = true;
                //MessageBoard.displayMessage("【风之罗盘】 按 J 键使用 在已经走过的楼层间进行跳跃。");
                break;
            case 36:    // [道具] 魔法之匙
                OneMap[currentFloor][y][x] = 0;
                myHero.addKey(YellowKeyID);
                myHero.addKey(BlueKeyID);
                myHero.addKey(RedKeyID);
                MessageBoard.displayMessage("魔法之匙 所有钥匙数+1");
                break;*/
            case 38:    // [宝物] 宝石锄头
                OneMap[currentFloor][y][x] = 0;
                //ItemsBean.isHasHammer = true;
                MessageBoard.displayMessage("宝石锄头");
                break;
                
            case 39:    // [道具] 幸运金币
                OneMap[currentFloor][y][x] = 0;
                MTower.myHero.addGold(200);
                MessageBoard.displayMessage("幸运金币 金币+300");
                break;
                
            case 40:    // [怪物 monster]
            case 41:    // [怪物 monster]
            case 42:    // [怪物 monster]
            case 43:    // [怪物 monster]
            case 44:    // [怪物 monster]
            case 45:    // [怪物 monster]
            case 46:    // [怪物 monster]
            case 47:    // [怪物 monster]
            case 48:    // [怪物 monster]
            case 49:    // [怪物 monster]
            case 50:    // [怪物 monster]
            case 51:    // [怪物 monster]
            case 52:    // [怪物 monster]
            case 53:    // [怪物 monster]
            case 54:    // [怪物 monster]
            case 55:    // [怪物 monster]
            case 56:    // [怪物 monster]
            case 57:    // [怪物 monster]
            case 58:    // [怪物 monster]
            case 59:    // [怪物 monster]
            case 60:    // [怪物 monster]
            case 61:    // [怪物 monster]
            case 62:    // [怪物 monster]
            case 63:    // [怪物 monster]
            case 64:    // [怪物 monster]
            case 65:    // [怪物 monster]
            case 66:    // [怪物 monster]
            case 67:    // [怪物 monster]
            case 68:    // [怪物 monster]
            case 69:    // [怪物 monster]
            case 70:    // [怪物 monster]
                    new BattleBoard(id, x, y);
                    break;
            
            case 71:    // [宝物] 铁剑
                OneMap[currentFloor][y][x] = 0;
                MTower.myHero.addAttack(8);
                MessageBoard.displayMessage("铁剑 攻击力+8");
                break;
            
            case 72:    // [宝物] 长剑
                OneMap[currentFloor][y][x] = 0;
                MTower.myHero.addAttack(16);
                MessageBoard.displayMessage("长剑 攻击力+16");
                break;
            
            case 76:    // [宝物] 皮革之盾
                OneMap[currentFloor][y][x] = 0;
                myHero.addDefence(7);
                MessageBoard.displayMessage("皮革之盾 防御力+7");
                break;
            
            case 77:    // [宝物] 铁盾
                OneMap[currentFloor][y][x] = 0;
                myHero.addDefence(13);
                MessageBoard.displayMessage("铁盾 防御力+13");
                break;
            
            case 78:    // [宝物] 光之盾
                OneMap[currentFloor][y][x] = 0;
                myHero.addDefence(22);
                MessageBoard.displayMessage("光之盾 防御力+22");
                break;
            
            case 81:
            	OneMap[currentFloor][y][x] = 0;
            	myHero.setHeroStates(0);
            	MessageBoard.displayMessage("火酒，治疗衰弱状态");
            	break;
            
            case 82:
            	OneMap[currentFloor][y][x] = 0;
            	myHero.setHeroStates(0);
            	MessageBoard.displayMessage("抗毒剂，治疗中毒状态");
            	break;
            
            case 198:
                new BattleBoard(id, x, y);
                break;
        }
    }
}
