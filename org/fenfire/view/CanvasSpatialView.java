/*
CanvasSpatialView.java
 *    
 *    Copyright (c) 2005, Benja Fallenstein and Matti Katila
 *
 *    This file is part of Fenfire.
 *    
 *    Libvob is free software; you can redistribute it and/or modify it under
 *    the terms of the GNU General Public License as published by
 *    the Free Software Foundation; either version 2 of the License, or
 *    (at your option) any later version.
 *    
 *    Libvob is distributed in the hope that it will be useful, but WITHOUT
 *    ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 *    or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General
 *    Public License for more details.
 *    
 *    You should have received a copy of the GNU General
 *    Public License along with Libvob; if not, write to the Free
 *    Software Foundation, Inc., 59 Temple Place, Suite 330, Boston,
 *    MA  02111-1307  USA
 *    
 *
 */
/*
 * Written by Benja Fallenstein and Matti Katila
 */
package org.fenfire.view;
import org.fenfire.Cursor;
import org.fenfire.swamp.*;
import org.fenfire.vocab.*;
import org.fenfire.lob.*;
import org.fenfire.util.RDFUtil;
import org.nongnu.libvob.lob.*;
import org.nongnu.libvob.*;
import org.nongnu.libvob.util.*;
import org.nongnu.navidoc.util.Obs;
import java.awt.Color;
import java.util.*;

public class CanvasSpatialView implements SpatialViewSettings.SpatialView {
    static private void p(String s) { System.out.println("CanvasSpatialView:: "+s); }

    private Graph graph;
    private ContentViewSettings contentViewSettings;
    private WindowAnimation winAnim;

    private Map canvasCache = new org.nongnu.navidoc.util.WeakValueMap();
    private Map buoyCache = new org.nongnu.navidoc.util.WeakValueMap();

    public CanvasSpatialView(Graph graph, 
			     ContentViewSettings contentViewSettings,
			     WindowAnimation winAnim) {
	this.graph = graph;
	this.contentViewSettings = contentViewSettings;
	this.winAnim = winAnim;
    }



    public final ViewSettings.Type TYPE = // XXX should be static
	new ViewSettings.AbstractType() {
	    public boolean containsNode(Object node) {
		return graph.find1_X11(CANVAS2D.contains, node) != null;
	    }
	};
    
    public Set getTypes() {
	return Collections.singleton(TYPE);
    }

    protected CanvasCursor getCanvasCursor(Cursor c) {
	Object pos = c.getSpatialCursor();

	if (pos instanceof CanvasCursor) {
	    return (CanvasCursor)pos;
	} else {
	    Object n = c.getNode();
	    return makeCanvasCursor(n);
	}
    }

    protected CanvasCursor makeCanvasCursor(Object n) {
	Object canvas = graph.find1_X11(CANVAS2D.contains, n);

	float x = RDFUtil.getFloat(graph, n, CANVAS2D.x);
	float y = RDFUtil.getFloat(graph, n, CANVAS2D.x);
	
	Lob l = getContentLob(n);
	SizeRequest r = l.getSizeRequest();

	x += r.natW/2;
	y += r.natH/2;

	return new CanvasCursor(canvas, x, y, 1);
    }


    public Lob getMainviewLob(Cursor cursor) {
	Object node = cursor.getNode();
	CanvasCursor cc = getCanvasCursor(cursor);

	Lob l = getCanvasContent(cc.getCanvas(), cursor);

	l = Lobs.translate(l, -cc.getPanX(), -cc.getPanY());
	l = Lobs.scale(l, cc.getZoom());
	l = Lobs.align(l, .5f, .5f);

	/*
	Lob l = new DragController(pzl, 3, new org.nongnu.libvob.mouse.RelativeAdapter() {
		public void startDrag(int x, int y) {
		    super.startDrag(x, y);
		    mainviewCache = (Lob)theLob.get();
		}

		public void changedRelative(float dx, float dy) {
		    float nx = panX.getFloat();
		    float ny = panY.getFloat();
		    float nz = zoom.getFloat() + dy/100;

		    zoom.setFloat(nz);

		    pzl.setParams(nx, ny, nz);
		    mainviewCache = (Lob)theLob.get();
		    winAnim.rerender();
		}
	    });
	l = new DragController(l, 1, new org.nongnu.libvob.mouse.RelativeAdapter() {
		public void startDrag(int x, int y) {
		    super.startDrag(x, y);
		    mainviewCache = (Lob)theLob.get();
		}

		public void changedRelative(float dx, float dy) {
		    float nx = panX.getFloat() - dx/zoom.getFloat();
		    float ny = panY.getFloat() - dy/zoom.getFloat();
		    float nz = zoom.getFloat();

		    panX.setFloat(nx);
		    panY.setFloat(ny);

		    pzl.setParams(nx, ny, nz);
		    mainviewCache = (Lob)theLob.get();
		    winAnim.rerender();
		}
	    }); 
	*/

	/*
	l = new DepthChangeLob(l, -10);
	*/
	l = addBackground(l, cc.getCanvas(), true);
	/*
	l = new DepthChangeLob(l, 10);
	*/

	l = SpatialContextLob.newInstance(l);
	l = Lobs.margin(l, 40);

	return l;
    }

    public Lob getBuoyLob(Object node) {
	Lob l = Lobs.nullLob();
	l = BuoyConnectorLob.newInstance(l, node);
	l = SpatialContextLob.newInstance(l);
	return l;
	/*
	if(buoyCache.get(node) != null) return (Lob)buoyCache.get(node);

	Object canvas = graph.find1_X11(CANVAS2D.contains, node);
	Lob canvasContent = (Lob)canvasCache.get(canvas);
	if(canvasContent == null) {
	    canvasContent = getCanvasContent(canvas, null);
	    canvasCache.put(canvas, canvasContent);
	}

	Lob ct = getContentLob(node);
	Model x = getModel(node, CANVAS2D.x), y = getModel(node, CANVAS2D.y);
	x = x.plus(ct.getNatSize(Lob.X) / 2);
	y = y.plus(ct.getNatSize(Lob.Y) / 2);
	
	Lob l = new PanZoomLob(canvasContent, x, y, new FloatModel(1));
	l = addBackground(l, canvas, false);
	l = new SpatialContextLob(l, (Model)l.getTemplateParameter("cs"));
	
	buoyCache.put(node, l);
	return l;
	*/
    }

    protected Lob getContentLob(Object node) {
	return contentViewSettings.getLob(node);
    }


    /**
     *  'cursor' may be null.
     */
    protected Lob getCanvasContent(final Object canvas, final Cursor cursor) {
	
	Lob tray = Lobs.tray(false);
	
	for(Iterator i=graph.findN_11X_Iter(canvas, CANVAS2D.contains); 
	    i.hasNext();) {
	    
	    Object n = i.next();
	    Lob label = getContentLob(n);
	    Lob l = BuoyConnectorLob.newInstance(label, n);

	    float x = RDFUtil.getFloat(graph, n, CANVAS2D.x);
	    float y = RDFUtil.getFloat(graph, n, CANVAS2D.y);

	    /*
	    if(cursor != null)
		l = new ClickController(l, 1, new AbstractAction() {
			public void run() {
			    CanvasCursor cc = getCanvasCursor(cursor);

			    float nx = x.getFloat()+label.getNatSize(Lob.X)/2;
			    float ny = y.getFloat()+label.getNatSize(Lob.Y)/2;
			    float nz = cc.getZoom();

			    CanvasCursor c = new CanvasCursor(cc.getCanvas(),
							      nx, ny, nz);

			    cursor.set(n, c);

			    VobScene sc = winAnim.getCurrentVS();
			    ConnectionVobMatcher m = 
				(ConnectionVobMatcher)sc.matcher;
			    
			    int focus = m.getFocus();
			    int context = m.getLink(focus, -1, "spatial context", "structure point");
			    m.setNextFocus(m.getLink(context, 1, n, "structure point"));
			}
		    });
	    */

	    l = Lobs.translate(l, x, y);
	    tray.add(l);
	}
	
	return Lobs.request(tray, 100, 100, 100, 100, 100, 100);
    }

    protected Lob addBackground(Lob content, Object canvas, boolean fade) {
	Color bgcolor = UniqueColors.getColor(canvas, .75f, 1f);

	Lob l = Lobs.frame(content, bgcolor, Color.black, 2, 0, true);

	/*
	if(fade) l = new AbstractMonoLob(l) { 
		public void render(VobScene scene, int into, int matchingParent,
				   float w, float h, float d,
				   boolean visible) {
		    scene.fader = new ColorFader((Color)bgcolor.get(), 0, 10);
		    super.render(scene, into, matchingParent, w, h, d, visible);
		}
		protected Object clone(Object[] params) {
		    throw new Error("not impl");
		}
	    };
	*/

	return l;
    }
}
