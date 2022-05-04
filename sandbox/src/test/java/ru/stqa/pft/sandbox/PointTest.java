package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {
  @Test
  public void testDistance() {
    Point p1 = new Point(2, 3);
    Point p2 = new Point(4, 6);
    Assert.assertEquals(p1.distance(p2), 3.605551275463989);
  }

  @Test
  public void testDistanceWith0() {
    Point p1 = new Point(3, 0);
    Point p2 = new Point(0, 0);
    Assert.assertEquals(p1.distance(p2), 3);
  }
}
