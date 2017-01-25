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
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * @author Grégory Van den Borre
 */
@RunWith(Enclosed.class)
public class CollisionResultTest {

    private static final EntityId id1 = EntityId.get(4L);
    private static final EntityId id2 = EntityId.get(3L);

    private static final EntityIdentifiable enid1 = () -> id1;
    private static final EntityIdentifiable enid2 = () -> id2;

    private static CollisionResult givenACollisionResult() {
        return new CollisionResult(id1, id2);
    }

    public static class Constructor {

        @Test
        public void happyFlow() {
            CollisionResult r = givenACollisionResult();
            Assert.assertEquals(id1, r.object1);
            Assert.assertEquals(id2, r.object2);
        }

        @Test(expected = AssertionError.class)
        public void withObject1Null() {
            new CollisionResult(null, id2);
        }

        @Test(expected = AssertionError.class)
        public void withObject2Null() {
            new CollisionResult(id1, null);
        }
    }

    public static class Contains {

        @Test
        public void happyFlow() {
            CollisionResult r = givenACollisionResult();
            Assert.assertTrue(r.contains(id1));
            Assert.assertTrue(r.contains(id2));
            Assert.assertFalse(r.contains(EntityId.WORLD));
        }

        @Test
        public void happyFlowTwoParams() {
            CollisionResult r = givenACollisionResult();
            Assert.assertTrue(r.contains(id1, id2));
            Assert.assertFalse(r.contains(EntityId.WORLD, id2));
        }

        @Test
        public void happyFlowIdentifiable() {
            CollisionResult r = givenACollisionResult();
            Assert.assertTrue(r.contains(enid1));
            Assert.assertTrue(r.contains(enid2));
            Assert.assertFalse(r.contains(() -> EntityId.WORLD));
        }

        @Test
        public void happyFlowIdentifiableTwoParams() {
            CollisionResult r = givenACollisionResult();
            Assert.assertTrue(r.contains(enid1, enid2));
            Assert.assertFalse(r.contains(() -> EntityId.WORLD, enid2));
        }

        @Test(expected = AssertionError.class)
        public void withNull() {
            CollisionResult r = givenACollisionResult();
            r.contains((EntityId)null);
        }

        @Test(expected = AssertionError.class)
        public void withNullParamOne() {
            CollisionResult r = givenACollisionResult();
            r.contains(null, id2);
        }

        @Test(expected = AssertionError.class)
        public void withNullParamTwo() {
            CollisionResult r = givenACollisionResult();
            r.contains(id1, null);
        }

        @Test(expected = AssertionError.class)
        public void withNullIdentifiable() {
            CollisionResult r = givenACollisionResult();
            r.contains((EntityIdentifiable) null);
        }

        @Test(expected = AssertionError.class)
        public void withNullIdentifiableParamOne() {
            CollisionResult r = givenACollisionResult();
            r.contains(null, enid2);
        }

        @Test(expected = AssertionError.class)
        public void withNullIdentifiableParamTwo() {
            CollisionResult r = givenACollisionResult();
            r.contains(enid1, null);
        }

    }

    public static class ContainsAndNot {

        @Test
        public void happyFlow() {
            CollisionResult r = givenACollisionResult();
            Assert.assertTrue(r.contains(id1, id2));
            Assert.assertFalse(r.contains(EntityId.WORLD));
            Assert.assertTrue(r.containsAndNot(id1, EntityId.WORLD));
            Assert.assertTrue(r.containsAndNot(EntityId.WORLD, id2));
            Assert.assertTrue(r.containsAndNot(id2, EntityId.WORLD));
            Assert.assertTrue(r.containsAndNot(EntityId.WORLD, id1));
        }

        @Test(expected = AssertionError.class)
        public void withParamOneNull() {
            CollisionResult r = givenACollisionResult();
            r.containsAndNot(null, enid2);
        }

        @Test(expected = AssertionError.class)
        public void withParamTwoNull() {
            CollisionResult r = givenACollisionResult();
            r.containsAndNot(enid1, null);
        }

        @Test
        public void happyFlowIdentifiable() {
            CollisionResult r = givenACollisionResult();
            Assert.assertTrue(r.contains(enid1, enid2));
            Assert.assertFalse(r.contains(() -> EntityId.WORLD));
            Assert.assertTrue(r.containsAndNot(enid1, () -> EntityId.WORLD));
            Assert.assertTrue(r.containsAndNot(() -> EntityId.WORLD, enid2));
            Assert.assertTrue(r.containsAndNot(enid2, () -> EntityId.WORLD));
            Assert.assertTrue(r.containsAndNot(() -> EntityId.WORLD, enid1));
        }

        @Test
        public void containsBoth() {
            CollisionResult r = givenACollisionResult();
            Assert.assertFalse(r.containsAndNot(id1, id2));
        }

        @Test
        public void containsNone() {
            CollisionResult r = givenACollisionResult();
            Assert.assertFalse(r.containsAndNot(EntityId.WORLD, EntityId.get(1000L)));
        }
    }

    public static class HashCode {

        @Test
        public void happyFlow() {
            CollisionResult r = givenACollisionResult();
            Assert.assertEquals(id1.hashCode() + id2.hashCode(), r.hashCode());
        }
    }

    public static class Equals {

        @Test
        public void sameInstance() {
            CollisionResult r = givenACollisionResult();
            Assert.assertTrue(r.equals(r));
        }

        @Test
        public void sameObject() {
            CollisionResult r = givenACollisionResult();
            CollisionResult r2 = givenACollisionResult();
            Assert.assertTrue(r.equals(r2));
        }

        @Test
        public void differentOrder() {
            CollisionResult r = givenACollisionResult();
            CollisionResult r2 = new CollisionResult(id2, id1);
            Assert.assertTrue(r.equals(r2));
        }

        @Test
        public void withNull() {
            CollisionResult r = givenACollisionResult();
            Assert.assertFalse(r.equals(null));
        }

        @Test
        public void differentObject() {
            CollisionResult r = givenACollisionResult();
            CollisionResult r2 = new CollisionResult(id1, EntityId.WORLD);
            Assert.assertFalse(r.equals(r2));
        }

        @Test
        public void differentObjectParamTwo() {
            CollisionResult r = givenACollisionResult();
            CollisionResult r2 = new CollisionResult(EntityId.WORLD, id2);
            Assert.assertFalse(r.equals(r2));
        }

        @Test
        public void differentType() {
            CollisionResult r = givenACollisionResult();
            Assert.assertFalse(r.equals("ok"));
        }
    }

    public static class ToString {

        @Test
        public void happyFlow() {
            CollisionResult r = givenACollisionResult();
            Assert.assertEquals("Collision: " + id1 + " : " + id2, r.toString());
        }
    }
}
