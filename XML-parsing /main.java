
package xmlprojectt;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Xmlprojectt {
static String extraction(String xmlcontent){
    StringBuilder TOSTRING= new StringBuilder();
    for (int i=27; i<xmlcontent.length();i++){
        if(xmlcontent.charAt(i)=='\"'&&xmlcontent.charAt(i+1)=='*'&&xmlcontent.charAt(i+2)!='>'
                ||xmlcontent.charAt(i)=='\"'&&xmlcontent.charAt(i+1)=='/'&&xmlcontent.charAt(i+2)!='>'
                ||xmlcontent.charAt(i)=='\"'&&xmlcontent.charAt(i+1)=='+'&&xmlcontent.charAt(i+2)!='>'
                ||xmlcontent.charAt(i)=='\"'&&xmlcontent.charAt(i+1)=='-'&&xmlcontent.charAt(i+2)!='>'
                ||xmlcontent.charAt(i)=='\"'&&Character.isDigit(xmlcontent.charAt(i+1))&&xmlcontent.charAt(i+2)!='>'){
            TOSTRING.append(xmlcontent.charAt((i+1)));
        }
    }
    return TOSTRING.toString();
}
static int calc(String xmlcontent){
    StringBuilder REV_tostring= new StringBuilder(xmlcontent).reverse();
    Stack<Integer>num=new Stack<>();
    Stack<Character>opp=new Stack<>();
    for(char c :REV_tostring.toString().toCharArray()){
        if (c=='+'|| c=='-'||c=='*'||c=='/'){
            opp.push(c);
        }
        else{
            num.push(Character.getNumericValue(c));
        }
        if(num.size()>=2&&!opp.isEmpty()){
            int num1=num.pop();
            int num2=num.pop();
            switch(opp.pop()){
                case'+':
                    num.push(num1+num2);
                    break;
                    case'-':
                    num.push(num1-num2);
                    break;
                    case'*':
                    num.push(num1*num2);
                    break;
                    case'/':
                    num.push(num1/num2);
                    break;
            }
        }
    }
    int result=num.pop();
    return result;
}
static String infix(String xmlcontent){
    Stack<String>operands=new Stack<>();
    for (int i =xmlcontent.length()-1;i>=0;i--){
        char c = xmlcontent.charAt(i);
        if(isOperator(c)){
            String operand1=operands.pop();
            String operand2=operands.pop();
            String expression="("+operand1+c+operand2+")";
            operands.push(expression);
        }
        else{
            operands.push(Character.toString(c));
        }
    }
    return operands.pop();
}
static boolean isOperator(char c){
    return c=='*'||c=='/'||c=='+'||c=='-';
    
}
 
    
    public static void main(String[] args) {
        String filePath="C:\\Users\\Dell\\OneDrive\\Desktop\\expression.xml.txt";
     try{
         String filecontent=Files.readString(Paths.get(filePath));
         String xmlcontent=extraction(filecontent);
         int result=calc(xmlcontent);
         String infix=infix(xmlcontent);
         System.out.println("answer: "+result);
         System.out.println("infix: "+infix);
     }
     catch(IOException e){
         e.printStackTrace();
     }
    }
    
}
    
    

