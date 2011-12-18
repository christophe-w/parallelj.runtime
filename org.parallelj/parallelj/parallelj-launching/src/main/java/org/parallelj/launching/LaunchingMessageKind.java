/*
 *     ParallelJ, framework for parallel computing
 *
 *     Copyright (C) 2010 Atos Worldline or third-party contributors as
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

package org.parallelj.launching;

import org.parallelj.internal.util.Formatter;
import org.parallelj.internal.util.Formatter.Format;

/**
 * This enumeration contains the types of messages logged by //J launching.
 * 
 * @author Atos Worldline
 * @since 0.4.0
 */
public enum LaunchingMessageKind {
	
	/*
	 * Information messages for TcpIp
	 */
	
	/**
	 * Starting TcpIpServer on [%s:%s]
	 */
	@Format("Starting the TcpIpServer on [%s:%s]")
	ITCPIP0001,
	
	/**
	 * Stopping TcpIpServer
	 */
	@Format("Stoping the TcpIpServer")
	ITCPIP0002,
	
	/*
	 * Error messages for TcpIp
	 */
	
	/**
	 * TcpIpServer can't be started
	 */
	@Format("TcpIpServer can't be started")
	ETCPIP0001,
	
	/*
	 * Information messages for JMX
	 */
	
	/**
	 * Starting the JmxServer on [%s:%s]
	 */
	@Format("Starting the JmxServer on [%s:%s]")
	IJMX0001,
	
	/**
	 * JmxServer started! [%s]
	 */
	@Format("JmxServer started! [%s]")
	IJMX0002,
	
	/**
	 * Stoping the JmxServer
	 */
	@Format("Stoping the JmxServer")
	IJMX0003,
	
	/**
	 * Registering MBean %s...
	 */
	@Format("Registering MBean %s...")
	IJMX0004,
	
	/**
	 * MBean %s registered
	 */
	@Format("MBean %s registered")
	IJMX0005,
	
	/**
	 * MBean %s unregistered
	 */
	@Format("MBean %s unregistered")
	IJMX0006,
	
	/*
	 * Error messages for JMX
	 */
	
	/**
	 * JmxServer can't be started
	 */
	@Format("JmxServer can't be started")
	EJMX0001,
	
	/**
	 * Can't register any MBeans as JmxServer is not started
	 */
	@Format("Can't register any MBeans as JmxServer is not started")
	EJMX0002,
	
	/**
	 * Can't register MBean : is class %s annotated with @Program ?
	 */
	@Format("Can't register MBean : is class %s annotated with @Program ?")
	EJMX0003,

	/**
	 * Error loading class %s for MBean registration
	 */
	@Format("Error loading class %s for MBean registration")
	EJMX0004,
	
	/*
	 * Information messages for Quartz 
	 */
	
	/**
	 * QuartzScheduler started
	 */
	@Format("QuartzScheduler started")
	IQUARTZ0001,
	
	/**
	 * Program %s launched! jobId: %s 
	 */
	@Format("Program %s launched! jobId: %s ")
	IQUARTZ0002,
	
	/**
	 * Program %s with jobId %s is terminated!
	 */
	@Format("Program %s with jobId %s is terminated!")
	IQUARTZ0003,
	
	/*
	 * Error messages for Quartz 
	 */
	
	/**
	 * Error starting Quartz Scheduler
	 */
	@Format("Error starting Quartz Scheduler")
	EQUARTZ0001,
	
	/**
	 * Quartz Scheduler failed to shutdown cleanly
	 */
	@Format("Quartz Scheduler failed to shutdown cleanly")
	EQUARTZ0002,
	
	/**
	 * Error invoking Program %s. Program not launched
	 */
	@Format("Error invoking Program %s. Program not launched")
	EQUARTZ0003,
	
	/*
	 * Error messages for remote access
	 */
	
	/**
	 * Can't find class %
	 */
	@Format("Can't find class %")
	EREMOTE0001,
	
	/**
	 * Can't parse command line when launching program [...]
	 */
	@Format("Can't parse command line when launching program [%s %s %s %s %s %s %s %s %s %s %s %s %s]")
	EREMOTE0002,
	
	/**
	 * Can't instanciate class ?
	 */
	@Format("Can't instanciate class ?")
	EREMOTE0003,
	
	/**
	 * Id %s is out of range! No Program launched!
	 */
	@Format("Id %s is out of range! No Program launched!")
	EREMOTE0004,
	
	/**
	 * Invalid arguments for Program %s. Number of expected arguments is %s! Program not launched!
	 */
	@Format("Invalid arguments for Program %s. Number of expected arguments is %s! Program not launched!")
	EREMOTE0005,
	
	/**
	 * Illegal argument value. Program not launched!
	 */
	@Format("Illegal argument value. Program not launched!")
	EREMOTE0006,
	
	/**
	 * Error with Parser %s - Program not launched!
	 */
	@Format("Error with Parser %s - Program not launched!")
	EREMOTE0007;
	

	/**
	 * Method used to format a message
	 * 
	 * @param args
	 *            the arguments used to format the message
	 * @return the formatted message
	 */
	public String format(Object... args) {
		// delegates to formatter
		return formatter.print(this, args);
	}
	
	public String getFormatedMessage(Object... args) {
		String f[] = formatter.getFormatedMessage(this, args).split("\t");
		if (f.length>=2) {
			return f[1];
		}
		return f[0];
	}
	
	static Formatter<LaunchingMessageKind> formatter = new Formatter<LaunchingMessageKind>(LaunchingMessageKind.class);

}
