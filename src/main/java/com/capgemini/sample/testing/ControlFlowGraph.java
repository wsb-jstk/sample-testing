package com.capgemini.sample.testing;

/**
 * Example of method, which has few nodes and edges in Control Flow Graph
 *
 * @see <a href="https://en.wikipedia.org/wiki/Control-flow_graph">Control Flow Graph</a>
 * @see <a href="https://en.wikipedia.org/wiki/Code_coverage">Code coverage</a>
 */
public class ControlFlowGraph {

	public int sumOfEvenElementSmallerThan(int number) {
		int sum = 0;
		int i = 0;
		while (i < number) {
			if (i % 2 == 0) {
				sum += i++;
			}
		}
		return sum;
	}

}
