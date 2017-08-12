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
import be.yildiz.common.vector.Point3D;

/**
 * dummy implementation for physic engine.
 *
 * @author Grégory Van den Borre
 */
public final class DummyPhysicEngine extends PhysicEngine {

    /**
     * Build a dummy physic engine.
     */
    public DummyPhysicEngine() {
        super();
    }

    @Override
    protected DummyPhysicWorld createPhysicWorldImpl() {
        return new DummyPhysicWorld();
    }

    /**
     * dummy implementation for physic world.
     *
     * @author Grégory Van den Borre
     */
    public static class DummyPhysicWorld implements PhysicWorld {

        /**
         * Dummy implementation.
         * Does nothing.
         */
        @Override
        public void update() {
            //Dummy implementation.
        }

        /**
         * Dummy implementation.
         *
         * @param origin    Ray origin coordinates.
         * @param direction Ray direction vector.
         * @param distance  Maximum length of the ray.
         * @return World.
         */
        @Override
        public EntityId throwSimpleRay(final Point3D origin, final Point3D direction, final float distance) {
            return EntityId.WORLD;
        }

        @Override
        public PhysicObjectBuilder createBuilder() {
            return new PhysicObjectBuilder() {
                @Override
                public StaticBody buildStatic() {
                    return new DummyBody();
                }

                @Override
                public KinematicBody buildKinematic() {
                    return new DummyBody();
                }

                @Override
                public DynamicBody buildDynamic() {
                    return new DummyBody();
                }

                @Override
                public GhostObject buildGhost() {
                    return new DummyBody();
                }
            };
        }

        /**
         * Dummy implementation.
         *
         * @param origin      Ray origin coordinates.
         * @param destination Ray end coordinates.
         * @return World.
         */
        @Override
        public EntityId throwSimpleRay(final Point3D origin, final Point3D destination) {
            return EntityId.WORLD;
        }

        /**
         * Dummy implementation.
         *
         * @param origin      Ray origin coordinates.
         * @param destination Ray end coordinates.
         * @return World and 0,0,0
         */
        @Override
        public RaycastResult throwRay(final Point3D origin, final Point3D destination) {
            assert  origin != null;
            assert  destination != null;
            return new RaycastResult(0, 0, 0, EntityId.WORLD.value);
        }

        /**
         * Dummy implementation.
         *
         * @param gravityX Gravity value on X axis(horizontal) unused.
         * @param gravityY Gravity value on Y axis(vertical) unused.
         * @param gravityZ Gravity value on Y axis(depth) unused.
         */
        @Override
        public void setGravity(final float gravityX, final float gravityY, final float gravityZ) {
            //Dummy implementation.
        }

        /**
         * Dummy implementation.
         *
         * @return 0, 0, 0
         */
        @Override
        public Point3D getGravity() {
            return Point3D.ZERO;
        }

        /**
         * Dummy implementation.
         *
         * @param gravityValue Value, unused.
         */
        @Override
        public void setGravity(final Gravity gravityValue) {
            //Dummy implementation.
        }

        /**
         * Dummy implementation.
         * Does nothing.
         */
        @Override
        public void delete() {
            //Dummy implementation.
        }

        /**
         * Dummy implementation.
         *
         * @param listener Listener, unused.
         */
        @Override
        public void addCollisionListener(CollisionListener listener) {
            //Dummy implementation.
        }

        /**
         * Dummy implementation.
         *
         * @param listener Listener, Unused.
         */
        @Override
        public void addGhostCollisionListener(CollisionListener listener) {
            //Dummy implementation.
        }
    }
}
