/**
  * @filename MavenRepositoryService.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.maven;

import java.io.File;

import com.hua.util.EmptyUtil;
import com.hua.util.FileUtil;
import com.hua.util.ZipUtil;

 /**
 * @type MavenRepositoryService
 * @description Maven 仓库
 * @author qianye.zheng
 */
public class MavenRepositoryService
{
	private static final String JAR_FILE_SUFFIX = ".jar";
	
	
	/**
	 * 1. 到达文件层 arrive
	 * 2.寻找jar文件 findJar();
	 * 3.检查jar文件中是否有损坏的 ZipUtil.isDamage();
	 * 4.有损坏，则删除改文件所在的级目录 File.delete();
	 * 
	 */
	
	/**
	 * 
	 * @description 清理仓库含有损坏文件的目录
	 * 删除完之后，让maven插件重新下载依赖
	 * @param repositoryPath 仓库路径
	 * @author qianye.zheng
	 */
	public void clean(final String repositoryPath)
	{
		final File repositoryFile = new File(repositoryPath);
		//
		recursive(repositoryFile);
	}
	
	/**
	 * 
	 * @description 递归遍历目录
	 * @param file
	 * @author qianye.zheng
	 */
	private void recursive(File file)
	{
		final File[] files = file.listFiles();
		for (File subFile : files)
		{ // 发现一个是文件，则只遍历一次
			if (subFile.isFile())
			{
				/*
				 * 是文件，说明已经导到文件层
				 * 处理文件所在的目录
				 */
				final File[] jarFiles = findJar(file);
				if (EmptyUtil.isEmpty(jarFiles))
				{
					// 不含有jar文件，则结束当前处理
					break;
				}
				boolean hasDamage = false;
				for (File jarF : jarFiles)
				{
					if (ZipUtil.isDamage(jarF))
					{
						hasDamage = true;
						
						break;
					}
				}
				// 检查是否有损坏的文件
				if (hasDamage)
				{
					System.out.println("删除目录: " + file.getPath());
					// 删除该目录
					FileUtil.delete(file);
					
					// 删除完成之后就结束当前目录的循环
					break;
				}
			} else
			{ // 递归调用: 目录，则继续循环往下遍历
				recursive(subFile);
			}
		}
	}
	
	/**
	 * 
	 * @description 在当前目录下寻找jar文件
	 * @param directory 目录
	 * @return
	 * @author qianye.zheng
	 */
	private File[] findJar(final File directory)
	{
		// 
		final File[] files = directory.listFiles((x, y) -> y.endsWith(JAR_FILE_SUFFIX));
		
		return files;
	}
	
}
