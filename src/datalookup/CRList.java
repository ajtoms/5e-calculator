package datalookup;

/**
 *
 * @author Andrew J Toms II
 */
public class CRList {
    
    public static final int MIN_CR_INDEX = 0;
    public static final int MAX_CR_INDEX = 32;
    
    public static final String CR1_8th = "1/8";
    public static final String CR1_4th = "1/4";
    public static final String CR1_2th = "1/2";
    public static final String CR1 = "1";
    public static final String CR2 = "2";
    public static final String CR3 = "3";
    public static final String CR4 = "4";
    public static final String CR5 = "5";
    public static final String CR6 = "6";
    public static final String CR7 = "7";
    public static final String CR8 = "8";
    public static final String CR9 = "9";
    public static final String CR10 = "10";
    public static final String CR11 = "11";
    public static final String CR12 = "12";
    public static final String CR13 = "13";
    public static final String CR14 = "14";
    public static final String CR15 = "15";
    public static final String CR16 = "16";
    public static final String CR17 = "17";
    public static final String CR18 = "18";
    public static final String CR19 = "19";
    public static final String CR20 = "20";
    public static final String CR21 = "21";
    public static final String CR22 = "22";
    public static final String CR23 = "23";
    public static final String CR24 = "24";
    public static final String CR25 = "25";
    public static final String CR26 = "26";
    public static final String CR27 = "27";
    public static final String CR28 = "28";
    public static final String CR29 = "29";
    public static final String CR30 = "30";
    
    public static final String[] allCR = new String[]{CR1_8th,CR1_4th,CR1_2th,CR1,CR2,CR3,CR4,CR5,
        CR6,CR7,CR8,CR9,CR10,CR11,CR12,CR13,CR14,CR15,CR16,CR17,CR18,CR19,CR20,CR21,CR22,CR23,
        CR24,CR25,CR26,CR27,CR28,CR29,CR30};
    
    public static int indexFromString(String cr)
    {
        switch (cr)
        {
            case CR1_8th:
                return 0;
            case CR1_4th:
                return 1;
            case CR1_2th:
                return 2;
            default:
                try
                {
                    int result = Integer.parseInt(cr)+2;
                    if(result > MAX_CR_INDEX || result < MIN_CR_INDEX)
                    {
                        throw new IllegalArgumentException(cr + " is not a real CR");
                    }
                    return result;
                }
                catch (NumberFormatException ex)
                {
                    throw new IllegalArgumentException(cr + " is not a real CR");
                }
        }
    }
    
    public static String crAtIndex(int index)
    {
        if(index > MAX_CR_INDEX || index < MIN_CR_INDEX)
        {
            throw new IllegalArgumentException("No CR for index " + index);
        }
        return allCR[index];
    }

}
