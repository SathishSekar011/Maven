package org.suite;

import org.adactin.AdactinHotel;
import org.adactin.Sample;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({AdactinHotel.class, Sample.class})
public class SuiteExecution {

}
