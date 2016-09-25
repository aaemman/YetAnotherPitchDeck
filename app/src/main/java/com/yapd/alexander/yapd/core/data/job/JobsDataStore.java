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
        job.setDescription("• Lead development of the Skillshare Android application using Test Driven Development.\n\n" +
                "• Worked with the Director of Mobile and representatives from google to get the Skillshare Android app featured in the Google Play Store twice in 2 months, resulting in an additional 15,000 downloads\n\n" +
                "• Designed and developed Skillshare’s internal Java SDK\n\n" +
                "• Aided in the hiring and product management processes of the Android development team");
        job.setStartDate("2015");
        job.setEndDate("Current");
        job.setTitle("Software Engineer - Android");
        return job;
    }

    private Company createSkillshareCompany() {
        Company skillshare = new Company();
        skillshare.setName("Skillshare");
        skillshare.setDescription("Skillshare is a learning community for creators. Skillshare's mission is to provide the world with access to high-quality learning. Anyone can take online classes, watch video lessons, create projects, and even teach a class themselves.");
        skillshare.setLocation("210 Elizabeth Street, New York, NY, USA 10012");
        skillshare.setWebsiteUrl("http://www.skillshare.com");
        skillshare.setLogoUrl("https://pbs.twimg.com/profile_images/1474879083/twitter_400x400.png");
        skillshare.setFeaturedImageUrls(createSkillshareFeaturedImageUrlArray());
        return skillshare;
    }

    private List<String> createSkillshareFeaturedImageUrlArray() {
        List<String> urls = new ArrayList<>();
        urls.add("https://lh3.googleusercontent.com/D818ouPHrz0IqLGhw-8b3l2DUvPPy6xYvT5DxW07rjumepspM-c3IwVXVM2tJucmLRo=h900-rw");
        urls.add("https://lh3.googleusercontent.com/tj6Ug78synVFd0hiRzxenPxEi025ORl0yusMVYEc9Sf3cZVHn36aJT2euLDwULeG34gM=h900-rw");
        urls.add("https://lh3.googleusercontent.com/_ZHZlAY9TlygUtDY_fcekypDvbKyPLWYOwJs8im9q-fVfOrTOb8z3-oYXHzDN6TY8oY=h900-rw");
        urls.add("https://lh3.googleusercontent.com/KVN0Nmtz0-tJBNiGhZuCPRRAw4jZAe4g0WclJZaMarrUfL_XYDnelVXPxgZtectN6w=h900-rw");
        urls.add("https://lh3.googleusercontent.com/sWc9rEAZJYugr0uoNi-r52EQVDAFTDcn27HrVWYCi5AHl1f9aWqt5cwTb0TsddxzG-E=h900-rw");
        return urls;
    }

    private Job createVTSJob() {
        Job job = new Job();
        job.setCompany(createVTS());
        job.setDescription("• Architected and developed the first iteration of the VTS Android application using Test Driven Development in 50% of the initial projected time\n\n" +
                "• Worked closely with the product & management teams in order to ensure that the our solution met all of the company's business needs\n\n" +
                "• Aided in creating the hiring and management processes for the Android development team");
        job.setStartDate("2014");
        job.setEndDate("2015");
        job.setTitle("Software Engineer - Android");
        return job;
    }

    private Company createVTS() {
        Company vts = new Company();
        vts.setName("VTS");
        vts.setDescription("VTS is a commercial leasing and asset management platform for landlords and brokerages currently being used to manage 2.7+ billion square feet of real estate and is being used by over 80 percent of the top 10 global investment managers.");
        vts.setLocation("142 W 36th Street, New York, NY, USA 10018");
        vts.setWebsiteUrl("http://www.vts.com");
        vts.setLogoUrl("https://lh3.googleusercontent.com/CEbaXbbLLW4KK_xMwCY07Ph3K3IumnYdnuw_FSXrvG3w2AJdlwSjkQaS0gqw-Lc=w300-rw");
        vts.setFeaturedImageUrls(createVTSFeaturedImageUrlArray());
        return vts;
    }

    private List<String> createVTSFeaturedImageUrlArray() {
        List<String> urls = new ArrayList<>();
        urls.add("https://lh3.googleusercontent.com/iM0j1XFU52MAW6iZ_6IwiWkrsIpOKF9m_qoIALhNR_Z-YN0RVq2G2RBQMWMrXKXJpvY=h900-rw");
        urls.add("https://lh3.googleusercontent.com/0E5RdlldIhkWR-1zY2ktk3FgVB9DkNi4D52qVrwObVKJFuUApFRb-TwniYrnSASVDw=h900-rw");
        urls.add("https://lh3.googleusercontent.com/ajpD_E2FGPwPZ2nR8cbUUDGKAVAWsMS2oIgMvm8glQzKVz_V3x_NHg1AHsWCp4IZ3Q8=h900-rw");
        urls.add("https://lh3.googleusercontent.com/14GoAqMAX8tlWhaYck9jpJr16NvYvNb7a4TBTAz7JHU739Brp2ZNF9R5qr0IzKE5MT4=h900-rw");
        return urls;
    }

    private Job createSynacorJob() {
        Job job = new Job();
        job.setCompany(createSynacor());
        job.setDescription("• Collaborated with a multidisciplinary team to create mobile applications and digital products (including mobile, tablet and TV) for Fortune 100 & 500 clients");
        job.setStartDate("2014");
        job.setEndDate("2014");
        job.setTitle("Software Engineer - Android");
        return job;
    }

    private Company createSynacor() {
        Company synacor = new Company();
        synacor.setName("Synacor");
        synacor.setDescription("Synacor is the creator of a proprietary Android Customization Development Platform, an award-winning mobile product development company focused on merging design and technology to create transformative user experiences on a variety of connected devices.");
        synacor.setLocation("5M3, 55 Murray St #500, Ottawa, ON K1N, Canada");
        synacor.setWebsiteUrl("http://www.synacor.com");
        synacor.setLogoUrl("https://pbs.twimg.com/profile_images/1233125274/tek11_logo.jpg");
        synacor.setFeaturedImageUrls(createSynacorFeaturedImageUrlArray());
        return synacor;
    }

    private List<String> createSynacorFeaturedImageUrlArray() {
        List<String> urls = new ArrayList<>();
        urls.add("http://cdn.redmondpie.com/wp-content/uploads/2013/04/Chameleon-Launcher-Nexus-4.png");
        urls.add("http://www.teknision.com/wp-content/uploads/phone_tablet_2.png");
        urls.add("http://www.teknision.com/wp-content/uploads/tablet_group.png");
        urls.add("http://a9droid.com/wp-content/uploads/2016/02/Chameleon-Launcher.png");
        return urls;
    }

    private Job createKwiltJob() {
        Job job = new Job();
        job.setCompany(createKwilt());
        job.setDescription(null);
        job.setStartDate("2013");
        job.setEndDate("2014");
        job.setTitle("Junior Mobile Application Developer");
        return job;
    }

    private Company createKwilt() {
        Company kwilt = new Company();
        kwilt.setName("Kwilt");
        kwilt.setDescription("Kwilt is a photo management application that gives you easy access to all of your photos on the web, no matter where you saved them. Kilt gives you total control over yout photos by bringing together, all the memories that matter to you the most, whenever you need them.");
        kwilt.setLocation("283 Dalhousie St, Ottawa, ON K1N 7E5, Canada");
        kwilt.setWebsiteUrl("http://www.kwiltapp.com");
        kwilt.setLogoUrl("https://media.licdn.com/mpr/mpr/shrink_200_200/AAEAAQAAAAAAAAjKAAAAJDYzZWUxYzg1LWI0ZDEtNGVlNS04ZWMwLWE4ZGYyODQ0OGE3Mw.png");
        kwilt.setFeaturedImageUrls(createKwiltFeaturedImageUrlArray());
        return kwilt;
    }

    private List<String> createKwiltFeaturedImageUrlArray() {
        List<String> urls = new ArrayList<>();
        urls.add("https://lh3.googleusercontent.com/zqgo7rPX6uMeiN0NA4jzTHN5eoIrMaXZtthRRnNRGg_Ll4wtq7ImDU0jtHALbAaT-0k=h900-rw");
        urls.add("https://lh3.googleusercontent.com/OAtNiGl4ViKEf-gMBmFTr5Q-HVVdmt68gFaxjEVuWayPLJYkmzNNGofM_FnuT2h1VME=h900-rw");
        urls.add("https://lh3.googleusercontent.com/sE4hQIqY1lScGFUFXgnGyyxN6ulfesu_tLGONWU8jAiFHuFyCrCBRqeMXB4ys3E7TUcR=h900-rw");
        urls.add("https://lh3.googleusercontent.com/QsjylBDagfqkWVEZz5rd3aQxp93pTrImy57u1bMutsN9JJBZI95k4F_QoP1MemMBN50=h900-rw");
        urls.add("https://lh3.googleusercontent.com/p4sDELga2bY5_JH8hWTfHLjFXy1HCmnXJ4j1Snq_nAUYKgQNColB2jyGbdfV_Yoz0Mgx=h900-rw");
        return urls;
    }


    private Job createMBSJob() {
        Job job = new Job();
        job.setCompany(createMBS());
        job.setDescription(null);
        job.setStartDate("2012");
        job.setEndDate("2012");
        job.setTitle("Android Product Developer");
        return job;
    }

    private Company createMBS() {
        Company mbs = new Company();
        mbs.setName("Magnetic Bear Studios");
        mbs.setDescription("Magnetic Bear Studios is a digital agency based in Ottawa Canada which aims to create beautiful and delightful products");
        mbs.setLocation("185 Rideau St, Ottawa, ON K1N 9P1, Canada");
        mbs.setWebsiteUrl("http://www.magneticbear.com");
        mbs.setLogoUrl("http://magneticbear.com/images/mbs.png");
        return mbs;
    }
}
