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

/**
 * A dynamic body is moved by physics forces.
 *
 * @author Grégory Van den Borre
 */
public interface DynamicBody extends MovableBody {

    /**
     * Set the body position.
     * @param x Body position X value.
     * @param y Body position Y value.
     * @param z Body position Z value.
     */
    void setPosition(float x, float y, float z);

    /**
     * Set the body position.
     *
     * @param position New position.
     */
    default void setPosition(Point3D position) {
        this.setPosition(position.x, position.y, position.z);
    }

    /**
     * Set the body direction.
     * @param x Body direction X value.
     * @param y Body direction Y value.
     * @param z Body direction Z value.
     */
    void setDirection(float x, float y, float z);

    /**
     * Set the body direction.
     *
     * @param direction New direction.
     */
    default void setDirection(Point3D direction) {
        this.setDirection(direction.x, direction.y, direction.z);
    }

}
