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
package eu.gentech.osgi.packagescanner.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author genious87
 */
public class PackageNameValidatorTest
{

	@Test
	public void testNull()
	{
		Assert.assertFalse(PackageNameValidator.isValid(null));
	}

	@Test
	public void testEmpty()
	{
		Assert.assertFalse(PackageNameValidator.isValid(""));
	}

	@Test
	public void testValidNames()
	{
		Assert.assertTrue(PackageNameValidator.isValid("eu.gentech"));
		Assert.assertTrue(PackageNameValidator.isValid("eu.gentech1"));
		Assert.assertTrue(PackageNameValidator.isValid("org.apache"));
		Assert.assertTrue(PackageNameValidator.isValid("org.springframework"));
	}

	@Test
	public void testValidButNotRecommandedNames()
	{
		Assert.assertTrue(PackageNameValidator.isValid("Eu.gentech"));
		Assert.assertTrue(PackageNameValidator.isValid("eu.Gentech"));
		Assert.assertTrue(PackageNameValidator.isValid("eu.genTech"));
	}

	@Test
	public void testInvalidNames()
	{
		Assert.assertFalse(PackageNameValidator.isValid(" eu.genteh"));
		Assert.assertFalse(PackageNameValidator.isValid("org. apache"));
		Assert.assertFalse(PackageNameValidator.isValid("org.apache."));
		Assert.assertFalse(PackageNameValidator.isValid("org..apache"));
		Assert.assertFalse(PackageNameValidator.isValid("1org.springframework"));
	}

	@Test
	public void testClasspath()
	{
		final Package[] packages = Package.getPackages();
		for (final Package pkg : packages)
		{
			Assert.assertTrue(PackageNameValidator.isValid(pkg.getName()));
		}
	}

}
