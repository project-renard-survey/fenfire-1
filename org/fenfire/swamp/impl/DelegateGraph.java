// AUTOGENERATED By makeswamp2.py - DO NOT EDIT.

package org.fenfire.swamp.impl;
import org.nongnu.navidoc.util.Obs;
import org.fenfire.swamp.*;
import java.util.Iterator;

public abstract class DelegateGraph extends AbstractGraph {
    Graph graph;

    public DelegateGraph(Graph graph) {
	this.graph = graph;
    }
    
    public synchronized void close() { graph.close(); }
    public synchronized Obs getObserver() { return graph.getObserver(); }
    public synchronized ConstGraph getOriginalConstGraph() {
        return graph.getOriginalConstGraph();    }
    public synchronized ConstGraph getObservedConstGraph(Obs o) {
        return graph.getObservedConstGraph(o);    }
    public synchronized boolean contains(Object e0, Object e1, Object e2) {
        return graph.contains(e0,e1,e2); }
    public synchronized boolean contains(Object e0, Object e1, Object e2, Obs o) {
        return graph.contains(e0,e1,e2, o); }
    public synchronized Graph getObservedGraph(org.nongnu.navidoc.util.Obs o) {
        return graph.getObservedGraph(o); }
    public synchronized void set1_11X(Object subject, Object predicate, Object object) {
        graph.set1_11X(subject, predicate, object);   }
    public synchronized void add(Object subject, Object predicate, Object object) {
        graph.add(subject, predicate, object);     }
    public synchronized void addAll(Graph g) {
        graph.addAll(g);     }
    public synchronized void rm_111(Object subject, Object predicate, Object object) {
        graph.rm_111(subject, predicate, object);     }


    public Object find1_11X(Object subj, Object pred, Obs obs) {
    return find1_11X(subj, pred, obs);
}
public Iterator findN_11X_Iter(Object subj, Object pred, Obs obs) {
    return findN_11X_Iter(subj, pred, obs);
}
public Object find1_1X1(Object subj, Object obj, Obs obs) {
    return find1_1X1(subj, obj, obs);
}
public Iterator findN_1X1_Iter(Object subj, Object obj, Obs obs) {
    return findN_1X1_Iter(subj, obj, obs);
}
public Object find1_X11(Object pred, Object obj, Obs obs) {
    return find1_X11(pred, obj, obs);
}
public Iterator findN_X11_Iter(Object pred, Object obj, Obs obs) {
    return findN_X11_Iter(pred, obj, obs);
}
public Object find1_1XA(Object subj, Obs obs) {
    return find1_1XA(subj, obs);
}
public Iterator findN_1XA_Iter(Object subj, Obs obs) {
    return findN_1XA_Iter(subj, obs);
}
public Object find1_XAA(Obs obs) {
    return find1_XAA(obs);
}
public Iterator findN_XAA_Iter(Obs obs) {
    return findN_XAA_Iter(obs);
}
public Object find1_X1A(Object pred, Obs obs) {
    return find1_X1A(pred, obs);
}
public Iterator findN_X1A_Iter(Object pred, Obs obs) {
    return findN_X1A_Iter(pred, obs);
}

}
