import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class TypeSafeCache <K,V>{
    private final Map<K,V> cache = new HashMap<>();
    private final String name;

    public TypeSafeCache(String name){
        this.name=name;
    }

    public void put(K key, V value){
        cache.put(key,value);
    }

    public Optional<V> get(K key){
        return Optional.ofNullable(cache.get(key));
    }

    /*
    grades.getOrCreate("Анна", k -> 0);
                                  ^
                                  | эта лямбда — callback
    */
    public V getOrCreate(K key, Function<K,V> factory){
        V value=cache.get(key);
        if(value==null) {
            value = factory.apply(key);
            cache.put(key, value);
        }
        return value;
    }

    public TypeSafeCache<K,V> filter(Predicate<V> condition){
        TypeSafeCache<K,V> filteredCache = new TypeSafeCache<>(this.name);

        this.cache.forEach(
                ((key, value) -> {
                    if(condition.test(value)){
                        filteredCache.put(key,value);
                    }
                })
        );
        return filteredCache;
    }

    public String getOrElse(String s, int dec){
        if(cache.isEmpty()) {
            // System.out.println(s);
            return Integer.toString(dec);
        }
        return cache.toString();

    }

    @Override
    public String toString() {
        return "TypeSafeCache{" +
                "cache=" + cache +
                ", name='" + name + '\'' +
                '}';
    }
}
