package dk.si.restfull.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import dk.si.restfull.classes.TravelRequest;
import get.dk.si.route.MetaData;
import get.dk.si.route.Root;
import get.dk.si.route.Route;
import get.dk.si.route.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class RoutingSlipCreator {

    protected Logger logger = LoggerFactory.getLogger(RoutingSlipCreator.class.getName());


    public void routeService(TravelRequest travelRequest) {
        try {
            logger.info("Recieved request.");
            Root root = new Root();


            List<Route> routingSlip = createRoutingSlip(travelRequest);
            root.setRoutingSlip(routingSlip);

            MetaData metaData = addMetaData(travelRequest);
            root.setMetaData(metaData);

            Util util = new Util();

            Route route = root.nextRoute();

            String json = util.rootToJson(root);

            util.sendToRoute(route, json);

            logger.info("Sent to rabbit.");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }

    }


    public List<Route> createRoutingSlip(TravelRequest travelRequest) {
        List<Route> routes = new ArrayList<>();

        if (travelRequest.isFlightBooking()) {
            Route route = new Route(false, "flight", "", 30);
            routes.add(route);
        }
        if (travelRequest.isHotelBooking()) {
            Route route = new Route(false, "hotel", "", 20);
            routes.add(route);
        }
        if (travelRequest.isCountryData()) {
            Route route = new Route(false, "countryData", "", 10);
            routes.add(route);
        }

        Route route = new Route(false, "email", "", 1);
        routes.add(route);

        return routes;
    }

    public MetaData addMetaData(TravelRequest travelRequest) {
        MetaData metaData = new MetaData();

        metaData.put("travelRequest", travelRequest);


        return metaData;
    }
}
