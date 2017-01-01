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

import be.yildiz.common.collections.Lists;
import be.yildiz.common.gameobject.Movable;
import be.yildiz.common.vector.Point3D;

import java.util.List;
import java.util.Optional;

/**
 * @author Grégory Van den Borre
 */
public abstract class AbstractMovableObject implements Movable {

    /**
     * List of children objects.
     */
    private final List<Movable> children = Lists.newList();
    /**
     * Current object position, relative from its parent.
     */
    private Point3D position = Point3D.ZERO;
    /**
     * Current object absolute position.
     */
    private Point3D absolutePosition = Point3D.ZERO;
    /**
     * Optional parent object.
     */
    private Optional<Movable> parent = Optional.empty();

    /**
     * Constructor.
     *
     * @param position Object initial position, absolute position is set at same value.
     */
    public AbstractMovableObject(final Point3D position) {
        super();
        this.position = position;
        this.absolutePosition = position;
    }

    @Override
    public final Point3D getPosition() {
        return this.position;
    }

    @Override
    public final void setPosition(final Point3D newPosition) {
        this.position = newPosition;
        if (this.parent.isPresent()) {
            this.absolutePosition = this.parent.get().getAbsolutePosition().add(newPosition);
        } else {
            this.absolutePosition = this.position;
        }
        this.setPositionImpl(this.absolutePosition);
        for (Movable m : this.children) {
            m.setAbsolutePosition(m.getPosition().add(this.absolutePosition));
        }
    }

    /**
     * Set the position in implementation.
     *
     * @param pos Position to set.
     */
    protected abstract void setPositionImpl(Point3D pos);

    @Override
    public final Point3D getAbsolutePosition() {
        return this.absolutePosition;
    }

    @Override
    public final void setAbsolutePosition(final Point3D pos) {
        this.absolutePosition = pos;
        this.setPositionImpl(this.absolutePosition);
        for (Movable m : this.children) {
            m.setAbsolutePosition(m.getPosition().add(this.absolutePosition));
        }
    }

    @Override
    public final Point3D getDirection() {
        return Point3D.BASE_DIRECTION;
    }

    @Override
    public final void setDirection(Point3D newDirection) {
    }

    @Override
    public final Point3D getAbsoluteDirection() {
        return Point3D.BASE_DIRECTION;
    }

    @Override
    public final void attachTo(Movable other) {
        other.addChild(this);
        this.parent.ifPresent(p -> p.detach(this));
        this.parent = Optional.of(other);
    }

    @Override
    public final void attachToOptional(Movable other) {

    }

    @Override
    public final void detach(Movable other) {
        this.children.remove(other);
    }

    @Override
    public final void addChild(Movable other) {
        this.children.add(other);
    }

}
