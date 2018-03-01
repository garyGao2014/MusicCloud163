package com.github.gary.service;

import com.github.gary.resp.PlayListDetailResp;

public interface IPlayListDetailSerivce {

    /**
     * 根据歌单id，获取歌单详情
     * @param id
     * @return
     */
    public PlayListDetailResp getPlayListDetailById(String id);
}
