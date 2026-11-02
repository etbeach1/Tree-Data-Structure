
public interface SortedTreeSetInterface //Binary Tree
{
	public Person getPerson();

	public boolean hasLeft();
	public void setLeft(SortedTreeSet left);
	public SortedTreeSet getLeft();

	public boolean hasRight();
	public void setRight(SortedTreeSet right);
	public SortedTreeSet getRight();

	public void add(Person p);
	
}