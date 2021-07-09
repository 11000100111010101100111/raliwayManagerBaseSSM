
import com.yakeManager.service.serviceInterface.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.*;


public class testFindCity {
//    @Resource(name = "userServiceImpl")
//    UserService userService;


//    读取省份和地级市
    @Test
    public void fun1(){

//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserService service = (UserService) context.getBean("userServiceImpl");
////        System.out.println(service.findselectmsg("train_id","carrage"));
//        List<String> provinces=service.findProvince();
//
//        for (String item:provinces) {
//            System.out.print(item+":");
////            List<String> city=service.findCity(item);
//            for (String temp:city) {
//                System.out.print(temp+" ,");
//            }
//            System.out.println();
//        }
    }

//    可读取省份内的列车车次和省市列车车次
    @Test
    public void fun2(){
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserService service = (UserService) context.getBean("userServiceImpl");
//        List<String> provinces=service.findProvince();
//        HashMap<String,List<String>> Pcity = new HashMap<String, List<String>>();
//        for (String item:provinces) {
//            System.out.print(item+":");
//            List<String> ob=service.findCity(item);
//            System.out.println(ob);
//            Pcity.put(item,ob);
//        }
//        for (int i=0 ;i<Pcity.size();i++){
//            for (String item:Pcity.get(provinces.get(i))) {
//                System.out.println(provinces.get(i)+"-"+item+":"+service.findTrainByProvinceCity(provinces.get(i),item));
//            }
//        }
    }
    @Test
    public void fun3(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service = (UserService) context.getBean("userServiceImpl");
        ArrayList<String> provinces=service.findAllProvince();
        System.out.println(provinces.size());
    }

    @Test
    public void fun4(){
        System.out.println(((UserService) (new ClassPathXmlApplicationContext("applicationContext.xml"))
                .getBean("userServiceImpl"))
                .findUserById("188207245")
        );
    }
    @Test
    public void fun5(){
//        ArrayList<String> arr=userService.findAllProvince();
        System.out.println(((UserService) (new ClassPathXmlApplicationContext("applicationContext.xml"))
                .getBean("userServiceImpl"))
                .findAllProvince()
        );
    }

//    @Test
//    public void fun6(){
////        ArrayList<String> arr=userService.findAllProvince();
//        System.out.println(((UserService) (new ClassPathXmlApplicationContext("applicationContext.xml"))
//                .getBean("userServiceImpl"))
//                .findselectmsg("train_id","carrage")
//        );
//    }
    @Test
    public void fun7(){
//        ArrayList<String> arr=userService.findAllProvince();
        System.out.println(((UserService) (new ClassPathXmlApplicationContext("applicationContext.xml"))
                .getBean("userServiceImpl"))
                .findrailway()
        );
    }

    @Test
    public void fun8() throws ParseException {
        String dateString="2021-6-29 12:32:00";
        String time="2010-11-20 11:10:10";

        Date date=null;
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date=formatter.parse(time);
        System.out.println(date);

    }
    @Test
    public void fun9() throws ParseException{
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        //将字符串形式的时间转化为Date类型的时间
        Date a=sdf.parse("2021-6-20 12:65:22");
        Date b=sdf.parse("2021-6-29 12:32:00");
        Date item=sdf.parse("2021-7-1 12:32:00");
//        if(a.equals(b))
//            System.out.println("true");
//        //Date类的一个方法，如果a早于b返回true，否则返回false
//        System.out.println(a.before(b));

        System.out.println((!item.equals(a) && !item.equals(b)) && (!item.after(a) || !item.before(b)));

    }
    @Test
    public void j(){
            Date date = new Date();
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String da = dateFormat.format(date);
            //将字符串形式的时间转化为Date类型的时间
            Date item=new Date();
            try {
                item=dateFormat.parse("2021-07-01 11:00:00");
                date=dateFormat.parse(da);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        System.out.println(item.before(date));
    }
    @Test
    public void time() throws ParseException {
        SimpleDateFormat simpleFormat =new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date start = simpleFormat.parse("2018-03-10 17:02");
        Date end = simpleFormat.parse("2018-03-12 17:48");
        long startT = start.getTime();
        long endT = end.getTime();
        int minutes = (int) ((endT - startT) / (1000 * 60));

        int H=minutes/60;
        int M=minutes%60;
        int D=H/24;
        H=H%24;

        System.out.println("两个时间之间的差为：" +D+"天"+ H+"小时"+M+"分钟");
        System.out.println((D>0? D+"天"+H+"小时": H>0? H+"小时" : "")+ (M>0? M+"分钟":"") );
    }
    @Test
    public void fun10() throws ParseException {
        SimpleDateFormat simpleFormat =new SimpleDateFormat("yyyy-MM-dd");
        Date start = simpleFormat.parse("2021-10-6 12:30:02");

        String time=simpleFormat.format(start);
//        System.out.println(time);


        System.out.println(time);
    }
    @Test
    public void fun11(){
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String da = dateFormat.format(date);
        System.out.println(da);
    }
    @Test
    public void deleteStr(){
        String item="共青城";
        String str="站";

        if(item.substring(item.length()-1).equals(str)){
            item=item.substring(0,item.length()-1);
        }
        System.out.println(item);
    }
    @Test
    public void timeNow(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Calendar nowTime = Calendar.getInstance();
//                nowTime.add(Calendar.MINUTE, 0);// 把日期往后增加10分钟.

        String now = sdf.format(nowTime.getTime());
        System.out.println(now);
    }

    @Test
    public void isOverNow(){
        String time="2021-07-02T08:34";
        System.out.println(time.length());
        if(time.length()<=16)
            time = time+":00";
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String da = dateFormat.format(date);

//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Calendar nowTime = Calendar.getInstance();
//
//            String now = sdf.format(nowTime.getTime());

        //将字符串形式的时间转化为Date类型的时间
        Date item=new Date();
        try {
            System.out.println(time);
            item=dateFormat.parse(time.replace('T',' '));
            System.out.println(item);
            date=dateFormat.parse(da);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("当前时间："+date.getTime()+"对照时间："+time+",是否超出时间："+item.before(date));
//        return item.before(date);
    }
    @Test
    public void splitStr(){
        String[] str="station=12356".split("=");
        System.out.println(str[0]+"---"+str[1]);
    }
    @Test
    public void getNowTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
    }
    @Test
    public void judgeIsNow() throws ParseException {
        Date d1=new Date();
        SimpleDateFormat simpleFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = simpleFormat.parse("2021-07-01 12:30:55");
        Date end = simpleFormat.parse("2021-07-02 12:22:12");
        Date now =new Date();
//                      d1=  df.format(r.getStart_time());
        if(start.before(now) && end.after(now)){
            System.out.println("正在运行");
        }else if(end.before(now)){
            System.out.println("已停用");
        }else {
            System.out.println("未发车");
        }
    }
}
