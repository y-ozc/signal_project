package com.cardio_generator.outputs;

/**
 * An interface that provides an abstraction for the output of data
 */
public interface OutputStrategy {

    /**
     * 
     * @param patientId used to keep track of which datapoint belongs to which patient
     * @param timestamp used to keep track where the simulation is in time
     * @param label used to record what type of data is being outputted from the simulation
     * @param data a string representation of the outputted data
     */
    void output(int patientId, long timestamp, String label, String data);
}
