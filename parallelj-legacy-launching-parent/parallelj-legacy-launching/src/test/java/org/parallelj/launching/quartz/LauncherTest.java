/*
 *     ParallelJ, framework for parallel computing
 *
 *     Copyright (C) 2010, 2011, 2012 Atos Worldline or third-party contributors as
 *     indicated by the @author tags or express copyright attribution
 *     statements applied by the authors.
 *
 *     This library is free software; you can redistribute it and/or
 *     modify it under the terms of the GNU Lesser General Public
 *     License as published by the Free Software Foundation; either
 *     version 2.1 of the License.
 *
 *     This library is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *     Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public
 *     License along with this library; if not, write to the Free Software
 *     Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 */
package org.parallelj.launching.quartz;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.parallelj.launching.programs.BeginProgram;
import org.quartz.Job;

public class LauncherTest {

	@Test
	public void testNewLaunch() {
		try {
			Launcher launcher = Launcher.getLauncher();
			Launch launch = launcher.newLaunch(BeginProgram.class);
			launch.synchLaunch();
			Job job = launch.getAdapter();
			launcher.complete();

			assertNotNull(job);
			assertEquals(job.getClass(), BeginProgram.class);
			// Test Program has been executed.
			assertEquals(((BeginProgram) job).begin, true);
		} catch (LaunchException e) {
			fail("Error");
		}
	}
}
