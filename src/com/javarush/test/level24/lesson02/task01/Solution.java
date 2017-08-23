package com.javarush.test.level24.lesson02.task01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Cloneable
Добавьте java-код, чтобы метод main отработал без исключений.
Удалять что-либо нельзя.
*/
public class Solution {

    public static void main(String[] args) throws CloneNotSupportedException ,ParseException {
        Test1 test1 = new Test1();
        test1.clone();

        Test2 test2 = new Test2();
        test2.clone(new Test2());

        Test3 test3 = new Test3();
        test3.c1one();

        Test4 test4 = new Test4();
        test4.clone();

        String description = "\"<p>\\n\\t<img alt=\\\"\\u0413\\u043e\\u0434\\u0438\\u043d\\u0430 \\u0430\\u043b\\u044c\\u0442\\u0435\\u0440\\u043d\\u0430\\u0442\\u0438\\u0432\\u0438\\\" class=\\\"img-responsive event-picture__pic\\\" src=\\\"https:\\/\\/s3.eu-central-1.amazonaws.com\\/listmusor\\/production\\/afisha\\/30167\\/596dbe759b488.jpeg?1309784296\\\" style=\\\"width:0px;\\\"><img alt=\\\"\\u0413\\u043e\\u0434\\u0438\\u043d\\u0430 \\u0430\\u043b\\u044c\\u0442\\u0435\\u0440\\u043d\\u0430\\u0442\\u0438\\u0432\\u0438\\\" class=\\\"img-responsive event-picture__pic\\\" src=\\\"https:\\/\\/s3.eu-central-1.amazonaws.com\\/listmusor\\/production\\/afisha\\/30167\\/596dbe759b488.jpeg?1309784296\\\" style=\\\"width:0px;\\\"><img alt=\\\"\\u0413\\u043e\\u0434\\u0438\\u043d\\u0430 \\u0430\\u043b\\u044c\\u0442\\u0435\\u0440\\u043d\\u0430\\u0442\\u0438\\u0432\\u0438\\\" class=\\\"img-responsive event-picture__pic\\\" src=\\\"https:\\/\\/s3.eu-central-1.amazonaws.com\\/listmusor\\/production\\/afisha\\/30167\\/596dbe759b488.jpeg?1309784296\\\" style=\\\"width:0px;\\\"><img alt=\\\"\\u0413\\u043e\\u0434\\u0438\\u043d\\u0430 \\u0430\\u043b\\u044c\\u0442\\u0435\\u0440\\u043d\\u0430\\u0442\\u0438\\u0432\\u0438\\\" class=\\\"img-responsive event-picture__pic\\\" src=\\\"https:\\/\\/s3.eu-central-1.amazonaws.com\\/listmusor\\/production\\/afisha\\/30167\\/596dbe759b488.jpeg?1309784296\\\" style=\\\"width:0px;\\\">\\u041a\\u043e\\u0436\\u0435\\u043d \\u0441\\u043e\\u0440\\u0442 \\u043a\\u0430\\u0432\\u0438 \\u043c\\u0430\\u0454 \\u0441\\u0432\\u043e\\u0457 \\u0441\\u043c\\u0430\\u043a\\u043e\\u0432\\u0456 \\u0445\\u0430\\u0440\\u0430\\u043a\\u0442\\u0435\\u0440\\u0438\\u0441\\u0442\\u0438\\u043a\\u0438 \\u0456 \\u0432 \\u0437\\u0430\\u043b\\u0435\\u0436\\u043d\\u043e\\u0441\\u0442\\u0456 \\u0432\\u0456\\u0434 \\u0441\\u043f\\u043e\\u0441\\u043e\\u0431\\u0443 \\u0437\\u0430\\u0432\\u0430\\u0440\\u044e\\u0432\\u0430\\u043d\\u043d\\u044f \\u0442\\u0435 \\u0447\\u0438 \\u0456\\u043d\\u0448\\u0435 \\u0437\\u0435\\u0440\\u043d\\u043e \\u043c\\u043e\\u0436\\u0435 \\u0440\\u043e\\u0437\\u043a\\u0440\\u0438\\u0432\\u0430\\u0442\\u0438\\u0441\\u044f \\u0431\\u0456\\u043b\\u044c\\u0448 \\u044f\\u0441\\u043a\\u0440\\u0430\\u0432\\u043e. \\u0422\\u043e\\u043c\\u0443 \\u0424\\u0430\\u0431\\u0440\\u0438\\u043a\\u0430 \\u043a\\u0430\\u0432\\u0438 \\u0440\\u043e\\u0437\\u043f\\u043e\\u0447\\u0438\\u043d\\u0430\\u0454 \\u0434\\u0435\\u0433\\u0443\\u0441\\u0442\\u0430\\u0446\\u0456\\u044e \\u0430\\u043b\\u044c\\u0442\\u0435\\u0440\\u043d\\u0430\\u0442\\u0438\\u0432\\u043d\\u0438\\u0445 \\u043c\\u0435\\u0442\\u043e\\u0434\\u0456\\u0432 \\u043f\\u0440\\u0438\\u0433\\u043e\\u0442\\u0443\\u0432\\u0430\\u043d\\u043d\\u044f.<br>\\n\\t\\u0427\\u0435\\u043a\\u0430\\u0454\\u043c\\u043e \\u0443\\u0441\\u0456\\u0445 \\u0431\\u0430\\u0436\\u0430\\u044e\\u0447\\u0438\\u0445 \\u0441\\u043a\\u0443\\u0448\\u0442\\u0443\\u0432\\u0430\\u0442\\u0438 \\u0430\\u0440\\u043e\\u043c\\u0430\\u0442\\u043d\\u0438\\u0439 \\u043d\\u0430\\u043f\\u0456\\u0439, \\u043f\\u0440\\u0438\\u0433\\u043e\\u0442\\u043e\\u0432\\u043b\\u0435\\u043d\\u0438\\u0439 \\u0443 \\u043a\\u0435\\u043c\\u0435\\u043a\\u0441\\u0456.<br>\\n\\t\\u0417\\u0430\\u0432\\u0430\\u0440\\u044e\\u0432\\u0430\\u0442\\u0438\\u043c\\u0435\\u043c\\u043e \\u0434\\u0432\\u0430 \\u0440\\u0456\\u0437\\u043d\\u0438\\u0445 \\u0441\\u043e\\u0440\\u0442\\u0438 \\u0456 \\u043f\\u043e\\u0440\\u0456\\u0432\\u043d\\u044e\\u0432\\u0430\\u0442\\u0438\\u043c\\u0435\\u043c\\u043e \\u0457\\u0445 \\u0441\\u043c\\u0430\\u043a\\u0438.<\\/p>\"";

        String description5 = "<p>\\n\\t<img alt=\\\"Image may contain: people smiling, one or more people, beard, eyeglasses and indoor\\\" class=\\\"spotlight\\\" height=\\\"487\\\" src=\\\"https:\\/\\/scontent-frt3-2.xx.fbcdn.net\\/v\\/t1.0-9\\/18556010_1331515183570045_7539947695831576640_n.jpg?oh=5b0e0f880648a881ba5c2d1304ea7eac&amp;oe=59D1C708\\\" width=\\\"737\\\"><\\/p>\\n<p>\\n\\t<span class=\\\"_4n-j _fbReactionComponent__eventDetailsContentTags fsl\\\">Make Like a Tree is a quintessention of travels expressed in music and photography created by Sergey Onischenko - vagabonder from Ukraine who is hitch-hiking round the world and spreading his indie-folk tunes with a touch of non-conformism and Beat Generation ideas and exhibiting his minimalistic landscape photography taken in omnifarious places during his journeys. Each concert is played with new members and all songs are created and recordered in different parts of the world. Experiments with sounds and collaborations with audience can turn one-man-band in a duo or in quite a large improvising ensemble so be ready to take part in a process of creating music. Sloundscapes of Make Like a Tree will bring you to <span class=\\\"text_exposed_show\\\">inner world of nature, woods, mountains and songs of whales on the bottom of the ocean.<br><br>\\n\\tMake Like a Tree is a combination of music, photography and videoart that have been created on the road during years of non stop travels around the world. <\\/span><\\/span><\\/p><p>\\n\\t<img alt=\\\"Image may contain: people smiling, one or more people, beard, eyeglasses and indoor\\\" class=\\\"spotlight\\\" height=\\\"487\\\" src=\\\"https:\\/\\/scontent-frt3-2.xx.fbcdn.net\\/v\\/t1.0-9\\/18556010_1331515183570045_7539947695831576640_n.jpg?oh=5b0e0f880648a881ba5c2d1304ea7eac&amp;oe=59D1C708\\\" width=\\\"737\\\"><\\/p>\\n<p>\\n\\t<span class=\\\"_4n-j _fbReactionComponent__eventDetailsContentTags fsl\\\">Make Like a Tree is a quintessention of travels expressed in music and photography created by Sergey Onischenko - vagabonder from Ukraine who is hitch-hiking round the world and spreading his indie-folk tunes with a touch of non-conformism and Beat Generation ideas and exhibiting his minimalistic landscape photography taken in omnifarious places during his journeys. Each concert is played with new members and all songs are created and recordered in different parts of the world. Experiments with sounds and collaborations with audience can turn one-man-band in a duo or in quite a large improvising ensemble so be ready to take part in a process of creating music. Sloundscapes of Make Like a Tree will bring you to <span class=\\\"text_exposed_show\\\">inner world of nature, woods, mountains and songs of whales on the bottom of the ocean.<br><br>\\n\\tMake Like a Tree is a combination of music, photography and videoart that have been created on the road during years of non stop travels around the world. <\\/span><\\/span><\\/p>";

     /*   Pattern patternOne = Pattern.compile("\\b<img\\b");
        Matcher matcher = patternOne.matcher(description);

        while (matcher.find()) {
            System.out.print(matcher.start() + " " + matcher.end());
        }

        Pattern patternTwo = Pattern.compile(">");
        Matcher matcherTwo = patternTwo.matcher(description);

        while (matcherTwo.find()) {
            System.out.print(matcherTwo.start() + " " + matcherTwo.end());
        }
        */
        int start;
        int end;
        System.out.println(start = description.indexOf("<img "));
        System.out.println(end  = description.indexOf('>', start));

        String partOne;
        String partTwo;
        String partThree;

        String res = "";
        if(start > 0 && end > 0) {
            System.out.println(partTwo = description.substring(start, end + 1));

            int startTwo;
            int endTwo;

            startTwo = partTwo.indexOf("src=");
            endTwo = partTwo.indexOf('"', startTwo + 10);

            if(startTwo > 0 && endTwo > 0) {
                System.out.println(partTwo = partTwo.substring(startTwo, endTwo + 1));
                partTwo = "<img alt=\"Picture\" ".concat(partTwo).concat(" style=\"height:auto; max-width:100%;\">");
                System.out.println(partTwo);
            }

            partOne = description.substring(0, start);
            partThree = description.substring(end + 1);

            res = partOne.concat(partTwo).concat(partThree);
            System.out.println(res);
        }

        Calendar c = Calendar.getInstance();

// set the calendar to start of today
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

// and get that as a Date
        Date today = c.getTime();

// or as a timestamp in milliseconds
        long todayInMillis = c.getTimeInMillis();

// user-specified date which you are testing
// let's say the components come from a form or something
        int year = 2011;
        int month = 5;
        int dayOfMonth = 20;

// reuse the calendar to set user specified date
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

// and get that as a Date
        Date dateSpecified = c.getTime();

// test your condition
        if (dateSpecified.before(today)) {
            System.err.println("Date specified [" + dateSpecified + "] is before today [" + today + "]");
        } else {
            System.err.println("Date specified [" + dateSpecified + "] is NOT before today [" + today + "]");
        }
    }

    public static class Test1 implements Cloneable{
        protected Test1 clone() throws CloneNotSupportedException {
            return (Test1)super.clone();
        }
    }

    public static class Test2 extends Test1 {
        public Test2 clone(Test2 test2) throws CloneNotSupportedException {
            return (Test2)test2.clone();
        }
    }

    public static class Test3 extends Test2 {
        protected Object c1one() throws CloneNotSupportedException {
            return new Test3();
        }
    }

    public static class Test4 extends Test3 {
        protected Object c1one() throws CloneNotSupportedException {
            return super.c1one();
        }
    }
}
