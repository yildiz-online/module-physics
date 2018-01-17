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


import be.yildizgames.common.gameobject.Movable;
import be.yildizgames.common.geometry.Point3D;
import be.yildizgames.common.geometry.Quaternion;
import be.yildizgames.common.model.EntityId;

/**
 * @author Grégory Van den Borre
 */
public class DummyBody implements StaticBody, KinematicBody, DynamicBody, GhostObject {

    @Override
    public EntityId getId() {
        return EntityId.WORLD;
    }

    @Override
    public void attachTo(Movable other) {
        //Does nothing
    }

    @Override
    public void addChild(Movable other) {
        //Does nothing
    }

    @Override
    public void removeChild(Movable child) {
        //Does nothing
    }

    @Override
    public Movable getInternal() {
        return this;
    }

    @Override
    public void attachToOptional(Movable other) {
        //Does nothing
    }

    @Override
    public void detachFromParent() {
        //Does nothing
    }

    @Override
    public Point3D getPosition() {
        return Point3D.ZERO;
    }

    @Override
    public Point3D getAbsolutePosition() {
        return Point3D.ZERO;
    }

    @Override
    public Point3D getDirection() {
        return Point3D.BASE_DIRECTION;
    }

    @Override
    public Point3D getAbsoluteDirection() {
        return Point3D.BASE_DIRECTION;
    }

    @Override
    public void scale(float x, float y, float z) {
        //Does nothing
    }

    @Override
    public void sleep(boolean sleeping) {
        //Does nothing
    }

    @Override
    public void setDirection(float dirX, float dirY, float dirZ) {
        //Does nothing
    }

    @Override
    public void addOptionalChild(Movable child) {
        //Does nothing
    }

    @Override
    public void setDirection(Point3D direction) {
        //Does nothing
    }

    @Override
    public void setPosition(float posX, float posY, float posZ) {
        //Does nothing
    }

    @Override
    public void setPosition(Point3D position) {
        //Does nothing
    }

    @Override
    public void setOrientation(float x, float y, float z, float w) {
        //Does nothing
    }

    @Override
    public void setOrientation(Quaternion q) {
        //Does nothing
    }

    @Override
    public void delete() {
        //Does nothing
    }
}
