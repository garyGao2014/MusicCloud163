package com.github.gary.service;

import com.github.gary.resp.PlayListResp;
import com.github.gary.resp.PlayerMusicResp;
import com.github.gary.resp.PlayerResp;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface IPlayerService {
    /**
     * 根据歌曲id获取其歌曲详情
     *
     * @param ids
     * @return
     */
    public PlayerResp getPlayerByIds(Collection<String> ids);

    /**
     * 根据歌曲id获取其歌曲(url)
     *
     * @param ids
     * @return PlayerMusicResp
     */
    public List<PlayerMusicResp> getPlayerUrlByIds(Collection<String> ids);
}
