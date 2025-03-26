public class MainWithTTL {
    public static void main(String[] args) throws InterruptedException {

        ICacheWithTTL<String,String> cache = new LRUCacheWithTTL<>(3);
        cache.addToCache("1", "One", 5000);
        cache.addToCache("2", "Two", 3000);
        cache.addToCache("3", "Three", 10000);

        System.out.println("Get 1: " + cache.getFromCache("1")); // Hit
        Thread.sleep(4000);
        System.out.println("Get 2 (Expired): " + cache.getFromCache("2")); // Miss
        System.out.println("Get 3: " + cache.getFromCache("3")); // Hit

        cache.addToCache("4", "Four", 5000);
        cache.addToCache("5", "Five", 5000); // Evicts oldest entry
        System.out.println("Get 1 (Evicted): " + cache.getFromCache("1")); // Miss
    }
}
