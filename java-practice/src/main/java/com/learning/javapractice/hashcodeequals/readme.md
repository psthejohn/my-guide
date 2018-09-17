java.lang.object has two very important methods
	public boolean equals(Object obj) 
	public int hashCode()

Equals method is used to compare two objects 
	types:	
		shallow comparison
			default implementation provided in object class
			checks if two references refer to same object 
			i.e x==y
			since object class has no data members defined , its called swallow comparison also.
		deep comparison
			data members of objects are also compared with eachother
			thats why called as deep comparison
		
it simply compare the object passed to it as parameter with the object on which it is invoked.
	if two objects are equal it should return true  

The general contract of hashCode is:

	During the execution of the application, if hashCode() is invoked more than once 
	on the same Object then it must consistently return the same Integer value, 
	provided no information used in equals(Object) comparison on the Object is modified. 
	
	It is not necessary that this Integer value to be remained same from one execution 
	of the application to another execution of the same application.
	
	If two Objects are equal, according to the the equals(Object) method, 
	then hashCode() method must produce the same Integer on each of the two Objects.
	
	If two Objects are unequal, according to the the equals(Object) method, 
	It is not necessary the Integer value produced by hashCode() method 
	on each of the two Objects will be distinct. 
	
	It can be same but producing the distinct Integer on each of the two Objects 
	is better for improving the performance of hashing based Collections like HashMap, 
	HashTable…etc.