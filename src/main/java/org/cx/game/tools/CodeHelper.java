package org.cx.game.tools;

public class CodeHelper {

	public static final Integer Prefix_Corps = 101;
	public static final Integer Prefix_Skill = 102;
	public static final Integer Prefix_Buff = 103;
	public static final Integer Prefix_Spell = 108;
	
	public static Integer getPrefixByCode(Integer code) {
		String prefix = code.toString().substring(0,3);
		return Integer.valueOf(prefix);
	}
	
	public static void main(String[] args) {
		Integer i = 101020001;
		System.out.println(getPrefixByCode(i));
	}
}
