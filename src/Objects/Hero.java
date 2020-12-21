package Objects;

import java.awt.image.BufferedImage;
import Datas.ImageData;

public class Hero {
	enum HeroState	//英雄状态
	{
		normal, died, poisoned, weak 
	}
	
	private int health;		//生命值
	private int attack;		//攻击力
	private int defence;	//防御力
	private int speed;		//敏捷（先后手/闪避）
	private int gold;		//金币
	private int exp;		//经验
	private double critical;	//暴击率
	private int[] keys = new int[3];		//钥匙
	private HeroState s1 = HeroState.normal;		//当前状态
	
	private int level;		//等级
	public int posX;		//位置
	public int posY;
	private int towards;	//朝向: 0=上, 1=右, 2=下, 3=左
	
	//初始化构造方法
    public Hero() 
    {
        this.health = 50000;
        this.attack = 100;
        this.defence = 100;
        this.speed = 2;
        this.gold = 0;
        this.exp = 0;
        this.critical = 0.1;
        
        this.keys[0] = 1;	//黄钥匙
        this.keys[1] = 1;	//蓝钥匙
        this.keys[2] = 1;	//红钥匙
        
        this.level = 1;
        this.posX = 5;
        this.posY = 9;
        this.towards = 0;
    }
    
    //属性获取相关
    public int getHealth() 
	{
        return health;
    }

    public int getAttack()
    {
        return attack;
    }

    public int getDefence()
    {
        return defence;
    }
    
    public int getSpeed() 
    {
    	return speed;
    }

    public int getGold()
    {
        return gold;
    }
    
    public int getExp()
    {
        return exp;
    }

    public double getCritical() 
    {
        return critical;
    }
    
    public int getKey(int keyID)
    {
    	return keys[keyID];
    }
    
    public int getLevel() 
    {
        return level;
    }
    
    public int getPosX() 
    {
        return posX;
    }
    
    public int getPosY() 
    {
        return posY;
    }
    
    public int getTowards()
    {
    	return towards;
    }
    
    public String getHeroStates()
    {
    	switch(s1)
    	{
	    	case normal: return "正常";
	    	case died: return "死亡";
	    	case poisoned: return "中毒";
	    	case weak: return "虚弱";
	    	default: return "Error";
    	}
    }
    
    //set相关
    public void setHealth(int health)
    {
        this.health = health;
    }

    public void setAttack(int attack) 
    {
    	this.attack = attack;
    }
    
    public void setDefence(int defence)
    {
        this.defence = defence;
    }
    
    public void setSpeed(int speed)
    {
    	this.speed = speed;
    }
    
    public void setGold(int gold)
    {
    	this.gold = gold;
    }
    
    public void setExp(int exp)
    {
    	this.exp = exp;
    }
    
    public void setCritical(int critical)
    {
    	this.critical = critical;
    }
    
    public void setKey(int keyID, int keyNum)
    {
    	this.keys[keyID] = keyNum; 
    }
    
    public void setLevel(int level)
    {
    	this.level = level;
    }
    
    //位置瞬移传送相关操作
    
    public void setPosX(int posX)
    {
    	this.posX = posX;
    }
    
    public void setPosY(int posY)
    {
    	this.posY = posY;
    }
    
    public void setTowards(int towards)
    {
    	this.towards = towards;
    }
    
    public void setHeroStates(int a)
    {
    	switch(a)
    	{
	    	case 0:
	    		this.s1 = HeroState.normal;
	    		break;
	    	case 1:
	    		this.s1 = HeroState.died;
	    		break;
	    	case 2:
	    		this.s1 = HeroState.poisoned;
	    		break;
	    	case 3:
	    		this.s1 = HeroState.weak;
	    		break;
    	}
    }
    
    //以下为属性修改相关
    
    public void addHealth(int h)
    {
    	health += h;
    }
    
    public void loseHealth(int damage) 
    {
    	if(health - damage <= 0) 
    	{
    		s1 = HeroState.died;
    	}
    	else 
    	{
    		health -= damage;
    	}
    }
    
    
    public void addAttack(int atk)
    {
    	attack += atk;
    }
    
    public void addDefence(int def)
    {
    	defence += def;
    }
    
    public void addSpeed(int sp)
    {
    	speed += sp;
    }
    
    public void addLevel(int l)
    {
    	level += l;
    }
	
    public void addGold(int g)
    {
    	gold += g;
    }
    
    public void spendGold(int g)
    {
    		gold -= g;
    }
    
    public boolean enoughGold(int g)
    {
    	if(g > gold) 
    	{
    		return false;
    	}
    	else
    	{
    		return true;
    	}
    }
    
    public void addExp(int e)
    {
    	exp += e;
    }
    
    public void spendExp(int e)
    {
    		exp -= e;
    }
    
    public boolean enoughExp(int e)
    {
    	if(e > exp) 
    	{
    		return false;
    	}
    	else
    	{
    		return true;
    	}
    }
    
    public void addKey(int keyID)
    {
    	keys[keyID] += 1; 
    }
    
    public boolean enoughKey(int keyID)
    {
    	if(keys[keyID] == 0)
    	{
    		return false;
    	}
    	else
    	{
    		return true;
    	}
    }
    
    public void useKey(int keyID)
    {
    	keys[keyID] -= 1; 
    }
    
    //移动相关
    
    public void move(int x, int y)
    {
    	posX = x;
    	posY = y;
    }
    
    //绘图相关
    public BufferedImage draw()
    {
    	return ImageData.playerMap.get(towards);
    }

}
