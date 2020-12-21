package Objects;

//import Objects.Hero.HeroState;

public class Monster {
	enum LifeState	//怪物状态
	{
		alive, died
	}
	
	private int id;			//怪物序号
	private String name;	//名字
	private int health;		//生命值
	private int attack;		//攻击力
	private int defence;	//防御力
	private int speed;		//敏捷（先后手/闪避/攻击频率）
	private int gold;		//掉落金币
	private int exp;		//掉落经验
	private LifeState s = LifeState.alive;		//当前状态
	
	public Monster(int id, String name, int health, int attack, int defence, int speed, int gold, int exp) 
	{
        this.id = id;
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
        this.gold =  gold;
        this.exp = exp;
    }
	
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

    public String getName() 
    {
        return name;
    }

}
