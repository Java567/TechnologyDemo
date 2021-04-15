//package com.wx.core.util;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.JwtException;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.servlet.http.HttpServletRequest;
//import java.security.Key;
//import java.util.Date;
//
//import static com.wx.core.constant.SecurityConstant.*;
//
//
///**
// * \* Created with IntelliJ IDEA.
// * \* @author: guohezuzi
// * \* Date: 2018-12-09
// * \* Time: 下午9:52
// * \* Description:jwt工具类
// * \
// */
//
//public class JwtUtil {
//    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);
//    private static final Key KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//
//    /**
//     * 解析token
//     * @param token the JWT token to parse
//     * @return token claims
//     */
//    public static Claims parseToken(String token) {
//        try {
//            return Jwts.parser()
//                    .setSigningKey(KEY)
//                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
//                    .getBody();
//        } catch (JwtException e) {
//            logger.warn("jwt验证失败" + e.getMessage());
//            return null;
//        }
//    }
//
//    /**
//     * 超级管理员token授权
//     * @param id 用户Id
//     * @return the JWT token
//     */
//    public static String generateTokenForRoot(String id) {
//        Claims claims = Jwts.claims().setAudience(id).setSubject("ROLE_ROOT");
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .signWith(KEY)
//                .compact();
//    }
//
//    /**
//     * 普通管理员token授权
//     * @param id 用户Id
//     * @return the JWT token
//     */
//    public static String generateTokenByIdForAdmin(String id) {
//        Claims claims = Jwts.claims().setAudience(id).setSubject("ROLE_ADMIN");
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .signWith(KEY)
//                .compact();
//    }
//
//    /**
//     * 用户获取token
//     * @param id 微信用户为用户Id
//     * @return the JWT token
//     * */
//    public static String generateTokenByIdForUser(String id) {
//        Claims claims = Jwts.claims().setAudience(id).setSubject("ROLE_USER");
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .signWith(KEY)
//                .compact();
//    }
//
//    /**
//     * 记录者获取token
//     * @param id 微信用户为用户Id
//     * @return the JWT token
//     * */
//    public static String generateTokenByIdForRecorder(String id) {
//        Claims claims = Jwts.claims().setAudience(id).setSubject("ROLE_RECORDER");
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .signWith(KEY)
//                .compact();
//    }
//
//    /**
//     * 用户或场农为获取在数据库中的id,管理员为获取用户名
//     * @param request http请求
//     * @return 用户或场农在数据库中的id或管理员用户名
//     */
//    public static Claims claimGet(HttpServletRequest request){
//        Claims claims = null;
//        String token = request.getHeader(HEADER_STRING);
//        if (token != null) {
//            // parse the token.
//            claims = JwtUtil.parseToken(token);
//        }
//        return claims;
//    }
//}
