package eu.gentech.osgi.packagescanner.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PackageNameValidator
{

	private static final Pattern PATTERN = Pattern.compile("^[a-zA-Z_\\$][\\w\\$]*(?:\\.[a-zA-Z_\\$][\\w\\$]*)*$");

	public static final boolean isValid(final String packageName)
	{
		if (packageName == null || packageName.isEmpty())
		{
			return false;
		}
		final Matcher matcher = PATTERN.matcher(packageName);
		return matcher.matches();
	}

}
