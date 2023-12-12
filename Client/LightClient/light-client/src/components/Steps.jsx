import stepIc from "../assets/step.png";
import {
  faArrowRight,
  faArrowLeft,
  faRoad,
  faClock,
  faCheckCircle,
} from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { useEffect, useState } from "react";
import GetTypeIcon from "./GetTypeIcon";
import moment from "moment";
import { Stepper, Step, Button, Typography } from "@material-tailwind/react";
import originIc from "../assets/origin.png";
import destinationIc from "../assets/destination.png";
import originStationIc from "../assets/originStation.png";
import destinationStationIc from "../assets/destionationStation.png";
import congratsIc from "../assets/congrats.webp";
export default function Steps(props) {
  const { currentStep, setCurrentStep, updateCurrentStep, steps } = props;
  const updateStep = (num) => {
    if (currentStep.number < currentStep.nbSteps - num) {
      setPreviousStep(currentStep);
      updateCurrentStep(num);
      resetTimeDistance(num);
    } else if (currentStep.stepType === 2) {
    } else {
      updateCurrentStep(0);
    }
  };

  const resetTimeDistance = (num) => {
    switch (num) {
      case 0:
        setKmTotalLeft(kmTotal);
        setTimePreviousStep(0);
        break;
      case 1:
        setKmTotalLeft(kmTotalLeft - currentStep.step.Distance);
        setTimePreviousStep(timePreviousStep + currentStep.step.Duration);
        break;
      case -1:
        setKmTotalLeft(kmTotalLeft + previousStep.step.Distance);
        setTimePreviousStep(timePreviousStep - previousStep.step.Duration);
        break;
      default:
        break;
    }
  };

  useEffect(() => {
      setKmTotal(kmTotalCal());
      setKmTotalLeft(kmTotalCal());
      setTimePreviousStep(0);
      setArrivalTime(arrivalTimeCal());
  }, [steps]);

  //------For demo purpose only-------
  //   useEffect(() => {
  //     setTimeout(() => {
  //       updateStep(1);
  //   }, 10);
  // }, [updateStep]);
  //------For demo purpose only-------


  const [kmTotal, setKmTotal] = useState(0);
  const [previousStep, setPreviousStep] = useState(null);
  const [kmTotalLeft, setKmTotalLeft] = useState(0);
  const [timePreviousStep, setTimePreviousStep] = useState(0);
  const [arrivalTime, setArrivalTime] = useState("");

  const isPreviousDisabled = () => {
    return currentStep.number === 0 && currentStep.stepType === 0;
  };

  const isNextDisabled = () => {
    return (
      currentStep.number === currentStep.nbSteps - 1 &&
      currentStep.stepType === 2
    );
  };
  const stepName = () => {
    switch (currentStep.stepType) {
      case 0:
        return "Going to your nearest station";
      case 1:
        return "Going to the destination station";
      case 2:
        return "Going to your destination";
      default:
        return "Congratulations, you arrived to the destination";
    }
  };

  const meterOrKm = (num) => {
    if (num < 1000) {
      return num.toFixed(2) + " m";
    } else {
      return (num / 1000).toFixed(2) + " km";
    }
  };

  const arrivalTimeCal = () => {
    const fullRoutes = steps.fullRoute;
    const totalTime = fullRoutes.reduce(
      (accumulator, route) =>
        accumulator +
        route.Path.Features[0].Properties.Segments[0].Steps.reduce(
          (accumulator, step) => accumulator + (step.Duration || 0),
          0
        ),
      0
    );
    return moment().add(totalTime, "seconds").format("LT");
  };

  const kmTotalCal = () => {
    const fullRoutes = steps.fullRoute;
    const totalDistance = fullRoutes.reduce(
      (accumulator, route) =>
        accumulator +
        route.Path.Features[0].Properties.Segments[0].Steps.reduce(
          (accumulator, step) => accumulator + (step.Distance || 0),
          0
        ),
      0
    );
    return totalDistance;
  };

  const secondsOrHour = (num) => {
    let duration = moment.duration(num, "seconds");
    let hh =
      duration.years() * (365 * 24) +
      duration.months() * (30 * 24) +
      duration.days() * 24 +
      duration.hours();
    let mm = duration.minutes();
    let ss = duration.seconds();
    if (hh === 0) {
      return mm === 0 ? ss + " sec" : mm + " min " + ss + " sec";
    } else {
      return mm === 0
        ? hh + " h " + ss + " sec"
        : hh + " h " + mm + " min " + ss + " sec";
    }
  };

  const calculSecondsFromNow = (num) => {
    //return expected arrival time
    let minTotal = num + timePreviousStep;
    return moment().add(minTotal, "seconds").format("LT");
  };

  return (
    <div className="h-full bg-white flex flex-col items-center justify-center">
      {currentStep.number === currentStep.nbSteps - 1 &&
      currentStep.stepType === steps.fullRoute.length - 1 ? (
        <img src={congratsIc} alt="congrats" className="h-full mb-1 mx-auto" />
      ) : (
        <>
          <div className="flex-1 pb-8 mb-1 pt-2 px-3 rounded-3xl bg-blue-500 max-w-sm w-full flex flex-col items-center justify-center">
            <div aria-label="header" className="flex items-center space-x-2 ">
              <div className="inline-flex items-center shrink-0 justify-center w-10 h-10 rounded-full text-white bg-white focus:outline-none">
                <GetTypeIcon type={currentStep.step.Type} />
              </div>

              <div className="flex-1">
                <h3 className="font-bold text-2xl text-blue-950 leading-tight">
                  {currentStep.step.Instruction}
                </h3>
                <p className="text-sm font-normal text-blue-950 leading-none">
                  {stepName()}
                </p>
                <p className="text-sm font-normal leading-none">
                  <span className="font-bold">{meterOrKm(kmTotalLeft)}</span>{" "}
                  remaining
                </p>
                <p className="text-sm font-normal leading-none">
                  Estimated arrival time:{" "}
                  <span className="font-bold">{arrivalTime}</span>
                </p>
              </div>
            </div>

            <div aria-label="content" className="mt-1 grid gap-2.5 -mb-1">
              <div href="#">
                <div className="flex items-center space-x-3 p-2 rounded-full bg-gradient-to-r from-blue-900 to-purple-900">
                  <span className="flex items-center justify-center w-10 h-10 shrink-0 rounded-full bg-white text-white">
                    <GetTypeIcon type={currentStep.stepType + 15} />
                  </span>
                  <div className="flex flex-col flex-1">
                    <div className="font-medium text-white text-2xl">
                      <FontAwesomeIcon icon={faClock} />{" "}
                      {currentStep.step.Duration
                        ? secondsOrHour(currentStep.step.Duration)
                        : "0 min"}
                    </div>
                    <div className="divide-x divide-gray-200 mt-auto">
                      <span className="inline-block px-3 leading-none text-white font-normal first:pl-0">
                        <FontAwesomeIcon icon={faRoad} />{" "}
                        {currentStep.step.Distance
                          ? meterOrKm(currentStep.step.Distance)
                          : "0 m"}
                      </span>
                      <span className="inline-block px-3 leading-none text-white font-normal first:pl-0">
                        <FontAwesomeIcon icon={faClock} />{" "}
                        {calculSecondsFromNow(currentStep.step.Duration)}
                      </span>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div className="mt-auto mb-2">
            <div className="flex space-x-4">
              <button
                onClick={() => updateStep(-1)}
                className={`text-white py-2 px-4 rounded-full transition duration-300 ${
                  isPreviousDisabled()
                    ? "bg-gray-500 cursor-not-allowed"
                    : "bg-blue-500 hover:bg-gradient-to-r hover:from-purple-800 hover:to-blue-500 "
                }`}
                disabled={isPreviousDisabled()}
              >
                <FontAwesomeIcon
                  size="lg"
                  icon={faArrowLeft}
                  className="mr-2"
                />
                Previous
              </button>
              <button
                onClick={() => updateStep(1)}
                className={`text-white py-2 px-4 rounded-full transition duration-300 ${
                  isNextDisabled()
                    ? "bg-gray-500 cursor-not-allowed"
                    : "bg-blue-500 hover:bg-gradient-to-r hover:from-blue-500 hover:to-purple-800 "
                }`}
                disabled={isNextDisabled()}
              >
                Next
                <FontAwesomeIcon
                  size="lg"
                  icon={faArrowRight}
                  className="ml-3"
                />
              </button>
            </div>
          </div>
        </>
      )}
    </div>
  );
}
