/*
PotionAction.java
 *    
 *    Copyright (c) 2005, Benja Fallenstein
 *    
 *    This file is part of Fenfire.
 *    
 *    Fenfire is free software; you can redistribute it and/or modify it under
 *    the terms of the GNU Lesser General Public License as published by
 *    the Free Software Foundation; either version 2 of the License, or
 *    (at your option) any later version.
 *    
 *    Fenfire is distributed in the hope that it will be useful, but WITHOUT
 *    ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 *    or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General
 *    Public License for more details.
 *    
 *    You should have received a copy of the GNU Lesser General
 *    Public License along with Fenfire; if not, write to the Free
 *    Software Foundation, Inc., 59 Temple Place, Suite 330, Boston,
 *    MA  02111-1307  USA
 *    
 *    
 */
/*
 * Written by Benja Fallenstein
 */
package org.fenfire.potion;
import org.fenfire.Cursor;
import org.fenfire.swamp.*;
import org.nongnu.libvob.fn.*;
import org.nongnu.libvob.lob.*;
import javolution.realtime.*;
import java.util.*;

public class PotionAction extends RealtimeObject implements Action {

    protected Graph graph;
    protected Cursor cursor;
    protected Graph prefsGraph;

    protected List commandStack;

    protected Expression expression;

    public PotionAction(Expression expression,
			Graph graph, Cursor cursor, Graph prefsGraph,
			List commandStack) {
	this.expression = expression;

	this.graph = graph;
	this.cursor = cursor;
	this.prefsGraph = prefsGraph;
	this.commandStack = commandStack;
    } 

    public void run() {

	Map context = new HashMap();
	context.put("graph", graph);
	context.put("cursor", cursor);
	context.put("prefsGraph", prefsGraph);

	Expression expr = expression.instantiatePattern(context);

	CommandExpression c;

	if(expr instanceof CommandExpression) {
	    c = (CommandExpression)expr;
	} else {
	    if(commandStack.isEmpty()) return;
	    c = (CommandExpression)commandStack.remove(0);
	    c = (CommandExpression)c.setNextParam((FunctionExpression)expr);
	}

	if(c.isComplete()) {
	    c.execute(context);

	    System.out.println("performed: "+c);
	} else {
	    commandStack.add(0, c);
	    System.out.println("set current command to: "+c);
	}

	org.nongnu.libvob.AbstractUpdateManager.chg(); // XXX
    }
}
