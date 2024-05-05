package com.itzyf;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author： 1ml
 * @Description： TODO
 * @Date： 2024/4/8 23:28
 * @Version： 1.0
 */
public class JwtTest {

    @Test
    public void testGen() {

        HashMap<String, Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("username","zhangsan");

        String token = JWT.create()
                .withClaim("user",claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12))
                .sign(Algorithm.HMAC256("itzyf"));

        System.out.println(token);
    }

    @Test
    public void testParse() {

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
                ".eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6InpoYW5nc2FuIn0sImV4cCI6MTcxMjYzNDA2OH0" +
                ".toRsLOJcvynPas-psWZwyBhX74lPr6cgB2LYvK_xPDA";

        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("itzyf")).build();

        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));

    }

}
