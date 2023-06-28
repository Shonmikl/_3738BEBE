# Java Tasks#3 Examples

### Самостоятельная - делим группу на пары. 15-20 минут

1. Дан лист строк "BigBen", "BigBob", "Big", "Ben", "Big Bob". сколько раз объект «Big» встречается в коллекции

        Arrays.asList("BigBen", "BigBob", "Big", "Ben", "Big Bob");

        решение:
        
        Example5.java (one)
        list.stream().filter("Big"::equals).count();

2. Найти самый маленький элемент: Arrays.asList("a1", "b5", "a2", "b4")

        решение
        Example5.java (two)
        list.stream().min(String::compareTo).get();

---

### Если осталось время на практику

1. Выполнить сортировку в обратном алфавитном порядке и удалить дубликаты.

        // Example5.java (three)
        прямой порядок
        List<String> list = Arrays.asList("a1", "b5", "c1", "a2", "b4", "c1", "a1");
        List<String> stringList = list.stream().sorted(String::compareTo).distinct().collect(Collectors.toList());
        System.out.println(stringList);

        // Example5.java (four)
        обратный порядок
        List<String> stringList = list.stream().sorted((o1, o2) -> -o1.compareTo(o2)).distinct().collect(Collectors.toList());
        System.out.println(stringList);

> #### LectureNote
> Можно напомнить, что возвращает compareTo метод.
