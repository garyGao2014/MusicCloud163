package com.github.gary;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.gary.api.MusicApi;
import com.github.gary.core.Params;
import com.github.gary.req.LoginReq;
import com.github.gary.req.MusicUrlReq;
import com.github.gary.req.PlayListDetailReq;
import com.github.gary.req.PlayListReq;
import com.github.gary.resp.PlayListDetailResp;
import com.github.gary.tools.EncryTool;
import com.github.gary.tools.HttpTool;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author garygao
 */
public class Main {
    public static void main(String[] args) {
//        login();
        getMusicUrl();
//        getPlayList();
//        getPlayListDetail();
    }


    private static void login() {
        //288986872
        String username = "346703329@qq.com";
        String password = "2012081048chengZ";
        LoginReq login = new LoginReq();
        login.setUsername(username);
        try {
            login.setPassword(new String(EncryTool.getMD5(password), "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        login.setCsrf_token("");
        login.setClientToken("1_KJrAO+ifmy7J31aKKyZDkp5wFiX3nzhS_PvXciyu9xmqdCzCWQA1PrraNbpYGz3rv");
        login.setRememberLogin(Boolean.toString(true));
        String result = HttpTool.post(MusicApi.loginUrl, JSONObject.toJSONString(login));
        System.out.println(result);
    }

    private static void getMusicUrl() {
        MusicUrlReq musicUrl = new MusicUrlReq();
        musicUrl.setBr(Params.BR.br198.getBr());
        musicUrl.setCsrf_token("");
        musicUrl.setIds(new String[]{"418603077"});
//        String result = HttpTool.post(MusicApi.musicUrl, "{'ids':'[" + 418603077 + "]','br':" + Params.BR.br198.getBr() + ",'csrf_token':''}");
        String result = HttpTool.post(MusicApi.musicUrl, JSONObject.toJSONString(musicUrl));
        System.out.println(result);
    }

    private static void getPlayList() {
        PlayListReq palyList = new PlayListReq();
        palyList.setCsrf_token("");
        palyList.setLimit(1);
        palyList.setUid("288986872");
        palyList.setOffset(0);
        String result = HttpTool.post(MusicApi.playListUrl, JSONObject.toJSONString(palyList));
        System.out.println(result);

        JSONArray playlistArray = JSONObject.parseArray(JSONObject.parseObject(result).get("playlist").toString());
        System.out.println(playlistArray);
        for (int i = 0; i < playlistArray.size(); i++) {
            JSONObject jsonObject = playlistArray.getJSONObject(i);
            String id = jsonObject.getString("id");
        }
    }

    private static void getPlayListDetail() {
        PlayListDetailReq playListDetail = new PlayListDetailReq();
        playListDetail.setId("398932332");
        playListDetail.setCsrf_token("");
        playListDetail.setLimit(10);
        playListDetail.setN(100);
        playListDetail.setTotal(true);
        playListDetail.setOffset(0);
        String result = HttpTool.post(MusicApi.playListDetailUrl, JSONObject.toJSONString(playListDetail));
        System.out.println(result);

        PlayListDetailResp playListDetailResp = JSONObject.parseObject(result, PlayListDetailResp.class);
        PlayListDetailResp.PlaylistBean playlist1 = playListDetailResp.getPlaylist();
        List<PlayListDetailResp.PlaylistBean.TracksBean> tracks1 = playlist1.getTracks();
        PlayListDetailResp.PlaylistBean.TracksBean tracksBean = tracks1.get(0);
        tracksBean.getId();
        System.out.println("####"+tracksBean.getId());
        JSONObject playlist = JSONObject.parseObject(JSONObject.parseObject(result).get("playlist").toString());
        System.out.println("playlist:" + playlist);
        JSONArray tracks = playlist.getJSONArray("tracks");
        for (int j = 0; j < tracks.size(); j++) {
            JSONObject track = tracks.getJSONObject(j);
            String id = track.getString("id");
            String name = track.getString("name");
            System.out.println("id:" + id + ",name:" + name);
            MusicUrlReq musicUrl = new MusicUrlReq();
            musicUrl.setBr(Params.BR.br198.getBr());
            musicUrl.setCsrf_token("");
            musicUrl.setIds(new String[]{id});
            result = HttpTool.post(MusicApi.musicUrl, JSONObject.toJSONString(musicUrl));
            System.out.println(result);
        }
    }
}
