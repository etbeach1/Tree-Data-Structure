public class Person implements Comparable<Person>
{
	//Creates a private string and variable for name, height, and weight
	private String name;    // the person's name, e.g. "Mario"
	private double height;  // height in centimeters (metric)
	private double weight;  // weight in kilograms (metric)

	//Creates a constructor that runs with NewPerson
	
	public Person(String name, double height, double weight)
	{
		//"this.name" assigns the attribute belonging to this object
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	//Builds a brand new Person with the same data as an existing one
	public Person(Person other)
	{
		this.name = other.name;
		this.height = other.height;
		this.weight = other.weight;
	}

	//Creates the getter for name, height, and weight
	public String getName()
	{
		return name;
	}

	public double getHeight()
	{
		return height;
	} 

	public double getWeight()
	{
		return weight;
	}

	//Creates the setter to change the name, height, and weight of the person, void
	//to prevent returning anything
	public void setHeight(double height)
	{
		this.height = height;
	}

	public void setWeight(double weight)
	{
		this.weight = weight;
	}

	//"toString" returns the Person as a String
	//Oerrides to check that it correctly replaces Object.equals()
	@Override
	public String toString()
	{
		return String.format("%s\t%.1f\t%.1f", name, height, weight);
	}

	//Replaces Object's equals() so Persons with matching field values count as equal
	@Override
	public boolean equals(Object o)
	{
		//If o is null (nothing), it can't be equal to us
		if (o == null)
		{
			return false;
		}

		//If o is literally this same object, it's obviously equal
		if (o == this)
		{
			return true;
		}

		//If o isn't a Person at all (e.g. a String), it can't be equal
		if (!(o instanceof Person))
		{
			return false;
		}

		//Cast so it treats o as a Person, so it can be accessed
		Person p = (Person) o;

		//Equal only if name, height, and weight all match
		
		if (this.name.equals(p.name)
				&& this.height == p.height
				&& this.weight == p.weight)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	//compareTo: required by the Comparable interface. Returns a negative
	//number if this Person comes before p, positive if after, 0 if same.
	//Sorts alphabetically by name. Ties are broken by height, then weight,
	//so that compareTo returns 0 only when equals() would return true.
	@Override
	public int compareTo(Person p)
	{
		int result = this.name.compareTo(p.name);
		if (result != 0)
		{
			return result;
		}

		result = Double.compare(this.height, p.height);
		if (result != 0)
		{
			return result;
		}

		return Double.compare(this.weight, p.weight);
	}
}
