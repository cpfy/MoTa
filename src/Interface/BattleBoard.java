package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import MoTa.MTower;
import Objects.Monster;
import Datas.ImageData;
import Datas.MonsterData;
import Datas.DialogData;

import static MoTa.MTower.*;
import static Datas.MapData.OneMap;
import static Datas.ImageData.battleBgImg;

public class BattleBoard {
    // 战斗页面文字Font
    private static final Font BATTLE_FONT = new Font("黑体", Font.BOLD, 35);
    private static final Font VICTORY_FONT = new Font("黑体", Font.BOLD, 50);

    public static JLayeredPane battlePane = new JLayeredPane();       // 战斗信息面板
    //public static JLayeredPane victoryPane = new JLayeredPane();       // 战斗信息面板

    private JLabel battleBg = new JLabel();
    private JLabel victoryBg = new JLabel();
    
    private JLabel monsterImg = new JLabel();       // 怪物图片
    private JLabel monster_name = new JLabel();      // 怪物名称
    private JLabel monster_hp = new JLabel();       // 怪物生命值
    private JLabel monster_attack = new JLabel();   // 怪物攻击力
    private JLabel monster_defence = new JLabel();  // 怪物防御力
    private JLabel monster_speed = new JLabel();   	// 怪物敏捷
    
    private JLabel player_hp = new JLabel();        // 玩家生命值
    private JLabel player_attack = new JLabel();    // 玩家攻击力
    private JLabel player_defence = new JLabel();   // 玩家防御力
    private JLabel player_speed = new JLabel();    	// 玩家敏捷

    private JLabel monster_exp = new JLabel();  					// 怪物掉落经验
    private JLabel monster_gold = new JLabel();   					// 怪物掉落金币

    private Monster monster;
    private int hp;
    private int attack;
    private int defence;
    private int speed;
    
    private boolean runaway = false;

    public BattleBoard(int id, int x, int y) //x,y坐标
    {

        monster = MonsterData.monsterMap.get(id);
        hp = monster.getHealth();
        attack = monster.getAttack();
        defence = monster.getDefence();
        speed = monster.getSpeed(); 

        // 取图
        battleBg = new JLabel(new ImageIcon(battleBgImg));
        monsterImg = new JLabel(new ImageIcon(imgSource.get(id)));

        // 初始化 战斗信息面板
        battlePane.setLayout(null);
        battlePane.setBounds(0, 0, PIX69*18, PIX69*13);
        
        battleBg.setBounds(375, 300, 837, 286);
        battlePane.add(battleBg, 1, 0);
        battlePane.setVisible(false);

        //
        int offsetY = 250;
        int locX1 = 660;
        int locX2 = 890;
        
        monsterImg.setBounds(449, 375, PIX69, PIX69);
        
        monster_name.setBounds(locX1 - 240 , -60 + offsetY, 300, 300);
        monster_name.setFont(BATTLE_FONT);
        monster_name.setForeground(Color.WHITE);
        
        monster_hp.setBounds(locX1, 0 + offsetY, 300, 300);
        monster_hp.setFont(BATTLE_FONT);
        monster_hp.setForeground(Color.WHITE);

        monster_attack.setBounds(locX1, 50 + offsetY, 300, 300);
        monster_attack.setFont(BATTLE_FONT);
        monster_attack.setForeground(Color.WHITE);

        monster_defence.setBounds(locX1, 100 + offsetY, 300, 300);
        monster_defence.setFont(BATTLE_FONT);
        monster_defence.setForeground(Color.WHITE);
        
        monster_speed.setBounds(locX1, 150 + offsetY, 300, 300);
        monster_speed.setFont(BATTLE_FONT);
        monster_speed.setForeground(Color.WHITE);

        player_hp.setBounds(locX2, 0 + offsetY, 300, 300);
        player_hp.setFont(BATTLE_FONT);
        player_hp.setForeground(Color.WHITE);

        player_attack.setBounds(locX2, 50 + offsetY, 300, 300);
        player_attack.setFont(BATTLE_FONT);
        player_attack.setForeground(Color.WHITE);

        player_defence.setBounds(locX2, 100 + offsetY, 300, 300);
        player_defence.setFont(BATTLE_FONT);
        player_defence.setForeground(Color.WHITE);
        
        player_speed.setBounds(locX2, 150 + offsetY, 300, 300);
        player_speed.setFont(BATTLE_FONT);
        player_speed.setForeground(Color.WHITE);

        battlePane.add(monster_name, 2, 0);
        battlePane.add(monster_hp, 3, 0);
        battlePane.add(monster_attack, 4, 0);
        battlePane.add(monster_defence, 5, 0);
        battlePane.add(monster_speed, 6, 0);
        
        
        battlePane.add(player_hp, 7, 0);
        battlePane.add(player_attack, 8, 0);
        battlePane.add(player_defence, 9, 0);
        battlePane.add(player_speed, 10, 0);
        
        battlePane.add(monsterImg, 11, 0);
        
        monster_name.setText(monster.getName() + "");
        monster_hp.setText(hp + "");
        monster_attack.setText(attack + "");
        monster_defence.setText(defence + "");
        monster_speed.setText(speed + "");

        player_hp.setText(myHero.getHealth() + "");
        player_attack.setText(myHero.getAttack() + "");
        player_defence.setText(myHero.getDefence() + "");
        player_speed.setText(myHero.getSpeed() + "");
        
        battlePane.setVisible(true);
        MTower.inConversation = true;
        
        KeyAdapter battleKeyListener = new KeyAdapter()	//Q键逃跑的keyListener
        {
        	public void keyPressed(KeyEvent e) 
            {
                if (e.getKeyCode() == e.VK_Q) 
                {
                	//System.out.print("press Q.\n");
                	runaway = true;
                }
            }
        };
        
        gameFrame.addKeyListener(battleKeyListener);
        
        Timer bFrame = new Timer(500, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ex) {
                attack();
                monster_hp.setText(hp + "");
                player_hp.setText(myHero.getHealth() + "");
                MTower.gameFrame.repaint();
                
                if (hp <= 0 || runaway == true) 
                {
                	/*
                	addVictory();
                	battlePane.setVisible(true);
                	gameFrame.repaint();
                	
                	try{
                		Thread.sleep(1000);
                	}catch(InterruptedException e){
                        System.err.format("IOException: %s%n", e);
                    };*/
                	
                	((Timer) ex.getSource()).stop();
                	clearPane();
                    battlePane.setVisible(false);
                    MTower.inConversation = false;
                    
                    gameFrame.removeKeyListener(battleKeyListener);
                    
                    if(!runaway) {
                    	myHero.addExp(monster.getExp());	
                        myHero.addGold(monster.getGold());
                        //MsgUtil.displayMessage("获得金币数 " + Monster.getExp() + " 经验值 " + Monster.getMoney() + " ！");
                        
                        if(id == 28) defeatFakePrincess(y, x);

                        else if(id == 198) clearNineGrid(y,x);
                        
                        else OneMap[currentFloor][y][x] = 0;
                    }

                    runaway = false;  
                }
            }
        });
        bFrame.start();
    }
    
    private void clearPane()
    {
    	battlePane.remove(monsterImg);
        battlePane.remove(monster_name);
        battlePane.remove(monster_hp);
        battlePane.remove(monster_attack);
        battlePane.remove(monster_defence);
        battlePane.remove(monster_speed);
        
        battlePane.remove(player_hp);
        battlePane.remove(player_attack);
        battlePane.remove(player_defence);
        battlePane.remove(player_speed);
        
        battlePane.remove(victoryBg);
        battlePane.remove(monster_exp);
        battlePane.remove(monster_gold);
    }

    private void attack()
    {
    	double crit = Math.random();
    	double miss = Math.random();
    	
        if (myHero.getAttack() > defence) 
        {
        	if(crit <= myHero.getCritical()) //暴击2倍伤害
        	{
        		if(miss > monster.getSpeed()/100)//怪物闪避
        			hp = hp - (myHero.getAttack() - defence)*2;
        	}
        	else if(miss > monster.getSpeed()/100) 
        		hp = hp - myHero.getAttack() + defence;
        }
        
        if (hp <= 0) return;
        
        if (attack > myHero.getDefence()) 
        {
        	if(miss > myHero.getSpeed()/100)	//英雄未闪避
        		myHero.loseHealth(attack - myHero.getDefence());
        }
        
        if (myHero.getAttack() < defence && attack < myHero.getDefence()) return;
    }
    
    private void addVictory()
    {
    	//战斗胜利信息:        
        // 取图        
        victoryBg = new JLabel(new ImageIcon(ImageData.victoryBgImg));
        
        victoryBg.setBounds(375, 575, 838, 80);
        
        //位置
        monster_exp.setBounds(660 + 120, 220 + 250, 300, 300);
        monster_exp.setFont(VICTORY_FONT);
        monster_exp.setForeground(Color.WHITE);
        
        monster_gold.setBounds(660 + 400, 220 + 250, 300, 300);
        monster_gold.setFont(VICTORY_FONT);
        monster_gold.setForeground(Color.WHITE);
        
        battlePane.add(victoryBg, 11, 0);
        battlePane.add(monster_exp, 12, 0);
        battlePane.add(monster_gold, 13, 0);
        
        //文字内容
        monster_exp.setText(monster.getExp() + "");
        monster_gold.setText(monster.getGold() + "");
    }
    
    private void clearNineGrid(int y, int x)
    {
    	OneMap[currentFloor][y][x] = 0;
    	OneMap[currentFloor][y][x-1] = 0;
    	OneMap[currentFloor][y][x+1] = 0;
    	OneMap[currentFloor][y-1][x] = 0;
    	OneMap[currentFloor][y-1][x-1] = 0;
    	OneMap[currentFloor][y-1][x+1] = 0;
    	OneMap[currentFloor][y-2][x] = 0;
    	OneMap[currentFloor][y-2][x-1] = 0;
    	OneMap[currentFloor][y-2][x+1] = 0;
    }
    
    private void defeatFakePrincess(int y, int x)
    {
    	OneMap[currentFloor][y][x] = 13;	//21F隐藏门
    	
    	OneMap[currentFloor][0][0] = 6;
    	OneMap[currentFloor][0][1] = 11;
    	OneMap[currentFloor][0][2] = 11;
    	OneMap[currentFloor][0][3] = 11;
    	
    	OneMap[currentFloor][0][7] = 11;
    	OneMap[currentFloor][0][8] = 11;
    	OneMap[currentFloor][0][9] = 11;
    	OneMap[currentFloor][0][10] = 6;
    	
    	OneMap[currentFloor][1][0] = 7;
    	OneMap[currentFloor][1][1] = 9;
    	OneMap[currentFloor][1][2] = 9;
    	OneMap[currentFloor][1][3] = 9;
    	
    	OneMap[currentFloor][1][7] = 10;
    	OneMap[currentFloor][1][8] = 10;
    	OneMap[currentFloor][1][9] = 10;
    	OneMap[currentFloor][1][10] = 7;
    	
    	OneMap[currentFloor][4][0] = 14;
    	OneMap[currentFloor][4][10] = 14;	//下楼
    	
    	OneMap[currentFloor][3][5] = 0;
    	
    	DialogData.fakePrincessIsBeaten = true;
    	
    	new DialogBoard(28, x, y);
    }
    
}