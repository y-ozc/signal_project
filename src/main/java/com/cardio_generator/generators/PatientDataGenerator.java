package com.cardio_generator.generators;

import com.cardio_generator.outputs.OutputStrategy;

/**
 * An interface used for classes that generate data.
 */
public interface PatientDataGenerator {

    /**
     * Abstract method for generating data
     * @param patientId used to keep track of which datapoint belongs to which patient
     * @param outputStrategy used to handle the output of generated data. This will depend on the implemetation.
     */
    void generate(int patientId, OutputStrategy outputStrategy);
}
