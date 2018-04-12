/**
  * @filename ProjectInfo.java
  * @description 
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.bean;

import java.io.File;

import com.hua.util.ProjectUtil;

 /**
 * @type ProjectInfo
 * @description 
 * @author qye.zheng
 */
public final class ProjectInfo {

	/* 默认放在 /doc/jar 目录下 */
	private String location = ProjectUtil.getAbsolutePath("/doc/jar", true) + File.separator;
	
	/**
	 * mvn install:install-file -Dfile=%jarPath% -DgroupId=%groupId% -DartifactId=%artifactId% 
	 * -Dversion=%version% -Dpackaging=%packaging% -Dclassifier=sources
	 */
	/* jar项 名称 */
	private String name;
	
	/*  */
	private String groupId;
	
	/*  */
	private String artifactId;
	
	/*  */
	private String version;
	
	/* 类文件jar名称 name + .jar */
	private String classJarName;
	
	/* 源码文件jar名称 namne + -sources.jar */
	private String sourceJarName;
	
	/* mvn 类文件安装 命令 */
	private String classOrder;
	
	/* mvn 源码文件安装 命令 */
	private String sourceOrder;
	
	/* 备注 */
	private String remark;

	private String packaging = "jar";
	
	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the groupId
	 */
	public final String getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public final void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the artifactId
	 */
	public final String getArtifactId() {
		return artifactId;
	}

	/**
	 * @param artifactId the artifactId to set
	 */
	public final void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	/**
	 * @return the version
	 */
	public final String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public final void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the classJarName
	 */
	public final String getClassJarName() {
		classJarName = name + ".jar";
		
		return classJarName;
	}

	/**
	 * @param classJarName the classJarName to set
	 */
	public final void setClassJarName(String classJarName) {
		this.classJarName = classJarName;
	}

	/**
	 * @return the sourceJarName
	 */
	public final String getSourceJarName() {
		sourceJarName = name + "-sources.jar";
		
		return sourceJarName;
	}

	/**
	 * @param sourceJarName the sourceJarName to set
	 */
	public final void setSourceJarName(String sourceJarName) {
		this.sourceJarName = sourceJarName;
	}

	/**
	 * @return the classOrder
	 */
	public final String getClassOrder() {
		classOrder = "mvn install:install-file -Dfile=" + location + getClassJarName() + " -DgroupId=" 
				+ getGroupId() + " -DartifactId=" + getArtifactId() + " -Dversion=" + getVersion() + " -Dpackaging=" + packaging;

		return classOrder;
	}

	/**
	 * @param classOrder the classOrder to set
	 */
	public final void setClassOrder(String classOrder) {
		this.classOrder = classOrder;
	}

	/**
	 * @return the sourceOrder
	 */
	public final String getSourceOrder() {
		sourceOrder =  "mvn install:install-file -Dfile=" + location + getSourceJarName() + " -DgroupId=" 
					+ groupId + " -DartifactId=" + artifactId + " -Dversion=" + version + " -Dpackaging=" + packaging + " -Dclassifier=sources";
		
		return sourceOrder;
	}

	/**
	 * @param sourceOrder the sourceOrder to set
	 */
	public final void setSourceOrder(String sourceOrder) {
		this.sourceOrder = sourceOrder;
	}

	/**
	 * @return the remark
	 */
	public final String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public final void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the location
	 */
	public final String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public final void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the packaging
	 */
	public final String getPackaging() {
		return packaging;
	}

	/**
	 * @param packaging the packaging to set
	 */
	public final void setPackaging(String packaging) {
		this.packaging = packaging;
	}
	
}
