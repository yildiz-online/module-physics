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

import be.yildizgames.common.exception.implementation.ImplementationException;
import be.yildizgames.common.model.EntityId;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Grégory Van den Borre
 */
public class PhysicObjectBuilderTest {

    @Nested
    public class WithId {

        @Test
        public void happyFlow() {
            PhysicObjectBuilder builder = givenABuilder();
            builder.withId(5);
            assertEquals(EntityId.valueOf(5), builder.id);
        }

        @Test
        public void happyFlowId() {
            PhysicObjectBuilder builder = givenABuilder();
            builder.withId(EntityId.valueOf(3));
            assertEquals(EntityId.valueOf(3), builder.id);
        }

        @Test
        public void withNullId() {
            PhysicObjectBuilder builder = givenABuilder();
            assertThrows(ImplementationException.class, () -> builder.withId(null));
        }

    }

    private static PhysicObjectBuilder givenABuilder() {
        PhysicObjectBuilder mock = Mockito.mock(PhysicObjectBuilder.class);
        Mockito.when(mock.withId(5)).thenCallRealMethod();
        Mockito.when(mock.withId(EntityId.valueOf(3))).thenCallRealMethod();
        Mockito.when(mock.withId(EntityId.valueOf(5))).thenCallRealMethod();
        Mockito.when(mock.withId(null)).thenCallRealMethod();
        return mock;
    }

}