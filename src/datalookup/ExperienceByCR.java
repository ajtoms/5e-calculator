package datalookup;

import java.util.HashMap;

/**
 *
 * @author Andrew J Toms II
 */
public class ExperienceByCR {

    private static final HashMap<String, Integer> map;

    static {
        map = new HashMap<>();
        map.put(CRList.CR1_8th, 25);
        map.put(CRList.CR1_4th, 50);
        map.put(CRList.CR1_2th, 100);
        map.put(CRList.CR1, 200);
        map.put(CRList.CR2, 450);
        map.put(CRList.CR3, 700);
        map.put(CRList.CR4, 1100);
        map.put(CRList.CR5, 1800);
        map.put(CRList.CR6, 2300);
        map.put(CRList.CR7, 2900);
        map.put(CRList.CR8, 3900);
        map.put(CRList.CR9, 5000);
        map.put(CRList.CR10, 5900);
        map.put(CRList.CR11, 7200);
        map.put(CRList.CR12, 8400);
        map.put(CRList.CR13, 10000);
        map.put(CRList.CR14, 11500);
        map.put(CRList.CR15, 13000);
        map.put(CRList.CR16, 15000);
        map.put(CRList.CR17, 18000);
        map.put(CRList.CR18, 20000);
        map.put(CRList.CR19, 22000);
        map.put(CRList.CR20, 25000);
        map.put(CRList.CR21, 33000);
        map.put(CRList.CR22, 41000);
        map.put(CRList.CR23, 50000);
        map.put(CRList.CR24, 62000);
        map.put(CRList.CR25, 75000);
        map.put(CRList.CR26, 90000);
        map.put(CRList.CR27, 105000);
        map.put(CRList.CR28, 120000);
        map.put(CRList.CR29, 135000);
        map.put(CRList.CR30, 155000);
    }
    
    public static int forCR(String cr)
    {
        Integer result = map.get(cr);
        if(result == null){
            throw new IllegalArgumentException("CR " + cr + " does not exist.");
        }
        return map.get(cr);
    }
}
