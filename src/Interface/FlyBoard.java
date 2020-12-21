package Interface;

import static MoTa.MTower.PIX69;
import static MoTa.MTower.currentFloor;
import static MoTa.MTower.gameFrame;
import static MoTa.MTower.gamePanel;
import static MoTa.MTower.inConversation;
import static MoTa.MTower.interaction;
import static MoTa.MTower.myHero;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.awt.event.KeyEvent.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;

import Datas.ImageData;
import Datas.MapData;
import MoTa.MTower;

public class FlyBoard {
	 	public static JLayeredPane flyPane = new JLayeredPane();
	    public static JLabel flyBgImg = new JLabel();
	    public static JTextArea floortext = new JTextArea(20, 20);
	    
	    private static final Font floorFont = new Font("黑体", Font.BOLD, 120);
	    
    	private int originFloor = currentFloor;
    	private int tempFloor = currentFloor;

	    static 
	    {  
	        floortext.setForeground(Color.WHITE);
	        floortext.setFont(floorFont);
	        floortext.setWrapStyleWord(true);
	        floortext.setLineWrap(true);
	        floortext.setOpaque(false);
	        floortext.setEditable(false);
	        floortext.setFocusable(false);
	    }
	    
	    public FlyBoard()
	    {
	        Insets insets = flyPane.getInsets();
	        
	        flyPane.setLayout(null);
	        flyBgImg.setIcon(new ImageIcon(ImageData.flyBgImg));
	        flyPane.add(flyBgImg, 1, 0);

	        floortext.setBounds(350 + insets.left, 325 + insets.top, 761, 761);		//谈话内容
	        floortext.setText(tempFloor + "");
	        
	        flyBgImg.setBounds(0, 0, 761, 761);
	        flyPane.setBounds(415, 69, 761, 761);
	        flyPane.add(floortext, 2, 0);
	        
	        flyPane.setVisible(true);
	        inConversation = true;
	        
	        gamePanel.add(flyPane);
	        gamePanel.repaint();

	        gameFrame.addKeyListener(new KeyListener() {

	            @Override
	            public void keyTyped(KeyEvent e) {
	            }

	            @Override
	            public void keyPressed(KeyEvent e)
	            {
	            	switch (e.getKeyCode()) {
	            	case VK_UP:
	            		if (tempFloor < MTower.maxFloor) {
                            tempFloor++;
                            floortext.setText(tempFloor + "");
                            gameFrame.repaint();
                        }
	            		break;
	            	
	            	case VK_DOWN:
	            		if (tempFloor > 0) {
                            tempFloor--;
                            floortext.setText(tempFloor + "");
                            gameFrame.repaint();
                        }
	            		break;
	            	
	            	case VK_F:
	            		flyPane.remove(flyBgImg);
	                    flyPane.remove(floortext);
	                    gamePanel.remove(flyPane);
	                    
                        inConversation = false;
                        gameFrame.removeKeyListener(this);
                        gameFrame.repaint();
	            		break;
	            	
	            	case VK_ENTER:
	            		currentFloor = tempFloor;
	            		myHero.posX = MapData.flyPos[currentFloor][0];
	            		myHero.posY = MapData.flyPos[currentFloor][1];
	            		
	            		flyPane.remove(flyBgImg);
	                    flyPane.remove(floortext);
	                    gamePanel.remove(flyPane);
	                    
                        inConversation = false;
                        gameFrame.removeKeyListener(this);
                        gameFrame.repaint();
	            		
	            		break;
	            	}
	            }

	            @Override
	            public void keyReleased(KeyEvent e) {
	            }
	        });
	    }
	    
	    private void clearFlyPane() {
	    	
	    }
}
