# 쉽게 배우는 소프트웨어 공학 (네이버 지식백과) 

https://terms.naver.com/list.nhn?cid=58528&categoryId=58528&so=st4.asc

※ 출제영역
Chapter 01. 소프트웨어 공학 소개
Chapter 02. 소프트웨어 개발 프로세스
Chapter 05. 상위 설계
Chapter 06. 하위 설계

# 정규표현식의 개념과 기초 문법

https://soooprmx.com/archives/7718

# Examples - The Quick Coding Guide


## print log

~~~java
System.out.printf("varName : %s %b", "value1");
~~~


## Lambda

~~~java
Collections.sort(listPerson, (g1, g2) -> g1.getName().compareTo(g2.getName()));

Collections.sort(listPerson, (g1, g2) -> (g1.getAge() - g2.getAge()));

Collections.sort(listPerson, Comparator.comparing(Person::getName).reversed());
~~~


## toString on Array

* Use [ Source - Generate toString() ] menu 

~~~java
System.out.printf("sorted by Ip : %s\n", Arrays.toString(listComputer.toArray()));
~~~


## List creation
* Arrays.asList(new Object(), new Object());

~~~java 
List<Person> listPerson = Arrays.asList(new Person("A", 30), new Person("c", 27));
~~~


## Map :: merge
~~~java
List<Computer> listComputer = Arrays.asList(new Computer("127.0.0.1", "k8s master1", 4, 8),
		new Computer("192.168.1.100", "worker 1", 16, 64), new Computer("127.0.0.1", "k8s master2", 4, 8),
		new Computer("192.168.1.100", "worker 3", 32, 128), new Computer("127.0.0.1", "k8s master3", 4, 8),
		new Computer("10.64.65.14", "nexus", 2, 4), new Computer("192.168.1.100", "worker 2", 16, 64));
		
Map<String, Integer> map = new HashMap<String, Integer>();
listComputer.stream().filter(c -> c.getCore() >= 2).forEach(c -> map.merge(c.getIp(), c.getCore(), Integer::sum));
System.out.printf("map:%s\n", map.toString());
~~~


## File Reader, Writer

* Reader

~~~java
br = new BufferedReader( new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8));
~~~

* Writer

~~~java
bw = new BufferedWriter(new FileWriter(reportfileName, false));
~~~


## String Reader, Writer

* Reader
~~~java
	br = new BufferedReader(new InputStreamReader(is));
	String readLine = null;
	while((readLine = br.readLine()) != null) {
		bw.write(readLine);
	}
~~~

* Writer
~~~java
	bw = new BufferedWriter(new FileWriter("TYPELOG_3_" + pattern + ".TXT", true));
				bw.write(split[0] + "#" + split[1] + "#");
	bw.newLine();
~~~	

			
## Execute when filter-condition fulfilled

~~~java
	public static void streamIfPresent() {
		List<Contact> contacts = ContactSource.findAll();
		contacts.stream()
		.filter(c -> "Florida".equals(c.getState()))
		.findFirst()
		.ifPresent(c -> c.call());
	}
~~~
