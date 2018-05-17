package model;

/* This model is used for the incoming request parameters.
 */
public class IncomingRequestParameters {



//    String mSdkType;
//    String mSdkVersion;
//    String mMraid;
//    String mT;

    String mCountryCode;
    String mLongitude;
    String mLatitude;
    String mUserAgentInfo;
    String mUserAgentExtraInfo;
    String mPlacementId;
    int mRefreshRate;
    String mImei1;
    String mIpAddress;
    String mConnectionType;
    String mImei2;
    String mRequestType;
    int mCategory;
    int mWidth;
    int mHeight;

    public String getRequestType() {
        return mRequestType;
    }

    public void setRequestType(String requestType) {
        this.mRequestType = requestType;
    }

    public String getLongitude() {
        return mLongitude;
    }

    public void setLongitude(String longitude) {
        this.mLongitude = longitude;
    }

    public String getLatitude() {
        return mLatitude;
    }

    public void setLatitude(String latitude) {
        this.mLatitude = latitude;
    }

    public String getUserAgentInfo() {
        return mUserAgentInfo;
    }

    public void setUserAgentInfo(String userAgentInfo) {
        this.mUserAgentInfo = userAgentInfo;
    }

    public String getUserAgentExtraInfo() {
        return mUserAgentExtraInfo;
    }

    public void setUserAgentExtraInfo(String userAgentExtraInfo) {
        this.mUserAgentExtraInfo = userAgentExtraInfo;
    }

    public String getPlacementId() {
        return mPlacementId;
    }

    public void setPlacementId(String placementId) {
        this.mPlacementId = placementId;
    }

//    public String getSdkType() {
//        return mSdkType;
//    }

//    public void setSdkType(String sdkType) {
//        this.mSdkType = sdkType;
//    }

    public String getImei1() {
        return mImei1;
    }

    public void setImei1(String imei1) {
        this.mImei1 = imei1;
    }

//    public String getSdkVersion() {
//        return mSdkVersion;
//    }

//    public void setSdkVersion(String sdkVersion) {
//        this.mSdkVersion = sdkVersion;
//    }

    public String getIpAddress() {
        return mIpAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.mIpAddress = ipAddress;
    }

//    public String getMraid() {
//        return mMraid;
//    }

//    public void setMraid(String mraid) {
//        this.mMraid = mraid;
//    }

    public String getConnectionType() {
        return mConnectionType;
    }

    public void setConnectionType(String connectionType) {
        this.mConnectionType = connectionType;
    }

    public String getImei2() {
        return mImei2;
    }

    public void setImei2(String imei2) {
        this.mImei2 = imei2;
    }

//    public String getT() {
//        return mT;
//    }

//    public void setT(String t) {
//        this.mT = t;
//    }

//    public String getListAds() {
//        return mListAds;
//    }

//    public void setListAds(String listAds) {
//        this.mListAds = listAds;
//    }


    public String getCountryCode() {
        return mCountryCode;
    }

    public void setCountryCode(String countryCode) {
        this.mCountryCode = countryCode;
    }

    public int getRefreshRate() {
        return mRefreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        this.mRefreshRate = refreshRate;
    }

    public int getCategory() {
        return mCategory;
    }

    public void setCategory(int category) {
        this.mCategory = category;
    }

    public int getWidth() {
        return mWidth;
    }

    public void setWidth(int width) {
        this.mWidth = width;
    }

    public int getHeight() {
        return mHeight;
    }

    public void setHeight(int height) {
        this.mHeight = height;
    }
}
