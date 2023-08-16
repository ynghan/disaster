package shelter.disaster.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiController {

    @GetMapping("/apitest")
    public String callapihttp() {
        StringBuffer result = new StringBuffer();

        try {
            String urlstr = "http://apis.data.go.kr/1741000/TsunamiShelter3/getTsunamiShelter1List?" +
                    "ServiceKey=cdt%2FWJxFZhiTfIABX5WQ3Aa5Zh1GeZU5Qx140UQFmRGcS92SHL2JeWTZ7fsWVaPoPzMdhJJJ7xHBR7QjqA0dCQ%3D%3D" +
                    "&type=json" +
                    "&pageNo=1" +
                    "&numOfRows=10";
            URL url = new URL(urlstr);
            HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
            urlconnection.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));

            String returnLine;
            while((returnLine = br.readLine()) != null) {
                result.append(returnLine + "\n");
            }
            urlconnection.disconnect();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result + "</xmp>";
    }
    }

