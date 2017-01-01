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

/**
 * Constant gravity values for common planets and satellites.
 *
 * @author Grégory Van den Borre
 */
public enum Gravity {

    /**
     * Gravity in empty environment, 0.
     */
    SPACE(-0.0f),

    /**
     * Gravity on Earth planet.
     */
    EARTH(9.81f),

    /**
     * Gravity on Mars planet.
     */
    MARS(3.69f),

    /**
     * Gravity on Earth moon.
     */
    MOON(1.63f),

    /**
     * Gravity on Venus planet.
     */
    VENUS(8.87f),

    /**
     * Gravity on Mercure planet.
     */
    MERCURE(3.701f),

    /**
     * Gravity on floating environment -0.1.
     */
    FLOATING(-0.1f);

    /**
     * Gravity speed, on the Y axis.
     */
    public final float value;

    /**
     * Full constructor.
     *
     * @param gravityValue Gravity value(in m/sec²).
     */
    Gravity(final float gravityValue) {
        this.value = gravityValue;
    }
}
