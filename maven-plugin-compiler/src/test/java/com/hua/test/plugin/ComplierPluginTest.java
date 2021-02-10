/**
 * 描述: 
 * ComplierPluginTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.plugin;

// 静态导入
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.cli.MavenCli;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;
import com.hua.util.StringUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * ComplierPluginTest
 */
public final class ComplierPluginTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testComplierPlugin() {
		try {
			String maven = System.getenv("MAVEN_HOME");
			if (StringUtil.isEmpty(maven)) { // 使用默认配置
				maven = "C:/software/apache-maven-3.6.3";
				final File path = new File(maven);
				if (!path.exists()) {
					throw new IllegalArgumentException("please check ${MAVEN_HOME} variable or maven running evn.");
				}
			}
			// 指定工程路径，插件运行的时候，直接设置该参数
			System.setProperty(MavenCli.MULTIMODULE_PROJECT_DIRECTORY, System.getProperty("user.dir"));
			String mavenConf = maven + File.separator + "conf" + File.separator + "settings.xml";
			// 多个 goal 放入末尾的数组
			String goal1 = null;
			String goal2 = null;
			
			//goals = "package";
			//goal1 = "clean";
			goal2 = "install";
			goal2 = "compile";
			// 名称取自 artifact-id
			goal2 = "compiler:compile";
			//goal2 = "install-file";
			//goal2 = "package";
			List<String> params = new ArrayList<>(10);
			params.add("-B");
			params.add("-gs");
			params.add(mavenConf);
			params.add("-s");
			params.add(mavenConf);
			if (null != goal1) {
				params.add(goal1);
			}
			if (null != goal2) {
				params.add(goal2);
			}
			
			/* 注意，若通过 MavenCli 去调用，则无需主动依赖各个插件
			 * 依赖各个插件 在这种情况下 只是为了和maven进程进行远程(localhost)
			 * 代码调试
			 * 
			 */
			MavenCli.main(params.toArray(new String[params.size()]));
			
			
		} catch (Exception e) {
			log.error("testComplierPlugin =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testTemp() {
		try {
			
			
		} catch (Exception e) {
			log.error("testTemp=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCommon() {
		try {
			
			
		} catch (Exception e) {
			log.error("testCommon =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSimple() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSimple =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@Ignore("解决ide静态导入消除问题 ")
	private void noUse() {
		String expected = null;
		String actual = null;
		Object[] expecteds = null;
		Object[] actuals = null;
		String message = null;
		
		assertEquals(expected, actual);
		assertEquals(message, expected, actual);
		assertNotEquals(expected, actual);
		assertNotEquals(message, expected, actual);
		
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(message, expecteds, actuals);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(message, true);
		assertTrue(message, true);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(message, expecteds, actuals);
		assertNotSame(message, expecteds, actuals);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(message, actuals);
		assertNotNull(message, actuals);
		
		assertThat(null, null);
		assertThat(null, null, null);
		
		fail();
		fail("Not yet implemented");
		
	}

}
