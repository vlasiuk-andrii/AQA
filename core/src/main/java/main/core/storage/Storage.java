package main.core.storage;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Storage {

    private ThreadLocal<Boolean> userLoggedIn = new ThreadLocal<>();

    public Boolean isUserLoggedIn() {
        return userLoggedIn.get();
    }

    public void setUserLoggedIn(Boolean value) {
        userLoggedIn.set(value);
    }



        public static String LAST_ASSERTION = "LAST_ASSERTION";

    private static Storage instance;
    private Map<String, Optional<?>> memory = new HashMap<>();
    private Logger log = LoggerFactory.getLogger(getClass());

    private Storage () {
        userLoggedIn.set(false);
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public void storeValue(String key, Object value) {
        log.trace("Put into memory: key '{}', value '{}'", key, value);
        memory.put(key, Optional.ofNullable(value));
    }

    public void removeValue(String key) {
        memory.remove(key);
    }

    public void clearStorage(){
        memory.clear();
    }

    public <T> void storeList(String key, List<T> list){
        if(getStoredList(key) == null){
            storeValue(key, list);
        }else{
            List<T> storedList = getStoredList(key);
            storedList.addAll(list);
            storeValue(key, storedList);
        }
    }

    public <T> List<T> getStoredList(final String key){
        List<T> result = null;
        if (containsKey(key)) {
            result = (List<T>) memory.get(key).orElse(null);
        }
        return result;
    }

    public <T> void storeSet(String key, Set<T> set){
        if(getStoredSet(key) == null){
            storeValue(key, set);
        }else{
            Set<T> storedSet = getStoredSet(key);
            storedSet.addAll(set);
            storeValue(key, storedSet);
        }
    }

    public <T> Set<T> getStoredSet(final String key){
        Set<T> result = null;
        if (containsKey(key)) {
            result = (Set<T>) memory.get(key).orElse(null);
        }
        return result;
    }

    public String getStoredValue(String key) {
        String result = "";
        if (containsKey(key)) {
            result = memory.get(key).map(value -> value.toString()).orElse("");
        }
        return result;
    }

    public Object getStoredObject(String key) {
        Object result = null;
        if (containsKey(key)) {
            result = memory.get(key).orElseThrow(() -> new StorageException("Avoid getting null from Storage"));
        }
        return result;
    }

    public <T> T getStoredObject(String key, Class<T> tClass) {
        T result = null;
        if (containsKey(key)) {
            result =  memory.get(key).map(tClass::cast).orElseThrow(() -> new StorageException("Avoid getting null from Storage"));
        }
        return result;
    }

    public void clearStoredValue(String key) {
        log.trace("Remove from memory: key '{}'", key);
        memory.put(key, Optional.empty());
    }

    private boolean containsKey(String key) {
        if (!memory.containsKey(key)) {
            log.trace("Key '{}' is not used in Storage", key);
        }
        return memory.containsKey(key);
    }
}