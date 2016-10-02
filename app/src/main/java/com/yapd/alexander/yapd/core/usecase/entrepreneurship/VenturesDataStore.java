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
//        ventures.add(createDropChat());
//        ventures.add(createAmalexPropertyManagement());
//        ventures.add(createMyFirstBusiness());
        return ventures;
    }

    private Venture createStudyRoomVenture() {
        Venture venture = new Venture();
        venture.setCompany(createStudyRoom());
        venture.setDescription("I came up with an innovative idea to leverage mobile technology, data visualization and natural language processing to help enable classroom communication at universities. I mobilized a team of 3 engineers to develop and rollout the platform in a local university");
        venture.setProblem("• In the STEM (expand acronym) community, students are often reluctant to seek help when they are struggling with class materials for fear being ridiculed. This causes students to slip further behind creating a negative feedback cycle.\n" +
                "• At the same time, professors have little to no real-time insight into their students comprehension of the material being taught; and rather, usually only learn this information after tests and exams at which point they can do little to nothing to help the students.");
        venture.setSolution("• As a team of four engineers, we created Study Room, a gamified question and answer system which allows anonymous communication between students, while simultaneously providing professors with real-time, high level metrics about their student’s knowledge state regarding class material.\n");
        venture.setMonetization("• Study Room was a SaaS platform for universities; universities pay a fixed per month rate based on the number of students that would be using the system. The software would be managed and distributed by the universities themselves.");
        venture.setLesson("• Study Room taught me a lot about product market fit; when building the platform, universities and professors were very excited about the potential of the platform and ……...\n");
        return venture;
    }
    private Company createStudyRoom() {
        Company studyRoom = new Company();
        studyRoom.setName("StudyRoom");
        studyRoom.setDescription("StudyRoom is a mobile first, question and answer platform which provides professors with insight into study habits, learning patterns and the overall knowledge states of their students; while simultaneously increasing student engagement using gamification.");
        studyRoom.setLocation("Ottawa, ON, Canada");
        studyRoom.setWebsiteUrl(null);
        studyRoom.setLogoUrl("https://lh3.ggpht.com/l8dr0YOI9XoqJKg--niERGSs5xOrNu6nRuu8phUDeQiWE51DyCRpV58ZJLRoKv2uPVg=w300");
        studyRoom.setFeaturedImageUrls(createStudyRoomFeaturedImageUrlArray());
        studyRoom.setTags(createSkillshareTagsArray());
        return studyRoom;
    }

    private List<String> createStudyRoomFeaturedImageUrlArray() {
        List<String> urls = new ArrayList<>();
        urls.add("https://lh3.googleusercontent.com/nM_8GO7vh_jtMc3lqdv2nzsmIvgMJykMEceRAXDE_HoHPUXV1PO5fs9pxJclyArTQOmJsaqY4sDosg=w1920-h1216-no");
        urls.add("https://lh3.googleusercontent.com/xfo9btNliFInuqk-y1b8NDDFpPb2U4dEJQb5_dH1WJeR-Y_1yif4UJr-P-2DNB_lNEnouN2AC8zXtw=w1920-h1216-no");
        urls.add("https://lh3.googleusercontent.com/nHgq_Xt8OChK5c16sSTnsGky4tvZdiBYxi-fbkWx5k5rPUQ-UCLZCCDIv6ZIKlabPhsZXETaCGL04Aze2r_1-MR97SuXTnwps95BJnjQAUZhBwLwIuo_Tm_Q735tvK1OG9kqG-kQyErEaRkiaVGw5FHGsZGRO2S6MGj7va7KjWxxszzg2eU6k4vGRQbIijMGtfX9iPaCdqwIbRyZm0LeVY9V7DPV710VPOzI6Iuqu_dRhyqMbtyg1myX_Ihq7M9OUZ3iu44s58dudgXrMKPuRZD_ZyTVyXdl3h-HwGzuY3aJ8gfl0baU9tM3pOZLuksYXb2XEI0OLwKT-3a5B4xmCauAB71FdRldT7V5ENNdRKLzQI9PtkGJ6bg5keaF7x9JWdzFaWO2ExEh_o2x5JShx7H8_JIWpqPZwamKzTUKkNrvpWI2aQFCGcz4YmzY6nolxDiIp01pgnpGNs3grXdL_-ZiQxUB7pZW4Ts7Ag6kCtCwh81MiqTW156s9aXBtq7K8EsVAcyMdf99h6TusN6UQG-pOFduxRxj6O-45SvJF5YkPsuO9aQHn5ff9RWQ-m4PLVr9FWJ8NksUyRhkdMxKGaNpswztGYAOLalNpWGbRA1dG8G4JQ=w1920-h1216-no");
        urls.add("https://lh3.googleusercontent.com/Urrw2wUqidwJ-p3lxa0t9L-__TfXt48gXHGQAdm8a_Hy1sbFn24mOrn8vgT_aigPZpawjgzTIrMNpDq0w5m_PzM1kZBYckRzrk58wP_uGCESTd9tp-d-Gyh5V8t1mdg880vbHnIPp_8Z_RkNYA1n6oyC26k98BWwHDe-GHXxhWZhj5B9uaNc74ZhvnE4rZuwGh8rDM_RlyaAhJ2gJlvgnM4lQxinhyA7gkoUvCpZUgOn0JBp-i32wW7INvC9-waGTHCBjRrANaUWjkmqnvB7fejuGRQ-j_LAZxTn1NMO0Vp6Y6uYH29-_ht8n7YAG7mgI_q6u2E4BfD-SjtaS7IaFHgE0H4LJN8Zre7rkdhNI6-fOWJf9aAy6xZ8P4at8vGylttnZfxKPiHltUu4atJQd6lbc27vcBqZ3fLlitzYqiArtla5yNquaOF23NspW1Ulab8Nkph6NDnmGs-uCa8qmLuFNv7uP8yJH0njsBu-1Qkk7dojm9kHiPLMKytBky_ZgXIMYaWxtdwcgEJCOz88qeRMJ6v958-wnRGOjpf1e831Rfq3KSc8z1HiWyageaxuT8Xx_9yvqdS5h8-CYyep_nFfAHV6-Tnay2Yxd0uH_jGAyh2phw=w1920-h1216-no");
        urls.add("https://lh3.googleusercontent.com/UVZnewBVoeVv6g3Pu0Yb8bXEhJ3xjdOGTdi6YItlm1tY85vxS3mSmVBtQDNWyPk6ZlWUvlYG7JHPSeMWcoZOxwQak9XXuNC1PJOUByC6Xd7QZxJ6p0gMvqNmiYgM2mqTfztan54UqAWdNhsdjlZ9b2bwZ2cr_J62Y-VCLcqH-b_YSzZKyNddt-E3mZ3OR9vVQ1QksXhkyIu7Qk1PvLoTfyK0JnCQWllbE4prc_VuoSeH1K3u8ST9yylLKqc6F8a4m1COEOn2ZlJFRs31chybeqZjzIq2BEJevPNFTr4ASvQeqGhskc3GdGuyifbcR059QUXGTnDkNGSgxkHWEaZqdevBj7A3_eTKrpEu07d7nbEY96zKCsVTKiQhVkQ6yZ2CXHaV712gRZYI-PEizmpICYXPnoXv2fIlQsuaw_LxPc7by_D2NsqT2OOiwDfxeilU5DqYpR6Bh9IVLPOTsw0ZWBIHrfhdA1eJkpDrDJfa2dOgMNpEM5dDDgUrigQ3kwJxogcpJalAM81n5ZGqeHCURBd4auGDZajwVBKwjlamlJZV-2o9cp3xQ3fOoXlKPSFZqCwQCfu4JL1Men2T_6d8FCJXaA5wOp52xnI1nqUA3QHsICfz0Q=w1920-h1216-no");
        urls.add("https://lh3.googleusercontent.com/24POG--XVV_WvgvLFzpLI3lwGTBiAbXcEnSJwgqjbNVBGQ5oWcZe3l67x5AkdEzsLHNas5PugplgSwPl2WevOa5EOl2GAY3HxjI7OKUw1CicHrvQ8zc11j5pDVSHlZ0qaULoiyUNEUv0Htg-EFgK2QXQh2B8zzrAcf6W6GP_XbE9x1cOX-m1xPkH869BqpV5cuYHoHeLLufXzuTTc56PKAkT7xtp0i27VzE27VPv4sfErH-W-0-_b6-BHIG62WjvW-ov5_8XsL_MoQh4-sJMJEpD1TrgCNHzjwTrwfiYybM3GJ58jlmq2rbKzxbwjSUu5-K3Xzd3Lr46QM-w4bwcR4r_lbZuc5Lwr9zpTh-1Ky9RA9mY0gYI5LjXuFSdF6CQO9EJ-B5Rwgs9JRfg7FBwAyqS631Hp4qzuRT91kaNYGSJS61j1vAFOtLvIC0Q-RiEW89mD4ur3OHKj5CAouMEHnzfSL6i4JfB4xSoqq7KEwdOraPx66iJSTF6w-xriFM5wAudbuwG-5T7sVb8UwTwfwITjtG_GtPjsY0vOgoHl6Xc5A0X3hsdgPl-UlEN__xRXVzzteIzjLm9shKOaEDWWEpdOYDID4ctbvjFv-XZ7NHF8K-3Lg=w1920-h1216-no");
        urls.add("https://lh3.googleusercontent.com/NRGe0DgESZE58RFtUc_XWPAy9x5lAehtopJygYExSn8f8G3lKpvWDz3Hwmcjh5n0TJDTpDlOF-s3_fiP6ZOEHwVHPtZjlnr8uFlug5ubzbJfb03JMDSyuvYxUHLl8B7SjdfMTdlxxMP-CcWToQi8-Ch7aejdGgPakl_tx68omcn6jwmXj6RZ5dtGnJcujbzdvPsXdXt91HrCy7GrYkVcOj9_eDsirdtBJGAwjPVSjZcs4tT6tZ7EH_BwwBDJm7xsGipwG9VaKIwhdsbeNuj63nvQaty5WTSuG4S0q3joea4WDy1IU5IQj-4hT0CZXXY5WCdn0Q582d032-vcbWPZD-paCM1gTwHMxDEo2HI1q2E6LLKCzmFg1Z6R8wxEMm9-zapQ3L83CP4f-z6drNu1TXzXxRhU0V46M1a6ZcARgui_a-M3ZsQ7QjLnuQWm1m4AL32j2w9NchJz_0q8kWMJCyW0ARqWdUMGWdubbwECntf8Oswce0JwWgmP1bjFEY4Yo_0ruSo5bBOZ-TeqJA4d1t2OnnvXbgZh3mJ-XcSzdN0OOsN8skGAO7DQoSqICePzo8nypgU8bS2ZLlDx4yE1EgHceOCRFK7bCE8eOstxQ57Zr_jZZw=w1920-h1216-no");
        urls.add("https://lh3.googleusercontent.com/4_GQDQTvgCoMKAPchlC7_5Lgxh4l9dHgdPz-FZhyQWYA8AzVGvK5AqC3KvuTvvAfIrOu_eS7wRkc-zPn6P7ihrjBGKtS2ks-5cBOwZfznfxC0YgyCKk15IZ1r5B599kfPv59nrCZUuToghMhBYUCvK9wv4y8Rv3dPWn8qZ_sswOjCAJGmg0ngvlh9cTWZ6toyeLMjbw_jTJsboJWlsbcw0rycoXm5Uk1x4Gpsj8DM468dYGEQ_e0NJHD9DyQwNZvijjIqRoAh-88sczRAArnSpGqgdE8wc2Qyxbbet36wOHq6D4O-MfpOQ6rUQMPYdyvz135nAUr5Ut0RvEX9c5AozE5nA-2xGv_KZurGyPdDhG5y3LP7v5EgFUpm3YZHvekEpFVIWoDAxK1312WR3giqNh2jrejdEmVdlTaFAFzqVXj7bfhaRH88qAc8tMRdbbrvE1WtxCjbc5IC29KRZ2K-60B_Q8A2nDKim_sHp7SB8YhFTH-UxE9jnExxvGzlACsHtMBkqqK_f6CyrjPA_Yax_wdB2HW9Q1w6x4dT2ny74bofW6ELg9w7bO-tRCXK3Wjv5EDTqzS7kNM2nQ_c3BthPKNrIZjAS4pecJqoVw2S2eeQCYoAw=w1920-h1216-no");
        urls.add("https://lh3.googleusercontent.com/JdpuPzAm1pbLf6KqFb-H2b6-0NAODA5MnfkaOLperyj971UgufS4tcErDp1bx7c0UtFGwpfJtDJKguFUKVk5IjR2SzPwSog2LbP_k4KLlFlllNLcH4GgUNK6HMW3ey8V9kYvoxJmjATp7e6PRr2-l0mL_Dru2rJ00r9ChPHzxmD8qjYp_BrkKTbYT0qvWXSwB-_qICHM4hqZvZgUWBbbN8wGYMZ1BFO2WqpqX2kUke-o5RDiIy4RIR0o2kIMKeHJmKL_dinbKEMcxAd4Czh68xZAC8ZWogJ5enXronGFji2XTXzSE58bjRiO5Utmzz13anKFGVFjFyVxjxnYVirXJA7OMEJzKRer1U1X14NCsMk0ccF4ymyZfCkstCDe2HKaZb92znQjaMAfCPmpbUU3ITB_irGjE6mfbOFr4wSP3f5s5Tb2smuIaHiVzSr8ZQ-bjDwoQ2ctE5ct2UNTnx3Fs9S08qj6555vmuC1c4YNApio1yu3Ma_D5y4gahysi4yZ9zAnCYUsSVx7zPXNPn2ro_nAZ5XyOx7_Ym1XwpRYuY7JDs8aBv83SWCTwyN0z9Ovq4lilRRvuHfdeggmh4HqcgNWP-bK_vAa8t7oHoV3g5YMjgDu7w=w1920-h1216-no");
        urls.add("https://lh3.googleusercontent.com/BgWQRK4K5NYdgmwtcjTpWBM-MRtIUze2pnPMpWqpFEDXCrOlKKi7jdOmU_RfW5g7VGQ29l_ZQwW-GDSGUoIkEzF9d15Ns9S8CZbRiG23EoRfZbp1CTXd0WX48yqDQLa6WfLK1EK-W4jYJQe-YGfcfYcbjkXcYDI3QMEsBLgeR1ltsvpPbXRgp_2Kyvdb7SUeqozcDFrqM543_Uj-nDv8uPFPjfR-7t87I4bT7n3Yog5Eo2cNjq0bRe0UdTc03SBD49yghj7CbpB2aUD1FoR-alkssINUYyWymqxxaea5vKYkGFnqoHh4HuVustP4XEL9quVBJ9hSy6nV7iiE8gydhdZHtmKMd_c_9AvPAQ3ok2E41sYJ7Q1Wzpysvw03v6JFPXdBDFI4d824HyjrrxcTm6WwrGoU4qJvCg98ZmeB_qMNn2jEIUDdAVHnSaz_FQMN4sMnfbA6p49IpU4vJZ1kUdhP_Vi_VrNSBby0e01v98jlZjcfihfvrHAHq3GIUK8mEmrc5sV1jBfVFhoUZP0rDJMgd0wKfbLqywZ2Cr88xvk8_gD6IDtIM4dnzmr_VAFhjzyiLgNpHPLKvGOUkU43SDkSNWkwMUsYke1O_k4errR4l46dqw=w1920-h1216-no");
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

    private Company createDropChat() {
        Company dropChat = new Company();
        dropChat.setName("Drop Chat");
        dropChat.setDescription("DropChat is social platform which lets users and businesses “drop” location-based messages and discounts for people nearby");
        dropChat.setLocation("Ottawa, ON, Canada");
        dropChat.setWebsiteUrl(null);
        dropChat.setLogoUrl("");
        dropChat.setFeaturedImageUrls(createDropChatFeaturedImageUrlArray());
        dropChat.setTags(createDropChatTagsArray());
        return dropChat;
    }

    private List<String> createDropChatFeaturedImageUrlArray() {
        List<String> urls = new ArrayList<>();
        urls.add("https://lh3.googleusercontent.com/_M8lVvzg2_kJrlZOdOCQIFOWjBdZ2FGu0FC8rfpwfQLGOPyhT9LI4LE3XCo6to02Etk1iVT-tQHSmprEgKf7mpi9_iQyIe9vvwvAsNinftwiyFCnAkPj8u36nIoB8tsN1NVv09w5NTE1L2Li5ajZTuYuNSMpNMVj6pWK_8mBZ9XLE2E3hjaW_DqnsmXx1i-9U00OsHTZxht1MfoKofJY_jXpzpmzeP7157I7mHkdurDph-njyVY6Ky2a4dYfceAGkWWmxMfYRZSXotW9vjpgNF2viuTRWE0V4NH0iQmSf13FBPeKwO5iTkm-kEVpeXohmeF-uBCjXtm4SF654Tau2S8YnAHR5OZFCM8OUhBP91b9S2XlJhKeNBNRAW8ZPe1ERUu-OkunjLE1WlkxutvqG68QOgDpPBsYy0jlmV379Y_GoSQvFqJp5dghOPHGbPZbvRHjzzOCaF2ZkGtRQVmPY42q9G8XkgiC-D3mrcX6n3vAl2tvUUjK-6vRcbsqSPJEDyL9iqmc4b4k6OMxXDj47J1nh3Zd9F0e8h5iJYuMgkKqkZy211ZsBgjHwKRrMy6qopdcsqe-FCeahiiXwu7c8WcVZl5sw82Ls_tzQ29Jc_IjiqlrgQ=w1920-h1216-no");
        urls.add("https://lh3.googleusercontent.com/QkjMB7095ZYU_o0-pvstLy50PLhfZTfk7GHnrJGPok_HLyNaFSjbB3n6a1nFv817880U-npFclFLc8n9A7FIvfeyQxfmNaHChZGuJLo6FTJMfJBfSr8cwVYKey8ltYFA63Ba0D1hGllARG7oL9XXtDSN2dy0iGvkrctfgtxj7-IAyvIKka_8lPHfX4iVS37FSflXj_-7RLieZ7w5Sv-jPbhCyoU3wOSRHHcEP2IKPOTIFt_GIpTcr3ElmQuYaIAgasITmLCNDxWshhyGD2P4uckCXksUoDlcQjWwWgRSGhHQOciFIFYmIlnxcaMnNIbql5bW_MHSQQQ0_oaQmcXSaW1D6vtyw9OkFuH5t7WuL-1fFwXKut6JSyZgzhkkUi6PmQyWHCzBgWcgVsiLOLuXaWWO_M8B-2_UGr3nmzRRMumogTt1lMqQYIfc10-j-C6_8jPgGTvPWC0Ge7nRkzOUiXvIeh3SVG7C_sgRkOaFBnJ_CkXegJdiuPf7nxGsbXzMBMy5kEabNh6YtlHD52eLyh56SJUBHrLZI6LNB-yKBukDk_VTzujxFNfDmBpA3kJ6g9TCtObxry-Fcm-OX-AeKFPrHtwp3UenT4zYSzhucpWSKScqQQ=w1920-h1216-no");
        urls.add("https://lh3.googleusercontent.com/5ZXsarW999M6xYzJEoQknHwfupRbqZlV8VINGAhLyvRz_nNt9o1pMujVJbUvWxDFnn2Mq4eOWN0uY4eF5W01ZUUdFtJD1nKDYLn5vaDGRiBnhfyYbyZqKVblOMWRBZ4M6MFhAsOMsaBjkr-NZWtoMRT-Ikeg4kJ6EW9_R54FfTD0XScUrN5AcO4UaSFPrMKQYHk_YjQpJ637CUPchNjliLq7FsZcEG4UsuM4k8kvNSyP9voiLhgaH1LqQEHDD1wX-R8LtVfp7bIEdTwhPCHyydOTggUIjAErtpJil8BPsgXh1fuYr2SruIZ64igwtAp5wIlDkx9OcpejL9axZj7qsbmGX1iwxv2t_FEIr3ah5d60bleOvI9BEfyNxXWOMIMdneAxdiWRuf7XjZP2IaV-eudOikyb9O97aEAwr_jc5B8ZAq-r8NH4C8MdimOTiY087rRD4PMJXW69E-ALws9nG_SQBX4KzNV_tA6vnrUw5xQyjCNpopc1_BKEiKJgl2524uOBSOro1VXzglGQg3IFR63YYs7oYphFr11iHt91A3UEBr9-hDR3yiNEs1Jjz2lws_90BwHFuC6nRdyG_q-X7JeG1uQ1qElzN_37Jmbq0EpEL5170Q=w1920-h1216-no");
        urls.add("https://lh3.googleusercontent.com/HV_DTe74-bsvpBpXBPXAr73clGwPl4pMraQn7tW_xTReDLpY0Xt2QYKMjoQ-fMzzHCtXh7UAMWFDlG2C7ZxKFxPAjVC0gjzTaF1mOXhz97UiEV4Wkhn-UpVsica5IeoAW1mUX0IVSPBBDJ1eLHJb9EoXLneNydkVsiJDW6ybYhDpngHZQ4f0UP-bgaLVcvZCtxuFl7geTGi_ImEH8h5DHPo1q9bcE40bx7Zccw8ThMSpgDChcQjLLtvjlprD5KNSmJPs09B5x-FahG8LdIXFe5Y1uIUuy1vrHLc26jVqVycVxgb771lrOZML727Ynfv-OCZDMKJYuPLHuIukuUhdLTJoj1CPmUIThOFaf5Covj6H4OPRFiEea3IiUKlVE6mpg0q_Q-x28L2X2NUWjsYV5YZ0phQDTamzDwAKkrgTp2-gN-Z5Re2wXjxOK8TeKNTRbfhTcg1PWA_i9FWaXvl85Ql6PIs_QPBnMJLmacek5llvAMUOYoIdJSXC6_2agyPhNOggy4bNMB25UJjdPhhsqhbpueEhbOiwRzufoVVAwM9o4s76TRNvhTSffxBsk7OQc6V9-1X81wvqLB4sXth_4DTSTs1mNP8hmrySUHnCnsE81y-R0g=w1920-h1216-no");
        urls.add("https://lh3.googleusercontent.com/9CxQlwtlCWzaCyQ6yW-rusqWYP5NrtXXGsj6sVMTsdzC3z_jQ-LpABR3NgH83VxYM7uKkz8UIQi130_yEQloKIRJMWy4740m966wbv_IrzAXbrTnBghDCX5aa8dDeGWrb-zqAS82YnYogOEDuw-kSo7d3wP8eU1fvDGqbZ9hSo7cZv1AI2b4oGU3i6aAZ_ln0xQ6jgBHZaVVASjYxPwBTYE6MHO9C-Ch2rFUxcDujipn1ywCeYd8qP_pADva29mZhmbEkBC1DpVf37K8ZRad6pDdggioL8uUF6ZprPphweXg4iNNk9I4NxxJlH0ufDIlc-RvY_FABk5B_Sj4C_Tw-TNIorvIWK7uJ2PnAv_-2kli7YhyZv5MQ7l39Xsg6MkHsSWcbSHRhXVG6rZJAiIPSIY1YdM9fuwWPy_t19m8JjUuKPTc954rq2svi5pStzXMmPMr_9rocGuIV2xpH6_mjBgA62T2By2bNFsQTuz4XIHq6RotxXeOx_HvWgfAZmAZavSgCAxK19R8v1L9IdVH-jE25wFzZpUhUesR3hMlC6Jy6S0ykAzhi2xGRb9kl9zjxsKn__xQjACDMbjFb6_eBZXzIGXaGYAzLgxOfFxMfYcuk6gq3w=w1920-h1216-no");
        urls.add("https://lh3.googleusercontent.com/c80EHs_ncvyx-cXZzmAFl6gwh0Dl7eigDlxzP0pZUjWJBkYlRcMCbBmhxuMJ6mVn6b8antR9A-8MR3ad88x7_9FpqNFJEnkkOb68WnFfqcYDfHbXCc8oGqYuaPQ8xHaXki_Hp19pYEyAF22ckoM2bOJSFVIp8XJ4D_oaLWiRvCSIe1QOpfHoiAUEdf4cbxUPOfvE1Y6B4ZoTn7lvYSdaRD0-IHPDpvTCHi2C-0RF0nOpfXyPD3p0ljcUh_rQFE4mW57MxWeMYMC2fzcBqoH8kuXwSr9nMDRAmZdQzhykdH6vY4TYGfnrp_ZkkTqDA1-v5E3SuZ_8bHx1LDxrlFuSOWwJp2vEDfVISYvc5c3X4HOeeuZf5poqyvzDJJ3p8La7WciDlAhi6INm1ozztr31KyzAcUxGH7Zmlwp9HQWgwsC397SnG48vFBLoLm956mBOinu8KMvmawZAZ6wfIhsV_zdVIaZlTozfYh_5qcq2Kqx7FsMcKY89DQamnyelAOwSYAxFq1kGwvvBFCjfR5pJNyS7XeLrlrdk778PEnbuCimfUkuOy4W3OPBWzSxI5ncI0Ig7MeWTI33LWACKgvTIGE0O5J87Dn1mpXeUco6bdbt30L-58A=w1920-h1216-no");
        urls.add("https://lh3.googleusercontent.com/noJ5yPnSbMvh3FL3KfW56LpTqAfyeNsVtnuPhyv0foH9b3ZHVuH93ZBrSK_VsPlknk7qU01NC9FUjwkr8IoEiuQsKPZwq9ATc1o95zvjbgQEF8ZokDoDcYY3JpHKTJIczkHKkXmUC0RywRPMGCXF6B7v9RGlGeXAj_GYKHfYYhHnutNTLNi8Gd7CmZwhpWhxOcOawmBg2tAVqRPKEp_3kQJigrhkIZXq5cz4rWN40irNEW--flRJ0wklFF9SU8CU6UO3fpeOuScNMDpmeNFXqz8ynHuDMZCqto-2sP-TXGI7jfY4RWY2JA8zdzqwEMw54_itANz_9tVtcMo9HtwDRRDRq2sgrIHsIKwGc4W3KQoKPuJwuj0Uwv8pITHl8Tw03wixifJx7CbZMWfMOwoRWF8YY05gHb6_8EuBnVE7v3zkYwl7MzqBF92S8JbuXJvQ6qgLAONLBinRirTv2crEGivglUnfUaIzUaaAjEXWBKrBtqKb4GLzlP-8c-RtvBpfZmK_uwNAAfoBWiqCZkX21LvWvFf6FnPMPwvMw39IGrKgemy1-0jOloP9fZ1wEHEFHEKXI3MsRcCan_PXgnPkEmXoj7eICqr4VCK42Sqdt4H7uaqD_A=w1920-h1216-no");
        return urls;
    }

    private List<String> createDropChatTagsArray() {
        List<String> tags = new ArrayList<>();
        tags.add("#HyperLocal");
        tags.add("#Social");
        tags.add("#DigitalRealEstate");
        return tags;
    }

    private Company createAmalexPropertyManagement() {
        Company amalexPropertyManagement = new Company();
        amalexPropertyManagement.setName("Amalex Property Management");
        amalexPropertyManagement.setDescription("");
        amalexPropertyManagement.setLocation("Ottawa, ON, Canada");
        amalexPropertyManagement.setWebsiteUrl(null);
        amalexPropertyManagement.setLogoUrl("https://static.pexels.com/photos/2324/skyline-buildings-new-york-skyscrapers.jpg");
        amalexPropertyManagement.setFeaturedImageUrls(createAmalexPropertyManagementFeaturedImageUrlArray());
        amalexPropertyManagement.setTags(createAmalexPropertyManagementTagsArray());
        return amalexPropertyManagement;
    }

    private List<String> createAmalexPropertyManagementFeaturedImageUrlArray() {
        List<String> urls = new ArrayList<>();
        urls.add("https://lh3.googleusercontent.com/kSAG09wFiU9EscIfs9MqToUeqnAMWS-jCgqQkOfZmxcVDnbq9Bz4QXdp8sO0XVsJbE8VT7b4Qd9WfR2XQ4mTdt1KzBG3bidhOiCfD1RUBosSYHF3jJ4uKb6rgnEfOZ3MTe-_ZR57TFw79C9qu04hdxdDt0P7kuqeRxpexety4kHgG3jsCCaNpGR15LpVw2aGNS0BQxsZ_FYYGjY1dyu_BepyvheJGljpYp3A2ZJOCDL17YejMLtOxnnRGX9PhMY9McbPqnRaMeXskrs2M_pxlktpqS2RdIQ-lskOJuGnZtRhboBTqKAy1T83qPgcLa5eXGPIvVubUSGnVndX2dJGM9E7z7jF76QGvV9vOoPWQ4ZZJvGIy_lGEHBQhXl2NrPi9Ya1tWNGpe3JTz0IL1lu1hEJZ7wNFSqmUuuEa3qSz1pS8gFY-Hnuz4k-r7X3WFbh5zy7lWvw9GmP3B6LY_o3AA7RwTIaTcZvQoM5WLPkUA-KvnuSx0PkyZiuUyxxWAvrEU_Rs9koYRUfm75BSfvm5SOvgkRyg60XLWBcD_xos3zHDDJIQ6AwjnowXOaCV4QJF42rUiM6vPdpOH0UBTr4zt1jxQvIJNgE63CN2FdBsOfvh-zgnw=w1920-h1440-no");
        urls.add("https://lh3.googleusercontent.com/kSAG09wFiU9EscIfs9MqToUeqnAMWS-jCgqQkOfZmxcVDnbq9Bz4QXdp8sO0XVsJbE8VT7b4Qd9WfR2XQ4mTdt1KzBG3bidhOiCfD1RUBosSYHF3jJ4uKb6rgnEfOZ3MTe-_ZR57TFw79C9qu04hdxdDt0P7kuqeRxpexety4kHgG3jsCCaNpGR15LpVw2aGNS0BQxsZ_FYYGjY1dyu_BepyvheJGljpYp3A2ZJOCDL17YejMLtOxnnRGX9PhMY9McbPqnRaMeXskrs2M_pxlktpqS2RdIQ-lskOJuGnZtRhboBTqKAy1T83qPgcLa5eXGPIvVubUSGnVndX2dJGM9E7z7jF76QGvV9vOoPWQ4ZZJvGIy_lGEHBQhXl2NrPi9Ya1tWNGpe3JTz0IL1lu1hEJZ7wNFSqmUuuEa3qSz1pS8gFY-Hnuz4k-r7X3WFbh5zy7lWvw9GmP3B6LY_o3AA7RwTIaTcZvQoM5WLPkUA-KvnuSx0PkyZiuUyxxWAvrEU_Rs9koYRUfm75BSfvm5SOvgkRyg60XLWBcD_xos3zHDDJIQ6AwjnowXOaCV4QJF42rUiM6vPdpOH0UBTr4zt1jxQvIJNgE63CN2FdBsOfvh-zgnw=w1920-h1440-no");
        urls.add("https://lh3.googleusercontent.com/PpzUYqKDzBsnmHCvFIyoGzChQIS6lg8foKyi3I2QQ1HIb8cJ80ByxpjbsZaX8dTug-mKKTMlRdLn9hU2tJXJEc1RHuWVxD_rvTVLuS_JcB5lXgGuHCw4J6Xlv598CStKzCuUkl5rQnSyfw0NqwcqwwEeGY1L31dU1NWOFHxPosjuBKB0vXMJSLcyWPjk7NcUJv4SEZAA24llQgRSFQcdA7UmBo97i43luxOwCmsJ5oR0A8M39dUjicUzjQRbFjOeiXGejKysHsiviU5dJoIJlt_C4xZQYyzOCt4WKh-PW1L87waiScH82rU1L5mun-_yzyFlaVKpFcyg_3NQavV7vzuHAuigRL3ka2EmkQba5nBl091P6GlkKzQBA5h6qBTJ-Fk5DeU2h9CkPJTxeO8DPrhmCoD30SL-9TO7MryCb9XDpPrzkbp9bHsH2kJRvequffksK0Y5K2epklTQT3Mso6idIQyscRgvEdmtCyVM_aGkIwWal4iPF-43BlsX_KQtehbv_0KYE5A1y1y4a5WmrLVdEftX3acuLmGDQGoFFVLT0TN6tFqNxKfBLWWfnjurf02scCpcM2ZXOVKUKS68tByaL0ShVYkQbsWF62WwJV8-ksz2-Q=w1920-h1440-no");
        urls.add("https://lh3.googleusercontent.com/L-Vnvs3bQojUymA9PgeNXr-yYC3bgQcJ7mcaPlACGxBzLXEXri6DQ3Sa_-MeXnt0_2M4SCjekCURBK7ucSJoSfJsL7Rrx72zoJcCbvu2HHYw9bMSNpB8Dvv6kMw1nB910WkfofXHP0pROSN8Fahu5vBsMCbdh548Rb0bEEDE_p4cQQGtostk0Gg_h6-N7t1jUrb_xaV2oy4kLzVoIJ2vlV9ZbwYE4aKVFf2eS_XLCLb6FR8Mr6hjX9DOsyUIVizfBXzmRNaKBS4Ipb5v4ZusN9kAixUj6o4id9sKeMmxATPt4kQr_jUfb2n3UrKHGDdFNB8V-Wm3dAIi2k-Wtpwbkr7rxTaSd52yzlJ9I8o4wfJj9324dm4sRMuPX7v7yPhc22C7E6PnQIPsu_wER4QOPAPDd5Hvrj7DMXjwh01rNakl_JaEc0wmf6QOThNzPXKW_N9mnmW-6X09bBOKIhDYxk1XH2rSvIBGk0GKZkTgc4oPuF4XgGYhebGJJ6ZhGcPQy760dxf7UKnxojrtpF1ljWdGOCE1Wsv_Eo5aAunYlbM9A45seuXMuHpFIooiRG0fS7BWCWzDaHjhZ238r7RwPKqX40xboXkHzRNlCGFs0LJMRNC_9A=w1920-h1440-no");
        urls.add("https://lh3.googleusercontent.com/nrVDUjv6VRTboujFYjSaxQQc_3AlqXA9SzL2e1uPLy2K9GjTBQmECG9MhVGn8GZjsmZvOrAo40KifQahIfgc7Ah1wGuTnTxxuzE14VmSQ8FUnnH9aeQPe1Rn15LjzgNXiQAdiwLemBdFD7_IFPNS1Fh7OkA6znQJHnSMmsA_W-u2Sg6UZtFyp9ldmI457T6BJTylHmVqt1vabo-gKyBC7z7SSXyTTbrFU_VkWR6am4eMmVxIisQKm5sG6-feU5xGF0_ZFqgECPB666mcR1lcR7hyJAC3paZQu2wbEAjieAr0-saDEld0eE_oUmF-CoHFx4OGQe4DGIwS217dfy3d2akOcVlMmhSZRDIa-X8ZkVUiNypoD-_ztS55Tj4oQ54kbJZUioXBdURmjeJvd_dWSDI_Xp_xsM1RgT2HiFmPGK7XS20VwYq-m7_Bp_Il_P4zDGD3-AIn0w1QpcY9m9aBRB3Bp0-xN3h4-dbduiGvL_PD_dxkqVHJ1fnFkmrYGJtyvykwieqpJYltfUH3EG7LA1UtF222Aa_2CFWE5uLOxtVqZvA2Gj-vSP-21jqK2ULRidoDStXVdu02ftR8Ibk0PmCqbTQS7yLBwlKe-1Xy6h6fceyF5Q=w1920-h1440-no");
        urls.add("https://lh3.googleusercontent.com/Iilin62HOOS-5guaQ-KBRRNYdiNgIek5j0NxIo0Wr3FwGTAhTBhoCtq7Li_Grpsw2ccAxS4uWNL1vhBdSHUM6Tez13ZvglPlXdwbmkg0DySiCOjf8r4fExjtn8VJJVTR1k9aWiSxKXCL3yPAHt2UTfKq1xhcpWkdRV6HhtvHN74uYipHfjfoD5hxiODeU7H4Yd-HlN6S_pvB7K4qQrYvaNKQBX6rqFewxayGzEF8k__F6xs-ktjBhDBkKUHHp-yHqknoYVly5KTQNX8i3qah2HdknIQDdMLU_Nr_4Mc1XsB1jf8qYXvyWESceCfLYLNIpEv-AnHyL4kzf045IyWMo6PVjZUbaHRYXBLUgC2_um9w356iOpM2-W7bNZ8uG6puAacupHbM1SbpwCCOlk5HEQdvzXQIVQOFZ_3XePIfmNz0TyIw-5iORrHOy9UhWBWITLVD0x5dGQGLfhg4QaG0TIdmbK6R7reqGhynX6Lb3t6qqf8GZj_9-q4fsLU0csIJmlC5xNDHLGxcG_VP-VDsX4NKmGwbC5Lkg8JsrJlF756tuwYaz0ixi2-QElorhZFP6w3ZxbDLAbOa-dGMMTnOGT5wBghOI4mfPDkLcLsTNJaRUkLDDA=w1920-h1440-no");
        urls.add("https://lh3.googleusercontent.com/_7N7gAcJFVKburNysQtZNcNRYXBXPRISkEOVDSy30sRD89klc4XGX-9Dq2qVspyMN5I7NA6RspY7nFDI6nMAm-KW0R4aAcjUsBe2Fdw3cFxHica4vP6pq52jBqXHtmVLwYC85J2gHhGMbRif0_HBJ1HH2_aRtiGcqXoYa7V357bQS4ohPP1pmtbupoNSu8BIBZVhlB6uMl8AWOk8RgWVBvwoClc2tXm4hMT0d5OXAva4_zasK_AhUCZc3HLwbhFMH7JjKNOQWltasZqMMy2bR7pofc8RkOttssIineSFzF3n2s0CV_mm6gWgelRejkdL-6mApADY24lDsbiZFd8m59oAz3byeXMGisfYLouypDf1Lzt2Hw8vWAX2pfJDSljZBuyYMJyY_Ls_3RYyuRNwrKQxQiNnmtRn-saTLsW9XEFpT0HM2qEY7INUiu88vSjyZPXdA_VXPcdxnTTHrb0fY-_XPBinUeJpouNw2k_Taw7u71vIYJtDkMDDJqJIF7osMV6Oekd89-jSGUZCmnnIwI2BU0dE1NNA3Zre3XFg3sX3H-TY_sS5OrujOKqBjiBkfjjgpq6czc0dmF_Ks9n96dwFje6td_GNuyZumKYLUUzbrc1m5A=w1920-h1440-no");
        urls.add("https://lh3.googleusercontent.com/bz_PlpfHX2WWTnzgOIATuaJbloJTaUsYh2RKsthIXgEFRbIM1C-Iqyi71-DdXSy8a5XmA3ig2LDjOEizC8ehW4NBJ_GA7UA4M-BoFh_K1BAhc0ihsMUmyEX_jjZnocoOqi9Jv3RRlvFjoONU8u4JGTKkt9E1FEDPMqJHpGktrg8VkG0egBa0tFk3FRomovlKYhRc1CmRxoBj3iblC3lDMkbdlr841dt49vw5PuUU2D4E0SIaooqk4ZxJiO7y6kd7rz72T2Ci_cpDJrsdyVMY7GkxdfayqzoCF_mT8HufEYFPklFyjsn6SSozMOsekxr8lRCaT6PRo2DkRK8easaZ68VgXVv1rSpkZh-J5kINmNrTmGxMN0vAoSnBzb-gihnwjEH7yQigm9ufEtj7KboMMP_gB_Vvr8JttRZTN1Q56A21rvCXqBh89ODdVHI6SgIJLzjLIS4RjCp1BRRumlIhac2RVDeMLiY0Atkknshg2FqZf4Gdd2b-iztKvRR1k0P-axgrlKcLiGVmAE3LLLEEZKw2p-vhVw7bcH6SYK3Ki1J1WakKdf1umGVaJpXYTZDxwjzCrg9oBaaLJAws9E4PZasbt9C10qrNJIJ3oHbx-pIw51ZiwA=w1920-h1440-no");
        urls.add("https://lh3.googleusercontent.com/92bz1RLB17e7ExgLpnPgsGx2IEjzILCzzD8Yr3DINt-YEts14LYWAjszzeyxF4-uuWxGSr5VP6iRCBz_tgQkyc5aTKtQgMpK7ZKbcbTcgsqf2UlNHUOrCCzpAv1IEa9ewsiB7JJT2vJapVLwOglY3vK1XPZmfEbtgu8Y3UJVyUAJ2iEyJAZLKKqc1W1xOMgrgjOn2r9DtvK-Zm-ZC99PbOmChA5z-TG-Q2qYtTN-KZhyQFtH4ZGGm64TX_EBEBLkGarrh_LHSzFkZpwPfoAPB2wGiWxCGakb7jSrOBACm6wF30X3lJ78LqJcGqNBzOfk4_y6lDV2WUdODPE9KnKZxKN2ZK5XmDd6lOrksweLQ36kmDxbwQkbh6oSngxvTGPqysKKvRoq6O8dhC9aZ4fmMIQUBhIvMOwrqrXIjOmsj7V_9hiu6WtCRDqdcIBCF3ABebvtlf54KAlF4dUkoYc1oRpiMzWl9NWa14DjtwUNG46ybLD4pYZrkUqKj676CD0C7XY0gJsXThrbU-8if2CmykxDkh6w9_qt5SMsNlh5EU3ilZAn_dzIsTN00orX92w5w1-wQlbBEhlsVKaHtgiWOFDJDXaCmbZVrBlQ2_xmlaHu5jfwbQ=w1920-h1440-no");
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

    private Company createMyFirstBusiness() {
        Company kwilt = new Company();
        kwilt.setName("My First Business");
        kwilt.setDescription("");
        kwilt.setLocation("Ottawa, ON, Canada");
        kwilt.setWebsiteUrl(null);
        kwilt.setLogoUrl("http://www.disruptiveadvertising.com/wp-content/uploads/2015/06/lightbulb_blogpic-65.jpg");
        kwilt.setFeaturedImageUrls(createMyFirstBusinessFeaturedImageUrlArray());
        kwilt.setTags(createMyFirstBusinessTagsArray());
        return kwilt;
    }

    private List<String> createMyFirstBusinessFeaturedImageUrlArray() {
        List<String> urls = new ArrayList<>();
        urls.add("");
        urls.add("");
        urls.add("");
        urls.add("");
        urls.add("");
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
