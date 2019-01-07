/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2018 Grégory Van den Borre
 *
 *  More infos available: https://www.yildiz-games.be
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

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


/**
 * @author Grégory Van den Borre
 */
public abstract class AbstractMovableObject implements Movable {

    /**
     * List of children objects.
     */
    private final Set<Movable> children = new HashSet<>();

    /**
     * Optional parent object.
     */
    private Movable parent = null;

    /**
     * Constructor.
     */
    protected AbstractMovableObject() {
        super();
    }

    /**
     * An object can be attached to another one, in this case the attached
     * object position and direction will be relative to its parent.
     * The absolute position is not relative to the parent but to the world.
     * @return The absolute position.
     */
    @Override
    public final Point3D getAbsolutePosition() {
        if(this.parent == null) {
            return this.getPosition();
        }
        return this.getPosition().add(this.parent.getAbsolutePosition());
    }

    @Override
    public final void attachTo(Movable other) {
        other.addChild(this);
        this.detachFromParent();
        this.parent = other;
    }

    @Override
    public final void attachToOptional(Movable other) {
        this.attachTo(other);
    }

    @Override
    public final void addChild(Movable other) {
        if(this.children.add(other)) {
            other.attachTo(this);
        }
    }

    @Override
    public final void setDirection(Point3D newDirection) {
        this.setDirection(newDirection.x, newDirection.y, newDirection.z);
    }

    @Override
    public final void setPosition(Point3D newPosition) {
        assert newPosition != null;
        this.setPosition(newPosition.x, newPosition.y, newPosition.z);
    }

    /**
     * An object can be attached to another one, in this case the attached
     * object position and direction will be relative to its parent.
     * The absolute direction is not relative to the parent but to the world.
     * @return The normalized absolute direction.
     */
    @Override
    public final Point3D getAbsoluteDirection() {
        if(this.parent == null) {
            return Point3D.normalize(this.getDirection());
        }
        return Point3D.normalize(this.getDirection().add(this.parent.getAbsolutePosition()));
    }

    @Override
    public final void detachFromParent() {
        Optional.ofNullable(this.parent).ifPresent(p -> p.removeChild(this));
        this.parent = null;
    }

    @Override
    public final void addOptionalChild(Movable child) {
        //TODO do
    }

    @Override
    public final void removeChild(Movable child) {
        //TODO do
    }

}
