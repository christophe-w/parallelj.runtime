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
package org.parallelj.internal.reflect;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.parallelj.internal.kernel.KProgram;

public class PipelineFactory {

	static Map<Class<?>, KProgram> pipelines = new ConcurrentHashMap<Class<?>, KProgram>();

	public static KProgram getPipeline(Class<?> type) {
		KProgram program = pipelines.get(type);
		if (program != null) {
			return program;
		}
		// build
		PipelineBuilder builder = new PipelineBuilder(type);
		builder.start();
		// add it to the registry in order to make it available for pipeline
		// management.
		pipelines.put(type, builder.getPipeline());
		builder.build().complete();
		return builder.getPipeline();
	}

}
