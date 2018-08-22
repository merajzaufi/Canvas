import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.canvas.controller.ChallengeTwo;
import com.canvas.model.Device;


public class TestChallenge {

	private ChallengeTwo objInstance;
	private List<String> csvData;
	@Before
	public void setUp() throws Exception{
		objInstance = new ChallengeTwo();
		csvData = new ArrayList<String>();
	}
	
	@Test
	public void test() throws ParseException {
		assertNotNull(objInstance);
		csvData.add("Heading Text will be skipped");
		csvData.add("123,A,B,C,D,08/08/18");
		List<Device> testcsvData = objInstance.convertCSVToObject(csvData);
		assertNotNull(testcsvData);
		assertEquals(6,testcsvData.size());
	}

}
