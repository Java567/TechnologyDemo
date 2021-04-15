package com.wx.service;

import com.alibaba.fastjson.JSON;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class WxLoginService {


    /**
     * 微信登录样板
     * 通过微信appid获取用户信息
     * @param code
     * @return
     */
//    public ResultInfo<?> getMemberByWechatId(String code,String phoneNum) {
//        PartyMember partyMember=partyMemberMapper.findPhoneNum(phoneNum);
//        if(partyMember!=null) {
//            AssertUtil.isTrue(code == null, "请选择一个微信号授权");
//            String json = WeChatTokenUtils.request(code);
//            WeChatServerMessage msg = JSON.parseObject(json, WeChatServerMessage.class);
//            String openid = msg.getOpenid();
//            if (openid != null) {
//                PartyMember partyMember1 = partyMemberMapper.findBywechat(openid);
//                if (partyMember1 == null) {
//                    //String uuid = UUID.randomUUID().toString().replace("-", "");
//                    // 设置头像的默认路径
//                    Calendar calendar = Calendar.getInstance();
//                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                    // todo 默认头像路径修改
//                    // PartyMember partyMember = PartyMember.builder().id(uuid).wechatId(msg.getOpenid()).headImgUrl("").createTime(formatter.format(calendar.getTime())).build();
//                    partyMember = PartyMember.builder().wechatId(msg.getOpenid()).headImgUrl("").phoneNum(phoneNum).build();
////                        System.out.println(partyMember);
//                    partyMemberMapper.updateToPojo(partyMember);
//                    PartyMember partyMember2=partyMemberMapper.findBywechat(partyMember.getWechatId());
//                    String token = JwtUtil.generateTokenByIdForUser(partyMember2.getId());
//                    System.out.println(token);
//                    Map<String, Object> map = new HashMap<>(2);
//                    map.put("party_member", partyMember2);
//                    map.put("Authorization", TOKEN_PREFIX + token);
//                    return ResultInfoUtil.buildSuccess(map);
//                }else {
//                    String token = JwtUtil.generateTokenByIdForUser(partyMember1.getId());
//                    Map<String, Object> map = new HashMap<>(2);
//                    map.put("party_member", partyMember1);
//                    map.put("Authorization", TOKEN_PREFIX + token);
//                    return ResultInfoUtil.buildSuccess(map);
//                }
//            }
//        }
//        return null;
//    }
}
