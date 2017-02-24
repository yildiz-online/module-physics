/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 * Copyright (c) 2017 Grégory Van den Borre
 *
 * More infos available: https://www.yildiz-games.be
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without
 * limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 * OR COPYRIGHT  HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  SOFTWARE.
 */

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
public class AbstractMovableObjectTest {

    public static class SetPosition {

        @Test
        public void happyFlow() {
            AbstractMovableObject o = givenAMovable(Point3D.ZERO);
            o.setPosition(Point3D.xyz(1,2,3));
            Assert.assertEquals(Point3D.xyz(1,2,3), o.getPosition());
        }

        @Test(expected = AssertionError.class)
        public void withNullValue() {
            givenAMovable(Point3D.ZERO).setPosition(null);
        }

        @Test
        public void withParent() {
            AbstractMovableObject p = givenAMovable(Point3D.xyz(1,2,3));
            AbstractMovableObject o = givenAMovable(Point3D.ZERO);
            o.attachTo(p);
            o.setPosition(Point3D.xyz(5,6,7));
            Assert.assertEquals(Point3D.xyz(6,8,10), o.getAbsolutePosition());
        }

        @Test
        public void withChild() {
            AbstractMovableObject c = givenAMovable(Point3D.xyz(1,2,3));
            AbstractMovableObject o = givenAMovable(Point3D.ZERO);
            c.attachTo(o);
            o.setPosition(Point3D.xyz(4,5,6));
            Assert.assertEquals(Point3D.xyz(5, 7, 9), c.getAbsolutePosition());
        }

    }

    public static AbstractMovableObject givenAMovable(Point3D p) {
        return new AbstractMovableObject(p) {
            @Override
            protected void setPositionImpl(Point3D pos) {

            }

            @Override
            public void delete() {

            }
        };
    }
}
