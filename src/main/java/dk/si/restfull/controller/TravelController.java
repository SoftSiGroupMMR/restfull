package dk.si.restfull.controller;

import dk.si.restfull.classes.TravelRequest;
import get.dk.si.route.Util;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


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



    @PostMapping("/travelRequest")
    public EntityModel<TravelRequest> createTravelSearch(@RequestBody TravelRequest travelRequest) {
        visitorCount++;
        try {
            System.out.println(travelRequest);

            routingSlipCreator.routeService(travelRequest);

            EntityModel<TravelRequest> resource = EntityModel.of(travelRequest);

            Link selfLink = linkTo(methodOn(this.getClass()).createTravelSearch(travelRequest)).withSelfRel();
            resource.add(selfLink);


            return resource;

        } catch (Exception e) {
            return null;
        }
    }


    @GetMapping("/showVisitorCount")
    public ResponseEntity seeCounter() throws Exception {
        try {
            return ResponseEntity.ok().body("{\"visitorCount\" : " + visitorCount + "}");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    //     public ResponseEntity counter(@PathVariable(value = "value") double fahr,@PathVariable(value = "type") String type) throws IOException {

}
