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

/**
 * Physics object manually moved.
 *
 * @author Grégory Van den Borre
 */
public interface KinematicBody {

    /**
     * Set the body direction.
     *
     * @param dirX Direction X value.
     * @param dirY Direction Y value.
     * @param dirZ Direction Z value.
     */
    void setDirection(float dirX, float dirY, float dirZ);

    /**
     * Set the body position.
     *
     * @param posX Position X value.
     * @param posY Position Y value.
     * @param posZ Position Z value.
     */
    void setPosition(float posX, float posY, float posZ);

    /**
     * Rotate the body.
     *
     * @param x Rotation X value.
     * @param y Rotation Y value.
     * @param z Rotation Z value.
     * @param w Rotation W value.
     */
    void rotate(float x, float y, float z, float w);

    /**
     * @return The object identifier.
     */
    EntityId getId();

    /**
     * Change the size of the object.
     *
     * @param x X scale factor.
     * @param y Y scale factor.
     * @param z Z scale factor.
     */
    void scale(float x, float y, float z);

    /**
     * Delete the body.
     */
    void delete();

    /**
     * While sleeping, an object is not taken into account for collisions.
     *
     * @param sleeping Sleeping or not.
     */
    void sleep(boolean sleeping);
}
