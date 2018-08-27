# Examples - The Quick Coding Guide

## Lambda

Collections.sort(listPerson, (g1, g2) -> g1.getName().compareTo(g2.getName()));

Collections.sort(listPerson, (g1, g2) -> (g1.getAge() - g2.getAge()));

Collections.sort(listPerson, Comparator.comparing(Person::getName).reversed());


## toString on Array

* Use [ Source - Generate toString() ] menu 

System.out.printf("sorted by Ip : %s\n", Arrays.toString(listComputer.toArray()));


## List creation
* Arrays.asList(new Object(), new Object());
 
List<Person> listPerson = Arrays.asList(new Person("A", 30), new Person("c", 27));


## File Reader, Writer

* Reader

br = new BufferedReader( new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8));

* Writer

bw = new BufferedWriter(new FileWriter(reportfileName, false));

