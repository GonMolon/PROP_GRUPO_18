package common.domain;

import common.persistence.PersistenceController;
import org.jblas.DoubleMatrix;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws GraphException {

        Graph g = new Graph();
        PersistenceController pc = new PersistenceController();

        Author test = new Author("pepe");

        g.addNode(test);

        SimpleSearch search = new SimpleSearch(g, NodeType.AUTHOR, "pep");
        ArrayList<Node> result = search.getResult();
        for(int i = 0; i < result.size(); ++i) {
            System.out.println(result.get(i).getValue());
        }

        DoubleMatrix m = new DoubleMatrix(10, 10);

        pc.importNodes(g, "data/author.txt", NodeType.AUTHOR);
        pc.importNodes(g, "data/conf.txt", NodeType.CONFERENCE);
        pc.importNodes(g, "data/paper.txt", NodeType.PAPER);
        pc.importNodes(g, "data/term.txt", NodeType.TERM);
        //pc.importEdges(g, "data/author_label.txt", "Author", "Label");
        //TODO implementar relation nula en medio de relationStructure cuando es impar
        //TODO método públio en grafo para acceder a getIdFromValue de container
        //TODO Subclases de Relation para las relaciones predeterminadas
        //TODO metodos en relationStructure para facilitar busqueda
        //TODO removeRelation by name throws exception
    }

}
