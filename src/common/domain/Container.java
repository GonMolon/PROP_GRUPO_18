package common.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Container<T extends  Element> {
	//Attributes
    private int lastID;
    private HashMap<Integer, T> elements;

    //Constructors
    protected Container() {
        elements = new HashMap<Integer, T>();
        lastID = 1;
    }

    //Set & Get
    protected int getSize() {
        return elements.size();
    }

    protected int getLastID() {
        return lastID;
    }
    protected ContainerIterator getIterator() {
        return new ContainerIterator(this);
    }

    //Queries
    protected void addElement(T element) {
        element.setId(lastID);
        elements.put(lastID++, element);
    }

    protected void addElement(T element, int ID) throws GraphException {
        if (!checkNewID(ID)) {
        	throw new GraphException(GraphExceptionError.ID_INVALID);
        } else if (elements.containsKey(ID)) {
        	throw new GraphException(GraphExceptionError.ID_USED);
        } else {
            lastID = ID;
            addElement(element);
        }
    }

    protected void removeElement(int ID) throws GraphException {
        if (!checkID(ID)) {
        	throw new GraphException(GraphExceptionError.ID_INVALID);
        } else if (elements.containsKey(ID)) {
            elements.remove(ID);
        } else {
        	throw new GraphException(GraphExceptionError.ID_NONEXISTENT);
        }
    }

    protected T getElement(int ID) throws GraphException {
        if (!checkID(ID)) {
        	throw new GraphException(GraphExceptionError.ID_INVALID);
        } else if (elements.containsKey(ID)) {
            return elements.get(ID);
        } else {
        	throw new GraphException(GraphExceptionError.ID_NONEXISTENT);
        }
    }

    protected ArrayList<Integer> getIdFromValue(String value) {
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ContainerIterator iterator = getIterator();
        while(iterator.hasNext()) {
            Element aux = iterator.next().getValue();
            if(aux.getValue() != null && aux.getValue().equalsIgnoreCase(value)) {
                ids.add(aux.getId());
            }
        }
        return ids;
    }

    private boolean checkID(int ID) {
    	return ID > 0 && ID < lastID;
    }
    
    private boolean checkNewID(int ID) {
    	return ID >= lastID;
    }

    public class ContainerIterator implements Iterator<Map.Entry<Integer, T>> {

        private Iterator<Map.Entry<Integer, T>> iterator;

        private ContainerIterator(Container<T> container) {
            iterator = container.elements.entrySet().iterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Map.Entry<Integer, T> next() {
            return iterator.next();
        }
    }

}
 