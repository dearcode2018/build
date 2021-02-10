/**
  * @filename ApplicationMain.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.main;

import com.hua.util.EmptyUtil;

/**
 * @type ApplicationMain
 * @description 
 * @author qianye.zheng
 */
public final class ApplicationMain {

	/**
	 * @description 
	 * @param args
	 * @author qianye.zheng
	 */
	public static void main(String[] args) {
		if (EmptyUtil.isNotEmpty(args)) {
			for (int i = 0; i < args.length; i++) {
				System.out.println(String.format("arg[%d] = %s", i, args[i]));
			}
		}
	}

}
