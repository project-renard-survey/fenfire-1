// AUTOGENERATED By makeswamp.py - DO NOT EDIT.

package org.fenfire.swamp.impl;
import org.nongnu.navidoc.util.Obs;
import org.fenfire.swamp.*;
import java.util.Iterator;

public abstract class GraphToQuadsGraph extends AbstractGraph {
    protected QuadsGraph graph;

    public GraphToQuadsGraph(QuadsGraph graph) {
	this.graph = graph;
    }

    public static class Simple extends GraphToQuadsGraph {
        protected Object quad;
        public Simple(QuadsGraph graph, Object quad) {
            super(graph);
            this.quad = quad;
        }
        protected Object getQuad() { return quad; }
    }
    
    abstract protected Object getQuad();
    
    public synchronized Obs getObserver() { return graph.getObserver(); }
    public synchronized boolean contains(Object e0, Object e1, Object e2) {
        return graph.contains(e0,e1,e2, getQuad()); }
    public synchronized boolean contains(Object e0, Object e1, Object e2, Obs o) {
        return graph.contains(e0,e1,e2, getQuad(), o); }
    public synchronized void set1_11X(Object subject, Object predicate, Object object) {
        graph.set1_11XA(subject, predicate, object);
        graph.add(subject, predicate, object, getQuad());
    }
    public synchronized void add(Object subject, Object predicate, Object object) {
        graph.add(subject, predicate, object, getQuad());     }
    public synchronized void rm_111(Object subject, Object predicate, Object object) {
        graph.rm_1111(subject, predicate, object, getQuad());     }

    public synchronized void addAll(Graph g) {
       for (Iterator i=g.findN_XAA_Iter(); i.hasNext();) {
           Object subj = i.next();
           for (Iterator j=g.findN_1XA_Iter(subj); j.hasNext();) {
               Object pred = j.next();
               for (Iterator k=g.findN_11X_Iter(subj,pred); k.hasNext();){
                   Object obj = k.next();
                   graph.add(subj, pred, obj, getQuad());
               }
           }
       }
    }

    public synchronized Object find1_11X(Object e0,Object e1) {
    return graph.find1_11XA(e0,e1); }

public synchronized Object find1_1X1(Object e0,Object e2) {
    return graph.find1_1X1A(e0,e2); }

public synchronized Object find1_X11(Object e1,Object e2) {
    return graph.find1_X11A(e1,e2); }

public synchronized Object find1_1XA(Object e0) {
    return graph.find1_1XAA(e0); }

public synchronized Object find1_XAA() {
    return graph.find1_XAAA(); }

public synchronized Object find1_X1A(Object e1) {
    return graph.find1_X1AA(e1); }

public synchronized Iterator findN_11X_Iter(Object e0,Object e1) {
    return graph.findN_11XA_Iter(e0,e1); }

public synchronized Iterator findN_1X1_Iter(Object e0,Object e2) {
    return graph.findN_1X1A_Iter(e0,e2); }

public synchronized Iterator findN_X11_Iter(Object e1,Object e2) {
    return graph.findN_X11A_Iter(e1,e2); }

public synchronized Iterator findN_1XA_Iter(Object e0) {
    return graph.findN_1XAA_Iter(e0); }

public synchronized Iterator findN_XAA_Iter() {
    return graph.findN_XAAA_Iter(); }

public synchronized Iterator findN_X1A_Iter(Object e1) {
    return graph.findN_X1AA_Iter(e1); }

public synchronized Object find1_11X(Object e0,Object e1,Obs o) {
    return graph.find1_11XA(e0,e1,o); }

public synchronized Object find1_1X1(Object e0,Object e2,Obs o) {
    return graph.find1_1X1A(e0,e2,o); }

public synchronized Object find1_X11(Object e1,Object e2,Obs o) {
    return graph.find1_X11A(e1,e2,o); }

public synchronized Object find1_1XA(Object e0,Obs o) {
    return graph.find1_1XAA(e0,o); }

public synchronized Object find1_XAA(Obs o) {
    return graph.find1_XAAA(o); }

public synchronized Object find1_X1A(Object e1,Obs o) {
    return graph.find1_X1AA(e1,o); }

public synchronized Iterator findN_11X_Iter(Object e0,Object e1,Obs o) {
    return graph.findN_11XA_Iter(e0,e1,o); }

public synchronized Iterator findN_1X1_Iter(Object e0,Object e2,Obs o) {
    return graph.findN_1X1A_Iter(e0,e2,o); }

public synchronized Iterator findN_X11_Iter(Object e1,Object e2,Obs o) {
    return graph.findN_X11A_Iter(e1,e2,o); }

public synchronized Iterator findN_1XA_Iter(Object e0,Obs o) {
    return graph.findN_1XAA_Iter(e0,o); }

public synchronized Iterator findN_XAA_Iter(Obs o) {
    return graph.findN_XAAA_Iter(o); }

public synchronized Iterator findN_X1A_Iter(Object e1,Obs o) {
    return graph.findN_X1AA_Iter(e1,o); }


}

