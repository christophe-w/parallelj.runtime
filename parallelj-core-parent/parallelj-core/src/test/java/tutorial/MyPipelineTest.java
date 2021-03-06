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
package tutorial;

import java.util.List;

import org.parallelj.AndJoin;
import org.parallelj.AndSplit;
import org.parallelj.Begin;
import org.parallelj.Capacity;
import org.parallelj.ForEach;
import org.parallelj.Pipeline;
import org.parallelj.PipelineData;
import org.parallelj.PipelineParameter;
import org.parallelj.Program;

/**
 * Program org.parallelj.training.test.MyTest Description :
 **/
@Program
public class MyPipelineTest {
	/**
	 * list field Description :
	 **/
	List<String> list;
	long start;
	long end;
	
	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	@Begin
	@Capacity(1)
	public MyTestTwo myPipeline(
			@PipelineParameter("list") List<String> list) {
		// TODO : to be implemented
		System.out.println("start pipeline");
		start = System.currentTimeMillis();
		return new MyTestTwo(list);
	}

	@AndSplit({ "nop" })
	public void myPipeline(MyTestTwo executable) {
		// TODO : to be implemented
		System.out.println("end pipeline");
		end = System.currentTimeMillis();
		System.out.println("Execution time for pipeline was "+(end-start)+" ms.");
	}
	
	@AndJoin
	@AndSplit({ "forEachProcedure" })
	public void nop() {
		System.out.println("start sequential procedures");
		start = System.currentTimeMillis();
	}
	
	@AndJoin
	@Capacity(1)
	public MyInnerProgram forEachProcedure(@ForEach("list") Object val) {
		return new MyInnerProgram(val.toString());
	}

	@AndSplit({ "noptwo" })
	public void forEachProcedure(MyInnerProgram executable) {
		// TODO : to be implemented
	}
	
	@AndJoin
	@AndSplit({ "end" })
	public void noptwo() {
		System.out.println("end sequential procedures");
		end = System.currentTimeMillis();
		System.out.println("Execution time for sequential procedures was "+(end-start)+" ms.");
	}
	

	@Pipeline
	public class MyTestTwo {

		@PipelineData
		List<String> list;

		public MyTestTwo(List<String> list) {
			this.list = list;
		}

		@Begin
		@Capacity(1)
		public ToUpperCase procone(Object next) {
			System.out.println("Display procone 1a: " + next);
			ToUpperCase toUpperCase = new ToUpperCase();
			toUpperCase.setSource(next.toString());
			return toUpperCase;
		}

		@AndSplit({ "proctwo" })
		@Capacity(1)
		public void procone(ToUpperCase toUpperCase, String result) {
			System.out.println("RES one: " + result);
		}

		@AndJoin
		@Capacity(1)
		public ToUpperCase proctwo(Object next) {
			System.out.println("Display proctwo 1b: " + next);
			ToUpperCase toUpperCase = new ToUpperCase();
			toUpperCase.setSource(next.toString());
			return toUpperCase;
		}

		@AndSplit({ "procthree" })
		@Capacity(1)
		public void proctwo(ToUpperCase toUpperCase, String result) {
			// System.out.println("Display proctwo 1b: " + iteratortwo.next());
			System.out.println("RES two: " + result);
		}

		@AndJoin
		@Capacity(1)
		public ToUpperCase procthree(Object next) {
			System.out.println("Display procthree 1c: " + next);

			ToUpperCase toUpperCase = new ToUpperCase();
			toUpperCase.setSource(next.toString());
			return toUpperCase;
		}

		@AndSplit({ "pipelineend" })
		@Capacity(1)
		public void procthree(ToUpperCase toUpperCase, String result) {
			System.out.println("RES three: " + result);
		}

		public List<String> getList() {
			return list;
		}

		public void setList(List<String> list) {
			this.list = list;
		}
	}
}
