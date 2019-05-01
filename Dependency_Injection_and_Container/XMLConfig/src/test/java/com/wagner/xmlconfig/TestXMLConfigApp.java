package com.wagner.xmlconfig;

import com.wagner.xmlconfig.coach.Coach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
class TestXMLConfigApp {

  @Autowired
  private ApplicationContext applicationContext;

  @Test
  void test() {
    Coach theCoach = applicationContext.getBean("myCoach", Coach.class);
    assertNotNull(theCoach);
  }
}
