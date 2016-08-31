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

import be.yildiz.common.gameobject.Movable;
import be.yildiz.common.vector.Point3D;

/**
 * @author Grégory Van den Borre
 */
public abstract class AbstractStaticObject implements Movable {

    /**
     * Immutable position.
     */
    private final Point3D direction;

    /**
     * Immutable direction.
     */
    private final Point3D position;

    /**
     * Constructor.
     *
     * @param initialPosition  Immutable position.
     * @param initialDirection Immutable direction.
     */
    public AbstractStaticObject(final Point3D initialPosition, final Point3D initialDirection) {
        super();
        this.position = initialPosition;
        this.direction = initialDirection;
    }

    @Override
    public final void attachTo(final Movable other) {
    }

    @Override
    public final void detach(final Movable other) {
    }

    @Override
    public final void addChild(final Movable other) {
    }

    @Override
    public final void attachToOptional(final Movable other) {
    }

    @Override
    public final Point3D getPosition() {
        return this.position;
    }

    @Override
    public final void setPosition(final Point3D newPosition) {
    }

    @Override
    public final Point3D getAbsolutePosition() {
        return this.position;
    }

    @Override
    public final void setAbsolutePosition(final Point3D pos) {
    }

    @Override
    public final Point3D getDirection() {
        return this.direction;
    }

    @Override
    public final void setDirection(final Point3D newDirection) {
    }

    @Override
    public final Point3D getAbsoluteDirection() {
        return this.direction;
    }
}