/**
  * @filename BuildMain.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.maven;

import com.hua.util.StringUtil;

/**
 * @type BuildMain
 * @description 
 * @author qianye.zheng
 */
public class BuildMain
{

	/**
	 * @description 
	 * @param args
	 * @author qianye.zheng
	 */
	public static void main(String[] args)
	{
		if (StringUtil.isNotEmpty(args[0]))
		{
			System.out.println("args[0] is not empty value = " + args[0]);
		}
		
		System.out.println("BuildMain.main()");
	}

}
