//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        ICache cache = new GenericCache();
//
//        cache.addToCache("first","one");
//        cache.addToCache("second","two");
//        cache.addToCache(10,5);
//        System.out.println(cache.getFromCache(5));

        ICache<String,String> lruCache = new LRUCache<>(2);
        lruCache.addToCache("1", "One");
        lruCache.addToCache("2", "Two");
        lruCache.addToCache("3", "Three");
        System.out.println(lruCache.getFromCache("1"));
        System.out.println(lruCache.getFromCache("2"));
        lruCache.addToCache("1", "One");
        System.out.println(lruCache.getFromCache("3"));

    }
}