package iterator;

/**
 * ÈÝÆ÷µÄ½Ó¿Ú
 * @author HP
 *
 */

public interface MyList {
	void add(Object e);
	Object get(int index);
	Iterator iterator();
	int getSize();
}
