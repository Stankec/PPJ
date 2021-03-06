package hr.unizg.fer.zemris.ppj.maheri.tests.sa;

import static org.junit.Assert.assertEquals;
import hr.unizg.fer.zemris.ppj.maheri.parser.InputProcessor;
import hr.unizg.fer.zemris.ppj.maheri.tests.TestUtils;
import hr.unizg.fer.zemris.ppj.maheri.tests.TestUtils.TestData;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Tests the 2nd input processor, as well as serializing a Grammar to string
 * 
 * @author Petar Šegina <psegina@ymail.com>
 * 
 */
@RunWith(Parameterized.class)
public class SAInputProcessorTest {

	List<String> input;
	List<String> expectedOutput;

	public SAInputProcessorTest(List<String> input, List<String> expectedOutput) {
		this.input = input;
		this.expectedOutput = expectedOutput;
	}

	@Parameters
	public static Collection<Object[]> params() {
		List<Object[]> result = new LinkedList<Object[]>();
		for (TestData t : TestUtils.loadData("SintaksniAnalizatorInputTest")) {
			result.add(new Object[] { t.getInput(), t.getExpectedOutput() });
		}
		return result;
	}

	@Test
	public void test() {
		String[] output = InputProcessor.parseInput(input.toArray(new String[0])).toString().split("\n");

		HashSet<String> set1 = new HashSet<String>(Arrays.asList(output));
		HashSet<String> set2 = new HashSet<String>(expectedOutput);

		assertEquals(set1, set2);

	}

}
