package com.base.job.utils;


import com.base.job.dao.JobMapper;
import com.base.job.model.Job;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduledJsoup {

    @Autowired
    JobMapper jobMapper;

    private final String  ChinaHrWeb = "http://www.chinahr.com/sou/?orderField=relate&keyword=%s&city=%s&page=%d&workAge=%s";

    private final String Job51Web = "http://search.51job.com/list/%s,000000,0000,00,9,99,%s,2,%d.html&workyear=%s";

    private final String LagouWeb = "https://www.lagou.com/jobs/positionAjax.json?gj=%s&px=default&city=%s&needAddtionalResult=false";



    public void timingJsoup(){
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);
        pool.scheduleAtFixedRate(new JsoupThread(),0,1,TimeUnit.DAYS);
    }


    public void ChinaHrJsoup(){
        List<Job> jobList = new ArrayList<>();
        try {
            for (int h = 1; h < 3 ; h++) {
                String url = "https://campus.chinahr.com/qz/P"+ h;
                org.jsoup.nodes.Document document = Jsoup.connect("https://campus.chinahr.com/qz/").get();
                Element body = document.body();
                for (int i = 0 ; i < 15 ; i++ ){
                    String jsoupText = body.getElementsByClass("item").get(i).text();
                    Element urlElement = body.getElementsByClass("top-area").get(i);
                    String urlString = urlElement.select("a").attr("href");
                    System.out.println(jsoupText);
                    String jobNarration = " ";
                    String url1 = "https://campus.chinahr.com"+urlString;
                    System.out.println(url1);
                    try {
                        org.jsoup.nodes.Document document1 = Jsoup.connect(url1).get();
                        Element body1 = document1.body();
                        jobNarration = body1.getElementsByClass("job-responsibility").text();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    String[] strings = jsoupText.split(" ");
                    String jobName = strings[0];
                    String jobCompany = strings[1];
                    String jobMinMoney = strings[2].split("-")[0];
                    String jobMaxMoney = "0";
                    if (strings[2].split("-").length == 1){
                        jobMinMoney = "0";
                    }else{
                        jobMaxMoney = strings[2].split("-")[1];
                    }
                    String jobEducation = " ";
                    String jobAdrees = " ";
                    if (strings[3].charAt(0) == '/'){
                        jobEducation = strings[3];
                    }else{
                        jobAdrees = strings[3];
                    }
                    if (strings[4].length() > 1){
                        jobEducation = strings[4];
                    }
                    String jobSource = "中华英才网";
                    String jobTime = strings[9];

                    Job job = new Job();
                    job.setJobName(jobName);
                    job.setJobAddress(jobAdrees);
                    job.setJobEducation(jobEducation);
                    job.setJobTime(jobTime);
                    job.setJobSource(jobSource);
                    job.setJobNarration(jobNarration);
                    job.setJobType("全职");
                    jobList.add(job);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (jobList == null){
                return;
            }
            jobMapper.insertJobByJsoup(jobList);
        }

    }





}


class JsoupThread implements Runnable{


    @Override
    public void run() {
        new ScheduledJsoup().ChinaHrJsoup();
    }

}
