import java.util.ArrayList;

/*
 * A self-sorting binary search tree set of Person objects, ordered by name.
 * Duplicate names are ignored. Each SortedTreeSet object is one node
 */
public class SortedTreeSet implements SortedTreeSetInterface
{
	private Person person;
	private SortedTreeSet left;
	private SortedTreeSet right;
	private SortedTreeSet parent; 

	public SortedTreeSet()
	{
		person = null;
		left = null;
		right = null;
		parent = null;
	}

	public Person getPerson()
	{
		return person;
	}

	public boolean hasLeft()
	{
		return left != null;
	}

	public void setLeft(SortedTreeSet left)
	{
		this.left = left;
		if (left != null)
			left.parent = this;
	}

	public SortedTreeSet getLeft()
	{
		return left;
	}

	public boolean hasRight()
	{
		return right != null;
	}

	public void setRight(SortedTreeSet right)
	{
		this.right = right;
		if (right != null)
			right.parent = this;
	}

	public SortedTreeSet getRight()
	{
		return right;
	}

	public SortedTreeSet getParent()
	{
		return parent;
	}

	//Inserts p in sorted order by name; does nothing if the name already exists
	public void add(Person p)
	{
		if (p == null)
			return;

		if (person == null) // empty tree / empty node
		{
			person = p;
			return;
		}

		int cmp = p.getName().compareTo(person.getName());
		if (cmp == 0)
			return; // duplicate name, ignore

		if (cmp < 0)
		{
			if (left == null)
			{
				SortedTreeSet node = new SortedTreeSet();
				node.person = p;
				setLeft(node); // also sets parent
			}
			else
				left.add(p);
		}
		else
		{
			if (right == null)
			{
				SortedTreeSet node = new SortedTreeSet();
				node.person = p;
				setRight(node);
			}
			else
				right.add(p);
		}
	}

	public int size()
	{
		if (person == null)
			return 0;
		int count = 1;
		if (left != null)
			count += left.size();
		if (right != null)
			count += right.size();
		return count;
	}

	//In-order traversal: left, this, right (gives sorted order)
	private void inOrder(ArrayList<Person> list)
	{
		if (person == null)
			return;
		if (left != null)
			left.inOrder(list);
		list.add(person);
		if (right != null)
			right.inOrder(list);
	}

	//In-order (sorted) listing, one person per line.
	public String toString()
	{
		ArrayList<Person> list = new ArrayList<Person>();
		inOrder(list);
		StringBuilder sb = new StringBuilder();
		for (Person p : list)
			sb.append(p).append("\n");
		return sb.toString();
	}
}
