package com.yapd.alexander.yapd.core.data.job;

import com.yapd.alexander.yapd.core.model.Company;
import com.yapd.alexander.yapd.core.model.Job;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Created by alexander on 9/22/16.s
 */
public class JobsDataStore implements JobsDataSource {
    @Override
    public Observable<List<Job>> index() {
        return Observable.defer(() -> Observable.just(createJobsList()));
    }

    private List<Job> createJobsList() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(createSkillshareJob());
        jobs.add(createVTSJob());
        jobs.add(createSynacorJob());
        jobs.add(createKwiltJob());
        jobs.add(createMBSJob());
        return jobs;
    }

    private Job createSkillshareJob() {
        Job job = new Job();
        job.setCompany(createSkillshareCompany());
        job.setDescription("- Lead development of the Skillshare Android application using Test Driven Development.\n\n" +
                "- Worked with the Director of Mobile and representatives from google to get the Skillshare Android app featured in the Google Play Store twice in 2 months, resulting in an additional 15,000 downloads\n\n" +
                "- Designed and developed Skillshare’s internal Java SDK\n\n" +
                "- Aided in the hiring and product management processes of the Android development team");
        job.setStartDate("2015");
        job.setEndDate("Current");
        job.setTitle("Software Engineer - Android");
        return job;
    }

    private Company createSkillshareCompany() {
        Company skillshare = new Company();
        skillshare.setName("Skillshare");
        skillshare.setDescription("Skillshare is a learning community for creators. Skillshare's mission is to provide the world with access to high-quality learning. Anyone can take online classes, watch video lessons, create projects, and even teach a class themselves. We believe that everyone is creative, and that giving people tools to harness their creative power has the potential to change lives for the better. Not creativity defined as an artist but creativity defined as a mindset, as a mental toolkit, as a set of building blocks, as a way of solving problems, and as a means to live a more interesting life.");
        skillshare.setLocation("210 Elizabeth Street, New York, NY, USA 10012");
        skillshare.setWebsiteUrl("www.skillshare.com");
        skillshare.setLogoUrl("https://pbs.twimg.com/profile_images/1474879083/twitter_400x400.png");
        return skillshare;
    }

    private Job createVTSJob() {
        Job job = new Job();
        job.setCompany(createVTS());
        job.setStartDate("2014");
        job.setEndDate("2015");
        job.setTitle("Software Engineer - Android");
        return job;
    }

    private Company createVTS() {
        Company vts = new Company();
        vts.setName("VTS");
        vts.setDescription("VTS is a commercial leasing and asset management platform for landlords and brokerages. Using VTS, landlords can track leasing trends across their buildings, track negotiations, and monitor their marketing performance, among other things. Similarly, brokers can use the company’s tools to manage their own leasing pipelines, while tenant reps can manage their workflow on the platform, too. VTS’s services are currently being used to manage 2.7+ billion square feet of real estate and is being used by over 80 percent of the top 10 global investment managers");
        vts.setLocation("142 W 36th Street, New York, NY, USA 10018");
        vts.setWebsiteUrl("www.vts.com");
        vts.setLogoUrl("https://lh3.googleusercontent.com/CEbaXbbLLW4KK_xMwCY07Ph3K3IumnYdnuw_FSXrvG3w2AJdlwSjkQaS0gqw-Lc=w300-rw");
        return vts;
    }

    private Job createSynacorJob() {
        Job job = new Job();
        job.setCompany(createSynacor());
        job.setStartDate("2014");
        job.setEndDate("2014");
        job.setTitle("Software Engineer - Android");
        return job;
    }

    private Company createSynacor() {
        Company synacor = new Company();
        synacor.setName("Synacor");
        synacor.setDescription("Synacor is the creator of a proprietary Android Customization Development Platform, an award-winning mobile product development company focused on merging design and technology to create transformative user experiences on a variety of connected devices. Synacor’s technology has the ability to make any device a smart device.");
        synacor.setLocation("5M3, 55 Murray St #500, Ottawa, ON K1N, Canada");
        synacor.setWebsiteUrl("www.synacor.com");
        synacor.setLogoUrl("https://pbs.twimg.com/profile_images/1233125274/tek11_logo.jpg");
        return synacor;
    }

    private Job createKwiltJob() {
        Job job = new Job();
        job.setCompany(createKwilt());
        job.setStartDate("2013");
        job.setEndDate("2014");
        job.setTitle("Junior Mobile Application Developer");
        return job;
    }

    private Company createKwilt() {
        Company kwilt = new Company();
        kwilt.setName("Kwilt");
        kwilt.setDescription("Kwilt is your photo gallery on steroids! Easily the only app you’ll ever need for photo organization, sharing and editing. Kwilt gives you easy access to all of your photos on the web, no matter where you saved them. Kilt gives you total control over yout photos by bringing together, all the memories that matter to you the most, whenever you need them.");
        kwilt.setLocation("283 Dalhousie St, Ottawa, ON K1N 7E5, Canada");
        kwilt.setWebsiteUrl("http://www.kwiltapp.com");
        kwilt.setLogoUrl("https://media.licdn.com/mpr/mpr/shrink_200_200/AAEAAQAAAAAAAAjKAAAAJDYzZWUxYzg1LWI0ZDEtNGVlNS04ZWMwLWE4ZGYyODQ0OGE3Mw.png");
        return kwilt;
    }

    private Job createMBSJob() {
        Job job = new Job();
        job.setCompany(createMBS());
        job.setStartDate("2012");
        job.setEndDate("2012");
        job.setTitle("Junior Mobile Application Developer");
        return job;
    }

    private Company createMBS() {
        Company mbs = new Company();
        mbs.setName("Magnetic Bear Studios");
        mbs.setDescription("Magnetic Bear Studios is a digital agency based in Ottawa Canada which aims to create beautiful and delightful products");
        mbs.setLocation("185 Rideau St, Ottawa, ON K1N 9P1, Canada");
        mbs.setWebsiteUrl("http://magneticbear.com");
        mbs.setLogoUrl("http://magneticbear.com/images/mbs.png");
        return mbs;
    }
}
