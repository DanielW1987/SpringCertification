package com.wagner.javaconfig;

import com.wagner.javaconfig.coach.Coach;
import com.wagner.javaconfig.config.ApplicationConfig;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import static org.junit.Assert.assertNotNull;

@ContextConfiguration(classes = ApplicationConfig.class)
public class JavaConfigAppTest2 extends AbstractJUnit4SpringContextTests {

  @Test
  public void test() {
    Coach tennisCoach = applicationContext.getBean("tennisCoach", Coach.class);
    assertNotNull(tennisCoach);
  }

}
