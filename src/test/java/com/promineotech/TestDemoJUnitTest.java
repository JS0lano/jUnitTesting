package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.function.IntPredicate;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class TestDemoJUnitTest {
	@Mock
	private TestDemo testDemo;
	private TestDemo spyDemo;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		testDemo = new TestDemo();
		spyDemo = spy(testDemo);
	}
	
	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
			Arguments.of(1, 1, 2, false),   
			Arguments.of(2, 3, 5, false),  
			Arguments.of(5, 7, 12, false),
			Arguments.of(1, 5, 6, false),
			Arguments.of(2, 4, 6, false)
		);
	}


	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected) {
		 boolean expectException = false;
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected); 
	} else  {
			assertThatThrownBy(() ->
		    testDemo.addPositive(a, b))
		        .isInstanceOf(IllegalArgumentException.class); 
		}
}
	
		@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
			assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);  // 4 + 5 = 9
			assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);  // 40 + 50 = 90
			assertThat(testDemo.addPositive(10, 20)).isEqualTo(30);  // 10 + 20 = 30
			assertThat(testDemo.addPositive(6, 7)).isEqualTo(13);  // 6 + 7 = 13
									
	}


		@Test
	void assertThatPairsOfPositiveNumbersAreSubtractedCorrectly() {
			assertThat(TestDemo.subtractPositive(5, 4)).isEqualTo(1); // 5-4=1
			assertThat(TestDemo.subtractPositive(20, 10)).isEqualTo(10); // 20-10=10
			assertThat(TestDemo.subtractPositive(30, 10)).isEqualTo(20); // 30-10=20
			assertThat(TestDemo.subtractPositive(40, 20)).isEqualTo(20); // 40-20=20

		}
		
		@Test
	void assertThatNumberSquaredIsCorrect() {
			doReturn(5).when(spyDemo);
			int fiveSquad =spyDemo.randomNumberSquared();
			assertThat(fiveSquad).isEqualTo(25);
		}
		
		}

