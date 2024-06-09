package com.cardio_generator.generators;

import java.util.Random;

import com.cardio_generator.outputs.OutputStrategy;

/**
 * This class implemets the PatientDataGenerator interface to generate plausable medcial alert data of a patient.
 */
public class AlertGenerator implements PatientDataGenerator {

    /**
     * A constant that holds the random seed.
     */
    // Renamed constant to UPPER_SNAKECASE and renamed variable to lowerCamelCase
    public static final Random RANDOM_GENERATOR = new Random();
    private boolean[] slertStates; // false = resolved, true = pressed

    /**
     * Constructs AlertGenerator and initialises a boolean array for the patients alerts.
     * @param patientCount the number of patients in the simulation that need to be inilialised.
     */
    public AlertGenerator(int patientCount) {
        slertStates = new boolean[patientCount + 1];
    }

    @Override
    public void generate(int patientId, OutputStrategy outputStrategy) {
        try {
            if (slertStates[patientId]) {
                if (RANDOM_GENERATOR.nextDouble() < 0.9) { // 90% chance to resolve
                    slertStates[patientId] = false;
                    // Output the alert
                    outputStrategy.output(patientId, System.currentTimeMillis(), "Alert", "resolved");
                }
            } else {
                double Lambda = 0.1; // Average rate (alerts per period), adjust based on desired frequency
                double p = -Math.expm1(-Lambda); // Probability of at least one alert in the period
                boolean alertTriggered = RANDOM_GENERATOR.nextDouble() < p;

                if (alertTriggered) {
                    slertStates[patientId] = true;
                    // Output the alert
                    outputStrategy.output(patientId, System.currentTimeMillis(), "Alert", "triggered");
                }
            }
        } catch (Exception e) {
            System.err.println("An error occurred while generating alert data for patient " + patientId);
            e.printStackTrace();
        }
    }
}
