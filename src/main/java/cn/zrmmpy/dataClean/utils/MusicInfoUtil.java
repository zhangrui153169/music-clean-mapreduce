package cn.zrmmpy.dataClean.utils;

import java.util.Random;

public class MusicInfoUtil {

	public static int getCategory(String musicinfo) {
		Random random=new Random();
		
		return random.nextInt(14)+1;	
	}
}
