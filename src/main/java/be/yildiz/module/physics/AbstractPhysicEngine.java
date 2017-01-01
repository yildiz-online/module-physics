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
import be.yildiz.common.log.Logger;

import java.util.List;

/**
 * Abstract physic engine, create worlds, shape objects, physic bodies, manage collisions.
 *
 * @author Grégory Van den Borre
 */
public abstract class AbstractPhysicEngine {

    /**
     * List of existing worlds.
     */
    private final List<PhysicWorld> worlds = Lists.newList();

    /**
     * Build a new physic engine.
     */
    protected AbstractPhysicEngine() {
        super();
    }

    /**
     * Update the physic world to its latest state.
     */
    public final void update() {
        this.worlds.forEach(PhysicWorld::update);
    }

    /**
     * Close the engine and free its resources.
     */
    public final void close() {
        this.worlds.forEach(PhysicWorld::delete);
        this.worlds.clear();
        Logger.info("Physic engine closed.");
    }

    /**
     * Create a new world, a world is a portion of the game where entities interact each other. Entities from a world cannot interact with entities from am other world.
     *
     * @return The created physic world.
     */
    public PhysicWorld createPhysicWorld() {
        PhysicWorld w = this.createPhysicWorldImpl();
        this.worlds.add(w);
        return w;
    }

    /**
     * Create a new world in implementation.
     *
     * @return The created world.
     */
    protected abstract PhysicWorld createPhysicWorldImpl();
}
