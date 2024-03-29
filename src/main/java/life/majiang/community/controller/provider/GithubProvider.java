package life.majiang.community.controller.provider;

import com.alibaba.fastjson.JSON;
import life.majiang.community.dto.AccessTokenDTO;
import life.majiang.community.dto.githubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;
import java.io.IOException;
@Component
public class GithubProvider {
       public String getAccessToken(AccessTokenDTO accessTokenDTO) {
           MediaType mediaType = MediaType.get("application/json; charset=utf-8");

           OkHttpClient client = new OkHttpClient();
           RequestBody body = RequestBody.create(JSON.toJSONString(accessTokenDTO), mediaType);
           Request request = new Request.Builder()
                       .url("https://github.com/login/oauth/access_token")
                       .post(body)
                       .build();
               try (Response response = client.newCall(request).execute()) {
                   String string = response.body().string();
                   String[] split = string.split("&");
                   String tokenstr = split[0];
                   String token = tokenstr.split("=")[1];
                   return token;
               } catch (IOException e) {
                        e.printStackTrace();
               }
               return null;
       }

       public githubUser getUser(String accessToken) {
           OkHttpClient client = new OkHttpClient();
           Request request = new Request.Builder()
                       .url("https://api.github.com/user?access_token=" + accessToken)
                       .build();

           try (Response response = client.newCall(request).execute()) {
                  String string = response.body().string();
                  githubUser githubUser = JSON.parseObject(string, githubUser.class);
                  return githubUser;
           } catch (IOException e) {

           }
           return null;
       }


}
