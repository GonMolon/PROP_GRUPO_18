package common.persistence;


import common.domain.Node;
import common.domain.Term;

public class TermSerializer extends NodeSerializer {

    public TermSerializer(Node node) {
        super(node);
    }

    public TermSerializer(String data) { super(data); }

    @Override
    public Term getNode() {
        this.inflate();
        node = new Term(nodeId,name);
        return ((Term)node);
    }
}