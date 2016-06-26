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

    /**
     * Called when then engine stops.
     */
    void delete();

    /**
     * Create a static physic box, it a given Id, cannot move, and will not be affected in any way by physics dynamic, but is collidable. It is usually used to represent collidable object like
     * buildings, trees...
     *
     * @param id        Id to retrieve when object is selected, has collisions...
     * @param box       Box to use physic resource.
     * @param position  Object immutable position, InvalidParamException is thrown in case of null parameter.
     * @param direction Object immutable direction, InvalidParamException is thrown in case of null parameter.
     * @return The built object.
     */
    StaticBody createStaticBody(EntityId id, Box box, Point3D position, Point3D direction);

    /**
     * Create a static physic sphere, it a given Id, cannot move, and will not be affected in any way by physics dynamic, but is collidable. It is usually used to represent collidable object like
     * buildings, trees...
     *
     * @param id        Id to retrieve when object is selected, has collisions...
     * @param sphere    Sphere to use physic resource.
     * @param position  Object immutable position, InvalidParamException is thrown in case of null parameter.
     * @param direction Object immutable direction, InvalidParamException is thrown in case of null parameter.
     * @return The built object.
     */
    StaticBody createStaticBody(EntityId id, Sphere sphere, Point3D position, Point3D direction);

    /**
     * Create a static physic body, it a given Id, cannot move, and will not be affected in any way by physics dynamic, but is collidable. It is usually used to represent collidable object like
     * buildings, trees...
     *
     * @param id        Id to retrieve when object is selected, has collisions...
     * @param mesh      Mesh to use physic resource.
     * @param position  Object immutable position, InvalidParamException is thrown in case of null parameter.
     * @param direction Object immutable direction, InvalidParamException is thrown in case of null parameter.
     * @return The built object.
     */
    StaticBody createStaticBody(EntityId id, PhysicMesh mesh, Point3D position, Point3D direction);

    /**
     * Create a movable physic box, it has a given Id and will not be affected in any way by physics dynamic, but is collidable.
     * It is usually used to represent playable or movable object like characters, vehicles...
     *
     * @param id       Id to retrieve when object is selected, has collisions...
     * @param box      Box to use physic resource.
     * @param position Object initial position.
     * @return The built body.
     */
    KinematicBody createKinematicBody(EntityId id, Box box, Point3D position);

    /**
     * Create a movable physic sphere, it has a given Id and will not be affected in any way by physics dynamic, but is collidable.
     * It is usually used to represent playable or movable object like characters, vehicles...
     *
     * @param id       Id to retrieve when object is selected, has collisions...
     * @param sphere   Sphere to use physic resource.
     * @param position Object initial position.
     * @return The built body.
     */
    KinematicBody createKinematicBody(EntityId id, Sphere sphere, Point3D position);

    /**
     * Create a movable physic mesh, it has a given Id and will not be affected in any way by physics dynamic, but is collidable. It is usually used to represent playable or movable object like
     * characters, vehicles...
     *
     * @param id       Id to retrieve when object is selected, has collisions...
     * @param mesh     Mesh to use physic resource.
     * @param position Object initial position.
     * @return The built object.
     */
    KinematicBody createKinematicBody(EntityId id, PhysicMesh mesh, Point3D position);

    /**
     * Create a dynamic physic box, it has a given Id and will be affected by physics dynamic.
     *
     * @param id       Id to retrieve when object is selected, has collisions...
     * @param box      Box to use physic resource.
     * @param position Object initial position.
     * @param mass     Object mass.
     * @return The built body.
     */
    DynamicBody createDynamicBody(EntityId id, Box box, Point3D position, float mass);

    /**
     * Create a dynamic physic sphere, it has a given Id and will be affected by physics dynamic.
     *
     * @param id       Id to retrieve when object is selected, has collisions...
     * @param sphere   Sphere to use physic resource.
     * @param position Object initial position.
     * @param mass     Object mass.
     * @return The built body.
     */
    DynamicBody createDynamicBody(EntityId id, Sphere sphere, Point3D position, float mass);

    /**
     * Create a dynamic physic mesh, it has a given Id and will be affected by physics dynamic.
     *
     * @param id       Id to retrieve when object is selected, has collisions...
     * @param mesh     Mesh to use physic resource.
     * @param position Object initial position.
     * @param mass     Object mass.
     * @return The built body.
     */
    DynamicBody createDynamicBody(EntityId id, PhysicMesh mesh, Point3D position, float mass);

    /**
     * Add a collision listener to be notified when collision occurs.
     *
     * @param listener Listener to add.
     */
    void addCollisionListener(@NonNull CollisionListener listener);

    /**
     * Add a collision listener to be notified when collision occurs with ghost objects.
     *
     * @param listener Listener to add.
     */
    void addGhostCollisionListener(@NonNull CollisionListener listener);
}
