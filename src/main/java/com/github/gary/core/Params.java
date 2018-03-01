package com.github.gary.core;

/**
 * @author garygao
 */
public class Params {
    public final static String pubKey = "010001";
    public final static String modulus = "00e0b509f6259df8642dbc35662901477df22677ec152b5ff68ace615bb7b725152b3ab17a876aea8a5aa76d2e417629ec4ee341f56135fccf695280104e0312ecbda92557c93870114af6c9d05c4f7f0c3685b7a46bee255932575cce10b424d813cfe4875d3e82047b97ddef52741d546b8e289dc6935b3ece0462db0a22b8e7";
    public final static String nonce = "0CoJUm6Qyw8W8jud";

    /**
     * 比特率
     */
    public enum BR {
        br64(64000), br128(128000), br198(198000), br320(320000);

        private int br;

        BR(int br) {
            this.br=br;
        }

        public int getBr() {
            return br;
        }

        public void setBr(int br) {
            this.br = br;
        }
    }
}
