package common;

import common.domain.Graph;
import common.domain.GraphException;
import common.domain.NodeType;
import common.domain.Relation;
import common.persistence.PersistenceController;


public class Main {

    public static void main(String[] args) throws GraphException {

        System.out.println("Starts initialization...");
        Graph g = new Graph();

        PersistenceController pc = new PersistenceController(g);
        pc.importGraph("out/");

        Relation AP = new Relation(NodeType.PAPER, NodeType.AUTHOR, "AP");
        g.addRelation(AP);

       /* Author a1 = (Author) g.createNode(NodeType.AUTHOR, "a1");
        Author a2 = (Author) g.createNode(NodeType.AUTHOR, "a2");
        Author a3 = (Author) g.createNode(NodeType.AUTHOR, "a3");

        Paper p1 = (Paper) g.createNode(NodeType.PAPER, "p1");
        Paper p2 = (Paper) g.createNode(NodeType.PAPER, "p2");
        Paper p3 = (Paper) g.createNode(NodeType.PAPER, "p3");
        Paper p4 = (Paper) g.createNode(NodeType.PAPER, "p4");

        g.addNode(a1);
        g.removeNode(NodeType.AUTHOR, a1.getId());
        g.addNode(a2);
        g.addNode(a3);
        g.addNode(p1);
        g.addNode(p2);
        g.addNode(p3);
        g.addNode(p4);

        g.addEdge(AP.getId(), a1, p1);
        g.addEdge(AP.getId(), a1, p2);
        g.addEdge(AP.getId(), a2, p2);
        g.addEdge(AP.getId(), a2, p3);
        g.addEdge(AP.getId(), a2, p4);
        g.addEdge(AP.getId(), a3, p4);

        System.out.println("Starts search...");

        try {
            ArrayList<Relation> aux = new ArrayList<Relation>();
            aux.add(g.getRelation(0));
            aux.add(g.getRelation(0));
            //aux.add(AP);
            //aux.add(AP);
            RelationStructure rs = new RelationStructure(NodeType.AUTHOR, aux, NodeType.AUTHOR);
            GraphSearch s = new FreeSearch(g, rs);
            s.search();
            ArrayList<GraphSearch.Result> results = s.getResults();
            for(int i = 0; i < results.size(); ++i) {
                results.get(i).print();
            }
        } catch (RelationStructureException e) {
            e.printStackTrace();
        }
        */

        System.out.println("Exporting graph...");
        pc.exportGraph("out/");

    }
}
