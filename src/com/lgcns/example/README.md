# Examples - The Quick Coding Guide

## Lambda

Collections.sort(listPerson, (g1, g2) -> g1.getName().compareTo(g2.getName()));

Collections.sort(listPerson, (g1, g2) -> (g1.getAge() - g2.getAge()));

Collections.sort(listPerson, Comparator.comparing(Person::getName).reversed());


## toString on Array

System.out.printf("sorted by Ip : %s\n", Arrays.toString(listComputer.toArray()));

