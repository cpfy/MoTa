package Interface;

import Datas.ImageData;
import MoTa.MTower;
import Datas.DialogData;
import Datas.DialogData.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import static MoTa.MTower.*;

public class DialogBoard {
    public static JLayeredPane dialogPane = new JLayeredPane();
    public static JLabel dialogBgImg = new JLabel();
    public static JTextArea name = new JTextArea(20, 20);
    public static JTextArea text = new JTextArea(20, 20);
    public static JLabel imgIco = new JLabel();
    
    private static final Font titleFont = new Font("黑体", Font.BOLD, 40);
    private static final Font textFont = new Font("黑体", Font.BOLD, 30);

    static 
    {
        dialogPane.setLayout(null);
        dialogBgImg.setIcon(new ImageIcon(ImageData.dialogBgImg));
        dialogPane.add(dialogBgImg, 1, 0);
        
        name.setForeground(Color.WHITE);
        name.setFont(titleFont);
        name.setWrapStyleWord(true);
        name.setLineWrap(true);
        name.setOpaque(false);
        name.setEditable(false);
        name.setFocusable(false);
                
        text.setForeground(Color.WHITE);
        text.setFont(textFont);
        text.setWrapStyleWord(true);
        text.setLineWrap(true);
        text.setOpaque(false);
        text.setEditable(false);
        text.setFocusable(false);
    }

    // 对话事件
    public DialogBoard(int id, int x, int y)
    {
        Insets insets = dialogPane.getInsets();
        
        String[] messages = DialogData.getDialogData(id, currentFloor);

        imgIco.setIcon(new ImageIcon(DialogData.getNPCImage(id)));				//NPC头像
        imgIco.setBounds(33 + insets.left, 27 + insets.top, PIX69, PIX69);
        
        name.setBounds(250 + insets.left, 20 + insets.top, 561 - 200, 100);		//NPC姓名
        name.setText(DialogData.getNPCName(id, currentFloor));
        //System.out.print(DialogData.getNPCName(id));
        
        text.setBounds(120 + insets.left, 75 + insets.top, 561 - 15 - 120, 284);		//谈话内容
        text.setText(messages[0]);
        
        dialogBgImg.setBounds(0, 0, 561, 284);
        dialogPane.setBounds(510, 135, 561, 284);
        dialogPane.add(imgIco, 2, 0);
        dialogPane.add(name, 3, 0);
        dialogPane.add(text, 4, 0);
        
        dialogPane.setVisible(true);
        MTower.inConversation = true;
        
        gamePanel.add(dialogPane);
        gamePanel.repaint();

        gameFrame.addKeyListener(new KeyListener() {
        	int count = 0;

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) 
            {
                if (e.getKeyCode() == e.VK_ENTER) 
                {
                	//System.out.print("Enter pressed.");
                	
                    dialogPane.remove(imgIco);
                    dialogPane.remove(name);
                    dialogPane.remove(text);
                    gamePanel.remove(dialogPane);
                    count++;

                    if (count >= messages.length) 
                    {
                        inConversation = false;
                        gameFrame.removeKeyListener(this);
                        gamePanel.repaint();
                        
                        if(id == 28 && 
                    		currentFloor == 20 &&
                    		!DialogData.fakePrincessIsBeaten) new BattleBoard(id, x, y);
                        
                        return;
                    }
    
                    text.setText(messages[count]);
                    
                    dialogPane.add(imgIco, 2, 0);
                    dialogPane.add(name, 3, 0);
                    dialogPane.add(text, 4, 0);
                    
                    gamePanel.add(dialogPane);
                    gamePanel.repaint();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }
}