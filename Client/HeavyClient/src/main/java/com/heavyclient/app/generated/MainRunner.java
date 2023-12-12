package com.heavyclient.app.generated;

public class MainRunner {
    PartialRoutingSuccessfulResult result;
    public MainRunner(PartialRoutingSuccessfulResult result) {
        this.result = result;
    }
//    public void run() {
//        var fullRoute = result.getValue().getFullRoute().getValue();
//        var routeParts = fullRoute.getRoutePart();
//
//        // Starting point -> nearest station on foot
//        var routePart1 = routeParts.get(0);
//        printSteps(routePart1, "Going from starting point to nearest station");
//
//        // Nearest station -> destination station on bike
//        var routePart2 = routeParts.get(1);
//        printSteps(routePart2, "Going from nearest station to destination station");
//
//        // Destination station to destination on foot
//        var routePart3 = routeParts.get(2);
//        printSteps(routePart3, "Going from destination station to destination");
//    }

    private void printSteps(RoutePart routePart, String message) {
        System.out.println("--- " + message + " ---");
        var steps = routePart.getPath().getValue().getFeatures().getValue().getFeature().get(0).getProperties().getValue().getSegments().getValue().getSegment().get(0).getSteps().getValue().getStep();
        int stepNumber = 1;
        for (Step step : steps) {
            System.out.println("Step " + stepNumber + ": " + step.getInstruction().getValue());
            stepNumber++;
        }
    }
}
