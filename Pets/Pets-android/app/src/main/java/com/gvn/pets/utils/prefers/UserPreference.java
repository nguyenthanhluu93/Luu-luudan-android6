package com.gvn.pets.utils.prefers;

import android.text.TextUtils;

import com.gvn.pets.app.Constants;
import com.gvn.pets.app.NotificationSetting;
import com.gvn.pets.base.BasePrefers;
import com.gvn.pets.model.bean.AuthenticationBean;
import com.gvn.pets.utils.LogUtils;
import com.gvn.pets.utils.TimeUtils;

/**
 * Created by namIT on 11/29/2016.
 */

public class UserPreference extends BasePrefers {

    public static String TAG = UserPreference.class.getSimpleName();

    public static final String KEY_TOKEN = "key.token";
    public static final String KEY_USER_ID = "key.user.id";
    public static final String KEY_USER_NAME = "key.user.name";
    public static final String KEY_EMAIL = "key.email";
    public static final String KEY_PASSWORD = "key.password";
    public static final String KEY_FACEBOOK_ID = "key.facebookid";
    public static final String KEY_MOCOM_ID = "key.mocom_id";
    public static final String KEY_FAMU_ID = "key.famu_id";
    public static final String KEY_AVA_ID = "key.ava.id";
    public static final String KEY_PENDING_AVA_ID = "key.pending.ava.id";
    public static final String KEY_GENDER = "key.gender";
    public static final String KEY_BIRTHDAY = "key.birthday";
    public static final String KEY_TEMP_FACEBOOK_ID = "temp_facebook_id";
    public static final String KEY_FB_AVATAR = "fb_avatar";

    public static final String KEY_EDIT_PROFILE_SHOWED = "key.edit.profile.showed";
    public static final String KEY_SHOW_NEWS_NOTIFICATIONS = "key.show.new.notifications";
    public static final String KEY_SHOW_WELCOME_NOTIFICATIONS = "key.show.welcome.notifications";
    public static final String KEY_LAST_TIME_SETUP_PROFILE_DIALOG_SHOWED = "key.last.time.setup.profile.dialog.showed";
    public static final String KEY_IS_PLEASE_FILL_PROFILE_DIALOG_SHOWABLE = "key.is.please.fill.profile.dialog.showable";
    public static final String KEY_IS_UPDATE_EMAIL = "key.is.update.email";

    public static final String KEY_NUMBER_POINT = "key.number.point";
    public static final String KEY_NUMBER_FRIEND = "key.number.friend";
    public static final String KEY_NUMBER_FAVORITE = "key.number.favorite";
    public static final String KEY_NUMBER_FAVORITED_ME = "key.number.favorited.me";
    public static final String KEY_NUMBER_CONNECTION = "key.number.connection";

    public static final String KEY_NUMBER_UNREAD_MESSAGE = "key.number.unread.message";
    public static final String KEY_NUMBER_NOTIFICATION = "key.number.notification";
    public static final String KEY_NUMBER_LIKE_NOTIFICATION = "key.number.like.notification";
    public static final String KEY_NUMBER_NEWS_NOTIFICATION = "key.number.news.notification";
    public static final String KEY_LASTTIME_UPDATE_LOCATION = "key.last.time.get.location";
    public static final String KEY_IS_AUTO_DETECT_REGION = "key.is.auto.detect.region";
    public static final String KEY_AGE_VERIFICATION = "key.age.verification";
    public static final String KEY_FINISH_REGISTER_FLAG = "key.finish.register.flag";

    public static final String KEY_CURRENT_CHAT_FRIEND_ID = "key.current.chat.friend.id";
    public static final String KEY_CURRENT_MSG_CHAT_ID = "key.current.msg.chat.id";
    public static final String KEY_IS_ENABLE_VOICE_CALL = "is.enable.voice_call";
    public static final String KEY_IS_ENABLE_VIDEO_CALL = "is.enable.video_call";
    public static final String KEY_CHAT_NOTIFICATION = "chat_notification";
    public static final String KEY_IN_CALLING_PROCESS = "in_calling_process";
    public static final String KEY_IN_RECORDING_PROCESS = "in_recording_process";
    public static final String KEY_CALLING_USER_ID = "calling_user_id";
    public static final String KEY_STARTED_CALL_MESSAGE_ID = "started_call_message_id";
    public static final String KEY_EDIT_PROFILE_FIRST_TIME = "edit_profile_first_time";

    public static final String KEY_UNLOCK_WHO_CHECK_ME_OUT = "key.unlock.who.check.me.out";
    public static final String KEY_UNLOCK_FAVORITE = "key.unlock.favorite";
    public static final String KEY_WINK_BOMB_NUMBER = "key.wink.bomb.number";
    public static final String KEY_WINK_MESSAGE_INDEX = "key.wink.message.index";

    public static final String KEY_SOUND_SETTING = "sound_setting";
    public static final String KEY_ON_OFF_SETTING = "on_off_setting";
    public static final String KEY_VIBRATION_SETTING = "vibration_setting";
    public static final String KEY_INVITE_URL = "invite_url";
    public static final String KEY_INVITE_CODE = "invite_code";

    public static final String KEY_VIDEO_CAPTION_LOCATION = "video_caption_location";
    public static final String KEY_LOGOUT = "log_out";
    public static final String KEY_IS_LOGIN = "key.is.login";

    public static final String KEY_IS_NEWLY_ACCOUNT = "is.newly.account";

    public static final String KEY_SHOW_NEWS_POPUP = "key.show.news.popup";
    public static final String KEY_IS_SHOW_NEWS = "is.show.news";
    public static final String KEY_DATE_SETTING_SHOW_NEWS = "date.setting.show.news";
    public static final String KEY_FIRST_LOGIN = "key.first.login";
    public static final String KEY_SETTING_SHOW_NEWS = "key.setting.show.news";
    public static final String KEY_IS_SETTING = "key.is.setting";

    public static UserPreference getInstance() {
        UserPreference mPreferences = new UserPreference();
        return mPreferences;
    }

    public UserPreference() {
        super();
    }

    @Override
    protected String getFileNamePrefers() {
        return "user_preference";
    }

    public void saveAuthentication(String email, String password) {
        saveEmail(email);
        savePassword(password);
    }

    public void saveSuccessLoginData(AuthenticationBean authenData,
                                     boolean isFirstLogin) {
        if (authenData == null) {
            return;
        }
        // Toogle logout flag
        setIsLogout(false);
        setIsLogin(true);

        // Basic data
        String token = authenData.getToken();
        String userName = authenData.getUserName();
        String userId = authenData.getUserId();
        String avartarId = authenData.getAvartarId();
        int gender = authenData.getGender();
        int numFriend = authenData.getNumFriend();
        int numFavourite = authenData.getNumFavourite();
        int numFavouriteMe = authenData.getNumFavouriteMe();
        int numMyChat = authenData.getNumMyChat();
        int numNotification = authenData.getNumNotification();
        int numNotificationNews = authenData.getNumNotificationNews();
        int numNotificationLike = authenData.getNumNotificationLike();
        int numPoint = authenData.getNumPoint();
        String inviteUrl = authenData.getInviteUrl();
        boolean isEnableVoice = authenData.isEnableVoice();
        boolean isEnableVideo = authenData.isEnableVideo();

        saveBasicData(token, userName, userId, avartarId, gender, numFriend,
                numFavourite, numFavouriteMe, numMyChat,
                numNotification, numNotificationNews, numNotificationLike,
                numPoint, inviteUrl, isEnableVoice, isEnableVideo);

        int finishRegister = authenData.getFinishRegister();
        int verificationFlag = authenData.getVerificationFlag();
        boolean isUpdateEmail = authenData.isUpdateEmail();

        saveUpdateEmail(isUpdateEmail);
        saveFinishRegister(finishRegister);
        saveAgeVerification(verificationFlag);
        setShowWelcomeNotifications(isFirstLogin);

        // Check login be re-login or sign up
        if (isFirstLogin) {
            saveSettingShowNews(authenData.isShowPopupNews());
            setShowNewsPopup(authenData.isShowPopupNews());
        }
//        // Check login be re-login or sign up
//        if (isFirstLogin) {
//            setShowNewsPopup(authenData.isShowPopupNews());
//            saveFirstLogin(true);
//        }
    }

    public void saveBasicData(String token, String name, String id,
                              String avatar, int gender, int numOfFriend, int numOfFavorite,
                              int numFavoritedMe, int unreadMessage,
                              int numberNotify, int numNotificationNews, int numNotificationLike,
                              int numberPoint, String inviteURL, boolean isEnableVoice,
                              boolean isEnableVideo) {
        if (!TextUtils.isEmpty(token)) {
            saveToken(token);
        }
        if (!TextUtils.isEmpty(id)) {
            saveUserId(id);
        }
        if (!TextUtils.isEmpty(name)) {
            saveUserName(name);
        }
        if (!TextUtils.isEmpty(avatar)) {
            saveAvaId(avatar);
        }
        saveGender(gender);
        saveNumberConnection(numOfFriend, numOfFavorite);
        saveNumberFavoritedMe(numFavoritedMe);
        saveNumberUnreadMessage(unreadMessage);
        saveNumberNotification(numberNotify);
        saveNumberNewsNotification(numNotificationNews);
        saveNumberLikeNotification(numNotificationLike);
        saveNumberPoint(numberPoint);
        saveIsSetting(false);
        if (!TextUtils.isEmpty(inviteURL)) {
            saveInviteUrl(inviteURL);
        }
        saveEnableVoiceCall(isEnableVoice);
        saveEnableVideoCall(isEnableVideo);
    }

    // ====== ====== setting show news from backend ===== ======
    public void saveSettingShowNews(boolean show) {
        getEditor().putBoolean(KEY_SETTING_SHOW_NEWS, show).commit();
    }

    public boolean getSettingShowNew() {
        return getPreferences().getBoolean(KEY_SETTING_SHOW_NEWS, false);
    }

    //    ===============================
    public boolean saveIsSetting(boolean isSetting) {
        LogUtils.d(TAG, "isSetting: " + isSetting);
        return getEditor().putBoolean(KEY_IS_SETTING, isSetting).commit();
    }

    public boolean getIsSetting() {
        return getPreferences().getBoolean(KEY_IS_SETTING, false);
    }


    public boolean saveFirstLogin(boolean isLogin) {
        LogUtils.d(TAG, "isLogin: " + isLogin);
        return getEditor().putBoolean(KEY_FIRST_LOGIN, isLogin).commit();
    }

    public boolean getFirstLogin() {
        return getPreferences().getBoolean(KEY_FIRST_LOGIN, false);
    }

    // ====== ====== Token ===== ======
    public boolean saveToken(String token) {
        LogUtils.d(TAG, "Token: " + token);
        return getEditor().putString(KEY_TOKEN, token).commit();
    }

    public String getToken() {
        return getPreferences().getString(KEY_TOKEN, "");
    }

    // ====== ====== User ID ===== ======
    public boolean saveUserId(String userId) {
        LogUtils.d(TAG, "User id: " + userId);
        return getEditor().putString(KEY_USER_ID, userId).commit();
    }

    public String getUserId() {
        return getPreferences().getString(KEY_USER_ID, "");
    }

    // ====== ====== User name ===== ======
    public void saveUserName(String userName) {
        LogUtils.d(TAG, "User name: " + userName);
        getEditor().putString(KEY_USER_NAME, userName).commit();
    }

    public String getUserName() {
        return getPreferences().getString(KEY_USER_NAME, "");
    }

    // ====== ====== Authentication location ===== ======
    public boolean saveEmail(String email) {
        removeFacebookId();
        return getEditor().putString(KEY_EMAIL, email).commit();
    }

    public String getRegEmail() {
        return getPreferences().getString(KEY_EMAIL, "");
    }

    public String getEmail() {
        String currentEmail = getPreferences().getString(KEY_EMAIL, "");
        if (!TextUtils.isEmpty(currentEmail)) {
            return currentEmail;
        }

        String facebookId = getFacebookId();
        if (!TextUtils.isEmpty(facebookId)) {
            return "";
        }

        return getPreferences().getString(KEY_EMAIL, "");
    }

    public void removeEmail() {
        getEditor().remove(KEY_EMAIL).commit();
    }

    public boolean savePassword(String password) {
        return getEditor().putString(KEY_PASSWORD, password).commit();
    }

    public String getPassword() {
        String currentPassword = getPreferences().getString(KEY_PASSWORD,
                "");
        if (!TextUtils.isEmpty(currentPassword)) {
            return currentPassword;
        }

        return getPreferences().getString(KEY_PASSWORD, "");
    }

    public void removePassword() {
        getEditor().remove(KEY_PASSWORD).commit();
    }

    // ====== ====== Facebook ===== ======
    public boolean saveFacebookId(String facebookId) {
        removeEmail();
        return getEditor().putString(KEY_FACEBOOK_ID, facebookId).commit();
    }

    public String getFacebookId() {
        return getPreferences().getString(KEY_FACEBOOK_ID, "");
    }

    public void removeFacebookId() {
        getEditor().remove(KEY_FACEBOOK_ID).commit();
    }

    // ====== ====== Avatar Id ===== ======
    public boolean savePendingAvaId(String avaId) {
        LogUtils.d(TAG, "Avata id: " + avaId);
        if (removeExistPendingAvatar(avaId)) {
            return getEditor().putString(KEY_AVA_ID, avaId).commit();
        }
        return false;
    }

    public boolean saveAvaId(String avaId) {
        LogUtils.d(TAG, "Avata id: " + avaId);
        return getEditor().putString(KEY_AVA_ID, avaId).commit();
    }

    public String getAvaId() {
        return getPreferences().getString(KEY_AVA_ID, "");
    }

    public void removeAvaId() {
        getEditor().remove(KEY_AVA_ID).commit();
    }

    // ====== ====== Pending avatar Id ===== ======
    private final String SPLIT = "/";

    public boolean savePendingAva(String avaId) {
        LogUtils.d(TAG, "Pending avatar: " + avaId);
        String listPendingAvatar = getListPendingAva();
        if (!TextUtils.isEmpty(listPendingAvatar)) {
            listPendingAvatar += (SPLIT + avaId);
        } else {
            listPendingAvatar = avaId;
        }

        LogUtils.d(TAG,
                "List avatar: " + listPendingAvatar.replace(SPLIT, "\n"));
        return getEditor().putString(KEY_PENDING_AVA_ID, listPendingAvatar)
                .commit();
    }

    private String getListPendingAva() {
        return getPreferences().getString(KEY_PENDING_AVA_ID, "");
    }

    public boolean removeExistPendingAvatar(String avaId) {
        LogUtils.d(TAG, "Avatar id to check pending: " + avaId);
        if (avaId == null) {
            return false;
        }

        String[] avatarArray = getListPendingAva().split(SPLIT);

        StringBuilder builder = new StringBuilder();
        boolean isConstant = false;
        for (String pendingAvatar : avatarArray) {
            LogUtils.d(TAG, "Pending avatar in list: " + pendingAvatar);
            if (avaId.equals(pendingAvatar)) {
                isConstant = true;
            } else {
                builder.append(SPLIT).append(pendingAvatar);
            }
        }

        if (builder.length() > 0) {
            builder.delete(0, 1);
        }

        getEditor().putString(KEY_PENDING_AVA_ID, builder.toString()).commit();
        return isConstant;
    }

    // ====== ====== User birthday ===== ======
    public void saveBirthday(String birthday) {
        LogUtils.d(TAG, "Birthday: " + birthday);
        getEditor().putString(KEY_BIRTHDAY, birthday).commit();
    }

    public String getBirthday() {
        return getPreferences().getString(KEY_BIRTHDAY, "");
    }

    // ====== ====== User gender ===== ======
    public boolean saveGender(int gender) {
        LogUtils.d(TAG, "Gender: " + gender);
        return getEditor().putInt(KEY_GENDER, gender).commit();
    }

    public int getGender() {
        return getPreferences().getInt(KEY_GENDER, 0);
    }

    // ====== ====== User total point ===== ======
    public void saveNumberPoint(int numberPoint) {
        LogUtils.d("namit", "Number total point:" + numberPoint);
        getEditor().putInt(KEY_NUMBER_POINT, numberPoint).commit();
    }

    public int getNumberPoint() {
        return getPreferences().getInt(KEY_NUMBER_POINT, 0);
    }

    // ====== ====== Edit profile screen showed ===== ======
    public boolean saveEditProfileIsShowed() {
        LogUtils.d(TAG, "Edit profile showed: ");
        return getEditor().putBoolean(KEY_EDIT_PROFILE_SHOWED, true).commit();
    }

    public boolean getEditProfileIsShow() {
        return getPreferences()
                .getBoolean(KEY_EDIT_PROFILE_SHOWED, false);
    }

    // ====== ====== Setting show new notification ===== ======
    public void setShowWelcomeNotifications(boolean show) {
        LogUtils.d("namit", "set Show Welcome Notifications: " + show);
        getEditor().putBoolean(KEY_SHOW_WELCOME_NOTIFICATIONS, show).commit();
    }

    public boolean getShowWelcomeNotifications() {
        LogUtils.d("namit", "get Show Welcome Notifications: " + getPreferences().getBoolean(KEY_SHOW_WELCOME_NOTIFICATIONS,
                false));
        return getPreferences().getBoolean(KEY_SHOW_WELCOME_NOTIFICATIONS,
                false);
    }

    // ====== ====== Setting show new notification ===== ======
    public void setShowNewNotifications(boolean show) {
        LogUtils.d("namit", "set Show New Notifications: " + show);
        getEditor().putBoolean(KEY_SHOW_NEWS_NOTIFICATIONS, show).commit();
    }

    public boolean getShowNewNotifications() {
        LogUtils.d("namit", "get Show New Notifications: " + getPreferences().getBoolean(KEY_SHOW_NEWS_NOTIFICATIONS,
                false));
        return getPreferences().getBoolean(KEY_SHOW_NEWS_NOTIFICATIONS,
                false);
    }

    // ====== ====== show news popup ===== ======
    public void setShowNewsPopup(boolean show) {
        getEditor().putBoolean(KEY_SHOW_NEWS_POPUP, show).commit();
    }

    public boolean getShowNewsPopup() {
        return getPreferences().getBoolean(KEY_SHOW_NEWS_POPUP, false);
    }

    // ====== ====== Setting new account sign up ===== ======
    public void setIsNewlyAccount(boolean show) {
        getEditor().putBoolean(KEY_IS_NEWLY_ACCOUNT, show).commit();
    }

    public boolean isNewlyAccount() {
        return getPreferences().getBoolean(KEY_IS_NEWLY_ACCOUNT, false);
    }

    // ====== ====== Setting on show popup news ===== ======
    public void setIsShowNews(boolean show) {
        getEditor().putBoolean(KEY_IS_SHOW_NEWS, show).commit();
    }

    public boolean isShowNews() {
        return getPreferences().getBoolean(KEY_IS_SHOW_NEWS, true);
    }

    public void saveDateSettingNews(Long thisTime) {
        getEditor().putLong(KEY_DATE_SETTING_SHOW_NEWS, thisTime).commit();
    }

    public Long getDateSettingNews() {
        return getPreferences().getLong(KEY_DATE_SETTING_SHOW_NEWS, 0);
    }

    public boolean isOutOfDateSettingNews() {
        if (getDateSettingNews() == 0) {
            return true;
        }
        return !TimeUtils.checkThisDay(getDateSettingNews(), System.currentTimeMillis());
    }


    // ====== ====== Last time setup profile dialog showed ===== ======
    public boolean saveTimeShowSetupProfile(String time) {
        return getEditor().putString(KEY_LAST_TIME_SETUP_PROFILE_DIALOG_SHOWED,
                time).commit();
    }

    public String getTimeShowSetupProfile() {
        return getPreferences().getString(
                KEY_LAST_TIME_SETUP_PROFILE_DIALOG_SHOWED, "");
    }

    // ====== ====== Number of friend ===== ======
    public boolean saveIsFillProfileDialogShowable(boolean isShowed) {
        LogUtils.d(TAG, "Please fill profile dialog showable: " + isShowed);
        return getEditor().putBoolean(
                KEY_IS_PLEASE_FILL_PROFILE_DIALOG_SHOWABLE, isShowed).commit();
    }

    public boolean getIsFillProfileDialogShowable() {
        return getPreferences().getBoolean(
                KEY_IS_PLEASE_FILL_PROFILE_DIALOG_SHOWABLE,
                Constants.IS_NOT_SHOWED_FLAG);
    }

    // ====== ====== Update email or not ===== ======
    public boolean isUpdateEmail() {
        return getPreferences().getBoolean(KEY_IS_UPDATE_EMAIL, false);
    }

    public void saveUpdateEmail(boolean isUpdateEmail) {
        getEditor().putBoolean(KEY_IS_UPDATE_EMAIL, isUpdateEmail).commit();
    }

    // ====== ====== Number of friend ===== ======
    public void saveNumberFriend(int numberFriend) {
        LogUtils.d(TAG, "Number of friend: " + numberFriend);
        getEditor().putInt(KEY_NUMBER_FRIEND, numberFriend).commit();
    }

    public void decreaseFriend() {
        int numOfFriend = getNumberFriend();
        int numOfFavorite = getNumberFavorite();
        if (numOfFriend > 0) {
            numOfFriend--;
        } else {
            numOfFriend = 0;
        }
        saveNumberFriend(numOfFriend);

        int numOfConnection = getNumberConnection();
        int sumOfConnection = numOfFriend + numOfFavorite;
        if (numOfConnection > sumOfConnection) {
            numOfConnection--;
        } else {
            numOfConnection = sumOfConnection;
        }
        saveNumberConnection(numOfConnection);
    }

    public void increaseFriend() {
        int numOfFriend = getNumberFriend();
        numOfFriend++;
        saveNumberFriend(numOfFriend);

        int numOfConnection = getNumberConnection();
        numOfConnection++;
        saveNumberConnection(numOfConnection);
    }

    public int getNumberFriend() {
        return getPreferences().getInt(KEY_NUMBER_FRIEND, 0);
    }

    // ====== ====== Number of favorite ===== ======
    public void saveNumberFavorite(int numberOfFavorite) {
        LogUtils.d(TAG, "Number of favorite: " + numberOfFavorite);
        getEditor().putInt(KEY_NUMBER_FAVORITE, numberOfFavorite).commit();
    }

    public void decreaseFavorite() {
        int numOfFriend = getNumberFriend();
        int numOfFavorite = getNumberFavorite();
        if (numOfFavorite > 0) {
            numOfFavorite--;
        } else {
            numOfFavorite = 0;
        }
        saveNumberFavorite(numOfFavorite);

        int numOfConnection = getNumberConnection();
        int sumOfConnection = numOfFriend + numOfFavorite;
        if (numOfConnection > sumOfConnection) {
            numOfConnection--;
        } else {
            numOfConnection = sumOfConnection;
        }
        saveNumberConnection(numOfConnection);
    }

    public void increaseFavorite() {
        int numOfFavorite = getNumberFavorite();
        numOfFavorite++;
        saveNumberFavorite(numOfFavorite);

        int numOfConnection = getNumberConnection();
        numOfConnection++;
        saveNumberConnection(numOfConnection);
    }

    public int getNumberFavorite() {
        return getPreferences().getInt(KEY_NUMBER_FAVORITE, 0);
    }

    // ====== ====== Number of connection ===== ======
    public void saveNumberFavoritedMe(int numberFavoritedMe) {
        LogUtils.d(TAG, "Number favorited me: " + numberFavoritedMe);
        getEditor().putInt(KEY_NUMBER_FAVORITED_ME, numberFavoritedMe).commit();
    }

    public void increaseFavoritedMe() {
        int num = getPreferences().getInt(KEY_NUMBER_FAVORITED_ME, 0);
        num++;
        saveNumberFavoritedMe(num);
    }

    public int getNumberFavoritedMe() {
        return getPreferences().getInt(KEY_NUMBER_FAVORITED_ME, 0);
    }

    // ====== ====== Number of connection ===== ======
    public void saveNumberConnection(int numberConnection) {
        LogUtils.d(TAG, "Number of connection: " + numberConnection);
        getEditor().putInt(KEY_NUMBER_CONNECTION, numberConnection).commit();
    }

    public void saveNumberConnection(int numOfFriend, int numOfFavorite) {
        saveNumberFriend(numOfFriend);
        saveNumberFavorite(numOfFavorite);
        saveNumberConnection(numOfFriend + numOfFavorite);
    }

    public int getNumberConnection() {
        return getPreferences().getInt(KEY_NUMBER_CONNECTION, 0);
    }

    // ====== ====== Number of unread message ===== ======
    public void saveNumberUnreadMessage(int unreadMessage) {
        LogUtils.d("namit", "Number of unread mesage: " + unreadMessage);
        getEditor().putInt(KEY_NUMBER_UNREAD_MESSAGE, unreadMessage).commit();
    }

    public void increaseUnreadMessage(int unreadMessage) {
        int currenMsg = getNumberUnreadMessage();
        currenMsg += unreadMessage;
        saveNumberUnreadMessage(currenMsg);
    }

    public int getNumberUnreadMessage() {
        return getPreferences().getInt(KEY_NUMBER_UNREAD_MESSAGE, 0);
    }

    // ====== ====== Number of notification ===== ======
    public void saveNumberNotification(int numberNotify) {
        LogUtils.d(TAG, "Number of notification: " + numberNotify);
        getEditor().putInt(KEY_NUMBER_NOTIFICATION, numberNotify).commit();
    }

    public void increaseNotification() {

        int numberNotify = getNumberNotification();
        numberNotify++;
        LogUtils.d(TAG, "increase Notification: " + numberNotify);
        saveNumberNotification(numberNotify);
    }

    public void decreaseNumberNotification() {
        int numberNotify = getNumberNotification();

        numberNotify--;
        if (numberNotify < 0) {
            numberNotify = 0;
        }

        saveNumberNotification(numberNotify);
    }

    public void decreaseNumberNotification(int number) {
        int numberNotify = getNumberNotification();

        numberNotify -= number;
        if (numberNotify < 0) {
            numberNotify = 0;
        }

        saveNumberNotification(numberNotify);
    }

    public int getNumberNotification() {
        return getPreferences().getInt(KEY_NUMBER_NOTIFICATION, 0);
    }

    // ====== ====== Number like of notification ===== ======
    public void saveNumberLikeNotification(int numberNotify) {
        LogUtils.d(TAG, "Number like of notification: " + numberNotify);
        getEditor().putInt(KEY_NUMBER_LIKE_NOTIFICATION, numberNotify).commit();
    }

    public void increaseLikeNotification() {
        int numberNotify = getNumberLikeNotification();
        numberNotify++;
        saveNumberLikeNotification(numberNotify);
    }

    public void decreaseNumberLikeNotification() {
        int numberNotify = getNumberLikeNotification();

        numberNotify--;
        if (numberNotify < 0) {
            numberNotify = 0;
        }

        saveNumberLikeNotification(numberNotify);
    }

    public int getNumberLikeNotification() {
        return getPreferences().getInt(KEY_NUMBER_LIKE_NOTIFICATION, 0);
    }

    // ====== ====== Number news of notification ===== ======
    public void saveNumberNewsNotification(int numberNotify) {
        LogUtils.d(TAG, "Number news of notification: " + numberNotify);
        getEditor().putInt(KEY_NUMBER_NEWS_NOTIFICATION, numberNotify).commit();
    }

    public void increaseNewsNotification() {
        int numberNotify = getNumberNewsNotification();
        numberNotify++;
        saveNumberNewsNotification(numberNotify);
    }

    public void decreaseNumberNewsNotification() {
        int numberNotify = getNumberNewsNotification();

        numberNotify--;
        if (numberNotify < 0) {
            numberNotify = 0;
        }

        saveNumberNewsNotification(numberNotify);
    }

    public int getNumberNewsNotification() {
        return getPreferences().getInt(KEY_NUMBER_NEWS_NOTIFICATION, 0);
    }

    // ====== ====== Last update location time ===== ======
    public boolean saveLastTimeUpdateLocation(long time) {
        return getEditor().putLong(KEY_LASTTIME_UPDATE_LOCATION, time).commit();
    }

    public long getLastTimeUpdateLocation() {
        return getPreferences().getLong(KEY_LASTTIME_UPDATE_LOCATION, -1);
    }

    // ====== ====== Setting auto detect region ===== ======
    public boolean saveAutoDetectRegion(boolean code) {
        return getEditor().putBoolean(KEY_IS_AUTO_DETECT_REGION, code).commit();
    }

    public boolean isAutoDetectRegion() {
        return getPreferences().getBoolean(KEY_IS_AUTO_DETECT_REGION,
                false);
    }

    // ====== ====== Current friend chat with ===== ======
    public boolean saveAgeVerification(int code) {
        LogUtils.d(TAG, "Age veification status: " + code);
        return getEditor().putInt(KEY_AGE_VERIFICATION, code).commit();
    }

    public int getAgeVerification() {
        return getPreferences().getInt(KEY_AGE_VERIFICATION, -3);
    }

    // ====== ====== Register status flag ===== ======
    public boolean saveFinishRegister(int finish) {
        LogUtils.d(TAG, "Fisnish register flag: " + finish);
        return getEditor().putInt(KEY_FINISH_REGISTER_FLAG, finish).commit();
    }

    public int getFinishRegister() {
        return getPreferences().getInt(KEY_FINISH_REGISTER_FLAG,
                Constants.FINISH_REGISTER_NO);
    }

    // ====== ====== Current friend chat with ===== ======
    public boolean saveCurentFriendChat(String userId) {
        LogUtils.i(TAG, "Current friend chat Id: " + userId);
        return getEditor().putString(KEY_CURRENT_CHAT_FRIEND_ID, userId)
                .commit();
    }

    public String getCurentFriendChat() {
        return getPreferences().getString(KEY_CURRENT_CHAT_FRIEND_ID, "");
    }

    /**
     * Must pass currentUserIdToSend. Duoc su dung khi xay ra su kien onDetach()
     * o man hinh chat. (tranh truong hop: dang chat vs A, chuyen sang chat vs B
     * thi onDetach() o A duoc goi sau khi onStart() cua B -> dan toi truong hop
     * userIdToSend bi remove
     */
    public void removeCurentFriendChat() {
        getEditor().remove(KEY_CURRENT_CHAT_FRIEND_ID).commit();
    }

    // ====== ====== The first message chat on chat screen ===== ======
    public boolean saveCurrentMsgChatId(String msgId) {
        return getEditor().putString(KEY_CURRENT_MSG_CHAT_ID, msgId).commit();
    }

    public String getCurrentMsgChatId() {
        return getPreferences().getString(KEY_CURRENT_MSG_CHAT_ID, "");
    }

    public void removeCurrentMsgChatId() {
        getEditor().remove(KEY_CURRENT_MSG_CHAT_ID).commit();
    }

    // ====== ====== Enable voice call ===== ======
    public void saveEnableVoiceCall(boolean isEnable) {
        LogUtils.d(TAG, "Enable voice call: " + isEnable);
        getEditor().putBoolean(KEY_IS_ENABLE_VOICE_CALL, isEnable).commit();
    }

    public boolean isEnableVoiceCall() {
        return getPreferences().getBoolean(KEY_IS_ENABLE_VOICE_CALL,
                false);
    }

    // ====== ====== Enable video call ===== ======
    public void saveEnableVideoCall(boolean isEnable) {
        LogUtils.d(TAG, "Enable video call: " + isEnable);
        getEditor().putBoolean(KEY_IS_ENABLE_VIDEO_CALL, isEnable).commit();
    }

    public boolean isEnableVideoCall() {
        return getPreferences().getBoolean(KEY_IS_ENABLE_VIDEO_CALL,
                false);
    }

    // ====== ====== Show who check me out ===== ======
    public boolean saveUnlockWhoCheckMeOut(int unlockWhoCheckMeOut) {
        LogUtils.d(TAG, "Who check me out: " + unlockWhoCheckMeOut);
        return getEditor().putInt(KEY_UNLOCK_WHO_CHECK_ME_OUT,
                unlockWhoCheckMeOut).commit();
    }

    public int getUnlockWhoCheckMeOut() {
        return getPreferences().getInt(KEY_UNLOCK_WHO_CHECK_ME_OUT, 0);
    }

    // ====== ====== Unlock favorite ===== ======
    public boolean saveUnlockFavorite(int unlockFavorite) {
        LogUtils.d(TAG, "Unlock user list: " + unlockFavorite);
        return getEditor().putInt(KEY_UNLOCK_FAVORITE, unlockFavorite).commit();
    }

    public int getUnlockFavorite() {
        return getPreferences().getInt(KEY_UNLOCK_FAVORITE, 0);
    }

    // ====== ====== Number of wink bomb ===== ======
    public boolean saveWinkBombNumber(int winkBombNumber) {
        LogUtils.d(TAG, "Wink bomb number: " + winkBombNumber);
        return getEditor().putInt(KEY_WINK_BOMB_NUMBER, winkBombNumber)
                .commit();
    }

    public int getWinkBombNumber() {
        return getPreferences().getInt(KEY_WINK_BOMB_NUMBER, 0);
    }

    // ====== ====== Wink bomb message ===== ======
    public boolean saveWinkMessageIndex(int winkMessageIndex) {
        LogUtils.d(TAG, "Wink bomb message index: " + winkMessageIndex);
        return getEditor().putInt(KEY_WINK_MESSAGE_INDEX, winkMessageIndex)
                .commit();
    }

    public int getWinkMessageIndex() {
        return getPreferences().getInt(KEY_WINK_MESSAGE_INDEX, 0);
    }

    // ====== ====== group setting off on===== ======
    public boolean saveOnOffLayout(boolean value) {
        LogUtils.d(TAG, "saveOnOffLayout: " + value);
        return getEditor().putBoolean(KEY_ON_OFF_SETTING, value).commit();
    }

    public boolean isOnOffLayout() {
        return getPreferences().getBoolean(KEY_ON_OFF_SETTING, true);
    }

    // ====== ====== Sound setting ===== ======
    public boolean saveSoundOn(boolean value) {
        LogUtils.d(TAG, "Sound: " + value);
        return getEditor().putBoolean(KEY_SOUND_SETTING, value).commit();
    }

    public boolean isSoundOn() {
        return getPreferences().getBoolean(KEY_SOUND_SETTING, true);
    }

    // ====== ====== Vibration setting ===== ======
    public boolean saveVibration(boolean value) {
        LogUtils.d(TAG, "Vibration: " + value);
        return getEditor().putBoolean(KEY_VIBRATION_SETTING, value).commit();
    }

    public boolean isVibration() {
        return getPreferences().getBoolean(KEY_VIBRATION_SETTING, true);
    }

    // ====== ====== Invite URL ===== ======
    public void saveInviteUrl(String url) {
        getEditor().putString(KEY_INVITE_URL, url).commit();
    }

    public String getInviteUrl() {
        return getPreferences().getString(KEY_INVITE_URL, "");
    }

    // ====== ====== Invite code ===== ======
    public void saveInviteCode(String code) {
        getEditor().putString(KEY_INVITE_CODE, code).commit();
    }

    public String getInviteCode() {
        return getPreferences().getString(KEY_INVITE_CODE, "");
    }

    // ====== ====== Notification chat type ===== ======
    public void saveChatNotificationType(int type) {
        LogUtils.i(TAG, "Notification type: " + type);
        getEditor().putInt(KEY_CHAT_NOTIFICATION, type).commit();
    }

    public int getChatNotificationType() {
        return getPreferences().getInt(KEY_CHAT_NOTIFICATION,
                NotificationSetting.NOTIFY_CHAT_ALL);
    }

    // ====== ====== In calling progress ===== ======
    public void setInCallingProcess(boolean isCalling) {
        LogUtils.i(TAG, "Calling progress: " + isCalling);
        getEditor().putBoolean(KEY_IN_CALLING_PROCESS, isCalling).commit();
    }

    public boolean getInCallingProcess() {
        return getPreferences().getBoolean(KEY_IN_CALLING_PROCESS, false);
    }

    // ====== ====== In calling progress ===== ======
    public void setInRecordingProcess(boolean isCalling) {
        getEditor().putBoolean(KEY_IN_RECORDING_PROCESS, isCalling).commit();
    }

    public boolean getInRecordingProcess() {
        return getPreferences().getBoolean(KEY_IN_RECORDING_PROCESS,
                false);
    }

    // ====== ====== In calling progress ===== ======
    public void setCallingUserId(String userId) {
        getEditor().putString(KEY_CALLING_USER_ID, userId).commit();
    }

    public String getCallingUserId() {
        return getPreferences().getString(KEY_CALLING_USER_ID, "");
    }

    // ====== ====== Start call mesage id ===== ======
    public void setStartedCallMessageId(String msdId) {
        getEditor().putString(KEY_STARTED_CALL_MESSAGE_ID, msdId).commit();
    }

    public String getStartedCallMessageId() {
        return getPreferences()
                .getString(KEY_STARTED_CALL_MESSAGE_ID, "");
    }

    // ====== ====== Is first time edit profile ===== ======
    public void saveEditProfileFirstTime(boolean isProfilEdited) {
        getEditor().putBoolean(KEY_EDIT_PROFILE_FIRST_TIME, isProfilEdited)
                .commit();
        LogUtils.d(TAG, "isProfilEdited: " + isProfilEdited);
    }

    public boolean getEditProfileFirstTime() {
        return getPreferences().getBoolean(KEY_EDIT_PROFILE_FIRST_TIME,
                false);
    }

    // ====== ====== Temp Facebook id ===== ======
    public boolean saveTempFacebookId(String facebookId) {
        LogUtils.d(TAG, "FacebookId:" + facebookId);
        return getEditor().putString(KEY_TEMP_FACEBOOK_ID, facebookId).commit();
    }

    public String getTempFacebookId() {
        return getPreferences().getString(KEY_TEMP_FACEBOOK_ID, "");
    }

    // ====== ====== Facebook avatar id ===== ======
    public boolean saveFacebookAvatar(String url) {
        return getEditor().putString(KEY_FB_AVATAR, url).commit();
    }

    public String getFacebookAvatar() {
        return getPreferences().getString(KEY_FB_AVATAR, "");
    }

    // ====== ====== Video video location ===== ======
    public static int TOP_LEFT = 1;
    public static int TOP_RIGHT = 2;
    public static int BOTTOM_RIGHT = 3;
    public static int BOTTOM_LEFT = 4;

    public boolean saveVideoLocation(int location) {
        return getEditor().putInt(KEY_VIDEO_CAPTION_LOCATION, location)
                .commit();
    }

    public int getVideoLocation() {
        return getPreferences().getInt(KEY_VIDEO_CAPTION_LOCATION,
                TOP_LEFT);
    }

    public boolean isLogout() {
        return getPreferences().getBoolean(KEY_LOGOUT, true);
    }

    public void setIsLogout(boolean isLogout) {
        getEditor().putBoolean(KEY_LOGOUT, isLogout).commit();
    }

    public boolean isLogin() {
        return getPreferences().getBoolean(KEY_IS_LOGIN, false);
    }

    public void setIsLogin(boolean isLogin) {
        getEditor().putBoolean(KEY_IS_LOGIN, isLogin).commit();
    }

}