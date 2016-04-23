package com.kochiyasanae.kancollehelper.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KochiyaSanae on 2016/3/13.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String Create_Gaixiu="create table Gaixiu(id integer primary key autoincrement,leibie1 text,leibie2 text,mingcheng text,mubiao1 text,mubiao2 text,ran integer,dan integer,gang integer,lv integer,zicai1 text,luosi1 text,zhuangbei1 text,zicai2 text,luosi2 text,zhuangbei2 text,zicai3 text,luosi3 text,zhuangbei3 text,gaixiujian text,zhouri text,zhouyi text,zhouer text,zhousan text,zhousi text,zhouwu text,zhouliu text,youxianji integer,guanzhuxinpin text)";
    public static final String Create_Yuanzheng="create table Yuanzheng(id integer primary key autoincrement,bianhao text,haiyu text,mingcheng text,nandu text,haoshi1 text,haoshi2 text,haoshi3 integer,shouyiran integer,shouyidan integer,shouyigang integer,shouyilv integer,jiangli11 text,jiangli12 integer,jiangli21 text,jiangli22 integer,tidujingyan integer,jianniangjingyan integer,qijiandengji integer,hejidengji integer,yuanzhengyaoqiu text,yuanzhengbeizhu text,xiaohaoran1 text,xiaohaoran2 integer,xiaohaoran3 integer,xiaohaodan1 text,xiaohaodan2 integer,xiaohaodan3 integer,suoshujiandui text,yuanzhengcishu integer)";
//    public static final String Create_Yuanzhengdui="create table Yuanzhengdui(id integer primary key autoincrement,yuanzhengdui text,yuanzhengpeizhi text,dafadongting integer)";

    public static final String Create_Renwu="create table Renwu(id integer primary key autoincrement,bianhao text,leibie1 text,leibie2 text,mingcheng text,miaoshu text,renwubeizhu text,shouyiran integer,shouyidan integer,shouyigang integer,shouyilv integer,daojushouyi1 text,daojushuliang1 integer,daojushouyi2 text,daojushuliang2 integer,qitashouyi text,qianzhibianhao1 text,qianzhirenwu1 text,qianzhibianhao2 text,qianzhirenwu2 text,qitaneirong text,teshurenwu text,haiyuditu text)";
    public static final String Create_Renwugonglue="create table Renwugonglue(id integer primary key autoincrement,bianhao text,buchongneirong text,jianduipeizhi text,peizhuang1 text,beizhu1 text,peizhuang2 text,beizhu2 text,peizhuang3 text,beizhu3 text,peizhuang4 text,beizhu4 text,peizhuang5 text,beizhu5 text,peizhuang6 text,beizhu6 text)";







    private Context mContext;


    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL(Create_Gaixiu);
        db.execSQL(Create_Yuanzheng);
//        db.execSQL(Create_Yuanzhengdui);
        db.execSQL(Create_Renwu);
        db.execSQL(Create_Renwugonglue);

        db.beginTransaction();
        db.execSQL("INSERT INTO Gaixiu VALUES ('1','主炮','小口径主炮','12.7cm连装炮','12.7cm连装炮B型改二',null,'10','30','60','0','1/2','1/2',null,'1/2','1/2','12.7cm连装炮×1','2/3','3/6','12.7cm连装炮×2','全舰均可','全舰均可','全舰均可','全舰均可','全舰均可','全舰均可','全舰均可','全舰均可','10',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('2','主炮','小口径主炮','12.7cm连装炮B型改二','12.7cm连装炮B型改二','★max','10','40','70','0','2/2','2/3',null,'2/2','2/4','12.7cm连装炮B型改二×1',null,null,null,'夕立改二/绫波改二',null,'夕立改二/绫波改二','夕立改二/绫波改二','夕立改二/绫波改二',null,null,null,'40',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('3','主炮','小口径高角主炮+高射装置','10cm连装高角炮+94式高射装置','10cm连装高角炮+94式高射装置','★max','10','60','150','50','6/7','3/4',null,'5/8','4/7','10cm连装高角炮×2',null,null,null,'秋月/照月','照月','秋月','秋月','秋月','秋月/照月','照月','照月','61',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('4','主炮','中口径主炮','14cm单装炮','14cm连装炮',null,'10','50','80','0','1/2','1/2',null,'1/2','1/2','14cm单装炮×1','3/4','3/6','14cm单装炮×2','全舰均可','全舰均可','全舰均可','全舰均可','全舰均可','全舰均可','全舰均可','全舰均可','5',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('5','主炮','中口径主炮','14cm连装炮','14cm连装炮','★max','10','60','100','0','2/2','1/2',null,'2/4','2/3','14cm连装炮×1',null,null,null,'夕张',null,'夕张',null,null,'夕张',null,null,'39',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('6','主炮','中口径主炮','15.2cm连装炮','15.2cm连装炮改',null,'10','70','100','0','2/3','2/3',null,'2/3','2/4','15.2cm连装炮×1','5/8','4/10','22号对水上电探×1','阿贺野/能代/矢矧','能代','能代/矢矧','矢矧','矢矧','阿贺野/矢矧','阿贺野/能代','阿贺野/能代','50',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('7','主炮','中口径主炮','15.2cm连装炮改','15.2cm连装炮改','★max','20','80','100','30','3/4','2/3','15.2cm连装炮×1','4/6','3/6','15.2cm连装炮×1',null,null,null,'矢矧/酒匂','酒匂','酒匂','酒匂','矢矧','矢矧','矢矧','矢矧/酒匂','62',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('8','主炮','中口径主炮','15.5cm三联装炮','15.5cm三联装炮','★max','10','90','120','0','2/2','2/3',null,'2/3','2/4','15.5cm三联装炮×1',null,null,null,'最上/大淀','大淀','大淀',null,null,null,'最上','最上','35',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('9','主炮','中口径主炮','20.3cm连装炮','20.3cm(2号)连装炮',null,'10','90','120','0','1/2','2/3',null,'2/3','2/3','20.3cm连装炮×1','2/5','4/10','20.3cm连装炮×2','青叶/衣笠','青叶/衣笠','衣笠','衣笠','衣笠','青叶/衣笠','青叶/衣笠','青叶/衣笠','15',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('10','主炮','中口径主炮','20.3cm(2号)连装炮','20.3cm(3号)连装炮',null,'10','100','130','0','2/3','2/3',null,'2/4','2/4','20.3cm(2号)连装炮×1','4/8','4/11','20.3cm(2号)连装炮×1','妙高','妙高','妙高','妙高',null,null,null,null,'25',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('11','主炮','中口径主炮','20.3cm(3号)连装炮','20.3cm(3号)连装炮','★max','10','110','140','0','3/4','2/3',null,'3/5','3/5','20.3cm(3号)连装炮×1',null,null,null,'三隈',null,null,'三隈','三隈',null,null,null,'90',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('12','主炮','大口径主炮','35.6cm连装炮','试制35.6cm三连装炮',null,'20','240','300','0','2/3','1/2',null,'3/4','2/4','35.6cm连装炮×1','6/12','5/12','35.6cm连装炮×3','扶桑','扶桑',null,null,null,null,'扶桑','扶桑','34',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('13','主炮','大口径主炮','35.6cm连装炮(炫光迷彩)','35.6cm连装炮(炫光迷彩)','★max','30','250','300','30','3/4','2/3','35.6cm连装炮×1','4/5','3/5','35.6cm连装炮×2',null,null,null,'榛名改二','榛名改二','榛名改二','榛名改二','榛名改二',null,null,'榛名改二','54',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('14','主炮','大口径主炮','38cm连装炮','38cm连装炮改','★+3','20','380','450','20','4/5','2/3','35.6cm连装炮×1','5/8','3/5','35.6cm连装炮×2','10/20','6/13','41cm连装炮×2','Bismarck',null,null,null,null,'Bismarck','Bismarck','Bismarck','25',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('15','主炮','大口径主炮','38cm连装炮改','38cm连装炮改','★max','30','390','470','30','5/7','3/4','41cm连装炮×1','6/9','4/6','41cm连装炮×2',null,null,null,'Bismarck','Bismarck','Bismarck','Bismarck',null,null,null,null,'80',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('16','主炮','大口径主炮','试制35.6cm三连装炮','试制35.6cm三连装炮','★max','30','330','390','30','4/6','3/4','35.6cm连装炮×2','6/9','4/7','35.6cm连装炮×3',null,null,null,'金刚改二/榛名改二/扶桑改二/山城改二','山城改二',null,null,'金刚改二/扶桑改二','金刚改二/榛名改二/扶桑改二/山城改二','榛名改二/扶桑改二/山城改二','扶桑改二/山城改二','84',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('17','主炮','大口径主炮','381mm/50三连装炮','381mm/50三连装炮改','★+3','30','400','480','20','4/5','2/3','35.6cm连装炮×1','5/8','3/5','35.6cm连装炮×2','12/20','7/14','25mm连装机枪×2','Littorio/Italia/Roma','Roma','Roma','Littorio/Italia','Littorio/Italia','Littorio/Italia','Littorio/Italia','Roma','28',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('18','主炮','大口径主炮','41cm连装炮','41cm连装炮','★max','30','350','480','0','3/4','2/3','41cm连装炮×1','4/7','3/6','41cm连装炮×2',null,null,null,'长门/陆奥','陆奥','陆奥','长门',null,'陆奥','长门','长门','62',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('19','主炮','大口径主炮','381mm/50三连装炮改','381mm/50三连装炮改','★max','40','440','500','40','5/7','3/4','41cm连装炮×1','7/10','4/6','41cm连装炮×2',null,null,null,'Littorio/Italia/Roma','Littorio/Italia','Littorio/Italia','Roma','Roma','Roma','Roma','Littorio/Italia','79',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('20','主炮','大口径主炮','试制41cm三连装炮','试制41cm三连装炮','★max','40','440','620','40','5/7','4/6','41cm连装炮×2','8/10','5/8','41cm连装炮×3',null,null,null,'长门改/陆奥改','长门改','长门改','陆奥改','长门改/陆奥改','长门改','陆奥改','陆奥改','89',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('21','主炮','大口径主炮','试制46cm连装炮','46cm三连装炮','★+5','40','420','650','40','5/6','3/5','41cm连装炮×2','6/8','4/7','41cm连装炮×3','12/18','8/14','41cm连装炮×4','大和/武藏','大和','大和','武藏','武藏',null,null,null,'59',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('22','主炮','大口径主炮','46cm三连装炮','46cm三连装炮','★max','50','480','800','50','6/8','4/6','46cm三连装炮×1','8/10','5/8','46cm三连装炮×2',null,null,null,'大和/武藏','武藏','武藏',null,null,null,'大和','大和','82',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('23','主炮','大口径主炮','试制51cm连装炮','试制51cm连装炮','★max','50','550','950','80','7/9','5/7','46cm三连装炮×2','10/15','7/10','46cm三连装炮×3',null,null,null,'大和改/武藏改',null,'大和改/武藏改','大和改','武藏改',null,null,null,'89',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('24','副炮','常规副炮','15.2cm单装炮','15.2cm连装炮',null,'10','60','90','0','2/2','1/2',null,'2/3','2/3','15.2cm单装炮×1','3/4','3/5','15.2cm单装炮×2','阿贺野/金刚/山城','阿贺野/金刚','阿贺野/金刚/山城','阿贺野/山城','山城',null,null,'金刚','1',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('25','副炮','常规副炮','OTO 152mm三连装速射炮','OTO 152mm三连装速射炮','★max','10','90','120','0','2/3','2/3',null,'3/4','3/5','15.5cm三连装炮×1',null,null,null,'Littorio/Italia/Roma','Littorio/Italia/Roma','Roma','Littorio/Italia','Littorio/Italia','Roma','Roma','Littorio/Italia','76',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('26','副炮','高角副炮+高射装置','90mm单装高角炮','90mm单装高角炮','★max','10','20','70','10','1/2','1/2','10cm连装高角炮×1','2/3','1/2','10cm连装高角炮×2',null,null,null,'Littorio/Italia/Roma','Roma','Littorio/Italia','Littorio/Italia','Littorio/Italia','Littorio/Italia/Roma','Roma','Roma','83',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('27','鱼雷','常规鱼雷','61cm三连装鱼雷','61cm三连装(酸素)鱼雷',null,'50','70','60','20','1/2','1/1',null,'2/3','1/2','61cm三连装鱼雷×1','3/5','2/4','61cm三连装鱼雷×2','吹雪/丛云','丛云','丛云','丛云',null,'吹雪','吹雪','吹雪','11',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('28','鱼雷','常规鱼雷','61cm四连装鱼雷','61cm四连装(酸素)鱼雷','★+3','70','100','70','20','1/2','1/2',null,'2/3','1/2','61cm四连装鱼雷×1','3/5','3/6','61cm四连装鱼雷×2','全舰皆可','全舰皆可','全舰皆可','全舰皆可',null,null,'全舰皆可','全舰皆可','14',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('29','鱼雷','酸素鱼雷','61cm三连装(酸素)鱼雷','61cm四连装(酸素)鱼雷','★+5','60','90','60','20','1/2','1/1',null,'3/5','1/3','61cm三连装鱼雷×1','4/8','3/6','61cm四连装鱼雷×2','吹雪改二',null,null,null,null,'吹雪改二','吹雪改二','吹雪改二','17',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('30','鱼雷','酸素鱼雷','61cm四连装(酸素)鱼雷','61cm五连装(酸素)鱼雷',null,'80','120','80','20','2/3','1/2',null,'4/8','2/4','61cm四连装(酸素)鱼雷×1','5/10','5/11','61cm四连装(酸素)鱼雷×3','北上/大井','北上/大井','北上/大井','北上/大井','北上/大井','北上/大井','北上/大井','北上/大井','48',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('31','鱼雷','酸素鱼雷','61cm五连装(酸素)鱼雷','61cm五连装(酸素)鱼雷','★max','100','150','90','30','3/4','3/5',null,'5/9','3/7','61cm五连装(酸素)鱼雷×1',null,null,null,'岛风',null,null,null,'岛风','岛风',null,null,'91',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('32','水上飞机','水上侦察机','Ro.43水侦','Ro.44水上战斗机',null,'60','30','0','180','3/5','1/2','零式水上侦察机×1','4/6','3/5','瑞云×1','5/10','3/5','零式水上侦察机×2','Italia/Roma改/Zara改','Italia','Zara改','Roma改/Zara改','Roma改/Zara改','Zara改','Zara改','Italia','54',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('33','水上飞机','水上侦察机','零式水上侦察机','二式水战改',null,'90','20','0','300','4/6','2/3','零式水上侦察机×1','5/8','3/5','零式水上侦察机×2','9/15','5/10','零式舰战21型×3','千岁甲/千代田甲/秋津洲改/瑞穗','秋津洲改/瑞穗','瑞穗','瑞穗','千代田甲','千代田甲/秋津洲改','千岁甲/秋津洲改/瑞穗','千岁甲/秋津洲改/瑞穗','56',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('34','水上飞机','水上侦察机','零式水上观测机','零式水上观测机','★max','90','40','0','270','4/6','3/5','瑞云×1','6/9','4/7','零式水上观测机×1',null,null,null,'武藏/瑞穗','瑞穗','瑞穗','瑞穗','瑞穗','武藏','武藏','武藏/瑞穗','76',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('35','电探/雷达','小型电探','13号对空电探','13号对空电探改',null,'10','0','20','30','4/6','2/3',null,'5/7','3/5','13号对空电探×1','10/15','5/12','21号对空电探×1','五十铃改二/时雨改二/秋月/照月','五十铃改二/时雨改二','五十铃改二/照月','秋月/照月','秋月/照月','时雨改二/秋月','五十铃改二/时雨改二','五十铃改二/时雨改二','26',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('36','电探/雷达','小型电探','13号对空电探改','13号对空电探改','★max','10','0','30','40','5/7','3/4','13号对空电探×1','7/9','4/8','13号对空电探×2',null,null,null,'矶风改/初霜改二/雪风','初霜改二/雪风','雪风','雪风','雪风','矶风改','矶风改/初霜改二','矶风改/初霜改二','48',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('37','电探/雷达','小型电探','22号对水上电探','22号对水上电探改四',null,'10','0','30','30','4/5','2/3','22号对水上电探×1','7/10','3/5','22号对水上电探×2','10/20','8/14','22号对水上电探×3','日向/夕云/岛风','日向','日向/夕云','夕云','岛风','岛风','日向/夕云/岛风','日向/夕云/岛风','43',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('38','电探/雷达','小型电探','22号对水上电探改四','22号对水上电探改四','★max','10','0','40','40','5/8','3/4','22号对水上电探×1','8/10','4/8','22号对水上电探改四×1',null,null,null,'金刚改二/妙高改二/羽黑改二','妙高改二/羽黑改二','羽黑改二','金刚改二','金刚改二','金刚改二/妙高改二','金刚改二/妙高改二/羽黑改二','妙高改二/羽黑改二','66',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('39','电探/雷达','大型电探','21号对空电探','21号对空电探改',null,'10','0','40','50','5/6','2/3',null,'6/8','3/5','21号对空电探×1','12/16','5/13','21号对空电探×2','伊势/日向','伊势','伊势',null,'日向','日向','伊势/日向','伊势/日向','39',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('40','电探/雷达','大型电探','21号对空电探改','21号对空电探改','★max','10','0','60','70','6/8','2/3','21号对空电探×1','10/12','4/8','21号对空电探×2',null,null,null,'大和/武藏','大和',null,'武藏','武藏','大和/武藏','大和/武藏','大和','49',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('41','电探/雷达','大型电探','32号对水上电探','32号对水上电探改',null,'10','0','60','50','6/10','3/4','22号对水上电探×1','12/15','4/7','22号对水上电探×2','15/22','10/15','32号对水上电探×1','伊势/日向','日向','日向','日向','伊势','伊势','伊势','伊势','53',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('42','电探/雷达','大型电探','32号对水上电探改','32号对水上电探改','★max','10','0','100','80','10/15','5/6','22号对水上电探×3','14/18','7/10','32号对水上电探×1',null,null,null,'伊势/日向','伊势','伊势','伊势','日向','日向','日向','日向','54',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('43','对潜装备','爆雷','九四式爆雷投射机','三式爆雷投射机','★+3','10','60','20','20','1/2','1/2',null,'2/3','1/3','九四式爆雷投射机×1','3/6','3/8','九四式爆雷投射机×2','全舰皆可',null,null,null,'全舰皆可','全舰皆可',null,null,'8',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('44','对潜装备','爆雷','三式爆雷投射机','三式爆雷投射机','★max','10','80','20','30','3/3','2/2',null,'3/5','2/4','三式爆雷投射机×1',null,null,null,'五十铃改二',null,null,null,'五十铃改二','五十铃改二',null,null,'66',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('45','对潜装备','声纳','九三式水中听音机(进化分支一)','三式水中探信仪','★+3','10','0','30','30','2/2','1/2',null,'3/4','2/3','九三式水中听音机×1','6/9','3/5','九三式水中听音机×2','夕张/五十铃改二','夕张','五十铃改二',null,null,null,'夕张','夕张','8',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('46','对潜装备','声纳','九三式水中听音机(进化分支二)','四式水中听音机',null,'10','0','30','30','2/2','1/2',null,'3/4','2/3','九三式水中听音机×1','10/20','6/12','三式水中探信仪×2','五十铃改二/香取改/时雨改二','香取改/时雨改二',null,null,null,'五十铃改二/时雨改二','五十铃改二/香取改/时雨改二','香取改/时雨改二','74',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('47','对潜装备','声纳','三式水中探信仪','三式水中探信仪','★max','10','0','30','50','4/5','2/3',null,'5/7','3/5','三式水中探信仪×1',null,null,null,'夕张/五十铃改二','五十铃改二',null,'夕张/五十铃改二','夕张/五十铃改二',null,null,null,'56',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('48','对潜装备','声纳','四式水中听音机','四式水中听音机','★max','10','0','50','60','5/7','3/5','九三式水中听音机×2','6/10','4/6','四式水中听音机×1',null,null,null,'五十铃改二/香取改/秋月改/照月改','秋月改','香取改','香取改','照月改','五十铃改二','五十铃改二','五十铃改二','58',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('49','对舰装备','对舰强化弹','九一式穿甲弹','一式穿甲弹',null,'30','150','310','10','2/3','1/1',null,'3/5','1/2','九一式穿甲弹×1','6/9','4/9','九一式穿甲弹×3','比睿/雾岛','雾岛','雾岛',null,'比睿','比睿','比睿/雾岛','比睿/雾岛','82',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('50','对舰装备','对舰强化弹','一式穿甲弹','一式穿甲弹','★max','30','170','330','20','3/5','1/1','九一式穿甲弹×2','4/6','2/4','一式穿甲弹×1',null,null,null,'金刚/榛名','金刚','榛名','榛名','榛名',null,'金刚','金刚','75',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('51','对空装备','对空机枪','25mm单装机枪','25mm连装机枪','★+5','0','10','10','10','0/1','1/1',null,'1/2','1/1','25mm单装机枪×1','2/3','1/2','25mm单装机枪×1','皋月/文月','皋月','皋月',null,'文月','文月','皋月/文月','皋月/文月','1',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('52','对空装备','对空机枪','25mm连装机枪','25mm三连装机枪','★+3','0','20','10','10','0/1','1/1',null,'1/2','1/2','25mm连装机枪×1','2/3','1/2','25mm连装机枪×1','五十铃改二','五十铃改二',null,null,null,null,'五十铃改二','五十铃改二','1',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('53','对空装备','对空机枪','25mm三连装机枪','25mm三连装机枪 集中配备',null,'30','20','10','30','1/2','1/1',null,'1/3','1/2','25mm三连装机枪×1','5/9','3/7','25mm三连装机枪×5','摩耶(无法进化)/摩耶改二/五十铃改二','摩耶改二','摩耶改二/五十铃改二','摩耶(无法进化)/五十铃改二','摩耶(无法进化)/五十铃改二','摩耶(无法进化)','摩耶改二','摩耶改二','24',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('54','对空装备','高射装置','91式高射装置','94式高射装置',null,'0','0','60','40','3/4','1/2',null,'3/5','2/4','12.7cm连装高角炮×1','4/9','4/7','10cm连装高角炮×2','摩耶/秋月/照月','摩耶/秋月/照月','摩耶/秋月',null,null,'照月','摩耶/秋月/照月','摩耶/秋月/照月','22',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('55','对空装备','高射装置','94式高射装置(进化分支一)','10cm连装高角炮+94式高射装置',null,'0','0','80','70','4/5','2/3',null,'4/6','3/5','10cm连装高角炮×1','8/10','5/10','10cm连装高角炮×2','秋月/照月/初月/吹雪改二','秋月/照月/初月/吹雪改二','秋月/照月','秋月/照月','秋月/照月','秋月/照月/吹雪改二','秋月/照月/初月/吹雪改二','秋月/照月/初月/吹雪改二','44',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('56','对空装备','高射装置','94式高射装置(进化分支二)','12.7cm连装高角炮+94式高射装置',null,'0','0','80','70','4/5','2/3',null,'4/6','3/5','12.7cm连装高角炮×1','7/9','5/9','12.7cm连装高角炮×2','摩耶改二','摩耶改二',null,null,null,'摩耶改二','摩耶改二','摩耶改二','43',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('57','对陆装备','登陆艇','大发动艇','大发动艇(八九式中战车&陆战队)',null,'50','30','30','10','1/2','1/2','鼓桶(运输用)×1','1/4','2/3','7.7mm机枪×1','4/8','3/7','12.7mm单装机枪×3','秋津丸/阿武隈改二/皋月改二','秋津丸/阿武隈改二/皋月改二','秋津丸/阿武隈改二/皋月改二','秋津丸/皋月改二','秋津丸/皋月改二','秋津丸','秋津丸/阿武隈改二','秋津丸/阿武隈改二','76',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('58','对陆装备','登陆艇','大发动艇(八九式中战车&陆战队)','特二式内火艇',null,'70','80','120','30','3/5','2/3','25mm单装机枪×1','4/8','3/5','12cm30连装喷进炮×2','10/18','5/9','7.7mm机枪×3','秋津丸/阿武隈改二/皋月改二','秋津丸','秋津丸','阿武隈改二','阿武隈改二','阿武隈改二/皋月改二','秋津丸/皋月改二','秋津丸/皋月改二','70',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('59','对陆装备','特型内火艇','特二式内火艇','特二式内火艇','★max','80','90','100','70','5/8','3/4','7.7mm机枪×2','8/12','4/6','12.7mm单装机枪×3',null,null,null,'伊8/伊58/伊401','伊58','伊58/伊401','伊401','伊8/伊401','伊8/伊401','伊8/伊58','伊8/伊58','68',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('60','夜战装备','探照灯','探照灯','96式150cm探照灯',null,'10','0','30','20','3/3','2/3',null,'3/5','2/4','探照灯×1','5/10','3/7','熟练见张员×1','青叶/神通/绫波/晓','神通','青叶/绫波','青叶/绫波','青叶/绫波','晓','神通/晓','神通/晓','87',null)");
        db.execSQL("INSERT INTO Gaixiu VALUES ('61','夜战装备','大型探照灯','96式150cm探照灯','96式150cm探照灯','★max','20','0','70','30','4/5','3/4','探照灯×1','5/10','3/7','探照灯×1',null,null,null,'比睿/雾岛','比睿','比睿','雾岛','雾岛','雾岛','比睿/雾岛','比睿','48',null)");


        db.execSQL("INSERT INTO Yuanzheng VALUES ('1','远征1','镇守府海域','练习航海','E','15分钟','00:15','15','0','30','0','0',null,null,null,null,'10','10','1',null,'最低2只，舰种自由。',null,'30%','9','36','0%','0','12',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('2','远征2','镇守府海域','长距离练习航海','E','30分钟','00:30','30','0','100','30','0','高速修复材','1',null,null,'20','15','2',null,'最低4只，舰种自由。','该远征拥有极高的弹药、高速修复材收益。','50%','30','54','0%','0','12',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('3','远征3','镇守府海域','警备任务','D','20分钟','00:20','20','30','30','40','0',null,null,null,null,'30','30','3',null,'最低3只，舰种自由。','该远征拥有极高的钢材收益。','30%','14','36','20%','12','36',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('4','远征4','镇守府海域','对潜警戒任务','D','50分钟','00:50','50','0','60','0','0','高速修复材','1','家具箱(小)','1','30','40','3',null,'最低3只，轻巡洋舰×1，驱逐舰×2。','该远征拥有较高的高速修复材收益。','50%','28','60','0%','0','13',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('5','远征5','镇守府海域','海上护卫任务','C','1小时30分钟','01:30','90','200','200','20','20',null,null,null,null,'40','40','3',null,'最低4只，轻巡洋舰×1，驱逐舰×2，自由舰×1。','该远征拥有极高的燃料、弹药收益。','50%','35','60','0%','0','13',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('6','远征6','镇守府海域','防空射击演习','C','40分钟','00:40','40','0','0','0','80','家具箱(小)','1',null,null,'30','50','4',null,'最低4只，舰种自由。','该远征拥有极高的铝土矿收益。','30%','18','36','20%','16','36',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('7','远征7','镇守府海域','观舰式排演','C','1小时0分钟','01:00','60','0','0','50','30','高速建造材','1',null,null,'60','120','5',null,'全部6只，舰种自由。',null,'50%','45','54','0%','0','12',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('8','远征8','镇守府海域','观舰式','B','3小时0分钟','03:00','180','50','100','50','50','高速建造材','2','开发资材','1','120','140','6',null,'全部6只，舰种自由。',null,'50%','45','54','20%','24','36',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('9','远征9','南西诸岛海域','油轮护卫任务','C','4小时0分钟','04:00','240','350','0','0','0','家具箱(小)','1','高速修复材','2','60','60','3',null,'最低4只，轻巡洋舰×1，驱逐舰×2，自由舰×1。',null,'50%','35','60','0%','0','13',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('10','远征10','南西诸岛海域','强行侦察任务','C','1小时30分钟','01:30','90','0','50','0','30','高速修复材','1','高速建造材','1','40','50','3',null,'最低3只，轻巡洋舰×2，自由舰×1。',null,'30%','20','44','0%','0','14',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('11','远征11','南西诸岛海域','铝土矿护送任务','B','5小时0分钟','05:00','300','0','0','0','250','家具箱(小)','1','高速修复材','1','40','40','6',null,'最低4只，驱逐舰×2，自由舰×2。','该远征拥有较高的铝土矿收益。','50%','30','54','0%','0','12',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('12','远征12','南西诸岛海域','资源输送任务','B','8小时0分钟','08:00','480','50','250','200','50','家具箱(中)','1','开发资材','1','60','50','4',null,'最低4只，驱逐舰×2，自由舰×2。','该远征拥有合适的弹药、钢材收益。','50%','30','54','0%','0','12',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('13','远征13','南西诸岛海域','鼠输送作战','A','4小时0分钟','04:00','240','240','300','0','0','高速修复材','2','家具箱(小)','1','70','60','5',null,'全部6只，轻巡洋舰×1，驱逐舰×4，自由舰×1。',null,'50%','50','60','40%','52','65',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('14','远征14','南西诸岛海域','包围圈内陆战队撤退运输作战','A','6小时0分钟','06:00','360','0','240','200','0','高速修复材','1','开发资材','1','90','100','6',null,'全部6只，轻巡洋舰×1，驱逐舰×3，自由舰×2。','该远征拥有合适的弹药、钢材收益。','50%','50','60','0%','0','13',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('15','远征15','南西诸岛海域','诱饵机动部队支援作战','S','12小时0分钟','12:00','720','0','0','300','400','家具箱(大)','1','开发资材','1','100','160','9',null,'全部6只，正规航母(轻型航母、水上机母舰)×2，驱逐舰×2，自由舰×2。',null,'50%','65','78','40%','68','85',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('16','远征16','南西诸岛海域','舰队决战护卫作战','S','15小时0分钟','15:00','900','500','500','200','200','高速建造材','1','开发资材','2','120','200','11',null,'全部6只，轻巡洋舰×1，驱逐舰×2，自由舰×3。',null,'50%','50','60','40%','52','65',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('17','远征17','北方海域','敌方阵地侦察作战','A','45分钟','00:45','45','70','70','50','0',null,null,null,null,'30','40','20',null,'全部6只，轻巡洋舰×1，驱逐舰×3，自由舰×2。',null,'30%','30','40','40%','52','65',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('18','远征18','北方海域','舰载机运送作战','S','5小时0分钟','05:00','300','0','0','300','100',null,null,null,null,'60','60','15',null,'全部6只，正规航母(轻型航母、水上机母舰)×3，驱逐舰×2，自由舰×1。','该远征拥有合适钢材、铝土矿收益。','50%','80','96','20%','38','57',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('19','远征19','北方海域','北号作战','S','6小时0分钟','06:00','360','400','0','50','30','家具箱(小)','1','开发资材','1','60','70','20',null,'全部6只，航空战列舰×2，驱逐舰×2，自由舰×2。',null,'50%','125','150','40%','116','145',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('20','远征20','北方海域','潜水艇哨戒作战','S','2小时0分钟','02:00','120','0','0','150','0','开发资材','1','家具箱(小)','1','40','50','1',null,'最低2只，潜水艇(潜水航母)×1，轻巡洋舰×1。',null,'50%','18','57','40%','20','64',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('21','远征21','北方海域','北方鼠输送作战','S','2小时20分钟','02:20','140','320','270','0','0','家具箱(小)','1',null,null,'45','55','15','30','最低5只，轻巡洋舰×1，驱逐舰×4，至少3只舰娘各装备1只鼓桶(运输用)。','该远征拥有较高的燃料、弹药收益，并推荐采用“四闪四桶”的大成功配置。','80%','68','90','70%','77','104',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('22','远征22','北方海域','舰队演习','S','3小时0分钟','03:00','180','0','10','0','0',null,null,null,null,'45','400','30','45','全部6只，重巡洋舰×1，轻巡洋舰×1，驱逐舰×2，自由舰×1。',null,'80%','96','108','70%','116','132',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('23','远征23','北方海域','航空战列舰运用演习','S','4小时0分钟','04:00','240','0','20','0','100',null,null,null,null,'70','420','50','200','全部6只，航空战列舰×2，驱逐舰×2，自由舰×2。',null,'80%','200','225','80%','232','261',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('24','远征24','北方海域','北方航路海上护卫','S','8小时20分钟','08:20','500','500','0','0','150','开发资材','2','高速建造材','1','65','65','50','200','全部6只，轻巡洋舰(旗舰)×1，驱逐舰×4，自由舰×1。','该远征拥有合适的燃料、钢材、铝土矿收益，并推荐采用“四闪四桶”的大成功配置。','80%','80','90','60%','78','91',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('25','远征25','西方海域','通商破坏作战','S','40小时0分钟','40:00','2400','900','0','500','0',null,null,null,null,'80','180','25',null,'最低4只，重巡洋舰×2，驱逐舰×2。',null,'50%','50','78','80%','120','171',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('26','远征26','西方海域','敌方母港空袭作战','S','80小时0分钟','80:00','4800','0','0','0','900','高速修复材','3',null,null,'150','200','30',null,'最低4只，正规航母(轻型航母、水上机母舰)×1，轻巡洋舰×1，驱逐舰×2。',null,'80%','72','108','80%','92','140',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('27','远征27','西方海域','潜水艇通商破坏作战','S','20小时0分钟','20:00','1200','0','0','800','0','开发资材','1','家具箱(小)','2','80','60','1',null,'最低2只，潜水艇(潜水航母)×2。',null,'80%','16','54','80%','32','108',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('28','远征28','西方海域','西方海域封锁作战','S','25小时0分钟','25:00','1500','0','0','900','350','开发资材','2','家具箱(中)','2','100','140','30',null,'最低3只，潜水艇(潜水航母)×3。',null,'80%','24','54','80%','48','108',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('29','远征29','西方海域','潜水艇派遣演习','S','24小时0分钟','24:00','1440','0','0','0','100','开发资材','1','家具箱(小)','1','100','100','50',null,'最低3只，潜水艇(潜水航母)×3。',null,'90%','27','60','40%','24','60',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('30','远征30','西方海域','潜水艇派遣作战','S','48小时0分钟','48:00','2880','0','0','0','100','开发资材','3',null,null,'100','150','55',null,'最低4只，潜水艇(潜水航母)×4。',null,'90%','36','60','70%','56','96',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('31','远征31','西方海域','海外舰接触','S','2小时0分钟','02:00','120','0','30','0','0','家具箱(小)','1',null,null,'50','50','60','200','最低4只，潜水艇(潜水航母)×4。',null,'50%','20','36','0%','0','12',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('32','远征32','西方海域','远洋练习航海','D','24小时0分钟','24:00','1440','50','50','50','50',null,null,null,null,'300','900','5',null,'至少3只，练习巡洋舰(旗舰)×1，驱逐舰×2','该远征系特殊远征，拥有极高的经验收益，详情请查阅“练习巡洋舰”。','90%','100','110','30%','36','48',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('33','远征33','南方海域','前线部队支援任务','E','15分钟','00:15','15','-','-','-','-',null,null,null,null,'0','0','1',null,'至少2只，驱逐舰×2','该远征系特殊远征，详情请查阅“支援舰队”。','0%','-','-','0%','-','-',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('34','远征34','南方海域','舰队决战支援任务','E','30分钟','00:30','30','-','-','-','-',null,null,null,null,'0','0','1',null,'至少2只，驱逐舰×2','该远征系特殊远征，详情请查阅“支援舰队”。','0%','-','-','0%','-','-',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('35','远征35','南方海域','MO作战','S','7小时0分钟','07:00','420','0','0','240','280','家具箱(小)','2','开发资材','1','100','100','40',null,'全部6只，正规航母(轻型航母、水上机母舰)×2，重巡洋舰×1，驱逐舰×1，自由舰×2。','该远征拥有合适的钢材、铝土矿收益。','80%','120','135','80%','164','185',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('36','远征36','南方海域','水上机基地建设','S','9小时0分钟','09:00','540','480','0','200','200','家具箱(中)','2','高速修复材','1','100','100','30',null,'全部6只，水上机母舰×2，轻巡洋舰×1，驱逐舰×1，自由舰×2。','该远征拥有合适的燃料、钢材、铝土矿收益。','80%','112','126','80%','144','162',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('37','远征37','南方海域','东京急行','S','2小时45分钟','02:45','165','0','380','270','0','家具箱(小)','1',null,null,'50','65','50','200','全部6只，轻巡洋舰×1，驱逐舰×5，至少4只舰娘各装备1只鼓桶(运输用)。','该远征拥有较高的弹药、钢材收益，并推荐采用“四闪四桶”的大成功配置。','80%','80','90','80%','104','117',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('38','远征38','南方海域','东京急行(二)','S','2小时55分钟','02:55','175','420','0','200','0','家具箱(小)','1',null,null,'50','70','65','240','全部6只，驱逐舰×5，自由舰×1，至少4只舰娘各装备2只鼓桶(运输用)。','该远征拥有较高的燃料、钢材收益，并推荐采用“四闪八桶”的大成功配置。','80%','80','90','80%','104','117',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('39','远征39','南方海域','远洋潜水艇作战','S','30小时0分钟','30:00','1800','0','0','300','0','高速修复材','2','家具箱(小)','1','130','160','3','180','最低5只，潜水母舰(大鲸)×1，潜水艇(潜水航母)×4。',null,'90%','68','86','90%','81','110',null,null)");
        db.execSQL("INSERT INTO Yuanzheng VALUES ('40','远征40','南方海域','水上机前线运输','S','6小时50分钟','06:50','410','300','300','0','100','家具箱(小)','3','高速修复材','1','60','140','25','150','全部6只，轻巡洋舰(旗舰)×1，水上机母舰×2，驱逐舰×2，自由舰×2。','该远征拥有合适的燃料、弹药、铝土矿收益，并推荐采用“四闪四桶”的大成功配置。','80%','112','126','70%','126','144',null,null)");


  //      db.execSQL("INSERT INTO Yuanzhengdui VALUES ('1','第二远征队','常规配置','0')");
  //      db.execSQL("INSERT INTO Yuanzhengdui VALUES ('2','第三远征队','大成功配置','3')");
  //      db.execSQL("INSERT INTO Yuanzhengdui VALUES ('3','第四远征队','大成功配置','4')");


        db.execSQL("INSERT INTO Renwu VALUES ('1','A1','编成类','一次性任务','初次的“编成”！','编成拥有2只以上舰娘的舰队',null,'20','20','0','0',null,null,null,null,'驱逐舰“白雪”',null,null,null,null,'新手系列任务',null,null)");
        db.execSQL("INSERT INTO Renwu VALUES ('2','A2','编成类','一次性任务','“驱逐队”编成！','编成拥有4只以上驱逐舰的“驱逐队”',null,'30','30','30','0','高速建造材','1',null,null,null,'A1','初次的“编成”！',null,null,'周常系列任务',null,null)");
        db.execSQL("INSERT INTO Renwu VALUES ('3','A3','编成类','一次性任务','“水雷战队”编成！','编成拥有轻巡洋舰旗舰，和数只驱逐舰撩舰的“水雷战队”',null,'40','40','0','40','开发资材','1',null,null,null,'A2','“驱逐队”编成！',null,null,'周常系列任务',null,null)");
        db.execSQL("INSERT INTO Renwu VALUES ('4','A4','编成类','一次性任务','拥有6只舰娘的舰队编成！','编成拥有6只舰娘的主力舰队',null,'50','0','50','0',null,null,null,null,'开放第二舰队','A3','“水雷战队”编成！',null,null,'甲板系列任务',null,null)");
        db.execSQL("INSERT INTO Renwu VALUES ('5','A5','编成类','一次性任务','拥有2只轻巡洋舰的舰队编成！','编成拥有2只轻巡洋舰的高速舰队',null,'60','60','0','0','开发资材','1',null,null,null,'A3','“水雷战队”编成！',null,null,'第二块甲板系列任务','攻略任务',null)");


        db.execSQL("INSERT INTO Renwugonglue VALUES ('1','A5','本海域70.6（2-5秋）的索敌才能稳定进入BOSS点，建议到游戏中后期再进行该任务','轻巡洋舰X2，驱逐舰X4','轻巡洋舰','双15.2cm主炮+夜间侦察机，为舰队提供夜间火力支援','驱逐舰','双12.7cm主炮+小型电探，建议采用33号电探,提供足够的索敌',null,null,null,null,null,null,null,null)");

                db.setTransactionSuccessful();

        db.endTransaction();


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {





        switch (oldVersion){
            case 1:
                db.execSQL("update Gaixiu set zhouwu = '秋月/照月/初月/吹雪改二' where id = 55");
                db.execSQL("update Gaixiu set zhousan = '秋津丸/皋月改二' , zhousi = '秋津丸' , zhouwu = '秋津丸/阿武隈改二' where id = 57");
                db.execSQL("update Gaixiu set zhousan = '阿武隈改二' , zhousi = '阿武隈改二/皋月改二' , zhouwu = '秋津丸/皋月改二' where id = 58");
                db.execSQL("update Gaixiu set zhousan = '伊8/伊401' , zhousi = '伊8/伊401' , zhouwu = '伊8/伊58' where id = 59");
            case 2:
                db.beginTransaction();
                db.execSQL(Create_Yuanzheng);

                db.execSQL("INSERT INTO Yuanzheng VALUES ('1','远征1','镇守府海域','练习航海','E','15分钟','00:15','15','0','30','0','0',null,null,null,null,'10','10','1',null,'最低2只，舰种自由。',null,'30%','9','36','0%','0','12',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('2','远征2','镇守府海域','长距离练习航海','E','30分钟','00:30','30','0','100','30','0','高速修复材','1',null,null,'20','15','2',null,'最低4只，舰种自由。','该远征拥有极高的弹药、高速修复材收益。','50%','30','54','0%','0','12',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('3','远征3','镇守府海域','警备任务','D','20分钟','00:20','20','30','30','40','0',null,null,null,null,'30','30','3',null,'最低3只，舰种自由。','该远征拥有极高的钢材收益。','30%','14','36','20%','12','36',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('4','远征4','镇守府海域','对潜警戒任务','D','50分钟','00:50','50','0','60','0','0','高速修复材','1','家具箱(小)','1','30','40','3',null,'最低3只，轻巡洋舰×1，驱逐舰×2。','该远征拥有较高的高速修复材收益。','50%','28','60','0%','0','13',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('5','远征5','镇守府海域','海上护卫任务','C','1小时30分钟','01:30','90','200','200','20','20',null,null,null,null,'40','40','3',null,'最低4只，轻巡洋舰×1，驱逐舰×2，自由舰×1。','该远征拥有极高的燃料、弹药收益。','50%','35','60','0%','0','13',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('6','远征6','镇守府海域','防空射击演习','C','40分钟','00:40','40','0','0','0','80','家具箱(小)','1',null,null,'30','50','4',null,'最低4只，舰种自由。','该远征拥有极高的铝土矿收益。','30%','18','36','20%','16','36',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('7','远征7','镇守府海域','观舰式排演','C','1小时0分钟','01:00','60','0','0','50','30','高速建造材','1',null,null,'60','120','5',null,'全部6只，舰种自由。',null,'50%','45','54','0%','0','12',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('8','远征8','镇守府海域','观舰式','B','3小时0分钟','03:00','180','50','100','50','50','高速建造材','2','开发资材','1','120','140','6',null,'全部6只，舰种自由。',null,'50%','45','54','20%','24','36',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('9','远征9','南西诸岛海域','油轮护卫任务','C','4小时0分钟','04:00','240','350','0','0','0','家具箱(小)','1','高速修复材','2','60','60','3',null,'最低4只，轻巡洋舰×1，驱逐舰×2，自由舰×1。',null,'50%','35','60','0%','0','13',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('10','远征10','南西诸岛海域','强行侦察任务','C','1小时30分钟','01:30','90','0','50','0','30','高速修复材','1','高速建造材','1','40','50','3',null,'最低3只，轻巡洋舰×2，自由舰×1。',null,'30%','20','44','0%','0','14',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('11','远征11','南西诸岛海域','铝土矿护送任务','B','5小时0分钟','05:00','300','0','0','0','250','家具箱(小)','1','高速修复材','1','40','40','6',null,'最低4只，驱逐舰×2，自由舰×2。','该远征拥有较高的铝土矿收益。','50%','30','54','0%','0','12',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('12','远征12','南西诸岛海域','资源输送任务','B','8小时0分钟','08:00','480','50','250','200','50','家具箱(中)','1','开发资材','1','60','50','4',null,'最低4只，驱逐舰×2，自由舰×2。','该远征拥有合适的弹药、钢材收益。','50%','30','54','0%','0','12',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('13','远征13','南西诸岛海域','鼠输送作战','A','4小时0分钟','04:00','240','240','300','0','0','高速修复材','2','家具箱(小)','1','70','60','5',null,'全部6只，轻巡洋舰×1，驱逐舰×4，自由舰×1。',null,'50%','50','60','40%','52','65',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('14','远征14','南西诸岛海域','包围圈内陆战队撤退运输作战','A','6小时0分钟','06:00','360','0','240','200','0','高速修复材','1','开发资材','1','90','100','6',null,'全部6只，轻巡洋舰×1，驱逐舰×3，自由舰×2。','该远征拥有合适的弹药、钢材收益。','50%','50','60','0%','0','13',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('15','远征15','南西诸岛海域','诱饵机动部队支援作战','S','12小时0分钟','12:00','720','0','0','300','400','家具箱(大)','1','开发资材','1','100','160','9',null,'全部6只，正规航母(轻型航母、水上机母舰)×2，驱逐舰×2，自由舰×2。',null,'50%','65','78','40%','68','85',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('16','远征16','南西诸岛海域','舰队决战护卫作战','S','15小时0分钟','15:00','900','500','500','200','200','高速建造材','1','开发资材','2','120','200','11',null,'全部6只，轻巡洋舰×1，驱逐舰×2，自由舰×3。',null,'50%','50','60','40%','52','65',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('17','远征17','北方海域','敌方阵地侦察作战','A','45分钟','00:45','45','70','70','50','0',null,null,null,null,'30','40','20',null,'全部6只，轻巡洋舰×1，驱逐舰×3，自由舰×2。',null,'30%','30','40','40%','52','65',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('18','远征18','北方海域','舰载机运送作战','S','5小时0分钟','05:00','300','0','0','300','100',null,null,null,null,'60','60','15',null,'全部6只，正规航母(轻型航母、水上机母舰)×3，驱逐舰×2，自由舰×1。','该远征拥有合适钢材、铝土矿收益。','50%','80','96','20%','38','57',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('19','远征19','北方海域','北号作战','S','6小时0分钟','06:00','360','400','0','50','30','家具箱(小)','1','开发资材','1','60','70','20',null,'全部6只，航空战列舰×2，驱逐舰×2，自由舰×2。',null,'50%','125','150','40%','116','145',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('20','远征20','北方海域','潜水艇哨戒作战','S','2小时0分钟','02:00','120','0','0','150','0','开发资材','1','家具箱(小)','1','40','50','1',null,'最低2只，潜水艇(潜水航母)×1，轻巡洋舰×1。',null,'50%','18','57','40%','20','64',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('21','远征21','北方海域','北方鼠输送作战','S','2小时20分钟','02:20','140','320','270','0','0','家具箱(小)','1',null,null,'45','55','15','30','最低5只，轻巡洋舰×1，驱逐舰×4，至少3只舰娘各装备1只鼓桶(运输用)。','该远征拥有较高的燃料、弹药收益，并推荐采用“四闪四桶”的大成功配置。','80%','68','90','70%','77','104',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('22','远征22','北方海域','舰队演习','S','3小时0分钟','03:00','180','0','10','0','0',null,null,null,null,'45','400','30','45','全部6只，重巡洋舰×1，轻巡洋舰×1，驱逐舰×2，自由舰×1。',null,'80%','96','108','70%','116','132',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('23','远征23','北方海域','航空战列舰运用演习','S','4小时0分钟','04:00','240','0','20','0','100',null,null,null,null,'70','420','50','200','全部6只，航空战列舰×2，驱逐舰×2，自由舰×2。',null,'80%','200','225','80%','232','261',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('24','远征24','北方海域','北方航路海上护卫','S','8小时20分钟','08:20','500','500','0','0','150','开发资材','2','高速建造材','1','65','65','50','200','全部6只，轻巡洋舰(旗舰)×1，驱逐舰×4，自由舰×1。','该远征拥有合适的燃料、钢材、铝土矿收益，并推荐采用“四闪四桶”的大成功配置。','80%','80','90','60%','78','91',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('25','远征25','西方海域','通商破坏作战','S','40小时0分钟','40:00','2400','900','0','500','0',null,null,null,null,'80','180','25',null,'最低4只，重巡洋舰×2，驱逐舰×2。',null,'50%','50','78','80%','120','171',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('26','远征26','西方海域','敌方母港空袭作战','S','80小时0分钟','80:00','4800','0','0','0','900','高速修复材','3',null,null,'150','200','30',null,'最低4只，正规航母(轻型航母、水上机母舰)×1，轻巡洋舰×1，驱逐舰×2。',null,'80%','72','108','80%','92','140',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('27','远征27','西方海域','潜水艇通商破坏作战','S','20小时0分钟','20:00','1200','0','0','800','0','开发资材','1','家具箱(小)','2','80','60','1',null,'最低2只，潜水艇(潜水航母)×2。',null,'80%','16','54','80%','32','108',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('28','远征28','西方海域','西方海域封锁作战','S','25小时0分钟','25:00','1500','0','0','900','350','开发资材','2','家具箱(中)','2','100','140','30',null,'最低3只，潜水艇(潜水航母)×3。',null,'80%','24','54','80%','48','108',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('29','远征29','西方海域','潜水艇派遣演习','S','24小时0分钟','24:00','1440','0','0','0','100','开发资材','1','家具箱(小)','1','100','100','50',null,'最低3只，潜水艇(潜水航母)×3。',null,'90%','27','60','40%','24','60',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('30','远征30','西方海域','潜水艇派遣作战','S','48小时0分钟','48:00','2880','0','0','0','100','开发资材','3',null,null,'100','150','55',null,'最低4只，潜水艇(潜水航母)×4。',null,'90%','36','60','70%','56','96',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('31','远征31','西方海域','海外舰接触','S','2小时0分钟','02:00','120','0','30','0','0','家具箱(小)','1',null,null,'50','50','60','200','最低4只，潜水艇(潜水航母)×4。',null,'50%','20','36','0%','0','12',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('32','远征32','西方海域','远洋练习航海','D','24小时0分钟','24:00','1440','50','50','50','50',null,null,null,null,'300','900','5',null,'至少3只，练习巡洋舰(旗舰)×1，驱逐舰×2','该远征系特殊远征，拥有极高的经验收益，详情请查阅“练习巡洋舰”。','90%','100','110','30%','36','48',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('33','远征33','南方海域','前线部队支援任务','E','15分钟','00:15','15','-','-','-','-',null,null,null,null,'0','0','1',null,'至少2只，驱逐舰×2','该远征系特殊远征，详情请查阅“支援舰队”。','0%','-','-','0%','-','-',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('34','远征34','南方海域','舰队决战支援任务','E','30分钟','00:30','30','-','-','-','-',null,null,null,null,'0','0','1',null,'至少2只，驱逐舰×2','该远征系特殊远征，详情请查阅“支援舰队”。','0%','-','-','0%','-','-',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('35','远征35','南方海域','MO作战','S','7小时0分钟','07:00','420','0','0','240','280','家具箱(小)','2','开发资材','1','100','100','40',null,'全部6只，正规航母(轻型航母、水上机母舰)×2，重巡洋舰×1，驱逐舰×1，自由舰×2。','该远征拥有合适的钢材、铝土矿收益。','80%','120','135','80%','164','185',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('36','远征36','南方海域','水上机基地建设','S','9小时0分钟','09:00','540','480','0','200','200','家具箱(中)','2','高速修复材','1','100','100','30',null,'全部6只，水上机母舰×2，轻巡洋舰×1，驱逐舰×1，自由舰×2。','该远征拥有合适的燃料、钢材、铝土矿收益。','80%','112','126','80%','144','162',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('37','远征37','南方海域','东京急行','S','2小时45分钟','02:45','165','0','380','270','0','家具箱(小)','1',null,null,'50','65','50','200','全部6只，轻巡洋舰×1，驱逐舰×5，至少4只舰娘各装备1只鼓桶(运输用)。','该远征拥有较高的弹药、钢材收益，并推荐采用“四闪四桶”的大成功配置。','80%','80','90','80%','104','117',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('38','远征38','南方海域','东京急行(二)','S','2小时55分钟','02:55','175','420','0','200','0','家具箱(小)','1',null,null,'50','70','65','240','全部6只，驱逐舰×5，自由舰×1，至少4只舰娘各装备2只鼓桶(运输用)。','该远征拥有较高的燃料、钢材收益，并推荐采用“四闪八桶”的大成功配置。','80%','80','90','80%','104','117',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('39','远征39','南方海域','远洋潜水艇作战','S','30小时0分钟','30:00','1800','0','0','300','0','高速修复材','2','家具箱(小)','1','130','160','3','180','最低5只，潜水母舰(大鲸)×1，潜水艇(潜水航母)×4。',null,'90%','68','86','90%','81','110',null,null)");
                db.execSQL("INSERT INTO Yuanzheng VALUES ('40','远征40','南方海域','水上机前线运输','S','6小时50分钟','06:50','410','300','300','0','100','家具箱(小)','3','高速修复材','1','60','140','25','150','全部6只，轻巡洋舰(旗舰)×1，水上机母舰×2，驱逐舰×2，自由舰×2。','该远征拥有合适的燃料、弹药、铝土矿收益，并推荐采用“四闪四桶”的大成功配置。','80%','112','126','70%','126','144',null,null)");
 //               db.execSQL(Create_Yuanzhengdui);
 //               db.execSQL("INSERT INTO Yuanzhengdui VALUES ('1','第二远征队','常规配置','0')");
 //               db.execSQL("INSERT INTO Yuanzhengdui VALUES ('2','第三远征队','大成功配置','3')");
                //db.execSQL("INSERT INTO Yuanzhengdui VALUES ('3','第四远征队','大成功配置','4')");
                db.setTransactionSuccessful();
                db.endTransaction();


            case 3:
                db.beginTransaction();
                db.execSQL(Create_Renwu);
                db.execSQL(Create_Renwugonglue);

                db.execSQL("INSERT INTO Renwu VALUES ('1','A1','编成类','一次性任务','初次的“编成”！','配置2只以上的舰娘','编成拥有2只以上舰娘的“舰队”！',null,'20','20','0','0',null,null,null,null,'驱逐舰“白雪”',null,null,null,null,'新手系列任务',null)");
                db.execSQL("INSERT INTO Renwu VALUES ('2','A2','编成类','一次性任务','“驱逐队”编成！','配置4只以上的驱逐舰','编成拥有4只以上驱逐舰的“驱逐队”！',null,'30','30','30','0','高速建造材','1',null,null,null,'A1','初次的“编成”！',null,null,null,null)");
                db.execSQL("INSERT INTO Renwu VALUES ('3','A3','编成类','一次性任务','“水雷战队”编成！','以轻巡洋舰为旗舰，再配置数只驱逐舰','编成以轻巡洋舰为旗舰，外加数艘驱逐舰的“水雷战队”！',null,'40','40','0','40','开发资材','1',null,null,null,'A2','“驱逐队”编成！',null,null,null,null)");
                db.execSQL("INSERT INTO Renwu VALUES ('4','A4','编成类','一次性任务','拥有6只舰娘的舰队编成！','配置6只舰娘','编成拥有6只舰娘的主力舰队！',null,'50','0','50','0',null,null,null,null,'开放第二舰队','A3','“水雷战队”编成！',null,null,null,null)");
                db.execSQL("INSERT INTO Renwu VALUES ('5','A5','编成类','一次性任务','拥有2只轻巡洋舰的舰队编成！','配置2只轻巡洋舰','编成拥有2只轻巡洋舰的高速舰队！',null,'60','60','0','0','开发资材','1',null,null,null,'A3','“水雷战队”编成！',null,null,null,'特殊任务')");


                db.execSQL("INSERT INTO Renwugonglue VALUES ('1','A5','本海域70.6（2-5秋）的索敌才能稳定进入BOSS点，建议到游戏中后期再进行该任务','轻巡洋舰X2，驱逐舰X4','轻巡洋舰','双15.2cm主炮+夜间侦察机，为舰队提供夜间火力支援','驱逐舰','双12.7cm主炮+小型电探，建议采用33号电探,提供足够的索敌',null,null,null,null,null,null,null,null)");


                db.setTransactionSuccessful();
                db.endTransaction();

            case 24:
                db.beginTransaction();

            default:


        }

                Log.d("debug", "数据库更新");

        //*switch (oldVersion) {
        //        case 1:
        //        db.execSQL(CREATE_tujian);
        //        case 2:
        //        db.execSQL("alter table gaixiu add column category_id integer");
        //
    }

//快速插入数据啊






}



