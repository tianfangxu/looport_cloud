package com.yollweb.looport.utils;

public class SingleMap<K,V> {

    private Entry<K,V>[] table;
    private int MIN = 16;
    private float DILATANCY_FACTOR = 0.75f;
    public int size;

    public SingleMap() {
        table = new Entry[MIN];
    }

    public V put(K k, V v){
        int index = getIndex(k);
        Entry<K,V> entry = table[index];
        if(entry != null){
            do{
                if(entry.k.equals(k)){
                    V vOld = entry.v;
                    entry.v = v;
                    return vOld;
                }
            }while ((entry=entry.next) != null);
            table[index] = new Entry<>(k,v,table[index]);
            size++;
            return v;
        }
        table[index] = new Entry<>(k,v,null);
        size++;
        refresh();
        return v;
    }

    public V remove(K k){
        int index = getIndex(k);
        Entry<K,V> entry = table[index];
        Entry<K,V> entrySelf=null;
        if((entry) != null){
            do{
                if(entry.k.equals(k)){
                    if ((entrySelf == null)) {
                        table[index] = entry.next;
                    } else {
                        entrySelf.next = entry.next;
                    }
                    size--;
                    return entry.v;
                }
                entrySelf=entry;
            }while ((entry=entry.next) != null);
            return null;
        }
        return null;
    }

    public V get(K k){
        int index = getIndex(k);
        Entry<K,V> entry = table[index];
        if(entry != null){
            do{
                if(entry.k.equals(k)){
                    return entry.v;
                }
            }while ((entry=entry.next) != null);
            return null;
        }
        return null;
    }

    private void refresh(){
        int length = table.length;
        if(size > MIN*DILATANCY_FACTOR){
            Entry<K,V>[] tableOld = table;
            table = new Entry[MIN*2];
            for(int i = 0;i<MIN;i++){
                Entry<K,V> entry = tableOld[i];
                do {
                    if(entry != null){
                        Entry<K,V> newEntry = table[getIndex(entry.k)];
                        if(newEntry != null){
                            table[getIndex(entry.k)] = new Entry<>(entry.k,entry.v,newEntry);
                        }else{
                            table[getIndex(entry.k)] = new Entry<>(entry.k,entry.v,null);
                        }
                    }
                }while (entry!=null && (entry=entry.next) != null);
            }
            MIN = 2*MIN;
        }
    }

    private int getIndex(K k){
        int i = k.hashCode();
        return i%MIN;
    }

    private class Entry<K,V>{
        private K k;
        private V v;
        private Entry<K,V> next;
        public void setK(K k) {
            this.k = k;
        }
        public void setV(V v) {
            this.v = v;
        }
        public void setNext(Entry<K, V> next) {
            this.next = next;
        }
        public Entry() {
        }
        public Entry(K k, V v, Entry<K, V> next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }
    }
}
