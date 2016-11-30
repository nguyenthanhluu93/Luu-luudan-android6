package com.gvn.pets.model.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by namIT on 11/29/2016.
 */

public class AuthenticationBean {
    @SerializedName("token")
    private String token;
    @SerializedName("user_name")
    private String userName;
    @SerializedName("user_id")
    private String userId;
    @SerializedName("fb_id")
    private String facebookId;
    @SerializedName("ava_id")
    private String avartarId;
    @SerializedName("gender")
    private int gender;
    @SerializedName("frd_num")
    private int numFriend;
    @SerializedName("fav_num")
    private int numFavourite;
    @SerializedName("fvt_num")
    private int numFavouriteMe;
    @SerializedName("chat_num")
    private int numMyChat;
    @SerializedName("noti_num")
    private int numNotification;
    @SerializedName("noti_news_num")
    private int numNotificationNews;
    @SerializedName("noti_like_num")
    private int numNotificationLike;
    @SerializedName("point")
    private int numPoint;
    @SerializedName("ivt_url")
    private String inviteUrl;
    @SerializedName("finish_register_flag")
    private int finishRegister;
    @SerializedName("verification_flag")
    private int verificationFlag;
    @SerializedName("voice_call_waiting")
    private boolean isEnableVoice;
    @SerializedName("video_call_waiting")
    private boolean isEnableVideo;
    @SerializedName("chk_out_time")
    private int checkoutTime;
    @SerializedName("fav_time")
    private int favouriteTime;
    @SerializedName("bckstg_time")
    private int backstageTime;
    @SerializedName("look_time")
    private String lookAtMeTime;
    @SerializedName("bckstg_pri")
    private int backstagePrice;
    @SerializedName("bckstg_bonus")
    private int backstageBonus;
    @SerializedName("comment_buzz_pnt")
    private int commentPoint;
    @SerializedName("chat_pnt")
    private int chatPoint;
    @SerializedName("day_bns_pnt")
    private int dailyBonusPoints;
    @SerializedName("save_img_pnt")
    private int saveImagePoints;
    @SerializedName("unlck_chk_out_pnt")
    private int unlockWhoCheckMeOutPoints;
    @SerializedName("checkout_num")
    private int unlockWhoCheckMeOutNum;
    @SerializedName("unlck_fvt_pnt")
    private int unlockFavoritePoints;
    @SerializedName("unlck_fvt")
    private int unlockFavorite;
    @SerializedName("onl_alt_pnt")
    private int onlineAlertPoints;
    @SerializedName("wink_bomb_pnt")
    private int winkBombPoints;
    @SerializedName("wink_bomb_num")
    private int winkBombNum;
    @SerializedName("ivt_frd_pnt")
    private int inviteFriendPoints;
    @SerializedName("rate_distri_point")
    private double rateDistributionPoints;
    @SerializedName("update_email_flag")
    private boolean isUpdateEmail;
    @SerializedName("turn_off_show_news_android")
    private boolean isShowPopupNews;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getAvartarId() {
        return avartarId;
    }

    public void setAvartarId(String avartarId) {
        this.avartarId = avartarId;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getNumFriend() {
        return numFriend;
    }

    public void setNumFriend(int numFriend) {
        this.numFriend = numFriend;
    }

    public int getNumFavourite() {
        return numFavourite;
    }

    public void setNumFavourite(int numFavourite) {
        this.numFavourite = numFavourite;
    }

    public int getNumFavouriteMe() {
        return numFavouriteMe;
    }

    public void setNumFavouriteMe(int numFavouriteMe) {
        this.numFavouriteMe = numFavouriteMe;
    }

    public int getNumMyChat() {
        return numMyChat;
    }

    public void setNumMyChat(int numMyChat) {
        this.numMyChat = numMyChat;
    }

    public int getNumNotification() {
        return numNotification;
    }

    public void setNumNotification(int numNotification) {
        this.numNotification = numNotification;
    }

    public int getNumNotificationNews() {
        return numNotificationNews;
    }

    public void setNumNotificationNews(int numNotificationNews) {
        this.numNotificationNews = numNotificationNews;
    }

    public int getNumNotificationLike() {
        return numNotificationLike;
    }

    public void setNumNotificationLike(int numNotificationLike) {
        this.numNotificationLike = numNotificationLike;
    }

    public int getNumPoint() {
        return numPoint;
    }

    public void setNumPoint(int numPoint) {
        this.numPoint = numPoint;
    }

    public String getInviteUrl() {
        return inviteUrl;
    }

    public void setInviteUrl(String inviteUrl) {
        this.inviteUrl = inviteUrl;
    }

    public int getFinishRegister() {
        return finishRegister;
    }

    public void setFinishRegister(int finishRegister) {
        this.finishRegister = finishRegister;
    }

    public int getVerificationFlag() {
        return verificationFlag;
    }

    public void setVerificationFlag(int verificationFlag) {
        this.verificationFlag = verificationFlag;
    }

    public boolean isEnableVoice() {
        return isEnableVoice;
    }

    public void setEnableVoice(boolean enableVoice) {
        isEnableVoice = enableVoice;
    }

    public boolean isEnableVideo() {
        return isEnableVideo;
    }

    public void setEnableVideo(boolean enableVideo) {
        isEnableVideo = enableVideo;
    }

    public int getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(int checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public int getFavouriteTime() {
        return favouriteTime;
    }

    public void setFavouriteTime(int favouriteTime) {
        this.favouriteTime = favouriteTime;
    }

    public int getBackstageTime() {
        return backstageTime;
    }

    public void setBackstageTime(int backstageTime) {
        this.backstageTime = backstageTime;
    }

    public String getLookAtMeTime() {
        return lookAtMeTime;
    }

    public void setLookAtMeTime(String lookAtMeTime) {
        this.lookAtMeTime = lookAtMeTime;
    }

    public int getBackstagePrice() {
        return backstagePrice;
    }

    public void setBackstagePrice(int backstagePrice) {
        this.backstagePrice = backstagePrice;
    }

    public int getBackstageBonus() {
        return backstageBonus;
    }

    public void setBackstageBonus(int backstageBonus) {
        this.backstageBonus = backstageBonus;
    }

    public int getCommentPoint() {
        return commentPoint;
    }

    public void setCommentPoint(int commentPoint) {
        this.commentPoint = commentPoint;
    }

    public int getChatPoint() {
        return chatPoint;
    }

    public void setChatPoint(int chatPoint) {
        this.chatPoint = chatPoint;
    }

    public int getDailyBonusPoints() {
        return dailyBonusPoints;
    }

    public void setDailyBonusPoints(int dailyBonusPoints) {
        this.dailyBonusPoints = dailyBonusPoints;
    }

    public int getSaveImagePoints() {
        return saveImagePoints;
    }

    public void setSaveImagePoints(int saveImagePoints) {
        this.saveImagePoints = saveImagePoints;
    }

    public int getUnlockWhoCheckMeOutPoints() {
        return unlockWhoCheckMeOutPoints;
    }

    public void setUnlockWhoCheckMeOutPoints(int unlockWhoCheckMeOutPoints) {
        this.unlockWhoCheckMeOutPoints = unlockWhoCheckMeOutPoints;
    }

    public int getUnlockWhoCheckMeOutNum() {
        return unlockWhoCheckMeOutNum;
    }

    public void setUnlockWhoCheckMeOutNum(int unlockWhoCheckMeOutNum) {
        this.unlockWhoCheckMeOutNum = unlockWhoCheckMeOutNum;
    }

    public int getUnlockFavoritePoints() {
        return unlockFavoritePoints;
    }

    public void setUnlockFavoritePoints(int unlockFavoritePoints) {
        this.unlockFavoritePoints = unlockFavoritePoints;
    }

    public int getUnlockFavorite() {
        return unlockFavorite;
    }

    public void setUnlockFavorite(int unlockFavorite) {
        this.unlockFavorite = unlockFavorite;
    }

    public int getOnlineAlertPoints() {
        return onlineAlertPoints;
    }

    public void setOnlineAlertPoints(int onlineAlertPoints) {
        this.onlineAlertPoints = onlineAlertPoints;
    }

    public int getWinkBombPoints() {
        return winkBombPoints;
    }

    public void setWinkBombPoints(int winkBombPoints) {
        this.winkBombPoints = winkBombPoints;
    }

    public int getWinkBombNum() {
        return winkBombNum;
    }

    public void setWinkBombNum(int winkBombNum) {
        this.winkBombNum = winkBombNum;
    }

    public int getInviteFriendPoints() {
        return inviteFriendPoints;
    }

    public void setInviteFriendPoints(int inviteFriendPoints) {
        this.inviteFriendPoints = inviteFriendPoints;
    }

    public double getRateDistributionPoints() {
        return rateDistributionPoints;
    }

    public void setRateDistributionPoints(double rateDistributionPoints) {
        this.rateDistributionPoints = rateDistributionPoints;
    }

    public boolean isUpdateEmail() {
        return isUpdateEmail;
    }

    public void setUpdateEmail(boolean updateEmail) {
        isUpdateEmail = updateEmail;
    }

    public boolean isShowPopupNews() {
        return isShowPopupNews;
    }

    public void setShowPopupNews(boolean showPopupNews) {
        isShowPopupNews = showPopupNews;
    }
}
