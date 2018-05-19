/**
 * 描述: 
 * MavenRepositoryCleaner.java
 * @author	qye.zheng
 * 
 *  version 1.0
 */
package com.hua.starter;

import org.junit.Test;

import com.hua.maven.MavenRepositoryService;

/**
 * 描述: 启动器
 * @author  qye.zheng
 * 
 * MavenRepositoryCleaner
 */
public final class MavenRepositoryCleaner
{

	private MavenRepositoryService repositoryService = new MavenRepositoryService();
	

	// 启动器模板
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void start()
	{
		/** ===== begin 驱动参数设置  ===== */
		// 设置例子
		String repositoryPath = null;
		//repositoryPath = "E:/repo/org/springframework/spring-parent";
		//repositoryPath = "E:/repo/org/springframework";
		repositoryPath = "E:/repo";
		/** ===== end of 驱动参数设置 ===== */

		// 启动驱动
		repositoryService.clean(repositoryPath);			
		
	}

}
