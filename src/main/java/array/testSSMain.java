package array;

public class testSSMain {
    public static void main(String[] args) {
       /* String timestampField = "etl_date";
 *//*       String a1 = " >='";
        String a2 = "${start_" + timestampField + "}'";
        String a3 = " and ";
        String a4 = " < ";
        String a5 = "'${end_"+ timestampField + "}'";*//*
        StringBuilder sb = new StringBuilder();
        sb.append(timestampField);
        sb.append(" >='");
        sb.append("${start_" + timestampField + "}'");
        sb.append(" and ");
        sb.append(timestampField);
        sb.append(" < ");
        sb.append("'${end_"+ timestampField + "}'");
        System.out.println(sb.toString());
       *//* String whereParamStr = "{0} >= $"+{1} and {0} < ${2}";

        String[] valueList = {timestampField, "{start_" + timestampField + "}", "{end_" + timestampField + "}"};
        whereParamStr = MessageFormat.format(whereParamStr, valueList);
        System.out.println(whereParamStr);*/

        System.out.println(System.currentTimeMillis());
    }
}
