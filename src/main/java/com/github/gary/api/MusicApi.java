package com.github.gary.api;

/**
 * @author garygao
 */
public class MusicApi {
    /**
     * 登录
     */
    public static final String loginUrl = "https://music.163.com/weapi/login?csrf_token=";
    /**
     * 获取音乐的url资源
     */
    public static final String musicUrl = "https://music.163.com/weapi/song/enhance/player/url?csrf_token=";

    /**
     * 获取用户歌单
     */
    public static final String playListUrl = "http://music.163.com/weapi/user/playlist?csrf_token=";

    /**
     * 获取歌单详情
     */
    public static final String playListDetailUrl = "http://music.163.com/weapi/v3/playlist/detail?csrf_token=";

}
