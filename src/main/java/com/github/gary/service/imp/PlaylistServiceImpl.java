package com.github.gary.service.imp;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.gary.api.MusicApi;
import com.github.gary.req.PlayListReq;
import com.github.gary.resp.PlayListResp;
import com.github.gary.service.IPlayListService;
import com.github.gary.tools.HttpTool;

public class PlaylistServiceImpl implements IPlayListService {
    private static final int LIMIT = 10000;

    @Override
    public PlayListResp getPlayListByUid(String uid) {
        PlayListResp resp = new PlayListResp();
        try {
            if (uid != null && uid.trim().length() > 0) {
                PlayListReq palyList = new PlayListReq();
                palyList.setCsrf_token("");
                palyList.setLimit(LIMIT);
                palyList.setUid(uid);
                palyList.setOffset(0);
                String result = HttpTool.post(MusicApi.playListUrl, JSONObject.toJSONString(palyList));
                resp = JSONObject.parseObject(result, PlayListResp.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
}
