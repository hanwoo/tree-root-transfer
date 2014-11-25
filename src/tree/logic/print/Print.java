package tree.logic.print;


public interface Print<T> {

	public abstract void header();
	public abstract void footer();
	public abstract void display(T obj);
}
