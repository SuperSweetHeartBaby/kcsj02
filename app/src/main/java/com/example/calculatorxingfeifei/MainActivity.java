package com.example.calculatorxingfeifei;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt0,btjia,btjian,btdian,btcheng,btchu,btdengyu,btC,btback,btleft,btright;
    private EditText et_all;
    private boolean flag = true;//控制数字
    private int point = 0;//控制小数点

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btC = (Button) findViewById(R.id.btC);
        btback = (Button) findViewById(R.id.btback);
        btleft = (Button) findViewById(R.id.btleft);
        btright = (Button) findViewById(R.id.btright);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        bt5 = (Button) findViewById(R.id.bt5);
        bt6 = (Button) findViewById(R.id.bt6);
        bt7 = (Button) findViewById(R.id.bt7);
        bt8 = (Button) findViewById(R.id.bt8);
        bt9 = (Button) findViewById(R.id.bt9);
        bt0 = (Button) findViewById(R.id.bt0);
        btjia = (Button) findViewById(R.id.btjia);
        btjian = (Button) findViewById(R.id.btjian);
        btdian = (Button) findViewById(R.id.btdian);
        btcheng = (Button) findViewById(R.id.btcheng);
        btchu = (Button) findViewById(R.id.btchu);
        btdengyu = (Button) findViewById(R.id.btdengyu);
        et_all = (EditText) findViewById(R.id.et_all);

        btC.setOnClickListener(this);
        btback.setOnClickListener(this);
        btleft.setOnClickListener(this);
        btright.setOnClickListener(this);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
        bt0.setOnClickListener(this);

        btjia.setOnClickListener(this);
        btjian.setOnClickListener(this);
        btcheng.setOnClickListener(this);
        btchu.setOnClickListener(this);
        btdian.setOnClickListener(this);
        btdengyu.setOnClickListener(this);

        et_all.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        String str1 = et_all.getText().toString().replace("×","*");
        String str2 = str1.replace("÷","/");

        switch (view.getId()){
            case R.id.bt1:
                if (!flag){
                    et_all.setText("");
                }
                et_all.append("1");
                flag = true;
                break;
            case R.id.bt2:
                if (!flag){
                    et_all.setText("");
                }
                et_all.append("2");
                flag = true;
                break;
            case R.id.bt3:
                if (!flag){
                    et_all.setText("");
                }
                et_all.append("3");
                flag = true;
                break;
            case R.id.bt4:
                if (!flag){
                    et_all.setText("");
                }
                et_all.append("4");
                flag = true;
                break;
            case R.id.bt5:
                if (!flag){
                    et_all.setText("");
                }
                et_all.append("5");
                flag = true;
                break;
            case R.id.bt6:
                if (!flag){
                    et_all.setText("");
                }
                et_all.append("6");
                flag = true;
                break;
            case R.id.bt7:
                if (!flag){
                    et_all.setText("");
                }
                et_all.append("7");
                flag = true;
                break;
            case R.id.bt8:
                if (!flag){
                    et_all.setText("");
                }
                et_all.append("8");
                flag = true;
                break;
            case R.id.bt9:
                if (!flag){
                    et_all.setText("");
                }
                et_all.append("9");
                flag = true;
                break;
            case R.id.bt0:
                if (!flag){
                    et_all.setText("");
                }
                et_all.append("0");
                flag = true;
                break;
            case R.id.btjia:
                try{
                    if (str2.length() == 0){
                        try{
                            et_all.setText("");
                            break;
                        }catch(Exception e){
                        }
                    }else if (str2.charAt(str2.length()-1)==')'||str2.charAt(str2.length()-1)=='('){
                        et_all.append("+");
                        break;
                    }
                    else if (isSymbol(str2.charAt(str2.length()-1))){
                        try{
                            String str = et_all.getText().toString();
                            str = str.substring(0,str.length()-1);
                            et_all.setText(str+'+');
                            point = 0;
                            break;
                        }catch(Exception e){
                        }
                    }
                    et_all.append("+");
                    flag = true;
                    point = 0;
                    break;
                }catch (Exception e){

                }
            case R.id.btjian:
                try{
                    if (str2.length() == 0){
                        try{
                            et_all.setText("");
                            break;
                        }catch(Exception e){
                        }
                    }else if (str2.charAt(str2.length()-1)==')'||str2.charAt(str2.length()-1)=='('){
                        et_all.append("-");
                        break;
                    }
                    else if (isSymbol(str2.charAt(str2.length()-1))){
                        try{
                            String str = et_all.getText().toString();
                            str = str.substring(0,str.length()-1);
                            et_all.setText(str+'-');
                            break;
                        }catch(Exception e){
                        }
                    }
                    et_all.append("-");
                    point = 0;
                    flag = true;
                    break;
                }catch (Exception e){

                }
            case R.id.btcheng:
                try{
                    if (str2.length() == 0){
                        try{
                            et_all.setText("");
                            break;
                        }catch(Exception e){
                        }
                    }else if (str2.charAt(str2.length()-1)==')'||str2.charAt(str2.length()-1)=='('){
                        et_all.append("×");
                        break;
                    }
                    else if (isSymbol(str2.charAt(str2.length()-1))){
                        try{
                            String str = et_all.getText().toString();
                            str = str.substring(0,str.length()-1);
                            et_all.setText(str+'×');
                            break;
                        }catch(Exception e){
                        }
                    }
                    et_all.append("×");
                    point = 0;
                    flag = true;
                    break;
                }catch (Exception e){

                }
            case R.id.btchu:
                try{
                    if (str2.length() == 0){
                        try{
                            et_all.setText("");
                            break;
                        }catch(Exception e){
                        }
                    }else if (str2.charAt(str2.length()-1)==')'||str2.charAt(str2.length()-1)=='('){
                        et_all.append("÷");
                        break;
                    }
                    else if (isSymbol(str2.charAt(str2.length()-1))){
                        try{
                            String str = et_all.getText().toString();
                            str = str.substring(0,str.length()-1);
                            et_all.setText(str+'÷');
                            break;
                        }catch(Exception e){
                        }
                    }
                    et_all.append("÷");
                    point = 0;
                    flag = true;
                    break;
                }catch (Exception e){

                }
            case R.id.btdian:
                if (str2.length() == 0){
                    try{
                        et_all.append(".");
                        break;
                    }catch(Exception e){
                    }
                }else if(point == 1||str2.charAt(str2.length()-1)==')'||str2.charAt(str2.length()-1)=='('){
                    et_all.append("");
                    break;
                 }
                else if (str2.charAt(str2.length()-1) == '.'){
                    try{
                        String str = et_all.getText().toString();
                        str = str.substring(0,str.length()-1);
                        et_all.setText(str+'.');
                        break;
                    }catch(Exception e){
                    }
                }else {
                    et_all.append(".");
                    point = 1;
                    flag = true;
                }
                break;
            case R.id.btleft:
                if (!flag){
                    et_all.setText("");
                }
                et_all.append("(");
                flag = true;
                break;
            case R.id.btright:
                et_all.append(")");
                flag = true;
                break;
            case R.id.btdengyu:
               try{
                   char[] chars = str2.toCharArray();
                   //char[] chars = "2+3*(7-4)+8/4".toCharArray();
                   // 获得后缀表达式
                   List<String> suffixList = nifToSuf(chars);
                   //System.out.println(suffixList);
                   // 计算后缀表达式
                   BigDecimal res = calcSuffixExpression(suffixList);
                   //System.out.println(res.setScale(2, RoundingMode.HALF_UP));
                   et_all.setText(res.setScale(2, RoundingMode.HALF_UP).toString());
                   flag = false;
                   point = 0;
                   break;
               }catch (Exception e){
               }
/*
                    if (all.indexOf("+") != -1){
                        String a[] = all.split("\\+");
                        double shu1 = Double.valueOf(a[0]);
                        double shu2 = Double.valueOf(a[1]);
                        System.out.print(a[0]);
                        System.out.print(a[1]);
                        double alljia = shu1 + shu2;
                        et_all.setText(alljia + "");
                    }
                    if (all.indexOf("-") != -1){
                        String a[] = all.split("\\-");
                        double shu1 = Double.valueOf(a[0]);
                        double shu2 = Double.valueOf(a[1]);
                        System.out.print(a[0]);
                        System.out.print(a[1]);
                        double alljian = shu1 - shu2;
                        et_all.setText(alljian + "");
                    }
                    if (all.indexOf("×") != -1){
                        String a[] = all.split("\\×");
                        double shu1 = Double.valueOf(a[0]);
                        double shu2 = Double.valueOf(a[1]);
                        System.out.print(a[0]);
                        System.out.print(a[1]);
                        double allcheng = shu1 * shu2;
                        et_all.setText(allcheng + "");
                    }
                    if (all.indexOf("÷") != -1){
                            String a[] = all.split("\\÷");
                            double shu1 = Double.valueOf(a[0]);
                            double shu2 = Double.valueOf(a[1]);
                            System.out.print(a[0]);
                            System.out.print(a[1]);
                            double allchu = shu1 / shu2;
                            et_all.setText(allchu + "");
  */
            case R.id.btC:
                try{
                    et_all.setText("");
                    break;
                }catch(Exception e){
            }
            case R.id.btback:
               try{
                   String str = et_all.getText().toString();
                   str = str.substring(0,str.length()-1);
                   et_all.setText(str);
                   break;
               }catch(Exception e){
               }
            default:
                break;
        }

    }

    /**
     * 中缀表达式转化为后缀表达式
     *
     * @param chars 中缀表达式
     * @return 返回后缀表达式
     */
    public static List<String> nifToSuf(char[] chars) {
        List<String> exp = new ArrayList<>();
        Stack<Character> op = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < chars.length; i++) {

            // 如果是数字
            if ((i == 0 && chars[i] != '(') || (i != 0 && isDigit(chars[i], chars[i - 1]))) {
                sb.append(chars[i]);
                // 如果是最后一位 或者下一位是字符，数字添加到exp队列,sb清空
                if (i == chars.length - 1 || (i + 1 < chars.length && isSymbol(chars[i + 1]))) {

                    exp.add(sb.toString());
                    sb = new StringBuilder("");
                }
                // 如果是括号
            } else if (isBracket(chars[i])) {
                // 如果是左括号 直接入op栈
                if (chars[i] == '(') {
                    op.push(chars[i]);
                } else {
                    // 右括号
                    // 将op栈出栈 添加到exp直到遇到'(',将这一对 '(' ')' 舍去
                    char temp;
                    while ((temp = op.pop()) != '(') {
                        exp.add(temp + "");
                    }
                }
                // 如果是操作符
            } else if (isOperation(chars[i])) {
                while (true) {
                    // 空的栈直接入栈
                    if (op.isEmpty()) {
                        op.push(chars[i]);
                        break;
                        // 如果栈顶的符号优先级小于 扫描到的符号 入栈
                    } else if (getPriority(op.peek()) < getPriority(chars[i])) {
                        op.push(chars[i]);
                        break;
                        // 栈顶的符号优先级大于等于 扫描到的符号 出栈给exp,并继续扫描栈顶下一个符号
                    } else {
                        exp.add(op.pop() + "");
                    }
                }

            }
        }
        // 将剩余的符号全部入exp
        while (!op.isEmpty()) {
            exp.add(op.pop() + "");
        }

        return exp;
    }

    /**
     * 计算后缀表达式
     *
     * @param suffixExp 输入后缀表达式
     * @return @code{BigDecimal}
     */
    public static BigDecimal calcSuffixExpression(List<String> suffixExp) {
        Stack<BigDecimal> numStack = new Stack<>();
        for (String str : suffixExp) {
            // 如果是操作符
            if (str.length() == 1 && isOperation(str.charAt(0))) {
                BigDecimal num2 = numStack.pop();
                BigDecimal num1 = numStack.pop();
                numStack.push(calcValueOfTwoNum(num1, num2, str));
            } else {
                numStack.push(new BigDecimal(str));
            }
        }
        return numStack.peek();
    }

    public static BigDecimal calcValueOfTwoNum(BigDecimal num1, BigDecimal num2, String op) {
        switch (op) {
            case "+":
                return num1.add(num2);
            case "-":
                return num1.subtract(num2);
            case "*":
                return num1.multiply(num2);
            case "/":
                if (num2.signum() == 0) {
                    throw new RuntimeException("除数不能为0");
                }
                // 除法保留2位小数，四舍五入
                return num1.divide(num2, 2, RoundingMode.HALF_UP);
        }
        throw new RuntimeException("没有此操作符");
    }

    // 获取优先级
    public static int getPriority(char ch) {
        switch (ch) {
            case '(':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        throw new RuntimeException("不是加减乘除或者(");
    }

    public static boolean isSymbol(char ch) {
        return isOperation(ch) || isBracket(ch);
    }

    public static boolean isOperation(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static boolean isBracket(char ch) {
        return ch == '(' || ch == ')';
    }

    public static boolean isDigit(char ch, char leftBracket) {
        // 如果前一个是左括号 右边的数字可能带有正负号
        if (leftBracket == '(') {
            return ch == '-' || ch == '+' || (ch >= 48 && ch <= 57);
        }
        // 前一个符号不是左括号只能是数字或小数点
        return (ch >= 48 && ch <= 57) || ch == '.';

    }

}
