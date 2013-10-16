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
package org.parallelj.launching;

import java.util.HashMap;
import java.util.Map;

import org.parallelj.launching.errors.ProceduresOnError;


/**
 * The Result Object of a Program launching.
 * 
 */
public class LaunchResult {
	
	private Map<String, Object> outputParameters = new HashMap<String, Object>();
	
	private ProceduresOnError proceduresInError;
	
	private String returnCode; 

	private ProgramReturnCodes statusCode = ProgramReturnCodes.NOTSTARTED;

	public LaunchResult() {
	}

	public Map<String, Object> getOutputParameters() {
		return outputParameters;
	}

	public String getReturnCode() {
		return this.returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public void setOutputParameters(Map<String, Object> outputParameters) {
		this.outputParameters = outputParameters;
	}

	public void setProceduresInError(ProceduresOnError allProceduresInError) {
		this.proceduresInError = allProceduresInError;
	}

	public ProceduresOnError getProceduresInError() {
		return proceduresInError;
	}

	public ProgramReturnCodes getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(ProgramReturnCodes statusCode) {
		this.statusCode = statusCode;
	}
	

}
