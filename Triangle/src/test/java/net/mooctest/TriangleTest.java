package net.mooctest;

import java.lang.reflect.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TriangleTest {
  private static Field getField(Class clazz, String name) throws Throwable {
    Field field = clazz.getDeclaredField(name);
    field.setAccessible(true);
    return field;
  }

  private long lborderA(Triangle t) throws Throwable {
    return getField(Triangle.class, "lborderA").getLong(t);
  }
  private void lborderA(Triangle t, long lborderA) throws Throwable {
    getField(Triangle.class, "lborderA").setLong(t, lborderA);
  }
  private long lborderB(Triangle t) throws Throwable {
    return getField(Triangle.class, "lborderB").getLong(t);
  }
  private void lborderB(Triangle t, long lborderB) throws Throwable {
    getField(Triangle.class, "lborderB").setLong(t, lborderB);
  }
  private long lborderC(Triangle t) throws Throwable {
    return getField(Triangle.class, "lborderC").getLong(t);
  }
  private void lborderC(Triangle t, long lborderC) throws Throwable {
    getField(Triangle.class, "lborderC").setLong(t, lborderC);
  }

  private Triangle t;

  @Before
  public void setup() throws Throwable {
    t = new Triangle(1, 2, 3);
  }

  @Test
  public void testTriangle() throws Throwable {
    t = new Triangle(1, 2, 3);
    assertEquals(1, lborderA(t));
    assertEquals(2, lborderB(t));
    assertEquals(3, lborderC(t));
  }

  @Test
  public void testGetBorders() throws Throwable {
    assertArrayEquals(new long[]{
      lborderA(t),
      lborderB(t),
      lborderC(t),
    }, t.getBorders());
  }

  @Test
  public void testIsTriangle1() throws Throwable {
    lborderA(t, -1);
    assertFalse(t.isTriangle(t));
  }
  @Test
  public void testIsTriangle2() throws Throwable {
    lborderA(t, 1);
    lborderB(t, 2);
    lborderC(t, 3);
    assertFalse(t.isTriangle(t));
  }
  @Test
  public void testIsTriangle3() throws Throwable {
    lborderA(t, 1);
    lborderB(t, 1);
    lborderC(t, 1);
    assertTrue(t.isTriangle(t));
  }

  @Test
  public void testGetType1() throws Throwable {
    lborderA(t, -1);
    assertEquals("Illegal", t.getType(t));
  }
  @Test
  public void testGetType2() throws Throwable {
    lborderA(t, 1);
    lborderB(t, 1);
    lborderC(t, 1);
    assertEquals("Regular", t.getType(t));
  }
  @Test
  public void testGetType3() throws Throwable {
    lborderA(t, 2);
    lborderB(t, 3);
    lborderC(t, 4);
    assertEquals("Scalene", t.getType(t));
  }
  @Test
  public void testGetType4() throws Throwable {
    lborderA(t, 2);
    lborderB(t, 2);
    lborderC(t, 3);
    assertEquals("Isosceles", t.getType(t));
  }

  @Test
  public void testDiffOfBorders1() throws Throwable {
    assertEquals(1, t.diffOfBorders(2, 1));
  }
  @Test
  public void testDiffOfBorders2() throws Throwable {
    assertEquals(1, t.diffOfBorders(1, 2));
  }
}
