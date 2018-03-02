package com.github.gary;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.gary.api.MusicApi;
import com.github.gary.asyn.FileDownloadThread;
import com.github.gary.core.Params;
import com.github.gary.req.LoginReq;
import com.github.gary.req.MusicUrlReq;
import com.github.gary.req.PlayListDetailReq;
import com.github.gary.req.PlayListReq;
import com.github.gary.resp.PlayListDetailResp;
import com.github.gary.resp.PlayListResp;
import com.github.gary.resp.PlayerMusicResp;
import com.github.gary.resp.PlayerResp;
import com.github.gary.service.IPlayListDetailSerivce;
import com.github.gary.service.IPlayerService;
import com.github.gary.service.imp.PlayListDetailServiceImpl;
import com.github.gary.service.imp.PlayerSeriviceImpl;
import com.github.gary.tools.EncryTool;
import com.github.gary.tools.FileTool;
import com.github.gary.tools.HttpTool;
import com.google.common.collect.Maps;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * @author garygao
 */
public class Main {


    public static void main(String[] args) {
//        login();
//        getMusicUrl();
//        getPlayList();
        getPlayListDetail();
    }


    private static void login() {
        //xxxx
        String username = "xxxxx@qq.com";
        String password = "xxxx";
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
        musicUrl.setIds(new String[]{"xxxxxx"});
//        String result = HttpTool.post(MusicApi.musicUrl, "{'ids':'[" + 418603077 + "]','br':" + Params.BR.br198.getBr() + ",'csrf_token':''}");
        String result = HttpTool.post(MusicApi.musicUrl, JSONObject.toJSONString(musicUrl));
        System.out.println(result);
    }

    private static void getPlayList() {
        PlayListReq palyList = new PlayListReq();
        palyList.setCsrf_token("");
        palyList.setLimit(1);
        palyList.setUid("xxxxxx");
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

        Map<String, PlayListDetailResp.PlaylistBean.TracksBean> musices = Maps.newHashMap();
        String id = "2123548611";
        IPlayListDetailSerivce playListDetailSerivce = new PlayListDetailServiceImpl();
        PlayListDetailResp playListDetailById = playListDetailSerivce.getPlayListDetailById(id);
        if (playListDetailById != null) {
            PlayListDetailResp.PlaylistBean playlist = playListDetailById.getPlaylist();
            List<PlayListDetailResp.PlaylistBean.TracksBean> tracks = playlist.getTracks();
            for (int i = 0; i < tracks.size(); i++) {
                PlayListDetailResp.PlaylistBean.TracksBean tracksBean = tracks.get(i);
                tracksBean.getId();
                musices.put(tracksBean.getId() + "", tracksBean);
            }
        }
        IPlayerService playerService = new PlayerSeriviceImpl();
        List<PlayerMusicResp> musicResps = playerService.getPlayerUrlByIds(musices.keySet());
        if (musicResps != null && musicResps.size() > 0) {
            for (PlayerMusicResp resp : musicResps) {
                String mId = resp.getId();
                String artName = "";
                PlayListDetailResp.PlaylistBean.TracksBean tracksBean = musices.get(mId);
                if (tracksBean != null) {
                    List<PlayListDetailResp.PlaylistBean.TracksBean.ArBean> ar = tracksBean.getAr();
                    if (ar != null) {
                        PlayListDetailResp.PlaylistBean.TracksBean.ArBean arBean = ar.get(0);
                        if (arBean != null) {
                            artName = arBean.getName();
                        }
                    }
                }
                String name = artName + " - " + musices.get(mId).getName() + "." + resp.getType();
                String url = resp.getUrl();
                int br = resp.getBr();
                System.out.println("id:" + mId + ",||name:" + name + ",||url:" + ",||" + url + ",||br:" + br);
                Map<String, String> asynMaps = Maps.newHashMap();
                asynMaps.put(url, name);
                try {
                    FileDownloadThread.queue.put(asynMaps);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
