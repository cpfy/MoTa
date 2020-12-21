package Datas;

import static MoTa.MTower.currentFloor;
import static MoTa.MTower.myHero;

public class ShopData {
	
	public static void doShop(int id, int floor, int selection)
	{
		switch(id)
    	{
    	case 22://商店
    		switch(floor)
    		{
    		case 3://3F商店
    			switch(selection)
    			{
    			case 1://"● 增加 500 点生命\n",
    				if (myHero.getGold() >= 20) {
                        myHero.spendGold(20);
                        myHero.addHealth(500);
                    }
                    break;
    				
    			case 2://"⭕ 增加 3 点攻击力\n",
    				if (myHero.getGold() >= 20) {
                        myHero.spendGold(20);
                        myHero.addAttack(3);
                    }
                    break;
    			
    			case 3://"⭕ 增加 3 点防御力\n",
    				if (myHero.getGold() >= 20) {
                        myHero.spendGold(20);
                        myHero.addDefence(3);
                    }
    				break;
    			}
    			//System.out.print(selection + "," + myHero.getGold() + "\n");
				break;
				
			case 7://7F商店
				switch(selection)
    			{
    			case 1: //"● 提升 1 个等级(Exp70)\n"
    				if (myHero.getExp() >= 70) {
                        myHero.spendExp(70);
                        myHero.addLevel(1);
                        myHero.addHealth(250);
                        myHero.addAttack(3);
                        myHero.addDefence(3);
                    }
                    break;
    				
    			case 2: //"⭕ 增加 1 点攻击力(Exp20)\n"
    				if (myHero.getExp() >= 20) {
                        myHero.spendExp(20);
                        myHero.addAttack(1);
                    }
                    break;
                
    			case 3: //"⭕ 增加 2 点防御力(Exp20)\n"
    				if (myHero.getExp() >= 20) {
                        myHero.spendExp(20);
                        myHero.addDefence(2);
                    }
    				break;
    			}
				break;
    			
    		}
    		break;
    		
    	case 25: //小偷
    		switch(floor)
    		{
    		case 2://2F卖钥匙的
    			if(selection == 1) {
    				if (myHero.getGold() >= 20) {
                        myHero.spendGold(20);
                        myHero.addKey(0);
                    }
    			}
    			
    			else if(selection == 2) {
    				if (myHero.getGold() >= 80) {
                        myHero.spendGold(80);
                        myHero.addKey(1);
                    }
    			}
    			break;
    		}
    		break;
    		
    	case 26: //老人
    		break;
    		
    	case 27: //商人
    		switch(floor)
    		{
    		case 4://4F商人
    			if(selection == 1) {
    				if (myHero.getGold() >= 15) {
                        myHero.spendGold(15);
                        myHero.addHealth(200);     
                    }
    			}
    			break;
    		
    		case 15://15F收购钥匙
    			switch(selection)
    			{
    			case 1: //"黄钥匙($10)\n",
    				if (myHero.getKey(0) >= 1) {
                        myHero.useKey(0);
                        myHero.addGold(10);
                    }
                    break;
    				
    			case 2: //"⭕ 蓝钥匙($40)\n",
    				if (myHero.getKey(1) >= 1) {
                        myHero.useKey(1);
                        myHero.addGold(40);
                    }
                    break;
                
    			case 3: //"⭕ 红钥匙($150)\n",
    				if (myHero.getKey(2) >= 1) {
                        myHero.useKey(2);
                        myHero.addGold(150);
                    }
    				break;
    			}
				break;
    		}
    		break;
    	}
    }
	
	
	public static boolean isShopper(int id, int floor)
	{
		switch(id)
		{
		case 25://小偷
			if(floor == 2) return true;
			else return false;
		
		case 26://老人
			//if(floor == 4 || floor == 5) return true;
			return false;
		
		case 27://商人
			if(floor == 4 || floor == 5 || floor == 15) return true;
			else return false;
		
		default: return false;
		}
		
	}
}
