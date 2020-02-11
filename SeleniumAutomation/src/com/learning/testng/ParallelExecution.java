package com.learning.testng;

import org.testng.annotations.Test;

public class ParallelExecution {
  @Test
  public void executeFirst() {
	  System.out.println("Execute first");
  }
  
  @Test
  public void executeSecond() {
	  System.out.println("Execute second");
  }
  
  @Test
  public void executeThird() {
	  System.out.println("Execute third");
  }
  
  @Test
  public void executeFourth() {
	  System.out.println("Execute Fourth");
  }
  
  @Test
  public void executeFifth() {
	  System.out.println("Execute Fifth");
  }
}
