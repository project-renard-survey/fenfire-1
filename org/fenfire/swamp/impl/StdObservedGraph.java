// AUTOGENERATED By makeswamp.py - DO NOT EDIT.

package org.fenfire.swamp.impl;
import org.nongnu.navidoc.util.Obs;
import org.fenfire.swamp.*;
import java.util.Iterator;

public class StdObservedGraph extends StdObservedConstGraph implements Graph {
    Graph graph;

    public StdObservedGraph(Graph graph, Obs obs) {
	super(graph, obs);
	this.graph = graph;
	this.obs = obs;
    }

    public Graph getObservedGraph(Obs obs) {
	throw new Error("DoubleObs");
    }

    public void set1_11X(Object subject, Object predicate, Object object) {
	graph.set1_11X(subject, predicate, object);
    }

    public void rm_111(Object subj, Object pred, Object obj) {
    graph.rm_111(subj, pred, obj);
}
public void rm_11A(Object subj, Object pred) {
    graph.rm_11A(subj, pred);
}
public void rm_1A1(Object subj, Object obj) {
    graph.rm_1A1(subj, obj);
}
public void rm_1AA(Object subj) {
    graph.rm_1AA(subj);
}
public void rm_A11(Object pred, Object obj) {
    graph.rm_A11(pred, obj);
}
public void rm_A1A(Object pred) {
    graph.rm_A1A(pred);
}
public void rm_AA1(Object obj) {
    graph.rm_AA1(obj);
}
public void rm_AAA() {
    graph.rm_AAA();
}


    public void add(Object subject, Object predicate, Object object) {
	graph.add(subject, predicate, object);
    }

    public void addAll(Graph g) {
	graph.addAll(g);
    }
}
