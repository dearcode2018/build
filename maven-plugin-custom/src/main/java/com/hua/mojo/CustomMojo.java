/**
  * @filename CustomMojo.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.mojo;

import java.util.List;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * @type CustomMojo
 * @description 
 * @author qianye.zheng
 */
@Mojo(name = "customMojo", defaultPhase = LifecyclePhase.PACKAGE)
public class CustomMojo extends AbstractMojo {

	// configuration 标签定义的优先级高于@Parameter注解标识
	@Parameter(property = "custom.name")
	private String name;
	
	@Parameter(property = "modules")
	private List<String> modules;
	
	
	
	/**
	 * @description 
	 * @throws MojoExecutionException
	 * @throws MojoFailureException
	 * @author qianye.zheng
	 */
	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		System.out.println(String.format("name is %s, modules is %s", name, modules));
	}

}
