package yycg.util;

import java.util.HashSet;   
import java.util.Set;   
  
import net.sourceforge.pinyin4j.PinyinHelper;   
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;   
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;   
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;   
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;   
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;   
  
public class Pinyin4j {   
    
 /**  
  * 字符串集合转换字符串(逗号分隔)  
  * @author wyh  
  * @param stringSet  
  * @return  
  */  
 public static String makeStringByStringSet(Set<String> stringSet){   
  StringBuilder str = new StringBuilder();   
  int i=0;   
  for(String s : stringSet){   
   if(i == stringSet.size() - 1){   
    str.append(s);   
   }else{   
    str.append(s + ",");   
   }   
   i++;   
  }   
  return str.toString().toLowerCase();   
 }   
    
 /**  
  * 获取拼音集合  
  * @author wyh  
  * @param src  
  * @return Set<String>  
  */  
 public static Set<String> getPinyin(String src){   
  if(src!=null && !src.trim().equalsIgnoreCase("")){   
   char[] srcChar ;   
   srcChar=src.toCharArray();   
   //汉语拼音格式输出类   
   HanyuPinyinOutputFormat hanYuPinOutputFormat = new HanyuPinyinOutputFormat();   
  
//输出设置，大小写，音标方式等   
   hanYuPinOutputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);    
   //选项表明汉语拼音输出无音或音标记号码
   //The option indicates that hanyu pinyin is outputted without tone numbers or tone marks
   hanYuPinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);   
   //The option indicates that the output of 'ü' is "v"
   //将ü”显示为“V”
   hanYuPinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);   
      
   String[][] temp = new String[src.length()][];   
   for(int i=0;i<srcChar.length;i++){   
    char c = srcChar[i];   
    //判断是否是中文
    if(String.valueOf(c).matches("[\\u4E00-\\u9FA5]+")){   
     try{   
      //返回这个字符的拼音数组，因为存在多音字，所以会返回一个拼音数组
      temp[i] = PinyinHelper.toHanyuPinyinStringArray(srcChar[i], hanYuPinOutputFormat);   
      
      //以下是只取拼音首字母
      for(int mm =0;mm<temp[i].length;mm++){
    	  temp[i][mm] = temp[i][mm].substring(0, 1);
      }
      
     }catch(BadHanyuPinyinOutputFormatCombination e) {   
      e.printStackTrace();   
     }   
     //如果不是，那么就是其他的字符，如字母之类的
    }else{
    	temp[i] = new String[]{String.valueOf(srcChar[i])};
    }
    /*//是中文或者a-z或者A-Z转换拼音(我的需求，是保留中文或者a-z或者A-Z)
     * else if(((int)c>=65 && (int)c<=90) || ((int)c>=97 && (int)c<=122)){   
     temp[i] = new String[]{String.valueOf(srcChar[i])};   
    }else{   
     temp[i] = new String[]{""};   
    }
    */
   }   
   String[] pingyinArray = Exchange(temp);   
   Set<String> pinyinSet = new HashSet<String>();   
   for(int i=0;i<pingyinArray.length;i++){  
    pinyinSet.add(pingyinArray[i]);   
   }   
   return pinyinSet;   
  }   
  return null;   
 }   
    
 /**  
  * 递归  
  * @author wyh  
  * @param strJaggedArray  
  * @return  
  */  
    public static String[] Exchange(String[][] strJaggedArray){   
        String[][] temp = DoExchange(strJaggedArray);   
        return temp[0];          
    }   
      
    /**  
     * 排列组合
     * 递归  
     * @author wyh  
     * @param strJaggedArray  
     * @return  
     */  
    private static String[][] DoExchange(String[][] strJaggedArray){   
        int len = strJaggedArray.length;   
        if(len >= 2){         
        	//先排列组合前两个值
            int len1 = strJaggedArray[0].length;   
            int len2 = strJaggedArray[1].length;   
            int newlen = len1*len2;   
            String[] temp = new String[newlen];   
            int Index = 0;   
            for(int i=0;i<len1;i++){   
                for(int j=0;j<len2;j++){   
                    temp[Index] = strJaggedArray[0][i] + strJaggedArray[1][j];   
                    Index ++;   
                }   
            }   
            String[][] newArray = new String[len-1][];   
            for(int i=2;i<len;i++){   
                newArray[i-1] = strJaggedArray[i];                              
            }   
            //将数组的strJaggedArray[0]，strJaggedArray[1]前面两个进行排列组合成一个，然后递归下去
            //如：2*2*2，先排列2*2然后排列4*2，最后变成8，即这个数组strJaggedArray的长度变成1，就会返回
            newArray[0] = temp;   
            return DoExchange(newArray);   
        }else{   
         return strJaggedArray;      
        }   
    }   
      
 /**  
  * @param args  
  */  
 public static void main(String[] args) {   
  String str = "单田芳";   
  System.out.println(makeStringByStringSet(getPinyin(str)));   
  
}   
  
}  

