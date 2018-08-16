package com.capgemini;

import com.capgemini.service.impl.ServiceTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;



@RunWith(Suite.class)
@SuiteClasses({ServiceTestSuite.class})
public class AllTests {

}
