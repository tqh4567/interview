package com.huawei;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main1 {
    public static int count(int[] nums) {
        // 先将英文字母收集起来
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0;i < nums.length;i++) {
            for(int j = i+1;j < nums.length;j++){
                if(isSimpleNumber(nums[i]+nums[j])){
                    set.add(nums[i]);
                    set.add(nums[j]);
                }
            }
        }
        return set.size()/2;
    }
    private static boolean isSimpleNumber(int n) {
        for (int i = 2;i <= n/2;i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

//    public static void main(String[] args) {
////        int[] nums = {2,5,6,13};
////        System.out.println("count(nums) = " + count(nums));
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            int n  = in.nextInt();
//            int[] nums = new int[n];
//            for(int i = 0;i < n;i++){
//                nums[i] = in.nextInt();
//            }
//            System.out.println(count(nums));
//        }
//    }


//    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String str = sc.next();
////            String str1 = "abcdefg";
////            String str = "abaaab";
//            System.out.println(longestPalindrome(str));
//        }
//    }
public static void main(String[] args) {
    System.out.println("longest(\"12abba\") = " + longestPalindrome("dsuehgfqxzrnkmtmiwytshrerjfybxirufrsobkjeghiunftxyqqcyoreevvktxgvjjqzvcujsynsrlgllebyukyxgugrvkesovfhzdznstvtbblmjcngwsdrmfczsihiblqhkfvhzylwopepfmnixeesvugyifdxvpcknpqunolpgjehoxgylnzoggqpbdkhrngchidhfdktblrifjvppttemmplzrsbjhltvwprhkigkvfkxcxfsgyiyuuziqurgcmddqshenindtrfzlrqpfpekfosmugpwjgydtbwexcwrvdedposftffjrfeojsqpxtoguroojsgrwpyiyhurprcfsgnnykjtrjjzdswfqfwuohpcssgjzyikruvomeggqzyslmfurgnmhyvnksktvdcidvutrrxzixbxiypbvozgnmopfjiljggqrronwkfqvlpdwhtzfpsokfbvftyxdinknsrjlxbzyfmsinegprbnuezqlikgsbbixfdjtsjxojqwxdrvwfflrwjsnpcxqvfpmbidyvvlcnvvvvbglhhmkpuzhosfitgzclicpzsvozsbtvtlmjffqieosliqysgyxmceytmezfbtkcprfomftlkyortyfmykslfdmxzfeetmzxbuvoorpwmkerujcjcuuyvmpqidrrksrtmxhqoqdyvjgvcftbhywmbdfoixecfgorpxoxbqlhbnynwflbodsdqvwwoizdfyczefvonoczocvtbixehcvpmimyxgzddvomklofuthtytqougojqwmxvhzpmvtfsjwrgmxuoeizmnfptssolqbmnrhfjitoqxizflyoddgjlxknumclfmpmrzpomrqqogvmwgclpquhuqbkriyjkwcusetkyxozomcrsuyfmsddwubkiyyjoeqlzjsfnwkhdpgxkeicbivlwbdvcbvdqbyxuwdolmtxzgpogtzctlcjemoxdrbrmmtkuuidtiebckmqluiszgichpmgbsxdiurxdgkvvufyihcjejgwwepswxmjducltnxngtylgiqcvxldeebykysdgwokcupxmjnbiqlzovnocuesodotqivceqhimuhtromxxullejgzhzevzvtdhbfhcwbdivgslkfmudzofbmeeqixuprbsyrelcgvvkbtkgckezrrisnnkwwchcfwlqdoucccqinjplgwlqcylqojstlvdjmcjyqjsqwrvxjmujcuzirinocnnwszxjnyszncytltbusmcsxustpxeuxgmwlixnjnigsxnollfbpqrwohbshbohhnpsvenvgreqfwqypkkibenvgjcwmumwcgehehiyediindvppefciihjkcnzvelorusllpbexivekbflpyqpefpjlumctorwejnefenhrlfugnkywvwuvrdrxsxjksgowxholmpjfyjcksmhwpcpjcodwzmolzgkcjxmiqxdpewlyjilcbbwyxmxhqvsxkepiwdvmfxdceiswscupzpmhvmyciyosxuwnmjxnkdhhnquxsmekmcwgcklxzhhqxkebqcvxpsqzuoxikverbskrwvewomemysgcmrdnzgufysnoxuerrqcufevwwumrvbowvvkjuediygphwgwgdrpbgreytkmgcmzonbyxwkolywjcigvyqqhwsjmtkvvhbtuhctcigvfnkkffvsjrjiumlowlwvsbuopmsfcqrxlpprtmswlkdmkoxewhtfkzzoohdbutqccmzsscjdozeeecdqmugcrqqfjingovwfmvnltdfcmrofcftnoozquguyyzdxqqgwbdpotbquhokorykpurvwbvcwdnmzgimuzjipikdtvhstsgeykmunxvbszjmbgwhiymumfmlhennthtjwspxvqrelkhwqxjrzbkqbobfetlejvdhzpmwreqfhnupgovixdemmngzorgfooiruhjbjmvwgmzrvjgrwouxugmysbrdtdujjeffomribgqkhjohitgonqevcweedmleexqjgtywpwbwmoltxbdkiyvgrykhbesgckhvecyvcjryqbhstwrcloqmoivrmkkimzwbywumxfrzyterxmwpqcullcvebkflwmbbexqifohjrrgsnbsqhlxkwkuhwocmjfrhyfkqpqlbvxokbvbufqffclzlnlszcimzucrsrohldxeohdiktubdrvkzvgvhnrkeenmhcvujlxlpcyhohumnuxmswwfwyhuyqhurvcrvmnkgsyygunrvpbvdmpetuixhwtnswhmgtuunzybkyosezpzttrzcdukbtmxxeschlkjgqgrnhvixqbcusimvwdceedhhbbbrxefvztdcfdtzglhmzfthlmc"));
}
    public static int longest(String s){
        StringBuilder builder = new StringBuilder(s);
        String s2 = builder.reverse().toString();
        int i = 0,j = 0;
        int leng = 0;
        while (j < s.length() ){
            if ( s.charAt(i) == s2.charAt(j)){
                i++;
                j++;
                leng++;
            }else {
                j++;
            }
        }
        i = 0;j = 0;
        int len = 0;
        while (i < s.length() ){
            if ( s.charAt(i) == s2.charAt(j)){
                i++;
                j++;
                len++;
            }else {
                i++;
            }
        }
        return Math.max(leng,len);
    }
    public static int longestPalindrome(String s) {
        if(s.length() < 2) return 1;
        int begin = 0,n = s.length();
        int max = 1;
        boolean[][] flag = new boolean[n][n];
        for(int i = 0;i<n;i++){
            flag[i][i] = true;
        }
        for(int j = 1 ;j < n;j++){
            for(int i = 0;i<j;i++){
                if (s.charAt(i) != s.charAt(j)) {
                    flag[i][j] = false;
                }else{
                    if(j - i < 3){
                        flag[i][j] = true;
                    }else{
                        flag[i][j] = flag[i+1][j-1];
                    }
                }
                if (flag[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    begin = i;
                }
            }
        }
        return max;
    }
}


