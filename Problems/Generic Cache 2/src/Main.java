import Implementations.Cache;
import Interface.ICache;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

            ICache cache = new Cache("LRU",3);
            cache.addToCache("One","first");
            cache.addToCache("Two","second");
            cache.addToCache("Three","third");
            cache.addToCache("Four","forth");
            System.out.println(cache.getFromCache("One"));
            cache.addToCache("Five","fifth");
            System.out.println(cache.getFromCache("One"));
            System.out.println(cache.getFromCache("Two"));
    }
}