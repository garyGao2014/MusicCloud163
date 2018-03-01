package com.github.gary.resp;

import java.util.List;

public class PlayListResp {

    /**
     * more : false
     * playlist : [{"subscribers":[],"subscribed":false,"creator":{"defaultAvatar":false,"province":440000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/UBBHztuMWfLxCU9VIGFUEw==/1376588574598995.jpg","accountStatus":0,"gender":0,"city":442000,"birthday":-2209017600000,"userId":288986872,"userType":0,"nickname":"高志成成","signature":"","description":"","detailDescription":"","avatarImgId":1376588574598995,"backgroundImgId":2002210674180198,"backgroundUrl":"http://p1.music.126.net/i0qi6mibX8gq2SaLF1bYbA==/2002210674180198.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"1376588574598995","backgroundImgIdStr":"2002210674180198"},"artists":null,"tracks":null,"privacy":0,"updateTime":1470673713782,"adType":0,"highQuality":false,"playCount":1,"trackNumberUpdateTime":1470673713782,"coverImgUrl":"http://p1.music.126.net/__GcdZ_6RGUQWAbAP_ZoIA==/528865094211615.jpg","coverImgId":528865094211615,"createTime":1465572066224,"commentThreadId":"A_PL_0_398932332","totalDuration":0,"specialType":5,"anonimous":false,"newImported":false,"trackUpdateTime":1519810103332,"trackCount":1,"userId":288986872,"description":null,"ordered":false,"tags":[],"status":0,"cloudTrackCount":0,"subscribedCount":0,"name":"高志成成喜欢的音乐","id":398932332},{"subscribers":[],"subscribed":false,"creator":{"defaultAvatar":false,"province":440000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/UBBHztuMWfLxCU9VIGFUEw==/1376588574598995.jpg","accountStatus":0,"gender":0,"city":442000,"birthday":-2209017600000,"userId":288986872,"userType":0,"nickname":"高志成成","signature":"","description":"","detailDescription":"","avatarImgId":1376588574598995,"backgroundImgId":2002210674180198,"backgroundUrl":"http://p1.music.126.net/i0qi6mibX8gq2SaLF1bYbA==/2002210674180198.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"1376588574598995","backgroundImgIdStr":"2002210674180198"},"artists":null,"tracks":null,"privacy":0,"updateTime":1519893213672,"adType":0,"highQuality":false,"playCount":0,"trackNumberUpdateTime":0,"coverImgUrl":"http://p1.music.126.net/tGHU62DTszbFQ37W9qPHcg==/2002210674180197.jpg","coverImgId":2002210674180197,"createTime":1519893213672,"commentThreadId":"A_PL_0_2122173008","totalDuration":0,"specialType":0,"anonimous":false,"newImported":false,"trackUpdateTime":0,"trackCount":0,"userId":288986872,"description":null,"ordered":false,"tags":[],"status":0,"cloudTrackCount":0,"subscribedCount":0,"name":"123","id":2122173008}]
     * code : 200
     */

    private boolean more;
    private int code;
    private List<PlaylistBean> playlist;

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<PlaylistBean> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<PlaylistBean> playlist) {
        this.playlist = playlist;
    }

    public static class PlaylistBean {
        /**
         * subscribers : []
         * subscribed : false
         * creator : {"defaultAvatar":false,"province":440000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/UBBHztuMWfLxCU9VIGFUEw==/1376588574598995.jpg","accountStatus":0,"gender":0,"city":442000,"birthday":-2209017600000,"userId":288986872,"userType":0,"nickname":"高志成成","signature":"","description":"","detailDescription":"","avatarImgId":1376588574598995,"backgroundImgId":2002210674180198,"backgroundUrl":"http://p1.music.126.net/i0qi6mibX8gq2SaLF1bYbA==/2002210674180198.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"1376588574598995","backgroundImgIdStr":"2002210674180198"}
         * artists : null
         * tracks : null
         * privacy : 0
         * updateTime : 1470673713782
         * adType : 0
         * highQuality : false
         * playCount : 1
         * trackNumberUpdateTime : 1470673713782
         * coverImgUrl : http://p1.music.126.net/__GcdZ_6RGUQWAbAP_ZoIA==/528865094211615.jpg
         * coverImgId : 528865094211615
         * createTime : 1465572066224
         * commentThreadId : A_PL_0_398932332
         * totalDuration : 0
         * specialType : 5
         * anonimous : false
         * newImported : false
         * trackUpdateTime : 1519810103332
         * trackCount : 1
         * userId : 288986872
         * description : null
         * ordered : false
         * tags : []
         * status : 0
         * cloudTrackCount : 0
         * subscribedCount : 0
         * name : 高志成成喜欢的音乐
         * id : 398932332
         */

        private boolean subscribed;
        private CreatorBean creator;
        private Object artists;
        private Object tracks;
        private int privacy;
        private long updateTime;
        private int adType;
        private boolean highQuality;
        private int playCount;
        private long trackNumberUpdateTime;
        private String coverImgUrl;
        private long coverImgId;
        private long createTime;
        private String commentThreadId;
        private int totalDuration;
        private int specialType;
        private boolean anonimous;
        private boolean newImported;
        private long trackUpdateTime;
        private int trackCount;
        private int userId;
        private Object description;
        private boolean ordered;
        private int status;
        private int cloudTrackCount;
        private int subscribedCount;
        private String name;
        private int id;
        private List<?> subscribers;
        private List<?> tags;

        public boolean isSubscribed() {
            return subscribed;
        }

        public void setSubscribed(boolean subscribed) {
            this.subscribed = subscribed;
        }

        public CreatorBean getCreator() {
            return creator;
        }

        public void setCreator(CreatorBean creator) {
            this.creator = creator;
        }

        public Object getArtists() {
            return artists;
        }

        public void setArtists(Object artists) {
            this.artists = artists;
        }

        public Object getTracks() {
            return tracks;
        }

        public void setTracks(Object tracks) {
            this.tracks = tracks;
        }

        public int getPrivacy() {
            return privacy;
        }

        public void setPrivacy(int privacy) {
            this.privacy = privacy;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public int getAdType() {
            return adType;
        }

        public void setAdType(int adType) {
            this.adType = adType;
        }

        public boolean isHighQuality() {
            return highQuality;
        }

        public void setHighQuality(boolean highQuality) {
            this.highQuality = highQuality;
        }

        public int getPlayCount() {
            return playCount;
        }

        public void setPlayCount(int playCount) {
            this.playCount = playCount;
        }

        public long getTrackNumberUpdateTime() {
            return trackNumberUpdateTime;
        }

        public void setTrackNumberUpdateTime(long trackNumberUpdateTime) {
            this.trackNumberUpdateTime = trackNumberUpdateTime;
        }

        public String getCoverImgUrl() {
            return coverImgUrl;
        }

        public void setCoverImgUrl(String coverImgUrl) {
            this.coverImgUrl = coverImgUrl;
        }

        public long getCoverImgId() {
            return coverImgId;
        }

        public void setCoverImgId(long coverImgId) {
            this.coverImgId = coverImgId;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getCommentThreadId() {
            return commentThreadId;
        }

        public void setCommentThreadId(String commentThreadId) {
            this.commentThreadId = commentThreadId;
        }

        public int getTotalDuration() {
            return totalDuration;
        }

        public void setTotalDuration(int totalDuration) {
            this.totalDuration = totalDuration;
        }

        public int getSpecialType() {
            return specialType;
        }

        public void setSpecialType(int specialType) {
            this.specialType = specialType;
        }

        public boolean isAnonimous() {
            return anonimous;
        }

        public void setAnonimous(boolean anonimous) {
            this.anonimous = anonimous;
        }

        public boolean isNewImported() {
            return newImported;
        }

        public void setNewImported(boolean newImported) {
            this.newImported = newImported;
        }

        public long getTrackUpdateTime() {
            return trackUpdateTime;
        }

        public void setTrackUpdateTime(long trackUpdateTime) {
            this.trackUpdateTime = trackUpdateTime;
        }

        public int getTrackCount() {
            return trackCount;
        }

        public void setTrackCount(int trackCount) {
            this.trackCount = trackCount;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public boolean isOrdered() {
            return ordered;
        }

        public void setOrdered(boolean ordered) {
            this.ordered = ordered;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getCloudTrackCount() {
            return cloudTrackCount;
        }

        public void setCloudTrackCount(int cloudTrackCount) {
            this.cloudTrackCount = cloudTrackCount;
        }

        public int getSubscribedCount() {
            return subscribedCount;
        }

        public void setSubscribedCount(int subscribedCount) {
            this.subscribedCount = subscribedCount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<?> getSubscribers() {
            return subscribers;
        }

        public void setSubscribers(List<?> subscribers) {
            this.subscribers = subscribers;
        }

        public List<?> getTags() {
            return tags;
        }

        public void setTags(List<?> tags) {
            this.tags = tags;
        }

        public static class CreatorBean {
            /**
             * defaultAvatar : false
             * province : 440000
             * authStatus : 0
             * followed : false
             * avatarUrl : http://p1.music.126.net/UBBHztuMWfLxCU9VIGFUEw==/1376588574598995.jpg
             * accountStatus : 0
             * gender : 0
             * city : 442000
             * birthday : -2209017600000
             * userId : 288986872
             * userType : 0
             * nickname : 高志成成
             * signature :
             * description :
             * detailDescription :
             * avatarImgId : 1376588574598995
             * backgroundImgId : 2002210674180198
             * backgroundUrl : http://p1.music.126.net/i0qi6mibX8gq2SaLF1bYbA==/2002210674180198.jpg
             * authority : 0
             * mutual : false
             * expertTags : null
             * experts : null
             * djStatus : 0
             * vipType : 0
             * remarkName : null
             * avatarImgIdStr : 1376588574598995
             * backgroundImgIdStr : 2002210674180198
             */

            private boolean defaultAvatar;
            private int province;
            private int authStatus;
            private boolean followed;
            private String avatarUrl;
            private int accountStatus;
            private int gender;
            private int city;
            private long birthday;
            private int userId;
            private int userType;
            private String nickname;
            private String signature;
            private String description;
            private String detailDescription;
            private long avatarImgId;
            private long backgroundImgId;
            private String backgroundUrl;
            private int authority;
            private boolean mutual;
            private Object expertTags;
            private Object experts;
            private int djStatus;
            private int vipType;
            private Object remarkName;
            private String avatarImgIdStr;
            private String backgroundImgIdStr;

            public boolean isDefaultAvatar() {
                return defaultAvatar;
            }

            public void setDefaultAvatar(boolean defaultAvatar) {
                this.defaultAvatar = defaultAvatar;
            }

            public int getProvince() {
                return province;
            }

            public void setProvince(int province) {
                this.province = province;
            }

            public int getAuthStatus() {
                return authStatus;
            }

            public void setAuthStatus(int authStatus) {
                this.authStatus = authStatus;
            }

            public boolean isFollowed() {
                return followed;
            }

            public void setFollowed(boolean followed) {
                this.followed = followed;
            }

            public String getAvatarUrl() {
                return avatarUrl;
            }

            public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
            }

            public int getAccountStatus() {
                return accountStatus;
            }

            public void setAccountStatus(int accountStatus) {
                this.accountStatus = accountStatus;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public int getCity() {
                return city;
            }

            public void setCity(int city) {
                this.city = city;
            }

            public long getBirthday() {
                return birthday;
            }

            public void setBirthday(long birthday) {
                this.birthday = birthday;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getDetailDescription() {
                return detailDescription;
            }

            public void setDetailDescription(String detailDescription) {
                this.detailDescription = detailDescription;
            }

            public long getAvatarImgId() {
                return avatarImgId;
            }

            public void setAvatarImgId(long avatarImgId) {
                this.avatarImgId = avatarImgId;
            }

            public long getBackgroundImgId() {
                return backgroundImgId;
            }

            public void setBackgroundImgId(long backgroundImgId) {
                this.backgroundImgId = backgroundImgId;
            }

            public String getBackgroundUrl() {
                return backgroundUrl;
            }

            public void setBackgroundUrl(String backgroundUrl) {
                this.backgroundUrl = backgroundUrl;
            }

            public int getAuthority() {
                return authority;
            }

            public void setAuthority(int authority) {
                this.authority = authority;
            }

            public boolean isMutual() {
                return mutual;
            }

            public void setMutual(boolean mutual) {
                this.mutual = mutual;
            }

            public Object getExpertTags() {
                return expertTags;
            }

            public void setExpertTags(Object expertTags) {
                this.expertTags = expertTags;
            }

            public Object getExperts() {
                return experts;
            }

            public void setExperts(Object experts) {
                this.experts = experts;
            }

            public int getDjStatus() {
                return djStatus;
            }

            public void setDjStatus(int djStatus) {
                this.djStatus = djStatus;
            }

            public int getVipType() {
                return vipType;
            }

            public void setVipType(int vipType) {
                this.vipType = vipType;
            }

            public Object getRemarkName() {
                return remarkName;
            }

            public void setRemarkName(Object remarkName) {
                this.remarkName = remarkName;
            }

            public String getAvatarImgIdStr() {
                return avatarImgIdStr;
            }

            public void setAvatarImgIdStr(String avatarImgIdStr) {
                this.avatarImgIdStr = avatarImgIdStr;
            }

            public String getBackgroundImgIdStr() {
                return backgroundImgIdStr;
            }

            public void setBackgroundImgIdStr(String backgroundImgIdStr) {
                this.backgroundImgIdStr = backgroundImgIdStr;
            }
        }
    }
}
