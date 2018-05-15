package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import model.IncomingRequestParameters;
import org.springframework.util.StreamUtils;
import play.libs.Json;
import play.mvc.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Date;

public class Application extends Controller {

    public Result index() {
        return ok("Your new application is ready.");
    }

    /* This function receives the incoming requests from the AdsUnlock server.
       It parses the parameters (JSON query parameters) and stores them in an object
       that can be used to pick out the necessary fields to create individual
       requests to third party ad sources.
    * */
    @BodyParser.Of(BodyParser.Json.class)
    public Result mediationRequest() {
        JsonNode json = request().body().asJson();

        IncomingRequestParameters incomingParameters = new IncomingRequestParameters();

        String request_type = json.get("rt").asText();
        incomingParameters.setRequestType(request_type);

        String longitude = json.get("longitude").asText();
        incomingParameters.setLongitude(longitude);

        String latitude = json.get("latitude").asText();
        incomingParameters.setLatitude(latitude);

        String userAgentInfo = json.get("u").asText();
        incomingParameters.setUserAgentInfo(userAgentInfo);

        String userAgentExtraInfo = json.get("u2").asText();
        incomingParameters.setUserAgentExtraInfo(userAgentExtraInfo);

        String placementId = json.get("s").asText();
        incomingParameters.setPlacementId(placementId);

        String sdkType = json.get("sdk").asText();
        incomingParameters.setSdkType(sdkType);

        String imei = json.get("o").asText();
        incomingParameters.setImei1(imei);

        String sdkVersion = json.get("v").asText();
        incomingParameters.setSdkVersion(sdkVersion);

        String ipAddress = json.get("i").asText();
        incomingParameters.setIpAddress(ipAddress);

        String mraid = json.get("c.mraid").asText();
        incomingParameters.setMraid(mraid);

        String connectionType = json.get("connection_type").asText();
        incomingParameters.setConnectionType(connectionType);

        String imei2 = json.get("o2").asText();
        incomingParameters.setImei2(imei2);

        String t = json.get("t").asText();
        incomingParameters.setT(t);

        String listAds = json.get("listads").asText();
        incomingParameters.setListAds(listAds);

        String response= "";
        String priority = "ADSCEND";
        long startTime;
        long stopTime;

        switch ("ADSUNLOCK") {
            case "ADSCEND" :
                try {
                    Date date = new Date();

//                    System.currentTimeMillis();
                    startTime = date.getTime();
                    System.out.println("Start time : "+startTime);
                    URL url = new URL("https://api.adscendmedia.com/v1/publisher/109363/offers.json?target_system[]=40&countries[]=IN");
                    String encoding = Base64.getEncoder().encodeToString("109363:1481867767".getBytes("UTF-8"));
//            String encoding = Base64Encoder.encode("109363:1481867767");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setDoOutput(true);
                    connection.setRequestProperty("Authorization", "Basic " + encoding);
                    InputStream content = (InputStream)connection.getInputStream();
                    BufferedReader in = new BufferedReader(new InputStreamReader(content));

//                    StreamUtils.copyToString(content, Charset.forName("UTF-8"));
                    String line;
                    date = new Date();
                    stopTime = date.getTime();
                    System.out.println("Stop time : "+startTime);
                    System.out.println("Time taken : "+(stopTime-startTime));
                    while ((line = in.readLine()) != null) {
                        System.out.println("all good");
                        response=new String(line);

                    }
                } catch(Exception e) {
                    e.printStackTrace();
                }
                break;

            case "ADSUNLOCK" :
                try {
                    Date date = new Date();

//                    System.currentTimeMillis();
                    startTime = date.getTime();
                    System.out.println("Start time : "+startTime);

                    // Append to the URL string
                    String lUrl = "https://advertiser.adsunlock.com/md.adnetwork.php?";
                    lUrl += "country_code=IN";
                    lUrl += "&longitude="+incomingParameters.getLongitude();
                    lUrl += "&latitude="+incomingParameters.getLatitude();
                    lUrl += "&i="+incomingParameters.getIpAddress();
                    lUrl += "&u="+incomingParameters.getUserAgentInfo();
                    lUrl += "&o="+incomingParameters.getImei1();
                    lUrl += "&o2="+incomingParameters.getImei2();
                    lUrl += "&t="+incomingParameters.getT();
                    lUrl += "&connection_type="+incomingParameters.getConnectionType();
                    lUrl += "&os=android_app";
                    lUrl += "&device_type=Smartphone" +
                            "&device_brand=Samsung" +
                            "&device_model=sm-12345" +
                            "&req_user_id=example@gmail.com" +
                            "&device_resolution=1209*345" +
                            "&req_type=banner" +
                            "&width=320" +
                            "&height=50" +
                            "&refresh_rate=30" +
                            "&category=4";

                    System.out.println("BUILT URL :" +lUrl);

                    URL url = new URL(lUrl);

                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setDoOutput(true);
                    InputStream content = (InputStream)connection.getInputStream();
                    BufferedReader in = new BufferedReader(new InputStreamReader(content));

                    response = StreamUtils.copyToString(content, Charset.forName("UTF-8"));
                    System.out.println("RESULT:"+response);
//                    String line;
                    date = new Date();
                    stopTime = date.getTime();
                    System.out.println("Stop time : "+startTime);
                    System.out.println("Time taken : "+(stopTime-startTime));
//                    while ((line = in.readLine()) != null) {
//                        System.out.println("all good");
//                        response=new String(line);
//
//                    }
                } catch(Exception e) {
                    e.printStackTrace();
                }
                break;

            default: break;
        }

        return ok(response);
    }
}
