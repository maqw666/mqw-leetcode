package array;

import java.text.ParseException;

public class ttt {
    public static void main(String[] args) throws ParseException {
        /*String whereParamStr = "{0} >= ${1} and {0} < ${2}";
        String t = "2";
        if("1".equals(t)){
            String[] valueList = {"id","{start_"+"id}","{end_"+"id}"};
            whereParamStr = MessageFormat.format(whereParamStr,valueList);
        }else{
            String[] valueList = {"time","{start_"+"time}","{end_"+"time}"};
            whereParamStr = MessageFormat.format(whereParamStr,valueList);
        }
        System.out.println(whereParamStr);*/
        //"0 15 10 * * ? 2005"  2005年的每天上午10:15触发
        //operationTime :
        String operationTime = "2021-07-05 09:08:05";
        String date = operationTime.split(" ")[0];
        String time = operationTime.split(" ")[1];
        String hour = time.split(":")[0];
        String minute = time.split(":")[1];
        String second = time.split(":")[2];
        String year = date.split("-")[0];
        String month = date.split("-")[1];
        String day = date.split("-")[2];
        String cronExpression = second + " " + minute + " " + hour + " " + day + " " + month + " ? " + year;
        System.out.println(cronExpression);


        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = sdf.parse("2019-06-06 12:09:08");
        System.out.println(sdf.format(date));*/
    }
}
