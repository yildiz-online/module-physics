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

import be.yildiz.common.gameobject.Movable;
import be.yildiz.common.vector.Point3D;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Grégory Van den Borre
 */
class AbstractMovableObjectTest {

    @Nested
    class SetPosition {

        @Test
        void happyFlow() {
            AbstractMovableObject o = givenAMovable();
            o.setPosition(Point3D.valueOf(1,2,3));
            assertEquals(Point3D.valueOf(1,2,3), o.getPosition());
        }

        @Test
        void withNullValue() {
            assertThrows(AssertionError.class, () -> givenAMovable().setPosition(null));
        }

        @Test
        void withChild() {
            AbstractMovableObject child = givenAMovable();
            child.setPosition(Point3D.valueOf(1,2,3));
            AbstractMovableObject parent = givenAMovable();
            child.attachTo(parent);
            parent.setPosition(Point3D.valueOf(4,5,6));
            assertEquals(Point3D.valueOf(5, 7, 9), child.getAbsolutePosition());
        }

    }

    private static AbstractMovableObject givenAMovable() {
        return new AbstractMovableObject() {

            private Point3D pos = Point3D.ZERO;

            @Override
            public Point3D getPosition() {
                return pos;
            }

            @Override
            public void setPosition(float x, float y, float z) {
                pos = Point3D.valueOf(x, y, z);
            }

            @Override
            public void setDirection(float dirX, float dirY, float dirZ) {

            }

            @Override
            public Movable getInternal() {
                return this;
            }

            @Override
            public Point3D getDirection() {
                return Point3D.BASE_DIRECTION;
            }

            @Override
            public void delete() {

            }
        };
    }
}
