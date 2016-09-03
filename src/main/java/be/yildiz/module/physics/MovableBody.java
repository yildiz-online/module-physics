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

import be.yildiz.common.vector.Point3D;
import be.yildiz.common.vector.Quaternion;

/**
 * @author Grégory Van den Borre
 */
public interface MovableBody extends BaseBody {

    /**
     * Set the body direction.
     *
     * @param dirX Direction X value.
     * @param dirY Direction Y value.
     * @param dirZ Direction Z value.
     */
    void setDirection(float dirX, float dirY, float dirZ);

    /**
     * Set the body direction.
     * @param direction Direction value.
     */
    default void setDirection(final Point3D direction) {
        this.setDirection(direction.x, direction.y, direction.z);
    }

    /**
     * Set the body position.
     *
     * @param posX Position X value.
     * @param posY Position Y value.
     * @param posZ Position Z value.
     */
    void setPosition(float posX, float posY, float posZ);

    /**
     * Set the body position.
     * @param position Position value.
     */
    default void setPosition(final Point3D position) {
        this.setPosition(position.x, position.y, position.z);
    }

    /**
     * Rotate the body.
     *
     * @param x Rotation X value.
     * @param y Rotation Y value.
     * @param z Rotation Z value.
     * @param w Rotation W value.
     */
    void setOrientation(float x, float y, float z, float w);

    /**
     * Set the body orientation.
     *
     * @param q New orientation.
     */
    default void setOrientation(Quaternion q) {
        this.setOrientation(q.w, q.x, q.y, q.z);
    }
}
