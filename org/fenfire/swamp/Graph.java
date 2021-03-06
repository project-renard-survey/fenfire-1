// AUTOGENERATED By makeswamp.py - DO NOT EDIT.

package org.fenfire.swamp;
import java.util.Iterator;
import org.nongnu.navidoc.util.Obs;

/** A modifiable RDF graph. Existing iterators should not be used after
 *  the graph is modified, as it may cause unspecified behavior.
 */
public interface Graph extends ConstGraph {
    Graph getObservedGraph(org.nongnu.navidoc.util.Obs o);

    void startUpdate();
    void endUpdate();

    void set1_11X(Object subject, Object predicate, Object object);
    void add(Object subject, Object predicate, Object object);
    void addAll(Graph g);

    void rm_111(Object subj, Object pred, Object obj);
void rm_11A(Object subj, Object pred);
void rm_1A1(Object subj, Object obj);
void rm_1AA(Object subj);
void rm_A11(Object pred, Object obj);
void rm_A1A(Object pred);
void rm_AA1(Object obj);
void rm_AAA();

}
