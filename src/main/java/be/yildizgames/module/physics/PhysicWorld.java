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

import be.yildizgames.common.gameobject.CollisionListener;
import be.yildizgames.common.geometry.Point3D;
import be.yildizgames.common.model.EntityId;

/**
 * A physic world is a world where physic entities live, they can be static, kinematic or dynamic.
 *
 * @author Grégory Van den Borre
 */
public interface PhysicWorld extends World {

    /**
     * Update this world state, this is called by the physic engine, it should not be called explicitly excepted for tests.
     */
    void update();

    /**
     * Throw a ray to a distant direction.
     *
     * @param origin    Ray origin coordinates.
     * @param direction Ray direction vector.
     * @param distance  Maximum length of the ray.
     * @return The collided object.
     */
    EntityId throwSimpleRay(Point3D origin, Point3D direction, float distance);

    PhysicObjectBuilder createObject();

    /**
     * Called when then engine stops.
     */
    void delete();

    /**
     * Add a collision listener to be notified when collision occurs.
     *
     * @param listener Listener to add.
     */
    void addCollisionListener(CollisionListener listener);

    /**
     * Add a collision listener to be notified when collision occurs with ghost objects.
     *
     * @param listener Listener to add.
     */
    void addGhostCollisionListener(CollisionListener listener);
}
