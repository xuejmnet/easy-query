package com.easy.query.core.func;

import com.easy.query.core.expression.lambda.SQLExpression1;
import com.easy.query.core.expression.parser.core.SQLTableOwner;
import com.easy.query.core.func.column.ColumnExpression;
import com.easy.query.core.func.column.ColumnFuncSelector;
import com.easy.query.core.func.column.ColumnFuncSelectorImpl;
import com.easy.query.core.func.def.impl.BankSQLFunction;
import com.easy.query.core.func.def.impl.EmptySQLFunction;
import com.easy.query.core.func.def.impl.NotBankSQLFunction;
import com.easy.query.core.func.def.impl.NotEmptySQLFunction;
import com.easy.query.core.util.EasyArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * create time 2023/12/21 12:00
 * 文件说明
 *
 * @author xuejiaming
 */
public interface SQLStringFunc {

    /**
     * 连接函数将多个列合并在一起
     *
     * @param property1 属性列1
     * @param property2 属性列2
     * @param properties 其他属性列
     * @return 链接函数
     */
    default SQLFunction concat(String property1, String property2, String... properties) {
        return concat(s -> {
            s.column(property1)
                    .column(property2);
            if (EasyArrayUtil.isNotEmpty(properties)) {
                for (String property : properties) {
                    s.column(property);
                }
            }
        });
    }

    /**
     * 链接函数表达式 将多个列合并在一起
     *
     * @param sqlExpression 指定多个属性列
     * @return 链接函数
     */
    default SQLFunction concat(SQLExpression1<ColumnFuncSelector> sqlExpression) {
        List<ColumnExpression> concatExpressions = new ArrayList<>();
        sqlExpression.apply(new ColumnFuncSelectorImpl(concatExpressions));
        return concat(concatExpressions);
    }

    /**
     * 链接函数 将多个列合并在一起
     *
     * @param concatExpressions 链接列或者常量等表达式
     * @return 链接函数
     */
    SQLFunction concat(List<ColumnExpression> concatExpressions);

    default SQLFunction bank(String property){
        return new BankSQLFunction(property);
    }
    default SQLFunction notBank(String property){
        return new NotBankSQLFunction(property);
    }

    default SQLFunction empty(String property){
        return new EmptySQLFunction(property);
    }
    default SQLFunction notEmpty(String property){
        return new NotEmptySQLFunction(property);
    }

    /**
     * 小写
     * @param property 属性列
     * @return 小写函数
     */
    default SQLFunction toLower(String property){
        return toLower(s->{
            s.column(property);
        });
    }
    /**
     * 小写
     * @param sqlFunction sql函数
     * @return 小写函数
     */
    default SQLFunction toLower(SQLFunction sqlFunction){
        return toLower(s->{
            s.sqlFunc(sqlFunction);
        });
    }

    /**
     * 小写
     * @param sqlExpression 属性选择函数
     * @return 小写函数
     */
    SQLFunction toLower(SQLExpression1<ColumnFuncSelector> sqlExpression);

    /**
     * 大写
     * @param property 属性列
     * @return 大写函数
     */
    default SQLFunction toUpper(String property){
        return toUpper(s->{
            s.column(property);
        });
    }
    /**
     * 大写
     * @param sqlFunction sql函数
     * @return 大写函数
     */
    default SQLFunction toUpper(SQLFunction sqlFunction){
        return toUpper(s->{
            s.sqlFunc(sqlFunction);
        });
    }

    /**
     * 大写
     * @param sqlExpression 属性选择函数
     * @return 大写函数
     */
    SQLFunction toUpper(SQLExpression1<ColumnFuncSelector> sqlExpression);


    /**
     * 截取字符串
     * @param property 属性列
     * @return 截取字符串函数
     */
    default SQLFunction subString(String property,int begin,int length){
        return subString(s->{
            s.column(property);
            s.format(begin+1);
            s.format(length);
        });
    }
    /**
     * 截取字符串
     * @param sqlFunction sql函数
     * @return 截取字符串函数
     */
    default SQLFunction subString(SQLFunction sqlFunction,int begin,int length){
        return subString(s->{
            s.sqlFunc(sqlFunction);
            s.format(begin+1);
            s.format(length);
        });
    }

    /**
     * 截取字符串
     * @param sqlExpression 属性选择函数
     * @return 截取字符串函数
     */
    SQLFunction subString(SQLExpression1<ColumnFuncSelector> sqlExpression);
    /**
     * 截取字符串
     * @param property 属性列
     * @return 截取字符串函数
     */
    default SQLFunction trim(String property){
        return trim(s->{
            s.column(property);
        });
    }
    /**
     * 截取字符串
     * @param sqlFunction sql函数
     * @return 截取字符串函数
     */
    default SQLFunction trim(SQLFunction sqlFunction){
        return trim(s->{
            s.sqlFunc(sqlFunction);
        });
    }

    /**
     * 截取字符串
     * @param sqlExpression 属性选择函数
     * @return 截取字符串函数
     */
    SQLFunction trim(SQLExpression1<ColumnFuncSelector> sqlExpression);


    /**
     * 截取字符串
     * @param property 属性列
     * @return 截取字符串函数
     */
    default SQLFunction trimStart(String property){
        return trimStart(s->{
            s.column(property);
        });
    }
    /**
     * 截取字符串
     * @param sqlFunction sql函数
     * @return 截取字符串函数
     */
    default SQLFunction trimStart(SQLFunction sqlFunction){
        return trimStart(s->{
            s.sqlFunc(sqlFunction);
        });
    }

    /**
     * 截取字符串
     * @param sqlExpression 属性选择函数
     * @return 截取字符串函数
     */
    SQLFunction trimStart(SQLExpression1<ColumnFuncSelector> sqlExpression);

    /**
     * 截取字符串
     * @param property 属性列
     * @return 截取字符串函数
     */
    default SQLFunction trimEnd(String property){
        return trimEnd(s->{
            s.column(property);
        });
    }
    /**
     * 截取字符串
     * @param sqlFunction sql函数
     * @return 截取字符串函数
     */
    default SQLFunction trimEnd(SQLFunction sqlFunction){
        return trimEnd(s->{
            s.sqlFunc(sqlFunction);
        });
    }

    /**
     * 截取字符串
     * @param sqlExpression 属性选择函数
     * @return 截取字符串函数
     */
    SQLFunction trimEnd(SQLExpression1<ColumnFuncSelector> sqlExpression);

    /**
     * 替换字符串
     * @param property 属性列
     * @param oldValue 要被替换的字符
     * @param newValue 替换为的字符
     * @return 替换字符串函数
     */
    default SQLFunction replace(String property,String oldValue,String newValue){
        return replace(s->{
            s.column(property);
            s.value(oldValue);
            s.value(newValue);
        });
    }
    /**
     * 替换字符串
     * @param sqlFunction sql函数
     * @param oldValue 要被替换的字符
     * @param newValue 替换为的字符
     * @return 替换字符串函数
     */
    default SQLFunction replace(SQLFunction sqlFunction,String oldValue,String newValue){
        return replace(s->{
            s.sqlFunc(sqlFunction);
            s.value(oldValue);
            s.value(newValue);
        });
    }

    /**
     * 替换字符串
     * @param sqlExpression 属性选择函数
     * @return 替换字符串函数
     */
    SQLFunction replace(SQLExpression1<ColumnFuncSelector> sqlExpression);

    /**
     * 替换字符串
     * @param property 属性列
     * @param comparedValue 被比较的值
     * @return 替换字符串函数
     */
    default SQLFunction compareTo(String property,String comparedValue){
        return compareTo(s->{
            s.column(property);
            s.value(comparedValue);
        });
    }
    default SQLFunction compareTo(String property, SQLTableOwner tableOwner,String otherProperty){
        return compareTo(s->{
            s.column(property);
            s.column(tableOwner,otherProperty);
        });
    }
    default SQLFunction compareTo(String property, SQLFunction sqlFunction){
        return compareTo(s->{
            s.column(property);
            s.sqlFunc(sqlFunction);
        });
    }
    /**
     * 比较字符串函数
     * @param sqlFunction sql函数
     * @param comparedValue 被比较的值
     * @return 比较字符串函数
     */
    default SQLFunction compareTo(SQLFunction sqlFunction,String comparedValue){
        return compareTo(s->{
            s.sqlFunc(sqlFunction);
            s.value(comparedValue);
        });
    }
    default SQLFunction compareTo(SQLFunction sqlFunction, SQLTableOwner tableOwner,String otherProperty){
        return compareTo(s->{
            s.sqlFunc(sqlFunction);
            s.column(tableOwner,otherProperty);
        });
    }
    default SQLFunction compareTo(SQLFunction sqlFunction, SQLFunction comparedSQLFunction){
        return compareTo(s->{
            s.sqlFunc(sqlFunction);
            s.sqlFunc(comparedSQLFunction);
        });
    }

    /**
     * 替换字符串
     * @param sqlExpression 属性选择函数
     * @return 替换字符串函数
     */
    SQLFunction compareTo(SQLExpression1<ColumnFuncSelector> sqlExpression);


    /**
     * 字符串补全 左侧补齐totalWidth位数用空格补齐
     * @param property 属性列
     * @param totalWidth 补多少位
     * @return 字符串补全函数
     */
    default SQLFunction leftPad(String property, int totalWidth){
        return leftPad(s->{
            s.column(property);
            s.format(totalWidth);
        });
    }

    /**
     * 字符串补全 左侧补齐totalWidth位数用paddingChar补齐
     * @param property 属性列
     * @param totalWidth 补多少位
     * @param paddingChar 用哪个字符补
     * @return 字符串补全函数
     */
    default SQLFunction leftPad(String property, int totalWidth, char paddingChar){
        return leftPad(s->{
            s.column(property);
            s.format(totalWidth);
            s.value(String.valueOf(paddingChar));
        });
    }
    /**
     * 字符串补全 左侧补齐totalWidth位数用空格补齐
     * @param sqlFunction 要补齐的值
     * @param totalWidth 补多少位
     * @return 字符串补全函数
     */
    default SQLFunction leftPad(SQLFunction sqlFunction, int totalWidth){
        return leftPad(s->{
            s.sqlFunc(sqlFunction);
            s.format(totalWidth);
        });
    }

    /**
     * 字符串补全 左侧补齐totalWidth位数用paddingChar补齐
     * @param sqlFunction 要补齐的值
     * @param totalWidth 补多少位
     * @param paddingChar 用哪个字符补
     * @return 字符串补全函数
     */
    default SQLFunction leftPad(SQLFunction sqlFunction, int totalWidth, char paddingChar){
        return leftPad(s->{
            s.sqlFunc(sqlFunction);
            s.format(totalWidth);
            s.value(String.valueOf(paddingChar));
        });
    }

    /**
     * 字符串补齐
     * @param sqlExpression 属性选择函数
     * @return 字符串补齐函数
     */
    SQLFunction leftPad(SQLExpression1<ColumnFuncSelector> sqlExpression);




    /**
     * 字符串补全 右侧补齐totalWidth位数用空格补齐
     * @param property 属性列
     * @param totalWidth 补多少位
     * @return 字符串补全函数
     */
    default SQLFunction rightPad(String property, int totalWidth){
        return rightPad(s->{
            s.column(property);
            s.format(totalWidth);
        });
    }

    /**
     * 字符串补全 右侧补齐totalWidth位数用paddingChar补齐
     * @param property 属性列
     * @param totalWidth 补多少位
     * @param paddingChar 用哪个字符补
     * @return 字符串补全函数
     */
    default SQLFunction rightPad(String property, int totalWidth, char paddingChar){
        return rightPad(s->{
            s.column(property);
            s.format(totalWidth);
            s.value(String.valueOf(paddingChar));
        });
    }
    /**
     * 字符串补全 右侧补齐totalWidth位数用空格补齐
     * @param sqlFunction 要补齐的值
     * @param totalWidth 补多少位
     * @return 字符串补全函数
     */
    default SQLFunction rightPad(SQLFunction sqlFunction, int totalWidth){
        return rightPad(s->{
            s.sqlFunc(sqlFunction);
            s.format(totalWidth);
        });
    }

    /**
     * 字符串补全 右侧补齐totalWidth位数用paddingChar补齐
     * @param sqlFunction 要补齐的值
     * @param totalWidth 补多少位
     * @param paddingChar 用哪个字符补
     * @return 字符串补全函数
     */
    default SQLFunction rightPad(SQLFunction sqlFunction, int totalWidth, char paddingChar){
        return rightPad(s->{
            s.sqlFunc(sqlFunction);
            s.format(totalWidth);
            s.value(String.valueOf(paddingChar));
        });
    }

    /**
     * 字符串补齐
     * @param sqlExpression 属性选择函数
     * @return 字符串补齐函数
     */
    SQLFunction rightPad(SQLExpression1<ColumnFuncSelector> sqlExpression);
}
