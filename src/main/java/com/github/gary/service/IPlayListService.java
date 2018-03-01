package com.github.gary.service;

import com.github.gary.resp.PlayListResp;

public interface IPlayListService {
    /**
     * 根据用户uid查询其所有歌单
     * @param uid
     * @return
     */
    public PlayListResp getPlayListByUid(String uid);
}
