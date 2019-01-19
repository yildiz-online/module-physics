/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2019 Grégory Van den Borre
 *
 *  More infos available: https://engine.yildiz-games.be
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 *  documentation files (the "Software"), to deal in the Software without restriction, including without
 *  limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 *  of the Software, and to permit persons to whom the Software is furnished to do so,
 *  subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all copies or substantial
 *  portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 *  WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 *  OR COPYRIGHT  HOLDERS BE LIABLE FOR ANY CLAIM,
 *  DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  SOFTWARE.
 *
 */

package be.yildizgames.module.physics;

import be.yildizgames.common.gameobject.Movable;
import be.yildizgames.common.geometry.Point3D;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Grégory Van den Borre
 */
class AbstractStaticObjectTest {

    @Nested
    class Constructor {

        @Test
        void happyFlow() {
            Point3D pos = Point3D.valueOf(1,2,3);
            Point3D dir = Point3D.valueOf(4,5,6);
            AbstractStaticObject o = givenAStaticObject(pos, dir);
            assertEquals(pos, o.getPosition());
            assertEquals(dir, o.getDirection());
        }

        @Test
        void withNullPos() {
            assertThrows(AssertionError.class, () -> givenAStaticObject(null, Point3D.valueOf(4,5,6)));
        }

        @Test
        void withNullDir() {
            assertThrows(AssertionError.class, () -> givenAStaticObject(Point3D.valueOf(4,5,6), null));
        }
    }

    private static AbstractStaticObject givenAStaticObject(Point3D pos, Point3D dir) {
        return new AbstractStaticObject(pos, dir) {

            @Override
            public void delete() {
                //Does nothing
            }

            @Override
            public void detachFromParent() {

            }

            @Override
            public void setPosition(float posX, float posY, float posZ) {

            }

            @Override
            public void setDirection(float dirX, float dirY, float dirZ) {

            }

            @Override
            public void addOptionalChild(Movable child) {

            }

            @Override
            public void removeChild(Movable child) {

            }

            @Override
            public Movable getInternal() {
                return this;
            }

        };
    }
}