package be.yildiz.module.physics;

import be.yildiz.common.vector.Point3D;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * @author Grégory Van den Borre
 */
@RunWith(Enclosed.class)
public class AbstractStaticObjectTest {

    public static class Constructor {

        @Test
        public void happyFlow() {
            Point3D pos = Point3D.xyz(1,2,3);
            Point3D dir = Point3D.xyz(4,5,6);
            AbstractStaticObject o = givenAStaticObject(pos, dir);
            Assert.assertEquals(pos, o.getPosition());
            Assert.assertEquals(dir, o.getDirection());
        }

        @Test(expected = AssertionError.class)
        public void withNullPos() {
            givenAStaticObject(null, Point3D.xyz(4,5,6));
        }

        @Test(expected = AssertionError.class)
        public void withNullDir() {
            givenAStaticObject(Point3D.xyz(4,5,6), null);
        }
    }

    public static AbstractStaticObject givenAStaticObject(Point3D pos, Point3D dir) {
        return new AbstractStaticObject(pos, dir) {

            @Override
            public void delete() {

            }
        };
    }
}