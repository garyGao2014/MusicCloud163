package com.github.gary.service.imp;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.gary.api.MusicApi;
import com.github.gary.core.Params;
import com.github.gary.req.MusicUrlReq;
import com.github.gary.req.PlayListDetailReq;
import com.github.gary.resp.PlayListDetailResp;
import com.github.gary.service.IPlayListDetailSerivce;
import com.github.gary.tools.HttpTool;

import java.util.List;

public class PlayListDetailServiceImpl implements IPlayListDetailSerivce {
    private static final int LIMIT = 10000;

    @Override
    public PlayListDetailResp getPlayListDetailById(String id) {
        PlayListDetailResp resp = new PlayListDetailResp();
        try {
            if (id != null && id.trim().length() > 0) {
                PlayListDetailReq playListDetail = new PlayListDetailReq();
                playListDetail.setId(id);
                playListDetail.setCsrf_token("");
                playListDetail.setLimit(LIMIT);
                playListDetail.setN(1000);
                playListDetail.setTotal(true);
                playListDetail.setOffset(0);
                String result = HttpTool.post(MusicApi.playListDetailUrl, JSONObject.toJSONString(playListDetail));
                resp = JSONObject.parseObject(result, PlayListDetailResp.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
}
