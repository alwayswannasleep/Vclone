package org.oa.teach_http.app.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class User {

    @SerializedName("id")
    private long mUid;

    @SerializedName("first_name")
    private String mFirstName;

    @SerializedName("last_name")
    private String mLastName;

    @SerializedName("deactivated")
    private String mDeactivated;

    @SerializedName("sex")
    private int mSex;

    @SerializedName("bdate")
    private String mBirthDate;

    @SerializedName("country")
    private Country mCountry;

    @SerializedName("city")
    private City mCity;

    @SerializedName("online")
    private int mOnline;

    @SerializedName("mobile_phone")
    private String mMobPhone;

    @SerializedName("home_phone")
    private String mHomePhone;

    @SerializedName("site")
    private String mSite;

    @SerializedName("university")
    private long mUniversityID;

    @SerializedName("university_name")
    private String mUniversityName;

    @SerializedName("faculty")
    private long mFacultyID;

    @SerializedName("faculty_name")
    private String mFacultyName;

    @SerializedName("universities")
    private List<University> mUniversities;

    @SerializedName("schools")
    private List<School> mSchools;

    @SerializedName("photo_100")
    private String mPhotoURL;

    @SerializedName("status")
    private String mStatus;

    @SerializedName("last_seen")
    private LastSeen mLastSeen;

    @SerializedName("followers_count")
    private int mFollowersCount;

    @SerializedName("common_count")
    private int mCommonCount;

    @SerializedName("counters")
    private Counters mCounters;

    @SerializedName("occupation")
    private Occupation mOccupation;

    @SerializedName("nickname")
    private String mNickname;

    @SerializedName("relatives")
    private List<Relative> mRelatives;

    @SerializedName("relation")
    private int mRelation;

    @SerializedName("personal")
    private Personal mPersonal;

    @SerializedName("skype")
    private String mSkype;

    @SerializedName("twitter")
    private String mTwitter;

    @SerializedName("facebook")
    private String mFacebook;

    @SerializedName("livejournal")
    private String mLivejournal;

    @SerializedName("instagram")
    private String mInstagram;

    @SerializedName("wall_comments")
    private int mWallComments;

    @SerializedName("activities")
    private String mActivities;

    @SerializedName("interests")
    private String mInterests;

    @SerializedName("music")
    private String mMusic;

    @SerializedName("movies")
    private String mMovies;

    @SerializedName("tv")
    private String mTv;

    @SerializedName("books")
    private String mBooks;

    @SerializedName("games")
    private String mGames;

    @SerializedName("about")
    private String mAbout;

    @SerializedName("can_post")
    private int mCanPost;

    @SerializedName("can_see_all_posts")
    private int mCanSeeAllPosts;

    @SerializedName("can_see_audio")
    private int mCanSeeAudio;

    @SerializedName("can_write_private_message")
    private int mCanWritePrivateMessage;

    @SerializedName("can_send_friend_request")
    private int mCanSendFriendRequest;

    @SerializedName("screen_name")
    private String mScreenName;

    @SerializedName("maiden_name")
    private String mMaidenName;

    @SerializedName("is_friend")
    private int mIsFriend;

    @SerializedName("friend_status")
    private int mFriendStatus;

    @SerializedName("career")
    private List<Career> mCareer;

    @SerializedName("military")
    private List<Military> mMilitary;

    @SerializedName("blacklisted")
    private int mBlackListed;

    @SerializedName("blacklisted_by_me")
    private int mBlackListedByMe;

    private int mStorageId;

    public User() {
    }

    public long getUid() {
        return mUid;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public int getOnline() {
        return mOnline;
    }

    public String getPhotoURL() {
        return mPhotoURL;
    }

    public void setUid(long uid) {
        mUid = uid;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public void setOnline(int online) {
        mOnline = online;
    }

    public void setPhotoURL(String photoURL) {
        mPhotoURL = photoURL;
    }

    public int getStorageId() {
        return mStorageId;
    }

    public void setStorageId(int storageId) {
        mStorageId = storageId;
    }

    public String getDeactivated() {
        return mDeactivated;
    }

    public void setDeactivated(String deactivated) {
        mDeactivated = deactivated;
    }

    public int getSex() {
        return mSex;
    }

    public void setSex(int sex) {
        mSex = sex;
    }

    public String getBirthDate() {
        return mBirthDate;
    }

    public void setBirthDate(String birthDate) {
        mBirthDate = birthDate;
    }

    public Country getCountry() {
        return mCountry;
    }

    public void setCountry(Country country) {
        mCountry = country;
    }

    public City getCity() {
        return mCity;
    }

    public void setCity(City city) {
        mCity = city;
    }

    public String getMobPhone() {
        return mMobPhone;
    }

    public void setMobPhone(String mobPhone) {
        mMobPhone = mobPhone;
    }

    public String getHomePhone() {
        return mHomePhone;
    }

    public void setHomePhone(String homePhone) {
        mHomePhone = homePhone;
    }

    public String getSite() {
        return mSite;
    }

    public void setSite(String site) {
        mSite = site;
    }

    public long getUniversityID() {
        return mUniversityID;
    }

    public void setUniversityID(long universityID) {
        mUniversityID = universityID;
    }

    public String getUniversityName() {
        return mUniversityName;
    }

    public void setUniversityName(String universityName) {
        mUniversityName = universityName;
    }

    public long getFacultyID() {
        return mFacultyID;
    }

    public void setFacultyID(long facultyID) {
        mFacultyID = facultyID;
    }

    public String getFacultyName() {
        return mFacultyName;
    }

    public void setFacultyName(String facultyName) {
        mFacultyName = facultyName;
    }

    public List<University> getUniversities() {
        return mUniversities;
    }

    public void setUniversities(List<University> universities) {
        mUniversities = universities;
    }

    public List<School> getSchools() {
        return mSchools;
    }

    public void setSchools(List<School> schools) {
        mSchools = schools;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public LastSeen getLastSeen() {
        return mLastSeen;
    }

    public void setLastSeen(LastSeen lastSeen) {
        mLastSeen = lastSeen;
    }

    public int getFollowersCount() {
        return mFollowersCount;
    }

    public void setFollowersCount(int followersCount) {
        mFollowersCount = followersCount;
    }

    public int getCommonCount() {
        return mCommonCount;
    }

    public void setCommonCount(int commonCount) {
        mCommonCount = commonCount;
    }

    public Counters getCounters() {
        return mCounters;
    }

    public void setCounters(Counters counters) {
        mCounters = counters;
    }

    public Occupation getOccupation() {
        return mOccupation;
    }

    public void setOccupation(Occupation occupation) {
        mOccupation = occupation;
    }

    public String getNickname() {
        return mNickname;
    }

    public void setNickname(String nickname) {
        mNickname = nickname;
    }

    public List<Relative> getRelatives() {
        return mRelatives;
    }

    public void setRelatives(List<Relative> relatives) {
        mRelatives = relatives;
    }

    public int getRelation() {
        return mRelation;
    }

    public void setRelation(int relation) {
        mRelation = relation;
    }

    public Personal getPersonal() {
        return mPersonal;
    }

    public void setPersonal(Personal personal) {
        mPersonal = personal;
    }

    public String getSkype() {
        return mSkype;
    }

    public void setSkype(String skype) {
        mSkype = skype;
    }

    public String getTwitter() {
        return mTwitter;
    }

    public void setTwitter(String twitter) {
        mTwitter = twitter;
    }

    public String getFacebook() {
        return mFacebook;
    }

    public void setFacebook(String facebook) {
        mFacebook = facebook;
    }

    public String getLivejournal() {
        return mLivejournal;
    }

    public void setLivejournal(String livejournal) {
        mLivejournal = livejournal;
    }

    public String getInstagram() {
        return mInstagram;
    }

    public void setInstagram(String instagram) {
        mInstagram = instagram;
    }

    public int getWallComments() {
        return mWallComments;
    }

    public void setWallComments(int wallComments) {
        mWallComments = wallComments;
    }

    public String getActivities() {
        return mActivities;
    }

    public void setActivities(String activities) {
        mActivities = activities;
    }

    public String getInterests() {
        return mInterests;
    }

    public void setInterests(String interests) {
        mInterests = interests;
    }

    public String getMusic() {
        return mMusic;
    }

    public void setMusic(String music) {
        mMusic = music;
    }

    public String getMovies() {
        return mMovies;
    }

    public void setMovies(String movies) {
        mMovies = movies;
    }

    public String getTv() {
        return mTv;
    }

    public void setTv(String tv) {
        mTv = tv;
    }

    public String getBooks() {
        return mBooks;
    }

    public void setBooks(String books) {
        mBooks = books;
    }

    public String getGames() {
        return mGames;
    }

    public void setGames(String games) {
        mGames = games;
    }

    public String getAbout() {
        return mAbout;
    }

    public void setAbout(String about) {
        mAbout = about;
    }

    public int getCanPost() {
        return mCanPost;
    }

    public void setCanPost(int canPost) {
        mCanPost = canPost;
    }

    public int getCanSeeAllPosts() {
        return mCanSeeAllPosts;
    }

    public void setCanSeeAllPosts(int canSeeAllPosts) {
        mCanSeeAllPosts = canSeeAllPosts;
    }

    public int getCanSeeAudio() {
        return mCanSeeAudio;
    }

    public void setCanSeeAudio(int canSeeAudio) {
        mCanSeeAudio = canSeeAudio;
    }

    public int getCanWritePrivateMessage() {
        return mCanWritePrivateMessage;
    }

    public void setCanWritePrivateMessage(int canWritePrivateMessage) {
        mCanWritePrivateMessage = canWritePrivateMessage;
    }

    public int getCanSendFriendRequest() {
        return mCanSendFriendRequest;
    }

    public void setCanSendFriendRequest(int canSendFriendRequest) {
        mCanSendFriendRequest = canSendFriendRequest;
    }

    public String getScreenName() {
        return mScreenName;
    }

    public void setScreenName(String screenName) {
        mScreenName = screenName;
    }

    public String getMaidenName() {
        return mMaidenName;
    }

    public void setMaidenName(String maidenName) {
        mMaidenName = maidenName;
    }

    public int getIsFriend() {
        return mIsFriend;
    }

    public void setIsFriend(int isFriend) {
        mIsFriend = isFriend;
    }

    public int getFriendStatus() {
        return mFriendStatus;
    }

    public void setFriendStatus(int friendStatus) {
        mFriendStatus = friendStatus;
    }

    public List<Career> getCareer() {
        return mCareer;
    }

    public void setCareer(List<Career> career) {
        mCareer = career;
    }

    public List<Military> getMilitary() {
        return mMilitary;
    }

    public void setMilitary(List<Military> military) {
        mMilitary = military;
    }

    public int getBlackListed() {
        return mBlackListed;
    }

    public void setBlackListed(int blackListed) {
        mBlackListed = blackListed;
    }

    public int getBlackListedByMe() {
        return mBlackListedByMe;
    }

    public void setBlackListedByMe(int blackListedByMe) {
        mBlackListedByMe = blackListedByMe;
    }

    @Override
    public String toString() {
        return "User{" +
                "mUid=" + mUid +
                ", mFirstName='" + mFirstName + '\'' +
                ", mLastName='" + mLastName + '\'' +
                ", mDeactivated='" + mDeactivated + '\'' +
                ", mSex=" + mSex +
                ", mBirthDate='" + mBirthDate + '\'' +
                ", mCountry=" + mCountry +
                ", mCity=" + mCity +
                ", mOnline=" + mOnline +
                ", mMobPhone='" + mMobPhone + '\'' +
                ", mHomePhone='" + mHomePhone + '\'' +
                ", mSite='" + mSite + '\'' +
                ", mUniversityID=" + mUniversityID +
                ", mUniversityName='" + mUniversityName + '\'' +
                ", mFacultyID=" + mFacultyID +
                ", mFacultyName='" + mFacultyName + '\'' +
                ", mUniversities=" + mUniversities +
                ", mSchools=" + mSchools +
                ", mPhotoURL='" + mPhotoURL + '\'' +
                ", mStatus='" + mStatus + '\'' +
                ", mLastSeen=" + mLastSeen +
                ", mFollowersCount=" + mFollowersCount +
                ", mCommonCount=" + mCommonCount +
                ", mCounters=" + mCounters +
                ", mOccupation=" + mOccupation +
                ", mNickname='" + mNickname + '\'' +
                ", mRelatives=" + mRelatives +
                ", mRelation=" + mRelation +
                ", mPersonal=" + mPersonal +
                ", mSkype='" + mSkype + '\'' +
                ", mTwitter='" + mTwitter + '\'' +
                ", mFacebook='" + mFacebook + '\'' +
                ", mLivejournal='" + mLivejournal + '\'' +
                ", mInstagram='" + mInstagram + '\'' +
                ", mWallComments=" + mWallComments +
                ", mActivities='" + mActivities + '\'' +
                ", mInterests='" + mInterests + '\'' +
                ", mMusic='" + mMusic + '\'' +
                ", mMovies='" + mMovies + '\'' +
                ", mTv='" + mTv + '\'' +
                ", mBooks='" + mBooks + '\'' +
                ", mGames='" + mGames + '\'' +
                ", mAbout='" + mAbout + '\'' +
                ", mCanPost=" + mCanPost +
                ", mCanSeeAllPosts=" + mCanSeeAllPosts +
                ", mCanSeeAudio=" + mCanSeeAudio +
                ", mCanWritePrivateMessage=" + mCanWritePrivateMessage +
                ", mCanSendFriendRequest=" + mCanSendFriendRequest +
                ", mScreenName='" + mScreenName + '\'' +
                ", mMaidenName='" + mMaidenName + '\'' +
                ", mIsFriend=" + mIsFriend +
                ", mFriendStatus=" + mFriendStatus +
                ", mCareer=" + mCareer +
                ", mMilitary=" + mMilitary +
                ", mBlackListed=" + mBlackListed +
                ", mBlackListedByMe=" + mBlackListedByMe +
                ", mStorageId=" + mStorageId +
                '}';
    }

    private class Country {
        @SerializedName("id")
        private long mId;

        @SerializedName("title")
        private String mTitle;

        public long getId() {
            return mId;
        }

        public void setId(long id) {
            mId = id;
        }

        public String getTitle() {
            return mTitle;
        }

        public void setTitle(String title) {
            mTitle = title;
        }

        @Override
        public String toString() {
            return "Country{" +
                    "mId=" + mId +
                    ", mTitle='" + mTitle + '\'' +
                    '}';
        }
    }

    private class City {
        @SerializedName("id")
        private long mId;

        @SerializedName("title")
        private String mTitle;

        public long getId() {
            return mId;
        }

        public void setId(long id) {
            mId = id;
        }

        public String getTitle() {
            return mTitle;
        }

        public void setTitle(String title) {
            mTitle = title;
        }

        @Override
        public String toString() {
            return "City{" +
                    "mId=" + mId +
                    ", mTitle='" + mTitle + '\'' +
                    '}';
        }
    }

    private class University {
        @SerializedName("id")
        private long mId;

        @SerializedName("country")
        private long mCountryID;

        @SerializedName("city")
        private long mCityID;

        @SerializedName("name")
        private String mName;

        @SerializedName("faculty")
        private long mFacultyID;

        @SerializedName("faculty_name")
        private String mFacultyName;

        @SerializedName("chair")
        private long mChairID;

        @SerializedName("chair_name")
        private String mChairName;

        @SerializedName("education_form")
        private String mEducationForm;

        @SerializedName("education_status")
        private String mEducationStatus;

        @SerializedName("graduation")
        private long mGraduation;

        public long getId() {
            return mId;
        }

        public void setId(long id) {
            mId = id;
        }

        public long getCountryID() {
            return mCountryID;
        }

        public void setCountryID(long countryID) {
            mCountryID = countryID;
        }

        public long getCityID() {
            return mCityID;
        }

        public void setCityID(long cityID) {
            mCityID = cityID;
        }

        public String getName() {
            return mName;
        }

        public void setName(String name) {
            mName = name;
        }

        public long getFacultyID() {
            return mFacultyID;
        }

        public void setFacultyID(long facultyID) {
            mFacultyID = facultyID;
        }

        public String getFacultyName() {
            return mFacultyName;
        }

        public void setFacultyName(String facultyName) {
            mFacultyName = facultyName;
        }

        public long getChairID() {
            return mChairID;
        }

        public void setChairID(long chairID) {
            mChairID = chairID;
        }

        public String getChairName() {
            return mChairName;
        }

        public void setChairName(String chairName) {
            mChairName = chairName;
        }

        public String getEducationForm() {
            return mEducationForm;
        }

        public void setEducationForm(String educationForm) {
            mEducationForm = educationForm;
        }

        public String getEducationStatus() {
            return mEducationStatus;
        }

        public void setEducationStatus(String educationStatus) {
            mEducationStatus = educationStatus;
        }

        public long getGraduation() {
            return mGraduation;
        }

        public void setGraduation(long graduation) {
            mGraduation = graduation;
        }

        @Override
        public String toString() {
            return "University{" +
                    "mId=" + mId +
                    ", mCountryID=" + mCountryID +
                    ", mCityID=" + mCityID +
                    ", mName='" + mName + '\'' +
                    ", mFacultyID=" + mFacultyID +
                    ", mFacultyName='" + mFacultyName + '\'' +
                    ", mChairID=" + mChairID +
                    ", mChairName='" + mChairName + '\'' +
                    ", mEducationForm='" + mEducationForm + '\'' +
                    ", mEducationStatus='" + mEducationStatus + '\'' +
                    ", mGraduation=" + mGraduation +
                    '}';
        }
    }

    private class School {
        @SerializedName("id")
        private long mId;

        @SerializedName("country")
        private long mCountryID;

        @SerializedName("city")
        private long mCityID;

        @SerializedName("name")
        private String mName;

        @SerializedName("year_from")
        private int mYearFrom;

        @SerializedName("year_to")
        private int mYearTo;

        @SerializedName("tear_graduated")
        private int mYearGraduated;

        @SerializedName("class")
        private String mSchoolClass;

        @SerializedName("speciality")
        private String mSpeciality;

        public long getId() {
            return mId;
        }

        public void setId(long id) {
            mId = id;
        }

        public long getCountryID() {
            return mCountryID;
        }

        public void setCountryID(long countryID) {
            mCountryID = countryID;
        }

        public long getCityID() {
            return mCityID;
        }

        public void setCityID(long cityID) {
            mCityID = cityID;
        }

        public String getName() {
            return mName;
        }

        public void setName(String name) {
            mName = name;
        }

        public int getYearFrom() {
            return mYearFrom;
        }

        public void setYearFrom(int yearFrom) {
            mYearFrom = yearFrom;
        }

        public int getYearTo() {
            return mYearTo;
        }

        public void setYearTo(int yearTo) {
            mYearTo = yearTo;
        }

        public int getYearGraduated() {
            return mYearGraduated;
        }

        public void setYearGraduated(int yearGraduated) {
            mYearGraduated = yearGraduated;
        }

        public String getSchoolClass() {
            return mSchoolClass;
        }

        public void setSchoolClass(String schoolClass) {
            mSchoolClass = schoolClass;
        }

        public String getSpeciality() {
            return mSpeciality;
        }

        public void setSpeciality(String speciality) {
            mSpeciality = speciality;
        }

        @Override
        public String toString() {
            return "School{" +
                    "mId=" + mId +
                    ", mCountryID=" + mCountryID +
                    ", mCityID=" + mCityID +
                    ", mName='" + mName + '\'' +
                    ", mYearFrom=" + mYearFrom +
                    ", mYearTo=" + mYearTo +
                    ", mYearGraduated=" + mYearGraduated +
                    ", mSchoolClass='" + mSchoolClass + '\'' +
                    ", mSpeciality='" + mSpeciality + '\'' +
                    '}';
        }
    }

    private class LastSeen {
        @SerializedName("time")
        private long mTime;

        @SerializedName("platform")
        private int mPlatform;

        public long getTime() {
            return mTime;
        }

        public void setTime(long time) {
            mTime = time;
        }

        public int getPlatform() {
            return mPlatform;
        }

        public void setPlatform(int platform) {
            mPlatform = platform;
        }

        @Override
        public String toString() {
            return "LastSeen{" +
                    "mTime=" + mTime +
                    ", mPlatform=" + mPlatform +
                    '}';
        }
    }

    private class Counters {
        @SerializedName("albums")
        private int mAlbumsCount;

        @SerializedName("videos")
        private int mVideosCount;

        @SerializedName("audios")
        private int mAudiosCount;

        @SerializedName("photos")
        private int mPhotosCount;

        @SerializedName("notes")
        private int mNotesCount;

        @SerializedName("friends")
        private int mFriendsCount;

        @SerializedName("groups")
        private int mGroupsCount;

        @SerializedName("online_friends")
        private int mOnlineFriendsCount;

        @SerializedName("mutual_friends")
        private int mMutualFriendsCount;

        @SerializedName("user_videos")
        private int mUserVideosCount;

        @SerializedName("followers")
        private int mFollowersCount;

        public int getAlbumsCount() {
            return mAlbumsCount;
        }

        public void setAlbumsCount(int albumsCount) {
            mAlbumsCount = albumsCount;
        }

        public int getVideosCount() {
            return mVideosCount;
        }

        public void setVideosCount(int videosCount) {
            mVideosCount = videosCount;
        }

        public int getAudiosCount() {
            return mAudiosCount;
        }

        public void setAudiosCount(int audiosCount) {
            mAudiosCount = audiosCount;
        }

        public int getPhotosCount() {
            return mPhotosCount;
        }

        public void setPhotosCount(int photosCount) {
            mPhotosCount = photosCount;
        }

        public int getNotesCount() {
            return mNotesCount;
        }

        public void setNotesCount(int notesCount) {
            mNotesCount = notesCount;
        }

        public int getFriendsCount() {
            return mFriendsCount;
        }

        public void setFriendsCount(int friendsCount) {
            mFriendsCount = friendsCount;
        }

        public int getGroupsCount() {
            return mGroupsCount;
        }

        public void setGroupsCount(int groupsCount) {
            mGroupsCount = groupsCount;
        }

        public int getOnlineFriendsCount() {
            return mOnlineFriendsCount;
        }

        public void setOnlineFriendsCount(int onlineFriendsCount) {
            mOnlineFriendsCount = onlineFriendsCount;
        }

        public int getMutualFriendsCount() {
            return mMutualFriendsCount;
        }

        public void setMutualFriendsCount(int mutualFriendsCount) {
            mMutualFriendsCount = mutualFriendsCount;
        }

        public int getUserVideosCount() {
            return mUserVideosCount;
        }

        public void setUserVideosCount(int userVideosCount) {
            mUserVideosCount = userVideosCount;
        }

        public int getFollowersCount() {
            return mFollowersCount;
        }

        public void setFollowersCount(int followersCount) {
            mFollowersCount = followersCount;
        }

        @Override
        public String toString() {
            return "Counters{" +
                    "mAlbumsCount=" + mAlbumsCount +
                    ", mVideosCount=" + mVideosCount +
                    ", mAudiosCount=" + mAudiosCount +
                    ", mPhotosCount=" + mPhotosCount +
                    ", mNotesCount=" + mNotesCount +
                    ", mFriendsCount=" + mFriendsCount +
                    ", mGroupsCount=" + mGroupsCount +
                    ", mOnlineFriendsCount=" + mOnlineFriendsCount +
                    ", mMutualFriendsCount=" + mMutualFriendsCount +
                    ", mUserVideosCount=" + mUserVideosCount +
                    ", mFollowersCount=" + mFollowersCount +
                    '}';
        }
    }

    private class Occupation {
        @SerializedName("type")
        private String mType;

        @SerializedName("id")
        private long mId;

        @SerializedName("name")
        private String mName;

        public String getType() {
            return mType;
        }

        public void setType(String type) {
            mType = type;
        }

        public long getId() {
            return mId;
        }

        public void setId(long id) {
            mId = id;
        }

        public String getName() {
            return mName;
        }

        public void setName(String name) {
            mName = name;
        }
    }

    private class Relative {
        @SerializedName("id")
        private long mID;

        @SerializedName("type")
        private String mType;

        public long getID() {
            return mID;
        }

        public void setID(long ID) {
            mID = ID;
        }

        public String getType() {
            return mType;
        }

        public void setType(String type) {
            mType = type;
        }

        @Override
        public String toString() {
            return "Relative{" +
                    "mID=" + mID +
                    ", mType='" + mType + '\'' +
                    '}';
        }
    }

    private class Personal {
        @SerializedName("political")
        private int mPolitical;

        @SerializedName("langs")
        private List<String> mLanguages;

        @SerializedName("religion")
        private String mReligion;

        @SerializedName("inspired_by")
        private String mInspiredBy;

        @SerializedName("people_main")
        private int mPeopleMain;

        @SerializedName("life_main")
        private int mLifeMain;

        @SerializedName("smoking")
        private int mSmoking;

        @SerializedName("alcohol")
        private int mAlcohol;

        public int getPolitical() {
            return mPolitical;
        }

        public void setPolitical(int political) {
            mPolitical = political;
        }

        public List<String> getLanguages() {
            return mLanguages;
        }

        public void setLanguages(List<String> languages) {
            mLanguages = languages;
        }

        public String getReligion() {
            return mReligion;
        }

        public void setReligion(String religion) {
            mReligion = religion;
        }

        public String getInspiredBy() {
            return mInspiredBy;
        }

        public void setInspiredBy(String inspiredBy) {
            mInspiredBy = inspiredBy;
        }

        public int getPeopleMain() {
            return mPeopleMain;
        }

        public void setPeopleMain(int peopleMain) {
            mPeopleMain = peopleMain;
        }

        public int getLifeMain() {
            return mLifeMain;
        }

        public void setLifeMain(int lifeMain) {
            mLifeMain = lifeMain;
        }

        public int getSmoking() {
            return mSmoking;
        }

        public void setSmoking(int smoking) {
            mSmoking = smoking;
        }

        public int getAlcohol() {
            return mAlcohol;
        }

        public void setAlcohol(int alcohol) {
            mAlcohol = alcohol;
        }

        @Override
        public String toString() {
            return "Personal{" +
                    "mPolitical=" + mPolitical +
                    ", mLanguages=" + mLanguages +
                    ", mReligion='" + mReligion + '\'' +
                    ", mInspiredBy='" + mInspiredBy + '\'' +
                    ", mPeopleMain=" + mPeopleMain +
                    ", mLifeMain=" + mLifeMain +
                    ", mSmoking=" + mSmoking +
                    ", mAlcohol=" + mAlcohol +
                    '}';
        }
    }

    private class Career {
        @SerializedName("group_id")
        private long mGroupID;

        @SerializedName("company")
        private String mCompany;

        @SerializedName("country_id")
        private int mCountryID;

        @SerializedName("city_id")
        private int mCityID;

        @SerializedName("city_name")
        private int mCityName;

        @SerializedName("from")
        private int mYearFrom;

        @SerializedName("until")
        private int mYearUntil;

        @SerializedName("position")
        private String mPosition;

        public long getGroupID() {
            return mGroupID;
        }

        public void setGroupID(long groupID) {
            mGroupID = groupID;
        }

        public String getCompany() {
            return mCompany;
        }

        public void setCompany(String company) {
            mCompany = company;
        }

        public int getCountryID() {
            return mCountryID;
        }

        public void setCountryID(int countryID) {
            mCountryID = countryID;
        }

        public int getCityID() {
            return mCityID;
        }

        public void setCityID(int cityID) {
            mCityID = cityID;
        }

        public int getCityName() {
            return mCityName;
        }

        public void setCityName(int cityName) {
            mCityName = cityName;
        }

        public int getYearFrom() {
            return mYearFrom;
        }

        public void setYearFrom(int yearFrom) {
            mYearFrom = yearFrom;
        }

        public int getYearUntil() {
            return mYearUntil;
        }

        public void setYearUntil(int yearUntil) {
            mYearUntil = yearUntil;
        }

        public String getPosition() {
            return mPosition;
        }

        public void setPosition(String position) {
            mPosition = position;
        }

        @Override
        public String toString() {
            return "Career{" +
                    "mGroupID=" + mGroupID +
                    ", mCompany='" + mCompany + '\'' +
                    ", mCountryID=" + mCountryID +
                    ", mCityID=" + mCityID +
                    ", mCityName=" + mCityName +
                    ", mYearFrom=" + mYearFrom +
                    ", mYearUntil=" + mYearUntil +
                    ", mPosition='" + mPosition + '\'' +
                    '}';
        }
    }

    private class Military {
        @SerializedName("unit")
        private String mUnit;

        @SerializedName("unit_id")
        private long mUnitID;

        @SerializedName("country_id")
        private long mCountryID;

        @SerializedName("from")
        private int mYearFrom;

        @SerializedName("until")
        private int mYearUntil;

        public String getUnit() {
            return mUnit;
        }

        public void setUnit(String unit) {
            mUnit = unit;
        }

        public long getUnitID() {
            return mUnitID;
        }

        public void setUnitID(long unitID) {
            mUnitID = unitID;
        }

        public long getCountryID() {
            return mCountryID;
        }

        public void setCountryID(long countryID) {
            mCountryID = countryID;
        }

        public int getYearFrom() {
            return mYearFrom;
        }

        public void setYearFrom(int yearFrom) {
            mYearFrom = yearFrom;
        }

        public int getYearUntil() {
            return mYearUntil;
        }

        public void setYearUntil(int yearUntil) {
            mYearUntil = yearUntil;
        }

        @Override
        public String toString() {
            return "Military{" +
                    "mUnit=" + mUnit +
                    ", mUnitID=" + mUnitID +
                    ", mCountryID=" + mCountryID +
                    ", mYearFrom=" + mYearFrom +
                    ", mYearUntil=" + mYearUntil +
                    '}';
        }
    }
}
