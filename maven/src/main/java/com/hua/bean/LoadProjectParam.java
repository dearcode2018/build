/**
 * 描述: 
 * LoadProjectParam.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.hua.util.ReadProperties;

/**
 * 描述: 加载 maven 配置中的项目参数
 * @author  qye.zheng
 * LoadProjectParam
 */
public final class LoadProjectParam
{
	
	private static final String CONFIG_PATH = "/conf/properties/maven-install.properties";
	
	private static final ReadProperties readProps = new ReadProperties(CONFIG_PATH);
	
	private static final List<ProjectInfo> infos = new ArrayList<ProjectInfo>();
	
	static
	{
		final Properties props = readProps.getProps();
		final Set<Map.Entry<Object, Object>> entries = props.entrySet();
		String key = null;
		String value = null;
		String[] arr = null;
		ProjectInfo info = null;
		int i = -1;
		for (Map.Entry<Object, Object> entry : entries)
		{
			key = (String) entry.getKey();
			value = (String) entry.getValue();
			arr = value.split("\\|");
			
			info = new ProjectInfo();
			info.setName(key.trim());
			i = 0;
			info.setGroupId(arr[i++].trim());
			info.setArtifactId(arr[i++].trim());
			info.setVersion(arr[i++].trim());
			// 放入集合
			infos.add(info);
		}
	}
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 */
	private LoadProjectParam()
	{
	}

	/**
	 * @return the infos
	 */
	public static final List<ProjectInfo> getInfos() {
		return infos;
	}

}
