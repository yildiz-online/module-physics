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

import be.yildizgames.common.geometry.Point3D;
import be.yildizgames.common.model.EntityId;
import be.yildizgames.common.shape.Box;
import be.yildizgames.common.shape.Plane;
import be.yildizgames.common.shape.Sphere;

import java.util.Objects;

/**
 * @author Grégory Van den Borre
 */
public abstract class PhysicObjectBuilder {

    protected EntityId id;

    protected float mass = 0f;

    protected Box box;

    protected Sphere sphere;

    protected Plane plane;

    protected PhysicMesh mesh;

    protected Point3D position = Point3D.ZERO;

    protected Point3D direction = Point3D.BASE_DIRECTION;

    public PhysicObjectBuilder withId(final long id) {
        return this.withId(EntityId.valueOf(id));
    }

    public PhysicObjectBuilder withId(final EntityId id) {
        Objects.requireNonNull(id);
        this.id = id;
        return this;
    }

    public PhysicObjectBuilder withMass(final float mass) {
        this.mass = mass;
        return this;
    }

    public PhysicObjectBuilder withShape(Box box) {
        this.box = box;
        return this;
    }

    public PhysicObjectBuilder withShape(Plane plane) {
        this.plane = plane;
        return this;
    }

    public PhysicObjectBuilder withShape(Sphere sphere) {
        this.sphere = sphere;
        return this;
    }

    public PhysicObjectBuilder withShape(PhysicMesh mesh) {
        this.mesh = mesh;
        return this;
    }

    public PhysicObjectBuilder atPosition(Point3D position) {
        this.position = position;
        return this;
    }

    public PhysicObjectBuilder withDirection(Point3D direction) {
        this.direction = direction;
        return this;
    }

    public abstract StaticBody buildStatic();

    public abstract KinematicBody buildKinematic();

    public abstract DynamicBody buildDynamic();

    public abstract GhostObject buildGhost();

}
