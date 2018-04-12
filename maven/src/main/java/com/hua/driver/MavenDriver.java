/**
 * 描述: 
 * MavenDriver.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.driver;

import java.util.List;

import com.hua.bean.LoadProjectParam;
import com.hua.bean.ProjectInfo;
import com.hua.constant.Constant;
import com.hua.constant.MavenConstant;
import com.hua.util.ClassPathUtil;
import com.hua.util.EmptyUtil;
import com.hua.util.FileUtil;
import com.hua.util.ProjectUtil;


/**
 * 描述:  - 驱动器
 * @author  qye.zheng
 * MavenDriver
 */
public class MavenDriver
{
	
	/* jar install 模板文件的路径 */
	private static final String jarInstallTemplateFilePath = ClassPathUtil.getClassSubpath("/conf/bat/JarInstall.bat");
	
	/**
	 * 因为不需要去执行bat下的脚本，因此把bat目录隐藏起来
	 * 把 doc下的 bat 目录隐藏一起，文件名前缀加上 . ，在eclipse中进行重命名
	 */
	
	/* jar install 文件的路径 */
	private static final String jarInstallFilePath = ProjectUtil.getAbsolutePath("/doc/.bat/JarInstall.bat", true);	
	
	// maven 安装器路径，
	private static final String mavenInstallPath = ProjectUtil.getAbsolutePath("/doc/.bat/MavenIntaller.bat", true);

	/**
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 */
	private MavenDriver()
	{
	}

	/**
	 * 
	 * 描述: 安装 jar包 支持 类文件、源码文件安装
	 * @author  qye.zheng
	 * @return
	 */
	public static final boolean installJar()
	{
		/**
		 * 由于 mvn install:install-file 命令在批处理脚本执行过程中
		 * 出现执行完一个之后就闪退，因此，多个命令就需要通过
		 * for循环中逐次执行
		 */
		boolean flag = false;
		try
		{
			final List<ProjectInfo> infos = LoadProjectParam.getInfos();
			if (!EmptyUtil.isEmpty(infos))
			{
				String command = null;
				Runtime rt = null;
				String content = null;
				Process process = null;
				for (ProjectInfo info : infos)
				{
					// 获取模板文件的内容 注意 bat 文件应该使用中文编码
					content = FileUtil.getString(jarInstallTemplateFilePath, Constant.CHART_SET_GB2312);
					// 进行内容替换
					content = content.replace(MavenConstant.MVN_INSTALL_BAT_REPLACE_SYMBOL, info.getClassOrder());
					// 输出到指定的文件，注意 bat 文件应该使用中文编码
					FileUtil.writeString(jarInstallFilePath, content, Constant.CHART_SET_GB2312);
					
					// 调用 windows bat 脚本
					command = "cmd /c start " + mavenInstallPath;
					System.out.println("execute command: " + command);
					rt = Runtime.getRuntime();
					process = rt.exec(command);
	
					// 无法实现
					//process.waitFor(5, TimeUnit.SECONDS);
					
					/*
					 * 需要等待 一个命令执行完毕 然后再执行后下一个
					 * 应该让主线程 休息 一定的时间，然后再继续执行
					 */
					Thread.sleep(1 * 1000);
					
					// 获取模板文件的内容 注意 bat 文件应该使用中文编码
					content = FileUtil.getString(jarInstallTemplateFilePath, Constant.CHART_SET_GB2312);
					// 进行内容替换
					content = content.replace(MavenConstant.MVN_INSTALL_BAT_REPLACE_SYMBOL, info.getSourceOrder());
					// 输出到指定的文件，注意 bat 文件应该使用中文编码
					FileUtil.writeString(jarInstallFilePath, content, Constant.CHART_SET_GB2312);
					
					// 调用 windows bat 脚本
					command = "cmd /c start " + mavenInstallPath;
					System.out.println("execute command: " + command);
					rt = Runtime.getRuntime();
					rt.exec(command);
				}
				
				flag = true;
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}	
	
	/**
	 * 
	 * 描述: 
	 * @author  qye.zheng
	 * @return
	 */
	public static final boolean template()
	{
		boolean flag = false;
		try
		{
			
			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
}
