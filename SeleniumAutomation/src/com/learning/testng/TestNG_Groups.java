package com.learning.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_Groups {
  
	@Test(groups = "foo")
	public void foo() {
		System.out.println("foo");
	}

	@Test(groups = "bar")
	public void bar() {
		System.out.println("bar");
	}

	@Test(groups = { "alpha", "sanity" })
	public void alpha() {
		System.out.println("alpha, Sanity");
	}

	@Test(groups = { "alpha", "combination" })
	public void combination() {
		System.out.println("alpha, combination");
	}
	
	@Test(groups = { "beta", "integration" })
	public void beta() {
		System.out.println("beta");
	}

	@BeforeClass(groups = "integration")
	public void beforeIntegrationTests() {
		System.out.println("Before Running integration test methods");
	}

	@AfterClass(groups = "integration")
	public void afterIntegrationTests() {
		System.out.println("After Running integration test methods");
	}
  
}
