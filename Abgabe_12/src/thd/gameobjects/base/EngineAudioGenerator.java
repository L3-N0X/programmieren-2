package thd.gameobjects.base;

import javax.sound.sampled.*;
import java.util.Arrays;

/**
 * Simple engine sound generator for the Car class. Generates basic engine sounds based on car speed. No threads - audio
 * is generated on-demand when update() is called.
 */
public class EngineAudioGenerator {
    private static final int SAMPLE_RATE = 22050;
    private static final int BUFFER_SIZE = 1024;

    // Volume constants
    private static final float MAX_VOLUME = 0.05f;
    private static final float IDLE_VOLUME = 0.015f;
    private static final float VOLUME_RANGE = MAX_VOLUME - IDLE_VOLUME;

    // Frequency constants
    private static final float IDLE_FREQUENCY = 40.0f;
    private static final float MAX_FREQUENCY = 130.0f;
    private static final float FREQUENCY_RANGE = MAX_FREQUENCY - IDLE_FREQUENCY;

    // Engine roughness
    private static final float ROUGHNESS_AMOUNT = 0.04f;
    private static final float GRASS_ROUGHNESS_AMOUNT = 0.4f;

    private SourceDataLine audioLine;
    private boolean isInitialized;

    // Sound parameters
    private float engineFrequency;
    private float volume;
    private boolean engineOn;
    private boolean isOnGrass;

    // Wave generation
    private float phase;
    private byte[] audioBuffer;

    /**
     * Creates a new EngineAudioGenerator instance.
     *
     * @throws LineUnavailableException if the audio line cannot be opened
     */
    public EngineAudioGenerator() throws LineUnavailableException {
        isInitialized = false;
        engineOn = false;
        isOnGrass = false;
        engineFrequency = IDLE_FREQUENCY;
        volume = IDLE_VOLUME;
        phase = 0.0f;
        audioBuffer = new byte[BUFFER_SIZE];

        setupAudio();
        isInitialized = true;
    }

    private void setupAudio() throws LineUnavailableException {
        AudioFormat format = new AudioFormat(SAMPLE_RATE, 16, 1, true, false);
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
        audioLine = (SourceDataLine) AudioSystem.getLine(info);
        audioLine.open(format, BUFFER_SIZE * 4);
    }

    /**
     * Start the audio line (call this once when starting the game).
     */
    public void start() {
        if (!isInitialized) {
            return;
        }

        engineOn = true;
        audioLine.start();
    }

    /**
     * Stop the audio line (call this when shutting down).
     */
    private void stop() {
        engineOn = false;

        if (audioLine != null) {
            audioLine.stop();
            audioLine.close();
        }
    }

    /**
     * Update the audio buffer and write it to the audio line.
     */
    public void update() {
        if (!isInitialized || !engineOn) {
            return;
        }

        // Only generate new audio if the buffer is getting low
        if (audioLine.available() >= BUFFER_SIZE) {
            if (volume > 0.0f) {
                fillBuffer(audioBuffer);
            } else {
                Arrays.fill(audioBuffer, (byte) 0);
            }
            audioLine.write(audioBuffer, 0, audioBuffer.length);
        }
    }

    /**
     * Update engine sound based on car speed.
     *
     * @param carSpeed  Current speed of the car
     * @param maxSpeed  Maximum speed of the car
     * @param isOnGrass Whether the car is on grass
     */
    public void updateSpeed(double carSpeed, double maxSpeed, boolean isOnGrass) {
        if (!engineOn) {
            return;
        }

        // Convert speed to throttle position (0.0 to 1.0)
        float throttle = (float) Math.max(0.0, Math.min(1.0, carSpeed / maxSpeed));

        // Engine frequency: IDLE_FREQUENCY to MAX_FREQUENCY based on throttle
        engineFrequency = IDLE_FREQUENCY + (throttle * FREQUENCY_RANGE);

        volume = IDLE_VOLUME + (throttle * VOLUME_RANGE);

        this.isOnGrass = isOnGrass;
    }

    /**
     * Turn engine on/off.
     *
     * @param on true to turn the engine on, false to turn it off
     */
    public void turnEngineOn(boolean on) {
        engineOn = on;
        if (!on) {
            volume = 0.0f;
        } else {
            volume = IDLE_VOLUME;
        }
    }

    private void fillBuffer(byte[] buffer) {
        int samples = buffer.length / 2; // 16-bit = 2 bytes per sample

        for (int i = 0; i < samples; i++) {
            // Combination of sine and square wave for engine-like sound
            float sample;
            if (!isOnGrass) {
                sample = (float) (Math.sin(phase) + Math.signum(Math.sin(phase)));
            } else {
                sample = (float) Math.signum(Math.sin(phase));
            }

            // Add engine roughness
            float roughnessAmount = isOnGrass ? GRASS_ROUGHNESS_AMOUNT : ROUGHNESS_AMOUNT;
            sample += (float) (Math.random() - 0.5) * roughnessAmount;

            // Apply volume
            sample *= volume;

            // Convert to 16-bit
            short value = (short) (sample * Short.MAX_VALUE);

            // Write to buffer (little endian)
            buffer[i * 2] = (byte) (value & 0xFF);
            buffer[i * 2 + 1] = (byte) ((value >> 8) & 0xFF);

            // Update phase
            phase += (float) ((engineFrequency * 2.0f * Math.PI) / SAMPLE_RATE);
            if (phase > 2.0f * Math.PI) {
                phase -= (float) (2.0f * Math.PI);
            }
        }
    }
}
