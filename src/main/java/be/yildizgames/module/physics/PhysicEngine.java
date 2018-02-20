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

import be.yildizgames.module.physics.dummy.DummyPhysicEngineProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * Abstract physic engine, create worlds, shape objects, physic bodies, manage collisions.
 *
 * @author Grégory Van den Borre
 */
public abstract class PhysicEngine {

    /**
     * List of existing worlds.
     */
    private final List<PhysicWorld> worlds = new ArrayList<>();

    private boolean stop;

    /**
     * Build a new physic engine.
     */
    protected PhysicEngine() {
        super();
    }

    public static PhysicEngine getEngine() {
        ServiceLoader<PhysicEngineProvider> provider = ServiceLoader.load(PhysicEngineProvider.class);
        return provider.findFirst().orElseGet(DummyPhysicEngineProvider::new).getPhysicEngine();
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
        this.stop = true;
        this.worlds.forEach(PhysicWorld::delete);
        this.worlds.clear();
    }

    /**
     * Create a new thread and run the engine.
     */
    public final PhysicEngine start() {
        new Thread(this::runEngine).start();
        return this;
    }

    /**
     * Create a new world, a world is a portion of the game where entities interact each other. Entities from a world cannot interact with entities from am other world.
     *
     * @return The created physic world.
     */
    public final PhysicWorld createWorld() {
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

    private void runEngine() {
        while(!this.stop) {
            this.update();
        }
    }

}
