package dk.si.restfull.controller;

import dk.si.restfull.classes.TravelRequest;
import get.dk.si.route.Util;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TravelController {

    private Integer visitorCount = 0;


    private Util util = new Util();
    private RoutingSlipCreator routingSlipCreator = new RoutingSlipCreator();

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

            routingSlipCreator.routeService(travelRequest);

            return travelRequest;
        } catch (Exception e) {
            return null;
            //return ResponseEntity.badRequest().build();
        }
    }


    //     public ResponseEntity counter(@PathVariable(value = "value") double fahr,@PathVariable(value = "type") String type) throws IOException {

}
