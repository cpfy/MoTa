package Datas;

import MoTa.MTower;
import Datas.ImageData;
import Datas.MapData;
import Interface.DialogBoard;
import Interface.MessageBoard;

import java.awt.image.BufferedImage;

public class DialogData {

    private static int talkNum[][] = new int[28][20];
    public static boolean fakePrincessIsBeaten = false; 

    public static String[] getDialogData(int id, int floor)
    {
    	//对话类NPC相关
    	
        String[] messages = null;
        
        switch (id) 
        {
            case 24:     //仙子
                messages = new String[]{
                		"元熙九年，天道崩殂；\n恶塔降世，天灾迭出。",
                		"星落平野，日坠东涂；\n饿殍流野，众生皆苦。",

                		"魔踞深堡，公居闺宿；\n公性温善，不忍疾苦。",
                		"昼感嗟叹，夜伏几哭。\n自甘人质，换民庇护。",

                		"东方有士，兼济天下。\n青衫仗剑，誓斩芜杂。",
                		"锈剑破靴，苦水劣马。\n浩然正气，震慑群鸦。",

                		"士有一剑，可破万法。\n一剑夺刃，一剑破甲。",
                		"又有一掌，可除幻化。\n一掌裁决，一掌诛伐。",

                		"士别王国，单刀赴塔。\n民不安居，剑不入匣。",
                		"以眼还眼，以杀止杀。\n士有夙愿，荡尽魔塔。",

                		"——第二章 塔内——"
                };
                break;
            
            case 25:	//小偷
            	break;
            	
            case 26:	//老人
            	switch(floor) 
            	{
            		case 1:
            		messages = new String[]
            		{
        				"听说这座塔不止20层...\n" +
        				"但是最高只能去到第20层...\n" +
        				"真叫人头痛..."
            		};
            		break;
            		
            		case 5:             		
                		switch(talkNum[id][5])
            			{
            			case 0:
            				messages = new String[]
                    		{
                				"这个给你...\n" +
                				"有了这个，\n" +
                				"就可看清楚怪物的能力...",
                				"心镜 按'D'键可知道怪物的能力"
                    		};
            				talkNum[id][5]++;
            				break;
            				
            			default:
            				messages = new String[]
                    		{
                				"哈哈哈哈\n" +
                				"勇者，预知未来的感觉如何...\n"
                    		};
            				break;
            			}
                		
                		break;
                		
                		
            		
            		case 8:
            			switch(talkNum[id][8])
            			{
            			case 0:
            				messages = new String[]
                    		{
                				"你真了不起\n" +
                				"竟然能来到这层！\n" +
                				"这个给你吧",
                				"黄金色羽根 按'F'键可启动飞行功能"
                    		};
            				MTower.canFly = true;
            				talkNum[id][8]++;
            				break;
            				
            			default:
            				messages = new String[]
                    		{
                				"体验怎么样？\n" +
                				"飞行羽毛用的还习惯吗？\n"
                    		};
            				break;
            			}
                		
                		break;
                	
            		case 14:
            			switch(talkNum[id][14])
            			{
            			case 0:
            				messages = new String[]
                    		{
                				"啊啊啊!!!!!!!\n" +
                				"你的剑!!你的盾!!!!\n" +
                				"全是古董呢!!!!!",
                				"我懂鉴定哦，如果你找到了什么宝贝，可以拿给我帮你看看..."
                    		};
            				talkNum[id][14]++;
                    		break;
            				
            			default:
            				messages = new String[]
                    		{
                				"怎样？\n" +
                				"不是有东西要判定吗？"
                    		};
            				break;
            			}
            		
            		case 19:
                		messages = new String[]
                		{
            				"公主就在上一层\n" +
            				"但听说有恶魔守着，\n" +
            				"如果实力不够千万不要上去"
                		};
                		break;
            	}
            	break;
            	
            case 27:	//商人
            	switch(floor) 
            	{
            		case 0:
            		messages = new String[]
            		{
        				"又是挑战者吗?\n" +
        				"希望你能够活着回去，\n" +
        				"嘻嘻嘻嘻..."
            		};
            		break;
            		
            		case 1:
            		messages = new String[]
            		{
        				"你知道什么是章吗?\n" +
        				"在这里有数个不同的章，只要\n" + 
        				"拿到就可以得到一些有利战斗\n" +
        				"的能力，",
        				"但是章要被鉴定后才可使用，你必须找一个懂鉴定的人！"
            		};
            		break;
            		
	            	case 2:
	            		messages = new String[]
	            		{
            				"你认识那个被抓住的盗贼吗？\n" +
	            			"听说他来这里是为了找一个" + 
            				"锄头.不知他要来干什么呢..."
	            		};
	            		break;
	            	
	            	case 13:
	            		messages = new String[]
	            		{
            				"那些骑士的必杀率高达30%，\n" +
	            			"请小心..."
	            		};
	            		break;
            	}
            	break;
            	
            case 28:	//公主
            	switch(floor) {
            	case 20:
            		if(!fakePrincessIsBeaten) {
            			messages = new String[]
                		{
            				"...........\n",
                			"哈哈哈哈哈哈哈哈哈\n" +
            				"受死吧!!!(男音)"
                		};
            		}
            		
            		else {
            			messages = new String[]
                		{
            				"这怎么可能...\n",
                			"啊啊啊啊...\n",
            				"啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊~~~\n"
                		};
            		}
            		
            		break;
            	
            	case 21:
            		messages = new String[]
            		{
        				"终于等到你...\n",
            			"The End."
            		};
            		break;
            	}
            	break;
        }
        return messages;
    }
    
    public static BufferedImage getNPCImage(int id)
    {
    	BufferedImage imgNPC;
        imgNPC = MTower.imgSource.get(id);
        return imgNPC;
    }
    
    public static String getNPCName(int id, int floor)
    {
    	switch(id)
    	{
    		case 22: return "商店";
	    	case 24: return "仙子";
	    	case 25: return "小偷";
	    	case 26: return "老人";
	    	case 27: return "商人";
	    	case 28: 
	    		if(floor == 21) return "公主";
	    		else return "假公主";
	    	default: return "Void";
    	}
    }
    
    public static String[] getShopData(int id, int floor)
    {
    	String[] messages = null;
        
        switch (id) 
        {
            case 22:     //商店
            	switch(floor)
            	{
            	case 3:
            		messages = new String[]{
                    		"人类啊！如果你愿意\n" + 
                			"给我 20 个金币的话，\n" +
                			"我可以加强你的战斗力！",
                			"● 增加 500 点生命\n",
                			"⭕ 增加 3 点攻击力\n",
                			"⭕ 增加 3 点防御力\n",
                			"⭕ 离开\n"
                    };
                    break;
                
            	case 7:
            		messages = new String[]{
                    		"可怜的勇者啊！\n" + 
                			"我可以将你累积得来的\n" +
                			"经验化作你的力量！",
                			"● 提升 1 个等级(Exp70)\n",
                			"⭕ 增加 1 点攻击力(Exp20)\n",
                			"⭕ 增加 2 点防御力(Exp20)\n",
                			"⭕ 离开\n"
                    };
                    break;
                    
            	}
            	break;
           
            case 25:	//小偷
            	switch(floor)
            	{
            	case 2:
            		messages = new String[]{
                    		"来！手上缺少哪一种\n" + 
                			"钥匙？我有大量的！\n",
                			"● 黄钥匙($20)\n",
                			"⭕ 蓝钥匙($80)\n",
                			"⭕ 离开\n"
                    };
            		break;
            	}
            	break;
            
            case 26:	//老人
            	break;
            	
            case 27:     //商人
            	switch(floor)
            	{
            	case 4:
            		messages = new String[]{
                    		"15个金币就可以恢复\n" + 
                			"200点生命\n" +
                			"需要吗？",
                			"● 要！\n",
                			"⭕ 离开\n"
                    };
                    break;
                
            	case 5:
            		messages = new String[]{
                    		"我这里有两颗红宝石，\n" + 
                			"你想要吗？\n" +
                			"40个金币卖给你吧",
                			"● 要！\n",
                			"⭕ 离开\n"
                    };
                    break;
                
            	case 15:
            		messages = new String[]
            		{
        				"你有钥匙吗?\n" +
        				"我愿意大量收购\n",
        				"● 黄钥匙($10)\n",
        				"⭕ 蓝钥匙($40)\n",
        				"⭕ 红钥匙($150)\n",
        				"⭕ 离开"
            		};
            		break;
                    
            	}
            	break;
            	
        }
        return messages;
    }
}