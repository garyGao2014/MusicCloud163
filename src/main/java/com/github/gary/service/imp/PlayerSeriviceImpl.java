package com.github.gary.service.imp;

import com.alibaba.fastjson.JSONObject;
import com.github.gary.api.MusicApi;
import com.github.gary.core.Params;
import com.github.gary.req.MusicUrlReq;
import com.github.gary.resp.PlayListResp;
import com.github.gary.resp.PlayerMusicResp;
import com.github.gary.resp.PlayerResp;
import com.github.gary.service.IPlayerService;
import com.github.gary.tools.HttpTool;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class PlayerSeriviceImpl implements IPlayerService {
    @Override
    public PlayerResp getPlayerByIds(Collection<String> ids) {
        PlayerResp resp = new PlayerResp();
        try {
            if (ids != null && ids.size() > 0) {
                MusicUrlReq musicUrl = new MusicUrlReq();
                musicUrl.setBr(Params.BR.br320.getBr());
                musicUrl.setCsrf_token("");
                musicUrl.setIds(ids.toArray(new String[ids.size()]));
                String result = HttpTool.post(MusicApi.musicUrl, JSONObject.toJSONString(musicUrl));
                resp = JSONObject.parseObject(result, PlayerResp.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    @Override
    public List<PlayerMusicResp> getPlayerUrlByIds(Collection<String> ids) {
        List<PlayerMusicResp> result = Lists.newArrayListWithCapacity(ids.size());
        try {
            PlayerResp playerByIds = this.getPlayerByIds(ids);
            List<PlayerResp.DataBean> data = playerByIds.getData();
            for (int i = 0; i < data.size(); i++) {
                PlayerResp.DataBean dataBean = data.get(i);
                PlayerMusicResp resp = new PlayerMusicResp();
                resp.setId(dataBean.getId() + "");
                resp.setBr(dataBean.getBr());
                resp.setUrl(dataBean.getUrl());
                resp.setType(dataBean.getType());
                result.add(resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
