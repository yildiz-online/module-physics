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
import be.yildiz.common.id.EntityIdentifiable;

/**
 * Contains the result of a collision between 2 objects.
 *
 * @author Grégory Van den Borre
 */
public final class CollisionResult {

    /**
     * Collided object Id.
     */
    public final EntityId object1;

    /**
     * Collided object Id.
     */
    public final EntityId object2;

    public CollisionResult(final EntityId e1, final EntityId e2) {
        super();
        this.object1 = e1;
        this.object2 = e2;
    }

    public boolean contains(final EntityIdentifiable entity) {
        return this.contains(entity.getId());
    }

    public boolean contains(final EntityIdentifiable entity, final EntityIdentifiable entity2) {
        return this.contains(entity.getId(), entity2.getId());
    }

    public boolean containsAndNot(final EntityIdentifiable entity, final EntityIdentifiable entity2) {
        return this.containsAndNot(entity.getId(), entity2.getId());
    }

    /**
     * Check if an id is implied in this collision.
     *
     * @param id Id to check.
     * @return <code>true</code> if the provided id is implied in this collision.
     */
    public boolean contains(final EntityId id) {
        return this.object1.equals(id) || this.object2.equals(id);
    }

    public boolean contains(final EntityId id, final EntityId id2) {
        return (this.object1.equals(id) && this.object2.equals(id2)) || (this.object2.equals(id) && this.object1.equals(id2));
    }

    public boolean containsAndNot(final EntityId id, final EntityId id2) {
        return (this.object1.equals(id) && !this.object2.equals(id2)) || (this.object2.equals(id) && !this.object1.equals(id2));
    }

    /**
     * @return The sum of the 2 Id hash codes.
     */
    @Override
    public int hashCode() {
        return this.object1.hashCode() + this.object2.hashCode();
    }

    /**
     * @param o Other object to test.
     * @return true if o is not null, is a CollisionResult and contains the same Ids as this object(order does not matter.)
     */
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof CollisionResult)) {
            return false;
        }
        final CollisionResult other = (CollisionResult) o;
        return (this.object1.equals(other.object2) && this.object2.equals(other.object1)) || (this.object1.equals(other.object1) && this.object2.equals(other.object2));
    }

    @Override
    public String toString() {
        return "Collision: " + this.object1 + " : " + this.object2;
    }
}
