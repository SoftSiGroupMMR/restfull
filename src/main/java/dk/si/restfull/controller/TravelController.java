package dk.si.restfull.controller;

import dk.si.restfull.classes.TravelRequest;
import dk.si.restfull.rabbit.Rabbit;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TravelController {

    Integer visitorCount = 0;
    ArrayList ips = new ArrayList<String>();



    @GetMapping("/")
    public ResponseEntity getHello() {
        visitorCount++;
        return ResponseEntity.ok().body("{\"response\": \"ok\"}");
    }


    @GetMapping("/showVisitorCount")
    public ResponseEntity seeCounter() throws Exception {
        try {
            return ResponseEntity.ok().body("{\"visitorCount\" : " + visitorCount + "}");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @PostMapping("/createTravel")
    public TravelRequest createTravelSearch(@RequestBody TravelRequest travelRequest) {
        visitorCount++;
        try {
            System.out.println(travelRequest);
            Rabbit rabbit = new Rabbit();
            rabbit.send(travelRequest.toString());
            return travelRequest;
            //return ResponseEntity.ok().body("{\"response\" : \"ok\"}");
        } catch (Exception e) {
            return null;
            //return ResponseEntity.badRequest().build();
        }
    }


    //     public ResponseEntity counter(@PathVariable(value = "value") double fahr,@PathVariable(value = "type") String type) throws IOException {

}
