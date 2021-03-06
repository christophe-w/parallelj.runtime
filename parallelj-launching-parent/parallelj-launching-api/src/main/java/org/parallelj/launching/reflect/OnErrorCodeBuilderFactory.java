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
package org.parallelj.launching.reflect;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.parallelj.internal.reflect.AnnotationBasedBuilderFactory;
import org.parallelj.internal.reflect.ElementBuilder;
import org.parallelj.launching.LaunchingMessageKind;
import org.parallelj.launching.OnError;
import org.parallelj.launching.errors.IProceduresOnError;

public class OnErrorCodeBuilderFactory extends AnnotationBasedBuilderFactory {

	public static class ErrorCodeBuilder extends AnnotationBasedBuilder<OnError, Field> {
		@Override
		public ElementBuilder complete() {
			// Get all the informations about the field annotated with @OnError
			String fieldName = this.getMember().getName();
			Method getReadFieldMethod = null;
			// Get the setter method for the Field
			Class<?> programType = this.getBuilder().getType();
			try {
				for (PropertyDescriptor descriptor : Introspector.getBeanInfo(programType)
						.getPropertyDescriptors()) {
					if (descriptor.getName().equals(fieldName)) {
						getReadFieldMethod = descriptor.getReadMethod();
						 break;
					}
				}
			} catch (IntrospectionException e) {
				LaunchingMessageKind.ELAUNCH0006.format(programType, fieldName, e);
			} catch (IllegalArgumentException e) {
				// Do Nothing
			}
			if (getReadFieldMethod==null) {
				LaunchingMessageKind.ELAUNCH0006.format(programType, fieldName, new Exception());
			}

			// Add the argument to the KProgram
			((IProceduresOnError)this.getProgram()).setGetterMethod(getReadFieldMethod);
			((IProceduresOnError)this.getProgram()).setFieldName(fieldName);
			return super.complete();
		}
	}

	public OnErrorCodeBuilderFactory(
			List<Class<? extends AnnotationBasedBuilder<?, ?>>> types) {
		super(types);
	}

	static final List<Class<? extends AnnotationBasedBuilder<?, ?>>> types = new ArrayList<Class<? extends AnnotationBasedBuilder<?, ?>>>();

	static {
		types.add(ErrorCodeBuilder.class);
	}

	public OnErrorCodeBuilderFactory() {
		super(types);
	}


}
