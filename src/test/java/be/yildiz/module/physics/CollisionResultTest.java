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

import be.yildiz.common.id.EntityId;
import be.yildiz.common.id.EntityIdentifiable;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Grégory Van den Borre
 */

class CollisionResultTest {

    private static final EntityId id1 = EntityId.valueOf(4L);
    private static final EntityId id2 = EntityId.valueOf(3L);

    private static final EntityIdentifiable enid1 = () -> id1;
    private static final EntityIdentifiable enid2 = () -> id2;

    private static CollisionResult givenACollisionResult() {
        return new CollisionResult(id1, id2);
    }

    @Nested
    class Constructor {

        @Test
        void happyFlow() {
            CollisionResult r = givenACollisionResult();
            assertEquals(id1, r.object1);
            assertEquals(id2, r.object2);
        }

        @Test
        void withObject1Null() {
            assertThrows(AssertionError.class, () -> new CollisionResult(null, id2));
        }

        @Test
        void withObject2Null() {
            assertThrows(AssertionError.class, () -> new CollisionResult(id1, null));
        }
    }

    @Nested
    class Contains {

        @Test
        void happyFlow() {
            CollisionResult r = givenACollisionResult();
            assertTrue(r.contains(id1));
            assertTrue(r.contains(id2));
            assertFalse(r.contains(EntityId.WORLD));
        }

        @Test
        void happyFlowTwoParams() {
            CollisionResult r = givenACollisionResult();
            assertTrue(r.contains(id1, id2));
            assertFalse(r.contains(EntityId.WORLD, id2));
        }

        @Test
        void happyFlowIdentifiable() {
            CollisionResult r = givenACollisionResult();
            assertTrue(r.contains(enid1));
            assertTrue(r.contains(enid2));
            assertFalse(r.contains(() -> EntityId.WORLD));
        }

        @Test
        void happyFlowIdentifiableTwoParams() {
            CollisionResult r = givenACollisionResult();
            assertTrue(r.contains(enid1, enid2));
            assertFalse(r.contains(() -> EntityId.WORLD, enid2));
        }

        @Test
        void withNull() {
            CollisionResult r = givenACollisionResult();
            assertThrows(AssertionError.class, () -> r.contains((EntityId)null));
        }

        @Test
        void withNullParamOne() {
            CollisionResult r = givenACollisionResult();
            assertThrows(AssertionError.class, () -> r.contains(null, id2));
        }

        @Test
        void withNullParamTwo() {
            CollisionResult r = givenACollisionResult();
            assertThrows(AssertionError.class, () -> r.contains(id1, null));
        }

        @Test
        void withNullIdentifiable() {
            CollisionResult r = givenACollisionResult();
            assertThrows(AssertionError.class, () -> r.contains((EntityIdentifiable) null));
        }

        @Test
        void withNullIdentifiableParamOne() {
            CollisionResult r = givenACollisionResult();
            assertThrows(AssertionError.class, () -> r.contains(null, enid2));
        }

        @Test
        void withNullIdentifiableParamTwo() {
            CollisionResult r = givenACollisionResult();
            assertThrows(AssertionError.class, () -> r.contains(enid1, null));
        }

    }

    @Nested
    class ContainsAndNot {

        @Test
        void happyFlow() {
            CollisionResult r = givenACollisionResult();
            assertTrue(r.contains(id1, id2));
            assertFalse(r.contains(EntityId.WORLD));
            assertTrue(r.containsAndNot(id1, EntityId.WORLD));
            assertTrue(r.containsAndNot(EntityId.WORLD, id2));
            assertTrue(r.containsAndNot(id2, EntityId.WORLD));
            assertTrue(r.containsAndNot(EntityId.WORLD, id1));
        }

        @Test
        void withParamOneNull() {
            CollisionResult r = givenACollisionResult();
            assertThrows(AssertionError.class, () -> r.containsAndNot(null, enid2));
        }

        @Test
        void withParamTwoNull() {
            CollisionResult r = givenACollisionResult();
            assertThrows(AssertionError.class, () -> r.containsAndNot(enid1, null));
        }

        @Test
        void happyFlowIdentifiable() {
            CollisionResult r = givenACollisionResult();
            assertTrue(r.contains(enid1, enid2));
            assertFalse(r.contains(() -> EntityId.WORLD));
            assertTrue(r.containsAndNot(enid1, () -> EntityId.WORLD));
            assertTrue(r.containsAndNot(() -> EntityId.WORLD, enid2));
            assertTrue(r.containsAndNot(enid2, () -> EntityId.WORLD));
            assertTrue(r.containsAndNot(() -> EntityId.WORLD, enid1));
        }

        @Test
        void containsBoth() {
            CollisionResult r = givenACollisionResult();
            assertFalse(r.containsAndNot(id1, id2));
        }

        @Test
        void containsNone() {
            CollisionResult r = givenACollisionResult();
            assertFalse(r.containsAndNot(EntityId.WORLD, EntityId.valueOf(1000L)));
        }
    }

    @Nested
    class HashCode {

        @Test
        void happyFlow() {
            CollisionResult r = givenACollisionResult();
            assertEquals(id1.hashCode() + id2.hashCode(), r.hashCode());
        }
    }

    @Nested
    class Equals {

        @Test
        void sameInstance() {
            CollisionResult r = givenACollisionResult();
            assertTrue(r.equals(r));
        }

        @Test
        void sameObject() {
            CollisionResult r = givenACollisionResult();
            CollisionResult r2 = givenACollisionResult();
            assertTrue(r.equals(r2));
        }

        @Test
        void differentOrder() {
            CollisionResult r = givenACollisionResult();
            CollisionResult r2 = new CollisionResult(id2, id1);
            assertTrue(r.equals(r2));
        }

        @Test
        void withNull() {
            CollisionResult r = givenACollisionResult();
            assertFalse(r.equals(null));
        }

        @Test
        void differentObject() {
            CollisionResult r = givenACollisionResult();
            CollisionResult r2 = new CollisionResult(id1, EntityId.WORLD);
            assertFalse(r.equals(r2));
        }

        @Test
        void differentObjectParamTwo() {
            CollisionResult r = givenACollisionResult();
            CollisionResult r2 = new CollisionResult(EntityId.WORLD, id2);
            assertFalse(r.equals(r2));
        }

        @Test
        void differentType() {
            CollisionResult r = givenACollisionResult();
            assertFalse(r.equals("ok"));
        }
    }

    @Nested
    class ToString {

        @Test
        void happyFlow() {
            CollisionResult r = givenACollisionResult();
            assertEquals("Collision: " + id1 + " : " + id2, r.toString());
        }
    }
}
