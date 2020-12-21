package Interface;

import MoTa.MTower;

import javax.swing.*;

import Datas.DialogData;
import Datas.ImageData;
import Datas.ShopData;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static MoTa.MTower.*;

public class ShopBoard {
    
	public static JLayeredPane shopPane = new JLayeredPane();
    public static JLabel shopBgImg = new JLabel();
    public static JLabel NPCImg = new JLabel();
    public static JTextArea name = new JTextArea(20, 20);
    public static JTextArea introduceText = new JTextArea(20, 20);
    public static JTextArea buyText = new JTextArea(20, 20);
    
    private static final Font titleFont = new Font("黑体", Font.BOLD, 35);
    private static final Font textFont = new Font("黑体", Font.BOLD, 28);
    private static final Font buytextFont = new Font("黑体", Font.BOLD, 35);
    
    private static String[] messages;
    
    static 
    {
        name.setForeground(Color.WHITE);
        name.setFont(titleFont);
        name.setWrapStyleWord(true);
        name.setLineWrap(true);
        name.setOpaque(false);
        name.setEditable(false);
        name.setFocusable(false);
                
        introduceText.setForeground(Color.WHITE);
        introduceText.setFont(textFont);
        introduceText.setWrapStyleWord(true);
        introduceText.setLineWrap(true);
        introduceText.setOpaque(false);
        introduceText.setEditable(false);
        introduceText.setFocusable(false);
        
        buyText.setForeground(Color.WHITE);
        buyText.setFont(buytextFont);
        buyText.setWrapStyleWord(true);
        buyText.setLineWrap(true);
        buyText.setOpaque(false);
        buyText.setEditable(false);
        buyText.setFocusable(false);
    }
    
 // 商店事件
    public static void shop(int id) {
    	
    	messages = DialogData.getShopData(id, currentFloor);
    	final int count = messages.length;
    	String bText = "";
    
        shopPane.setLayout(null);
        shopBgImg.setIcon(new ImageIcon(ImageData.shopBgImg));

        Insets insets = shopPane.getInsets();
        shopBgImg.setBounds(0, 0, 492, 560);									//背景图片
        
        NPCImg.setIcon(new ImageIcon(DialogData.getNPCImage(id)));				//NPC头像
        NPCImg.setBounds(73 + insets.left, 73 + insets.top, PIX69, PIX69);
        
        name.setBounds(250 + insets.left, 20 + insets.top, 561 - 200, 100);		//NPC姓名
        name.setText(DialogData.getNPCName(id, currentFloor));
        
        introduceText.setBounds(165 + insets.left, 75 + insets.top, 561 - 180, 250);	//商品文字介绍
        introduceText.setText(messages[0]);
        
        buyText.setBounds(60 + insets.left, 300 + insets.top, 492 - 60, 560 + 300);	//商品内容
        
        for(int i=1; i<count; i++) 
        {
        	bText += messages[i];
        }
        buyText.setText(bText);
        
        shopPane.setBounds(550, 200, 492, 560);
        
        shopPane.add(shopBgImg, 1, 0);
        shopPane.add(shopBgImg, 2, 0);
        shopPane.add(NPCImg, 3, 0);
        shopPane.add(name, 4, 0);
        shopPane.add(introduceText, 5, 0);
        shopPane.add(buyText, 6, 0);
        
        shopPane.setVisible(true);
        MTower.inConversation = true;
        
        gamePanel.add(shopPane);
        gamePanel.repaint();

        gameFrame.addKeyListener(new KeyListener() {
            int selection = 1;
            String message = "";

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) 
            {
                if (selection < count - 1 && e.getKeyCode() == e.VK_DOWN) //下移
                {
                	//System.out.print("press DOWN.\n");
                    messages[selection] = messages[selection].replaceAll("●", "⭕");
                    selection = selection + 1;
                    messages[selection] = messages[selection].replaceAll("⭕", "●");
                    
                    String bText = "";
                    for(int i=1; i<count; i++) 
                    {
                    	bText += messages[i];
                    }
                    buyText.setText(bText);
                    
                    //gameFrame.repaint();
                }
                
                if (selection > 1 && e.getKeyCode() == e.VK_UP) //上移
                {
                	//System.out.print("press UP.\n");
                    messages[selection] = messages[selection].replaceAll("●", "⭕");
                    selection = selection - 1;
                    messages[selection] = messages[selection].replaceAll("⭕", "●");
                    
                    String bText = "";
                    for(int i=1; i<count; i++) 
                    {
                    	bText += messages[i];
                    }
                    buyText.setText(bText);
                    
                    //gameFrame.repaint();
                }
            	
            	if (e.getKeyCode() == e.VK_ENTER) //确认
                {
                	if(selection == count - 1) 
                	{
                		clearPane();
                        gameFrame.removeKeyListener(this);
                	}
	                		
	                else
	                {
	                	ShopData.doShop(id, currentFloor, selection);
	                	gameFrame.repaint();
                	}
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }
    
    private static void clearPane()
    {
    	shopPane.remove(shopBgImg);
        shopPane.remove(shopBgImg);
        shopPane.remove(NPCImg);
        shopPane.remove(name);
        shopPane.remove(introduceText);
        shopPane.remove(buyText);
        
        gamePanel.remove(shopPane);
        gameFrame.repaint();
        inConversation = false;
    }
    
}