package com.klef.Payment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaymentServiceTest 
{
	private PaymentService paymentService;
	
	
	@BeforeEach //before every test case
	void setUp() 
	{
	System.out.println("***Before Each Testcase***");
	paymentService = new PaymentService();
	}
	
	//1.Valid Payment
	@Test
	void testcase1() {
		PaymentRequest request = new PaymentRequest(101, "John", "1234567890123456", 5000, "CARD", "INR", "Online Course Payment");
		
		String result = paymentService.processPayment(request);
		
		assertEquals("Payment Successful", result);
	}

	
	//2.Negative Amount
	@Test
	void testcase2() {
		PaymentRequest request = new PaymentRequest(101, "John", "1234567890123456", -250, "CARD", "INR", "Online Course Payment");
		
		String result = paymentService.processPayment(request);
		
		assertEquals("Payment Failed", result);
	}
	
	
	//3.Zero payment
	@Test
	void testcase3() {
		PaymentRequest request = new PaymentRequest(101, "John", "1234567890123456", 0, "CARD", "INR", "Online Course Payment");
		
		String result = paymentService.processPayment(request);
		
		assertEquals("Payment Failed", result);
	}
	
	
	//4.Missing customer name
	@Test
	void testcase4() {
		PaymentRequest request = new PaymentRequest(101, "", "1234567890123456", 5000, "CARD", "INR", "Online Course Payment");
		
		String result = paymentService.processPayment(request);
		
		assertEquals("Payment Failed", result);
	}
	
	
	//5.Missing card number
	@Test
	void testcase5() {
		PaymentRequest request = new PaymentRequest(101, "John","", 5000, "CARD", "INR", "Online Course Payment");
		
		String result = paymentService.processPayment(request);
		
		assertEquals("Payment Failed", result);
	}
	
	
	//6.Null payment request
	@Test
	void testcase6() {
		String result = paymentService.processPayment(null);
		
		assertEquals("Payment Failed", result);
	}
	
	
	//7.Blank Customer Name
	@Test
	void testcase7() {
		PaymentRequest request = new PaymentRequest(101, "   ", "1234567890123456", 5000, "CARD", "INR", "Online Course Payment");
		
		String result = paymentService.processPayment(request);
		
		assertEquals("Payment Failed", result);
	}
	
	
	//8.Null customer name
	@Test
	void testcase8() {
		PaymentRequest request = new PaymentRequest(101, null, "1234567890123456", 5000, "CARD", "INR", "Online Course Payment");
		
		String result = paymentService.processPayment(request);
		
		assertEquals("Payment Failed", result);
	}
	
	
	//9.null card number
	@Test
	void testcase9() {
		PaymentRequest request = new PaymentRequest(101, "John", null, 5000, "CARD", "INR", "Online Course Payment");
		
		String result = paymentService.processPayment(request);
		
		assertEquals("Payment Failed", result);
	}
	
	
	//10.Missing payment method
	@Test
	void testcase10() {
		PaymentRequest request = new PaymentRequest(101, "John", "1234567890123456", 5000, "", "INR", "Online Course Payment");
		
		String result = paymentService.processPayment(request);
		
		assertEquals("Payment Failed", result);
	}
	
	
	//11.Missing Currency
	@Test
	void testcase11() {
		PaymentRequest request = new PaymentRequest(101, "John", "1234567890123456", 5000, "CARD", "", "Online Course Payment");
		
		String result = paymentService.processPayment(request);
		
	}
	
	//12.Direct validation test
	@Test
	void testcase12() {
		PaymentRequest request = new PaymentRequest(101, "John", "1234567890123456", 5000, "CARD", "INR", "Online Course Payment");
		
boolean result = paymentService.validatePaymentDetails(request);		
		assertTrue(result);
	}
	

	
}