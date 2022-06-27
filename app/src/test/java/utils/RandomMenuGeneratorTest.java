package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomMenuGeneratorTest {
  @Test
  void creation() {
    RandomMenuGenerator randomMenuGenerator = new RandomMenuGenerator();

    assertNotNull(randomMenuGenerator.rice());
    assertNotNull(randomMenuGenerator.soup());
    assertNotNull(randomMenuGenerator.vegetable());
    assertNotNull(randomMenuGenerator.meat());
    assertNotNull(randomMenuGenerator.dessert());
  }

  @Test
  void domain0Menu() {
    RandomMenuGenerator randomMenuGenerator = new RandomMenuGenerator();

    assertEquals("현미밥", randomMenuGenerator.rice());
  }
}
