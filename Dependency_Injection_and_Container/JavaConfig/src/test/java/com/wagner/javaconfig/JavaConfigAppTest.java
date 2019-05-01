package com.wagner.javaconfig;

import com.wagner.javaconfig.coach.Coach;
import com.wagner.javaconfig.config.ApplicationConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class JavaConfigAppTest {

  @Autowired
  private ApplicationContext applicationContext;

  @Test
  public void test() {
    Coach tennisCoach = applicationContext.getBean("tennisCoach", Coach.class);
    assertNotNull(tennisCoach);
  }
}
