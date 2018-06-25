package cn.cout.pure.sframe.filter;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @author tj
 * @date 2018-06-12 23
 */

@WebFilter(filterName="druidWebStatFilter",
		urlPatterns="/*",
		initParams={
				@WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*"),// 忽略资源
		})
public class DruidStatFilter extends WebStatFilter {

}