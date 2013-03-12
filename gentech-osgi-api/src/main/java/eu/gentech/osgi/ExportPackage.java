/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.gentech.osgi;

import java.net.URL;

import org.osgi.framework.Version;

/**
 * @author genious87
 */
public class ExportPackage implements Comparable<ExportPackage>
{

	private final String name;
	private final Version version;
	private final URL location;

	private String toStringCache;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            name of the package
	 * @param version
	 *            version of the package or <code>null</code>
	 * @param location
	 *            location of the package or <code>null</code>
	 */
	public ExportPackage(final String name, final Version version, final URL location)
	{
		super();
		if (name == null)
		{
			throw new IllegalArgumentException("name must not be null");
		}
		this.name = name;
		this.version = version == null ? Version.emptyVersion : version;
		this.location = location;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @return the version
	 */
	public Version getVersion()
	{
		return version;
	}

	/**
	 * @return the location
	 */
	public URL getLocation()
	{
		return location;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(final ExportPackage other)
	{
		int result = name.compareTo(other.getName());
		if (result == 0)
		{
			result = version.compareTo(other.getVersion());
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (name == null ? 0 : name.hashCode());
		result = prime * result + (version == null ? 0 : version.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (!(obj instanceof ExportPackage))
		{
			return false;
		}
		final ExportPackage other = (ExportPackage) obj;
		if (name == null)
		{
			if (other.name != null)
			{
				return false;
			}
		} else if (!name.equals(other.name))
		{
			return false;
		}
		if (version == null)
		{
			if (other.version != null)
			{
				return false;
			}
		} else if (!version.equals(other.version))
		{
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		if (toStringCache == null)
		{
			final StringBuilder buffer = new StringBuilder();
			buffer.append(name);
			if (!version.equals(Version.emptyVersion))
			{
				buffer.append(";version=").append(version);
			}
			toStringCache = buffer.toString();
		}
		return toStringCache;
	}

}
