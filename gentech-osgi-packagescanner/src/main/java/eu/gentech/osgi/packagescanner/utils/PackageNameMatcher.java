package eu.gentech.osgi.packagescanner.utils;

import org.springframework.util.AntPathMatcher;

public class PackageNameMatcher
{

	private static final AntPathMatcher PACKAGE_NAME_MATCHER = new AntPathMatcher();;
	static
	{
		PACKAGE_NAME_MATCHER.setPathSeparator(".");
	}

	public static final boolean match(final String pattern, final String name)
	{
		return PACKAGE_NAME_MATCHER.match(pattern, name);
	}

}
