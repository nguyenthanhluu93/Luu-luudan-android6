package com.gvn.pets.model.bean;

import com.google.gson.annotations.SerializedName;
import com.gvn.pets.base.model.ServerResponse;

import java.util.ArrayList;

/**
 * Created by namIT on 11/18/2016.
 */

public class TestBean extends ServerResponse {

    @SerializedName("data")
    private ArrayList<ConversationItem> conversationItem;

    public ArrayList<ConversationItem> getConversationItem() {
        return conversationItem;
    }

    public void setConversationItem(ArrayList<ConversationItem> conversationItem) {
        this.conversationItem = conversationItem;
    }

    class ConversationItem{
        @SerializedName("frd_id")
        private String friendId;
        @SerializedName("frd_name")
        private String name;
        @SerializedName("is_online")
        private boolean isOnline;
        @SerializedName("last_msg")
        private String lastMessage;
        @SerializedName("is_own")
        private boolean isOwn;
        @SerializedName("sent_time")
        private String sentTime;
        @SerializedName("unread_num")
        private int unreadNum;
        @SerializedName("long")
        private double longtitude;
        @SerializedName("lat")
        private double lattitude;
        @SerializedName("dist")
        private double distance;
        @SerializedName("ava_id")
        private String avaId;
        @SerializedName("gender")
        private int gender;
        @SerializedName("msg_type")
        private String messageType;
        @SerializedName("is_anonymous")
        private boolean anonymous;

        @SerializedName("voice_call_waiting")
        private boolean isVoiceCallWaiting;

        @SerializedName("video_call_waiting")
        private boolean isVideoCallWaiting;

        private boolean isMsgError = false;

        public ConversationItem() {
        }

        public String getMessageType() {
            return messageType;
        }

        public void setMessageType(String messageType) {
            this.messageType = messageType;
        }

        public String getFriendId() {
            return friendId;
        }

        public void setFriendId(String friendId) {
            this.friendId = friendId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isOnline() {
            return isOnline;
        }

        public void setOnline(boolean isOnline) {
            this.isOnline = isOnline;
        }

        public String getLastMessage() {
            return lastMessage;
        }

        public boolean isOwn() {
            return isOwn;
        }

        public void setOwn(boolean isOwn) {
            this.isOwn = isOwn;
        }

        public String getSentTime() {
            return sentTime;
        }

        public void setSentTime(String sentTime) {
            this.sentTime = sentTime;
        }

        public int getUnreadNum() {
            return unreadNum;
        }

        public void setUnreadNum(int unreadNum) {
            this.unreadNum = unreadNum;
        }

        public double getLongtitude() {
            return longtitude;
        }

        public void setLongtitude(double longtitude) {
            this.longtitude = longtitude;
        }

        public double getLattitude() {
            return lattitude;
        }

        public void setLattitude(double lattitude) {
            this.lattitude = lattitude;
        }

        public double getDistance() {
            return this.distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public String getAvaId() {
            return avaId;
        }

        public void setAvaId(String avaId) {
            this.avaId = avaId;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public boolean getIsAnonymous() {
            return this.anonymous;
        }

        public void setIsAnonymous(boolean anonymous) {
            this.anonymous = anonymous;
        }

        public boolean isVoiceCallWaiting() {
            return isVoiceCallWaiting;
        }

        public void setVoiceCallWaiting(boolean isVoiceCallWaiting) {
            this.isVoiceCallWaiting = isVoiceCallWaiting;
        }

        public boolean isVideoCallWaiting() {
            return isVideoCallWaiting;
        }

        public void setVideoCallWaiting(boolean isVideoCallWaiting) {
            this.isVideoCallWaiting = isVideoCallWaiting;
        }

        public boolean isMsgError() {
            return isMsgError;
        }

        public void setMsgError(boolean isMsgError) {
            this.isMsgError = isMsgError;
        }
    }
}
