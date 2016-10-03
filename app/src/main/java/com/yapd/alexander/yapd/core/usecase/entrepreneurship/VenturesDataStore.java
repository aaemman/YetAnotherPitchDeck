package com.yapd.alexander.yapd.core.usecase.entrepreneurship;

import com.yapd.alexander.yapd.core.model.Company;
import com.yapd.alexander.yapd.core.model.Venture;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Created by alexander on 9/25/16.
 */
public class VenturesDataStore implements VenturesDataSource {
    @Override
    public Observable<List<Venture>> index() {
        return Observable.defer(() -> Observable.just(createVenturesList()));
    }

    private List<Venture> createVenturesList() {
        List<Venture> ventures = new ArrayList<>();
        ventures.add(createStudyRoomVenture());
        ventures.add(createDropChatVenture());
        ventures.add(createAmalexPropertiesVenture());
        ventures.add(createMyFirstBusinessVenture());
        return ventures;
    }

    private Venture createStudyRoomVenture() {
        Venture venture = new Venture();
        venture.setCompany(createStudyRoom());
        venture.setDescription("I came up with an innovative idea to leverage mobile technology, data visualization and natural language processing to help enable classroom communication at universities. I mobilized a team of 3 engineers to develop and rollout the platform in a local university");
        venture.setProblem("• In the STEM (Science Technology Engineering and Mathematics) community, students are often reluctant to seek help publicly when experiencing academic difficulties due to potential embarrassment. This causes students to slip further behind creating a negative feedback cycle.\n" +
                "• At the same time, professors have little to no real-time insight into their students’ comprehension of the material being taught and only learn about their difficulties after tests and exams have been administered; at this point they can do little to nothing to help the students.");
        venture.setSolution("• As a team of four engineers, we created Study Room, a gamified question and answer system which allows anonymous communication between students, while simultaneously providing professors with real-time, high level metrics about their student’s knowledge state regarding class material.");
        venture.setMonetization("• Study Room was a SaaS platform for universities; universities pay a fixed monthly rate, based on the number of students using the system. The software would be managed and distributed by the universities themselves.");
        venture.setLesson("• Despite the huge interest from academia, the student body was still hesitant to use a tool seen to be academically driven and not independent of the university. This taught us a lot about the importance of product market fit and how distribution channels can play a key role in the branding of a product.");
        return venture;
    }

    private Company createStudyRoom() {
        Company studyRoom = new Company();
        studyRoom.setName("StudyRoom");
        studyRoom.setDescription("StudyRoom is a mobile first, gamified question and answer platform for the classroom for use by professors and students.");
        studyRoom.setLocation("Ottawa, ON, Canada");
        studyRoom.setWebsiteUrl(null);
        studyRoom.setLogoUrl("https://lh3.ggpht.com/l8dr0YOI9XoqJKg--niERGSs5xOrNu6nRuu8phUDeQiWE51DyCRpV58ZJLRoKv2uPVg=w300");
        studyRoom.setFeaturedImageUrls(createStudyRoomFeaturedImageUrlArray());
        studyRoom.setTags(createSkillshareTagsArray());
        return studyRoom;
    }

    private List<String> createStudyRoomFeaturedImageUrlArray() {
        List<String> urls = new ArrayList<>();
        urls.add("https://lh3.googleusercontent.com/Ual-B7WeGzcUsKMRCdfIFutj_yc2W8t1zwlUWZCTW1kvTsroiT7QCXm6cOt6EU4-J8SLIabNMxg9_nkHMGR1V4Rih8HfdPrQ9l7-yZHUjH5rjK0X1l6NB83xQvt5khCWjca-NetTBCLSH808tivxogEwkkkRm7JoLjgJxVCR8mYi6mpg3_0NMK0VsEnOmY_CranLVridPQadAdkSfCECP1zKVxgp9XNmapR7Fc1VF-BRSmDJzbJTDHe6c5mxj6L9OF9LXp2zlte7Biej29kh3I2IUCmHpGvbuc2KqEkphmD7z1_mEDU1NZvRnGXPzR-irce44kmUz-vKJfN__kOb66roWM5X6LNuilJ73yVq-4VLGI-EYUJQ_BQe0bmF-8t_QZnAVRAIdJtOqz0ZiNl_85Dq61ifwT0uCQh4x8JTmnwlaY1L-e_5hpmB25HWAVGjtwGO7c-EwfLP5-L1PCZAwHow7sY0FYQs4Up2qV9aZIyhb59Cb4mmGmXceGS7K8dfdrrEKUlJJKy05PO2Xy0ljB7PdsaeeEOHVLYCqjR8oO7XMKmdUmL6bwBmyxyLUxSe1VMFeZun0irk378M0BTWoZJa0KB-4oRjAuxfj2tIG7ShOdC1rA=s838-w838-h530-no");
        urls.add("https://lh3.googleusercontent.com/2DzS18R18DDVsXIrXPPfITLGyhy4UybVZkTyTxHUTXZBSBv0QozFJSZFm36t0qpYPLx_4H4ObHj-YSSn0oCu3wFLBZromWF0XbtM5lIuzfS1EIZJaz1PDY68sqJyreci7anpERUQ17sIAkIV6ELWhzdmHftHK8V1zf4x1iSkJnfB_EwdiJelGZ6QAhTlAlujliXFiWK7F_3PCXrlNvtOro1c35oeck89bVVRTtIri1jDQnRgEhq1DiedWUooCIpH5ntNi8ZwotfG_2c1UNX3vODv8oE2TP1zBTDP9VL-HauOVuavMiY2pYYitppnliywtwAbR98RoTzP8T6LNbp5MkiiIxYFaAdwew-WNOAPVsT3PD_Tuisx0UdHGfBKGdFX5LqCy9k6-GBw4bFfNNDZXdBBWZIfqvgfEWQ5u41FCspr6P73QTQZ67R42KvEAKrMEuqBfDkDy_ixrgwUPPSvD2U5kPSFZyWQBbPD-3GNDxsO6P2IvkDi8D8iDGXhjINQu7xrtX4cPdxprZn3ujHnYHAQ-rui3-rP5K-wiaHS3UzoSS_zE44r-6zuGPbZ-ZDGoFvmx0Ia=s838-w838-h530-no");
        urls.add("https://lh3.googleusercontent.com/QxIfty7KtES-W-a6YsEVjUBQ-8NDP5lTLtb5vw4tJltC28kUx_5x3ICbVpxLBQQla1He9rz8Zj0pMi_Jm4tGHVOZCaDECpBZP6fqpOamxqXp-IL_fBBJYRSRXqU9KFl7NrmWpceavlUfRGahG7KubxjTFkazqA-jeeXD_FSxPu5p3YK5E8pGIruTy9KchdssEzu_xeqXZqiMNAMq4uMvudDHkouFExHN0yAhOqZmGUw_nVT6N90MWCF3LzeJD6DidSC_4YiKWVJysMy1gROflFfW6sOzJnDDlzu-fGlXg0xo7CDfG1jyJlZGR-EV3zIW7wu7gJ44gB5HWOoLzhpxrojIm3hOPV0w7C0A5VGVeWsg1fdbLbyEVTzSegQ4Ec3fUzbnIHv1FyqW8ACEss-LjInzLcz5nmqLW_hbpnFSL0EK3xPTrzhTIAKv99DVQldQyiivUuIrrkAcVVrZUOwYZXXE8PmoP16oYkfLTovs1tqJGzn57zpBr9BY4-RzK6jKXIHIGlCy5HaDFynHRk0SulP0geNquRWDLEWR1RHaw2gTjChWS92ZBNX_iAyOkF2xT1g2aIEP=s838-w838-h530-no");
        urls.add("https://lh3.googleusercontent.com/IA-tnx-Br8NnoDOOnmqIpSE1u8olyVprsgLbg6S_uwTfAy4uKMCJ7WyU-zKYuTT0o5OEFGvmO267CssAFYPulE6w-Jk8O6-5nyUPnMQJilyIdFwAvTRU0M2zzyuxvUrAR1l_X29A3GGvsnPTQE_Z0lzXReV9q4ioGFYOPJRq9C9Dpa0ZhlhtzPVFmMSJcvvhvy6yTOwPRsgI3Dol2LlQwZkRr9YkwQwsxc3lAqQZuTwmsNK6DNwFWZZTJNM4bvKaxhrCBD7zPRMn_rcPdbywUeVVNg6xvi-g--RYWBLHCarjzAwpr3UVtrpCBKYXSn1cQuJ_FjfEUpsEyCRoxe7veWQDbXkf4U6cMv8KAz7ggk5UGODYRFWMJ9VMAF6WKxzVo1pETH6OYxajYAcOcS3yqcpr_o0CzcB6vBFntSqIyRIm67u34hndtVpeznkwl5ZB1GJBZfcO7Ci0mmadWNaGATqnCVnSxLlSOUAjEeaGh2Vk8oqY1Dhd6u55fqsGSzJciHpfrzXOOrh8p4SY8MCT-Eht1-UNO5dg1A-OVbiFAIXAghudviWfedYJHKNGpQlOxMoDb_Yv=s838-w838-h530-no");
        urls.add("https://lh3.googleusercontent.com/9kKOFOhoAD4lqdWWnZfgmZq0P7P4c_eD4h5OCFWRmDGDI9D_EmhZjiwKGH3qz1SMbCTRp3GngDb4QFfasd7ncgguzpBtak6uQdobbd5HVr7xitRvB35DBckPcjXhstwa1E3lFKdqW0JN3mZENgTVRdulyKVzSZSFd9--53LPCSo4jabijov1Z63j5qoDBQYsru-_t2eQDm0FHPR5OeEJSvAZwt8qsi4Tuh5XUtcbZmXO8XTnEdRlznLqrWDb7Rc7sZF2tjXc5fxdIjJe-Sa1Ub8q4TwJeD1TntfrnzKdVeVsDq3Yc1-GUoJpwYZkWntex0cLNs8JweODC2rSneAn2D_WRVDyb1S0E8aTnkymqrw6Eno_XVTOtn3e9W96_oCZ6isNp2tJY83Q3uWUxeJZKJ8LzLBFWaCGB25QXN_oOEQiO3t4wz255fjEhT6k50TGodD-C6kcmqKwKSHMbTp1qQFfI_NBygkAV9eBOmzRiGE_P6o3OwDMIZVRSUVn1ZKlv6YpS0qWo6h2QKJOvFK1g8NEakiWFt3bGyZ9CpkCn2I6-7jSDbMgNzDc_dTrtrXJqdyAdjmKTbV4SL7-qQcpUVRNV_G5z3iJKyCKW_dVq2WhL-v7xQ=s838-w838-h530-no");
        urls.add("https://lh3.googleusercontent.com/Dlmh3rhdWWCOJw0eOecNda_XHbgItqQOsmpVjlFaok6u2wmt-RqXr-_UdxY7T1Oq4xvAQWJ_hiey7f9Vh7_9RFivJfZV8mb22za-67msjfetsJFs81IESAHAxi-h3grbfD-ZM5CETohYzhj1MA6DDU270xk4IHjJ9LGU4N7H_73fs9eMQ97pikYsKlpiBa75HWHhYChWKn4W7rGGys3TcYa9vXkb6Hab60XAZaTqgrjGf_CNUjBfVaQD8FBhWabzvkU-pD4S37PaHKKADOUV8qyEjDABB9UY0ji27w96-DN1m3yxxuPKNrOKo-VTE0GPOXRoZawQuYwoAwgZQGk58ApHEy2gzQ7KIzMAAGIqUxmKOW63BJ2VDeQZfpaAK6OlwMWAXF-NwihwkIN_uO26WrHQx3opXUGJHK4AzEFAvVcYaL2VNFp_2b9goQOc6mCR_8IiFS4u1j0uNVJxXHG1qCSiGLsKmsw9nwEFS3KctBdmyv12_zq1SAuIqy2mMeKH8hiOqvKP8W97TC8zSvqmAhpl9lA8dbYVf_LoT_RLdrMOLXJCpkvlKQah2KgAvGOhA4ssrs6c5VWEOWWVuGZTndg6114l_ynL8f6d3Sz0ISXCY4kI7w=s838-w838-h530-no");
        urls.add("https://lh3.googleusercontent.com/_aorSt47Ryj9s1vVBg2ey_wwemR7gf2BmIWXQxy9jET_wJwqoeGbG1Lsa9FeZX1QWxtn-gQ-9zlMIg1twAQhoFGBlb1gHIKMn8P8B9RezeCx_9Sv1XyOWIfPNHes5R1q3PLg2d3Wq8HnnXB_KvYBi6_G5e07HL6ndMOrPUsjdM_vYp04Hej8_sppF70V_jIkbfo6rIXd8PItUDpkZUTX_YHuDvzQBVDWNzkcKLoOKkY5g_Y_BRsb2Oy1q9OBgC2YACLnTYSci4V7Z9M40k57ZChVNDsMXsTaBjVhJE6aiclEg0tuA2AV4lRvOqtWG-kMbCe2w8FQyE2YQWg2oOiteIixpqjd1jX89C5-zOMyM9jzkF_9f2rc8TFagWZkbSR_mqem5szXYnRi_GPQTwkygJYXX9NPekGnV9ztZ2dBZA0u_4ujtSGtj7O5penLVQw6Hrzs2aO2_x0gKq7IdJExlURIpnuM6FW3PdOY7AQINduCqdqaVaK-wg9QSXuUNv6keRpOGa37sR9KHHQFSiUM1A6j4YNBgTs9gB4YsIpWDRhmV-fkb1eoMehJbTaquraocL2HNLODrMIII6CSxxhHyECxiwJGPH6PcYztxBdNs_shA8cefg=s838-w838-h530-no");
        urls.add("https://lh3.googleusercontent.com/7QTIu_9pZphC6Tq2vp-KIEvRYmxgFhHvBcLPHYmwpZn6nbWC3IXtSC5oXpfVJixU_KeEoiT9G6vl15OeIjl9geBwYue_cC-ZkBsGPyb3UAcmfcxa78lvTE2GYgYVTjnBgkQ_J5a9eNbqxdG9Cl0LHaYmaeXuQZnC7GuGmBC-0WkhSd8Zu5sjcdfGb8b5cyDFWt463T6SPHwEgD1Kgjt9e9HMdXKJQR7Y4mf6xZrTQCddXzUrDpwM09jNEjFndMKQ3WJ5x-JqYVRth5EqnRL_k0ddS7HW6onmZPBREPJMsE_EA9kNRCvJxGJNNTUmh-VdaHg-MTv-dOYMYRD5p1CkuaMti-nbxez9998FzIwpwVAxcbg57TlqEYheq0P3gfeSm6lzDNqG3LOTOWMw_wIMQvP-FhUvzSKjI84AqrBfE6i6LYW1Xi1fuYr2zArshNCEEVbIL9s4cGmPCLB49MAcW2tWvYyPfHc8whDrTGT2iwzofls5wA3butrgOjzdcGDToheF3GiuQS13DyxjJVTNB9e7JKDniR195dSU732bSOEdd77VQm225Nx5c2a9D_hFX58eU20I=s838-w838-h530-no");
        urls.add("https://lh3.googleusercontent.com/Og5hkEaBodigAV-wS4jjWuRX_IcgLEXYOwXASyMKn-P9jHNL2pgiSTPrS78cbKCa_7FssDZ7jmtIIXj4_U6XAbyTK9NKy1bmn1_UiZpWRVwbrlrnpNlZzLt0bFoIzs1ZXSFDcclP0nxAXk5USGxukz6HRqGDfgh-1iLyKSMOCqZR1xIKULz0p6upyFDeAJeIUkE9CVUX98k2XK3Xz1PxNOT3_HRznCJTot-gJ2UEgV9SEXEK9crq4qHEUdmvW-oPGl64pjXkbh6Cpw8JclpHoEd1UEAZ6FPKxhnnDiA4Yp7KePueiGsqINHUC8t6egziIvH0jVDxAzBE74DGDXOa7l5UhRbN3LurCqQWu2W51s8E2-FBST11YqZZLw9jF1Sb2WGXuld-a23c7e0GIDT7QwfRfrgmTK2RNZTLyRlJYHpl2p-derZC8jIvSAM0cunEIZNsnRNFIp9Z7swpaFvG7PtXwUbJNfPps0ofFGanpyqcPWALBHzPRAvzIAQEBfz49d9S1NBfb5ZN8Hk8NvMBCGcOFL1W_rG6xqOrjSu_9Qa615_8uSTURMyvPix9aExKWlzpC_Fc=s838-w838-h530-no");
        urls.add("https://lh3.googleusercontent.com/9zkIbvQvg74vALz7g2Ga-EqALoDxNPE9Wmi3IR3Biy41U73Bf4ERk1shmZZGMk73bN8-P78uu0Vcs4mtooqURQjKp87kKWvxNTHGDOPUNFmbg4hgWWAxm0gNPfs1_5cUTlGR5ACz0-hwR9IAcsC9S-8NRi2c3dvvrzw5wKr2hmHmveb15roDJyru4DAfYTVmkoiQSP2P4Bi7itAW_CA3HkWuLgCSOH6fWQOba7S5N4IAlAspPRI_Ripe4mFhcFfIcEWstzaMs363pNo5L56iRP0rcFUT8ACUux5r_ZKcsXXsam5u7YyiPkFpAUa3WgHw6LegItQVANCDtaLV3Vbz16ohxFsqWkP_kbifnszWvV1mv7PNKOutqA9N5wh2IGdxKRMoVGF_mvqf4i5_c6ZEsADFaed2WTBPg2pYrjhEKqt8OxMoYVsXHxLhRFX2R9V55TXj8ckgTI8RTB13coInsOJWyy0ux1gfAVz1hIbWusstN0LfNpogKMjAvamJ3-AMJ8pdvSEAQKB2ZNaiHN6oD-k9POXCP9Gk5OQv1FCIQt5LZ7nEq9Bdp7Rh_h0EREV7f53Bc4ut=s838-w838-h530-no");
        return urls;
    }

    private List<String> createSkillshareTagsArray() {
        List<String> tags = new ArrayList<>();
        tags.add("#MobileFirst");
        tags.add("#Education");
        tags.add("#Gamification");
        tags.add("#Enterprise");
        tags.add("#DataVisualization");
        return tags;
    }

    private Venture createDropChatVenture() {
        Venture venture = new Venture();
        venture.setCompany(createDropChat());
        venture.setDescription("I partnered with another engineer to create a hyperlocal social platform which leveraged a user’s location in order to surface content that was relevant to them. Our platform also allowed enterprises to show contextually relevant location based advertisements these users. This approach was considered cutting edge at the time and was a problem that several companies were trying to solve, this approach has now been used by Pokemon Go, the fastest growing mobile application in history.");
        venture.setProblem("• DropChat aimed to help users gain contextual information about the world around them. Social feeds on sites like twitter and facebook at the time simply showed posts chronologically as they were posted and we felt that a lot of the time this information wasn’t as relevant to my current situation as it could have been.");
        venture.setSolution("• As a team, we created DropChat: a social platform which used your location to surface information posted by people you follow. On DropChat there are two types of content: public and private drops. Public drops would be viewable by anyone that follows you when they were within one mile of the location you posted it; and private drops had a specific recipient, and only that person would be able to see the content. By limiting the content a user could see to only what was posted nearby, posts could be filtered to be only what was contextually relevant at that time.");
        venture.setMonetization("• DropChat’s monetization strategy was centered around location based advertising and discounts. In this strategy, enterprise customers would rent a piece of virtual real estate within DropChat when a user was physically located in that area, the user would see advertisements from said enterprise customer at the top of their feed.");
        venture.setLesson("• When building DropChat we learned about the product development process and the value of early in-depth user research. Had we done said research when initially developing DropChat, we would have known that seeding initial content onto social platforms is extremely difficult, especially when that content is filtered to such a granular detail.");
        return venture;
    }

    private Company createDropChat() {
        Company dropChat = new Company();
        dropChat.setName("Drop Chat");
        dropChat.setDescription("DropChat is a social platform which lets users and businesses “drop” location- based messages for people nearby");
        dropChat.setLocation("Ottawa, ON, Canada");
        dropChat.setWebsiteUrl(null);
        dropChat.setLogoUrl("");
        dropChat.setFeaturedImageUrls(createDropChatFeaturedImageUrlArray());
        dropChat.setTags(createDropChatTagsArray());
        return dropChat;
    }


    private List<String> createDropChatFeaturedImageUrlArray() {
        List<String> urls = new ArrayList<>();
        urls.add("https://lh3.googleusercontent.com/8Gm17tOWkNAiJ3La7OYNb4lBdsbUn7_bQpanhWwAHdj3ibSzx1RlpLZ7VfJ5dtLMLaJUPJqnCJnMMA=w480-h265-no");
        urls.add("https://lh3.googleusercontent.com/T7rBOJA83jpzaG6trccTWH-gIAsMjjjqU7T3TMI19Ble_tIkUDkTdDwMPehr2pKxPw7F9jVFz7yja5R-N-wn7tmlc9row6uUC9O5yHH5yFfEoGB89MRQh3h14_asmohjjwO0BTLGflZyqyRx3W0TRjy6mXrUI6RLb_DVt6tkzCL6ZHMq_iUVjtaAfh5hJYSrlCB0ZY1QPK4qVhoRXUrTxAbjapaOsDgm181JLrqalPa6tKW0GI_gjGj0vkQZUtQFRAvzZQ5tnK2m6c65hBTB49HEjm7FPiJu6ZsOx6kj0jHgIKEsVOVh8Ks7f6MkE94y2YRGv2rEBEIJvh5EgUoxyclarmn8apK38o1uNQdh9TfpNb2O7iTR1TLZogYToAmYdM0fJ_E-hk9pSXZR8ZoVywZl7_uHlJrkHG9v-3IYw6vsM8SFCGAzCSIZtCpns1VBwAQ-aN_woP3njZeVhizcB4kOfLlORqwIXvsCPFyM0CeKnJYc5SVyGoOb93nDLE3ikwGydd4AYnWhqNqja0j22PGmNBMMi-FwAMK-J_taK91bRlSX_RGdcxHqoNv4w9-0Fpv0iUz2=s838-w838-h530-no");
        urls.add("https://lh3.googleusercontent.com/JBD3Lz6sLOzMABe38VyX6djRwTlaVScyeX65zxb5iUMcRmlM9R0Wu2wAB5D8QVpFE_Wb1lBlgDGVDOJLKdfJv5mTrfr2SqmwR8SxnXQp_U3n5Rh7zLcto6IVdnCtpjgfcNUr8eLWlbkIRTM97F0EtbfeUKLkd1VTaDT87EPCNnfkHM6SgQa3bZl41dgS9WMnUOIRavHbs5U2-tcm2538aFGb8i_4Ry9HgpG6Uy6VsG-9msRETWAXssqxCnaK0TxwF1gqg77VMIbpUjYd0plS9gbWPU-BEtritgVA57IbPwujX3BzLNMsqPTloXiVZq0xdQ6yaP4upOKeOoAuMOwtYOmtNkW1HwANuQaOxLtILFImMoh71EMpk54G7FjAny8ePGwlJ9spdmZOQZz0xmoXUKWenisvnuYqxXRlvTAmlrhQ3ntmsjp5IEeoIidEAFp58JTvjRTZK_l77YU00zxNB7o-Ehb4arPALgFRvfj3U8AIhtj3ebmnbyWQ-9oczRtHVJbyeFNBPN0tAw-VXzFwMM8CglNJQ4bVeGHQ6IkDVOg5OlG5LYJvZC87htcRu4gyruO7iD72=s838-w838-h530-no");
        urls.add("https://lh3.googleusercontent.com/I2wk3pAYnF0Ak2P8UPVf-iXph8IUKfpnFVfGcFXPbFnFoYoi48lazTcfOg4H2g0b8ZFtv1ojoGLd9RQUh2_R_UcJ_vpTxIHB9kTmkIVNXE8IUQgfqKnHFGw1Jab6P32C9A1o59D4Oqwd2k4no5654PLHwQS_vDCU7gY6v_7_8dGup6m0FEDmcVl_yy0yTp0RRuHoxX1qpxfCoHexsL_mEf2tvWHnDrkWIg4dANG06yxXmOAfwpXjJ9OTRtSI8P4tlQd9Lpy6xRHUE8jHpMGc2j7c7SJDkWy_iNQfkXMQpbOLTzxLq_OKR6ssoGOW7b12nLrpL0VRYhEB9HG6bIQIYQmP6294YrojZbXjiPhlI2L51mp68aZTZAJXygrk6tzXBv9f3djIWxJaE-jpsIQIUyVVbfA4uBEdv3ijsZu8QYndz0QxbKLH0oip5jcyxU98GPgyinGkl3w_weGwys7Skic4vggru2LyM5ej4QmZrbFqrZ0s4Zk7LGDggSU1G4v9ZlYuNVuOuYAiH_7n-PLZDKU747VYOui6vi_JdaQVd8dWL8XqgQkWV_tBKglTBkRpCBAKmuGj=s838-w838-h530-no");
        urls.add("https://lh3.googleusercontent.com/u9cw05PGKeJ2HTxVklt1ammz7HzeSpZhDR7_qGumSXz49CYt2zoqjj1ADdSIJaPuWFAMp0fx1SLyTN1JDy-sO8bLXN3p4v9--OHVp1m6f8RPuL58pocCggfLY4gE7rlHAIHw2l-0FfBCyXtOQCNS6ckmardjBrc4z5XJvdGsF72O61Vh7GezIfDU6vN2lUzA3gF0CJvdlwezyxt-2R4s_yCdpQMzHSfiKo5W2F0G5Lse62FInvDxzdTUWKQC31lu96lmN2q5R7kFSuDCqWuJerc--6ccX6vyvC5GbQpyv8XQbm3riwDFQvlwH-sEm-hZ7J0JWSeW4saWE9O69aA7EX8FIwAL9Wp8liQsjf2vW__1NNWnG9lCvQKKpl2-vN56g9jE4LIYZ_bsTMElgfX3UnL92tXyeiw6Tido7Ghm0CZAAtugLs7UfkT-n8q51cUuIDOC8Q41JhQAa9g4MM72NVYrQssGuryg8Ngb0GF3BkEOzIX1dbrY0Y5Q6RkSnn8lj2UVKSACgEtFFCqSnlnTCg47lBQgjfwlEvexRwveUK9Nd4W6DRzO_YhUUEfopLpWRupqqdin=s838-w838-h530-no");
        urls.add("https://lh3.googleusercontent.com/oXJtVp3ptur0H_ploC4G_SjpJdrh7n1vbx_9VeAUG_tURUKzaewRUdexUktGefkio56HNnG4cy51unpz_1aH_5kC6LraHrSj_LG-BsiIfF7p8CqC7bRgm71MtSb_twDF5yBfHA73NozbKLQ0uZkDRRcykO9MsQS2mKyMj0ckznlUnyTLCBH-ASPcH14bRyzkxEIKylr4PuFn6Amu1kQwNF1fMmmeJBpAm3cZRwIkDYFCSgPFtmOW3JgK18WGE9L3eEw3AEGB-JhaTqNsN1MdoikY7r9BdD0xENz72FVc6GFDcyR37Z9Cb8YYyknvYqHiFYkcbzfj2u03vHhkYrbq2PvsMFdVhy9LtQQvfA0bl-zmRZ5MbKOjLrfL93qnFdso2PFiMoUv-nmhOpK3Aoxr42tUllHBQABbSdCNFXmT-0UwC04co5BYSfgsZKQObgomekIGB7UTJ1HvxUrrxonWHf6uwpBsTiLVoFqTJYYwJfpIXL3aVMJoy3mIrncIhZ6BxRVy3Nnpor1ChyRE_Z1--Cbt2KfVl4eI2_8sjBZC_DKErGP-gT_Mu6dB7C8nc_BRe4krbNBD=s838-w838-h530-no");
        urls.add("https://lh3.googleusercontent.com/sm9jgR4oVPqLsyvCYQWyHzSZ9MIf2dqE8UJuv7TOwp_bPi0INN2ExgLgMveX61wSnQVOggAe1elyjWHeazPAMy0_1DEI6znPawTdKLfc_ybXxEJArGMomLdsN0-L3hupPeru41rPf1PwigPUDqS9pAFR89rYbdDy1hrDAGakUVSrF2pUvS1jOCJr86I5o4xpibY3LlFwlWHvFrSqpY4KWDxdt9DzBVRd5oUjhNTjsu9y4YmohbgZEc84TY59kAoB9IoVNH_pB7GPwZdwZUBpnqCRtZrqGnNc3lLx8VL5euyewsSmR87kfCGLpEwX_hmw6KRTkF1n0LziGOLKnAfe1eOVTnyL5lBx9hhkppkldAaXopvShM1o6HZEMXZxEo-lUbzF4wOEuoUKScjW2jwUz9boXJUt0VEtWTBalBgYT-sLagJ6hcA-npJLgAhqMEFt0zss3UvtN8C1eaEKMq7W2s5cDOIlFEDLaXdAK02MertescaPVOV5MK_PCJ_Wbr2bOpkKSYNDe9PM66ogLMfTEpmjvqbuU9-Cm3V5kbqoTJyeuz-LDEfS36m5aSMnGQn3iZ9kiVrs=s838-w838-h530-no");
        return urls;
    }

    private List<String> createDropChatTagsArray() {
        List<String> tags = new ArrayList<>();
        tags.add("#HyperLocal");
        tags.add("#Social");
        tags.add("#DigitalRealEstate");
        return tags;
    }

    private Venture createAmalexPropertiesVenture() {
        Venture venture = new Venture();
        venture.setCompany(createAmalexPropertyManagement());
        venture.setDescription("");
        venture.setProblem("• We provide mid to high end housing for students and young professionals in the Greater Ottawa Area");
        venture.setSolution("• We purchased and renovated properties in the Ottawa area, adding high end finishes within budget, while also providing tenants with first class customer service experience.");
        venture.setMonetization("• We make money by charging tenants a flat monthly rate which covers rent, as well as other amenities to enhance their living experience.");
        venture.setLesson("• In managing Amalex Properties, I have learned about accounting, customer service and people management");
        return venture;
    }

    private Company createAmalexPropertyManagement() {
        Company amalexPropertyManagement = new Company();
        amalexPropertyManagement.setName("Amalex Property Management");
        amalexPropertyManagement.setDescription("Amalex properties is a property holding and management company which operates in Ottawa Canada.");
        amalexPropertyManagement.setLocation("Ottawa, ON, Canada");
        amalexPropertyManagement.setWebsiteUrl(null);
        amalexPropertyManagement.setLogoUrl("https://static.pexels.com/photos/2324/skyline-buildings-new-york-skyscrapers.jpg");
        amalexPropertyManagement.setFeaturedImageUrls(createAmalexPropertyManagementFeaturedImageUrlArray());
        amalexPropertyManagement.setTags(createAmalexPropertyManagementTagsArray());
        return amalexPropertyManagement;
    }

    private List<String> createAmalexPropertyManagementFeaturedImageUrlArray() {
        List<String> urls = new ArrayList<>();
        urls.add("https://lh3.googleusercontent.com/MllMwFhLpaaX0PcvlvbE81D8_NSAfa65GR6AJGgI-go0Rw8GiXdj7L8t5RTH1Bl1gjGasvWDGh6DhC_mcGzCCTTLMy-S0RcziHISA0XH3uTcT-onRQ4rvuYKFw-rhHmcIWZO6pHfcFBQs5zY57Sj5PhlOwMvJGAoiWnbOKVwKmKq9OyxB4dha7UdTzBMNLiIGs-G0adaBafDrJ3iUa3Nq1pD9hQt1MCpbEp1qQ-FZuetcB8G8cgUOWRfEj4f13ArXaP8aG737GT85lgQBFFg6JigY_UkMjybvOaIcYpo5F3c1ft_3tw8Oa3j-BnC0mhzq-5-vAARg8lRyxzJ5v4s8xq7omdNqQpR96cy-i4ZRS0C8OLyUBNUNnp5CG_KHFqXdNEHhZnPnqltPUoVBa0KVjeRfczy2MldRnLfAMNy_oEqzl2Yxc-_ZmexhxAyt1e6kuSS5152MnC6j6m-4h2JnnmCDYFQbSK0gWWDBBfNKMg11t94yBVoqNW_wuBZSnKzIydQrBQPzknKAhQaD0L9OTxtTZHhauDl-SPv13opls5nFkbSpcjZkIDOleotsJJ0Y-0Ps08m7jZ9aUCdENubMscOZ8RfL6sju9syMVwcyMqy_EzYrQ=s838-w838-h530-no");
        return urls;
    }

    private List<String> createAmalexPropertyManagementTagsArray() {
        List<String> tags = new ArrayList<>();
        tags.add("#RealEstate");
        tags.add("#PropertyManagement");
        tags.add("#CustomerRelations");
        tags.add("#Operations");
        tags.add("#Logistics");
        tags.add("#Accounting");
        return tags;
    }

    private Venture createMyFirstBusinessVenture() {
        Venture venture = new Venture();
        venture.setCompany(createMyFirstBusiness());
        venture.setDescription("");
        venture.setProblem("• Drinks offered by the vending machines on the school campus lacked variety and were very expensive, as a result students were bored with the drinks offered and were unwilling to pay for them.");
        venture.setSolution("• I solved this problem by buying and selling a large variety of drinks out of my locker which were not offered by the school, the drink selection was changed weekly. Eventually I was selling enough volume that I was able to negotiate a deal with a local soft drink distributor to provide me with a pallette of drinks for a discounted price.");
        venture.setMonetization("• I sold the drinks for 50 - 75% of the cost of a drink from the vending machine depending on whether the drink was regular or premium.");
        venture.setLesson("• Starting this business allowed me to realize my passion for business and greatly influenced the career path that I chose. Even though the business was on a very small scale I learned several valuable lessons about many business concepts such as: supply and demand, supply chain management, sales, marketing and customer satisfaction.");
        return venture;
    }

    private Company createMyFirstBusiness() {
        Company kwilt = new Company();
        kwilt.setName("My First Business");
        kwilt.setDescription("I started my first business when I was was 12 years old by selling soft drinks out of my school locker.");
        kwilt.setLocation("Ottawa, ON, Canada");
        kwilt.setWebsiteUrl(null);
        kwilt.setLogoUrl("");
        kwilt.setFeaturedImageUrls(createMyFirstBusinessFeaturedImageUrlArray());
        kwilt.setTags(createMyFirstBusinessTagsArray());
        return kwilt;
    }

    private List<String> createMyFirstBusinessFeaturedImageUrlArray() {
        List<String> urls = new ArrayList<>();
        urls.add("https://lh3.googleusercontent.com/tJnmwGGR4EsF6FLCpOGYhJUDv-HzFjaivilFywsfEGJBWLZhgKyQli4N1-hUhWtD8fy5-_yz7R7dJNwtOGT-MKHFGufppNTkNlM3tw3Ryg7MPxOXZuE_sGe5rE-Yrd9B4oUtALZvFmmnGsMW3-G9Wn0nXnekV7iRxT-dZq8aI21KmmFJGEog84BOMdTNUH946ikgVPGE_ApyluDiGcW7hgmEfK5KFqe8Fmt90JrUucerI77cX8ycEmcQvZRIZw3oyNy8_S81-Yx79txQGJkM2h79lriS6i9OrzRZRNYyXumQb_skyA53R_Dm7119wwpM8IdFzRZ1aSVj3UhNBd3rHRaNn5DQeCotsLSoyikgA3oQYFz14ptvbXVpx6ycsW1e6BUxlS4KG_3sO-MNOrddKIO5cME_RFKwsPEow5k76-BmlidioPmJjZ_vB0n-xvKJ_pTpYux_3e74UYkg9CdQpyHx0BWikp_HbB4vyneQ2RylJUrVt6s3obmKUXGTkjhSCF0TEIr3nZWsCrYDJh6k3BNpMnpb2iPto5I4MKlGRQLbzKSMvVKDVakLwrboUso3YmSpuwNZMcUp4zE_vN1td3F3hvUGhbLpbuLbb8kmnWAiNMdfOQ=s838-w838-h530-no");
        return urls;
    }

    private List<String> createMyFirstBusinessTagsArray() {
        List<String> tags = new ArrayList<>();
        tags.add("#SupplyChainManagement");
        tags.add("#Bootstraped");
        tags.add("#Beverages");
        tags.add("#Startup");
        return tags;
    }
}
