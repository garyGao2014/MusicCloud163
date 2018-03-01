package com.github.gary.service;

import com.github.gary.resp.PlayListResp;

public interface IPlayerService {
    /**
     * 根据歌曲id获取其歌曲详情,url等
     * @param id
     * @return
     */
    public PlayListResp getPlayerById(String id);
}
