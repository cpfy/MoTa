package Datas;

import java.util.HashMap;
import Objects.Monster;

//存放魔塔怪物的属性数据
public class MonsterData {

    public static HashMap<Integer, Monster> monsterMap = new HashMap<>();

    static 
    {
        monsterMap.clear();
        monsterMap.put(40, new Monster(0, "绿史莱姆", 40, 18, 1, 0, 1, 1));///
        monsterMap.put(41, new Monster(1, "红史莱姆", 50, 20, 4, 0, 2, 1));///
        monsterMap.put(42, new Monster(2, "小蝙蝠", 55, 32, 2, 4, 3, 1));///
        monsterMap.put(43, new Monster(3, "黑史莱姆", 80, 37, 9, 0, 5, 1));///
        monsterMap.put(44, new Monster(4, "小骷髅", 95, 70, 0, 3, 5, 1));///
        monsterMap.put(45, new Monster(5, "骷髅队长", 190, 100, 5, 3, 13, 2));///
        monsterMap.put(46, new Monster(6, "兽人", 190, 90, 33, 2, 15, 2));///
        monsterMap.put(47, new Monster(7, "初级守卫", 85, 40, 55, 3, 6, 1));///
        monsterMap.put(48, new Monster(8, "大蝙蝠", 66, 55, 12, 4, 6, 1));///
        monsterMap.put(49, new Monster(9, "红蝙蝠", 210, 185, 70, 4, 24, 3));///
        
        //monsterMap.put(50, new Monster(10, "白衣魔王", 1300, 300, 3, 150, 40, 35));
        
        monsterMap.put(50, new Monster(10, "大法师", 450, 100, 302, 1, 77, 8));///
        monsterMap.put(51, new Monster(11, "红衣法师", 500, 400, 260, 2, 47, 45));
        monsterMap.put(52, new Monster(12, "史莱姆王", 172, 130, 60, 2, 19, 2));///    
        
        //monsterMap.put(53, new Monster(13, "红衣魔王", 15000, 1000, 1000, 3, 100, 100));
        
        monsterMap.put(53, new Monster(13, "高级法师", 290, 40, 90, 0, 27, 3));///
        monsterMap.put(54, new Monster(14, "初级骑士", 130, 115, 43, 4, 17, 2));///
        monsterMap.put(55, new Monster(15, "高级武士", 900, 750, 650, 3, 77, 70));
        monsterMap.put(56, new Monster(16, "中级骷髅队长", 290, 170, 23, 3, 21, 3));///
        monsterMap.put(57, new Monster(17, "幽冥法师", 1500, 830, 730, 3, 80, 70));
        monsterMap.put(58, new Monster(18, "幽冥战士", 1200, 980, 900, 3, 88, 75));
        monsterMap.put(59, new Monster(19, "幽冥魔王", 30000, 1700, 1500, 5, 250, 220));
        monsterMap.put(60, new Monster(20, "黄衣法师", 250, 120, 70, 2, 20, 17));
        monsterMap.put(61, new Monster(21, "灵骷髅", 800, 602, 560, 4, 30, 4));///
        monsterMap.put(62, new Monster(22, "骷髅灵战士", 2500, 900, 850, 3, 84, 75));
        monsterMap.put(63, new Monster(23, "初级法师", 65, 10, 5, 0, 4, 1));///
        monsterMap.put(64, new Monster(24, "中级法师", 190, 20, 20, 0, 8, 1));///
        monsterMap.put(65, new Monster(25, "石怪", 30, 45, 70, 0, 7, 1));///
        monsterMap.put(66, new Monster(26, "兽人队长", 900, 450, 330, 3, 50, 50));
        monsterMap.put(67, new Monster(27, "双手剑士", 280, 210, 110, 4, 34, 4));///
        monsterMap.put(68, new Monster(28, "中级守卫", 775, 220, 310, 3, 63, 7));///
        monsterMap.put(69, new Monster(29, "高级守卫", 1500, 560, 460, 2, 60, 60));
        monsterMap.put(70, new Monster(30, "史莱姆人", 90, 79, 24, 30, 10, 2));///
        
        monsterMap.put(198, new Monster(198, "巨大八爪鱼", 700, 295, 120, 5, 170, 18));///
        
        monsterMap.put(28, new Monster(28, "假公主", 10000, 270, 160, 5, 120, 13));///
    }
}