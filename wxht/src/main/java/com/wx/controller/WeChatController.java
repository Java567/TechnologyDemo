//package com.wx.controller;
//
//import com.mage.core.ResultInfo;
//import com.mage.core.util.ResultInfoUtil;
//import com.mage.model.pojo.*;
//import com.mage.service.PartyMemberJobService;
//import com.mage.service.PartyMemberService;
//import com.mage.service.WeChatService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
//
///**
// * 微信订阅模板
// */
//
//@Component
//@RestController
//@RequestMapping("/wechat")
//@Api(tags = "微信请求接口")
//@Validated
//public class WeChatController {
//
//    @Resource
//    private PartyMemberService partyMemberService;
//
//    @Resource
//    private WeChatService weChatService;
//
//    @Resource
//    private PartyMemberJobService partyMemberJobService;
//
//
//    @Scheduled(cron = "0 0 0 * * ?")
//    @PostMapping("getToken")
//    @ApiOperation("微信token获取")
//    public ResultInfo<?> getAccessToken(){
//        String token;
//        try{
//            token = weChatService.getWeChatToken();
//            System.out.println(token);
//        }catch (Exception e){
//            return ResultInfoUtil.buildError();
//        }
//
//        if ("".equals(token)){
//            return ResultInfoUtil.buildError(500, "请求失败,请重试!");
//        }
//        return ResultInfoUtil.buildSuccess(token);
//    }
//
//
//
//    @PostMapping("/pushByOneDay")
//    @Scheduled(cron = "0 0 0 * * ?")
//    @ApiOperation("书记订阅消息模板，设置提前一天提醒,接口每隔两分钟刷新一下")
//    public void weChatMessageSendAdmin() throws ParseException {
//        List<PartyMember> partyMemberList=partyMemberService.getOwners();
//        for(PartyMember partyMember:partyMemberList) {
//            String name1=partyMember.getName();
//            String institutionName=partyMember.getInstitutionName();
//            String joining="书记";
//            String rank=institutionName+joining;
//            //System.out.println(name1);
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(new Date());
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            String cDate = simpleDateFormat.format(calendar.getTime());
//            Long startDate = simpleDateFormat.parse(cDate).getTime();
//            Long endDate = partyMember.getPoliticalBirthday().getTime();
//            Long temp = endDate - startDate;
//            Integer diff = Math.toIntExact(temp / 86400000);
//            if(diff==1){
//                PartyMember partyMember1=partyMemberService.getNameByRank1(rank);
//                String openId=partyMember1.getWechatId();
//                SimpleDateFormat simpleDateFormat1= new SimpleDateFormat("yyyy-MM-dd");
//                Subscription bean = new Subscription();
//                Calendar calendar1 = Calendar.getInstance();
//                calendar1.setTime(new Date());
//                calendar1.add(calendar.DATE, 1);
//                String cDate1 = simpleDateFormat1.format(calendar1.getTime());
//                bean.setDate2(new Subscription.date2(cDate1));
//                bean.setName1(new Subscription.name1(name1));
//                bean.setThing3(new Subscription.thing3("您的党员" + name1+"明天生日哦,记得送上祝福哦"));
//                System.out.println(bean);
//                WeChatMessage weChatMessage = new WeChatMessage();
//                weChatMessage.setToUser(openId);
//                weChatMessage.setTemplateId("NQSm2va3qQ_I7i1KJw0hoarTYJ7jk9mFWy2FHIUXfBg");
//                weChatMessage.setPage("pages/index/index");
//                weChatMessage.setData(bean);
//                weChatMessage.setMiniprogramState("trial");
//                weChatMessage.setLang("zh_CN");
//                weChatService.weChatMessageSend(weChatMessage);
//            }
//        }
//    }
//
//
//
//    @PostMapping("getPushCard")
//    @Scheduled(cron = "0 0 0 * * ?")
//    @ApiOperation("测试完成用这个接口 生日人收到生日提醒订阅消息模板2")
//    public void weChatMessageSendPushCard() throws ParseException {
//        List<PartyMember> partyMemberList=partyMemberService.getOwners();
//        for(PartyMember partyMember:partyMemberList){
//            String institutionName=partyMember.getInstitutionName();
//            String joining="书记";
//            String rank=institutionName+joining;
//            String openid=partyMember.getWechatId();
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(new Date());
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            String cDate = simpleDateFormat.format(calendar.getTime());
//            Long startDate = simpleDateFormat.parse(cDate).getTime();
//            Long endDate = partyMember.getPoliticalBirthday().getTime();
//            Long temp = endDate - startDate;
//            Integer diff = Math.toIntExact(temp / 86400000);
//            if(diff==0){
//                String name=partyMemberService.getNameByRank(rank);
//                BirthdayReminder bean=new BirthdayReminder();
//                bean.setThing2(new BirthdayReminder.thing2("党员政治生日卡片"));
//                bean.setThing1(new BirthdayReminder.thing1(name));
//                WeChatMessage weChatMessage = new WeChatMessage();
//                weChatMessage.setToUser(openid);
//                weChatMessage.setTemplateId("qR_R1C-XC9JoCLL7JbZOWKfiSNJTcOuH9Y9fZBTF1SE");
//                weChatMessage.setPage("pages/mycard/mycard");
//                weChatMessage.setData(bean);
//                weChatMessage.setMiniprogramState("trial");
//                weChatMessage.setLang("zh_CN");
//                weChatService.weChatMessageSend(weChatMessage);
//                System.out.println(weChatMessage);
//            }
//        }
//    }
//
//}
