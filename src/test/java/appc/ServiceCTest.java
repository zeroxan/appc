package appc;

import static org.junit.Assert.*;

import org.junit.Test;

public class ServiceCTest {

	@Test
	public void testJumble() {
		IServiceC serviceC = new ServiceC();
		int result = serviceC.jumble(5, 5, 3, 2);
		assertEquals(5, result);
	}

}
