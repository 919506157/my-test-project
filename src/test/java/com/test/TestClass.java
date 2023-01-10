package com.test;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.imageio.ImageIO;
import javax.xml.crypto.dsig.*;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import java.net.*;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TestClass {
    private static final SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd");
    private static final SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyyMMddHHmmss");


    private static final Integer[] userIdArray = new Integer[]{13314310, 13314311, 13314312, 13314313, 13314314, 13314315, 13314316, 13314317, 13314318, 13314319, 13314320, 13314321, 13314322, 13314323, 13314324, 13314325, 13314326, 13314327, 13314328, 13314329, 13314330, 13314331, 13314332, 13314333, 13314334, 13314335, 13314336, 13314337, 13314338, 13314339, 13314340, 13314341, 13314342, 13314343, 13314344, 13314345, 13314346, 13314347, 13314348, 13314349, 13314350, 13314351, 13314352, 13314353, 13314354, 13314355, 13314356, 13314357, 13314358, 13314359, 13314360, 13314361, 13314362, 13314363, 13314364, 13314365, 13314366, 13314367, 13314368, 13314369, 13314370, 13314371, 13314372, 13314373, 13314374, 13314375, 13314376, 13314377, 13314378, 13314379, 13314380, 13314381, 13314382, 13314383, 13314384, 13314385, 13314386, 13314387, 13314388, 13314389, 13314390, 13314391, 13314392, 13314393, 13314394, 13314395, 13314396, 13314397, 13314398, 13314399, 13314400, 13314401, 13314402, 13314403, 13314404, 13314405, 13314406, 13314407, 13314408, 13314409};
    public static final DateTimeFormatter yyyyMMdd = DateTimeFormatter.ofPattern("yyyyMMdd");

    private static final SimpleDateFormat YYYY_MM_DD_HH_MM_SS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Test
    public void void54() {
        LocalDate now = LocalDate.now();

        LocalDate firstDayOfThisWeek = now.with(DayOfWeek.MONDAY);
        LocalDate firstDayOfThisMonth = now.with(TemporalAdjusters.firstDayOfMonth());

        LocalDate firstDayOfLastWeek = now.minusWeeks(1).with(DayOfWeek.MONDAY);
        LocalDate firstDayOfLastMonth = now.minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());



        System.out.println("");
    }

    @Test
    public void void53() {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();

        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("111"+stringBuilder.toString());

        ArrayList<String> list = new ArrayList<>();
        List<String> collect = list.stream().filter(s -> s.equals("1")).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void void52() {
        BigDecimal bigDecimal = new BigDecimal("0.02");
        int minute = bigDecimal.multiply(new BigDecimal(24 * 60)).intValue();
        System.out.println(JSON.toJSONString(minute));

        DateTime dateTime = DateUtil.offsetMinute(new Date(), minute);
        System.out.println(dateTime);
    }

    @Test
    public void void51() {
        List<User> list = new ArrayList<>();
        list.add(new User("11", "11"));
        list.add(new User("22", "22"));
        list.add(new User("33", "33"));

        list.stream().filter(user -> user.getEmail().equals("11")).forEach(user -> {
            user.setEmail(user.getEmail() + "ab");
        });

        System.out.println(JSON.toJSONString(list));

    }

    @Test
    public void void50() {
        List<User> userList = new ArrayList();
        User user = new User("123", "ABC");
        userList.add(user);
        userList.add(user);
        System.out.println(userList);
        System.out.println(JSON.toJSONString(userList));
        String s = JSON.toJSONString(userList);
        List<User> users = JSON.parseArray(s, User.class);
        System.out.println(users);
    }

    @Test
    public void test49() {
        long l = System.nanoTime();
        System.out.println(l);
        System.out.println(Thread.currentThread().getName());

        // 提交任务
        Future<String> future = executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(2000L);
            return "success";
        });
        try {
            String s = future.get(1, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test48() {
//        HashSet<String> hset = new HashSet<>();
//
//        TreeSet tset = new TreeSet();
//
//        hset.add("123");
//        hset.add("123");
//        hset.add("234");
        String key = "123";
        System.out.println(key.hashCode());
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put(key, "123");

        stringStringHashMap.get(key);

    }

    @Test
    public void test47() {
        int count = 100;
        int pageSize = 10;

        int pageNum = (count + pageSize - 1) / pageSize;
        int pageNum1 = count / pageSize + pageSize / pageSize - 1 / pageSize;

        int a = 1 / 10;
        System.out.println(a);
    }

    @Test
    public void test46() {
        try {
            ServerSocketChannel ssChannel = ServerSocketChannel.open();
            ssChannel.configureBlocking(false);
            ssChannel.bind(new InetSocketAddress(8080));

            Selector selector = Selector.open();
            ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test45() {
        UUID share = UUID.randomUUID();
        String shareId = share.toString().replaceAll("-", "");
        System.out.println(shareId);
        System.out.println(System.currentTimeMillis());

        new SimpleDateFormat("yyyyMMddHHmmssSSS");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        LocalDateTime now = LocalDateTime.now();
        String format = dateTimeFormatter.format(now);
        System.out.println(format);
    }

    @Test
    public void test44() {
        Integer min = 1000;
        Integer max = 2000;
        Random random = new Random();
        Integer r = random.nextInt(max - min + 1) + min;
        System.out.println(r);
    }

    @Test
    public void test43() {

        LocalDate now = LocalDate.now();
        String yyyyMMdd = now.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        System.out.println(yyyyMMdd);


        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(YYYY_MM_DD_HH_MM_SS.format(date));

        LocalDateTime localDateTime1 = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        Date date1 = Date.from(localDateTime1.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(YYYY_MM_DD_HH_MM_SS.format(date1));

        LocalDateTime localDateTime2 = LocalDateTime.of(LocalDate.now(), LocalTime.MIN).with(DayOfWeek.MONDAY);
        Date date2 = Date.from(localDateTime2.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(YYYY_MM_DD_HH_MM_SS.format(date2));

        LocalDateTime localDateTime3 = LocalDateTime.of(LocalDate.now(), LocalTime.MAX).with(DayOfWeek.SUNDAY);
        Date date3 = Date.from(localDateTime3.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(YYYY_MM_DD_HH_MM_SS.format(date3));
    }


    @Test
    public void test42() {

        String now = yyyyMMdd.format(LocalDate.now());
        System.out.println(now);
    }

    @Test
    public void test41() {
        System.out.println(56 & 8);
    }

    @Test
    public void test40() {
        try {
            InetAddress localHost = Inet4Address.getLocalHost();
            System.out.println(localHost.getHostAddress());
            System.out.println(localHost.getHostName());
            System.out.println(localHost.getCanonicalHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test39() {
        BigDecimal b1 = new BigDecimal("20.234");
        BigDecimal b2 = new BigDecimal("30.456464");
        BigDecimal b3 = new BigDecimal("40");


        ArrayList<BigDecimal> list = new ArrayList<>();
        list.add(b1);
        list.add(b2);
        list.add(b3);

//        for (BigDecimal bigDecimal : list) {
//            bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
//        }

//        for (int i = 0; i < list.size(); i++) {
//            list.get(i) = list.get(i).setScale(2, RoundingMode.HALF_UP);
//        }


        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);


    }


    @Test
    public void test38() {

        long millis = 30558003;
        long precision = 4;

        StringBuilder sb = new StringBuilder();
        String[] units = {"天", "时", "分", "秒", "毫秒"};
        int[] unitLen = {86400000, 3600000, 60000, 1000, 1};
        precision = Math.min(precision, 5);
        for (int i = 0; i < precision; i++) {
            if (millis >= unitLen[i]) {
                long mode = millis / unitLen[i];
                millis -= mode * unitLen[i];
                sb.append(mode).append(units[i]);
            }
        }
        System.out.println(sb.toString());
    }


    @Test
    public void test37() {

    }

    @Test
    public void test36() {
        String a = "123abc456.\\n";
        String s = a.replaceAll("[\\D]", "");
        System.out.println(s);
        Integer.parseInt("");
        Integer.valueOf("");
    }

    @Test
    public void test35() {
        Integer integer = new Integer(1);
        Number num = new Integer(1);

        //ArrayList<Number> list = new ArrayList<Integer>();
        //List<Number> list = new ArrayList<Integer>();

        List<? extends Number> list = new ArrayList<Integer>();
        list.add(null);


//        List<? super Number> list = new ArrayList<Object>();
    }

    @Test
    public void test34() {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        LocalDate begin = LocalDate.of(2015, 5, 21);
        Period between = Period.between(begin, now);
        System.out.println("相识" + between.getYears() + "年" + between.getMonths() + "月" + between.getDays() + "天");
        System.out.println();
    }


    @Test
    public void test33() {
        try {
            String a = "中国";
            String b = URLEncoder.encode(a, StandardCharsets.UTF_8.toString());

            System.out.println(b);
            System.out.println(URLDecoder.decode(a, StandardCharsets.UTF_8.toString()));


            String mobile = "15638571002";
            mobile = mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
            System.out.println(mobile);
            String s = Pattern.compile("(\\d{3})\\d{4}(\\d{4})").matcher(mobile).replaceAll("$1****$2");


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void test32() {

        List<Integer> list1 = new ArrayList();

        list1.add(1);
        list1.add(2);
//        list1.add(3);
//        list1.add(4);

        for (Integer t : list1) {
            //list1.add(3);
            list1.remove(1);
        }
        System.out.println(JSON.toJSONString(list1));

       /* List<Integer> list = Arrays.asList(userIdArray);
        for (Integer t : list){
            list.add(100);
            //list.remove(t);
        }*/
    }

    @Test
    public void test31() {

        boolean isPass = false;
        String input = null;

        while (!isPass) {
            Scanner sc = new Scanner(System.in);
            input = sc.nextLine();
            if (input.length() < 10) {
                System.out.println("长度不够");
                continue;
            }
            if (input.equals("111")) {
                System.out.println("输入的值不能为111");
                continue;
            }
            isPass = true;
        }


        System.out.println(input);

    }

    @Test
    public void test30() {
        String code = "";
        int checkBitLen = 7;

    }

    @Test
    public void test29() {

        int dynamicId = 11352;
        int activityId = 41;
        int sum = 300;//总数量
        int n = 20;//份数
        int min = 1;//最小值
        boolean isAllowZero = false;//是否允许为0

        List<Integer> list = new ArrayList();
        if (!isAllowZero) {
            //最小值*份数
            //修改总分总先扣除，后续每份再加上最小值
            sum = sum - n * min;
        }

        int temp = 0;
        for (int i = 0; i < n - 1; i++) {
            temp = (int) (Math.random() * sum);
            list.add(temp);
        }

        //头部加0
        list.add(0);
        //尾部加总数量
        list.add(sum);

        //排序
        Collections.sort(list);
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            //相邻两个数之间的差值，为此份的真实值
            nums[i] = list.get(i + 1) - list.get(i);
            //不允许为0的话，每份再加上一个最小值
            if (!isAllowZero) {
                nums[i] += min;
            }
        }


        Random random = new Random();
        Set<Integer> userIdSet = new TreeSet<>();


        do {
            int randomInt = random.nextInt(100) + 1;
            userIdSet.add(userIdArray[randomInt]);
        } while (userIdSet.size() < n);


       /* userIdSet.forEach(System.out::println);
        Arrays.stream(nums).forEach(System.out::println);*/

        List<Integer> result = new ArrayList<>(userIdSet);
        String a = "insert into T_VOTE_DYNAMIC_USER_TICKET (id, DYNAMIC_ID, DYNAMIC_USER_ID, VOTE_ACTIVITY_ID, USER_ID, TOTAL_TICKET_NUM, CREATE_TIME,UPDATE_TIME) values (T_VOTE_DYNAMIC_USER_TICKET_SEQ.nextval, %d, (select user_id from t_vote_dynamic where dynamic_id = %d), %d, %d,  %d, sysdate, sysdate);";

        for (int i = 0; i < n; i++) {
            System.out.println(String.format(a, dynamicId, dynamicId, activityId, result.get(i), nums[i]));
        }

    }

    @Test
    public void test28() {

        //计算砍价金额，用户砍价比例x剩余砍价金额
        BigDecimal userCutAmount = new BigDecimal("5.23").multiply(new BigDecimal("10")).divide(new BigDecimal(100)).setScale(8, BigDecimal.ROUND_DOWN);

        //真实砍价金额
        BigDecimal tureCutAmount = null;
        //计算金额=0，则为0
        if (userCutAmount.compareTo(BigDecimal.ZERO) == 0) {
            tureCutAmount = BigDecimal.ZERO;
        }
        //计算金额小于1分，则为1分
        else if (userCutAmount.compareTo(new BigDecimal("0.01")) <= 0) {
            tureCutAmount = new BigDecimal("0.01");
        }
        //计算金额小于1分，计算砍价金额
        else {
            tureCutAmount = userCutAmount.setScale(2, BigDecimal.ROUND_DOWN);
        }
        System.out.println(tureCutAmount);
    }

    @Test
    public void test27() {

        double a = 10;
        double b = 0.32;
        double c = a * b;
        double d = c % 1;
        System.out.println(d);

    }

    @Test
    public void test26() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int randomInt = random.nextInt(10) + 1;
            System.out.println(randomInt);
        }

        TreeMap<Long, Object> map = new TreeMap<>();
        map.tailMap(10L);


    }

    @Test
    public void test25() {
        int a = 5;

        int b = 6;

        int c = b / a;
        int d = b % a;
        int e = 0;
        if (c == 0) {
            e = 1;
        } else {
            if (d == 0) {
                e = c;
            } else {
                e = c + 1;
            }
        }
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
    }

    @Test
    public void test24() {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date nowDate = new Date();
        System.out.println(sdf1.format(nowDate));
        Integer type = 5;
        Date beginRuleDate = null;
        try {
            if (type == 1) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
                beginRuleDate = sdf.parse(sdf.format(nowDate));
            } else if (type == 2) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                beginRuleDate = sdf.parse(sdf.format(nowDate));
            } else if (type == 3) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                Calendar cal = Calendar.getInstance();
                cal.setTime(nowDate);
                cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                beginRuleDate = sdf.parse(sdf.format(cal.getTime()));
            } else if (type == 4) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Calendar cal = Calendar.getInstance();
                cal.setTime(nowDate);
                cal.add(Calendar.SECOND, -10);
                beginRuleDate = sdf.parse(sdf.format(cal.getTime()));
            } else if (type == 5) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Calendar cal = Calendar.getInstance();
                cal.setTime(nowDate);
                cal.add(Calendar.MINUTE, -10);
                beginRuleDate = sdf.parse(sdf.format(cal.getTime()));
            }


            System.out.println(sdf1.format(beginRuleDate));


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test23() {
        Integer totalCount = 98;

        totalCount += 1;
        /*int a = totalCount / 999;
        int b = totalCount % 999;
        System.out.println(a);
        System.out.println(b);

        if (b == 0) {
            char c = (char) (65 + a - 1);
            System.out.println(c + "999");
        } else {
            char c = (char) (65 + a);
            if (b < 10) {
                System.out.println(c + "0" + b);
            } else {
                System.out.println(c + "" + b);
            }
        }*/

        String format = String.format("%03d", totalCount);
        System.out.println(format);

    }

    @Test
    public void test22() {
        String a = "yanqiu.li@vdou.com";
        boolean matches = Pattern.matches("\\w+[\\w,.]+\\w+@(\\w+.)+[a-z]{2,3}", a);
        System.out.println(matches);

    }

    @Test
    public void test21() {
        String str = "#你好啊#就离开噶快就勾搭上了#快跑啊~#阿斯蒂芬 #都是# asdf";
        String rex = "#[^#]+#";
        Pattern pat = Pattern.compile(rex);
        Matcher mat = pat.matcher(str);
        while (mat.find()) {
            System.out.println(mat.group(0));//m.group(1)不包括这两个字符
        }
    }

    @Test
    public void test20() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String beginDateString = "2019-11-15 10:11:00";
            String nowDateString = "2020-01-15 10:22:00";
            Date fromTime = sdf2.parse(beginDateString);
            Date nowTime = sdf2.parse(nowDateString);

            Date beginTime = null;
            Date endTime = null;
            Calendar fromCal = Calendar.getInstance();
            fromCal.setTime(fromTime);
            int fromYear = fromCal.get(Calendar.YEAR);
            int fromMonth = fromCal.get(Calendar.MONTH);
            int fromDay = fromCal.get(Calendar.DAY_OF_MONTH);

            Calendar nowCal = Calendar.getInstance();
            nowCal.setTime(nowTime);
            int nowYear = nowCal.get(Calendar.YEAR);
            int nowMonth = nowCal.get(Calendar.MONTH);
            int nowDay = nowCal.get(Calendar.DAY_OF_MONTH);

            int yearNum = nowYear - fromYear;

            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, fromYear);
            cal.set(Calendar.MONTH, fromMonth);
            cal.set(Calendar.DAY_OF_MONTH, fromDay);
            cal.add(Calendar.YEAR, yearNum);
            int calYear = cal.get(Calendar.YEAR);
            int calMonth = cal.get(Calendar.MONTH);
            int calDay = cal.get(Calendar.DAY_OF_MONTH);
            if (nowYear == calYear && nowMonth <= calMonth && nowDay < calDay) {
                beginTime = cal.getTime();

                Calendar cal2 = Calendar.getInstance();
                cal2.set(Calendar.YEAR, fromYear);
                cal2.set(Calendar.MONTH, fromMonth);
                cal2.set(Calendar.DAY_OF_MONTH, fromDay);
                cal2.add(Calendar.YEAR, (yearNum - 1));
                cal2.add(Calendar.DATE, -1);
                endTime = cal2.getTime();
            } else {
                beginTime = cal.getTime();

                Calendar cal2 = Calendar.getInstance();
                cal2.set(Calendar.YEAR, fromYear);
                cal2.set(Calendar.MONTH, fromMonth);
                cal2.set(Calendar.DAY_OF_MONTH, fromDay);
                cal2.add(Calendar.YEAR, yearNum + 1);
                cal2.add(Calendar.DATE, -1);
                endTime = cal2.getTime();
            }

            System.out.println("开始" + sdf2.format(beginTime));
            System.out.println("结束" + sdf2.format(endTime));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test19() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String beginDateString = "2019-11-15 10:11:00";
            String nowDateString = "2020-01-15 10:22:00";
            Date beginDate = sdf2.parse(beginDateString);
            Date nowDate = sdf2.parse(nowDateString);

            Date d1 = null;
            Date d2 = null;

            Calendar beginCal = Calendar.getInstance();
            beginCal.setTime(beginDate);
            Calendar nowCal = Calendar.getInstance();
            nowCal.setTime(nowDate);
            System.out.println(beginCal.getTime());
            System.out.println(nowCal.getTime());

            int beginYear = beginCal.get(Calendar.YEAR);
            int beginMonth = beginCal.get(Calendar.MONTH);
            int beginDay = beginCal.get(Calendar.DAY_OF_MONTH);

            int nowYear = nowCal.get(Calendar.YEAR);
            int nowMonth = nowCal.get(Calendar.MONTH);
            int nowDay = nowCal.get(Calendar.DAY_OF_MONTH);
            int nowCalActualMaximum = nowCal.getActualMaximum(Calendar.DAY_OF_MONTH);

            int quarterNum = ((nowYear * 12 + nowMonth) - (beginYear * 12 + beginMonth)) / 3;
            System.out.println("相差季度数" + quarterNum);

            /*if (quarterNum == 0) {
                d1 = beginCal.getTime();
                beginCal.add(Calendar.MONTH, 3);
                beginCal.add(Calendar.DATE, -1);
                d2 = beginCal.getTime();
            } else {*/
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, beginYear);
            cal.set(Calendar.MONTH, beginMonth);
            cal.set(Calendar.DAY_OF_MONTH, beginDay);

            cal.add(Calendar.MONTH, quarterNum * 3);
            int endYear = cal.get(Calendar.YEAR);
            int endMonth = cal.get(Calendar.MONTH);
            int endDay = cal.get(Calendar.DAY_OF_MONTH);

            //还在期内
            if (nowMonth == endMonth && nowDay < endDay) {
                cal.add(Calendar.DATE, -1);
                d2 = cal.getTime();

                Calendar cal2 = Calendar.getInstance();
                cal2.set(Calendar.YEAR, beginYear);
                cal2.set(Calendar.MONTH, beginMonth);
                cal2.set(Calendar.DAY_OF_MONTH, beginDay);
                //
                cal2.add(Calendar.MONTH, (quarterNum - 1) * 3);
                d1 = cal2.getTime();
            } else {
                d1 = cal.getTime();

                Calendar cal2 = Calendar.getInstance();
                cal2.set(Calendar.YEAR, nowYear);
                cal2.set(Calendar.MONTH, beginMonth);
                cal2.set(Calendar.DAY_OF_MONTH, beginDay);
                //
                cal2.add(Calendar.MONTH, (quarterNum + 1) * 3);
                cal2.add(Calendar.DATE, -1);
                d2 = cal2.getTime();
            }

            System.out.println("开始" + sdf2.format(d1));
            System.out.println("结束" + sdf2.format(d2));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test18() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String beginDateString = "2020-01-31 10:11:00";
            String nowDateString = "2020-01-31 10:22:00";
            Date beginDate = sdf2.parse(beginDateString);
            Date nowDate = sdf2.parse(nowDateString);

            Calendar beginCal = Calendar.getInstance();
            beginCal.setTime(beginDate);
            Calendar nowCal = Calendar.getInstance();
            nowCal.setTime(nowDate);
            System.out.println(beginCal.getTime());
            System.out.println(nowCal.getTime());

            int beginYear = beginCal.get(Calendar.YEAR);
            int beginMonth = beginCal.get(Calendar.MONTH);
            int beginDay = beginCal.get(Calendar.DAY_OF_MONTH);

            int nowYear = nowCal.get(Calendar.YEAR);
            int nowMonth = nowCal.get(Calendar.MONTH);
            int nowDay = nowCal.get(Calendar.DAY_OF_MONTH);
            int nowCalActualMaximum = nowCal.getActualMaximum(Calendar.DAY_OF_MONTH);
            Date d1 = null;
            Date d2 = null;

            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, nowYear);
            cal.set(Calendar.MONTH, nowMonth);

            int monthNum = (nowYear * 12 + nowMonth) - (beginYear * 12 + beginMonth);

            if (nowDay < beginDay) {
                //先获取上个月的开始时间
                cal.add(Calendar.MONTH, -1);
                int actualMaximum = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
                if (beginDay >= actualMaximum) {
                    cal.set(Calendar.DAY_OF_MONTH, actualMaximum);
                } else {
                    cal.set(Calendar.DAY_OF_MONTH, beginDay);
                }
                d1 = cal.getTime();
                //获取下个月的结束时间
                cal.add(Calendar.MONTH, 1);
                int actualMaximum2 = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
                if (beginDay >= actualMaximum2) {
                    cal.set(Calendar.DAY_OF_MONTH, actualMaximum2 - 1);
                } else {
                    cal.set(Calendar.DAY_OF_MONTH, beginDay - 1);
                }
                d2 = cal.getTime();
            } else {
                cal.set(Calendar.DAY_OF_MONTH, beginDay);
                d1 = cal.getTime();
                cal.add(Calendar.MONTH, 1);
                int actualMaximum = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
                if (beginDay >= actualMaximum) {
                    cal.set(Calendar.DAY_OF_MONTH, actualMaximum - 1);
                } else {
                    cal.set(Calendar.DAY_OF_MONTH, beginDay - 1);
                }
                d2 = cal.getTime();
            }

            System.out.println("开始" + sdf2.format(d1));
            System.out.println("结束" + sdf2.format(d2));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test17() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String beginDateString = "20201001";
            String nowDateString = "20201014";
            Date beginDate = sdf.parse(beginDateString);
            Date nowDate = sdf.parse(nowDateString);
            Calendar cal = Calendar.getInstance();

            long dateNum = (nowDate.getTime() - beginDate.getTime()) / (1000L * 3600L * 24L);
            long weeksNum = dateNum / 7L;
            System.out.println(nowDate.getTime());
            System.out.println(beginDate.getTime());
            System.out.println(dateNum);
            System.out.println(weeksNum);

            cal.setTime(beginDate);
            cal.add(Calendar.DAY_OF_MONTH, (int) (weeksNum * 7));

            Date time = cal.getTime();
            System.out.println("应拉取日期-开始" + sdf.format(time));
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(time);
            cal2.add(Calendar.DAY_OF_MONTH, 6);
            Date time2 = cal2.getTime();
            System.out.println("应拉取日期-结束" + sdf.format(time2));


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test16() {
        List<String> list1 = new ArrayList<>(10);
        list1.add("1-1");
        list1.add("1-2");
        list1.add("1-3");
        list1.add("1-4");
        list1.add("1-5");
        list1.add("1-6");
        list1.add("1-7");
        list1.add("1-8");
        list1.add("1-9");
        list1.add("1-10");

        System.out.println(list1);

        /*list1.add(1, "2-2");
        list1.add(2, "2-3");
        list1.add(6, "2-7");*/
        /*list1.add(11, "2-12");
        list1.add(12, "2-13");*/

        list1.add("2-12");
        list1.add("2-13");
        //List<String> list2 = list1.subList(0, 15);

        System.out.println(list1);
        //System.out.println(list2);
    }

    @Test
    public void test15() {
        String a = "0xe4,0xb8,0x8d,0xe5,0x9c,0xa8,0xe7,0x99,0xbd,0xe5,0x90,0x8d,0xe5,0x8d,0x95,0xe4,0xb8,0xad";
        String[] split = a.split(",");

        int b = 0x9c;
        String s = Integer.toString(0xe4);
        int c = Integer.parseInt("e4", 16);

        char a1 = 'A';
        char a2 = 'a';
        char a3 = 65;
        char a4 = 97;
        char a5 = 97;

        System.out.println('A' + a1);

    }

    @Test
    public void test14() {
        StringBuffer stringBuffer = new StringBuffer("00000000");
        StringBuffer replace = stringBuffer.replace(1, 2, "1");
        System.out.println(replace.toString());
    }

    @Test
    public void test13() {
        try {
            String a = "2020-08-11 24:01:58";
            String b = "2020-08-12 01:03:10";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date parse1 = sdf.parse(a);
            Date parse2 = sdf.parse(b);
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");

            String format1 = sdf2.format(parse1);
            String format2 = sdf2.format(parse2);

            Date parse3 = sdf2.parse(format1);
            Date parse4 = sdf2.parse(format2);
            long l = parse4.getTime() - parse3.getTime();
            long min = l / 1000 / 60;
            System.out.println(min);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test12() {

        String beginTime = "08:17";
        String endTime = "08:20";

        String[] startArr = beginTime.split(":");
        String[] endArr = endTime.split(":");

        Integer startMin = Integer.parseInt(startArr[0]) * 60 + Integer.parseInt(startArr[1]);
        Integer endMin = Integer.parseInt(endArr[0]) * 60 + Integer.parseInt(endArr[1]);

        Integer totalMin = endMin - startMin;
        System.out.println(totalMin);
    }

    @Test
    public void test11() {
        String commissionRate = "2001";
        BigDecimal commissionRateBig = new BigDecimal("0." + commissionRate);
        BigDecimal bigDecimal = new BigDecimal("0.9");
        BigDecimal multiply = commissionRateBig.multiply(bigDecimal).multiply(new BigDecimal("79"));
        String s = multiply.setScale(2, BigDecimal.ROUND_DOWN).toString();
        System.out.println(s);


    }


    @Test
    public void test10() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -4);
        String format = sdf.format(calendar.getTime());
        System.out.println(format);
    }

    @Test
    public void test9() {
        Random random = new Random();
        for (int j = 0; j < 10000000; j++) {
            int i1 = random.nextInt(999999999);
            if (i1 < 10) {
                System.out.println("特殊：" + i1);
            }
            System.out.println(i1);
        }
    }

    @Test
    public void test8() {
        Date date = new Date(1458115189);
        System.out.println(date);
    }

    @Test
    public void test7() {
        String a = "{\n" +
                "\t\"ActionStatus\": \"OK\",\n" +
                "\t\"ErrorCode\": 0,\n" +
                "\t\"GroupId\": \"@TGS#2FZNNRAEU\",\n" +
                "\t\"ShuttedUinList\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"Member_Account\": \"tommy\",\n" +
                "\t\t\t\"ShuttedUntil\": 1458115189\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Member_Account\": \"peter\",\n" +
                "\t\t\t\"ShuttedUntil\": 1458115189\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";


        JSONObject jsonObject = JSON.parseObject(a);
        System.out.println(jsonObject.toJSONString());
        Object shuttedUinList = jsonObject.get("ShuttedUinList");

        List<ShutUser> shutUsers = JSON.parseArray(shuttedUinList.toString(), ShutUser.class);
        System.out.println(shutUsers);

    }

    @Test
    public void test6() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        calendar.add(Calendar.HOUR, 1);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.YEAR, 100);
        System.out.println(calendar.getTime());
    }

    @Test
    public void test5() {
        List<Integer> list = new ArrayList<>();
        int a = 0;
        for (int i = 1; i <= 8; i++) {
            a++;
            list.add(a);
        }

        List<List<Integer>> listGroup = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += 10) {
            List<Integer> list1 = null;
            if (i + 10 > size) {
                list1 = list.subList(i, size);
            } else {
                list1 = list.subList(i, i + 10);
            }
            listGroup.add(list1);
        }
    }

    @Test
    public void test4() {
        FTPClient ftpClient = new FTPClient();
        String fileName = "测试.txt";

        String localPath = "D:/" + fileName;
        String remotePath = "/test/" + fileName;
        try {

            //1.获取模板的文件
            /*ftpClient.connect("172.16.5.85", 21);
            ftpClient.login("dzdz", "Lh536I70ZP");*/
            ftpClient.connect("172.22.203.21", 21);
            ftpClient.login("dzdz", "123456");

            ftpClient.setControlEncoding("UTF-8");
            ftpClient.enterLocalPassiveMode();//被动模式

            //文件下载后保存的位置
            FileOutputStream fos = new FileOutputStream(localPath);
            ftpClient.setBufferSize(1024);
            //设置文件类型（二进制）
            ftpClient.setFileType(2);

            String a = new String(remotePath.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
            System.out.println(a);

            ftpClient.retrieveFile(a, fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
    }

    @Test
    public void test3() {
        String[] a = {"abc", "def", "ghi"};
        List<String> list = Arrays.asList(a);
        list.add("123");

    }

    @Test
    public void test2() {
        try {
            //创建解析器工厂
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            document.setXmlStandalone(true);
            //根
            Element root = document.createElement("ceb:CEB411Message");
            root.setAttribute("guid", "4CDE1CFD-EDED-46B1-946C-B8022E42FC94");
            root.setAttribute("version", "1.0");
            root.setAttribute("xmlns:ceb", "http://www.chinaport.gov.cn/ceb");
            root.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            Node node = document.appendChild(root);
            //
            for (int i = 0; i < 2; i++) {
                Element payment = document.createElement("ceb:Payment");
                Node node1 = root.appendChild(payment);

                Element paymentHead = document.createElement("ceb:PaymentHead");
                Node node2 = payment.appendChild(paymentHead);

                paymentHead.appendChild(document.createElement("ceb:guid")).setTextContent("4CDE1CFD-EDED-46B1-946C-B8022E42FC94");
                paymentHead.appendChild(document.createElement("ceb:appType")).setTextContent("1");
                paymentHead.appendChild(document.createElement("ceb:appTime")).setTextContent("20160308112745");

            }
            //dom转字符串
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            DOMSource domSource = new DOMSource(document);
            transformer.transform(domSource, new StreamResult(bos));
            System.out.println(bos.toString());

            /***************************************************/
            //创建xml签名工厂
            XMLSignatureFactory xmlSignatureFactory = XMLSignatureFactory.getInstance("DOM");
            //获取到私钥
            PrivateKey privateKey = getPriKey();
            DOMSignContext domSignContext = new DOMSignContext(privateKey, document.getDocumentElement());
            Reference reference = null;
            SignedInfo signedInfo = null;

            DigestMethod digestMethod = xmlSignatureFactory.newDigestMethod(DigestMethod.SHA1, null);
            Transform transform = xmlSignatureFactory.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null);
            List<Transform> transforms = Collections.singletonList(transform);
            reference = xmlSignatureFactory.newReference("", digestMethod, transforms, null, null);


            CanonicalizationMethod cm = xmlSignatureFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null);
            SignatureMethod sm = xmlSignatureFactory.newSignatureMethod(SignatureMethod.RSA_SHA1, null);
            List<Reference> references = Collections.singletonList(reference);
            signedInfo = xmlSignatureFactory.newSignedInfo(cm, sm, references);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PrivateKey getPriKey() {
        FileInputStream fis = null;
        KeyStore keyStore = null;
        try {
            fis = new FileInputStream("E:\\usr\\local\\keys\\yinlian\\jg-私钥-4000370693.pfx");
            char[] pwdCharArray = "11111111".toCharArray();
            keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(fis, pwdCharArray);
            Enumeration<String> aliases = keyStore.aliases();
            String keyAlias = null;
            if (aliases.hasMoreElements()) {
                keyAlias = aliases.nextElement();
            }
            Key key = keyStore.getKey(keyAlias, pwdCharArray);
            return (PrivateKey) key;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static PublicKey loadPublicKeyFromCer(String cerPath) {
        FileInputStream fis = null;
        CertificateFactory cf = null;
        X509Certificate X509Certificate = null;
        try {
            fis = new FileInputStream("cerPath");
            cf = CertificateFactory.getInstance("X.509");
            X509Certificate = (X509Certificate) cf.generateCertificate(fis);
            PublicKey publicKey = X509Certificate.getPublicKey();
            return publicKey;
        } catch (Exception e) {
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (Exception e) {
            }
        }
        return null;
    }


    @Test
    public void test1() {
        BufferedImage image = new BufferedImage(70, 26, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, 70, 26);
        String s = createCharacter(g);
        System.out.println("验证码" + s);
        g.dispose();

        try {
            ImageIO.write(image, "jpg", new File("E:/" + "123.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String createCharacter(Graphics g) {
        char[] codeSeq = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J',
                'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9'};
        String[] fontTypes = {"Arial", "Arial Black", "AvantGarde Bk BT", "Calibri"};
        Random random = new Random();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            String r = String.valueOf(codeSeq[random.nextInt(codeSeq.length)]);//random.nextInt(10));
            g.setColor(new Color(50 + random.nextInt(100), 50 + random.nextInt(100), 50 + random.nextInt(100)));
            g.setFont(new Font(fontTypes[random.nextInt(fontTypes.length)], Font.BOLD, 26));
            g.drawString(r, 15 * i + 5, 19 + random.nextInt(8));
//			g.drawString(r, i*w/4, h-5);
            s.append(r);
        }


        return s.toString();
    }

    @Test
    public void mybatisTest() {
        while (true) {
            for (int i = 0; i < 30000; i++) {
                int a = i * i;
            }
        }
    }
}
