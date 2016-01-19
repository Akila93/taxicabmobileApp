/*
 * Copyright (C) 2011 The UBBdroid Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.ubbdroid;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import android.os.Build;

/**
 * A class which detemines which patches should be included on this platform.
 * 
 * @author Janos Levai
 * 
 */

// //////////////////////////////////////////////////////////////////////////////
// Implemented changes compared to 2.1, 2.2, 2.3:
// * Change I44e3c0af: Make disabled TextViews uneditable (issue 2771)
// //////////////////////////////////////////////////////////////////////////////

public abstract class PatchIncluder {
	private static final String[] versionCategories;
	private static final Map<String, Set<String>> blacklist;
	private static final Set<String> affected;
	private static final Set<String> versions;

	private static final String V_2_1;
	private static final String V_2_2;
	private static final String V_2_3;

	static {
		/*
		 * Define regular expressions for versions. For example covers all
		 * versions 2.2 and 3 of Android:
		 * 
		 * allVersions = new String[] { "2\\.2.*", "3.*" };
		 */
		V_2_1 = "2\\.1.*";
		V_2_2 = "2\\.2.*";
		V_2_3 = "2\\.3.*";
		versionCategories = new String[] { V_2_1, V_2_2, V_2_3 };

		blacklist = new HashMap<String, Set<String>>();
		affected = new HashSet<String>();
		versions = new HashSet<String>();

		determineCurrentVersion();
		configurePatchVersions();
	}

	/**
	 * This is where affected platform version regular expressions are
	 * associated with patches. They are added to the blacklist.
	 */
	private static void configurePatchVersions() {
		/*
		 * To associate a patch key with call the "associate" method. The
		 * example below marks the patch "ABC" affects version 2.1 of Android.
		 * 
		 * associate("ABC", new String[] { V_2_1 });
		 */
		associate("I44e3c0af", new String[] { V_2_1, V_2_2, V_2_3 });
	}

	/**
	 * Associates a patch key with an array of platform versions.
	 * 
	 * @param key
	 *            the key to be associated
	 * @param versions
	 *            the affected platforms which should be added to the blacklist
	 */
	private static void associate(String key, String[] versions) {
		if (!blacklist.containsKey(key)) {
			Set<String> values = new HashSet<String>(versions.length);
			for (String version : versions) {
				values.add(version);
			}
			blacklist.put(key, values);
		}
	}

	/**
	 * Determines which categories does this build of the OS fall into.
	 */
	private static void determineCurrentVersion() {
		String current = Build.VERSION.RELEASE;
		for (String regexp : versionCategories) {
			if (Pattern.matches(regexp, current)) {
				versions.add(regexp);
			}
		}
	}

	/**
	 * Checks if the current version is in the key's blacklist. After that, it
	 * is removed from the blacklist. If the current version is affected, it
	 * will be added to the "affected" set.
	 * 
	 * @param key
	 *            the key to be checked
	 */
	private static void determineAffectedness(String key) {
		Set<String> keyVersions = blacklist.get(key);
		if (keyVersions != null) {
			blacklist.remove(key);
			for (String version : versions) {
				if (keyVersions.contains(version)) {
					affected.add(key);
					break;
				}
			}
		}
	}

	/**
	 * Checks if a patch should be enabled. It performs a lazy check: first it
	 * checks in the blacklist and performs a check on a set of platform
	 * versions. Previously checked keys are removed from the blacklist and
	 * affected ones are marked by adding them to a simple String set, so that
	 * next time the affectedness will be determined in constant time.
	 * 
	 * @param key
	 *            the key of the patch
	 * @return true if the patch should be included in the current version;
	 *         false otherwise
	 */
	public static boolean includePath(String key) {
		determineAffectedness(key);
		return affected.contains(key);
	}
}
