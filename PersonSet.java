import java.util.ArrayList;


public class PersonSet implements PersonList
{
	//protected so PersonOrderedSet can sort it directly
	protected ArrayList<Person> people = new ArrayList<Person>();

	//Adds the Person only if an equal Person isn't already stored
	//(uses Person.equals, which compares name, height, and weight)
	@Override
	public void add(Person p)
	{
		if (!people.contains(p))
		{
			people.add(p);
		}
	}

	//Returns the Person stored at the given position
	@Override
	public Person get(int index)
	{
		return people.get(index);
	}

	//Header line for output; subclasses can override to change the units
	public String getHeader()
	{
		return "Name\tHeight (cm)\tWeight (kg)";
	}

	//Header plus one line per Person, used for both file output and the screen
	public String toFileString()
	{
		String result = getHeader() + "\n";
		for (Person p : people)
		{
			result += p.toString() + "\n";
		}
		return result;
	} 
}
