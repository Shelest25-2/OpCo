public class Main {
    public static void main(String[] args) {
        TypeSafeCache<String, Integer> grades = new TypeSafeCache<>("Оценки");
        TypeSafeCache<String, Integer> noGrades = new TypeSafeCache<>("Нет оценок");

        grades.put("Иван", 5);
        grades.put("Пётр", 4);
        grades.put("Мария", 3);

        System.out.println(grades.getOrCreate("Иван", k -> 0));    // 5
        System.out.println(grades.getOrCreate("Анна", k -> 0));    // 0

        TypeSafeCache<String, Integer> excellent = grades.filter(g -> g >= 4);
        System.out.println(excellent);  // {Иван=5, Пётр=4}

        System.out.println(grades.getOrElse("Нет такого", -1));   // -1
        System.out.println(noGrades.getOrElse("Нет такого", -1));   // -1

        TypeSafeCache<Integer, String> products = new TypeSafeCache<>("Продукты");
        System.out.println(products.getOrCreate(1, id -> "Продукт #" + id));
        System.out.println(products.getOrCreate(2, id -> "Продукт #" + id));
        System.out.println(products.getOrCreate(3, id -> "Продукт #" + id));
        System.out.println(products);
    }
}