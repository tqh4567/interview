package com.huawei;


import java.util.HashMap;
import java.util.Map;

/**
 * 密码是我们生活中非常重要的东东，我们的那么一点不能说的秘密就全靠它了。哇哈哈. 接下来渊子要在密码之上再加一套密码，虽然简单但也安全。
 *
 *
 *
 * 假设渊子原来一个BBS上的密码为zvbo9441987,为了方便记忆，他通过一种算法把这个密码变换成YUANzhi1987，这个密码是他的名字和出生年份，怎么忘都忘不了，而且可以明目张胆地放在显眼的地方而不被别人知道真正的密码。
 *
 *
 *
 * 他是这么变换的，大家都知道手机上的字母： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0,就这么简单，渊子把密码中出现的小写字母都变成对应的数字，数字和其他的符号都不做变换，
 *
 *
 *
 * 声明：密码中没有空格，而密码中出现的大写字母则变成小写之后往后移一位，如：X，先变成小写，再往后移一位，不就是y了嘛，简单吧。记住，z往后移是a哦。
 *
 *
 * 输入描述:
 * 输入包括多个测试数据。输入是一个明文，密码长度不超过100个字符，输入直到文件结尾
 *
 * 输出描述:
 * 输出渊子真正的密文
 *
 * 示例1
 * 输入
 * 复制
 * YUANzhi1987
 * 输出
 * 复制
 * zvbo9441987
 */
public class JianDanMiMa {
    public static void main(String[] args) {
        System.out.println("getPassword(\"YUANzhi1987\") = " + getPassword("YUANzhi1987"));
    }
    public static String getPassword(String s){
        Map<Character,String> map = new HashMap<>();
        map.put('a',"2");map.put('b',"2");map.put('c',"2");
        map.put('d',"3");map.put('e',"3");map.put('f',"3");
        map.put('g',"4");map.put('h',"4");map.put('i',"4");
        map.put('j',"5");map.put('k',"5");map.put('l',"5");
        map.put('m',"6");map.put('n',"6");map.put('o',"6");
        map.put('p',"7");map.put('q',"7");map.put('r',"7");map.put('s',"7");
        map.put('t',"8");map.put('u',"8");map.put('v',"8");
        map.put('w',"9");map.put('x',"9");map.put('y',"9");map.put('z',"9");

        map.put('A',"b");map.put('B',"c");map.put('C',"d");
        map.put('D',"e");map.put('E',"f");map.put('F',"g");
        map.put('G',"h");map.put('H',"i");map.put('I',"j");
        map.put('J',"k");map.put('K',"l");map.put('L',"m");
        map.put('M',"n");map.put('N',"o");map.put('O',"p");
        map.put('P',"q");map.put('Q',"r");map.put('R',"s");map.put('S',"t");
        map.put('T',"u");map.put('U',"v");map.put('V',"w");
        map.put('W',"x");map.put('X',"y");map.put('Y',"z");map.put('Z',"a");
        StringBuilder builder = new StringBuilder();
        for (int i = 0;i < s.length();i++){
            if (map.containsKey(s.charAt(i))){
                builder.append(map.get(s.charAt(i)));
            }else {
                builder.append(s.charAt(i));
            }
        }

        return builder.toString();
    }
}
