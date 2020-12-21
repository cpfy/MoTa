package Interface;

import javax.swing.*;

import static java.awt.event.KeyEvent.VK_ENTER;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Datas.ImageData;
import MoTa.MTower;

import static Interface.MessageBoard.msgPane;
import static MoTa.MTower.*;

public class MessageBoard {

    public static JLayeredPane msgPane = new JLayeredPane();           // 初次提示信息面板
    public static JLabel msgLabel = new JLabel();

    static {
        // 初始化 信息面板
        msgPane.setLayout(null);
        msgPane.setBounds(300, 380, 906, 76);
        msgLabel.setBounds(130, 0, 700, 76);
        msgLabel.setForeground(Color.WHITE);
        msgLabel.setFont(new Font("黑体", Font.BOLD, 35));
        
        JLabel msgBackground = new JLabel(new ImageIcon(ImageData.messageBgImg));
        msgBackground.setLayout(null);
        msgBackground.setBounds(0, 0, 906, 76);
        
        msgPane.add(msgBackground, 1, 0);
        msgPane.add(msgLabel, 2, 0);
        msgPane.setVisible(false);
    }

    public static void displayMessage(String message) {
        msgPane.setVisible(true);
        inConversation = true;
        msgLabel.setText(message);
        gameFrame.repaint();
        
        gameFrame.addKeyListener(new KeyListener() 
        {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) 
            {
                if(MTower.inConversation && e.getKeyCode() == VK_ENTER)
                {
                	msgPane.setVisible(false);
                    inConversation = false;
                    gameFrame.removeKeyListener(this);
                    gameFrame.repaint();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        /*
        Timer animat = new Timer(500, new ActionListener() {
            int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                if (count == 5) {
                    msgPane.setVisible(false);
                    inConversation = false;
                    ((Timer) e.getSource()).stop();
                }
                msgLabel.setText(message);
                gameFrame.repaint();
            }
        });
        animat.setInitialDelay(0);
        animat.start();*/
    }
}
