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
import be.yildiz.common.vector.Point3D;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Grégory Van den Borre
 */
public class RaycastResultTest {

    @Test
    public void testFullConstructor() {
        RaycastResult r = new RaycastResult(10, 15, 20, 8L);
        Assert.assertNotNull(r.getContact());
        Assert.assertNotNull(r.getId());
        Assert.assertEquals(Point3D.xyz(10, 15, 20), r.getContact());
        Assert.assertEquals(EntityId.get(8L), r.getId());
    }

    @Test
    public void testFullConstructorObject() {
        RaycastResult r = new RaycastResult(Point3D.xyz(12, 7, 2), EntityId.get(15L));
        Assert.assertNotNull(r.getContact());
        Assert.assertNotNull(r.getId());
        Assert.assertEquals(Point3D.xyz(12, 7, 2), r.getContact());
        Assert.assertEquals(EntityId.get(15L), r.getId());
    }

}