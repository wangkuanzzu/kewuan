package zzpy;

import java.util.HashMap;
import java.util.Map;

public class EasySqlDemo {

    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<>();

        String s = getSql(map);

        System.out.println(s);

    }


    public static  String getSql(Map<String, Object> ruleSql) {
        StringBuffer stringBuffer = new StringBuffer("select ");
        // 判断级别表字段
        if ("table".equals(ruleSql.get("rule_scope"))){
            //判断是否有过滤条件
            if (null !=ruleSql.get("rule_condition")&&!"".equals(ruleSql.get("rule_condition"))) {
                if (ruleSql.get("rule_fun").equals(ruleSql.get("空值率"))) {
                    stringBuffer.append("count(1)").append(" from ").append(ruleSql.get("rule_table")).append(ruleSql.get("rule_condition"));
                } else if (ruleSql.get("rule_fun").equals(ruleSql.get("表行数"))) {
                    stringBuffer.append("count(1)").append(" from ").append(ruleSql.get("rule_table")).append(ruleSql.get("rule_condition"));
                }
            }else{
                if (ruleSql.get("rule_fun").equals(ruleSql.get("空值率"))) {
                    stringBuffer.append("count(1)").append(" from ").append(ruleSql.get("rule_table"));
                } else if (ruleSql.get("rule_fun").equals(ruleSql.get("表行数"))) {
                    stringBuffer.append("count(1)").append(" from ").append(ruleSql.get("rule_table"));
                }
            }
        }else{
            if (null !=ruleSql.get("rule_condition")&&!"".equals(ruleSql.get("rule_condition"))) {
                if (ruleSql.get("rule_fun").equals("avg")) {
                    //拼接avg
                    stringBuffer.append("avg(" + ruleSql.get("rule_column") + ")").append(" from ").append(ruleSql.get("rule_table")).append(ruleSql.get("rule_condition"));
                } else if (ruleSql.get("rule_fun").equals("min")) {
                    //拼接min
                    stringBuffer.append("min(" + ruleSql.get("rule_column") + ")").append(" from ").append(ruleSql.get("rule_table")).append(ruleSql.get("rule_condition"));
                } else if (ruleSql.get("rule_fun").equals("max")) {
                    //拼接max
                    stringBuffer.append("max(" + ruleSql.get("rule_column") + ")").append(" from ").append(ruleSql.get("rule_table")).append(ruleSql.get("rule_condition"));
                } else if (ruleSql.get("rule_fun").equals("sum")) {
                    //拼接sum
                    stringBuffer.append("sum(" + ruleSql.get("rule_column") + ")").append(" from ").append(ruleSql.get("rule_table")).append(ruleSql.get("rule_condition"));
                } else if (ruleSql.get("rule_fun").equals("行数")){
                    //拼接count  不使用count（*）
                    stringBuffer.append("count(1)").append("from").append(ruleSql.get("rule_table"));
                } else if (ruleSql.get("rule_fun").equals("空值数")){
                    //空值个数   select count(1) from test_data where ="" or ='null'
                    stringBuffer.append("count(1)").append("from").append(ruleSql.get("rule_table"));
                } else if (ruleSql.get("rule_fun").equals("重复数")){
                    //select count(*) appid from  test_data GROUP BY appid
                    stringBuffer.append("count(1)").append("from").append(ruleSql.get("rule_table")).append("group by").append(ruleSql.get("rule_column"));
                } else if (ruleSql.get("rule_fun").equals("空置率")){
                    stringBuffer.append("count(1)").append("from").append(ruleSql.get("rule_table"));
                }
            }else{
                if (ruleSql.get("rule_fun").equals("avg")) {
                    stringBuffer.append("avg(" + ruleSql.get("rule_column") + ")").append(" from ").append(ruleSql.get("rule_table"));
                } else if (ruleSql.get("rule_fun").equals("min")) {
                    stringBuffer.append("min(" + ruleSql.get("rule_column") + ")").append(" from ").append(ruleSql.get("rule_table"));
                } else if (ruleSql.get("rule_fun").equals("max")) {
                    stringBuffer.append("max(" + ruleSql.get("rule_column") + ")").append(" from ").append(ruleSql.get("rule_table"));
                } else if (ruleSql.get("rule_fun").equals("sum")) {
                    stringBuffer.append("sum(" + ruleSql.get("rule_column") + ")").append(" from ").append(ruleSql.get("rule_table"));
                } else if (ruleSql.get("rule_fun").equals("行数")){
                    //拼接count   不使用count（*）
                    stringBuffer.append("count(1)").append("from").append(ruleSql.get("rule_table"));
                } else if (ruleSql.get("rule_fun").equals("空值数")){
                    //空值个数   select count(1) from test_data where ="" or ='null'
                    stringBuffer.append("count(1)").append("from").append(ruleSql.get("rule_table")).append(ruleSql.get("rule_condition"));
                } else if (ruleSql.get("rule_fun").equals("重复数")){
                    //select count(*) appid from  test_data GROUP BY appid
                    stringBuffer.append("count(1)").append("from").append(ruleSql.get("rule_table")).append("group by").append(ruleSql.get("rule_column"));
                } else if (ruleSql.get("rule_fun").equals("空置率")){
                    stringBuffer.append("count(1)").append("from").append(ruleSql.get("rule_table")).append(ruleSql.get("rule_condition"));
                }
                System.out.println(stringBuffer+"0000000000000000000000000");
            }
        }
        System.out.println(stringBuffer);
        String sql = stringBuffer.toString();
        System.out.println(sql);
        return sql;
    }
}
