//package HashSet_code;
//
//import javax.swing.tree.TreeNode;
//import java.util.HashMap;
//import java.util.HashSet;
//
//@SuppressWarnings({"all"})
//
//public class HashSetDeBug_ {
//    public static void main(String[] args) {
//        HashSet hashSet = new HashSet();
//        hashSet.add("java");
//        hashSet.add("php");
//        hashSet.add("java");
//    }
//}
//public class code  {
//    //添加方法
//
//    public boolean add(E e){
//        return map.put(e, PRESENT)==null;
//    }
//    public V put(K key, V value) {
//        return putVal(hash(key), key, value, false, true);
//    }


//    //hash值的算法
//    static final int hash(Object key) {
//        int h;
//        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
//    }



//    //add方法底层
//    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
//                   boolean evict) {
//        HashMap.Node<K,V>[] tab; HashMap.Node<K,V> p; int n, i;//辅助变量

//        //先判断table表是否是空的
//        if ((tab = table) == null || (n = tab.length) == 0)
//            n = (tab = resize()/*table扩容方法*/).length;

//        //判断table表中的某个（根据船传入的数据的Hash值算出来的）节点是否为null
//        //如果为null，就将我们要添加的值以链表的形式加到table表的这个位置
//        if ((p = tab[i = (n - 1) & hash]) == null)//p是指向根据hash值算出来的table表的节点的指针
//            tab[i] = newNode(hash, key, value, null);

//        else {//如果不为空，则需要判断即将要加入的值是否和之前已经加入的值相同
//            HashMap.Node<K,V> e; K k;//辅助变量。e的指向默认为空

//            //如果要加入的数据有表中的数据一样的，
//            if (p.hash == hash &&
//                    ((k = p.key) == key || (key != null && key.equals(k))))
//                e = p;//也将e指向p所指向的位置
//            else if (p instanceof TreeNode)
//                e = ((HashMap.TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
//            else {//上述条件不满足，就让表的节点中的链表一个节点一个节点的循环，检查有没有相同的元素
//                for (int binCount = 0; ; ++binCount) {
//                    if ((e = p.next) == null) {//如果该节点为空直接new一个链表节点将这个节点挂载到后面
//                        p.next = newNode(hash, key, value, null);
//                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
//                            treeifyBin(tab, hash);
//                        break;
//                    }
//                    //如果不是空的就循环判断这个链表的每一个节点的是否与要加入的元素相同，只要发现邮有相同的元素
//                    //进入if，直接跳出循环
//                    if (e.hash == hash &&
//                            ((k = e.key) == key || (key != null && key.equals(k))))
//                        break;
//                    p = e;
//                }
//            }
//            if (e != null) { // existing mapping for key
//                V oldValue = e.value;
//                if (!onlyIfAbsent || oldValue == null)
//                    e.value = value;
//                afterNodeAccess(e);
//                return oldValue;
//            }
//        }
//        ++modCount;
//        if (++size > threshold)
//            resize();
//        afterNodeInsertion(evict);
//        return null;
//    }
//
//    /**
//     * table表扩容
//     * @return
//     */
//    final HashMap.Node<K,V>[] resize() {
//        HashMap.Node<K,V>[] oldTab = table;//首次扩容table是空的
//        int oldCap = (oldTab == null) ? 0 : oldTab.length;
//        int oldThr = threshold;//这个属性为0
//        int newCap, newThr = 0;//定义两个属性，newThr是将来table扩容的临界值，也就是表真正的大小乘以0.75的值
//        if (oldCap > 0) {//首次建立表，oldCap大小是零，不进入
//            if (oldCap >= MAXIMUM_CAPACITY) {
//                threshold = Integer.MAX_VALUE;
//                return oldTab;
//            }
//            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
//                    oldCap >= DEFAULT_INITIAL_CAPACITY)
//                newThr = oldThr << 1; // double threshold
//        }
//        //不进入
//        else if (oldThr > 0) // initial capacity was placed in threshold
//            newCap = oldThr;
//        else {               // zero initial threshold signifies using defaults
//            newCap = DEFAULT_INITIAL_CAPACITY;//新的值大小默认为16
//            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY/*（临界因子大小是0.75）*/);//临界值大小，为新表的大小乘以0.75
//        }
//        if (newThr == 0) {
//            float ft = (float)newCap * loadFactor;
//            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
//                    (int)ft : Integer.MAX_VALUE);
//        }
//        threshold = newThr;//临界值首次扩容大小是12，赋值给threshold变量
//        @SuppressWarnings({"rawtypes","unchecked"})
//        HashMap.Node<K,V>[] newTab = (HashMap.Node<K,V>[])new HashMap.Node[newCap];//创建新的table表
//        // 大小是16（首次）；
//        table = newTab;//将创建的newTab赋给table
//        if (oldTab != null) {
//            for (int j = 0; j < oldCap; ++j) {
//                HashMap.Node<K,V> e;
//                if ((e = oldTab[j]) != null) {
//                    oldTab[j] = null;
//                    if (e.next == null)
//                        newTab[e.hash & (newCap - 1)] = e;
//                    else if (e instanceof HashMap.TreeNode)
//                        ((HashMap.TreeNode<K,V>)e).split(this, newTab, j, oldCap);
//                    else { // preserve order
//                        HashMap.Node<K,V> loHead = null, loTail = null;
//                        HashMap.Node<K,V> hiHead = null, hiTail = null;
//                        HashMap.Node<K,V> next;
//                        do {
//                            next = e.next;
//                            if ((e.hash & oldCap) == 0) {
//                                if (loTail == null)
//                                    loHead = e;
//                                else
//                                    loTail.next = e;
//                                loTail = e;
//                            }
//                            else {
//                                if (hiTail == null)
//                                    hiHead = e;
//                                else
//                                    hiTail.next = e;
//                                hiTail = e;
//                            }
//                        } while ((e = next) != null);
//                        if (loTail != null) {
//                            loTail.next = null;
//                            newTab[j] = loHead;
//                        }
//                        if (hiTail != null) {
//                            hiTail.next = null;
//                            newTab[j + oldCap] = hiHead;
//                        }
//                    }
//                }
//            }
//        }
//        return newTab;//返回创建的新的table表
//    }
//}
