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
 * A static body will nor move neither be affected by physic forces.
 *
 * @author Grégory Van den Borre
 */
public interface StaticBody {

    /**
     * Scale the body along 3 axes.
     *
     * @param x X scaling value.
     * @param y Y scaling value.
     * @param z Z scaling value.
     */
    void scale(float x, float y, float z);

    /**
     * Activate or deactivate this body in the world.
     * Once sleeping a body will no longer interact with its surrounding.
     *
     * @param sleeping
     * @Ensures this.body will no longer interact if sleeping == true or will interact if sleeping == false.
     */
    void sleep(boolean sleeping);

    /**
     * @return This body unique id.
     * @Ensures return value != null
     */
    EntityId getId();

    /**
     * Delete the body and remove it from its world.
     *
     * @Ensures The body is deleted.
     * @Ensures The associated world no longer contains this body.
     */
    void delete();
}
