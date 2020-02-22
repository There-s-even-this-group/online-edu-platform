package com.training.onlineeduplatform.model;

import lombok.Data;

import java.sql.Date;

/**
 * Created on 2020/2/22.
 *
 * @author Hongwe Xiong
 */
@Data
public class OpenClass {
    private int public_classID;
    private String teacherID;
    private String public_className;
    private String public_classType;
    private String public_classPicture;
    private String MallType;
    private String MainSpeaker;
    private int Sign_Number;
    private String Syllabus;
    private String TeachingWay;
    private String IntroducingCourse    ;
    private String IntroducingSpeaker;
    private Date CreateDate;
    private Date StartClassDate;
    private String BeginClassTime;
    private String EndClassTime;
    private String MatchStudent;
    private String LectureGuide;
    private int PriceClass;
    private int LikeTimes;
    private String GatherPlace;
    private String ClassStage;
    private String ClassGroup;
}
