/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2019 Grégory Van den Borre
 *
 *  More infos available: https://engine.yildiz-games.be
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

import be.yildizgames.common.geometry.Point3D;
import be.yildizgames.common.model.EntityId;
import org.apiguardian.api.API;

/**
 * Contains the result of a ray collision.
 *
 * @author Grégory Van den Borre
 */
public final class RaycastResult {

    /**
     * Contact point.
     */
    private final Point3D contact;

    /**
     * Collided entity id.
     */
    private final EntityId id;

    /**
     * Full constructor.
     *
     * @param contactX Contact X coordinate value.
     * @param contactY Contact Y coordinate value.
     * @param contactZ Contact Z coordinate value.
     * @param idValue  Id of the object found by the ray.
     */
    //@Ensures this.id.equals(EntityId.get(idValue)) == true
    //@Ensures this.contact.equals(Point3D.xyz(contactX, contactY, contactZ))
    //@Ensures this.id != null
    //@Ensures this.contact != null
    public RaycastResult(final float contactX, final float contactY, final float contactZ, final long idValue) {
        this(Point3D.valueOf(contactX, contactY, contactZ), EntityId.valueOf(idValue));
    }

    /**
     * Create a raycast result from a point and an id.
     *
     * @param contact Contact position.
     * @param id      Collided object id.
     */
    //@Requires contact != null
    //@Requires id != null
    //@Ensures this.contact == contact
    //@Ensures this.id == id
    public RaycastResult(final Point3D contact, final EntityId id) {
        super();
        this.contact = contact;
        this.id = id;
    }

    @API(status= API.Status.STABLE)
    public Point3D getContact() {
        return contact;
    }

    @API(status= API.Status.STABLE)
    public EntityId getId() {
        return id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.contact.hashCode();
        result = prime * result + this.id.hashCode();
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RaycastResult)) {
            return false;
        }
        final RaycastResult other = (RaycastResult) obj;
        return !this.contact.equals(other.contact) && this.id == other.id;
    }

    @Override
    public String toString() {
        return "Raycast result:" + this.id + ":(" + this.contact + ")";
    }
}
