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
package org.parallelj.launching.web;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.parallelj.internal.conf.ConfigurationService;
import org.parallelj.internal.conf.ParalleljConfigurationManager;
import org.parallelj.internal.conf.pojos.ParalleljConfiguration;
import org.parallelj.launching.LaunchException;
import org.parallelj.launching.Launcher;
import org.parallelj.launching.LaunchingMessageKind;
import org.parallelj.launching.transport.jmx.JmxServer;
import org.parallelj.launching.transport.ssh.SshServer;
import org.parallelj.launching.transport.tcp.TcpIpHandlerAdapter;
import org.parallelj.launching.transport.tcp.TcpIpServer;

/**
 * <p>
 * A ServletContextListner that can be used to start: - a Parallelj scheduler -
 * a TcpIpServer - a JmxServer - a SshServer
 * </p>
 */
public class LegacyServersInitializerListener implements ServletContextListener {

	/**
	 * The @Deprecated TcpIpServer for remote launching via telnet.
	 */
	private @Deprecated TcpIpServer tcpIpServer;

	/**
	 * The @Deprecated JmxServer for remote launching via JMX.
	 */
	private @Deprecated JmxServer jmxServer;

	/**
	 * The SscServer for remote launching via SSH
	 */
	private @Deprecated SshServer sshServer;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.ServletContextListener#contextInitialized(javax.servlet
	 * .ServletContextEvent)
	 */
	public final void contextInitialized(final ServletContextEvent sce) {
		try {
			// Get the configuration
			final ParalleljConfiguration configuration = (ParalleljConfiguration) ConfigurationService
					.getConfigurationService().getConfigurationManager()
					.get(ParalleljConfigurationManager.class).getConfiguration();

			// Initialize the launcher
			Launcher.getLauncher();

			// Initialize a TcpIpServer
			if (configuration.getServers() != null
					&& configuration.getServers().getTelnet() != null) {
				this.tcpIpServer = new TcpIpServer(configuration.getServers()
						.getTelnet().getHost(), configuration.getServers()
						.getTelnet().getPort(), new TcpIpHandlerAdapter());
				// Try to start the TciIpServer
				if (this.tcpIpServer != null) {
					try {
						this.tcpIpServer.start();
					} catch (IOException e) {
						LaunchingMessageKind.ETCPIP0001.format(e);
					}
				}
			}

			// Initialize a JmxServer
			// and register all defined Program as MBeans
			if (configuration.getServers() != null
					&& configuration.getServers().getJmx() != null) {
				this.jmxServer = new JmxServer(configuration.getServers()
						.getJmx().getHost(), configuration.getServers()
						.getJmx().getPort());
				// Try to start the JmxServer
				if (this.jmxServer != null) {
					try {
						this.jmxServer.start();
					} catch (IOException e) {
						LaunchingMessageKind.EJMX0001.format(e);
					}
				}
			}

			// Initialize a SshServer
			if (configuration.getServers() != null
					&& configuration.getServers().getSsh() != null) {

				this.sshServer = new SshServer(configuration.getServers()
						.getSsh().getPort());

				// Try to start SshServer
				if (this.sshServer != null) {
					try {
						sshServer.start();
					} catch (IOException e) {
						LaunchingMessageKind.ESSH0001.format(e);
					}
				}
			}
			
		} catch (LaunchException e) {
			LaunchingMessageKind.EWLAUNCH0001.format(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.
	 * ServletContextEvent)
	 */
	public final void contextDestroyed(final ServletContextEvent sce) {
		// Stop the TciIpServer
		if (this.tcpIpServer != null) {
			this.tcpIpServer.stop();
		}

		// Stop the JmxServer
		if (this.jmxServer != null) {
			this.jmxServer.stop();
		}

		// Stop the SshServer
		if (this.sshServer != null) {
			try {
				this.sshServer.stop();
			} catch (InterruptedException e) {
				LaunchingMessageKind.ESSH0002.format(e);
			}
		}
	}

	public TcpIpServer getTcpIpServer() {
		return tcpIpServer;
	}

	public JmxServer getJmxServer() {
		return jmxServer;
	}
}
