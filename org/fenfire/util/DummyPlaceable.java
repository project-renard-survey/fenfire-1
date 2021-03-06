/*
DummyPlaceable.java
 *    
 *    Copyright (c) 2003, Tuomas J. Lukka
 *    This file is part of Fenfire.
 *    
 *    Fenfire is free software; you can redistribute it and/or modify it under
 *    the terms of the GNU General Public License as published by
 *    the Free Software Foundation; either version 2 of the License, or
 *    (at your option) any later version.
 *    
 *    Fenfire is distributed in the hope that it will be useful, but WITHOUT
 *    ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 *    or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General
 *    Public License for more details.
 *    
 *    You should have received a copy of the GNU General
 *    Public License along with Fenfire; if not, write to the Free
 *    Software Foundation, Inc., 59 Temple Place, Suite 330, Boston,
 *    MA  02111-1307  USA
 *    
 */
/*
 * Written by Tuomas J. Lukka
 */

package org.fenfire.util;
import org.nongnu.libvob.lava.placeable.Placeable;
import org.nongnu.libvob.*;

/** A trivial implementation of Placeable with a single vob and 
 * fixed width, height.
 * XXX Should go to libvob?
 */
public class DummyPlaceable implements Placeable {
    Vob vob;
    float width, height;

    public DummyPlaceable(Vob vob, float width, float height) {
	this.vob = vob;
	this.width = width;
	this.height = height;
    }

    public void place(VobScene vs, int into) {
	vs.put(vob, into);
    }

    public float getWidth() {
	return width;
    }

    public float getHeight() {
	return height;
    }
}
    
