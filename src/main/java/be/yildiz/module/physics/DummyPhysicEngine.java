//        This file is part of the Yildiz-Online project, licenced under the MIT License
//        (MIT)
//
//        Copyright (c) 2016 Grégory Van den Borre
//
//        More infos available: http://yildiz.bitbucket.org
//
//        Permission is hereby granted, free of charge, to any person obtaining a copy
//        of this software and associated documentation files (the "Software"), to deal
//        in the Software without restriction, including without limitation the rights
//        to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
//        copies of the Software, and to permit persons to whom the Software is
//        furnished to do so, subject to the following conditions:
//
//        The above copyright notice and this permission notice shall be included in all
//        copies or substantial portions of the Software.
//
//        THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//        IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
//        FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
//        AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
//        LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
//        OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
//        SOFTWARE.

package be.yildiz.module.physics;

import be.yildiz.common.id.EntityId;
import be.yildiz.common.shape.Box;
import be.yildiz.common.shape.Sphere;
import be.yildiz.common.vector.Point3D;
import lombok.NonNull;

/**
 * dummy implementation for physic engine.
 *
 * @author Grégory Van den Borre
 */
public final class DummyPhysicEngine extends AbstractPhysicEngine {

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
        public RaycastResult throwRay(@NonNull final Point3D origin, @NonNull final Point3D destination) {
            return new RaycastResult(0, 0, 0, EntityId.WORLD.value);
        }

        /**
         * Dummy implementation.
         *
         * @param gravityX Gravity value on X axis(horizontal).
         * @param gravityY Gravity value on Y axis(vertical).
         * @param gravityZ
         */
        @Override
        public void setGravity(final float gravityX, final float gravityY, final float gravityZ) {
            //Dummy implementation.
        }

        /**
         * Dummy implementation.
         *
         * @param id       Id retrieved when this ghost collide, must be unique.
         * @param box      Ghost shape.
         * @param position Initial object position.
         * @return null.
         */
        @Override
        public GhostObject createGhostObject(EntityId id, Box box, Point3D position) {
            return null;
        }

        /**
         * Dummy implementation.
         *
         * @param id       Id retrieved when this ghost collide, must be unique.
         * @param sphere   Ghost shape.
         * @param position Initial object position.
         * @return null.
         */
        @Override
        public GhostObject createGhostObject(EntityId id, Sphere sphere, Point3D position) {
            return null;
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
         * @param gravityValue
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

        @Override
        public StaticBody createStaticBody(EntityId id, Box box, Point3D position, Point3D direction) {
            return null;
        }

        @Override
        public StaticBody createStaticBody(EntityId id, Sphere sphere, Point3D position, Point3D direction) {
            return null;
        }

        @Override
        public StaticBody createStaticBody(EntityId id, PhysicMesh mesh, Point3D position, Point3D direction) {
            return null;
        }

        @Override
        public KinematicBody createKinematicBody(EntityId id, Box box, Point3D position) {
            return null;
        }

        @Override
        public KinematicBody createKinematicBody(EntityId id, Sphere sphere, Point3D position) {
            return null;
        }

        @Override
        public KinematicBody createKinematicBody(EntityId id, PhysicMesh mesh, Point3D position) {
            return null;
        }

        @Override
        public DynamicBody createDynamicBody(EntityId id, Box box, Point3D position, float mass) {
            return null;
        }

        @Override
        public DynamicBody createDynamicBody(EntityId id, Sphere sphere, Point3D position, float mass) {
            return null;
        }

        @Override
        public DynamicBody createDynamicBody(EntityId id, PhysicMesh mesh, Point3D position, float mass) {
            return null;
        }

        /**
         * Dummy implementation.
         *
         * @param listener
         */
        @Override
        public void addCollisionListener(@NonNull CollisionListener listener) {
            //Dummy implementation.
        }

        /**
         * Dummy implementation.
         *
         * @param listener
         */
        @Override
        public void addGhostCollisionListener(@NonNull CollisionListener listener) {
            //Dummy implementation.
        }
    }
}