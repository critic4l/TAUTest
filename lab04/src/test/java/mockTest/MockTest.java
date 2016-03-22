package mockTest;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import org.easymock.EasyMockRule;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.Test;

public class MockTest {
	
	@Rule
	public EasyMockRule mocks = new EasyMockRule(this);
	
	@Mock
	private IMyList mock;
	
	@TestSubject
	private FruitManager fm = new FruitManager(mock);
	
	@Test
	public void addCheck(){
		Fruit apple = new Fruit("Apple", "Spain");
		//Fruit apple1 = new Fruit("Apple", "Spain");
		mock.add(apple);
		expectLastCall();
		expect(mock.size()).andReturn(1);
		expect(mock.getAll()).andReturn(mock);
		replay(mock);
		//fm.add(apple1);
		assertEquals(1, fm.getAll().size());
		
	}
	
}
