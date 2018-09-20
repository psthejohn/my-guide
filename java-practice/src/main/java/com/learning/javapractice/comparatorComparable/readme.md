Java provides two interfaces to sort objects using data members of the class:
	Comparable
	Comparator

Comparable interface
	A comparable object is able to compare itself with other objects
	for this a class needs to implement comparable interface
	it provides compareTo() method implementation to sort objects
	we are sorting the movies on the basis of their release date , 
	but what if we want to sort the movies on the basis of their rating and name also?
	
	for this purpose only we need the comparator

Comparator:
	it is external to the object we are comparing , its a seperate class
	we create multiple seperate classes (implementing comparator) to compare by diff members.
	collection class has a second sort method and it takes comparator
	and it provides us two methods , one is 
	compare() and other is equals()
	
	to compare by rating we need to do 
		create a class that implements comparator
		make an instance of comparator class
		call the overloaded sort method
	