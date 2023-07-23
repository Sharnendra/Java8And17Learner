#Collections function in java 8.

In Java 8, the Collectors class in the java.util.stream package provides various static 
factory methods for creating collectors used in stream operations. Collectors are used to accumulate 
elements from a stream into various data structures such as lists, sets, maps, and more. Here are 
some commonly used functions of the Collectors class along with their usage and examples:

1. toList(): Collects elements into a List.
   >List<String> namesList = someStream.collect(Collectors.toList());

2. toSet(): Collects elements into a Set, removing duplicates.
   >Set<Integer> uniqueNumbers = someStream.collect(Collectors.toSet());

3. toMap(keyMapper, valueMapper): Collects elements into a Map using the provided key and value mappers.
   >Map<Integer, String> idToNameMap = someStream.collect(Collectors.toMap(Student::getId, Student::getName));

4. joining(): Concatenates elements into a single String.
   >String concatenatedNames = someStream.map(Student::getName).collect(Collectors.joining(", "));

5. groupingBy(classifier): Groups elements into a Map based on a classification function.
   >Map<String, List<Student>> studentsByDepartment = someStream.collect(Collectors.groupingBy(Student::getDepartment));

6. partitioningBy(predicate): Partitions elements into two groups based on a boolean predicate.
   >Map<Boolean, List<Student>> partitionedStudents = someStream.collect(Collectors.partitioningBy(s -> s.getAge() >= 18));

7. counting(): Returns the count of elements in the stream.
   >long count = someStream.collect(Collectors.counting());

8. summingInt(), summingLong(), summingDouble(): Returns the sum of elements as an int, long, or double.
   >int totalScore = someStream.collect(Collectors.summingInt(Student::getScore));

9. averagingInt(), averagingLong(), averagingDouble(): Returns the average of elements as an int, long, or double.
   >double averageScore = someStream.collect(Collectors.averagingDouble(Student::getScore));

10. maxBy(comparator): Returns the maximum element according to the specified comparator.
   >Optional<Student> topStudent = someStream.collect(Collectors.maxBy(Comparator.comparingInt(Student::getScore)));

11. minBy(comparator): Returns the minimum element according to the specified comparator.
   >Optional<Student> worstStudent = someStream.collect(Collectors.minBy(Comparator.comparingInt(Student::getScore)));

12.mapping(mapper, downstream): Performs a mapping operation before applying another downstream collector.
   >Map<String, List<Integer>> scoresByDepartment = someStream.collect(Collectors.groupingBy(Student::getDepartment, Collectors.mapping(Student::getScore, Collectors.toList())));

These are some of the commonly used functions provided by the Collectors class in Java 8. 
They make working with streams more convenient and powerful by allowing you to accumulate elements into various data structures and perform different types of aggregations on the elements.